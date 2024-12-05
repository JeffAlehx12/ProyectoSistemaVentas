package controlador;




import com.raven.main.Main;
import conexion.Conexion;
import vista.*;
import java.awt.Dimension;
import java.sql.*;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Ctrl_Auditoria {
    
     InterAuditoria vista;

 
     
     //controlador vacio
    public Ctrl_Auditoria() {
    }

     //controlador con el parametro del interfaz
    public Ctrl_Auditoria(InterAuditoria vista) {
        this.vista = vista;
        init();
    }

    
      //metodo para el inicio del interfaz
    
    private void init() {
        
       
        vista.setSize(new Dimension(1580, 1150));
        vista.setTitle("Registro de Auditoria");
        vista.setVisible(true);
        vista.setLocation(0,0);
       
        CargarTablaAuditoria();
        
         // Evitar que se pueda mover el JInternalFrame
        vista.setResizable(false);  // Deshabilita el redimensionamiento
        vista.setClosable(false);   // Deshabilita la opción de cerrar
        vista.setMaximizable(false); // Deshabilita la opción de maximizar
        vista.setIconifiable(false); // Deshabilita la opción de minimizar

        Main.desktopPane.add(vista);
        // Eliminar la barra de título y los botones de control (Cerrar, Minimizar, Maximizar)
        JInternalFrame jif = vista;
        ((BasicInternalFrameUI) jif.getUI()).setNorthPane(null); // Quita la barra de título

// Quitar el borde adicional alrededor del contenido
        jif.setBorder(BorderFactory.createEmptyBorder());  // Elimina el borde de todo el JInternalFrame

// Fuerza a que se dibuje correctamente el contenido
        jif.revalidate();
        jif.repaint();

        vista.toFront();
        
        vista.toFront();
        
 
        
    }
    
    


    public void CargarTablaAuditoria() {
    DefaultTableModel model = new DefaultTableModel();
    String sql = "SELECT * FROM auditoria"; // Asegúrate de que la tabla 'auditoria' tenga la columna 'usuario'
    Statement st;

    try {
        st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery(sql);
        vista.jTable1 = new JTable(model);
        vista.jScrollPane1.setViewportView(vista.jTable1);

        // Agregar las columnas al modelo
        model.addColumn("ID Auditoría");
        model.addColumn("Usuario");
        model.addColumn("Tabla");
        model.addColumn("Operación");
        model.addColumn("Fecha");
        model.addColumn("ID Registro");
        model.addColumn("Datos Anteriores");
        model.addColumn("Datos Nuevos");

        // Llenar el modelo con los datos obtenidos de la consulta
        while (rs.next()) {
            Object fila[] = new Object[8]; // Ahora son 8 columnas en lugar de 7
            fila[0] = rs.getInt("idAuditoria");
            fila[1] = rs.getString("usuario"); // Agregar el campo usuario
            fila[2] = rs.getString("tabla");
            fila[3] = rs.getString("operacion");
            fila[4] = rs.getTimestamp("fecha");
            fila[5] = rs.getInt("idRegistro");
            fila[6] = rs.getString("datosAnteriores");
            fila[7] = rs.getString("datosNuevos");
            model.addRow(fila);
        }

        // Ajustar ancho de columnas de forma personalizada
        int[] anchos = {10, 150, 80, 80, 100, 50, 450, 450}; // Define los anchos de cada columna
        for (int i = 0; i < vista.jTable1.getColumnCount(); i++) {
            vista.jTable1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        // Cerrar la conexión
        Conexion.conectar().close();
    } catch (SQLException e) {
        System.out.println("Error al llenar la tabla auditoria: " + e);
    }


    // Evento para detectar clic en una fila de la tabla
    vista.jTable1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila_point = vista.jTable1.rowAtPoint(e.getPoint());
            int columna_point = 0; // Supongamos que queremos obtener el ID de la auditoría (columna 0)

            if (fila_point > -1) {
                // Aquí puedes agregar lógica para manejar el clic en la fila
            }
        }
    });
}
    
       

}
