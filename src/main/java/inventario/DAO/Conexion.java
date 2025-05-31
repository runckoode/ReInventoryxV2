package inventario.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection con;


    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


    private final String db;
    private final String user;
    private final String pass;
    private final String url;

    public Conexion(String db) {
        this.db = db;

        this.user = System.getenv().getOrDefault("DB_USER", "user");
        this.pass = System.getenv().getOrDefault("DB_PASS", "userpassword");
        this.url = String.format("jdbc:mysql://localhost:3306/%s?useSSL=false&allowPublicKeyRetrieval=true", this.db);

        try {
            System.out.println("Cargando driver de conexión...");
            Class.forName(DRIVER);
            System.out.println("Driver cargado correctamente.");

            System.out.println("Conectando a la base de datos: " + url);
            // Establish the connection
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión establecida con éxito.");

        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver JDBC: " + e.getMessage());

        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("ErrorCode: " + e.getErrorCode());
        }
    }

    public Connection getConnection() {

        try {
            if (con == null || con.isClosed()) {
                System.err.println("La conexión es nula o está cerrada. Intentando reconectar...");

                System.out.println("Reintentando conectar a la base de datos: " + url);
                con = DriverManager.getConnection(url, user, pass);
                System.out.println("Reconexión establecida con éxito.");
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar o restablecer la conexión: " + e.getMessage());

            return null;
        }
        return con;
    }

    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
