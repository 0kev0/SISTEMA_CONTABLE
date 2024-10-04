package Conexion;

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
        this.pass = "Ally.2203";
        this.url = "jdbc:postgresql://localhost:5432/contables";

    }

    public Connection iniciarConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, usuario, pass);
            boolean estado = conexion.isValid(50000);
            System.out.println(estado ? "Conexión exitosa\n" : "ERROR al conectar\n");
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
