/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.guardian;

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
public class GuardianDAL {

    public static final class Columns {

        public static final String ID = "id";
        public static final String STUDENT_ID = "student_id";
        public static final String RELATION = "relation";
        public static final String NAME = "name";

    }

    public static final String TABLE_NAME = "guardian";

    private final SimpleJdbcInsert insertGuardian;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GuardianDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertGuardian = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.STUDENT_ID,
                        Columns.RELATION,
                        Columns.NAME
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<Guardian> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(Guardian.class));
    }

    public Guardian findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Guardian.class));
    }

    public Guardian insert(Guardian guardian) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Columns.STUDENT_ID, guardian.getStudentId());
        parameters.put(Columns.RELATION, guardian.getRelation().name());
        parameters.put(Columns.NAME, guardian.getName());
        Number newId = insertGuardian.executeAndReturnKey(parameters);
        guardian = findById(newId.intValue());
        return guardian;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public Guardian update(Guardian guardian) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.STUDENT_ID + " = ?,"
                + Columns.RELATION + " = ?,"
                + Columns.NAME + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    guardian.getStudentId(),
                    guardian.getRelation().name(),
                    guardian.getName(),
                    guardian.getId()
                });
        guardian = findById(guardian.getId());
        return guardian;
    }

}
