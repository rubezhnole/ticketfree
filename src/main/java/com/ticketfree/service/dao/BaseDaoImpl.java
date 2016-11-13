package com.ticketfree.service.dao;

import com.ticketfree.entity.baseentity.HistoryEntity;
import com.ticketfree.entity.bean.Event;
import com.ticketfree.entity.bean.Ticket;
import com.ticketfree.entity.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class BaseDaoImpl implements BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public <T> T findById(Class<T> clazz, Integer id) {
        return getSession().get(clazz, id);
    }

    public void save(HistoryEntity obj, User user) {
        obj.setCreateBy(user);
        obj.setEditBy(user);
        obj.setCreateDate(new Date());
        obj.setEditDate(new Date());
        getSession().saveOrUpdate(obj);
    }

    @Override
    public List<Ticket> loadTicketByEvent(Integer eventId) {
        if (null == eventId) {
            return new ArrayList<>();
        }

        return getSession().createCriteria(Ticket.class)
                .add(Restrictions.eq("event.entityId", eventId))
                .list();
    }

    @Override
    public List<Ticket> loadTicketByUser(Integer userId) {
        if (null == userId) {
            return new ArrayList<>();
        }

        return getSession().createCriteria(Ticket.class)
                .add(Restrictions.eq("user.entityId", userId))
                .list();
    }

    @Override
    public List<Ticket> loadTicketByEventAndUser(Integer eventId, Integer userId) {
        if (null == eventId || null == userId) {
            return new ArrayList<>();
        }

        return getSession().createCriteria(Ticket.class)
                .add(Restrictions.eq("event.entityId", eventId))
                .add(Restrictions.eq("user.entityId", userId))
                .list();
    }

    @Override
    public Optional<Ticket> findTicketByUUID(String uuid) {
        Ticket ticket = (Ticket) getSession().createCriteria(Ticket.class)
                .add(Restrictions.eq("uuid", uuid))
                .uniqueResult();
        return Optional.ofNullable(ticket);
    }

    @Override
    public void buyTicket(Integer eventId, User user) {
        buyTicket(eventId, null , user);
    }

    @Override
    public User findUserByName(String username) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("username", username))
                .uniqueResult();
    }

    @Override
    public void buyTicket(Integer eventId, Integer number, User user) {

        if (null == number || number < 1) {
            number = 1;
        } else if (number > 50) {
            number = 50;
        }

        Event event = findById(Event.class, eventId);

        for (int i = 0; i < number; i++) {
            String uuid = eventId + "~" + UUID.randomUUID().toString();

            Ticket ticket = new Ticket();
            ticket.setEvent(event);
            ticket.setUser(user);
            ticket.setUuid(uuid);
            ticket.setActive(true);

            save(ticket, user);
        }
    }
}
