package controlador;

import conexion.Conexion;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Producto;
import vista.*;



public class Frm_Ctrl_Stock {
    
    
     InterActualizarStock vista;
     
     int idProducto = 0;
      int cantidad = 0;

    public Frm_Ctrl_Stock() {
    }
        
    

     //controlador con el parametro del interfaz
    public Frm_Ctrl_Stock(InterActualizarStock vista) {
        this.vista = vista;
        init();
    }

    
      //metodo para el inicio del interfaz
    
    private void init() {
        
        vista.setTitle("Actualizar Stock de los Productos");
        vista.setSize(new Dimension(400, 300));
        vista.setVisible(true);
        vista.setLocation(35, 45);
        FromMenu.desktopPane.add(vista);
        

        CargarComboProductos();
        
        
        
        //el boton que se usara
        vista.jComboBox_producto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jComboBox_productoActionPerformed(e);
            }
        });
        
         vista.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });
         
         
         
         
    }
    
    //funcion del boton
    private void jComboBox_productoActionPerformed(java.awt.event.ActionEvent evt) {
    
    MostrarStock();
    
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {    

        //validamos seleccion del producto
        if (!vista.jComboBox_producto.getSelectedItem().equals("Seleccione producto:")) {
            //Validamos campos vacios
            if (!vista.txt_cantidad_nueva.getText().isEmpty()) {
                //validamos que el usuario no ingrese otros caracteres no numericos
                boolean validacion = validar(vista.txt_cantidad_nueva.getText().trim());
                if (validacion == true) {
                    //validar que la cantidad sea mayor cero (0)
                    if (Integer.parseInt(vista.txt_cantidad_nueva.getText()) > 0) {

                        Producto producto = new Producto();
                        Ctrl_Producto controlProducto = new Ctrl_Producto();
                        int stockActual = Integer.parseInt(vista.txt_cantidad_actual.getText().trim());
                        int stockNuevo = Integer.parseInt(vista.txt_cantidad_nueva.getText().trim());

                        stockNuevo = stockActual + stockNuevo;
                        producto.setCantidad_actual(stockNuevo);
                        if (controlProducto.actualizarStock(producto, idProducto)) {
                            JOptionPane.showMessageDialog(null, "Stock Actualizado");
                            vista.jComboBox_producto.setSelectedItem("Seleccione producto:");
                            vista.txt_cantidad_actual.setText("");
                            vista.txt_cantidad_nueva.setText("");
                            CargarComboProductos();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Actualizar Stock");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero ni negativa");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numericos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una nueva cantidad para sumar el stock del producto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        }
        

    }
    
    // metodos para optimizar la funcion del boton
    
      
    
    //Metodo para caragar los productos en el jComboBox
    private void CargarComboProductos() {

        Connection cn = Conexion.conectar();
        String sql = "select * from tb_producto";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            vista.jComboBox_producto.removeAllItems();
            vista.jComboBox_producto.addItem("Seleccione producto:");
            while (rs.next()) {
                vista.jComboBox_producto.addItem(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar los productos en: " + e);
        }

    }

    //metodo para mostrar stock del producto seleccionado
    private void MostrarStock() {
        try {

            Connection cn = Conexion.conectar();
            String sql = "select * from tb_producto where nombre = '" + vista.jComboBox_producto.getSelectedItem() + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                idProducto = rs.getInt("idProducto");
                cantidad = rs.getInt("cantidad");
                vista.txt_cantidad_actual.setText(String.valueOf(cantidad));
            } else {
                vista.txt_cantidad_actual.setText("");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener stock del producto en: " + e);
        }
    }

    //metodo de validacion de caracteres no numericos
    private boolean validar(String valor) {
        int num;
        try {
            num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
       
   

}
