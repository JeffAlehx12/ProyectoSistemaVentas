
package modelo;


public class Configuracion {
    
  private String ruc;
    private String nombre;
    private String telefono;
    private String direccion;
    private String razon;

    public Configuracion() {
        
        this.ruc = "";
        this.nombre = "";
        this.telefono = "";
        this.direccion = "";
        this.razon = "";
        
    }

    
    
    
    
    public Configuracion(String ruc, String nombre, String telefono, String direccion, String razon) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.razon = razon;
    }

    // Getters y setters
    public String getRuc() { return ruc; }
    public void setRuc(String ruc) { this.ruc = ruc; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getRazon() { return razon; }
    public void setRazon(String razon) { this.razon = razon; }
    
}