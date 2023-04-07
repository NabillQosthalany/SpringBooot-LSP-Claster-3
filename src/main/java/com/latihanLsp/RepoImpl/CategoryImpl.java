package com.latihanLsp.RepoImpl;

import com.latihanLsp.Model.Category;
import com.latihanLsp.Model.Product;
import com.latihanLsp.Repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CategoryImpl implements CategoryRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void addCategory(Category category) {
        String sql = "INSERT INTO category (name_category, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, category.getName(),category.getDesc());
    }
    @Override
    public void updateCategory(Category category) {
        String sql = "UPDATE category SET name_category=?,description=? WHERE id=?";
        jdbcTemplate.update(sql, category.getName(),category.getDesc(),category.getId());
    }

    @Override
    public void deleteCategory(int id) {
        String sql = "DELETE FROM category WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM category WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), id);
    }

    @Override
    public List<Category> getAllCategory() {
        String sql = "SELECT * FROM category";
        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }
    private static final class CategoryRowMapper implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name_category"));
            category.setDesc(rs.getString("description"));
            return category;
        }
    }
}
