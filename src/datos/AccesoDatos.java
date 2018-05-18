package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * @author Jorge Andres Cordoba
 */
public class AccesoDatos {
    
     private Connection conect;
     private PreparedStatement consulta;
    
    public AccesoDatos()
    {
        conect = null;
    }   
    public void establecerConexion(Connection con) 
    {
          conect = con;
    }
    
    public void insertar1MDatos() throws SQLException    
    {
          consulta = conect.prepareStatement("CALL InsDatosRand (100);");
          consulta.executeUpdate();
    
    }
    
    public boolean cerrarConexion()
    {    
        try
        {
            this.conect.close();
            return true;
        }
        catch(SQLException e)
        {
            return false;
        }
    }
    
    public ResultSet ejecutarConsulta(String inConsulta)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conect.createStatement();
            rs = stmt.executeQuery(inConsulta);
            return rs;        
        }
        catch(SQLException ex)
        {
            return null;
        }
    }
    
    public ResultSet consultaProductos()    
    {
        ResultSet rs;
        //creo consulta para enviar a select son 3 columnas que retorna
        String consulSelect = "select * from producto";
        
        //utilizo metodo para ejecutar select
        rs = ejecutarConsulta(consulSelect);
        return rs;
    }
    
    public ResultSet consultaProductoPorCategoria(String categoria)    
    {
        ResultSet rs;
        //creo consulta para enviar a select son 3 columnas que retorna
        String consulSelect = "select * from producto where categoria = "+categoria;
        
        //utilizo metodo para ejecutar select
        rs = ejecutarConsulta(consulSelect);
        return rs;
    }
    
    
    public ResultSet consultaProductoPromedio(String categoria)    
    {
        ResultSet rs;
        //creo consulta para enviar a select son 3 columnas que retorna
        String consulSelect = "select AVG(precio) Promedio from producto where categoria = "+categoria;
        
        //utilizo metodo para ejecutar select
        rs = ejecutarConsulta(consulSelect);
        return rs;
    }
    
    public ResultSet consultaProductoSumaPrecio()    
    {
        ResultSet rs;
        //creo consulta para enviar a select son 3 columnas que retorna
        String consulSelect = "select SUM(precio) Suma_Precios from producto ";
        
        //utilizo metodo para ejecutar select
        rs = ejecutarConsulta(consulSelect);
        return rs;
    }
    
    
    

}
