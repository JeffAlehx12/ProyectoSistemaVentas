
package modelo;


public class Producto {
    
    //Atributos
    
    private int idProducto;
    private String nombre;
    private String descripcion;
    private int idCategoria;
    private int idProveedor;
    private String ubicacion;
    private int cantidad_actual;
    private int stock_min;
    private int stock_max;
    private double precioCosto;
    private double precioVenta;
    private int porcentajeIgv;
    private double precio_total;
    private int idImagen;
    private int estado;
    
    
    //Constructor

    public Producto() {
        
        this.idProducto = 0;
        this.nombre = "";
        this.descripcion = "";
        this.idCategoria = 0;
        this.idProveedor = 0;
        this.ubicacion = "";
        this.cantidad_actual = 0;
        this.stock_min = 0;
        this.stock_max = 0;
        this.precioCosto = 0.0;
        this.precioVenta = 0.0;
        this.porcentajeIgv = 0;
        this.precio_total = 0.0;
        this.idImagen = 0;
        this.estado = 0;
        
    }

    public Producto(int idProducto, String nombre, String descripcion, int idCategoria, int idProveedor, String ubicacion, int cantidad_actual, int stock_min, int stock_max, double precioCosto, double precioVenta, int porcentajeIgv, double precio_total, int idImagen, int estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
        this.ubicacion = ubicacion;
        this.cantidad_actual = cantidad_actual;
        this.stock_min = stock_min;
        this.stock_max = stock_max;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.porcentajeIgv = porcentajeIgv;
        this.precio_total = precio_total;
        this.idImagen = idImagen;
        this.estado = estado;
    }

    
     //Set and Get

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(int cantidad_actual) {
        this.cantidad_actual = cantidad_actual;
    }

    public int getStock_min() {
        return stock_min;
    }

    public void setStock_min(int stock_min) {
        this.stock_min = stock_min;
    }

    public int getStock_max() {
        return stock_max;
    }

    public void setStock_max(int stock_max) {
        this.stock_max = stock_max;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getPorcentajeIgv() {
        return porcentajeIgv;
    }

    public void setPorcentajeIgv(int porcentajeIgv) {
        this.porcentajeIgv = porcentajeIgv;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

   

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

   
     
    
    
}
