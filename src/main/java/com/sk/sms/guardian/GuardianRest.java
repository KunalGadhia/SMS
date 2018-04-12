/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.guardian;

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
@RequestMapping("/guardian")
public class GuardianRest {

    @Autowired
    private GuardianDAL guardianDAL;

    @RequestMapping(method = RequestMethod.GET)
    public List<Guardian> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return guardianDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Guardian findById(@PathVariable("id") Integer id) throws SQLException {
        return guardianDAL.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Guardian insert(@RequestBody Guardian guardian) throws JsonProcessingException, ParseException {
        return guardianDAL.insert(guardian);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Guardian update(@RequestBody Guardian guardian) throws Exception {
        return guardianDAL.update(guardian);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        guardianDAL.delete(id);
    }

}
