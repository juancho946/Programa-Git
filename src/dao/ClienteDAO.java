package dao;

import config.DatabaseConnection;
import model.Cliente;
import java.sql.*;

public class ClienteDAO {
    public void registrarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nombre_red_social, telefono, ciudad) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cliente.getNombreRedSocial());
            stmt.setInt(2, cliente.getTelefono());
            stmt.setString(3, cliente.getCiudad());
            stmt.executeUpdate();
            System.out.println("✅ Cliente registrado en la nueva BD web.");
        }
    }
}