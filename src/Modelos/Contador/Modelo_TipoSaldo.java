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
public class Modelo_TipoSaldo {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

    private int id_TipoSaldo;
    private String TipoSaldo;

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

    public int getId_TipoSaldo() {
        return id_TipoSaldo;
    }

    public void setId_TipoSaldo(int id_TipoSaldo) {
        this.id_TipoSaldo = id_TipoSaldo;
    }

    public String getTipoSaldo() {
        return TipoSaldo;
    }

    public void setTipoSaldo(String TipoSaldo) {
        this.TipoSaldo = TipoSaldo;
    }

    public Modelo_TipoSaldo(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm, int id_TipoCuenta, String TipoCuenta) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;

        this.id_TipoSaldo = id_TipoCuenta;
        this.TipoSaldo = TipoCuenta;
    }

    public Modelo_TipoSaldo() {
        this.claseConectar = new ClaseConexion();
    }

    public ArrayList<Modelo_TipoSaldo> Get_TipoCuentas() {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                SELECT "id_Tipo_saldo", "Tipo_saldo"
                FROM public."Tbl_TipoSaldo";""";

            pstm = conexionDB.prepareStatement(sql);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_TipoSaldo> Modelo_TipoSaldo_Listado = new ArrayList<>();
            
            while (consulta.next()) {
                Modelo_TipoSaldo TipoCuenta = new Modelo_TipoSaldo();

                TipoCuenta.setId_TipoSaldo(consulta.getInt("id_Tipo_saldo"));
                TipoCuenta.setTipoSaldo(consulta.getString("Tipo_saldo"));

                Modelo_TipoSaldo_Listado.add(TipoCuenta);
            }

            conexionDB.close();
            return Modelo_TipoSaldo_Listado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_TipoSaldo.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public Modelo_TipoSaldo Get_TipoCuenta(int id_saldo) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                SELECT "id_Tipo_saldo", "Tipo_saldo"
                FROM public."Tbl_TipoSaldo"
                WHERE "id_Tipo_saldo" = ? ;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, id_saldo);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            Modelo_TipoSaldo TipoCuenta = new Modelo_TipoSaldo();

            while (consulta.next()) {
                TipoCuenta.setId_TipoSaldo(consulta.getInt("id_Tipo_saldo"));
                TipoCuenta.setTipoSaldo(consulta.getString("Tipo_saldo"));

            }

            conexionDB.close();
            return TipoCuenta;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_TipoSaldo.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }

        return null;
    }

}
