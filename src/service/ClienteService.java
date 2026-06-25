package service;

import repository.ClienteRepository;
import model.Cliente;
import java.sql.SQLException;

/**
 * Capa de Servicio que contiene la lógica de negocio de la aplicación.
 * Requisito indispensable en Frameworks como Spring para desacoplar componentes.
 */
public class ClienteService {
    
    // Dependencia del repositorio (Inyección lógica)
    private ClienteRepository clienteRepository = new ClienteRepository();

    /**
     * Valida los datos del cliente antes de enviarlos a guardar.
     */
    public boolean registrarCliente(Cliente cliente) throws SQLException {
        // Estándar de validación de negocio
        if (cliente.getNombreRedSocial() == null || cliente.getNombreRedSocial().isEmpty()) {
            return false; 
        }
        
        // Si pasa las validaciones, delega la persistencia al repositorio
        clienteRepository.save(cliente);
        return true;
    }
}