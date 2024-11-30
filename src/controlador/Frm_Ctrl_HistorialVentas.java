package controlador;

import com.raven.main.Main;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import vista.FromMenu;
import vista.InterGraficaVentas_prueba;
import vista.InterHistorialVentas;



public class Frm_Ctrl_HistorialVentas {
  
    InterHistorialVentas vista;
    
    public static String fecha_inicio = "", fecha_fin = "";

    
    public Frm_Ctrl_HistorialVentas() {
        
        
    }
   

    
    public Frm_Ctrl_HistorialVentas(InterHistorialVentas vista) {
        
        this.vista = vista;
        
        init();
        
    }
    
   
    
    private void init() {
       
        
        vista.setSize(new Dimension(567, 403));
        vista.setTitle("Historial de Ventas");
        vista.setVisible(true);
        vista.setLocation(200, 50);
        
        
        vista.toFront();
        // Cargar clientes y productos en la vista desde el controlador
       
        
        
        
        
        

        vista.jButton_Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton_GuardarActionPerformed(e);
            }
        });
        
    }
    
    

    //proceso de botones...
    
    // Método para convertir las fechas al formato SQL
         private String convertToSQLDate(Date date) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        return outputFormat.format(date);
    }

    // Método jButton_GuardarActionPerformed modificado
    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener las fechas directamente como Date
        Date fechaInicioDate = vista.jDateChooser_fecha_inicio.getDate();
        Date fechaFinDate = vista.jDateChooser_fecha_fin.getDate();

        // Convertir las fechas al formato SQL
        fecha_inicio = convertToSQLDate(fechaInicioDate);
        fecha_fin = convertToSQLDate(fechaFinDate);

        // Mostrar la vista de gráfico de ventas
        InterGraficaVentas_prueba interGraficaVentas_prueba = new InterGraficaVentas_prueba();
        Main.desktopPane.add(interGraficaVentas_prueba);
        interGraficaVentas_prueba.setVisible(true);
        interGraficaVentas_prueba.setTitle("Historial de Ventas");
        interGraficaVentas_prueba.setVisible(true);
        interGraficaVentas_prueba.setLocation(850, 50);
    }
    
    
    
}
