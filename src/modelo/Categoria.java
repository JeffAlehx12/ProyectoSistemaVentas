
package modelo;

public class Categoria {
    
    private int idCategoria;
    private String nombreCategoria;
    private int estado;

    public Categoria() {

        this.idCategoria = 0;
        this.nombreCategoria = "";
        this.estado = 0;
    }

    public Categoria(int idCategoria, String nombreCategoria, int estado) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.estado = estado;
    }

    public int getIdCategoria() {return idCategoria;}

    public void setIdCategoria(int idCategoria) {this.idCategoria = idCategoria;}

    public String getnombreCategoria() {return nombreCategoria;}

    public void setnombreCategoria(String nombreCategoria) {this.nombreCategoria = nombreCategoria;}

    public int getEstado() {return estado;}

    public void setEstado(int estado) {this.estado = estado;}
    
    
   
}
