package com.example.demo.config.controller;

import com.example.demo.config.mapper.Snack;
import com.example.demo.config.mapper.SnackRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/testdb")
    public String testDB() {
        jdbcTemplate.execute("CREATE TABLE box (id INT NOT NULL)");
        jdbcTemplate.execute("INSERT INTO box VALUES (1)");
        jdbcTemplate.execute("INSERT INTO box VALUES (2)");
        int value = jdbcTemplate.queryForObject("SELECT MIN(id) FROM box", Integer.class);
        return String.valueOf(value);
    }
    @GetMapping("/testdata")
    public String testData() {
        return jdbcTemplate.queryForObject("SELECT snacknaam FROM Snack WHERE snacknr = 1", String.class);
    }

    @GetMapping("/blabla")
    public List<Snack> blabla() { //kijk of dit return type correct
        List<Snack> snacks = jdbcTemplate.query("SELECT * FROM Snack", new SnackRowMapper());
//        snacks = jdbcTemplate.query("SELECT * FROM Snack WHERE snacknr < ? OR snacknr > ?", new SnackRowMapper(), Integer.valueOf(3), Integer.valueOf(4));
//        Snack s = jdbcTemplate.queryForObject("SELECT * FROM Snack WHERE snacknr = ?", new SnackRowMapper(), Integer.valueOf(2));
        return snacks;
    }
}
