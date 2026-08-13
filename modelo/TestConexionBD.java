package modelo;

public class TestConexionBD {
  //crear objeto de ConexionBD
public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
 // intentar conectar a la base de datos
        if (conexion.conectar()) {
            System.out.println("Conexion exitosa a la base de datos");
            //cerrar conexion
            if (conexion.cerrarConexion()) {
                System.out.println("Conexion cerrada correctamente");
            } else {
                System.out.println("Error al cerrar la conexion");
            }
        } else {
            System.out.println("Error al conectar a la base de datos");
        }
    }
}
