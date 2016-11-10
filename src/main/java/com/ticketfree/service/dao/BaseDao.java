package com.ticketfree.service.dao;

public interface BaseDao {

    <T> T findById(Class<T> clazz, Integer id);
}
