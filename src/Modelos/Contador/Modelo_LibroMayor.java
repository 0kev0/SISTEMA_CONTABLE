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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kev
 */
public class Modelo_LibroMayor {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

    private int id_Libro_diario;
    private Date Fecha;
    private String Nombre_cuenta;
    private String Tipo_documento;
    private String Tipo_saldo;
    private Double Saldo;
    private int id_Tipo_doc;
    private int id_Tipo_saldo;

    private ArrayList<Modelo_LibroMayor> deudores;
    private ArrayList<Modelo_LibroMayor> acreedores;

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

    public int getId_Libro_diario() {
        return id_Libro_diario;
    }

    public void setId_Libro_diario(int id_Libro_diario) {
        this.id_Libro_diario = id_Libro_diario;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getNombre_cuenta() {
        return Nombre_cuenta;
    }

    public void setNombre_cuenta(String Nombre_cuenta) {
        this.Nombre_cuenta = Nombre_cuenta;
    }

    public String getTipo_documento() {
        return Tipo_documento;
    }

    public void setTipo_documento(String Tipo_documento) {
        this.Tipo_documento = Tipo_documento;
    }

    public String getTipo_saldo() {
        return Tipo_saldo;
    }

    public void setTipo_saldo(String Tipo_saldo) {
        this.Tipo_saldo = Tipo_saldo;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double Saldo) {
        this.Saldo = Saldo;
    }

    public int getId_Tipo_doc() {
        return id_Tipo_doc;
    }

    public void setId_Tipo_doc(int id_Tipo_doc) {
        this.id_Tipo_doc = id_Tipo_doc;
    }

    public int getId_Tipo_saldo() {
        return id_Tipo_saldo;
    }

    public void setId_Tipo_saldo(int id_Tipo_saldo) {
        this.id_Tipo_saldo = id_Tipo_saldo;
    }

    public Modelo_LibroMayor(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm, int id_Libro_diario, Date Fecha, String Nombre_cuenta, String Tipo_documento, String Tipo_saldo, Double Saldo, int id_Tipo_doc, int id_Tipo_saldo) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;
        this.id_Libro_diario = id_Libro_diario;
        this.Fecha = Fecha;
        this.Nombre_cuenta = Nombre_cuenta;
        this.Tipo_documento = Tipo_documento;
        this.Tipo_saldo = Tipo_saldo;
        this.Saldo = Saldo;
        this.id_Tipo_doc = id_Tipo_doc;
        this.id_Tipo_saldo = id_Tipo_saldo;
    }

    public Modelo_LibroMayor() {
        this.claseConectar = new ClaseConexion();
    }

    public Modelo_LibroMayor(ArrayList<Modelo_LibroMayor> deudores, ArrayList<Modelo_LibroMayor> acreedores) {
        this.deudores = deudores;
        this.acreedores = acreedores;
    }

    public ArrayList<Modelo_LibroMayor> getDeudores() {
        return deudores;
    }

    public ArrayList<Modelo_LibroMayor> getAcreedores() {
        return acreedores;
    }

    public ArrayList<Modelo_LibroMayor> Get_LibroMayor() throws SQLException {

        conexionDB = claseConectar.iniciarConexion(); // Iniciamos la conexión
        String sql = """
    SELECT TBL_P."Fecha" ,TBL_LD."id_Libro_diario",TBL_C."Nombre_cuenta",TBL_TS."Tipo_saldo",TBL_TD."Tipo_documento"
        ,TBL_P."LibroDiario_id",TBL_P."Monto",TBL_P."id_Partida"
        FROM public."Tbl_LibroDiario" AS TBL_LD
        INNER JOIN "Tbl_Partida" AS TBL_P ON TBL_P."id_Partida" = TBL_LD."Partida_id"
        INNER JOIN "Tbl_Catalogo" AS TBL_C ON TBL_C."id_Cuenta" = TBL_P."Cuenta_id"
        INNER JOIN "Tbl_TipoSaldo" AS TBL_TS ON TBL_TS."id_Tipo_saldo" = TBL_P."Tipo_saldo_id"
        INNER JOIN "Tbl_TipoDocumento" AS TBL_TD ON TBL_TD."id_TipoDoc" = TBL_P."Tipo_documento_id";""";

        pstm = conexionDB.prepareStatement(sql);

        ResultSet consulta = pstm.executeQuery();

        ArrayList<Modelo_LibroMayor> periodosPorPartida = new ArrayList<>();

        while (consulta.next()) {
            if (consulta.getString("Tipo_saldo").equals("Deudor")) {
                Modelo_LibroMayor PartidasDebe = new Modelo_LibroMayor();

                PartidasDebe.setFecha(consulta.getDate("Fecha"));
                PartidasDebe.setId_Libro_diario(consulta.getInt("LibroDiario_id"));
                PartidasDebe.setSaldo(consulta.getDouble("Monto"));
            }

            Modelo_LibroMayor PartidasHaber = new Modelo_LibroMayor();

            PartidasHaber.setFecha(consulta.getDate("Fecha"));
            PartidasHaber.setId_Libro_diario(consulta.getInt("LibroDiario_id"));
            PartidasHaber.setSaldo(consulta.getDouble("Monto"));

        }

        conexionDB.close();
        return periodosPorPartida;
    }

    public Modelo_LibroMayor Get_LibroMayor_() throws SQLException {

        conexionDB = claseConectar.iniciarConexion();
        //modificar para que vaya por cuenta
        String sql = """
SELECT TBL_P."Fecha", TBL_LD."id_Libro_diario", TBL_C."Nombre_cuenta", TBL_TS."Tipo_saldo", TBL_TD."Tipo_documento",
               TBL_P."LibroDiario_id", TBL_P."Monto", TBL_P."id_Partida",TBL_TC."Tipo_cuenta"
    FROM public."Tbl_LibroDiario" AS TBL_LD
    INNER JOIN "Tbl_Partida" AS TBL_P ON TBL_P."id_Partida" = TBL_LD."Partida_id"
    INNER JOIN "Tbl_Catalogo" AS TBL_C ON TBL_C."id_Cuenta" = TBL_P."Cuenta_id"
    INNER JOIN "Tbl_TipoSaldo" AS TBL_TS ON TBL_TS."id_Tipo_saldo" = TBL_P."Tipo_saldo_id"
    INNER JOIN "Tbl_TipoDocumento" AS TBL_TD ON TBL_TD."id_TipoDoc" = TBL_P."Tipo_documento_id"
    INNER JOIN "Tbl_TipoCuenta" AS TBL_TC ON TBL_TC."id_Tipo_cuenta" = TBL_C."Tipo_cuenta_id"
    ORDER BY TBL_LD."id_Libro_diario" ASC ;
    	""";

        pstm = conexionDB.prepareStatement(sql);
        ResultSet consulta = pstm.executeQuery();

        ArrayList<Modelo_LibroMayor> deudores = new ArrayList<>();
        ArrayList<Modelo_LibroMayor> acreedores = new ArrayList<>();

        while (consulta.next()) {
            if (consulta.getString("Tipo_saldo").equals("Deudor")) {
                Modelo_LibroMayor partidaDebe = new Modelo_LibroMayor();
                partidaDebe.setFecha(consulta.getDate("Fecha"));
                partidaDebe.setId_Libro_diario(consulta.getInt("LibroDiario_id"));
                partidaDebe.setSaldo(consulta.getDouble("Monto"));

                Modelo_LibroMayor partidaHaber = new Modelo_LibroMayor();
                partidaHaber.setFecha(null);
                partidaHaber.setId_Libro_diario(0);
                partidaHaber.setSaldo(0.0);

                acreedores.add(partidaHaber);
                deudores.add(partidaDebe);
                
            } else {
                Modelo_LibroMayor partidaHaber = new Modelo_LibroMayor();
                partidaHaber.setFecha(consulta.getDate("Fecha"));
                partidaHaber.setId_Libro_diario(consulta.getInt("LibroDiario_id"));
                partidaHaber.setSaldo(consulta.getDouble("Monto"));

                Modelo_LibroMayor partidaDebe = new Modelo_LibroMayor();
                partidaDebe.setFecha(null);
                partidaDebe.setId_Libro_diario(0);
                partidaDebe.setSaldo(0.0);
                
                acreedores.add(partidaHaber);
                deudores.add(partidaDebe);
            }
        }

        conexionDB.close();

        return new Modelo_LibroMayor(deudores, acreedores);
    }

}
