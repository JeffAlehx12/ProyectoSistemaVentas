
package controlador;

import conexion.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.*;



public class Frm_Ctrl_GestionarProducto {
    
    InterGestionarProducto vista;
    
    private int idProducto;

    
    public Frm_Ctrl_GestionarProducto() {
    
    }
    
    
    
    public Frm_Ctrl_GestionarProducto(InterGestionarProducto vista) {
        this.vista = vista;
        init();
    }
    
    
    
    private void init() {
        
        
       

        vista.setSize(new Dimension(1317, 651));
        vista.setTitle("Gestionar Productos");
        vista.setVisible(true);
        vista.setLocation(170, 45);
        FromMenu.desktopPane.add(vista);
        
        
        
        vista.toFront();
        
        CargarTablaProductos();
       
        
       /* 
        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(1000, 500, WIDTH));
       // vista.jLabel_wallpaper.setIcon(icono);
        vista.repaint();
        
        */
       
       
        vista.jbtnActualizar.addActionListener(e -> jbtnActualizarActionPerformed(e));
        vista.jbtnCategoria.addActionListener(e -> jbtnCategoriaActionPerformed(e));
        vista.jbtnProducto.addActionListener(e -> AgregarProductoActionPerformed(e));

        
          
       
         
    }
    
    
    private InterProducto interProducto;
    private InterProductoActualizar interProductoActualizar;
    
    
    
    
    
    private void AgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {                                                

    if (interProducto == null || interProducto.isClosed()) {
        // No existe una instancia previa o está cerrada, crea una nueva
        interProducto = new InterProducto();
        Ctrl_Producto ctrl_Producto = new Ctrl_Producto(interProducto);
        // Agrega interProducto al contenedor principal, si es necesario
        // contenedorPrincipal.add(interProducto);
    } else {
        // Ya existe una instancia, colócala al frente
        try {
            interProducto.setSelected(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        interProducto.toFront();
    }

    vista.dispose();
}                                        

    private void jbtnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {

        InterGestionarCategoria interGestionarCategoria = new InterGestionarCategoria();
        Frm_Ctrl_GestionarCategoria ctrl_GestionarCategoria = new Frm_Ctrl_GestionarCategoria(interGestionarCategoria);
        vista.dispose();

    }

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        int fsel = InterGestionarProducto.jTable_productos.getSelectedRow();

        try {
            if (fsel == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                // Obtenemos el idProducto de la fila seleccionada
                int idProducto = Integer.parseInt(InterGestionarProducto.jTable_productos.getValueAt(fsel, 0).toString());
                
                ProductoSeleccionado.idProducto = idProducto;
                // Creamos la instancia de la interfaz de actualización y el controlador
                InterProductoActualizar interProductoActualizar = new InterProductoActualizar();
                Ctrl_ProductoActualizar ctrl_Producto = new Ctrl_ProductoActualizar(interProductoActualizar);

                // Enviamos los datos del producto seleccionado a la interfaz de actualización
                EnviarDatosProductoSeleccionado(idProducto, interProductoActualizar);

                vista.dispose();
                
            }
        } catch (Exception e) {
            e.printStackTrace(); // Esto te permitirá ver el error en la consola
        }
    }
    
    public class ProductoSeleccionado {
    public static int idProducto;
    
}

    private void EnviarDatosProductoSeleccionado(int idProducto, InterProductoActualizar interProductoActualizar) {
    try {
        Connection con = Conexion.conectar();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM tb_producto WHERE idProducto = ?");
        pst.setInt(1, idProducto);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            interProductoActualizar.jtxt_nombre.setText(rs.getString("nombre"));
            interProductoActualizar.jtxt_descripcion.setText(rs.getString("descripcion"));
            interProductoActualizar.jtxt_ubicacion.setText(rs.getString("ubicacion"));
            interProductoActualizar.jtxt_cantidad_inicial.setText(String.valueOf(rs.getInt("cantidad_actual")));
            interProductoActualizar.jspn_stockMinimo.setValue(rs.getInt("stock_min"));
            interProductoActualizar.jspn_StockMaximo.setValue(rs.getInt("stock_max"));
            interProductoActualizar.jtxt_precioCosto.setText(String.valueOf(rs.getDouble("precioCosto")));
            interProductoActualizar.jtxt_precioVenta.setText(String.valueOf(rs.getDouble("precioVenta")));

            // Seleccionar categoría por nombre
            int idCategoria = rs.getInt("idCategoria");
            PreparedStatement pstCategoria = con.prepareStatement("SELECT nombreCategoria FROM tb_categoria WHERE idCategoria = ?");
            pstCategoria.setInt(1, idCategoria);
            ResultSet rsCategoria = pstCategoria.executeQuery();
            if (rsCategoria.next()) {
                interProductoActualizar.jComboBox_categoria.setSelectedItem(rsCategoria.getString("nombreCategoria"));
            }

            // Seleccionar proveedor por nombre
            int idProveedor = rs.getInt("idProveedor");
            PreparedStatement pstProveedor = con.prepareStatement("SELECT razonSocial FROM tb_proveedor WHERE idProveedor = ?");
            pstProveedor.setInt(1, idProveedor);
            ResultSet rsProveedor = pstProveedor.executeQuery();
            if (rsProveedor.next()) {
                interProductoActualizar.jComboBox_proveedor.setSelectedItem(rsProveedor.getString("razonSocial"));
            }

            // Seleccionar IGV
            int porcentajeIgv = rs.getInt("porcentajeIgv");
            if (porcentajeIgv == 18) {
                interProductoActualizar.jComboBox_igv.setSelectedItem("18%");
            } else {
                interProductoActualizar.jComboBox_igv.setSelectedItem("No grava igv");
            }

            // Obtener la imagen y mostrarla en el JLabel
            int idImagen = rs.getInt("idImagen");
            if (idImagen != 0) {  // Asegurarse de que hay una imagen asignada
                PreparedStatement pstImagen = con.prepareStatement("SELECT imagen FROM Imagenes WHERE idImagen = ?");
                pstImagen.setInt(1, idImagen);
                ResultSet rsImagen = pstImagen.executeQuery();
                if (rsImagen.next()) {
                    Blob blob = rsImagen.getBlob("imagen");
                    if (blob != null) {  // Verificar que el blob no sea null
                        InputStream is = blob.getBinaryStream();
                        BufferedImage bufferedImage = ImageIO.read(is);
                        ImageIcon imageIcon = new ImageIcon(bufferedImage);
                        interProductoActualizar.jlbImg.setIcon(imageIcon);
                    } else {
                        // Si no hay imagen, se puede mostrar una imagen predeterminada o limpiar el JLabel
                        interProductoActualizar.jlbImg.setIcon(null);  // O una imagen por defecto
                    }
                }
            }
 
            

        } else {
            System.out.println("Producto no encontrado.");
        }

        con.close();
    } catch (SQLException | IOException e) {
        System.out.println("Error al seleccionar producto: " + e.getMessage());
    }
}
    
   

    /*
     * *****************************************************
     * metodo para mostrar todos los productos registrados
     * *****************************************************
     */
    String descripcionCategoria = "";

    double precio = 0.0;
    int porcentajeIgv = 0;
    double IGV = 0;

    private void CargarTablaProductos() {
    Connection con = Conexion.conectar();
    DefaultTableModel model = new DefaultTableModel();
    
    // Modifica la consulta para incluir el nombre del proveedor usando razonSocial
    String sql = "SELECT p.idProducto, p.nombre, p.descripcion, pr.razonSocial AS proveedor, c.nombreCategoria, p.ubicacion, p.precioCosto, p.precioVenta, p.porcentajeIgv, p.precio_total " +
                 "FROM tb_producto p " +
                 "JOIN tb_categoria c ON p.idCategoria = c.idCategoria " +
                 "JOIN tb_proveedor pr ON p.idProveedor = pr.idProveedor " +  // Usar razonSocial
                 "WHERE p.estado = 1;";  // Filtra por estado "1"
    
    Statement st;
    try {
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        InterGestionarProducto.jTable_productos = new JTable(model);
        InterGestionarProducto.jScrollPane1.setViewportView(InterGestionarProducto.jTable_productos);

        model.addColumn("ID°");  // ID
        model.addColumn("Nombre");
        model.addColumn("Descripcion");
        model.addColumn("Proveedor");  // Columna para el proveedor
        model.addColumn("Categoria");
        model.addColumn("Ubicacion");
        model.addColumn("Precio Costo");
        model.addColumn("Precio Venta");
        model.addColumn("IGV");
        model.addColumn("Precio Total");

        while (rs.next()) {
            double precio = rs.getDouble("precioVenta");
            int porcentajeIgv = rs.getInt("porcentajeIgv");

            Object fila[] = new Object[10];
            for (int i = 0; i < 10; i++) {
                if (i == 8) {
                    this.calcularIgv(precio, porcentajeIgv);  // Método para calcular IGV
                    fila[i] = IGV;
                } else {
                    fila[i] = rs.getObject(i + 1);
                }
            }
            model.addRow(fila);
        }
        con.close();
    } catch (SQLException e) {
        System.out.println("Error al llenar la tabla productos: " + e);
    }

    // Evento para obtener el campo al cual el usuario da clic
    InterGestionarProducto.jTable_productos.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila_point = InterGestionarProducto.jTable_productos.rowAtPoint(e.getPoint());
            int columna_point = 0;

            if (fila_point > -1) {
                idProducto = (int) model.getValueAt(fila_point, columna_point);
            }
        }
    });
}

    /*
     * **************************************************
     * Metodo para calcular Igv
     * **************************************************
     */
    private double calcularIgv(double precio, int iva) {
        int p_iva = iva;
        switch (p_iva) {
            case 0:
                IGV = 0.0;
                break;
            case 18:
                IGV = precio * 0.18;
                break;
            
        }
        //redondear decimales
        IGV = (double) Math.round(IGV * 100) / 100;
        return IGV;
    }

  
  //   Metodo que envia datos seleccionados
    
    private void EnviarStockSeleccionado(int idProducto) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from tb_producto where idProducto = '" + idProducto + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                
                
                vista.txt_cantidad.setText(rs.getString("cantidad_actual"));
                
               
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar producto: " + e);
        }
    }

   
   
}
