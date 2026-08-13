package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VistaUsuario extends JFrame {

    // atributos de la clase
    public JPanel encabezadoPanel;
    public JPanel contenidoPanel;
    public JPanel formularioPanel;
    public JLabel lblTituloUsuario;

    public JButton btnAgregarUsuario;
    public JButton btnEditarUsuario;
    public JButton btnEliminarUsuario;
    public JButton btnBuscarUsuario;
    public JButton btnSalir;

    public JTextField txtBuscarUsuario;

    public JLabel lblIdUsuario;
    public JLabel lblNombre;
    public JLabel lblApellidoPaterno;
    public JLabel lblApellidoMaterno;
    public JLabel lblEmail;

    public JTextField txtIdUsuario;
    public JTextField txtNombre;
    public JTextField txtApellidoPaterno;
    public JTextField txtApellidoMaterno;
    public JTextField txtEmail;

    public JTable tablaUsuarios;
    public DefaultTableModel modeloTablaUsuarios;

    // constructor vacío
    public VistaUsuario() {
        // Configuración de la ventana
        initComponents();
        // iniciar el metodo cargarUsuariosEnTabla() para que cargue los usuarios de la
        // base de datos en la tabla
        cargarUsuariosEnTabla();
        // manejador de eventos
        manejadorEventos();
    }

    // Método para inicializar los componentes de la ventana
    private void initComponents() {
        setTitle("Gestión de Usuarios");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setResizable(false);

        getContentPane().setLayout(new BorderLayout());

        // Inicializar el panel de encabezado
        initEncabezadoPanel();

        // Inicializar el panel de formulario
        initFormularioPanel();
        // Inicializar el panel de contenido
        initContenidoPanel();

    }// fin initComponents

    // metodo para el panel de encabezado, que incluya los botones paraa el crud
    // (agregar, editar, eliminar, buscar) y un campo de texto para la búsqueda
    private void initEncabezadoPanel() {
        // crear los objetos de los componentes del panel de encabezado
        encabezadoPanel = new JPanel();
        lblTituloUsuario = new JLabel("Gestión de Usuarios");
        btnAgregarUsuario = new JButton("Agregar Usuario");
        btnEditarUsuario = new JButton("Editar Usuario");
        btnEliminarUsuario = new JButton("Eliminar Usuario");
        btnBuscarUsuario = new JButton("Buscar Usuario");
        txtBuscarUsuario = new JTextField(20);
        btnSalir = new JButton("Salir");

        // Configurar el panel de encabezado
        encabezadoPanel.setLayout(null);
        encabezadoPanel.setBackground(new Color(240, 240, 240));
        encabezadoPanel.setPreferredSize(new Dimension(800, 100));
        lblTituloUsuario.setBounds(10, 10, 200, 30);
        btnAgregarUsuario.setBounds(220, 10, 100, 30);
        btnEditarUsuario.setBounds(330, 10, 100, 30);
        btnEliminarUsuario.setBounds(440, 10, 100, 30);
        txtBuscarUsuario.setBounds(550, 10, 150, 30);
        btnBuscarUsuario.setBounds(710, 10, 80, 30);
        btnSalir.setBounds(710, 50, 80, 30);

        // Agregar los componentes al panel de encabezado
        encabezadoPanel.add(lblTituloUsuario);
        encabezadoPanel.add(btnAgregarUsuario);
        encabezadoPanel.add(btnEditarUsuario);
        encabezadoPanel.add(btnEliminarUsuario);
        encabezadoPanel.add(txtBuscarUsuario);
        encabezadoPanel.add(btnBuscarUsuario);
        encabezadoPanel.add(btnSalir);
        // Agregar un fondo de color verde esperalda al panel de encabezado
        encabezadoPanel.setBackground(new java.awt.Color(0, 128, 0));

        // Agregar el panel de encabezado a la ventana
        getContentPane().add(encabezadoPanel, BorderLayout.NORTH);
    }// fin de initEncabezadoPanel

    // metodo para el panel del formulario.
    private void initFormularioPanel() {
        // Crear los objetos de los componentes del panel de formulario
        formularioPanel = new JPanel();
        lblIdUsuario = new JLabel("ID Usuario:");
        lblNombre = new JLabel("Nombre:");
        lblApellidoPaterno = new JLabel("Apellido Paterno:");
        lblApellidoMaterno = new JLabel("Apellido Materno:");
        lblEmail = new JLabel("Email:");

        txtIdUsuario = new JTextField(20);
        txtNombre = new JTextField(20);
        txtApellidoPaterno = new JTextField(20);
        txtApellidoMaterno = new JTextField(20);
        txtEmail = new JTextField(20);

        // agregar layout y componentes aqui segun sea lo neceario
        formularioPanel.setLayout(null);
        formularioPanel.setBackground(new Color(255, 255, 255));
        formularioPanel.setBounds(0, 100, 800, 500);

        lblIdUsuario.setBounds(10, 10, 100, 30);
        txtIdUsuario.setBounds(120, 10, 200, 30);
        lblNombre.setBounds(10, 50, 100, 30);
        txtNombre.setBounds(120, 50, 200, 30);
        lblApellidoPaterno.setBounds(10, 90, 100, 30);
        txtApellidoPaterno.setBounds(120, 90, 200, 30);
        lblApellidoMaterno.setBounds(10, 130, 100, 30);
        txtApellidoMaterno.setBounds(120, 130, 200, 30);
        lblEmail.setBounds(10, 170, 100, 30);
        txtEmail.setBounds(120, 170, 200, 30);

        // Agregar los componentes al panel de formulario
        formularioPanel.add(lblIdUsuario);
        formularioPanel.add(txtIdUsuario);
        formularioPanel.add(lblNombre);
        formularioPanel.add(txtNombre);
        formularioPanel.add(lblApellidoPaterno);
        formularioPanel.add(txtApellidoPaterno);
        formularioPanel.add(lblApellidoMaterno);
        formularioPanel.add(txtApellidoMaterno);
        formularioPanel.add(lblEmail);
        formularioPanel.add(txtEmail);

        // Agregar el panel de formulario a la ventana
        getContentPane().add(formularioPanel, BorderLayout.CENTER);

    }// fin initFormularioPanel

    // metodo para el panel de contenido, que incluya la tabla de usuarios
    private void initContenidoPanel() {
        // Crear los objetos de los componentes del panel de contenido
        contenidoPanel = new JPanel();
        tablaUsuarios = new JTable();
        modeloTablaUsuarios = new DefaultTableModel();

        // Configurar el modelo de la tabla
        modeloTablaUsuarios.addColumn("ID Usuario");
        modeloTablaUsuarios.addColumn("Nombre");
        modeloTablaUsuarios.addColumn("Apellido Paterno");
        modeloTablaUsuarios.addColumn("Apellido Materno");
        modeloTablaUsuarios.addColumn("Email");

        tablaUsuarios.setModel(modeloTablaUsuarios);
        // agregar filas de ejemplo al modelo tabla y 10 vacias
        modeloTablaUsuarios.addRow(new Object[] { "1", "Juan", "Pérez", "Gómez", "juan.perez@example.com" });
        modeloTablaUsuarios.addRow(new Object[] { "2", "María", "López", "Martínez", "maria.lopez@example.com" });

        // Agregar la tabla al panel de contenido usando un JScrollPane para
        // consistencia de tamaño
        contenidoPanel.setLayout(new BorderLayout());
        javax.swing.JScrollPane scrollTabla = new javax.swing.JScrollPane(tablaUsuarios);
        scrollTabla.setPreferredSize(new Dimension(800, 200));
        contenidoPanel.add(scrollTabla, BorderLayout.CENTER);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contenidoPanel, BorderLayout.SOUTH);
    }// fin initContenidoPanel

    // metodo que cargue los metodos de todos los usuarios a la tabla de usuarios de
    // la basse de datos
    private void cargarUsuariosEnTabla() {
        // limpiar la tabla de usuarios
        modeloTablaUsuarios.setRowCount(0);
        // llamar al metodo obtenerTodosLosUsuarios() de la clase UsuarioDAO
        modelo.UsuarioDAO usuarioDAO = new modelo.UsuarioDAO();
        java.util.List<modelo.Usuario> usuarios = usuarioDAO.obtenerTodosLosUsuarios();
        // recorrer la lista de usuarios y agregarlos a la tabla
        for (modelo.Usuario usuario : usuarios) {
            modeloTablaUsuarios.addRow(new Object[] {
                    usuario.getId(),
                    usuario.getNombre(),
                    usuario.getApellidoPaterno(),
                    usuario.getApellidoMaterno(),
                    usuario.getEmail() });
        }
        // agregar el modelo tabla a la tabla de usuarios
        tablaUsuarios.setModel(modeloTablaUsuarios);
    }// fin cargarUsuariosEnTabla

    // metodo para manejar todos eventos de los botones
    private void manejadorEventos() {
        // agregar evento para agregar usuario al boton btnAgregarUsuario
        btnAgregarUsuario.addActionListener(e -> AgregarUsuarioVista());
        {
            // llamar al metodo agregarUsuario() de la clase UsuarioDAO
        }
        // agregar evento para editar usuario al boton btnEditarUsuario
        btnEditarUsuario.addActionListener(e -> actualizarUsuarioVista());
        {
            // llamar al metodo actualizarUsuario() de la clase UsuarioDAO
        }

        // agregar evento para eliminar usuario al btnEliminarUsuario
        btnEliminarUsuario.addActionListener(e -> eliminarUsuarioVista());
        {
            // llamar al metodo eliminarUsuario() de la clase UsuarioDAO
        }

        // agregar evento para buscar obtenerUsuario por id al boton btnBuscarUsuario
        btnBuscarUsuario.addActionListener(e -> btnObtenerUsuario());
        {
            // llamar al metodo buscarUsuario() de la clase UsuarioDAO
        }
    }// fin manejadorEventos

    // metodo para agregar usuario a la base de datos
    private void AgregarUsuarioVista() {
        // obtener los datos del formulario
        int id = 0;
        try {
            id = Integer.parseInt(txtIdUsuario.getText());
        } catch (NumberFormatException e) {
            // el ID no es necesario para agregar, se auto-genera
        }
        String nombre = txtNombre.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        String email = txtEmail.getText();

        // crear un objeto de la clase Usuario
        modelo.Usuario usuario = new modelo.Usuario(id, nombre, apellidoPaterno, apellidoMaterno, email, "");

        // llamar al metodo agregarUsuario() de la clase UsuarioDAO
        modelo.UsuarioDAO usuarioDAO = new modelo.UsuarioDAO();
        boolean resultado = usuarioDAO.agregarUsuario(usuario);

        // mostrar mensaje de resultado
        if (resultado) {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuario agregado correctamente");
            // limpiar el formulario
            txtIdUsuario.setText("");
            txtNombre.setText("");
            txtApellidoPaterno.setText("");
            txtApellidoMaterno.setText("");
            txtEmail.setText("");
            // cargar los usuarios en la tabla
            cargarUsuariosEnTabla();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al agregar usuario");
        }
    }// fin AgregarUsuarioVista

    // metodo para editar usuario a la base de datos
    private void actualizarUsuarioVista() {
        // obtener los datos del formulario
        int id = 0;
        try {
            id = Integer.parseInt(txtIdUsuario.getText());
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar un ID valido para actualizar");
            return;
        }
        String nombre = txtNombre.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        String email = txtEmail.getText();

        // crear un objeto de la clase Usuario
        modelo.Usuario usuario = new modelo.Usuario(id, nombre, apellidoPaterno, apellidoMaterno, email, null);

        // llamar al metodo actualizarUsuario() de la clase UsuarioDAO
        modelo.UsuarioDAO usuarioDAO = new modelo.UsuarioDAO();
        boolean resultado = usuarioDAO.actualizarUsuario(usuario);

        // mostrar mensaje de resultado
        if (resultado) {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente");
            // limpiar el formulario
            txtIdUsuario.setText("");
            txtNombre.setText("");
            txtApellidoPaterno.setText("");
            txtApellidoMaterno.setText("");
            txtEmail.setText("");
            // cargar los usuarios en la tabla
            cargarUsuariosEnTabla();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar usuario");
        }
    }// fin actualizarUsuarioVista

    // agregar metodo para eliminar usuario a la base de datos
    private void eliminarUsuarioVista() {
        // obtener el id del usuario a eliminar
        int id = 0;
        try {
            id = Integer.parseInt(txtIdUsuario.getText());
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar un ID valido para eliminar");
            return;
        }

        // llamar al metodo eliminarUsuario() de la clase UsuarioDAO
        modelo.UsuarioDAO usuarioDAO = new modelo.UsuarioDAO();
        boolean resultado = usuarioDAO.eliminarUsuario(id);

        // mostrar mensaje de resultado
        if (resultado) {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente");
            // limpiar el formulario
            txtIdUsuario.setText("");
            txtNombre.setText("");
            txtApellidoPaterno.setText("");
            txtApellidoMaterno.setText("");
            txtEmail.setText("");
            // cargar los usuarios en la tabla
            cargarUsuariosEnTabla();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar usuario");
        }
    }// fin eliminarUsuarioVista

    // agregar metodo para buscar usuario por id a la base de datos
    private void btnObtenerUsuario() {
        // obtener el id del usuario a buscar
        int id = Integer.parseInt(txtBuscarUsuario.getText());

        // llamar al metodo obtenerUsuarioPorId() de la clase UsuarioDAO
        modelo.UsuarioDAO usuarioDAO = new modelo.UsuarioDAO();
        modelo.Usuario usuario = usuarioDAO.obtenerUsuarioPorId(id);

        // mostrar mensaje de resultado
        if (usuario != null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuario encontrado");
            // llenar el formulario con los datos del usuario
            txtNombre.setText(usuario.getNombre());
            txtApellidoPaterno.setText(usuario.getApellidoPaterno());
            txtApellidoMaterno.setText(usuario.getApellidoMaterno());
            txtEmail.setText(usuario.getEmail());
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuario no encontrado");
        }
    }// fin btnObtenerUsuarioPorId

    // método main para ejecutar la aplicación
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            VistaUsuario ventana = new VistaUsuario();
            ventana.setVisible(true);
        });
    }// fin main
}// fin clase VistaUsuario
