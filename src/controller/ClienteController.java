package controller;

import service.ClienteService;
import model.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Controlador principal del Módulo Web bajo el patrón MVC.
 * Gestiona el flujo de peticiones entrantes y las respuestas del cliente.
 */
@WebServlet("/registrarCliente")
public class ClienteController extends HttpServlet {
    
    // Conexión directa con la capa de servicio del Framework
    private ClienteService clienteService = new ClienteService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            // Captura de parámetros del formulario index.html / index.jsp
            String redSocial = request.getParameter("txtRedSocial");
            int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String ciudad = request.getParameter("txtCiudad");

            // Construcción del objeto modelo (POJO)
            Cliente nuevoCliente = new Cliente(0, redSocial, telefono, ciudad);

            // Ejecución de la lógica mediante el servicio
            boolean exito = clienteService.registrarCliente(nuevoCliente);

            if (exito) {
                response.sendRedirect("exito.jsp"); // Redirección exitosa
            } else {
                response.sendRedirect("error.jsp"); // Redirección en caso de datos inválidos
            }
            
        } catch (SQLException | NumberFormatException e) {
            // Control y captura de excepciones del sistema
            throw new ServletException("Error en el procesamiento del módulo con Framework", e);
        }
    }
}