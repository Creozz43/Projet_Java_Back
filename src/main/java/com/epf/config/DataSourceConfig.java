package com.epf.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// Remplacez l’ancien import ou ajoutez celui-ci :
import jakarta.annotation.PostConstruct;

@Configuration
public class DataSourceConfig {

    private DriverManagerDataSource ds;

    @Bean
    public DataSource dataSource() {
        ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/pvz?useSSL=false&serverTimezone=UTC");
        ds.setUsername("epf");
        ds.setPassword("votre_mot_de_passe");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @PostConstruct
    public void checkConnection() {
        try (Connection conn = ds.getConnection()) {
            System.out.println("✅ Connected to DB: " + conn.getMetaData().getURL());
        } catch (SQLException e) {
            throw new RuntimeException("❌ DB connection failed", e);
        }
    }
}
