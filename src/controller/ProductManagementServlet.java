package controller;

import model.Product;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductManagementServlet",urlPatterns = "/productList")
public class ProductManagementServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "addProduct":
                addProduct(request,response);
                break;
            case "updateProduct":
                updateProduct(request,response);
                break;
            case "deleteProduct":
                deleteProduct(request,response);
                break;
        }
    }


    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("productId"));
        try {
            this.productService.deleteProduct(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("productId"));
        String name = request.getParameter("productName");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category = Integer.parseInt(request.getParameter("categoryId"));
        try {
            this.productService.updateProduct(new Product(id,name,price,quantity,color,description,category));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("productName");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description= request.getParameter("description");
        int category = Integer.parseInt(request.getParameter("categoryId"));
        try {
            this.productService.addProduct(new Product(productName,price,quantity,color,description,category));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "addProduct":
                showAddProduct(request,response);
                break;
            case "updateProduct":
                showUpdateProduct(request,response);
                break;
            case "deleteProduct":
                showDeleteProduct(request,response);
                break;
//            default:
//                listProduct(request,response);
        }
    }

    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = null;
        try {
            product = this.productService.getProduct(productId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("deleteProduct.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = null;
        try {
            product = this.productService.getProduct(productId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateProduct.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addProduct.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
//        List<Product> productList = null;
//        try {
//            productList = this.productService.getListProduct();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        request.setAttribute("productList", productList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
