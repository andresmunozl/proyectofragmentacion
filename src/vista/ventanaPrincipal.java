
package vista;

import datos.AccesoDatos;
import datos.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ventanaPrincipal extends javax.swing.JFrame {
    private final AccesoDatos datos;
    private final Conexion conexion ;
    private final Connection conect;
    /**
     * Creates new form ventanaPrincipal
     */
    public ventanaPrincipal() throws SQLException
    {
        initComponents();
        conexion = new Conexion();
        conect  = conexion.crearConexion(); 
        datos = new AccesoDatos();
        datos.establecerConexion(conect);
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSumaProductos = new javax.swing.JButton();
        btnListarTodosProductos = new javax.swing.JButton();
        btnListarProductoPorCategoria = new javax.swing.JButton();
        btnConsultaPromedioCategoria = new javax.swing.JButton();
        btnProductoMasCaro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabDatos = new javax.swing.JTable();
        btnInsertaMillon = new javax.swing.JButton();
        jComboBoxCat = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCat2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSumaProductos.setText("Suma total de precios");
        btnSumaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSumaProductosMouseClicked(evt);
            }
        });

        btnListarTodosProductos.setText("Listar productos");
        btnListarTodosProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarTodosProductosMouseClicked(evt);
            }
        });
        btnListarTodosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosProductosActionPerformed(evt);
            }
        });

        btnListarProductoPorCategoria.setText("Listar productos de una categoria");
        btnListarProductoPorCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarProductoPorCategoriaMouseClicked(evt);
            }
        });
        btnListarProductoPorCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProductoPorCategoriaActionPerformed(evt);
            }
        });

        btnConsultaPromedioCategoria.setText("Promedio precios productos por categoria");
        btnConsultaPromedioCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultaPromedioCategoriaMouseClicked(evt);
            }
        });

        btnProductoMasCaro.setText("Producto mas caro");

        jtabDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtabDatos);

        btnInsertaMillon.setBackground(new java.awt.Color(255, 0, 0));
        btnInsertaMillon.setText("Insertar Millon De Datos");
        btnInsertaMillon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertaMillonMouseClicked(evt);
            }
        });

        jComboBoxCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        jLabel1.setText("Categoria");

        jLabel2.setText("Categoria");

        jComboBoxCat2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnInsertaMillon)
                    .addComponent(btnSumaProductos)
                    .addComponent(btnProductoMasCaro)
                    .addComponent(btnConsultaPromedioCategoria)
                    .addComponent(btnListarProductoPorCategoria)
                    .addComponent(btnListarTodosProductos)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addComponent(jComboBoxCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addComponent(jComboBoxCat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnListarTodosProductos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarProductoPorCategoria)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultaPromedioCategoria)
                        .addGap(62, 62, 62)
                        .addComponent(btnProductoMasCaro)
                        .addGap(37, 37, 37)
                        .addComponent(btnSumaProductos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInsertaMillon)
                        .addGap(25, 25, 25))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarTodosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosProductosActionPerformed
 
    }//GEN-LAST:event_btnListarTodosProductosActionPerformed

    private void btnListarTodosProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarTodosProductosMouseClicked
         
        
            ResultSet rs;
            rs = datos.consultaProductos();
            llenarJTableValores(rs);
        
    }//GEN-LAST:event_btnListarTodosProductosMouseClicked

    private void btnInsertaMillonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertaMillonMouseClicked
        try {        
            datos.insertar1MDatos();
        } catch (SQLException ex) {
            Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInsertaMillonMouseClicked

    private void btnListarProductoPorCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarProductoPorCategoriaMouseClicked

        //recibo seleccionado del combo box
        int categoria = 1 + jComboBoxCat.getSelectedIndex();

        ResultSet rs;
        
        //genero la consulta de buscar por categoria
        rs = datos.consultaProductoPorCategoria(String.valueOf(categoria));

        llenarJTableValores(rs);    
    }//GEN-LAST:event_btnListarProductoPorCategoriaMouseClicked

    private void btnListarProductoPorCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProductoPorCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListarProductoPorCategoriaActionPerformed

    private void btnConsultaPromedioCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultaPromedioCategoriaMouseClicked
        int categoria = 1 + jComboBoxCat2.getSelectedIndex();

        ResultSet rs;
        
        //genero la consulta de buscar por categoria
        rs = datos.consultaProductoPromedio(String.valueOf(categoria));

        llenarJTableValores(rs);    
    }//GEN-LAST:event_btnConsultaPromedioCategoriaMouseClicked

    private void btnSumaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSumaProductosMouseClicked
        ResultSet rs;
        
        //genero la consulta de buscar por categoria
        rs = datos.consultaProductoSumaPrecio();

        llenarJTableValores(rs);  
        
    }//GEN-LAST:event_btnSumaProductosMouseClicked

    
    
    
    
    //METODOS PARA EL LLENADO DE LA JTABLEDATOS DONDE SE VISUALIZARAN RESULTADOS
    public void llenarJTableValores(ResultSet resulSet)
    {
        construirJTable(resulSet,jtabDatos);
    }
    public void construirJTable(ResultSet resulSet, JTable tbl)
    {
        try
        {
            tbl.setModel(modeloTabla(resulSet));
            if(tbl.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(this,"no existen valores");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    private static DefaultTableModel modeloTabla(ResultSet rs) throws SQLException
    {
        ResultSetMetaData metaData = rs.getMetaData();
        
        Vector<String>columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for(int column = 1; column <=columnCount; column++)
        {
           columnNames.add(metaData.getColumnName(column));
        }
        Vector<Vector<Object>>data = new Vector<Vector<Object>>();
        while(rs.next())
        {
            Vector<Object> vector = new Vector<Object>();
            for(int columnIndex = 1; columnIndex<=columnCount; columnIndex++)
            {
                vector.add(rs.getObject(columnIndex));
                
            }
            data.add(vector);
        }
        //System.out.println(metaData.getColumnCount());
        return new DefaultTableModel(data,columnNames);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ventanaPrincipal().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultaPromedioCategoria;
    private javax.swing.JButton btnInsertaMillon;
    private javax.swing.JButton btnListarProductoPorCategoria;
    private javax.swing.JButton btnListarTodosProductos;
    private javax.swing.JButton btnProductoMasCaro;
    private javax.swing.JButton btnSumaProductos;
    private javax.swing.JComboBox<String> jComboBoxCat;
    private javax.swing.JComboBox<String> jComboBoxCat2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabDatos;
    // End of variables declaration//GEN-END:variables
}
