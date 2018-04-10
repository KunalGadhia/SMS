/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.caste;

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
public class CasteDAL {

    public static final class Columns {

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";

    }

    public static final String TABLE_NAME = "caste";

    private final SimpleJdbcInsert insertCaste;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CasteDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertCaste = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.NAME,
                        Columns.DESCRIPTION
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<Caste> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(Caste.class));
    }

    public Caste findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Caste.class));
    }

    public Caste insert(Caste caste) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Columns.NAME, caste.getName());
        parameters.put(Columns.DESCRIPTION, caste.getDescription());
        Number newId = insertCaste.executeAndReturnKey(parameters);
        caste = findById(newId.intValue());
        return caste;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public Caste update(Caste caste) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.NAME + " = ?,"
                + Columns.DESCRIPTION + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    caste.getName(),
                    caste.getDescription(),
                    caste.getId()
                });
        caste = findById(caste.getId());
        return caste;
    }
}
