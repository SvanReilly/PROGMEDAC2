package dbConnection1SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/pruebas";
    private static final String usuario = "root";
    private static final String password = "12345";

    public static void main(String[] args) {

    	final String ANSI_RESET = "\u001B[0m";
		final String ANSI_BLACK = "\u001B[30m";
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_YELLOW = "\u001B[33m";
		final String ANSI_BLUE = "\u001B[34m";
		final String ANSI_PURPLE = "\u001B[35m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_WHITE = "\u001B[37m";
		final String ANSI_LIGHT_YELLOW = "\u001B[93m";
		final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
		final String ANSI_BOLD = "\u001B[1m";
		final String ANSI_UNBOLD = "\u001B[21m";
		final String ANSI_UNDERLINE = "\u001B[4m";
		final String ANSI_STOP_UNDERLINE = "\u001B[24m";
		final String ANSI_BLINK = "\u001B[5m";
		
		final String ANSI_LIGHT_BLUE =  "\033[1;34m";
		final String ANSI_LIGHT_CYAN  = "\033[1;36m";
		final String ANSI_LIGHT_GREEN  = "\033[1;32m";
		final String ANSI_LIGHT_PURPLE  = "\033[1;35m";
		final String ANSI_LIGHT_RED =  "\033[1;31m";
		final String ANSI_BROWN = "\033[0;33m";
		final String ANSI_GRAY =  "\033[0;37m";
        //Visit: https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j-8.1.0.zip
    	//Proyecto>Build path>configure build path> Libraries > classpath add external JREs select mysqlconnector.jar
        Connection dbConnection = null;
        java.sql.Statement statement = null;

        try {
            Class.forName(DRIVER);
            dbConnection = DriverManager.getConnection(URL_CONEXION, usuario, password);
            String selectTableSQL = "SELECT ID,USERNAME,CONTRASENA,NOMBRE FROM usuarios";
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            System.out.println(ANSI_GREEN + ANSI_UNDERLINE +"LISTA DE USUARIOS DE PRUEBAS:" + ANSI_RESET +
            		 "\n");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String usr = rs.getString("USERNAME");
                String psw = rs.getString("CONTRASENA");
                String nombre = rs.getString("NOMBRE");
                System.out.println(ANSI_RED + "userid : "+ ANSI_RESET + id);
                System.out.println(ANSI_YELLOW + "usr : "+ ANSI_RESET + usr);
                System.out.println(ANSI_BLUE + "psw : " + ANSI_RESET + psw);
                System.out.println(ANSI_PURPLE + "nombre : "+ ANSI_RESET + nombre);
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
