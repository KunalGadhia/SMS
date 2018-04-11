/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.studentclass;

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
public class StudentClassDAL {

    public static final class Columns {

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SECTION_ID = "section_id";
        public static final String CLASS_TYPE = "class_type";

    }

    public static final String TABLE_NAME = "student_class";

    private final SimpleJdbcInsert insertStudentClass;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentClassDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertStudentClass = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.NAME,
                        Columns.SECTION_ID,
                        Columns.CLASS_TYPE
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<StudentClass> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(StudentClass.class));
    }

    public StudentClass findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(StudentClass.class));
    }

    public StudentClass insert(StudentClass studentClass) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Columns.NAME, studentClass.getName());
        parameters.put(Columns.SECTION_ID, studentClass.getSectionId());
        parameters.put(Columns.CLASS_TYPE, studentClass.getClassType().name());
        Number newId = insertStudentClass.executeAndReturnKey(parameters);
        studentClass = findById(newId.intValue());
        return studentClass;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public StudentClass update(StudentClass studentClass) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.NAME + " = ?,"
                + Columns.SECTION_ID + " = ?, "
                + Columns.CLASS_TYPE + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    studentClass.getName(),
                    studentClass.getSectionId(),
                    studentClass.getClassType().name(),
                    studentClass.getId()
                });
        studentClass = findById(studentClass.getId());
        return studentClass;
    }
}
