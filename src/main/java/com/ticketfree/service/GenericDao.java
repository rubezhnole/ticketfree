package com.ticketfree.service;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<E> {

    Serializable save(E entity);

    void update(E entity);

    void delete(E entity );

    List<E> findAll();

    List<E> findAllByExample(E entity );

    E findById(Serializable id );

    void clear();

    void flush();
}
