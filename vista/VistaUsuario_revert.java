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

public class VistaUsuario extends JFrame{



    //atributos de la clase
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

    //constructor vacío
    public VistaUsuario() {
        // Configuración de la ventana
        initComponents();
          //iniciar el metodo cargarUsuariosEnTabla() para que cargue los usuarios de la base de datos en la tabla
        cargarUsuariosEnTabla();
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

    }//fin initComponents



    //metodo para el panel de encabezado, que incluya  los botones paraa el crud
    //(agregar, editar, eliminar, buscar) y un campo de texto para la búsqueda
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
        //Agregar un fondo  de color verde esperalda al panel de encabezado
        encabezadoPanel.setBackground(new java.awt.Color(0, 128, 0));

        // Agregar el panel de encabezado a la ventana
        getContentPane().add(encabezadoPanel, BorderLayout.NORTH);
    }//fin de initEncabezadoPanel



    //metodo para el panel del formulario.
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

        //agregar layout y  componentes aqui segun sea lo neceario
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

    }//fin initFormularioPanel



    //metodo para el panel de contenido, que incluya la tabla de usuarios
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
        //agregar filas de ejemplo al modelo tabla y 10 vacias
        modeloTablaUsuarios.addRow(new Object[]{"1", "Juan", "Pérez", "Gómez", "juan.perez@example.com"});
        modeloTablaUsuarios.addRow(new Object[]{"2", "María", "López", "Martínez", "maria.lopez@example.com"});


        // Agregar la tabla al panel de contenido
        contenidoPanel.setLayout(new BorderLayout());
        contenidoPanel.add(tablaUsuarios.getTableHeader(), BorderLayout.NORTH);
        contenidoPanel.add(tablaUsuarios, BorderLayout.CENTER);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contenidoPanel, BorderLayout.SOUTH);
    }//fin initContenidoPanel



    //metodo que cargue los metodos de todos los usuarios a la tabla de usuarios de la basse de datos
    private void cargarUsuariosEnTabla() {
        //limpiar la tabla de usuarios
        modeloTablaUsuarios.setRowCount(0);
        //llamar al metodo obtenerTodosLosUsuarios() de la clase UsuarioDAO
        modelo.UsuarioDAO usuarioDAO = new modelo.UsuarioDAO();
        java.util.List<modelo.Usuario> usuarios = usuarioDAO.obtenerTodosLosUsuarios();
        //recorrer la lista de usuarios y agregarlos a la tabla
        for (modelo.Usuario usuario : usuarios) {
            modeloTablaUsuarios.addRow(new Object[]{
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellidoPaterno(),
                usuario.getApellidoMaterno(),
                usuario.getEmail()});
        }
        //agregar el modelo tabla a la tabla de usuarios
        tablaUsuarios.setModel(modeloTablaUsuarios);
    }//fin cargarUsuariosEnTabla



    //método main para ejecutar la aplicación
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            VistaUsuario ventana = new VistaUsuario();
            ventana.setVisible(true);
        });
    }//fin main
}//fin clase VistaUsuario
