/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.student;

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
public class StudentDAL {

    public static final class Columns {

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String STUDENT_IDCARD_NUMBER = "student_idcard_number";
        public static final String GENDER = "gender";
        public static final String STD_CODE = "std_code";
        public static final String LANDLINE_NUMBER = "landline_number";
        public static final String MOBILE_NUMBER = "mobile_number";
        public static final String EMAIL = "email";
        public static final String DATE_OF_BIRTH = "date_of_birth";
        public static final String CLASS_ID = "class_id";
        public static final String PERMANENT_ADDRESS = "permanent_address";
        public static final String CURRENT_ADDRESS = "current_address";
        public static final String LIVING_WITH = "living_with";
        public static final String CASTE_ID = "caste_id";
        public static final String MOTHER_TONGUE = "mother_tongue";
        public static final String RELIGION = "religion";
        public static final String PHOTO_PATH = "photo_path";
        public static final String ATTACHMENTS = "attachments";

    }

    public static final String TABLE_NAME = "student";

    private final SimpleJdbcInsert insertStudent;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertStudent = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.NAME,
                        Columns.STUDENT_IDCARD_NUMBER,
                        Columns.GENDER,
                        Columns.STD_CODE,
                        Columns.LANDLINE_NUMBER,
                        Columns.MOBILE_NUMBER,
                        Columns.EMAIL,
                        Columns.DATE_OF_BIRTH,
                        Columns.CLASS_ID,
                        Columns.PERMANENT_ADDRESS,
                        Columns.CURRENT_ADDRESS,
                        Columns.LIVING_WITH,
                        Columns.CLASS_ID,
                        Columns.MOTHER_TONGUE,
                        Columns.RELIGION,
                        Columns.PHOTO_PATH,
                        Columns.ATTACHMENTS
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<Student> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(Student.class));
    }

    public Student findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
    }

    public Student insert(Student student) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Columns.NAME, student.getName());
        parameters.put(Columns.STUDENT_IDCARD_NUMBER, student.getStudentIdcardNumber());
        parameters.put(Columns.GENDER, student.getGender().name());
        parameters.put(Columns.STD_CODE, student.getStdCode());
        parameters.put(Columns.LANDLINE_NUMBER, student.getLandlineNumber());
        parameters.put(Columns.MOBILE_NUMBER, student.getMobileNumber());
        parameters.put(Columns.EMAIL, student.getEmail());
        parameters.put(Columns.DATE_OF_BIRTH, student.getDateOfBirth());
        parameters.put(Columns.CLASS_ID, student.getClassId());
        parameters.put(Columns.PERMANENT_ADDRESS, student.getPermanentAddress());
        parameters.put(Columns.CURRENT_ADDRESS, student.getCurrentAddress());
        parameters.put(Columns.LIVING_WITH, student.getLivingWith().name());
        parameters.put(Columns.CASTE_ID, student.getCasteId());
        parameters.put(Columns.MOTHER_TONGUE, student.getMotherTongue().name());
        parameters.put(Columns.RELIGION, student.getReligion().name());
        parameters.put(Columns.PHOTO_PATH, student.getPhotoPath());
        parameters.put(Columns.ATTACHMENTS, student.getAttachments());
        Number newId = insertStudent.executeAndReturnKey(parameters);
        student = findById(newId.intValue());
        return student;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public Student update(Student student) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.NAME + " = ?,"
                + Columns.STUDENT_IDCARD_NUMBER + " = ?,"
                + Columns.GENDER + " = ?,"
                + Columns.STD_CODE + " = ?,"
                + Columns.LANDLINE_NUMBER + " = ?,"
                + Columns.MOBILE_NUMBER + " = ?,"
                + Columns.EMAIL + " = ?,"
                + Columns.DATE_OF_BIRTH + " = ?,"
                + Columns.CLASS_ID + " = ?,"
                + Columns.PERMANENT_ADDRESS + " = ?,"
                + Columns.CURRENT_ADDRESS + " = ?,"
                + Columns.LIVING_WITH + " = ?,"
                + Columns.CASTE_ID + " = ?,"
                + Columns.MOTHER_TONGUE + " = ?,"
                + Columns.RELIGION + " = ?,"
                + Columns.PHOTO_PATH + " = ?,"
                + Columns.ATTACHMENTS + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    student.getName(),
                    student.getStudentIdcardNumber(),
                    student.getGender().name(),
                    student.getStdCode(),
                    student.getLandlineNumber(),
                    student.getMobileNumber(),
                    student.getEmail(),
                    student.getDateOfBirth(),
                    student.getClassId(),
                    student.getPermanentAddress(),
                    student.getCurrentAddress(),
                    student.getLivingWith().name(),
                    student.getCasteId(),
                    student.getMotherTongue().name(),
                    student.getReligion().name(),
                    student.getPhotoPath(),
                    student.getAttachments(),
                    student.getId()
                });
        student = findById(student.getId());
        return student;
    }
}
