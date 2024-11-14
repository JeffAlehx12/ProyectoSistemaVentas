package controlador;

import conexion.Conexion;

import java.awt.Dimension;
import vista.FromMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import vista.InterGraficaVentas_prueba;



public class Frm_Ctrl_GraficoVentas {
    InterGraficaVentas_prueba vista;

    public ArrayList<Integer> listaCantidad = new ArrayList<>();
    public ArrayList<String> listaFechas = new ArrayList<>();
    int cantidadResultados = 0;
    String[] vector_fechaVenta;
    int[] vector_estatus_cantidad;

    public Frm_Ctrl_GraficoVentas() {
    }

    public Frm_Ctrl_GraficoVentas(InterGraficaVentas_prueba vista) {
        this.vista = vista;
        init();
    }

    private void init() {
        
        vista.setSize(new Dimension(550, 650));
        vista.setTitle("Historial de Ventas");
        vista.setVisible(true);
        vista.setLocation(1000, 50);

        FromMenu.desktopPane.add(vista); // Añadir al JDesktopPane
        vista.toFront();
        // Cargar clientes y productos en la vista desde el controlador

        MetodoContador();
        MetodoAlmacenaDatos();

        vector_fechaVenta = new String[cantidadResultados];
        vector_estatus_cantidad = new int[cantidadResultados];
    }

    // Método para convertir las fechas al formato SQL
    private String convertToSQLDate(String dateStr) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd MMM. yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = inputFormat.parse(dateStr);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Métodos

    // Método para determinar la cantidad de resultados a graficar
    private int MetodoContador() {
        try {
            Connection cn = Conexion.conectar();
            String fechaInicio = convertToSQLDate(Frm_Ctrl_HistorialVentas.fecha_inicio);
            String fechaFin = convertToSQLDate(Frm_Ctrl_HistorialVentas.fecha_fin);
            
            if (fechaInicio != null && fechaFin != null) {
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT fechaVenta, COUNT(fechaVenta) AS Ventas FROM tb_cabecera_venta "
                        + "WHERE fechaVenta BETWEEN ? AND ? GROUP BY fechaVenta;");
                pst.setString(1, fechaInicio);
                pst.setString(2, fechaFin);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    cantidadResultados++;
                }
                cn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error en: " + e);
        }
        return cantidadResultados;
    }

    // Método para almacenar en las listas los datos a graficar
    private void MetodoAlmacenaDatos() {
        try {
            Connection cn = Conexion.conectar();
            String fechaInicio = convertToSQLDate(Frm_Ctrl_HistorialVentas.fecha_inicio);
            String fechaFin = convertToSQLDate(Frm_Ctrl_HistorialVentas.fecha_fin);
            
            if (fechaInicio != null && fechaFin != null) {
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT fechaVenta, COUNT(fechaVenta) AS Ventas FROM tb_cabecera_venta "
                        + "WHERE fechaVenta BETWEEN ? AND ? GROUP BY fechaVenta;");
                pst.setString(1, fechaInicio);
                pst.setString(2, fechaFin);
                ResultSet rs = pst.executeQuery();
                int contador = 0;
                while (rs.next()) {
                    vector_fechaVenta[contador] = rs.getString("fechaVenta");
                    listaFechas.add(vector_fechaVenta[contador]);
                    vector_estatus_cantidad[contador] = rs.getInt("Ventas");
                    listaCantidad.add(vector_estatus_cantidad[contador]);

                    contador++;
                }
                cn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error en: " + e);
        }
    }
    
    
}