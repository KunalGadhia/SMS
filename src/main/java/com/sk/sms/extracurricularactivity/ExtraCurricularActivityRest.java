/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.extracurricularactivity;

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
@RequestMapping("/extra_curricular_activity")
public class ExtraCurricularActivityRest {

    @Autowired
    private ExtraCurricularActivityDAL extraCurricularActivityDAL;

    @RequestMapping(method = RequestMethod.GET)
    public List<ExtraCurricularActivity> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return extraCurricularActivityDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ExtraCurricularActivity findById(@PathVariable("id") Integer id) throws SQLException {
        return extraCurricularActivityDAL.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ExtraCurricularActivity insert(@RequestBody ExtraCurricularActivity extraCurricularActivity) throws JsonProcessingException, ParseException {
        return extraCurricularActivityDAL.insert(extraCurricularActivity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ExtraCurricularActivity update(@RequestBody ExtraCurricularActivity extraCurricularActivity) throws Exception {
        return extraCurricularActivityDAL.update(extraCurricularActivity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        extraCurricularActivityDAL.delete(id);
    }
}
