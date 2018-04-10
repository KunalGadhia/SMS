/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.caste;

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
@RequestMapping("/caste")
public class CasteRest {

    @Autowired
    private CasteDAL casteDAL;

    @RequestMapping(method = RequestMethod.GET)
    public List<Caste> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return casteDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Caste findById(@PathVariable("id") Integer id) throws SQLException {
        return casteDAL.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Caste insert(@RequestBody Caste caste) throws JsonProcessingException, ParseException {
        return casteDAL.insert(caste);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Caste update(@RequestBody Caste caste) throws Exception {
        return casteDAL.update(caste);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        casteDAL.delete(id);
    }

}
