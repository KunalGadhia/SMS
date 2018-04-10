/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.studentclass;

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
@RequestMapping("/student_class")
public class StudentClassRest {

    @Autowired
    private StudentClassDAL studentClassDAL;

    @RequestMapping(method = RequestMethod.GET)
    public List<StudentClass> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return studentClassDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StudentClass findById(@PathVariable("id") Integer id) throws SQLException {
        return studentClassDAL.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    public StudentClass insert(@RequestBody StudentClass studentClass) throws JsonProcessingException, ParseException {
        return studentClassDAL.insert(studentClass);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public StudentClass update(@RequestBody StudentClass studentClass) throws Exception {
        return studentClassDAL.update(studentClass);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        studentClassDAL.delete(id);
    }
}
