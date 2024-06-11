package org.example.recursos;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private HikariDataSource createDataSource() {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:mysql://localhost:3306/byte_bank");
        config.setUsername("root");
        config.setPassword("Aaaadsd][/123");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }

    public Connection recuperaConexao(){

        try {
            return createDataSource().getConnection();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
