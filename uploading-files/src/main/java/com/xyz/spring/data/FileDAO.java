package com.xyz.spring.data;

import com.xyz.spring.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FileDAO implements FileDAOBase {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static FileEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setId(rs.getString("id"));
        fileEntity.setBody(rs.getBytes("body"));
        fileEntity.setName(rs.getString("name"));
        return fileEntity;
    }

    @Override
    public void saveFile(FileEntity fileEntity) {
        String sql =
        "INSERT INTO img (name, body) VALUES (?, ?);";

        jdbcTemplate.update(sql, fileEntity.getName(), fileEntity.getBody());
    }

    @Override
    public FileEntity findFileEntityById(String id) {
        String sql =
        "SELECT * FROM img WHERE id = '"+id.trim()+"';";
        return jdbcTemplate.queryForObject(sql, FileDAO::mapRow);
    }

    @Override
    public List<FileEntity> findAll() {
        String sql =
        "SELECT * FROM img;";

        return this.jdbcTemplate.queryForStream(sql, FileDAO::mapRow)
            .collect(Collectors.toList());
    }
}
