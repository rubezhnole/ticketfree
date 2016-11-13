package com.ticketfree.service.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdbcTemplateImpl implements JDBCTemplate {

    @Autowired
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    @Override
    public List<Integer> findEventByText(String text) {
        text = "%" + text + "%";
        final String sql = "SELECT entityId FROM event WHERE title LIKE ?" +
                " OR description LIKE ?";


//        List<Integer> entityId = jdbcTemplate.query(sql, ((rs, rowNum) -> {
//            return rs.getInt("entityId");
//        }));
//
//        return entityId;

        return jdbcTemplate.queryForList(sql, Integer.class, text, text);
    }
}
