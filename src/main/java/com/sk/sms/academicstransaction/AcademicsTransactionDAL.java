/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.academicstransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class AcademicsTransactionDAL {

    public static final class Columns {

        public static final String ID = "id";
        public static final String STUDENT_ID = "student_id";
        public static final String SUBJECT_ID = "subject_id";
        public static final String UNIT_TEST_1 = "unit_test_1";
        public static final String UNIT_TEST_2 = "unit_test_2";
        public static final String MID_TERM = "mid_term";
        public static final String UNIT_TEST_3 = "unit_test_3";
        public static final String UNIT_TEST_4 = "unit_test_4";
        public static final String FINAL_TERM = "final_term";

    }

    public static final String TABLE_NAME = "academics_transaction";

    private final SimpleJdbcInsert insertAcademicsTransaction;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AcademicsTransactionDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertAcademicsTransaction = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.STUDENT_ID,
                        Columns.SUBJECT_ID,
                        Columns.UNIT_TEST_1,
                        Columns.UNIT_TEST_2,
                        Columns.MID_TERM,
                        Columns.UNIT_TEST_3,
                        Columns.UNIT_TEST_4,
                        Columns.FINAL_TERM
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<AcademicsTransaction> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(AcademicsTransaction.class));
    }

    public AcademicsTransaction findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(AcademicsTransaction.class));
    }

    public AcademicsTransaction insert(AcademicsTransaction academicsTransaction) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Columns.STUDENT_ID, academicsTransaction.getStudentId());
        parameters.put(Columns.SUBJECT_ID, academicsTransaction.getSubjectId());
        parameters.put(Columns.UNIT_TEST_1, academicsTransaction.getUnitTest1());
        parameters.put(Columns.UNIT_TEST_2, academicsTransaction.getUnitTest2());
        parameters.put(Columns.MID_TERM, academicsTransaction.getMidTerm());
        parameters.put(Columns.UNIT_TEST_3, academicsTransaction.getMidTerm());
        parameters.put(Columns.UNIT_TEST_4, academicsTransaction.getUnitTest4());
        parameters.put(Columns.FINAL_TERM, academicsTransaction.getFinalTerm());
        Number newId = insertAcademicsTransaction.executeAndReturnKey(parameters);
        academicsTransaction = findById(newId.intValue());
        return academicsTransaction;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public AcademicsTransaction update(AcademicsTransaction academicsTransaction) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.STUDENT_ID + " = ?,"
                + Columns.SUBJECT_ID + " = ?,"
                + Columns.UNIT_TEST_1 + " = ?,"
                + Columns.UNIT_TEST_2 + " = ?,"
                + Columns.MID_TERM + " = ?,"
                + Columns.UNIT_TEST_3 + " = ?,"
                + Columns.UNIT_TEST_4 + " = ?,"
                + Columns.FINAL_TERM + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    academicsTransaction.getStudentId(),
                    academicsTransaction.getSubjectId(),
                    academicsTransaction.getUnitTest1(),
                    academicsTransaction.getUnitTest2(),
                    academicsTransaction.getMidTerm(),
                    academicsTransaction.getUnitTest3(),
                    academicsTransaction.getUnitTest4(),
                    academicsTransaction.getFinalTerm(),
                    academicsTransaction.getId()
                });
        academicsTransaction = findById(academicsTransaction.getId());
        return academicsTransaction;
    }
}
