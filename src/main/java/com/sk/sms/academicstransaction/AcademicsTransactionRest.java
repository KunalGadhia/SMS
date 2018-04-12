/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.academicstransaction;

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
@RequestMapping("/academics_transaction")
public class AcademicsTransactionRest {

    @Autowired
    private AcademicsTransactionDAL academicsTransactionDAL;

    @RequestMapping(method = RequestMethod.GET)
    public List<AcademicsTransaction> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return academicsTransactionDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AcademicsTransaction findById(@PathVariable("id") Integer id) throws SQLException {
        return academicsTransactionDAL.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    public AcademicsTransaction insert(@RequestBody AcademicsTransaction academicsTransaction) throws JsonProcessingException, ParseException {
        return academicsTransactionDAL.insert(academicsTransaction);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public AcademicsTransaction update(@RequestBody AcademicsTransaction academicsTransaction) throws Exception {
        return academicsTransactionDAL.update(academicsTransaction);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        academicsTransactionDAL.delete(id);
    }
}
