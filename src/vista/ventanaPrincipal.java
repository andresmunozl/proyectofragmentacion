
package vista;

import datos.AccesoDatos;
import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
    private AccesoDatos datos;
    private Conexion conexion ;
    private Connection conect;
    /**
     * Creates new form ventanaPrincipal
     */
    public ventanaPrincipal() throws SQLException 
    {
        initComponents();
        conexion = new Conexion();
        conect  = conexion.crearConexion(); 
        mostrarDatos();
    }
    
    public void mostrarDatos() throws SQLException{
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CATEGORIA");
        jtabDatos.setModel(modelo);
        
        String []datos = new String[3];
        
        Statement consulta = conect.createStatement();
        ResultSet rs = consulta.executeQuery("select * from producto");
        
        while(rs.next()){
            datos[0]= rs.getString(1);
            datos[1]= rs.getString(2);
            datos[2]= rs.getString(3);
            modelo.addRow(datos);
            
        }
        jtabDatos.setModel(modelo);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSumaProductos.setText("Suma total de precios");

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

        btnConsultaPromedioCategoria.setText("Promedio precios productos por categoria");

        btnProductoMasCaro.setText("Producto mas caro");

        jtabDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtabDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnListarTodosProductos)
                    .addComponent(btnListarProductoPorCategoria)
                    .addComponent(btnConsultaPromedioCategoria)
                    .addComponent(btnProductoMasCaro)
                    .addComponent(btnSumaProductos))
                .addGap(96, 96, 96)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnListarTodosProductos)
                        .addGap(47, 47, 47)
                        .addComponent(btnListarProductoPorCategoria)
                        .addGap(51, 51, 51)
                        .addComponent(btnConsultaPromedioCategoria)
                        .addGap(40, 40, 40)
                        .addComponent(btnProductoMasCaro)
                        .addGap(50, 50, 50)
                        .addComponent(btnSumaProductos)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarTodosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosProductosActionPerformed
 
    }//GEN-LAST:event_btnListarTodosProductosActionPerformed

    private void btnListarTodosProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarTodosProductosMouseClicked
         
        
        if(conect != null)
        {
            System.out.println("Exito");
            //datos.establecerConexion(conect);
            ResultSet rs;
            //rs = datos.consultaProductos();
            //llenarJTableValores(rs);
        }
        else
            System.out.println("Fallo");
        
        try {
            PreparedStatement consulta = conect.prepareStatement("CALL InsDatosRand (100);");
            consulta.executeUpdate();
            mostrarDatos();
            System.out.println("paso por aquí");
            
        } catch (SQLException ex) {
            Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnListarTodosProductosMouseClicked

    
    
    
    
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new ventanaPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultaPromedioCategoria;
    private javax.swing.JButton btnListarProductoPorCategoria;
    private javax.swing.JButton btnListarTodosProductos;
    private javax.swing.JButton btnProductoMasCaro;
    private javax.swing.JButton btnSumaProductos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabDatos;
    // End of variables declaration//GEN-END:variables
}
