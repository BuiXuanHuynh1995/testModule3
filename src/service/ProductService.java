package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    public List<Product> getListProduct() throws SQLException;

    public Product getProduct(int productId) throws SQLException;

    public List<Product> searchByName(String productName) throws SQLException;

    public void addProduct(Product product) throws SQLException;

    public boolean updateProduct(Product product) throws SQLException;

    public boolean deleteProduct(int productId) throws SQLException;

}
