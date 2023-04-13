package com.sistemasactivos.mspersona.repository;

import com.sistemasactivos.mspersona.model.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    Persona findByCuit(String cuit);
}
