package com.ticketfree.service.dao;

import com.ticketfree.entity.baseentity.HistoryEntity;
import com.ticketfree.entity.bean.Ticket;
import com.ticketfree.entity.bean.User;

import java.util.List;
import java.util.Optional;

public interface BaseDao {

    <T> T findById(Class<T> clazz, Integer id);

    void save(HistoryEntity obj, User user);

    List<Ticket> loadTicketByEvent(Integer eventId);

    List<Ticket> loadTicketByUser(Integer userId);

    List<Ticket> loadTicketByEventAndUser(Integer eventId, Integer userId);

    Optional<Ticket> findTicketByUUID(String uuid);

    void buyTicket(Integer eventId, Integer number, User user);

    void buyTicket(Integer eventId, User user);

    User findUserByName(String username);
}
