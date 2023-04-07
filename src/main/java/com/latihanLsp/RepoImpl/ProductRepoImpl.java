package com.latihanLsp.RepoImpl;

import com.latihanLsp.Model.LogPenjualan;
import com.latihanLsp.Model.Product;
import com.latihanLsp.Model.ProductWithCategory;
import com.latihanLsp.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
@Repository
public class ProductRepoImpl implements ProductRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addProduct(Product products) {
        String sql = "INSERT INTO product (price, amount_sold,stock,tgl_input,category_id) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, products.getPrice(),products.getAmount_sold(),products.getStock(),products.getTgl_input(),products.getCategory_id());
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "UPDATE product SET price=?,stock=?,category_id=?,amount_sold=?,tgl_input=? WHERE id=?";
        jdbcTemplate.update(sql,product.getPrice(), product.getStock(), product.getCategory_id(),product.getAmount_sold(), product.getTgl_input(),product.getId());
    }
    @Override
    public Product getProductById(int id) {
        String sql = "SELECT * FROM product WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);
    }
    @Override
    public List<Product> getAllProduct() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }
    @Override
    public List<ProductWithCategory> getProductsWithCategory() {
        String sql = "SELECT * FROM `pwithc`";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductWithCategory.class));
    }

    @Override
    public List<LogPenjualan> getLogPenjualan() {
        String sql = "SELECT * FROM `log_penjualan`";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LogPenjualan.class));
    }

    @Override
    public void deleteAnimal(int id) {
        String sql = "DELETE FROM product WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
    private static final class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setCategory_id(rs.getInt("category_id"));
            product.setPrice(rs.getInt("price"));
            product.setStock(rs.getInt("stock"));
            product.setAmount_sold(rs.getInt("amount_sold"));
            product.setTgl_input(rs.getDate("tgl_input"));
            return product;
        }
    }

}
