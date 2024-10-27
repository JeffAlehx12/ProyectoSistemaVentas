 /*
package controlador;

public class claseparaactualizarproductoa {
    
    
    /*
 public class Frm_Ctrl_GestionarProducto {
    
    InterGestionarProducto vista;
    
    private int idProducto;
    int obtenerIdCategoriaCombo = 0;
    
    
    
    
     
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
        CargarComboCategoria();
        
        
       /* 
        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(1000, 500, WIDTH));
       // vista.jLabel_wallpaper.setIcon(icono);
        vista.repaint();
        
       


       
        vista.jButton_actualizar.addActionListener(e -> jButton_actualizarActionPerformed(e));
        vista.jButton_eliminar.addActionListener(e -> jButton_eliminarActionPerformed(e));
        
      
            
       
         
    }
    
    
    
    
    
    
    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {                                                   
   
      
        Producto producto = new Producto();
        Ctrl_Producto controlProducto = new Ctrl_Producto();
        
        String igv = "";
        String categoria = "";
        String proveedor = "";
        
        igv = vista.jComboBox_iva.getSelectedItem().toString().trim();
        categoria = vista.jComboBox_categoria.getSelectedItem().toString().trim();
        proveedor = vista.jComboBox_proveedor.getSelectedItem().toString().trim();
        //validar campos
        if (vista.txt_nombre.getText().isEmpty() || vista.txt_cantidad.getText().isEmpty() || vista.txt_precio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            if (igv.equalsIgnoreCase("Seleccione igv:")) {
                JOptionPane.showMessageDialog(null, "Seleccione igv.");
            } else {
                if (categoria.equalsIgnoreCase("Seleccione categoria:")) {
                    JOptionPane.showMessageDialog(null, "Seleccione categoria");
                } else {
                    if (proveedor.equalsIgnoreCase("Seleccione proveedor:")) {
                    JOptionPane.showMessageDialog(null, "Seleccione proveedor");
                } else {
                    
                    
                    try {
                        producto.setNombre(vista.txt_nombre.getText().trim());
                        producto.setCantidad_actual(Integer.parseInt(vista.txt_cantidad.getText().trim()));
                        String precioTXT = "";
                        double Precio = 0.0;
                        precioTXT = vista.txt_precio.getText().trim();
                        boolean aux = false;
                        /*
                            *Si el usuario ingresa , (coma) como punto decimal,
                            lo transformamos a punto (.)
                        
                        for (int i = 0; i < precioTXT.length(); i++) {
                            if (precioTXT.charAt(i) == ',') {
                                String precioNuevo = precioTXT.replace(",", ".");
                                Precio = Double.parseDouble(precioNuevo);
                                aux = true;
                            }
                        }
                        //evaluar la condicion
                        if (aux == true) {
                            producto.setPrecioVenta(Precio);
                        } else {
                            Precio = Double.parseDouble(precioTXT);
                            producto.setPrecioVenta(Precio);
                        }
                        
                        
                        //Descripcion 
                        producto.setDescripcion(vista.txt_descripcion.getText().trim());
                        
                        
                        
                        //Porcentaje IVA
                        if (igv.equalsIgnoreCase("No grava iva")) {
                            producto.setPorcentajeIgv(0);
                        } else if (igv.equalsIgnoreCase("18%")) {
                            producto.setPorcentajeIgv(18);
                        } 

                        //idcategoria - cargar metodo que obtiene el id de categoria
                        
                        IdCategoria();
                        producto.setIdCategoria(obtenerIdCategoriaCombo);
                        
                        
                        
                        
                        producto.setEstado(1);

                        if (controlProducto.actualizar(producto, idProducto)) {
                           
                            JOptionPane.showMessageDialog(null, "Registro Actualizado");
                            CargarComboCategoria();
                            
                            CargarTablaProductos();
                            vista.jComboBox_iva.setSelectedItem("Seleccione iva:");
                            vista.jComboBox_categoria.setSelectedItem("Seleccione categoria:");
                            vista.jComboBox_proveedor.setSelectedItem("Seleccione proveedor:");
                            
                            Limpiar();
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Actualizar");
                        }
                    } catch (HeadlessException | NumberFormatException e) {
                        System.out.println("Error en: " + e);
                    }
                }
            }}
        }
        
        
        
    
    
    }
    
    
    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
   
         Ctrl_Producto controlProducto = new Ctrl_Producto();
        if (idProducto == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Producto!");
        } else {
            if (!controlProducto.eliminar(idProducto)) {
                JOptionPane.showMessageDialog(null, "¡Producto Eliminado!");
                CargarTablaProductos();
                CargarComboCategoria();
               
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar producto!");
            }
        }
        
        
        
    }


    
    
    
    
    private void Limpiar() {
        vista.txt_nombre.setText("");
        vista.txt_cantidad.setText("");
        vista.txt_precio.setText("");
        vista.txt_descripcion.setText("");
        vista.jComboBox_iva.setSelectedItem("Seleccione iva:");
        vista.jComboBox_categoria.setSelectedItem("Seleccione categoria:");
    }

   
    private void CargarComboCategoria() {
        
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_categoria";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            vista.jComboBox_categoria.removeAllItems();
            vista.jComboBox_categoria.addItem("Seleccione categoria:");
            while (rs.next()) {
                vista.jComboBox_categoria.addItem(rs.getString("nombreCategoria"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("¡Error al cargar categorias!");
        }
    }
    
   

   
    String descripcionCategoria = "";

    double precio = 0.0;
    int porcentajeIgv = 0;
    double IGV = 0;

    private void CargarTablaProductos() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT p.idProducto, p.nombre, p.descripcion, c.nombreCategoria, p.ubicacion, p.precioCosto, p.precioVenta, p.porcentajeIgv,p.precio_total " +
                "FROM tb_producto p " +
                "JOIN tb_categoria c ON p.idCategoria = c.idCategoria;";
        
        
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarProducto.jTable_productos = new JTable(model);
            InterGestionarProducto.jScrollPane1.setViewportView(InterGestionarProducto.jTable_productos);

            model.addColumn("ID°");//ID
            model.addColumn("Nombre");
            model.addColumn("Descripcion");
            model.addColumn("Categoria");
            model.addColumn("Ubicacion");
            model.addColumn("Precio Costo");
            model.addColumn("Precio Venta");
            model.addColumn("IGV");
            model.addColumn("Precio Total");

            while (rs.next()) {

                precio = rs.getDouble("precioVenta");
                porcentajeIgv = rs.getInt("porcentajeIgv");

                Object fila[] = new Object[9];
                for (int i = 0; i < 9; i++) {

                    if (i == 7) {
                        this.calcularIgv(precio, porcentajeIgv);//metodo
                        fila[i] = IGV;
                        rs.getObject(i + 1);
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
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        jTable_productos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_productos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idProducto = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProductoSeleccionado(idProducto);//metodo
                }
            }
        });
    }

 
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
    
    private void EnviarDatosProductoSeleccionado(int idProducto) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from tb_producto where idProducto = '" + idProducto + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                
                vista.txt_nombre.setText(rs.getString("nombre"));
                vista.txt_cantidad.setText(rs.getString("cantidad_actual"));
                vista.txt_precio.setText(rs.getString("precio"));
                vista.txt_descripcion.setText(rs.getString("descripcion"));
                
                int iva = rs.getInt("porcentajeIgv");
                switch (iva) {
                    case 0:
                        vista.jComboBox_iva.setSelectedItem("No grava iva");
                        break;
                    case 18:
                        vista.jComboBox_iva.setSelectedItem("18%");
                        break;
                    default:
                        vista.jComboBox_iva.setSelectedItem("Seleccione iva:");
                        break;
                }
                int idCate = rs.getInt("idCategoria");
                
                vista.jComboBox_categoria.setSelectedItem(relacionarCategoria(idCate));
                
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar producto: " + e);
        }
    }

   
    private String relacionarCategoria(int idCategoria) {

        String sql = "select nombreCategoria from tb_categoria where idCategoria = '" + idCategoria + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                descripcionCategoria = rs.getString("nombreCategoria");
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("¡Error al obtener el id de la categoria!");
        }
        return descripcionCategoria;
    }
    
    

    
    private int IdCategoria() {
        String sql = "select * from tb_categoria where nombreCategoria = '" + vista.jComboBox_categoria.getSelectedItem() + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obtenerIdCategoriaCombo = rs.getInt("idCategoria");
            }
        } catch (SQLException e) {
            System.out.println("Error al obener id categoria");
        }
        return obtenerIdCategoriaCombo;
    }
    
   
    
    
   
}

    
    
 
}
 */