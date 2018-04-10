/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class VehicleDAL {

    public static final class Columns {

        public static final String ID = "id";
        public static final String VEHICLE_MODEL = "vehicle_model";
        public static final String MAKE = "make";

    }

    public static final String TABLE_NAME = "vehicle";

    private final SimpleJdbcInsert insertVehicle;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VehicleDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertVehicle = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.VEHICLE_MODEL,
                        Columns.MAKE
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<Vehicle> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(Vehicle.class));
    }

    public Vehicle findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Vehicle.class));
    }

    public Vehicle insert(Vehicle vehicle) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Columns.VEHICLE_MODEL, vehicle.getVehicleModel());
        parameters.put(Columns.MAKE, vehicle.getMake());
        Number newId = insertVehicle.executeAndReturnKey(parameters);
        vehicle = findById(newId.intValue());
        return vehicle;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public Vehicle update(Vehicle vehicle) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.VEHICLE_MODEL + " = ?,"
                + Columns.MAKE + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    vehicle.getVehicleModel(),
                    vehicle.getMake(),
                    vehicle.getId()
                });
        vehicle = findById(vehicle.getId());
        return vehicle;
    }
}
