package dbConnection1SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/pruebas";
    private static final String usuario = "root";
    private static final String password = "1234";

    public static void main(String[] args) {

        Connection dbConnection = null;
        java.sql.Statement statement = null;

        try {
            Class.forName(DRIVER);
            dbConnection = DriverManager.getConnection(URL_CONEXION, usuario, password);
            String selectTableSQL = "SELECT ID,USERNAME,CONTRASENA,NOMBRE FROM usuarios";
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String usr = rs.getString("USERNAME");
                String psw = rs.getString("CONTRASENA");
                String nombre = rs.getString("NOMBRE");
                System.out.println("userid : " + id);
                System.out.println("usr : " + usr);
                System.out.println("psw : " + psw);
                System.out.println("nombre : " + nombre);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
