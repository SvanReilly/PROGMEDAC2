package dbConnection1SQL;
//EJERCICIO 1: Inserción en BBDD orientadas a objetos

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseConnectionBorrador{
	//private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/pruebas";
    //private static final String usuario = "root";
    //private static final String password = "1234";

public void insertarRegistro(String nombre, int edad){

    try{

        //Creamos la conexión a BBDD
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mi_bd", "usuario", "contraseña"); // (URL, USER, PASSWORD)

        //Creamos la consulta SQL para insertar en BBDD

        //TODO -------------------------------------------------------------------------------------------------------
        String sql = "INSERT INTO usuarios VALUES (?, ?)"; //Debemos realizar una sentencia sql válida en la que los valores a añadir aparezcan como ?
        //------------------------------------------------------------------------------------------------------------

        //Creamos el objeto PreparedSteatement responsable de la ejecución de la consulta
        PreparedStatement pstmt = connection.prepareStatement(sql);

        //Asignamos los valores a los parámetros necesarios para la consulta SQL

        //TODO -------------------------------------------------------------------------------------------------------
        /*Ejemplos: pstmt.setTIPO(posicion_sentencia, valor_atributo); 
            - Existen setString, setInt, etc
            - Las posiciones empieza en 1*/
            
            pstmt.setString(1, nombre);
            pstmt.setInt(2, edad);
        

        //------------------------------------------------------------------------------------------------------------
        
        //Ejecutamos la consulta
        int filasAfectadas = pstmt.executeUpdate();

        //Verificamos si la consulta SQL se ejecutó correctamente
        if (filasAfectadas > 0){
            System.out.println("Se ha ejecutado correctamente la secuencia SQL. Total de filas afectadas: " + filasAfectadas);
        }
        else{
            System.out.println("No se ha modificado ninguna fila de la BBDD.");
        }

        //Cerramos la conexión y el objeto PreparedStatement
        pstmt.close();
        connection.close();

    } catch (SQLException e){
        System.err.println("Error al insertar el registro: " + e.getMessage());
    }
}

//EJERCICIO 2: Borrado en BBDD orientadas a objetos

public void eliminarRegistro(int id){

    try{

        //Creamos la conexión a BBDD
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mi_bd", "usuario", "contraseña");

        //Creamos la consulta SQL para borrar en BBDD

        //TO DO -------------------------------------------------------------------------------------------------------
        String sql = "DELETE FROM usuarios WHERE id=?"; //Debemos realizar una sentencia sql válida en la que los valores a añadir aparezcan como ?
        //------------------------------------------------------------------------------------------------------------

        //Creamos el objeto PreparedSteatement responsable de la ejecución de la consulta
        PreparedStatement pstmt = connection.prepareStatement(sql);

        
        //Asignamos los valores a los parámetros necesarios para la consulta SQL

        //TO DO -------------------------------------------------------------------------------------------------------
        /*Ejemplos: pstmt.setTIPO(posicion_sentencia, valor_atributo); 
            - Existen setString, setInt, etc
            - Las posiciones empieza en 1
        */
        
        pstmt.setInt(1, id);
        //------------------------------------------------------------------------------------------------------------
        
        //Ejecutamos la consulta
        int filasAfectadas = pstmt.executeUpdate();

        //Verificamos si la consulta SQL se ejecutó correctamente
        if (filasAfectadas > 0){
            System.out.println("Se ha ejecutado correctamente la secuencia SQL. Total de filas afectadas: " + filasAfectadas);
        }
        else{
            System.out.println("No se ha modificado ninguna fila de la BBDD.");
        }

        //Cerramos la conexión y el objeto PreparedStatement
        pstmt.close();
        connection.close();

    } catch (SQLException e){
        System.err.println("Error al insertar el registro: " + e.getMessage());
    }
}

//EJERCICIO 3: Modificación en BBDD orientadas a objetos

public void modificarDatos(int id, String nombre, int edad){

    try{

        //Creamos la conexión a BBDD 
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mi_bd", "usuario", "contraseña");

        //Creamos la consulta SQL para modificar valores en BBDD

        //TO DO -------------------------------------------------------------------------------------------------------
        String sql = "UPDATE usuarios SET nombre = ?, edad = ? WHERE id = ?"; //Debemos realizar una sentencia sql válida en la que los valores a añadir aparezcan como ?
        //------------------------------------------------------------------------------------------------------------

        //Creamos el objeto PreparedSteatement responsable de la ejecución de la consulta
        PreparedStatement pstmt = connection.prepareStatement(sql);


        //Asignamos los valores a los parámetros necesarios para la consulta SQL

        //TO DO -------------------------------------------------------------------------------------------------------
        /*Ejemplos: pstmt.setTIPO(posicion_sentencia, valor_atributo); 
            - Existen setString, setInt, etc
            - Las posiciones empieza en 1
        */
        pstmt.setString(1, nombre);
        pstmt.setInt(2, edad);
        pstmt.setInt(3, id);
        //------------------------------------------------------------------------------------------------------------
        
        //Ejecutamos la consulta
        int filasAfectadas = pstmt.executeUpdate();

        //Verificamos si la consulta SQL se ejecutó correctamente
        if (filasAfectadas > 0){
            System.out.println("Se ha ejecutado correctamente la secuencia SQL. Total de filas afectadas: " + filasAfectadas);
        }
        else{
            System.out.println("No se ha modificado ninguna fila de la BBDD.");
        }

        //Cerramos la conexión y el objeto PreparedStatement
        pstmt.close();
        connection.close();

    } catch (SQLException e){
        System.err.println("Error al insertar el registro: " + e.getMessage());
    }
}
}
