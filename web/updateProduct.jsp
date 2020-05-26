<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="service.CategoryServiceImpl" %>
<%@ page import="model.Category" %>
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
<form method="post" action="/productList?action=updateProduct">
    <c:if test="${product!=null}">
        <input type="hidden" name="productId" value="${product.productId}">
    </c:if>
    <table>
        <h1>Update Product</h1>
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
            <td><select name="categoryId">
                <%
                    for (Category category:categoryService.getListCategory()){
                %>
                <option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>
                <%
                    }
                %>
            </select></td>
<%--            <td><input type="text" value="<%=categoryService.getCategory(product.getCategoryId()).getCategoryName()%>"></td>--%>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Edit" onclick="return confirm('Are you sure?')">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
