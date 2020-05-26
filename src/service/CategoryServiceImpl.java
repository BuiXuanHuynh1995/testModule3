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

public class CategoryServiceImpl implements CategoryService{
    @Override
    public Category getCategory(int categoryId) throws SQLException {
        String sql = "select * from category where categoryId = '"+categoryId+"'";
        Connection connection = DBConnect.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        Category category = new Category();

        while (resultSet.next()){
            category.setCategoryId(resultSet.getInt(1));
            category.setCategoryName(resultSet.getString(2));
        }
        return category;
    }

    @Override
    public List<Category> getListCategory() throws SQLException {
        String sql ="select * from category";
        Connection connection = DBConnect.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Category> categories = new ArrayList<>();

        while (resultSet.next()){
            Category category = new Category();
            category.setCategoryId(resultSet.getInt(1));
            category.setCategoryName(resultSet.getString(2));
            categories.add(category);
        }
        return categories;
    }
}
