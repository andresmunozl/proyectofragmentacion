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
    
    public void insertar1MDatos(String tabla) throws SQLException    
    {
        if(tabla.equals("producto"))
          consulta = conect.prepareStatement("CALL InsDatosRand (100);");
        else
          consulta = conect.prepareStatement("CALL InsDatosRandProF (100);");
        
            
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
    
    public ResultSet consultaProductos(String tabla)    
    {
        ResultSet rs;
        //creo consulta para enviar a select son 3 columnas que retorna
        String consulSelect = "select * from "+tabla;
        
        //utilizo metodo para ejecutar select
        rs = ejecutarConsulta(consulSelect);
        return rs;
    }
    
    public ResultSet consultaProductoPorCategoria(String categoria,String tabla)    
    {
        ResultSet rs;
        //creo consulta para enviar a select son 3 columnas que retorna
        String consulSelect = "select * from "+tabla+" where categoria = "+categoria;
        
        //utilizo metodo para ejecutar select
        rs = ejecutarConsulta(consulSelect);
        return rs;
    }
    
    
    public ResultSet consultaProductoPromedio(String categoria, String tabla)    
    {
        ResultSet rs;
        //creo consulta para enviar a select son 3 columnas que retorna
        String consulSelect = "select AVG(precio) Promedio from "+tabla+" where categoria = "+categoria;
        
        //utilizo metodo para ejecutar select
        rs = ejecutarConsulta(consulSelect);
        return rs;
    }
    
    public ResultSet consultaProductoSumaPrecio(String tabla)    
    {
        ResultSet rs;
        //creo consulta para enviar a select son 3 columnas que retorna
        String consulSelect = "select SUM(precio) Suma_Precios from "+tabla;
        
        //utilizo metodo para ejecutar select
        rs = ejecutarConsulta(consulSelect);
        return rs;
    }
    
    public ResultSet consultaProductoCaro(String categoria,String tabla)    
    {
        ResultSet rs;
        //creo consulta para enviar a select son 3 columnas que retorna
        String consulSelect = "select * from (select codigo from "+tabla+" where categoria ="+categoria+" order by precio desc,codigo ) where rownum <= 1";
        
        //utilizo metodo para ejecutar select
        rs = ejecutarConsulta(consulSelect);
        return rs;
    }
  
    

}
