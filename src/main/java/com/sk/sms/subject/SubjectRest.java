/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.subject;

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
@RequestMapping("/subject")
public class SubjectRest {

    @Autowired
    private SubjectDAL subjectDAL;

    @RequestMapping(method = RequestMethod.GET)
    public List<Subject> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return subjectDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Subject findById(@PathVariable("id") Integer id) throws SQLException {
        return subjectDAL.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Subject insert(@RequestBody Subject subject) throws JsonProcessingException, ParseException {
        return subjectDAL.insert(subject);
    }

    @RequestMapping(value = "/find/name_like", method = RequestMethod.GET)
    public List<Subject> findByNameLike(@RequestParam("name") String name) {
        return subjectDAL.findByNameLike(name);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Subject update(@RequestBody Subject subject) throws Exception {
        return subjectDAL.update(subject);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        subjectDAL.delete(id);
    }

}
