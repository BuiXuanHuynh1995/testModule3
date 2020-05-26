<%@ page import="model.Category" %>
<%@ page import="service.CategoryServiceImpl" %>
<%@ page import="model.Product" %>
<%@ page import="service.ProductServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
    ProductServiceImpl productService = new ProductServiceImpl();
    Product product = productService.getProduct(Integer.parseInt(request.getParameter("productId")));
%>
<form method="post" action="/productList?action=deleteProduct">
    <table>
        <c:if test="${product!=null}">
            <input type="hidden" name="productId" value="${product.productId}">
        </c:if>
        <h1>Delete Product</h1>
        <tr>
            <th>Name</th>
            <td> <input type="text" name="productName" value="${product.productName}"></td>
        </tr>
        <tr>
            <th>Price</th>
            <td><input type="number" name="price" value="${product.price}"></td>
        </tr>
        <tr>
            <th>Quantity</th>
            <td><input type="number" name="quantity" value="${product.quantity}"></td>
        </tr>
        <tr>
            <th>Color</th>
            <td><input type="text" name="color" value="${product.color}"></td>
        </tr>
        <tr>
            <th>Description</th>
            <td><input type="text" name="description" value="${product.description}"></td>
        </tr>
        <tr>
            <th>Category</th>
            <td><input type="text" value="<%=categoryService.getCategory(product.getCategoryId()).getCategoryName()%>"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete more products??')">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
