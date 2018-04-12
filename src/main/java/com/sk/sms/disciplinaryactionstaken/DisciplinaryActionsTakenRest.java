/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.disciplinaryactionstaken;

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
@RequestMapping("/disciplinary_actions_taken")
public class DisciplinaryActionsTakenRest {

    @Autowired
    private DisciplinaryActionsTakenDAL disciplinaryActionsTakenDAL;

    @RequestMapping(method = RequestMethod.GET)
    public List<DisciplinaryActionsTaken> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return disciplinaryActionsTakenDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DisciplinaryActionsTaken findById(@PathVariable("id") Integer id) throws SQLException {
        return disciplinaryActionsTakenDAL.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    public DisciplinaryActionsTaken insert(@RequestBody DisciplinaryActionsTaken disciplinaryActionsTaken) throws JsonProcessingException, ParseException {
        return disciplinaryActionsTakenDAL.insert(disciplinaryActionsTaken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public DisciplinaryActionsTaken update(@RequestBody DisciplinaryActionsTaken disciplinaryActionsTaken) throws Exception {
        return disciplinaryActionsTakenDAL.update(disciplinaryActionsTaken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        disciplinaryActionsTakenDAL.delete(id);
    }

}
