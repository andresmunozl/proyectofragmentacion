package datos;
/*
 * @author Jorge Andres Cordoba
 */
public class Conexion {
    
    private String usuario;
    private String host;
    private int puerto;
    private String password;
    private boolean estadoConexion;

    public Conexion() 
    {
        this.host = "";
        this.puerto = 0;
        this.password = "";
        this.estadoConexion = false;
    }
    public Conexion(String pUsuario, String pHost, int pPuerto) 
    {
        this.usuario = pUsuario;
        this.host = pHost;
        this.puerto = pPuerto;
        this.estadoConexion=false;
        
    }
    public boolean isEstadoConexion() 
    {
        return estadoConexion;
    }
    public void setEstadoConexion(boolean estadoConexion) 
    {
        this.estadoConexion = estadoConexion;
    }
    
    public String getUsuario() 
    {
        return usuario;
    }
    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }
    
    public String getHost() 
    {
        return host;
    }
    public void setHost(String Host) 
    {
        this.host = Host;
    }

    public int getPuerto() 
    {
        return puerto;
    }
    public void setPuerto(int Puerto) 
    {
        this.puerto = Puerto;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }   

}
