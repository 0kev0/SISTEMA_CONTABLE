
package Modelo.Director;

import Conexion.ClaseConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Gestion_Personal {
    private Connection conexionDB;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

    private int NIE;
    private String Nombres;
    private String Apellidos;
    private String Rol_id;
    private String Grado_id;
    private String Materia_id;

    public Connection getConexionDB() {
        return conexionDB;
    }

    public void setConexionDB(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    public ClaseConexion getClaseConectar() {
        return claseConectar;
    }

    public void setClaseConectar(ClaseConexion claseConectar) {
        this.claseConectar = claseConectar;
    }

    public PreparedStatement getPstm() {
        return pstm;
    }

    public void setPstm(PreparedStatement pstm) {
        this.pstm = pstm;
    }

    public int getNIE() {
        return NIE;
    }

    public void setNIE(int NIE) {
        this.NIE = NIE;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getRol_id() {
        return Rol_id;
    }

    public void setRol_id(String Rol_id) {
        this.Rol_id = Rol_id;
    }

    public String getGrado_id() {
        return Grado_id;
    }

    public void setGrado_id(String Grado_id) {
        this.Grado_id = Grado_id;
    }

    public String getMateria_id() {
        return Materia_id;
    }

    public void setMateria_id(String Materia_id) {
        this.Materia_id = Materia_id;
    }

    public Modelo_Gestion_Personal() {
        claseConectar = new ClaseConexion();
    }

    // DEVUELVE LISTA DE FILAS PARA MOSTRAR EN TABLA
    public ArrayList<Modelo_Gestion_Personal> getPersonal() {
    ArrayList<Modelo_Gestion_Personal> Data_Personal = new ArrayList<>();
    try {
        conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
        System.out.println("###BUSQUEDA GENERAL");

         String sql = """
    SELECT TP."NIE", TP."Nombres", TP."Apellidos", TR."Rol", TG."Grado", TM."Nombre" as "Materia"
    FROM public."Tbl_Personal" AS TP
    INNER JOIN "Tbl_Roles" AS TR ON TP."Rol_id" = TR."id"
    INNER JOIN "Tbl_Grados" AS TG ON TP."Grado_id" = TG."id"
    INNER JOIN "Tbl_Materias" AS TM ON TP."Materia_id" = TM."id"
""";

        pstm = conexionDB.prepareStatement(sql);
        ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

        while (consulta.next()) {
    Modelo_Gestion_Personal personal = new Modelo_Gestion_Personal();

    personal.setNIE(consulta.getInt("NIE"));
    personal.setNombres(consulta.getString("Nombres"));
    personal.setApellidos(consulta.getString("Apellidos"));
    personal.setRol_id(consulta.getString("Rol"));
    personal.setGrado_id(consulta.getString("Grado"));
    personal.setMateria_id(consulta.getString("Materia"));

    Data_Personal.add(personal);
}


        consulta.close();
        pstm.close();
        conexionDB.close();
    } catch (SQLException ex) {
        Logger.getLogger(Modelo_Gestion_Personal.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Data_Personal;
}
}

