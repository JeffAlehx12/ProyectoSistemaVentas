
package vista;


public class InterSeleccionProductoEntrada extends javax.swing.JInternalFrame {

   
    public InterSeleccionProductoEntrada() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblProductos = new javax.swing.JTable();
        jbtnConfirmar = new javax.swing.JToggleButton();
        jbtnCancelar = new javax.swing.JToggleButton();

        jtblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblProductos);

        jbtnConfirmar.setBackground(new java.awt.Color(0, 153, 204));
        jbtnConfirmar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jbtnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atualizar.png"))); // NOI18N
        jbtnConfirmar.setText("Confirmar");

        jbtnCancelar.setBackground(new java.awt.Color(0, 153, 204));
        jbtnCancelar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jbtnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jbtnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JToggleButton jbtnCancelar;
    public javax.swing.JToggleButton jbtnConfirmar;
    public javax.swing.JTable jtblProductos;
    // End of variables declaration//GEN-END:variables
}
