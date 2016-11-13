package com.ticketfree.service.jdbc;

import java.util.List;

public interface JDBCTemplate {
    
    List<Integer> findEventByText(String text);
}
