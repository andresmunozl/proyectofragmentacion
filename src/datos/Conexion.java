package datos;
/*
 * @author Jorge Andres Cordoba
 */
//link video: https://www.youtube.com/watch?v=ao1ykHOsYvU&t=27s
//para dml : https://www.youtube.com/watch?v=_AtUevapQ80
import java.sql.*;
public class Conexion {
    Connection connetion = null;
    
    public Connection crearConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connetion = DriverManager.getConnection("jdbc:mysql://localhost/FragmentacionBD","root","");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connetion;
    }
}