/*
 * Techno Engineers
 * Conexion
 * 12/04/2016 -- Autorizo: Oscar de Paz Feliciano // Lider de proyecto
 * Modificaciones: Miguel Ángel Careaga Gómez // Desarrollo. [17/04/2016]
 * Permite hacer la conexion con la Base de Datos. entre el Sistema y MySQL
 * Numero de metodos en el codigo: 2
 * Interfaces: 
 */
package tr.rentas;

import java.sql.*;

public class Conexion
{
    public Connection con = null;//variable tipo conexion
    
    /**
     * Conecta con la base de datos MySQL
     * @param host - Nombre del servidor o la dirección ip
     * @param NomBD - Es el servicio de escucha de oracle (SID)
     * @param usuario - Usuario de la base de datos
     * @param passw - Contraseña del usuario de la base de datos
     * @return - Retorna datos de conexión a la base de datos
     * @throws SQLException - Se ejecuta si ocurre un error de conexión a la base de datos
     */
    
    public Connection Conecta(String host, String NomBD, String usuario, String passw){
    
        String driver = "com.mysql.jdbc.Driver";
        String error = "No se pudo cargar el driver Mysql";
        String url = "jdbc:mysql://"+host+"/"+NomBD;
        
        //Mensajes Mensaje=new Mensajes();
        try {
            Class.forName(driver).newInstance();//Carga el driver de MySQL
        } catch (Exception e) {
            // Ocurrió un error al registrar el driver 
            System.out.println(error);
            //Mensajes.falla(MensajeConexion,error);
        }

        try{
            // De esta forma se obtiene la conexi¢n 
            con = DriverManager.getConnection(url, usuario, passw);
            System.out.println("Conexi¢n establecida con " + host + " a la Base de Datos " + NomBD);
            //  Mensajes.exito(MensajeConexion);
        }catch(SQLException sqle){
            // Ocurrió un error con la conexi¢n 
            System.out.println("Error con la conexi¢n a la base de datos:");
            //  Mensajes.falla(MensajeConexion);
        } 
        
      return con; //Se regresa la conexion
    }
    
    /**
     * Cerrar la conexion con la base de datos
     * @param conect - recibe la conexion que se desea cerrar 
     */
    public void desconectar(Connection conect)
    {
        conect = null;
    }

}
