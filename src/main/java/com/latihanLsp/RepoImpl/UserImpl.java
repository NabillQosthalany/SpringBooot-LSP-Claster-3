package com.latihanLsp.RepoImpl;

import com.latihanLsp.Model.Product;
import com.latihanLsp.Model.User;
import com.latihanLsp.Repo.UserRepo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserImpl implements UserRepo {
    private JdbcTemplate jdbcTemplate;

    public UserImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ? LIMIT 1";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, username);
    }

    @Override
    public List<User> getAllAccount() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserImpl.UserRowMapper());
    }

    @Override
    public void updatePassword(User user) {
        String sql = "UPDATE users SET username=?, role=?, password=? WHERE id=?";
        jdbcTemplate.update(sql,user.getUsername(),user.getRole(), user.getPassword(),user.getId());
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (username, role, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getRole(),user.getPassword());
    }
    private static final class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setRole(rs.getString("role"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }

}
