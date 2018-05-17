package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * @author Jorge Andres Cordoba
 */
public class AccesoDatos {
    
    private String cadenaConexion;
    private Connection conexion;
    
    public AccesoDatos()
    {
        cadenaConexion = "";
        conexion = null;
    }   
    public boolean establecerConexion(String usuario, String host, int port, String pass)
    {
        try
        {
            cadenaConexion = "jdbc:oracle:thin:@"+host+":"+port+":xe";
            this.conexion = DriverManager.getConnection(cadenaConexion, usuario, pass);
            return true;
        }
        catch(Exception ex)
        {  
          
            return false;
        }    
    }
    public boolean cerrarConexion()
    {    
        try
        {
            this.conexion.close();
            return true;
        }
        catch(SQLException e)
        {
            return false;
        }
    }
    
    public ResultSet ejecutarSELECT(String consulta)
    {
        ResultSet rs;
        try
        {
            Statement stmt = this.conexion.createStatement();
            rs = stmt.executeQuery(consulta); 
            return rs;        
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    public ResultSet consultaProducto()    
    {
        ResultSet rs;
        //creo consulta para enviar a select son 3 columnas que retorna
        String consulta =  "Select * "
                         + "from 'producto'";
        
        //utilizo metodo para ejecutar select
        rs = ejecutarSELECT(consulta);
        return rs;
    }

}
