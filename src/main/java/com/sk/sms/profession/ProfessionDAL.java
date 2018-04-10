/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.profession;

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
public class ProfessionDAL {

    public static final class Columns {

        public static final String ID = "id";
        public static final String PROFESSION_NAME = "profession_name";
        public static final String BELONG_TO = "belong_to";

    }

    public static final String TABLE_NAME = "profession";

    private final SimpleJdbcInsert insertProfession;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProfessionDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertProfession = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.PROFESSION_NAME,
                        Columns.BELONG_TO
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<Profession> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(Profession.class));
    }

    public Profession findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Profession.class));
    }

    public Profession insert(Profession profession) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Columns.PROFESSION_NAME, profession.getProfessionName());
        parameters.put(Columns.BELONG_TO, profession.getBelongTo());
        Number newId = insertProfession.executeAndReturnKey(parameters);
        profession = findById(newId.intValue());
        return profession;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public Profession update(Profession profession) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.PROFESSION_NAME + " = ?,"
                + Columns.BELONG_TO + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    profession.getProfessionName(),
                    profession.getBelongTo(),
                    profession.getId()
                });
        profession = findById(profession.getId());
        return profession;
    }

}
