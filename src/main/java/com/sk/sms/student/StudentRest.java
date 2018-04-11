/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.student;

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
@RequestMapping("/student")
public class StudentRest {

    @Autowired
    private StudentDAL studentDAL;

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return studentDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student findById(@PathVariable("id") Integer id) throws SQLException {
        return studentDAL.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Student insert(@RequestBody Student student) throws JsonProcessingException, ParseException {
        return studentDAL.insert(student);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Student update(@RequestBody Student student) throws Exception {
        return studentDAL.update(student);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        studentDAL.delete(id);
    }
}
