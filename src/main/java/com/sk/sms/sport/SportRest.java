/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.sport;

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
@RequestMapping("/sport")
public class SportRest {

    @Autowired
    private SportDAL sportDAL;

    @RequestMapping(method = RequestMethod.GET)
    public List<Sport> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return sportDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Sport findById(@PathVariable("id") Integer id) throws SQLException {
        return sportDAL.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Sport insert(@RequestBody Sport sport) throws JsonProcessingException, ParseException {
        return sportDAL.insert(sport);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Sport update(@RequestBody Sport sport) throws Exception {
        return sportDAL.update(sport);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        sportDAL.delete(id);
    }
}
