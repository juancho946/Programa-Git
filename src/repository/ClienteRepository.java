package repository;

import config.DatabaseConnection;
import model.Cliente;
import java.sql.*;

/**
 * Clase Repositorio que maneja la persistencia de datos del Cliente.
 * Aplica el estándar de Frameworks para la abstracción de consultas SQL.
 */
public class ClienteRepository {

    // Método para insertar un cliente en la base de datos MySQL
    public void save(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nombre_red_social, telefono, ciudad) VALUES (?, ?, ?)";
        
        // Uso de try-with-resources para garantizar el cierre automático de la conexión
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Seteo de parámetros aplicando buenas prácticas contra Inyección SQL
            stmt.setString(1, cliente.getNombreRedSocial());
            stmt.setInt(2, cliente.getTelefono());
            stmt.setString(3, cliente.getCiudad());
            
            // Ejecución de la sentencia en el motor relacional
            stmt.executeUpdate();
        }
    }
}