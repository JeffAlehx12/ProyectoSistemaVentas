
package controlador;

import conexion.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import vista.*;

public class Frm_Ctrl_GestionarCategoriaProducto {
    
    InterGestionarCategoria vista;
    
    private int idCategoria;
    
     
    public Frm_Ctrl_GestionarCategoriaProducto() {
    
    }
    
    public Frm_Ctrl_GestionarCategoriaProducto(InterGestionarCategoria vista) {
        this.vista = vista;
        init();
    }
    
    private void init() {
        
        
        vista.setSize(new Dimension(896, 507));
        vista.setTitle("Gestionar Categorias");
        vista.setVisible(true);
        vista.setLocation(470, 45);
        
        
        FromMenu.desktopPane.add(vista);
        vista.toFront();
        
        CargarTablaCategorias();
        
        
        vista.jbtnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbtnRegresarActionPerformed(e);
            }
          });  
        
         vista.jbtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbtnGuardarActionPerformed(e);
            }

            
        });
        vista.jbtnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbtnEliminarActionPerformed(e);
            }

            
        });
        
        vista.jbtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbtnCancelarActionPerformed(e);
            }

            
        });
         
    }
    

    
     
    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        
        idCategoria=0;
        
        vista.jtxt_nombreCategoria.setText("");
        
   
    }
    
    private void jbtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {    
        
        vista.dispose();
        
        InterProducto interProducto = new InterProducto();
        Ctrl_Producto ctrl_Producto = new Ctrl_Producto(interProducto);
        
        
        
    } 
    
    
    
    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) { 
        
        
        
   if (vista.jtxt_nombreCategoria.getText().isEmpty()) {
       
            JOptionPane.showMessageDialog(null, "Agregue Categoria");
            
        } else {
            Categoria categoria = new Categoria();
            

            // Determine if it's a new or updated record
            boolean isNewRecord = idCategoria == 0;

            categoria.setnombreCategoria(vista.jtxt_nombreCategoria.getText().trim());
            categoria.setEstado(1);
            

            if (isNewRecord) {
                // New record
                if (!existeCategoria(categoria.getnombreCategoria())) {
                    if (guardar(categoria)) {
                        JOptionPane.showMessageDialog(null, "¡Categoria Registrado!");
                        CargarTablaCategorias();
                        vista.jtxt_nombreCategoria.setText("");
                        
                        InterProducto interProducto = new InterProducto();
                        Ctrl_Producto ctrl_Producto = new Ctrl_Producto(interProducto);
                        
                            vista.dispose();
                      
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error al registrar Categoria!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La Categoria ya está registrado, ingrese otro.");
                }
            } else {
                // Updated record
                if (actualizar(categoria, idCategoria)) {
                    JOptionPane.showMessageDialog(null, "¡Datos de la Categoria actualizada!");
                    CargarTablaCategorias();
                    vista.jtxt_nombreCategoria.setText("");
                    
                    idCategoria=0;
                    System.out.println(idCategoria);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos de la Categoria");
                }
            }
        }
    }
    
    
    
    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
   
         if (!vista.jtxt_nombreCategoria.getText().isEmpty()) {
            
            Categoria categoria = new Categoria();
            

            // Suponiendo que obtienes el ID de la categoría de alguna manera
           

            categoria.setnombreCategoria(vista.jtxt_nombreCategoria.getText().trim());

            // Verificar si la categoría está siendo utilizada en productos
            boolean isCategoriaUsada = isCategoriaUsadaEnProductos(idCategoria);

            if (isCategoriaUsada) {
                JOptionPane.showMessageDialog(null, "La categoría está siendo utilizada en productos. Elimine los productos asociados antes de eliminar la categoría.");
            } else {
                if (eliminar(idCategoria)) {
                    JOptionPane.showMessageDialog(null, "Categoría Eliminada");
                    vista.jtxt_nombreCategoria.setText("");
                    CargarTablaCategorias();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar la categoría");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoría");
        }
        
    }
    
    private void guardarCategoria() {
        
        Categoria categoria = new Categoria();
       

        if (vista.jtxt_nombreCategoria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            if (!existeCategoria(vista.jtxt_nombreCategoria.getText().trim())) {
                categoria.setnombreCategoria(vista.jtxt_nombreCategoria.getText().trim());
                categoria.setEstado(1);

                if (guardar(categoria)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La categoría ya está registrada en la Base de Datos");
            }
        }

        vista.jtxt_nombreCategoria.setText("");
    }
    
     //metodo para mostrar todas las categorias registradas
    
    
   private void CargarTablaCategorias(){
        
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select idCategoria, nombreCategoria from tb_categoria";
        Statement st;
        
        try {
            
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            vista.jTable_categoria = new JTable(model);
            vista.jScrollPane1.setViewportView(vista.jTable_categoria);
            
            model.addColumn("idCategoria");
            model.addColumn("nombreCategoria");
    
            
            while (rs.next()) {  
                
                Object fila[] = new Object[2];
                
                for (int i = 0; i < 2; i++) {
                    
                    fila[i] = rs.getObject(i + 1);
                
                }
                model.addRow(fila);
                
            }
            
            con.close();
            
            
        } catch (SQLException e) {
            
            System.out.println("Error al llenar la tabla categorias: " + e);
            
        }
        
        
        vista.jTable_categoria.addMouseListener(new MouseAdapter(){
        
            @Override
            
        public void mouseClicked(MouseEvent e){
            
            int fila_point = vista.jTable_categoria.rowAtPoint(e.getPoint());
            int columna_point = 0;
            
            if(fila_point > -1){
                
                idCategoria= (int) model.getValueAt(fila_point, columna_point);
                EnviarDatosCategoriaSeleccionada(idCategoria);
            
            }
        
        
        }
        
        
        });
    }
       
    
    
    //mostrar dato seleccionado por el mouse
    
   private void EnviarDatosCategoriaSeleccionada(int idCategoria){
     
         
         try {
             
                Connection con = Conexion.conectar();
                PreparedStatement pst = con.prepareStatement(
                        "select * from tb_categoria where idCategoria = '" + idCategoria +"'");
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    
                    vista.jtxt_nombreCategoria.setText(rs.getString("nombreCategoria"));
             }
                
                con.close();
             
             
             
         } catch (SQLException e) {
             
             System.out.println("Error cargar categoria: " + e);
             
          
         }
     
     

    }
    
    
    //metodo para consultar si existe la categoria
    public boolean existeCategoria(String nombreCategoria) {
    boolean respuesta = false;
    String sql = "select nombreCategoria from tb_categoria where nombreCategoria = '" + nombreCategoria + "';";
    Statement st;

    try {
        Connection cn = conexion.Conexion.conectar();
        st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            respuesta = true;
        }
        rs.close();
        st.close();
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al consultar categoría: " + e);
    }
    
    return respuesta;
}
    
    
    //metodo para actualizar categoria
    public boolean actualizar(Categoria objeto, int idCategoria){
        
        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {

            //prepareStatement "Preparar Declaracion"
            PreparedStatement consulta = cn.prepareStatement("update tb_categoria set nombreCategoria = ? where idCategoria ='" + idCategoria + "'");
            consulta.setString(1, objeto.getnombreCategoria());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar caterogia: " + e);
        }

        return respuesta;
        
    }
    
    
     
    //metodo para registrar categoria
    public boolean guardar(Categoria objeto) {
        
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
   
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria values (?,?,?)");
            consulta.setInt(1, 0); 
            consulta.setString(2, objeto.getnombreCategoria());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar categoria: " + e.getMessage());
        }

        return respuesta;
    }
    
    
    
   //metodo para eliminar categoria
   public boolean eliminar(int idCategoria) {
    Connection con = Conexion.conectar();
    String sql = "DELETE FROM tb_categoria WHERE idCategoria = ?";
    PreparedStatement pst;

    try {
        pst = con.prepareStatement(sql);
        pst.setInt(1, idCategoria);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.out.println("Error al eliminar la categoría: " + e);
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    return false;
}
    
    
     public boolean isCategoriaUsadaEnProductos(int idCategoria) {
        Connection con = Conexion.conectar();
        String sql = "SELECT COUNT(*) FROM tb_producto WHERE idCategoria = ?";
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCategoria);
            rs = pst.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Si hay al menos un producto asociado, retorna true
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar la categoría en productos: " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return false;
    }
 
}
