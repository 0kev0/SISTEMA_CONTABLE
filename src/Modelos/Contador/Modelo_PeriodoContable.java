package Modelos.Contador;

import Conexion.ClaseConexion;
import static Funciones.Funciones.TiemSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kev
 */
public class Modelo_PeriodoContable {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

    private int id_Periodo;
    private Date Fecha_inicio;
    private Date Fecha_final;

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

    public int getId_Periodo() {
        return id_Periodo;
    }

    public void setId_Periodo(int id_Periodo) {
        this.id_Periodo = id_Periodo;
    }

    public Date getFecha_inicio() {
        return Fecha_inicio;
    }

    public void setFecha_inicio(Date Fecha_inicio) {
        this.Fecha_inicio = Fecha_inicio;
    }

    public Date getFecha_final() {
        return Fecha_final;
    }

    public void setFecha_final(Date Fecha_final) {
        this.Fecha_final = Fecha_final;
    }

    public Modelo_PeriodoContable(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm, int id_Periodo, Date Fecha_inicio, Date Fecha_final) {
        //Database
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;

        this.id_Periodo = id_Periodo;
        this.Fecha_inicio = Fecha_inicio;
        this.Fecha_final = Fecha_final;
    }

    public Modelo_PeriodoContable() {
        this.claseConectar = new ClaseConexion();
    }

    public ArrayList<Modelo_PeriodoContable> Get_PeriodosContables(int Grado) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
        SELECT "id_Periodo", "Fecha_inicial", "Fecha_final"
	FROM public."Tbl_PeriodosContables";""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, Grado);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_PeriodoContable> PeriodosContables_Listado = new ArrayList<>();
            while (consulta.next()) {
                Modelo_PeriodoContable Periodo = new Modelo_PeriodoContable();

                Periodo.setId_Periodo(consulta.getInt("id_Periodo"));
                Periodo.setFecha_inicio(consulta.getDate("Fecha_inicial"));
                Periodo.setFecha_final(consulta.getDate("Fecha_final"));

                PeriodosContables_Listado.add(Periodo);
            }

            conexionDB.close();
            return PeriodosContables_Listado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_PeriodoContable.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public Modelo_PeriodoContable Get_PeriodoContable(int idDocente) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
        SELECT "id_Periodo", "Fecha_inicial", "Fecha_final"
	FROM public."Tbl_PeriodosContables";""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, idDocente);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta
            Modelo_PeriodoContable Periodo = new Modelo_PeriodoContable();

            while (consulta.next()) {
                Periodo.setId_Periodo(consulta.getInt("id_Periodo"));
                Periodo.setFecha_inicio(consulta.getDate("Fecha_inicial"));
                Periodo.setFecha_final(consulta.getDate("Fecha_final"));

            }

            conexionDB.close();
            return Periodo;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_PeriodoContable.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }

        return null;
    }

}
