package controlador;

import conexion.Conexion;
import controlador.Frm_Ctrl_RegistrarVenta;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CabeceraVenta;
import vista.FromMenu;
import vista.InterGestionarVentas;
import static vista.InterGestionarVentas.jTable_ventas;


public class Frm_Ctrl_GestionarVentas {
    
    
     InterGestionarVentas vista;
     
     private int idCliente = 0;
     private int idVenta;

    public Frm_Ctrl_GestionarVentas() {
    }
        
    

     //controlador con el parametro del interfaz
    public Frm_Ctrl_GestionarVentas(InterGestionarVentas vista) {
        this.vista = vista;
        init();
    }

    
      //metodo para el inicio del interfaz
    
    private void init() {
      
        
//Cargar tabla
        vista.setSize(new Dimension(900, 500));
        vista.setTitle("Gestionar Ventas");
        vista.setVisible(true);
        vista.setLocation(750, 50);
        vista.repaint();
        FromMenu.desktopPane.add(vista);
        vista.toFront();

        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        vista.jLabel_wallpaper.setIcon(icono);
        
      

        CargarComboClientes();
        CargarTablaVentas();
        
        
        
        //el boton que se usara
     
         vista.jButton_actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton_actualizarActionPerformed(e);
            }
        });
         
         
         
         
    }
    
    //funcion del boton
   
    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {   
    
    
    CabeceraVenta cabeceraVenta = new CabeceraVenta();
        Frm_Ctrl_RegistrarVenta controlRegistrarVenta = new Frm_Ctrl_RegistrarVenta();
        String cliente, estado;
        cliente = vista.jComboBox_cliente.getSelectedItem().toString().trim();
        estado = vista.jComboBox_estado.getSelectedItem().toString().trim();

        //obtener el id del cliente
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select idCliente, concat(nombre, ' ', apellido) as cliente "
                    + "from tb_cliente where concat(nombre, ' ', apellido) = '" + cliente + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error en cargar el id cliente: " + e);
        }

        //Actualizar datos
        if (!cliente.equalsIgnoreCase("Seleccione cliente:")) {
            cabeceraVenta.setIdCliente(idCliente);
            if (estado.equalsIgnoreCase("Activo")) {
                cabeceraVenta.setEstado(1);
            } else {
                cabeceraVenta.setEstado(0);
            }

            if (controlRegistrarVenta.actualizar(cabeceraVenta, idVenta)) {
                JOptionPane.showMessageDialog(null, "¡Registro Actualizado!");
                CargarTablaVentas();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para actualizar datos");
        }
    
    }
    
    
    
    
    // metodos para optimizar la funcion del boton
    
      
    
    //Metodo para caragar los productos en el jComboBox
    /*
     * *****************************************************
     * metodo para limpiar
     * *****************************************************
     */
    private void Limpiar() {
        vista.txt_total_pagar.setText("");
        vista.txt_fecha.setText("");
        vista.jComboBox_cliente.setSelectedItem("Seleccione cliente:");
        vista.jComboBox_estado.setSelectedItem("Activo");
        idCliente = 0;
    }


    /*
     * *****************************************************
     * metodo para mostrar todos los clientes registrados
     * *****************************************************
     */
    private void CargarTablaVentas() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select cv.idCabeceraVenta as id, concat(c.nombre, ' ', c.apellido) as cliente, "
                + "cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado "
                + "from tb_cabecera_venta as cv, tb_cliente as c where cv.idCliente = c.idCliente;";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarVentas.jTable_ventas = new JTable(model);
            InterGestionarVentas.jScrollPane1.setViewportView(InterGestionarVentas.jTable_ventas);

            model.addColumn("N°");//ID
            model.addColumn("Cliente");
            model.addColumn("Total Pagar");
            model.addColumn("Fecha Venta");
            model.addColumn("estado");

            while (rs.next()) {
                Object fila[] = new Object[5];
                for (int i = 0; i < 5; i++) {
                    if (i == 4) {
                        String estado = String.valueOf(rs.getObject(i + 1));
                        if (estado.equalsIgnoreCase("1")) {
                            fila[i] = "Activo";
                        } else {
                            fila[i] = "Inactivo";
                        }
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de ventas: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        jTable_ventas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_ventas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idVenta = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosVentaSeleccionada(idVenta);//metodo
                }
            }
        });
    }


    /*
     * **************************************************
     * Metodo que envia datos seleccionados
     * **************************************************
     */
    private void EnviarDatosVentaSeleccionada(int idVenta) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select cv.idCabeceraVenta, cv.idCliente, concat(c.nombre, ' ', c.apellido) as cliente, "
                    + "cv.valorPagar, cv.fechaVenta, cv.estado  from tb_cabecera_venta as cv, "
                    + "tb_cliente as c where  cv.idCabeceraVenta = '" + idVenta + "' and cv.idCliente = c.idCliente;");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                vista.jComboBox_cliente.setSelectedItem(rs.getString("cliente"));
                vista.txt_total_pagar.setText(rs.getString("valorPagar"));
                vista.txt_fecha.setText(rs.getString("fechaVenta"));
                int estado = rs.getInt("estado");
                if (estado == 1) {
                    vista.jComboBox_estado.setSelectedItem("Activo");
                } else {
                    vista.jComboBox_estado.setSelectedItem("Inactivo");
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar venta: " + e);
        }
    }

    /*
    Metodo para cargar los clientes en el jComboBox
     */
    private void CargarComboClientes() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_cliente";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            vista.jComboBox_cliente.removeAllItems();
            vista.jComboBox_cliente.addItem("Seleccione cliente:");
            while (rs.next()) {
            vista.jComboBox_cliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar clientes, !" + e);
        }
    }

}
