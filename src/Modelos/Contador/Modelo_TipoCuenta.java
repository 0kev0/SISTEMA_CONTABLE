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
public class Modelo_TipoCuenta {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

    private int id_TipoCuenta;
    private String TipoCuenta;

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

    public int getId_TipoCuenta() {
        return id_TipoCuenta;
    }

    public void setId_TipoCuenta(int id_TipoCuenta) {
        this.id_TipoCuenta = id_TipoCuenta;
    }

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(String TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    public Modelo_TipoCuenta(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm, int id_TipoCuenta, String TipoCuenta) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;

        this.id_TipoCuenta = id_TipoCuenta;
        this.TipoCuenta = TipoCuenta;
    }

    public Modelo_TipoCuenta() {
        this.claseConectar = new ClaseConexion();
    }

    public ArrayList<Modelo_TipoCuenta> Get_TipoCuentas() {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                SELECT "id_Tipo_cuenta", "Tipo_cuenta"
        	FROM public."Tbl_TipoCuenta";""";

            pstm = conexionDB.prepareStatement(sql);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_TipoCuenta> TipoCuentas_Listado = new ArrayList<>();
            
            while (consulta.next()) {
                Modelo_TipoCuenta TipoCuenta = new Modelo_TipoCuenta();

                TipoCuenta.setId_TipoCuenta(consulta.getInt("id_Tipo_cuenta"));
                TipoCuenta.setTipoCuenta(consulta.getString("Tipo_cuenta"));
                
                System.out.println("id_Tipo_cuenta: " + consulta.getInt("id_Tipo_cuenta") + "   tipo cuenta: " + consulta.getString("Tipo_cuenta"));


                TipoCuentas_Listado.add(TipoCuenta);
            }

            conexionDB.close();
            return TipoCuentas_Listado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_TipoCuenta.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public Modelo_TipoCuenta Get_TipoCuenta(int id_cuenta) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                SELECT "id_Tipo_cuenta", "Tipo_cuenta"
        	FROM public."Tbl_TipoCuenta"
                WHERE "id_Tipo_cuenta" = ? ;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, id_cuenta);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            Modelo_TipoCuenta TipoCuenta = new Modelo_TipoCuenta();

            while (consulta.next()) {
                TipoCuenta.setId_TipoCuenta(consulta.getInt("id_Tipo_cuenta"));
                TipoCuenta.setTipoCuenta(consulta.getString("Tipo_cuenta"));

            }

            conexionDB.close();
            return TipoCuenta;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_TipoCuenta.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }

        return null;
    }

}
