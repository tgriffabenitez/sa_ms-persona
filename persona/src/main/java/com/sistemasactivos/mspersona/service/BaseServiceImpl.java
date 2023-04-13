package com.sistemasactivos.mspersona.service;

import com.sistemasactivos.mspersona.model.Base;
import com.sistemasactivos.mspersona.model.Persona;
import com.sistemasactivos.mspersona.repository.BaseRepository;
import com.sistemasactivos.mspersona.repository.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    @Autowired
    private PersonaRepository personaRepository;

    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public List<E> findAll() throws Exception {
        try {
            return baseRepository.findAll();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E findById(ID id) throws Exception {
        try {
            Optional<E> optional = baseRepository.findById(id);
            return optional.orElse(null);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E save(E entity) throws Exception {
        try {
            // Si la entidad es una persona, verifico que no exista otra con el mismo CUIT
            if (entity instanceof Persona persona) {
                Persona personaDB = personaRepository.findByCuit(persona.getCuit());
                if (personaDB != null) {
                    throw new DataIntegrityViolationException("Ya existe una persona con el mismo CUIT");
                }
            }
            return baseRepository.save(entity);

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            if (entityOptional.isEmpty()) {
                throw new Exception("No existe la entidad con el id: " + id);
            }

            Long entidadId = entityOptional.get().getId();
            entityOptional = Optional.of(entity);
            entityOptional.get().setId(entidadId);
            return baseRepository.save(entityOptional.get());

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            if (entityOptional.isPresent()) {
                baseRepository.delete(entityOptional.get());
                return true;
            }
            return false;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
