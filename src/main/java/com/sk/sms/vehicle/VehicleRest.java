/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.vehicle;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.SQLException;
import java.util.List;
import oracle.jrockit.jfr.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleRest {

    @Autowired
    private VehicleDAL vehicleDAL;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return vehicleDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Vehicle findById(@PathVariable("id") Integer id) throws SQLException {
        return vehicleDAL.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Vehicle insert(@RequestBody Vehicle vehicle) throws JsonProcessingException, ParseException {
        return vehicleDAL.insert(vehicle);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Vehicle update(@RequestBody Vehicle vehicle) throws Exception {
        return vehicleDAL.update(vehicle);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        vehicleDAL.delete(id);
    }
}