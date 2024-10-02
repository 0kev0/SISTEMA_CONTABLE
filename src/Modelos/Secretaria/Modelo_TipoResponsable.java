package Modelos.Secretaria;

import Conexion.ClaseConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_TipoResponsable {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

//lado escritorio
    private int Id_TipoResponsable;
    private String TipoResponsable;

    public Connection getConexionDB() {
        return conexionDB;
    }

    public void setConexionDB(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
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

    public int getId_TipoResponsable() {
        return Id_TipoResponsable;
    }

    public void setId_TipoResponsable(int Id_TipoResponsable) {
        this.Id_TipoResponsable = Id_TipoResponsable;
    }

    public String getTipoResponsable() {
        return TipoResponsable;
    }

    public void setTipoResponsable(String TipoResponsable) {
        this.TipoResponsable = TipoResponsable;
    }

    public Modelo_TipoResponsable(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int Id_TipoResponsable, String TipoResponsable) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;
        this.Id_TipoResponsable = Id_TipoResponsable;
        this.TipoResponsable = TipoResponsable;
    }

    public Modelo_TipoResponsable() {
        this.claseConectar = new ClaseConexion();
    }

    /**
     * @return
     * *******************************************************************************************************************
     */
    public ArrayList<Modelo_TipoResponsable> Get_List_TipoResponsable() {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = "SELECT id, \"Tipo_de_responsable\" FROM public.\"Tbl_Tipos_Responsables\";";

            pstm = conexionDB.prepareStatement(sql);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_TipoResponsable> TiposDeResponsables = new ArrayList<>();

            while (consulta.next()) {
                Modelo_TipoResponsable Tipo = new Modelo_TipoResponsable();

                Tipo.setId_TipoResponsable(consulta.getInt("id"));
                Tipo.setTipoResponsable(consulta.getString("Tipo_de_responsable"));

                TiposDeResponsables.add(Tipo);
            }

            conexionDB.close();
            return TiposDeResponsables;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_TipoResponsable.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
            System.err.println("Error al obtener el listado: " + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Modelo_TipoResponsable.class.getName()).log(Level.SEVERE, "Unknown error occurred", ex);
            System.err.println("An unknown error occurred: " + ex.getMessage());
        }

        return null;
    }
}
