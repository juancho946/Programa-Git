package controller;

import dao.ClienteDAO;
import model.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
    private ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String redSocial = request.getParameter("txtRedSocial");
        int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
        String ciudad = request.getParameter("txtCiudad");

        Cliente nuevoCliente = new Cliente(0, redSocial, telefono, ciudad);

        try {
            clienteDAO.registrarCliente(nuevoCliente);
            response.sendRedirect("exito.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error en la base de datos web", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}