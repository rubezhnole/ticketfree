package com.ticketfree.util;

import com.ticketfree.entity.bean.User;
import com.ticketfree.service.dao.BaseDao;
import org.springframework.security.core.context.SecurityContextHolder;

public class SessionUtil {

    public static User getUser(BaseDao baseDao) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return baseDao.findUserByName(username);
    }
}
