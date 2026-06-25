package model;

public class Cliente {
    private int idCliente;
    private String nombreRedSocial;
    private int telefono;
    private String ciudad;

    public Cliente(int idCliente, String nombreRedSocial, int telefono, String ciudad) {
        this.idCliente = idCliente;
        this.nombreRedSocial = nombreRedSocial;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public Cliente() {}

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public String getNombreRedSocial() { return nombreRedSocial; }
    public void setNombreRedSocial(String nombreRedSocial) { this.nombreRedSocial = nombreRedSocial; }
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
}