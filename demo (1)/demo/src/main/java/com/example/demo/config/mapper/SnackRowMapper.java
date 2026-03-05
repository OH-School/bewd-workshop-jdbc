package com.example.demo.config.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SnackRowMapper implements RowMapper<Snack> {
    public Snack mapRow(ResultSet rs, int rowNum) throws SQLException {
        Snack s = new Snack();
        s.snacknr = rs.getInt("snacknr");
        s.snacknaam = rs.getString("snacknaam");
        s.calorieen = rs.getInt("calorieen");
        return s;
    }
}
