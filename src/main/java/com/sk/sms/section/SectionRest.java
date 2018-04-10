/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.section;

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
 * @author section
 */
@RestController
@RequestMapping("/section")
public class SectionRest {

    @Autowired
    private SectionDAL sectionDAL;

    @RequestMapping(method = RequestMethod.GET)
    public List<Section> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return sectionDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Section findById(@PathVariable("id") Integer id) throws SQLException {
        return sectionDAL.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Section insert(@RequestBody Section section) throws JsonProcessingException, ParseException {
        return sectionDAL.insert(section);
    }
    
     @RequestMapping(value = "/find/section_like", method = RequestMethod.GET)
    public List<Section> findByNameLike(@RequestParam("section") String section) {
        return sectionDAL.findByNameLike(section);
    } 

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Section update(@RequestBody Section section) throws Exception {
        return sectionDAL.update(section);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        sectionDAL.delete(id);
    }
}
