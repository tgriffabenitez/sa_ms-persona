package com.sistemasactivos.mspersona.service;

import com.sistemasactivos.mspersona.model.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface BaseService <E extends Base, ID extends Serializable> {
    Page<E> findAll(Pageable pageable) throws Exception;
    E findById(ID id) throws Exception;
    E save(E entity) throws Exception;
    E update(ID id, E entity) throws Exception;
    boolean delete(ID id) throws Exception;
}
