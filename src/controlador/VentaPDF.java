package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.PreparedStatement;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Configuracion;
import vista.InterFacturacion;


public class VentaPDF {

    private String nombreCliente;
    private String dniCliente;
    private String telefonoCliente;
    private String direccionCliente;

    private String fechaActual = "";
    private String nombreArchivoPDFVenta = "";

    // Método para obtener datos del cliente
     public void DatosCliente(int idCliente) {
        try (Connection cn = Conexion.conectar()) {
            String sql = "select * from tb_cliente where idCliente = ?";
            try (PreparedStatement st = (PreparedStatement) cn.prepareStatement(sql)) {
                st.setInt(1, idCliente);
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
                        dniCliente = rs.getString("identificacion");
                        telefonoCliente = rs.getString("telefono");
                        direccionCliente = rs.getString("direccion");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron datos del cliente.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: " + e);
        }
    }

    // Método para generar la factura de venta
    public void generarFacturaPDF(int IdCliente,String numeroFactura, String fechaActual) {
        
        DatosCliente(IdCliente); // Ejemplo: obtener datos del cliente con ID 1

        if (nombreCliente == null || dniCliente == null || telefonoCliente == null || direccionCliente == null) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos del cliente.");
            return;
        }

        Configuracion config = obtenerConfiguracion();
        if (config == null) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos de la empresa.");
            return;
        }

        try {
            // Cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            // Cambiar el formato de la fecha de / a _
            String fechaNueva = fechaActual.replace("/", "_");

            nombreArchivoPDFVenta = "Venta_" + nombreCliente + "_" + fechaNueva + ".pdf";

            File file = new File("src/pdf/");
            if (!file.exists()) {
                file.mkdirs();
            }

            File archivo = new File(file, nombreArchivoPDFVenta);
            try (FileOutputStream fos = new FileOutputStream(archivo)) {
                Document doc = new Document();
                PdfWriter.getInstance(doc, fos);
                doc.open();

                
                Image img = Image.getInstance("src/img/ventas.png");
                Paragraph fecha = new Paragraph();
                Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
                fecha.add(Chunk.NEWLINE); // agregar nueva línea
                fecha.add("Factura: " + numeroFactura + "\nFecha: " + fechaActual + "\n\n");

                PdfPTable Encabezado = new PdfPTable(4);
                Encabezado.setWidthPercentage(100);
                Encabezado.getDefaultCell().setBorder(0); // quitar el borde de la tabla
                // tamaño de las celdas
                float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
                Encabezado.setWidths(ColumnaEncabezado);
                Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
                // agregar celdas
                Encabezado.addCell(img);

                String ruc = config.getRuc();
                String nombre = config.getNombre();
                String telefono = config.getTelefono();
                String direccion = config.getDireccion();
                String razon = config.getRazon();

                Encabezado.addCell(""); // celda vacía
                Encabezado.addCell("RUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELÉFONO: " + telefono + "\nDIRECCIÓN: " + direccion + "\nRAZÓN SOCIAL: " + razon);
                Encabezado.addCell(fecha);
                doc.add(Encabezado);

                // CUERPO
                Paragraph cliente = new Paragraph();
                cliente.add(Chunk.NEWLINE); // nueva línea
                cliente.add("Datos del cliente: " + "\n\n");
                doc.add(cliente);

                // DATOS DEL CLIENTE
                PdfPTable tablaCliente = new PdfPTable(4);
                tablaCliente.setWidthPercentage(100);
                tablaCliente.getDefaultCell().setBorder(0); // quitar bordes
                // tamaño de las celdas
                float[] ColumnaCliente = new float[]{25f, 45f, 30f, 40f};
                tablaCliente.setWidths(ColumnaCliente);
                tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
                PdfPCell cliente1 = new PdfPCell(new Phrase("Cédula/RUC: ", negrita));
                PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
                PdfPCell cliente3 = new PdfPCell(new Phrase("Teléfono: ", negrita));
                PdfPCell cliente4 = new PdfPCell(new Phrase("Dirección: ", negrita));
                // quitar bordes 
                cliente1.setBorder(0);
                cliente2.setBorder(0);
                cliente3.setBorder(0);
                cliente4.setBorder(0);
                // agregar celdas a la tabla
                tablaCliente.addCell(cliente1);
                tablaCliente.addCell(cliente2);
                tablaCliente.addCell(cliente3);
                tablaCliente.addCell(cliente4);
                tablaCliente.addCell(dniCliente);
                tablaCliente.addCell(nombreCliente);
                tablaCliente.addCell(telefonoCliente);
                tablaCliente.addCell(direccionCliente);
                // agregar al documento
                doc.add(tablaCliente);

                // ESPACIO EN BLANCO
                Paragraph espacio = new Paragraph();
                espacio.add(Chunk.NEWLINE);
                espacio.add("");
                espacio.setAlignment(Element.ALIGN_CENTER);
                doc.add(espacio);

                // AGREGAR LOS PRODUCTOS
                PdfPTable tablaProducto = new PdfPTable(4);
                tablaProducto.setWidthPercentage(100);
                tablaProducto.getDefaultCell().setBorder(0);
                // tamaño de celdas
                float[] ColumnaProducto = new float[]{15f, 50f, 15f, 20f};
                tablaProducto.setWidths(ColumnaProducto);
                tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
                
                PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
                PdfPCell producto2 = new PdfPCell(new Phrase("Descripción: ", negrita));
                PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
                PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: ", negrita));
                // quitar bordes
                producto1.setBorder(0);
                producto2.setBorder(0);
                producto3.setBorder(0);
                producto4.setBorder(0);
                // agregar color al encabezado del producto
                producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                // agregar celdas a la tabla
                tablaProducto.addCell(producto1);
                tablaProducto.addCell(producto2);
                tablaProducto.addCell(producto3);
                tablaProducto.addCell(producto4);

                for (int i = 0; i < InterFacturacion.jTable_productos.getRowCount(); i++) {
                    String producto = InterFacturacion.jTable_productos.getValueAt(i, 1).toString();
                    String cantidad = InterFacturacion.jTable_productos.getValueAt(i, 2).toString();
                    String precio = InterFacturacion.jTable_productos.getValueAt(i, 3).toString();
                    String total = InterFacturacion.jTable_productos.getValueAt(i, 7).toString();

                    tablaProducto.addCell(cantidad);
                    tablaProducto.addCell(producto);
                    tablaProducto.addCell(precio);
                    tablaProducto.addCell(total);
                }
                // agregar al documento
                doc.add(tablaProducto);

                // Total pagar
                Paragraph info = new Paragraph();
                info.add(Chunk.NEWLINE);
                info.add("Total a pagar: " + InterFacturacion.txt_total_pagar.getText());
                info.setAlignment(Element.ALIGN_RIGHT);
                doc.add(info);

                // Firma
                Paragraph firma = new Paragraph();
                firma.add(Chunk.NEWLINE);
                firma.add("Cancelación y firma\n\n");
                firma.add("_______________________");
                firma.setAlignment(Element.ALIGN_CENTER);
                doc.add(firma);

                // Mensaje
                Paragraph mensaje = new Paragraph();
                mensaje.add(Chunk.NEWLINE);
                mensaje.add("¡Gracias por su compra!");
                mensaje.setAlignment(Element.ALIGN_CENTER);
                doc.add(mensaje);

                // cerrar el documento
                doc.close();
            }
            // abrir el documento al ser generado automáticamente
            Desktop.getDesktop().open(archivo);
        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }

    public Configuracion obtenerConfiguracion() {
        try (Connection cn = Conexion.conectar();
             PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("SELECT * FROM Configuracion WHERE id = 1");
             ResultSet rs = consulta.executeQuery()) {
            if (rs.next()) {
                return new Configuracion(
                        rs.getString("ruc"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("razon")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener configuración: " + e);
        }
        return null;
    }


}
