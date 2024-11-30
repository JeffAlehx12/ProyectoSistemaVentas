package controlador;

import conexion.Conexion;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;
import static vista.InterFacturacion.txt_total_pagar;




public class Frm_Ctrl_RegistrarVenta {
  
     InterFacturacion vista;

// último ID de la cabecera registrada
    public javax.swing.JTable jTable_productos;
    private javax.swing.table.DefaultTableModel modeloDatosProductos;
     
    public static int idCabeceraRegistrada;
    java.math.BigDecimal iDColVar;
   
      //Modelo de los datos
   
    //lista para el detalle de venta de los productos
    ArrayList<DetalleVenta> listaProductos = new ArrayList<>();
    private DetalleVenta producto;

    private int idCliente = 0;//id del cliente sleccionado

    private int idProducto = 0;
    private String nombre ="";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;
    private int porcentajeIva = 0;

    private int cantidad = 0;//cantidad de productos a comprar
    private double subtotal = 0.0;//cantidad por precio
    private double descuento = 0.0;
    private double iva = 0.0;
    private double totalPagar = 0.0;

    //variables para calculos globales
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double ivaGeneral = 0.0;
    private double totalPagarGeneral = 0.0;
    //fin de variables de calculos globales

    private int auxIdDetalle = 1;//id del detalle de venta
    
    //fin de variables de calculos globales
    
   

    public Frm_Ctrl_RegistrarVenta() {
        
    }
    
    
    public Frm_Ctrl_RegistrarVenta(InterFacturacion vista) {
        
        this.vista = vista;
        
        init();
        
    }
    
   
    
    private void init() {
       
        vista.setSize(new Dimension(1580, 880));
        vista.setTitle("Facturación");
        vista.setVisible(true);
        vista.setLocation(0, 0);
        
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
        // Cargar clientes y productos en la vista desde el controlador
        CargarComboClientes();
        CargarComboProductos();
         // Inicializar la tabla de productos
        inicializarTablaProducto();
        // Configuración inicial de los componentes
        
        vista.txt_subtotal.setText("0.0");
        vista.txt_iva.setText("0.0");
        vista.txt_descuento.setText("0.0");
        InterFacturacion.txt_total_pagar.setText("0.0");
        
        vista.txt_efectivo.setEnabled(false);
        vista.jButton_calcular_cambio.setEnabled(false);
        
        //insertar imagen en nuestro JLabel
        
        ///
        
        
        
        
       
        
        vista.jButton_busca_cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton_busca_clienteActionPerformed(e);

            }
        });
        
        
        // Botones y sus acciones
        vista.jButton_añadir_producto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton_añadir_productoActionPerforme(e);
            }
        });

        vista.jButton_RegistrarVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton_RegistrarVentaActionPerforme(e);
            }
        });

        vista.jButton_calcular_cambio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton_calcular_cambioActionPerformed(e);
            }
        });
        
        
        InterFacturacion.jTable_productos.addMouseListener(new MouseAdapter() {
          
            @Override
            public void mouseClicked(MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        
          vista.jComboBox_cliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                // Llamar al método para cargar los clientes cuando se haga clic en el combo
                jComboBox_clienteMouseClicked(evt);
            }
        });
          
          vista.jComboBox_producto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                // Llamar al método para cargar los clientes cuando se haga clic en el combo
                jComboBox_productoMouseClicked(evt);
            }
        });
        
    }
    
      private void jComboBox_clienteMouseClicked(java.awt.event.MouseEvent evt) {                                               
        CargarComboClientes();
    }  
      
       private void jComboBox_productoMouseClicked(java.awt.event.MouseEvent evt) {                                               
        CargarComboProductos();
    }  
    
    //metodo para inicializar la tabla de los productos
    private void inicializarTablaProducto() {
        modeloDatosProductos = new DefaultTableModel();
        //añadir columnas
        modeloDatosProductos.addColumn("N");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("SubTotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("Iva/und");
        modeloDatosProductos.addColumn("Total Pagar");
        modeloDatosProductos.addColumn("Accion");
        //agregar los datos del modelo a la tabla
        vista.jTable_productos.setModel(modeloDatosProductos);
         
    }
    

    //proceso de botones...
    
    
    private void jButton_busca_clienteActionPerformed(java.awt.event.ActionEvent evt) { 
    
        String clienteBuscar = vista.txt_cliente_buscar.getText().trim();
        Connection cn = Conexion.conectar();
        String sql = "select nombre, apellido from tb_cliente where identificacion = '" + clienteBuscar + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                vista.jComboBox_cliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                vista.jComboBox_cliente.setSelectedItem("Seleccione cliente:");
                JOptionPane.showMessageDialog(null, "¡Dni de cliente incorrecta o no encontrada!");
            }
            vista.txt_cliente_buscar.setText("");
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al buscar cliente!, " + e);
        }
    
    }
    
    
        private void jButton_añadir_productoActionPerforme(ActionEvent evt) {
          String combo = vista.jComboBox_producto.getSelectedItem().toString();
  // Validar que seleccione un producto
          if (combo.equalsIgnoreCase("Seleccione producto:")) {
              JOptionPane.showMessageDialog(null, "Seleccione un producto");
          } else {
              // Validar que ingrese una cantidad
            if (!vista.txt_cantidad.getText().isEmpty()) {
                // Validar que el usuario no ingrese caracteres no numéricos
                boolean validacion = validar(vista.txt_cantidad.getText());
                if (validacion == true) {
                    // Validar que la cantidad sea mayor a cero
                    if (Integer.parseInt(vista.txt_cantidad.getText()) > 0) {
                        cantidad = Integer.parseInt(vista.txt_cantidad.getText());
                        // Ejecutar método para obtener datos del producto
                        DatosDelProducto();
                        // Validar que la cantidad de productos seleccionado no sea mayor al stock de la base de datos
                        if (cantidad <= cantidadProductoBBDD) {
                            
                            boolean productoExiste = false;

                            // Verificar si el producto ya está en la lista
                            for (DetalleVenta prod : listaProductos) {
                                if (prod.getIdProducto() == idProducto) {
                                    
                                    // Actualizar la cantidad del producto existente
                                    int nuevaCantidad = cantidad;
                                    if (nuevaCantidad <= cantidadProductoBBDD) {
                                        prod.setCantidad(nuevaCantidad);
                                        
                                        
                                        // Recalcular los valores
                                        
                                        prod.setSubtotal(prod.getPrecioUnitario() * nuevaCantidad);
                                        iva = iva;
                                        prod.setTotalPagar(prod.getSubtotal() + (prod.getIva()*nuevaCantidad) - prod.getDescuento());
                                        
                                        // Redondear decimales
                                        prod.setSubtotal((double) Math.round(prod.getSubtotal() * 100) / 100);
                                        prod.setTotalPagar((double) Math.round(prod.getTotalPagar() * 100) / 100);
                                         
                                         
                                        JOptionPane.showMessageDialog(null, "Cantidad de producto actualizada");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La cantidad total supera el Stock");
                                    }
                                    productoExiste = true;
                                    break;
                                }
                            }

                            // Si el producto no está en la lista, agregarlo como nuevo
                            if (!productoExiste) {
                                
                                subtotal = precioUnitario * cantidad;
                                iva = iva/cantidad;
                                totalPagar = subtotal + (iva*cantidad) - descuento;

                                // Redondear decimales
                                subtotal = (double) Math.round(subtotal * 100) / 100;
                                iva = (double) Math.round(iva * 100) / 100;
                                descuento = (double) Math.round(descuento * 100) / 100;
                                totalPagar = (double) Math.round(totalPagar * 100) / 100;

                                // Crear un nuevo producto
                                producto = new DetalleVenta(auxIdDetalle, // idDetalleVenta
                                        1, // idCabecera
                                        idProducto,
                                        nombre,
                                        Integer.parseInt(vista.txt_cantidad.getText()),
                                        precioUnitario,
                                        subtotal,
                                        descuento,
                                        iva,
                                        totalPagar,
                                        1 // estado
                                );
                                // Añadir a la lista
                                listaProductos.add(producto);
                                JOptionPane.showMessageDialog(null, "Producto Agregado");
                                auxIdDetalle++;
                            }

                            vista.txt_cantidad.setText(""); // Limpiar el campo
                            // Volver a cargar combo productos
                            CargarComboProductos();
                            CalcularTotalPagar();
                            vista.txt_efectivo.setEnabled(true);
                            vista.jButton_calcular_cambio.setEnabled(true);

                            // Actualizar la tabla
                            listaTablaProductos();
                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad supera el Stock");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero (0), ni negativa");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numéricos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa la cantidad de productos");
            }
        }
    }

    
    
    private void jButton_RegistrarVentaActionPerforme(ActionEvent evt) {
        
    CabeceraVenta cabeceraVenta = new CabeceraVenta();
    DetalleVenta detalleVenta = new DetalleVenta();
    

    String fechaActual = "";
    Date date = new Date();
    fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

    if (!vista.jComboBox_cliente.getSelectedItem().equals("Seleccione cliente:")) {
        if (listaProductos.size() > 0) {
            // Método para obtener el ID del cliente
            this.ObtenerIdCliente();
            
            // Obtener datos del cliente
            VentaPDF pdf = new VentaPDF();
            pdf.DatosCliente(idCliente);
            
           
            // Verificar si se obtuvieron los datos de la empresa
            Configuracion config = pdf.obtenerConfiguracion();
            if (config == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos de la empresa.");
                return;
            }

            // Registrar cabecera
            cabeceraVenta.setIdCabeceraventa(0);
            cabeceraVenta.setIdCliente(idCliente);
            cabeceraVenta.setValorPagar(Double.parseDouble(txt_total_pagar.getText()));
            cabeceraVenta.setFechaVenta(fechaActual);
            cabeceraVenta.setEstado(1);

            if (guardar(cabeceraVenta)) {
                JOptionPane.showMessageDialog(null, "¡Venta Registrada!");

                int ultimoIdCabeceraVenta = obtenerUltimoidCabeceraVenta();
                String numeroFactura = String.format("001-%05d",ultimoIdCabeceraVenta);

                

                // Generar la factura de venta
                pdf.generarFacturaPDF(idCliente,numeroFactura,fechaActual);

                // Guardar detalle
                for (DetalleVenta elemento : listaProductos) {
                    detalleVenta.setIdDetalleVenta(0);
                    detalleVenta.setIdCabeceraVenta(0);
                    detalleVenta.setIdProducto(elemento.getIdProducto());
                    detalleVenta.setCantidad(elemento.getCantidad());
                    detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
                    detalleVenta.setSubtotal(elemento.getSubtotal());
                    detalleVenta.setDescuento(elemento.getDescuento());
                    detalleVenta.setIva(elemento.getIva());
                    detalleVenta.setTotalPagar(elemento.getTotalPagar());
                    detalleVenta.setEstado(1);

                    if (guardarDetalle(detalleVenta)) {
                        // Limpiar campos de vista
                        vista.txt_subtotal.setText("0.0");
                        vista.txt_iva.setText("0.0");
                        vista.txt_descuento.setText("0.0");
                        txt_total_pagar.setText("0.0");
                        vista.txt_efectivo.setText("");
                        vista.txt_cambio.setText("0.0");
                        auxIdDetalle = 1;

                        this.CargarComboClientes();
                        

                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error al guardar detalle de venta!");
                    }
                }
                // Vaciar la lista
                listaProductos.clear();
                listaTablaProductos();

            } else {
                JOptionPane.showMessageDialog(null, "¡Error al guardar cabecera de venta!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
        }
    } else {
        JOptionPane.showMessageDialog(null, "¡Seleccione un cliente!");
    }

}

    
     private void jButton_calcular_cambioActionPerformed(java.awt.event.ActionEvent evt) {   
     
     
         if (!vista.txt_efectivo.getText().isEmpty()) {
            //validamos que el usuario no ingrese otros caracteres no numericos 
            boolean validacion = validarDouble(vista.txt_efectivo.getText());
            if (validacion == true) {
                //validar que el efectivo sea mayor a cero
                double efc = Double.parseDouble(vista.txt_efectivo.getText().trim());
                double top = Double.parseDouble(vista.txt_total_pagar.getText().trim());

                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "El Dinero en efectivo no es suficiente");
                } else {
                    double cambio = (efc - top);
                    double cambi = (double) Math.round(cambio * 100d) / 100;
                    String camb = String.valueOf(cambi);
                    vista.txt_cambio.setText(camb);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No de admiten caracteres no numericos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo para calcular cambio");
        }
         
     
     }
     
     
     
     int idArrayList = 0;
     
     
    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {
        
        int fila_point = InterFacturacion.jTable_productos.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar Producto?");
        //opciones de confir dialog - (si = 0; no = 1; cancel = 2; close = -1)
        switch (opcion) {
            case 0: //presione si
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar(); // Recalcular todos los totales incluyendo el IVA
                this.listaTablaProductos(); // Actualizar la tabla con los nuevos valores
                break;
            case 1: //presione no
                break;
            default://sea que presione cancel (2) o close (-1)
                break;
                
        }
    }
    
    
     private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /*
     //metodo para restar la cantidad (stock) de los productos vendidos
    private void RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductosBaseDeDatos = 0;
        try {
            Connection cn = Conexion.conectar();
            String sql = "select idProducto, cantidad_actual from tb_producto where idProducto = '" + idProducto + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProductosBaseDeDatos = rs.getInt("cantidad_actual");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 1, " + e);
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement consulta = cn.prepareStatement("update tb_producto set cantidad_actual=? where idProducto = '" + idProducto + "'");
            int cantidadNueva = cantidadProductosBaseDeDatos - cantidad;
            consulta.setInt(1, cantidadNueva);
            if(consulta.executeUpdate() > 0){
                //System.out.println("Todo bien");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 2, " + e);
        }
    }
    */
    
    ////////////////luego cambiarlo al de inventario///////////////////////
    
    
    private void DatosDelProducto() {
        try {
            String sql = "select * from tb_producto where nombre = '" + vista.jComboBox_producto.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("cantidad_actual");
                precioUnitario = rs.getDouble("precioVenta");
                porcentajeIva = rs.getInt("porcentajeIgv");
                CalcularIgv(precioUnitario, porcentajeIva);//calcula y retorna el iva
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto, " + e);
        }
    }
    
    
    /*
        Metodo para calcular iva
     */
    private double CalcularIgv(double precio, int porcentajeIva) {
        int p_igv = porcentajeIva;

        switch (p_igv) {
            case 0:
                iva = 0.0;
                break;
            case 18:
                iva = (precioUnitario * cantidad) * 0.18;
                break;
            
        }

        return iva;
    }
    
    
    
    
    /*
    Metodo para calcular el total a pagar de todos los productos agregados
     */
    private void CalcularTotalPagar() {
    DecimalFormat df = new DecimalFormat("#.##");
    double subtotalGeneral = 0;
    double descuentoGeneral = 0;
    double ivaGeneral = 0;
    double totalPagarGeneral = 0;
    int totalProductos = 0;

    for (DetalleVenta elemento : listaProductos) {
        subtotalGeneral += elemento.getSubtotal();
        descuentoGeneral += elemento.getDescuento();
        ivaGeneral += elemento.getIva() * elemento.getCantidad(); // Multiplicar el IVA por la cantidad de productos
        totalProductos += elemento.getCantidad(); // Sumar la cantidad de productos
    }

    // Calcular el total a pagar general
    totalPagarGeneral = subtotalGeneral + ivaGeneral - descuentoGeneral;

    // Redondear decimales usando DecimalFormat
    subtotalGeneral = Double.parseDouble(df.format(subtotalGeneral));
    ivaGeneral = Double.parseDouble(df.format(ivaGeneral));
    descuentoGeneral = Double.parseDouble(df.format(descuentoGeneral));
    totalPagarGeneral = Double.parseDouble(df.format(totalPagarGeneral));

    // Enviar datos a la vista
    vista.txt_subtotal.setText(df.format(subtotalGeneral));
    vista.txt_iva.setText(df.format(ivaGeneral));
    vista.txt_descuento.setText(df.format(descuentoGeneral));
    InterFacturacion.txt_total_pagar.setText(df.format(totalPagarGeneral));
}




    
   /*
    Método para cargar los productos en el jComboBox
 */
public void CargarComboProductos() {
    Connection cn = Conexion.conectar();
    // Filtrar solo los productos con estado "1"
    String sql = "SELECT * FROM tb_producto WHERE estado = 1";  
    Statement st;
    try {
        st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        vista.jComboBox_producto.removeAllItems();
        vista.jComboBox_producto.addItem("Seleccione producto:");
        while (rs.next()) {
            vista.jComboBox_producto.addItem(rs.getString("nombre"));
        }
        cn.close();
    } catch (SQLException e) {
        System.out.println("¡Error al cargar productos! " + e);
    }
}

/*
    Método para cargar los clientes en el jComboBox
 */
private void CargarComboClientes() {
    Connection cn = Conexion.conectar();
    // Filtrar solo los clientes con estado "1"
    String sql = "SELECT * FROM tb_cliente WHERE estado = 1";  
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
        System.out.println("¡Error al cargar clientes! " + e);
    }
}
    
    //metodo para presentar la informacion de la tavla DetalleVenta
   private void listaTablaProductos() {
    this.modeloDatosProductos.setRowCount(listaProductos.size());
    for (int i = 0; i < listaProductos.size(); i++) {
        DetalleVenta producto = listaProductos.get(i);

        // Redondear valores
        DecimalFormat df = new DecimalFormat("#.##");
        producto.setSubtotal(Double.parseDouble(df.format(producto.getSubtotal())));
        producto.setIva(Double.parseDouble(df.format(producto.getIva())));
        producto.setTotalPagar(Double.parseDouble(df.format(producto.getTotalPagar())));

        // Actualizar la fila en la tabla
        this.modeloDatosProductos.setValueAt(i + 1, i, 0);
        this.modeloDatosProductos.setValueAt(producto.getNombre(), i, 1);
        this.modeloDatosProductos.setValueAt(producto.getCantidad(), i, 2);
        this.modeloDatosProductos.setValueAt(producto.getPrecioUnitario(), i, 3);
        this.modeloDatosProductos.setValueAt(producto.getSubtotal(), i, 4);
        this.modeloDatosProductos.setValueAt(producto.getDescuento(), i, 5);
        this.modeloDatosProductos.setValueAt(producto.getIva(), i, 6);
        this.modeloDatosProductos.setValueAt(producto.getTotalPagar(), i, 7);
        this.modeloDatosProductos.setValueAt("Eliminar", i, 8); // Aquí luego poner un botón de eliminar
    }
    // Añadir al JTable
    InterFacturacion.jTable_productos.setModel(modeloDatosProductos);
}
    
    
     /*
    Metodo para obtener id del cliente
     */
    private void ObtenerIdCliente() {
        try {
            String sql = "select * from tb_cliente where concat(nombre,' ',apellido) = '" + this.vista.jComboBox_cliente.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener id del cliente, " + e);
        }
    }
    
    
    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    //metodo para inicializar la tabla de los productos
    
   
  

    public boolean guardar(CabeceraVenta objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cabecera_venta values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0);//id
            consulta.setInt(2, objeto.getIdCliente());
            consulta.setDouble(3, objeto.getValorPagar());
            consulta.setString(4, objeto.getFechaVenta());
            consulta.setInt(5, objeto.getEstado());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            
            ResultSet rs = consulta.getGeneratedKeys();
            while(rs.next()){
                iDColVar = rs.getBigDecimal(1);
                idCabeceraRegistrada = iDColVar.intValue();
            }
            
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar cabecera de venta: " + e);
        }
        return respuesta;
    }
    
     /**
     * **************************************************
     * metodo para guardar el detalle de venta
     * **************************************************
     */
    public boolean guardarDetalle(DetalleVenta objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_detalle_venta values(?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setInt(2, idCabeceraRegistrada);
            consulta.setInt(3, objeto.getIdProducto());
            consulta.setInt(4, objeto.getCantidad());
            consulta.setDouble(5, objeto.getPrecioUnitario());
            consulta.setDouble(6, objeto.getSubtotal());
            consulta.setDouble(7, objeto.getDescuento());
            consulta.setDouble(8, objeto.getIva());
            consulta.setDouble(9, objeto.getTotalPagar());
            consulta.setInt(10, objeto.getEstado());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar detalle de venta: " + e);
        }
        return respuesta;
    }
    
    
         /**
     * **************************************************
     * metodo para actualizar un producto
     * **************************************************
     */
    public boolean actualizar(CabeceraVenta objeto, int idCabeceraVenta) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "update tb_cabecera_venta set idCliente = ?, estado = ? "
                            + "where idCabeceraVenta ='" + idCabeceraVenta + "'");
            consulta.setInt(1, objeto.getIdCliente());
            consulta.setInt(2, objeto.getEstado());
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cabecera de venta: " + e);
        }
        return respuesta;
    }
    
    
    public int obtenerUltimoidCabeceraVenta() {
    int ultimoId = 0;
    try (Connection cn = Conexion.conectar();
         Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery("select idCabeceraVenta FROM tb_cabecera_venta order by idCabeceraVenta desc limit 1")) {
        if (rs.next()) {
            ultimoId = rs.getInt(1);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el último ID de detalle de venta: " + e);
    }
        System.out.println(ultimoId);
    return ultimoId;
    
}
    
}
