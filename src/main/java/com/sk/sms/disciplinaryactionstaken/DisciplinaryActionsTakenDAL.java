/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.disciplinaryactionstaken;

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
public class DisciplinaryActionsTakenDAL {

    public static final class Columns {

        public static final String ID = "id";
        public static final String STUDENT_ID = "student_id";
        public static final String SEVERITY = "severity";
        public static final String DESCRIPTION = "description";
        public static final String ACTION_TAKEN = "action_taken";

    }

    public static final String TABLE_NAME = "disciplinary_actions_taken";

    private final SimpleJdbcInsert insertDisciplinaryActionsTaken;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DisciplinaryActionsTakenDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertDisciplinaryActionsTaken = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.STUDENT_ID,
                        Columns.SEVERITY,
                        Columns.DESCRIPTION,
                        Columns.ACTION_TAKEN
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<DisciplinaryActionsTaken> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(DisciplinaryActionsTaken.class));
    }

    public DisciplinaryActionsTaken findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(DisciplinaryActionsTaken.class));
    }

    public DisciplinaryActionsTaken insert(DisciplinaryActionsTaken disciplinaryActionsTaken) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Columns.STUDENT_ID, disciplinaryActionsTaken.getStudentId());
        parameters.put(Columns.SEVERITY, disciplinaryActionsTaken.getSeverity().name());
        parameters.put(Columns.DESCRIPTION, disciplinaryActionsTaken.getDescription());
        parameters.put(Columns.ACTION_TAKEN, disciplinaryActionsTaken.getActionTaken());
        Number newId = insertDisciplinaryActionsTaken.executeAndReturnKey(parameters);
        disciplinaryActionsTaken = findById(newId.intValue());
        return disciplinaryActionsTaken;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public DisciplinaryActionsTaken update(DisciplinaryActionsTaken disciplinaryActionsTaken) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.STUDENT_ID + " = ?,"
                + Columns.SEVERITY + " = ?,"
                + Columns.DESCRIPTION + " = ?,"
                + Columns.ACTION_TAKEN + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    disciplinaryActionsTaken.getStudentId(),
                    disciplinaryActionsTaken.getSeverity().name(),
                    disciplinaryActionsTaken.getDescription(),
                    disciplinaryActionsTaken.getActionTaken(),
                    disciplinaryActionsTaken.getId()
                });
        disciplinaryActionsTaken = findById(disciplinaryActionsTaken.getId());
        return disciplinaryActionsTaken;
    }
}
