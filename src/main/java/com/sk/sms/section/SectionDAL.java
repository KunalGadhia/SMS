/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.section;

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
public class SectionDAL {

    public static final class Columns {

        public static final String ID = "id";
        public static final String SECTION = "section";

    }

    public static final String TABLE_NAME = "section";

    private final SimpleJdbcInsert insertSection;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SectionDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertSection = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.SECTION
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<Section> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(Section.class));
    }

    public Section findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Section.class));
    }

    public Section insert(Section section) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Columns.SECTION, section.getSection());
        Number newId = insertSection.executeAndReturnKey(parameters);
        section = findById(newId.intValue());
        return section;
    }

    public List<Section> findByNameLike(String section) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND lower(section) LIKE?";
        String sectionNameLike = "%" + section.toLowerCase() + "%";
        return jdbcTemplate.query(sqlQuery, new Object[]{sectionNameLike}, new BeanPropertyRowMapper<>(Section.class));
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public Section update(Section section) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.SECTION + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    section.getSection(),
                    section.getId()
                });
        section = findById(section.getId());
        return section;
    }
}