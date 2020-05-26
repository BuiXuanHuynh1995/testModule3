package service;

import model.Category;
import model.DBConnect;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static final String SELECT_ALL_PRODUCT= "select * from product";
    private static final String SEARCH_BY_NAME= "select * from product where productName like ?";
    private static final String INSERT_INTO_PRODUCT= "insert into product(productName,price,quantity,color,description,categoryId) value(?,?,?,?,?,?)";
    private static final String SELECT_PRODUCT_BY_ID= "select * from product where productId = ?";
    private static final String DELETE_PRODUCT= "delete from product where productId= ? ";
    private static final String UPDATE_PRODUCT = "update product set productName=?,price=?,quantity=?,color=?,description=?,categoryId=? where productId=?";
    @Override
    public List<Product> getListProduct() throws SQLException {
//        String sql = "select * from product";
        Connection connection = DBConnect.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
        ResultSet resultSet = statement.executeQuery();
        List<Product> productList = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProductId(resultSet.getInt(1));
            product.setProductName(resultSet.getString(2));
            product.setPrice(resultSet.getFloat(3));
            product.setQuantity(resultSet.getInt(4));
            product.setColor(resultSet.getString(5));
            product.setDescription(resultSet.getString(6));
            product.setCategoryId(resultSet.getInt(7));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public Product getProduct(int productId) throws SQLException {
//        String sql = "select * from product where productId = '" + productId + "'";
        Connection connection = DBConnect.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
        statement.setInt(1,productId);
        ResultSet resultSet = statement.executeQuery();
        Product product = new Product();
        while (resultSet.next()) {
            product.setProductId(resultSet.getInt(1));
            product.setProductName(resultSet.getString(2));
            product.setPrice(resultSet.getFloat(3));
            product.setQuantity(resultSet.getInt(4));
            product.setColor(resultSet.getString(5));
            product.setDescription(resultSet.getString(6));
            product.setCategoryId(resultSet.getInt(7));
        }
        return product;
    }

    @Override
    public List<Product> searchByName(String productName) throws SQLException {
//        String sql = "select * from product where productName like ?";
        List<Product> productList = new ArrayList<>();
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(SEARCH_BY_NAME)) {
            statement.setString(1, "%" + productName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt(1));
                product.setProductName(resultSet.getString(2));
                product.setPrice(resultSet.getFloat(3));
                product.setQuantity(resultSet.getInt(4));
                product.setColor(resultSet.getString(5));
                product.setDescription(resultSet.getString(6));
                product.setCategoryId(resultSet.getInt(7));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void addProduct(Product product) throws SQLException {
//        String sql = "insert into product(productName,price,quantity,color,description,categoryId) value(?,?,?,?,?,?)";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_PRODUCT);) {
            statement.setString(1, product.getProductName());
            statement.setFloat(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4,product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
//        String sql = "update product set productName=?,price=?,quantity=?,color=?,description=?,categoryId=? where productId=?";
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT);
            statement.setString(1, product.getProductName());
            statement.setFloat(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4,product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getCategoryId());
            statement.setInt(7, product.getProductId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int productId) throws SQLException {
//        String sql = "delete from product where productId= ? ";
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT);
            statement.setInt(1, productId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
