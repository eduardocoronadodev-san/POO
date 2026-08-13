package modelo;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBD {
    private String url;
    private String usuario;
    private String contrasena;
    private Connection conexion;
    private String host;
    private String nameBD;
    private String driverBD;

    //constructor
    public ConexionBD(String url, String usuario, String contrasena) {
        this.url = url;
        this.usuario = usuario;
  //      this.contrasena = contrasena;
        this.driverBD = "com.mysql.cj.jdbc.Driver";
    }
    //constructor vacio

    public ConexionBD() {
        this.usuario = "root";
        this.host = "127.0.0.1:3306";
        this.nameBD = "bd_sistema_login";
        this.url = "jdbc:mysql://" + this.host + "/" + this.nameBD;
        this.contrasena = "GANCUBE356i."; //pass de mysql
        this.driverBD = "com.mysql.cj.jdbc.Driver";
        this.conexion = null;
    }



    //metodo para conectar a la base de datos
    public boolean conectar() {
        try {
            //cargar el driver de MySQL
            Class.forName(this.driverBD);
            //establecer la conexion
            conexion = java.sql.DriverManager.getConnection(url, usuario, contrasena);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return false;
        }
    }

    //metodo para cerrar la conexion a la base de datos
    public boolean cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion a la base de datos: " + e.getMessage());
            return false;
        }

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}