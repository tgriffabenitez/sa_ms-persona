package com.sistemasactivos.mspersona.service;

import com.sistemasactivos.mspersona.model.Persona;
import com.sistemasactivos.mspersona.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> {
    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }
}
