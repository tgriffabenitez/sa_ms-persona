package com.sistemasactivos.mspersona.controller;

import com.sistemasactivos.mspersona.model.Base;
import com.sistemasactivos.mspersona.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseControllerImpl <E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {
    @Autowired
    protected S service;

    @GetMapping("/personas")
    public ResponseEntity<?> getAll() {
        try {
            List<E> entity = service.findAll();
            if (entity.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(entity, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            if (id == null || id <= 0)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            E entity = service.findById(id);
            if (entity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(entity, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/personas")
    public ResponseEntity<?> save(@RequestBody E entity) {
        try {
            if (entity == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            E entityDB = service.save(entity);
            return new ResponseEntity<>(entityDB, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/persona/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity) {
        try {
            if (id == null || id <= 0)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            if (service.findById(id) == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            E updatedEntity = service.update(id, entity);
            if (updatedEntity == null)
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            if (id == null || id <= 0)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            if (service.findById(id) == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            boolean deleted = service.delete(id);
            if (deleted)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            else
                return new ResponseEntity<>(HttpStatus.CONFLICT);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
