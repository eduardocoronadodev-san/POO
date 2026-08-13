package modelo;

import java.util.List;

public class TestUsuarioDao {
    public static void main(String[] args) {
        // crear objeto de UsuarioDAO
        UsuarioDAO usuarioDao = new UsuarioDAO();

        // crear objeto de Usuario
    /*  Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellidoPaterno("Perez");
        usuario.setApellidoMaterno("Gomez");
        usuario.setEmail("juan.perez@gomez.com");


        boolean exito = usuarioDao.agregarUsuario(usuario);
        if (exito) {
            System.out.println("Usuario agregado correctamente");
        } else {
            System.out.println("Error al agregar usuario: " + usuarioDao.getMensaje());
        }*/

            //obtener todos los usuarios de la base de datos
        List<Usuario> usuarios = usuarioDao.obtenerTodosLosUsuarios();

        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido Paterno: " + usuario.getApellidoPaterno());
            System.out.println("Apellido Materno: " + usuario.getApellidoMaterno());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("-----------------------------");
        }

        //imprimir mensaje devuelto por el procedimientop almacenado
        System.out.println("Mensaje: " + usuarioDao.getMensaje());

    }
}
