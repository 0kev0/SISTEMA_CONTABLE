package Conexion;

import Funciones.Funciones;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClaseConexion {

    private final String usuario;
    private final String pass;
    private final String url;
    private Connection conexion;

    public ClaseConexion() {

        this.usuario = "postgres";
        this.pass = "1234";
        this.url = "jdbc:postgresql://localhost:5432/postgres";

    }

    public Connection iniciarConexion() {

        String loginfo = " Intento de coneccion a la base de datos... ";
        String Log = Funciones.Registro_Log(loginfo);
        Funciones.escribirEnArchivo(Log);
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, usuario, pass);
            boolean estado = conexion.isValid(50000);
            loginfo = (estado ? "Conexión exitosa" : "ERROR al conectar");
            Log = Funciones.Registro_Log(loginfo);
            Funciones.escribirEnArchivo(Log);
            
            return conexion;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClaseConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

//        this.usuario = "testeo_owner";
//        this.pass = "zgYOavhK9w6U";
//        this.url = "jdbc:postgresql://ep-young-moon-a53deizt.us-east-2.aws.neon.tech/testeo?user=testeo_owner&password=zgYOavhK9w6U&sslmode=require";
