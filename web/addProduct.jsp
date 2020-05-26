<%@ page import="service.CategoryService" %>
<%@ page import="service.CategoryServiceImpl" %>
<%@ page import="model.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
%>
<form method="post">
    <h2>Add New Product</h2>
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="productName"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="number" name="quantity"></td>
        </tr>
        <tr>
            <td>Color</td>
            <td><input type="text" name="color"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><select name="categoryId">
              <%
                  for (Category category: categoryService.getListCategory()){
              %>
                <option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>
                <%
                    }
                %>
            </select></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Add product" onclick="return confirm('Are you sure you want to add more products?')">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
