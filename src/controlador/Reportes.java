package controlador;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;


public class Reportes {

    /* ********************************************************************
    * metodo para crear reportes de los clientes registrados en el sistema
    *********************************************************************** */
    public void ReportesClientes() {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        String archivoPDF = ruta + "/Desktop/Reporte_Clientes.pdf";
        PdfWriter.getInstance(documento, new FileOutputStream(archivoPDF));

        // Agregar una imagen de encabezado
        Image header = Image.getInstance("src/img/header1.jpg");
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);

        // Formato al texto
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.add("\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        parrafo.add("Reporte de Clientes \n\n");

        // Abrir el documento
        documento.open();
        documento.add(header);
        documento.add(parrafo);

        // Configuración de la tabla con anchos de columna ajustados
        float[] columnsWidths = {1, 4, 4, 3, 4, 4}; // Los anchos de las columnas (en proporciones)
        PdfPTable tabla = new PdfPTable(columnsWidths); // Crear la tabla con los anchos definidos
        tabla.setWidthPercentage(105); // Ajustar la tabla al 110% del ancho de la página

        // Encabezados de la tabla
        tabla.addCell("ID");
        tabla.addCell("Nombres");
        tabla.addCell("Identificacion");
        tabla.addCell("Telefono");
        tabla.addCell("Direccion");
        tabla.addCell("Correo");

        // Conexión a la base de datos
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select idCliente, concat(nombre, ' ', apellido) as nombres, identificacion, telefono, direccion, correo from tb_cliente");
            ResultSet rs = pst.executeQuery();

            // Llenar la tabla con datos de la base de datos
            while (rs.next()) {
                tabla.addCell(rs.getString("idCliente"));
                tabla.addCell(rs.getString("nombres"));
                tabla.addCell(rs.getString("identificacion"));
                tabla.addCell(rs.getString("telefono"));
                tabla.addCell(rs.getString("direccion"));
                tabla.addCell(rs.getString("correo"));
            }

            // Agregar la tabla al documento
            documento.add(tabla);

        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e);
        }

        // Cerrar el documento
        documento.close();

        // Mostrar mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Reporte creado");

        // Abrir el archivo PDF generado
        if (Desktop.isDesktopSupported()) {
            try {
                File pdfFile = new File(archivoPDF);
                Desktop.getDesktop().open(pdfFile);
            } catch (IOException e) {
                System.out.println("Error al abrir el archivo PDF: " + e);
            }
        }

    } catch (DocumentException e) {
        System.out.println("Error en el documento: " + e);
    } catch (FileNotFoundException e) {
        System.out.println("Error al crear el archivo: " + e);
    } catch (IOException e) {
        System.out.println("Error al manejar el archivo: " + e);
    }
}
      /* ********************************************************************
    * metodo para crear reportes de los categorias registrados en el sistema
    *********************************************************************** */
    public void ReportesCategorias() {
    Document documento = new Document();
    try {
        // Ruta para guardar el archivo
        String ruta = System.getProperty("user.home") + "/Desktop/Reporte_Categorias.pdf";
        PdfWriter.getInstance(documento, new FileOutputStream(ruta));

        // Imagen de encabezado
        Image header = Image.getInstance("src/img/header1.jpg");
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);

        // Título del reporte
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.add("\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        parrafo.add("Reporte de Categorías \n\n");

        documento.open();
        documento.add(header);
        documento.add(parrafo);

        // Configuración de la tabla con anchos ajustados
        float[] columnWidths = {1, 5, 2}; // Proporciones del ancho de las columnas
        PdfPTable tabla = new PdfPTable(columnWidths);
        tabla.setWidthPercentage(100); // Ajustar al ancho de la página

        // Encabezados de la tabla
        tabla.addCell("Código");
        tabla.addCell("Descripción");
        tabla.addCell("Estado");

        // Consulta SQL para obtener los datos de las categorías
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT idCategoria, nombreCategoria, estado FROM tb_categoria");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tabla.addCell(rs.getString("idCategoria")); // Código
                tabla.addCell(rs.getString("nombreCategoria")); // Descripción
                tabla.addCell(rs.getInt("estado") == 1 ? "Activo" : "Inactivo"); // Estado
            }
            documento.add(tabla);

        } catch (SQLException e) {
            System.out.println("Error al generar el reporte de categorías: " + e);
        }

        documento.close();
        JOptionPane.showMessageDialog(null, "Reporte de Categorías creado exitosamente.");

        // Abrir automáticamente el PDF después de generarlo
        File archivo = new File(ruta);
        if (archivo.exists()) {
            Desktop.getDesktop().open(archivo);
        }

    } catch (DocumentException e) {
        System.out.println("Error 1 en: " + e);
    } catch (FileNotFoundException ex) {
        System.out.println("Error 2 en: " + ex);
    } catch (IOException ex) {
        System.out.println("Error 3 en: " + ex);
    }
}
    
    
    
    
    /* ********************************************************************
    * metodo para crear reportes de los productos registrados en el sistema
    *********************************************************************** */
   
   public void ReportesProductos() {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home") + "/Desktop/Reporte_Productos.pdf";
        PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        
        // Encabezado del reporte
        Image header = Image.getInstance("src/img/header1.jpg");
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);
        
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.add("\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        parrafo.add("Reporte de Productos \n\n");

        documento.open();
        documento.add(header);
        documento.add(parrafo);

        // Configuración de la tabla con anchos de columna ajustados
        float[] columnsWidths = {1, 4, 4, 5, 4, 3, 3, 3, 2, 4, 2}; 
        PdfPTable tabla = new PdfPTable(columnsWidths);
        tabla.setWidthPercentage(110); // Ajustar la tabla al ancho total de la página

        // Encabezados de la tabla
        tabla.addCell("ID");
        tabla.addCell("Nombre");
        tabla.addCell("Categoría");
        tabla.addCell("Proveedor");
        tabla.addCell("Ubicación");
        tabla.addCell("Cant.");
        tabla.addCell("P. Costo");
        tabla.addCell("P. Venta");
        tabla.addCell("IGV");
        tabla.addCell("P. Total");
        tabla.addCell("Estado");

        // Consulta SQL para extraer los datos relevantes
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT p.idProducto, p.nombre, c.nombreCategoria, pr.razonSocial, "
                    + "p.ubicacion, p.cantidad_actual, p.precioCosto, p.precioVenta, "
                    + "p.porcentajeIgv, p.precio_total, p.estado "
                    + "FROM tb_producto AS p "
                    + "INNER JOIN tb_categoria AS c ON p.idCategoria = c.idCategoria "
                    + "INNER JOIN tb_proveedor AS pr ON p.idProveedor = pr.idProveedor "
                    + "WHERE p.estado = 1;"); // Filtrar solo productos activos
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tabla.addCell(rs.getString("idProducto")); // ID del producto
                tabla.addCell(rs.getString("nombre")); // Nombre
                tabla.addCell(rs.getString("nombreCategoria")); // Nombre de la categoría
                tabla.addCell(rs.getString("razonSocial")); // Razón social del proveedor
                tabla.addCell(rs.getString("ubicacion")); // Ubicación
                tabla.addCell(rs.getString("cantidad_actual")); // Cantidad actual
                tabla.addCell(String.format("%.2f", rs.getDouble("precioCosto"))); // Precio costo
                tabla.addCell(String.format("%.2f", rs.getDouble("precioVenta"))); // Precio venta
                tabla.addCell(rs.getString("porcentajeIgv") + "%"); // Porcentaje IGV
                tabla.addCell(String.format("%.2f", rs.getDouble("precio_total"))); // Precio total
                tabla.addCell(rs.getInt("estado") == 1 ? "Activo" : "Inactivo"); // Estado
            }
            documento.add(tabla);

        } catch (SQLException e) {
            System.out.println("Error al generar el reporte de productos: " + e);
        }

        documento.close();
        JOptionPane.showMessageDialog(null, "Reporte de Productos creado exitosamente.");

        // Abrir automáticamente el PDF después de generarlo
        File archivo = new File(ruta);
        if (archivo.exists()) {
            Desktop.getDesktop().open(archivo);
        }

    } catch (DocumentException e) {
        System.out.println("Error 1 en: " + e);
    } catch (FileNotFoundException ex) {
        System.out.println("Error 2 en: " + ex);
    } catch (IOException ex) {
        System.out.println("Error 3 en: " + ex);
    }
}
    
      
    public void ReportesVentas() {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home") + "/Desktop/Reporte_Ventas.pdf";
        PdfWriter.getInstance(documento, new FileOutputStream(ruta));

        // Encabezado del reporte
        Image header = Image.getInstance("src/img/header1.jpg");
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);

        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.add("\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        parrafo.add("Reporte Detallado de Ventas \n\n");

        documento.open();
        documento.add(header);
        documento.add(parrafo);

        // Configuración de la tabla con anchos de columna ajustados
        float[] columnWidths = {2, 4, 4, 3, 4, 3, 4}; // Anchos ajustados para la tabla con una nueva columna para Total
        PdfPTable tabla = new PdfPTable(columnWidths);
        tabla.setWidthPercentage(100); // Ajustar al ancho de la página

        // Encabezados de la tabla
        tabla.addCell("ID Venta");
        tabla.addCell("Cliente");
        tabla.addCell("Producto");
        tabla.addCell("Cantidad");
        tabla.addCell("Precio Unitario");
        tabla.addCell("IGV");
        tabla.addCell("Total"); // Nueva columna

        // Consulta SQL para extraer los datos relevantes
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT cv.idCabeceraVenta, CONCAT(c.nombre, ' ', c.apellido) AS cliente, "
                    + "p.nombre AS producto, dv.cantidad, dv.precioUnitario, dv.igv "
                    + "FROM tb_cabecera_venta AS cv "
                    + "JOIN tb_cliente AS c ON cv.idCliente = c.idCliente "
                    + "JOIN tb_detalle_venta AS dv ON cv.idCabeceraVenta = dv.idCabeceraVenta "
                    + "JOIN tb_producto AS p ON dv.idProducto = p.idProducto;"
            );
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                double precioUnitario = rs.getDouble("precioUnitario");
                double igv = rs.getDouble("igv");
                double total = precioUnitario + igv; // Calcular el total

                tabla.addCell(rs.getString("idCabeceraVenta")); // ID Venta
                tabla.addCell(rs.getString("cliente")); // Cliente
                tabla.addCell(rs.getString("producto")); // Producto
                tabla.addCell(String.valueOf(rs.getInt("cantidad"))); // Cantidad
                tabla.addCell("S/ " + precioUnitario); // Precio Unitario
                tabla.addCell("S/ " + igv); // IGV
                tabla.addCell("S/ " + total); // Total (Precio + IGV)
            }

            documento.add(tabla);

        } catch (SQLException e) {
            System.out.println("Error al generar el reporte de ventas: " + e);
        }

        documento.close();
        JOptionPane.showMessageDialog(null, "Reporte Detallado de Ventas creado exitosamente.");

        // Abrir automáticamente el PDF después de generarlo
        File archivo = new File(ruta);
        if (archivo.exists()) {
            Desktop.getDesktop().open(archivo);
        }

    } catch (DocumentException e) {
        System.out.println("Error en: " + e);
    } catch (FileNotFoundException ex) {
        System.out.println("Error 2 en: " + ex);
    } catch (IOException ex) {
        System.out.println("Error 3 en: " + ex);
    }
}
}
