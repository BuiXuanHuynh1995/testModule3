<%@ page import="service.CategoryServiceImpl" %>
<%@ page import="model.Product"%>
<%@ page import="service.ProductServiceImpl"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <style>
        tr td{
            border: solid 1px black;
        }
    </style>
</head>
<body>
<%
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
    ProductServiceImpl productService = new ProductServiceImpl();
    NumberFormat format = NumberFormat.getNumberInstance();
%>
<h2><a href="/productList.jsp">Back To List</a></h2>
<form method="post">
    <input type="text" name="productName">
    <input type="submit" value="Search">
</form>
<table>
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Color</td>
        <td>Description</td>
        <td>Category</td>
        <td>Action</td>
    </tr>
    <%
        for (Product product: productService.searchByName(request.getParameter("productName"))){
    %>
    <tr>
        <td><%=product.getProductId()%></td>
        <td><%=product.getProductName()%></td>
        <td><%=format.format(product.getPrice())%></td>
        <td><%=product.getQuantity()%></td>
        <td><%=product.getColor()%></td>
        <td><%=product.getDescription()%></td>
        <td><%=categoryService.getCategory(product.getCategoryId()).getCategoryName()%></td>
        <td>
            <a href="/productList?action=updateProduct&productId=<%=product.getProductId()%>">Edit</a>
            <a href="/productList?action=deleteProduct&productId=<%=product.getProductId()%>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
