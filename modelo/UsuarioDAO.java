package modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// herencia multiple
public class UsuarioDAO extends Usuario implements InterfaceCRUDUsusario {
    // atributos
    private ConexionBD conexion;
    private CallableStatement callableStatement;
    private ResultSet resultSet;

    private ArrayList<Usuario> listaUsuarios;
    private String mensaje;

    // constructor
    public UsuarioDAO() {
        conexion = new ConexionBD();
        callableStatement = null;
        resultSet = null;
        listaUsuarios = new ArrayList<>();
        mensaje = "";
    }

    private void cerrarRecursos() {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (SQLException ignored) {
        }
        try {
            if (callableStatement != null && !callableStatement.isClosed()) {
                callableStatement.close();
            }
        } catch (SQLException ignored) {
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean agregarUsuario(Usuario usuario) {
        // validar si exist conexxion en base de datos con if y try catch
        if (conexion.conectar()) {
            try {
                // llamar al procedimiento almacenado para agregar usuario (4 parámetros)
                callableStatement = conexion.getConexion().prepareCall("call bd_sistema_login.sp_insertar_usuario(?,?,?,?)");
                callableStatement.setString(1, usuario.getNombre());
                callableStatement.setString(2, usuario.getApellidoPaterno());
                callableStatement.setString(3, usuario.getApellidoMaterno());
                callableStatement.setString(4, usuario.getEmail());
                // ejecutar el procedimiento almacenado
                callableStatement.execute();
                int filasAfectadas = callableStatement.getUpdateCount();
                // Algunos drivers devuelven -1 para procedimientos; considerarlo éxito.
                if (filasAfectadas == -1 || filasAfectadas > 0) {
                    mensaje = "Usuario agregado correctamente (filas=" + filasAfectadas + ")";
                    return true;
                } else {
                    mensaje = "Error al agregar usuario (filas=" + filasAfectadas + ")";
                    return false;
                }
            } catch (SQLException e) {
                mensaje = "Error al agregar usuario: " + e.getMessage();
                return false;
            } finally {
                cerrarRecursos();
                conexion.cerrarConexion();
            }
        } else {
            mensaje = "Error al conectar a la base de datos";
            return false;
        }
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        if (conexion.conectar()) {
            try {
                // sp_modificar tiene 5 parámetros: id, nombre, apellidoPaterno,
                // apellidoMaterno, email
                callableStatement = conexion.getConexion().prepareCall("call bd_sistema_login.sp_modificar(?,?,?,?,?)");
                callableStatement.setInt(1, usuario.getId());
                callableStatement.setString(2, usuario.getNombre());
                callableStatement.setString(3, usuario.getApellidoPaterno());
                callableStatement.setString(4, usuario.getApellidoMaterno());
                callableStatement.setString(5, usuario.getEmail());

                callableStatement.execute();
                int filasAfectadas = callableStatement.getUpdateCount();
                if (filasAfectadas == -1 || filasAfectadas > 0) {
                    mensaje = "Usuario actualizado correctamente";
                    return true;
                } else {
                    mensaje = "Error al actualizar usuario";
                    return false;
                }
            } catch (SQLException e) {
                mensaje = "Error al actualizar usuario: " + e.getMessage();
                return false;
            } finally {
                cerrarRecursos();
                conexion.cerrarConexion();
            }
        } else {
            mensaje = "Error al conectar a la base de datos";
            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(int id) {
        if (conexion.conectar()) {
            try {
                callableStatement = conexion.getConexion().prepareCall("call bd_sistema_login.sp_eliminar(?)");
                callableStatement.setInt(1, id);

                callableStatement.execute();
                int filasAfectadas = callableStatement.getUpdateCount();
                if (filasAfectadas == -1 || filasAfectadas > 0) {
                    mensaje = "Usuario eliminado correctamente";
                    return true;
                } else {
                    mensaje = "Error al eliminar usuario";
                    return false;
                }
            } catch (SQLException e) {
                mensaje = "Error al eliminar usuario: " + e.getMessage();
                return false;
            } finally {
                cerrarRecursos();
                conexion.cerrarConexion();
            }
        } else {
            mensaje = "Error al conectar a la base de datos";
            return false;
        }
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;
        if (conexion.conectar()) {
            try {
                callableStatement = conexion.getConexion().prepareCall("call bd_sistema_login.sp_consultarId(?)");
                callableStatement.setInt(1, id);
                resultSet = callableStatement.executeQuery();

                if (resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setNombre(resultSet.getString("nombre"));
                    usuario.setApellidoPaterno(resultSet.getString("apellidoPaterno"));
                    usuario.setApellidoMaterno(resultSet.getString("apellidoMaterno"));
                    usuario.setEmail(resultSet.getString("email"));
                    usuario.setPassword(resultSet.getString("password"));
                }
            } catch (SQLException e) {
                mensaje = "Error al obtener usuario por id: " + e.getMessage();
            } finally {
                cerrarRecursos();
                conexion.cerrarConexion();
            }
        } else {
            mensaje = "Error al conectar a la base de datos";
        }
        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        listaUsuarios.clear();
        if (conexion.conectar()) {
            try {
                callableStatement = conexion.getConexion().prepareCall("call bd_sistema_login.sp_consultar()");
                resultSet = callableStatement.executeQuery();

                while (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultSet.getInt("idUsuario"));
                    usuario.setNombre(resultSet.getString("nombreUsuario"));
                    usuario.setApellidoPaterno(resultSet.getString("apPaternoUsuario"));
                    usuario.setApellidoMaterno(resultSet.getString("apMaternoUsuario"));
                    usuario.setEmail(resultSet.getString("emailUsuario"));
                    // usuario.setPassword(resultSet.getString("password"));
                    listaUsuarios.add(usuario);
                }
            } catch (SQLException e) {
                mensaje = "Error al obtener todos los usuarios: " + e.getMessage();
            } finally {
                cerrarRecursos();
                conexion.cerrarConexion();
            }
        } else {
            mensaje = "Error al conectar a la base de datos";
        }
        return listaUsuarios;
    }
}
