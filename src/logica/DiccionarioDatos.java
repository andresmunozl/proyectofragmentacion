package logica;

import datos.AccesoDatos;
import datos.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Jorge Andres Cordoba
 */
public class DiccionarioDatos {

    String consulta;
    private AccesoDatos datos;
    private Conexion dc;
 

    public Conexion getDc() 
    {
        return dc;
    }
    public void setDc(Conexion dc) 
    {
        this.dc = dc;
    }
    
    
    
    public DiccionarioDatos() 
    {
        datos = new AccesoDatos();
    }

    public boolean comprobarConexion(Conexion dcs)
    {
        try
        {
            dc = dcs;
            return datos.establecerConexion(dc.getUsuario(), dc.getHost(), dc.getPuerto(), dc.getPassword());
        }
        catch(Exception e)
        {
            return datos.establecerConexion(dc.getUsuario(), dc.getHost(), dc.getPuerto(), dc.getPassword());
        }
    }
    public boolean desconexion()
    {
        return datos.cerrarConexion();
    }
    
    
}
