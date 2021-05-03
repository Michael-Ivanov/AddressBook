package com.miv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DBConnectionTests {

    @Autowired
    private DataSource dataSource;

    @Test
    public void shouldConnectToDb() throws SQLException {
        assertNotNull(dataSource.getConnection());

    }


}
