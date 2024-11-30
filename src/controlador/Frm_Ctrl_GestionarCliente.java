package controlador;

import conexion.Conexion;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import vista.FromMenu;
import vista.InterGestionarCliente;

public class Frm_Ctrl_GestionarCliente {
    
    InterGestionarCliente vista;
    
    
    private int idCliente = 0;
    

    public Frm_Ctrl_GestionarCliente() {
    }
    
    
    
    public Frm_Ctrl_GestionarCliente(InterGestionarCliente vista) {
        this.vista = vista;
        init();
    }
    
    
    
    
    private void init() {
        
        
        vista.setSize(new Dimension(1580, 880));
        vista.setTitle("Gestionar Cliente");
        vista.setVisible(true);
        vista.setLocation(0,0);
        
         // Evitar que se pueda mover el JInternalFrame
        vista.setResizable(false);  // Deshabilita el redimensionamiento
        vista.setClosable(false);   // Deshabilita la opción de cerrar
        vista.setMaximizable(false); // Deshabilita la opción de maximizar
        vista.setIconifiable(false); // Deshabilita la opción de minimizar

        // Eliminar la barra de título y los botones de control (Cerrar, Minimizar, Maximizar)
        JInternalFrame jif = vista;
        ((BasicInternalFrameUI) jif.getUI()).setNorthPane(null); // Quita la barra de título

// Quitar el borde adicional alrededor del contenido
        jif.setBorder(BorderFactory.createEmptyBorder());  // Elimina el borde de todo el JInternalFrame

// Fuerza a que se dibuje correctamente el contenido
        jif.revalidate();
        jif.repaint();
        
        vista.toFront();
        
        
        CargarTablaClientes();
        
        
        vista.repaint();
        
        
        vista.jButton_Guardar.addActionListener(e -> jButton_GuardarActionPerformed(e));
        vista.jButton_editar.addActionListener(e -> jButton_editarActionPerformed(e));
        vista.jButton_eliminar.addActionListener(e -> jButton_eliminarActionPerformed(e));
        vista.jButton_Cancelar.addActionListener(e -> jButton_CancelarActionPerformed(e));
        vista.jbtnBuscarporDni.addActionListener(e -> jbtnBuscarporDniActionPerformed(e));
        
       
         
    }
    
    
    private void jbtnBuscarporDniActionPerformed(java.awt.event.ActionEvent evt) { 
         
         String identificacion = vista.jtxtBusqueda.getText().trim();

    if (!identificacion.isEmpty()) {
        EnviarDatosClienteSeleccionado2(identificacion);
    } else {
        System.out.println("Por favor ingrese una identificación.");
    }
    }
    
    private void EnviarDatosClienteSeleccionado2(String identificacion) {
        DefaultTableModel model = (DefaultTableModel) InterGestionarCliente.jTable_cliente.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 3).equals(identificacion)) { // Asumiendo que la columna 3 contiene la identificación (Ruc/Dni)
                InterGestionarCliente.jTable_cliente.setRowSelectionInterval(i, i);
                InterGestionarCliente.jTable_cliente.scrollRectToVisible(new java.awt.Rectangle(InterGestionarCliente.jTable_cliente.getCellRect(i, 0, true)));
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    private void jButton_GuardarActionPerformed(ActionEvent e) {
        
          Cliente cliente = new Cliente();
  

    // Verifica si es un nuevo registro o una actualización
    boolean isNewRecord = (idCliente == 0); // true si es nuevo, false si es actualización

    if (vista.jtxtNombre.getText().isEmpty() || vista.jtxtApellido.getText().isEmpty() 
            || vista.jtxtIdentificacion.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "¡Completa todos los campos!");

    } else {
        // Rellenar objeto usuario con los datos del formulario
        cliente.setNombre(vista.jtxtNombre.getText().trim());
        cliente.setApellido(vista.jtxtApellido.getText().trim());
        cliente.setDni(vista.jtxtIdentificacion.getText().trim());
        cliente.setDireccion(vista.jtxtDireccion.getText().trim());
        cliente.setTelefono(vista.jtxtTelefono.getText().trim());
        cliente.setCorreo(vista.jtxtCorreo.getText().trim());
        cliente.setEstado(obtenerEstado());

        if (isNewRecord) {
            // Nuevo registro
            if (!existeCliente(cliente.getDni())) {
                if (guardar(cliente)) {
                    JOptionPane.showMessageDialog(null, "¡Usuario Registrado!");
                    CargarTablaClientes();
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al registrar usuario!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El Cliente ya está registrado, ingrese otro.");
            }
        } else {
            // Actualización de registro existente
            if (actualizar(cliente, idCliente)) {
                JOptionPane.showMessageDialog(null, "¡Datos del usuario actualizados!");
                CargarTablaClientes();
                idCliente = 0; // Resetear el valor de idCliente después de actualizar
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Dni: "+cliente.getDni()+" ya está registrado.");
            }
        } 
   }}
    
    
    
    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent e) {
        
      int selectedRow = vista.jTable_cliente.getSelectedRow();
        if (selectedRow != -1) {
            idCliente = (int) vista.jTable_cliente.getValueAt(selectedRow, 0);

            // Mostrar cuadro de diálogo de confirmación
            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar el cliente?", "Confirmación de eliminación", JOptionPane.YES_NO_OPTION);

            // Si el usuario selecciona "Sí"
            if (opcion == JOptionPane.YES_OPTION) {
                if (eliminar(idCliente)) {
                    JOptionPane.showMessageDialog(null, "¡Cliente Eliminado!");
                    CargarTablaClientes();
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error no se puede eliminar el Cliente!");
                    Limpiar();
                }
            } 
        } else {
            JOptionPane.showMessageDialog(null, "¡Seleccione un cliente!");
        }
    }
    
    
    private void jButton_editarActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = vista.jTable_cliente.getSelectedRow();
        if (selectedRow != -1) {
            idCliente = (int) vista.jTable_cliente.getValueAt(selectedRow, 0);
            EnviarDatosClienteSeleccionado(idCliente);
        } else {
            System.out.println("No se ha seleccionado ningún cliente.");
        }
    }
    
    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
       
         
         Limpiar();
         
         vista.jtxtNombre.requestFocus();
         
         
    }    
    
    
    
    
    
    
    /**
     * **************************************************
     * metodo para guardar un nuevo clientw
     * **************************************************
     */
    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cliente values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getDni());
            consulta.setString(5, objeto.getDireccion());
            consulta.setString(6, objeto.getTelefono());
            consulta.setString(7, objeto.getCorreo());
            consulta.setInt(8, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e);
        }
        return respuesta;
    }

    /**
     * ********************************************************************
     * metodo para consultar si el producto ya esta registrado en la BBDD
     * ********************************************************************
     */
    public boolean existeCliente(String dni) {
        boolean respuesta = false;
        String sql = "select dni from tb_cliente where dni = '" + dni + "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar cliente: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para actualizar un cliente
     * **************************************************
     */
    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_cliente set nombre=?, apellido = ?, identificacion = ?, direccion = ?, telefono= ?, correo = ?, estado = ? where idCliente ='" + idCliente + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getDni());
            consulta.setString(4, objeto.getDireccion());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getCorreo());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para eliminar un cliente
     * **************************************************
     */
    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            // Cambiar el estado a "0" en lugar de eliminar el registro
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE tb_cliente SET estado = 0 WHERE idCliente = ?");
            consulta.setInt(1, idCliente); // Usar parámetros para evitar SQL injection

            // Ejecutar la actualización
            if (consulta.executeUpdate() > 0) {
                respuesta = true; // La actualización fue exitosa
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cambiar el estado del cliente: " + e);
        }
        return respuesta; // Retornar si la operación fue exitosa
    }
    
    private void Limpiar() {
        
        vista.jtxtNombre.setText("");
        vista.jtxtApellido.setText("");
        vista.jtxtIdentificacion.setText("");
        vista.jtxtDireccion.setText("");
        vista.jtxtTelefono.setText("");
        vista.jtxtCorreo.setText("");
        
        vista.jComboBox_estado.setSelectedIndex(0);
        
        idCliente=0;
    }
/*
 * *****************************************************
 * método para mostrar todos los clientes registrados
 * *****************************************************
 */
private void CargarTablaClientes() {
    Connection con = Conexion.conectar();
    DefaultTableModel model = new DefaultTableModel();
    // Modificar la consulta para seleccionar solo los clientes con estado "1"
    String sql = "SELECT * FROM tb_cliente WHERE estado = 1";
    Statement st;
    try {
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        InterGestionarCliente.jTable_cliente = new JTable(model);
        InterGestionarCliente.jScrollPane1.setViewportView(InterGestionarCliente.jTable_cliente);

        model.addColumn("N°");       // ID
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("DNI");
        model.addColumn("Dirección");
        model.addColumn("Teléfono");
        model.addColumn("Correo");

        while (rs.next()) {
            Object fila[] = new Object[7];
            for (int i = 0; i < 7; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            model.addRow(fila);
        }
        con.close();
    } catch (SQLException e) {
        System.out.println("Error al llenar la tabla clientes: " + e);
    }
}
    
    
    private void EnviarDatosClienteSeleccionado(int idUsuario) {
        try {
            Connection con = Conexion.conectar();
            // Usar parámetros preparados correctamente para evitar inyección SQL
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tb_cliente WHERE idCliente = ?");
            pst.setInt(1, idCliente); // Asignar el parámetro idUsuario
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                vista.jtxtNombre.setText(rs.getString("nombre"));
                vista.jtxtApellido.setText(rs.getString("apellido"));
                vista.jtxtIdentificacion.setText(rs.getString("identificacion"));
                vista.jtxtDireccion.setText(rs.getString("direccion"));
                vista.jtxtTelefono.setText(rs.getString("telefono"));
                vista.jtxtCorreo.setText(rs.getString("correo"));
                
                int estado = rs.getInt("estado");
                    if (estado == 0) {
                        vista.jComboBox_estado.setSelectedItem("Inactivo");
                    } else if (estado == 1) {
                        vista.jComboBox_estado.setSelectedItem("Activo");
                    }

            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar usuario: " + e);
        }
    }

    private int obtenerEstado() {
        String estado = (String) vista.jComboBox_estado.getSelectedItem();
        if ("Activo".equals(estado)) {
            return 1;
        } else if ("Inactivo".equals(estado)) {
            return 0;
        }
        return -1; // Valor por defecto en caso de error
    }

}
