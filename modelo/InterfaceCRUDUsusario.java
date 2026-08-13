package modelo;

import java.util.List;

public interface InterfaceCRUDUsusario {
    // metodo para el CRUD de usuario
    boolean agregarUsuario(Usuario usuario);
    boolean actualizarUsuario(Usuario usuario);
    boolean eliminarUsuario(int idUsuario);
    // metodo para obtener un usuario por su id
    Usuario obtenerUsuarioPorId(int id);
    // metodo para obtener todos los usuarios
    List<Usuario> obtenerTodosLosUsuarios();
}
