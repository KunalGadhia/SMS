/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.extracurricularactivity;

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
public class ExtraCurricularActivityDAL {

    public static final class Columns {

        public static final String ID = "id";
        public static final String STUDENT_ID = "student_id";
        public static final String FIELD_OF_INTEREST = "field_of_interest";
        public static final String DESCRIPTION = "description";
        public static final String CERTIFICATION = "certification";

    }

    public static final String TABLE_NAME = "extra_curricular_activity";

    private final SimpleJdbcInsert insertExtraCurricularActivity;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ExtraCurricularActivityDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertExtraCurricularActivity = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.STUDENT_ID,
                        Columns.FIELD_OF_INTEREST,
                        Columns.DESCRIPTION,
                        Columns.CERTIFICATION
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<ExtraCurricularActivity> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(ExtraCurricularActivity.class));
    }

    public ExtraCurricularActivity findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(ExtraCurricularActivity.class));
    }

    public ExtraCurricularActivity insert(ExtraCurricularActivity extraCurricularActivity) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Columns.STUDENT_ID, extraCurricularActivity.getStudentId());
        parameters.put(Columns.FIELD_OF_INTEREST, extraCurricularActivity.getFieldOfInterest());
        parameters.put(Columns.DESCRIPTION, extraCurricularActivity.getDescription());
        parameters.put(Columns.CERTIFICATION, extraCurricularActivity.getCertification());
        Number newId = insertExtraCurricularActivity.executeAndReturnKey(parameters);
        extraCurricularActivity = findById(newId.intValue());
        return extraCurricularActivity;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public ExtraCurricularActivity update(ExtraCurricularActivity extraCurricularActivity) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.STUDENT_ID + " = ?,"
                + Columns.FIELD_OF_INTEREST + " = ?,"
                + Columns.DESCRIPTION + " = ?,"
                + Columns.CERTIFICATION + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    extraCurricularActivity.getStudentId(),
                    extraCurricularActivity.getFieldOfInterest(),
                    extraCurricularActivity.getDescription(),
                    extraCurricularActivity.getCertification(),
                    extraCurricularActivity.getId()
                });
        extraCurricularActivity = findById(extraCurricularActivity.getId());
        return extraCurricularActivity;
    }
}
