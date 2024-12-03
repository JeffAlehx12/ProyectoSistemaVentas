
package modelo;

public class Proveedor {
    
    private int idProveedor;
    private String razonSocial;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String productos;
    private String direccion;
    private String telefono;
    private String correo;
    private int estado;

    public Proveedor() {
        
        this.idProveedor = 0;
        this.razonSocial = "";
        this.identificacion = "";
        this.nombre = "";
        this.apellido = "";
        this.productos = "";
        this.direccion = "";
        this.telefono = "";
        this.correo = "";
        this.estado = 0;
        
        
    }

    public Proveedor(int idProveedor, String razonSocial, String identificacion, String nombre, String apellido, String productos, String direccion, String telefono, String correo, int estado) {
        this.idProveedor = idProveedor;
        this.razonSocial = razonSocial;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.productos = productos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }
    
    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    

    
    
    
}
