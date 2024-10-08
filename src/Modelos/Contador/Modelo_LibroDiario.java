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
public class Modelo_LibroDiario {

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

    public Modelo_LibroDiario(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm, int id_Libro_diario, Date Fecha, String Nombre_cuenta, String Tipo_documento, String Tipo_saldo, Double Saldo, int id_Tipo_doc, int id_Tipo_saldo) {
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

    public Modelo_LibroDiario() {
        this.claseConectar = new ClaseConexion();
    }

    public Map<Integer, ArrayList<Modelo_LibroDiario>> Get_LibroDiario() throws SQLException {

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

        Map<Integer, ArrayList<Modelo_LibroDiario>> periodosPorPartida = new HashMap<>();

        while (consulta.next()) {
            Modelo_LibroDiario Periodo = new Modelo_LibroDiario();

            Periodo.setId_Libro_diario(consulta.getInt("LibroDiario_id"));
            Periodo.setFecha(consulta.getDate("Fecha"));
            Periodo.setNombre_cuenta(consulta.getString("Nombre_cuenta"));
            Periodo.setTipo_documento(consulta.getString("Tipo_documento"));
            Periodo.setTipo_saldo(consulta.getString("Tipo_saldo"));
            Periodo.setSaldo(consulta.getDouble("Monto"));

            int NumeroPartida = consulta.getInt("LibroDiario_id");

            periodosPorPartida.putIfAbsent(NumeroPartida, new ArrayList<>());

            periodosPorPartida.get(NumeroPartida).add(Periodo);
        }

        for (Map.Entry<Integer, ArrayList<Modelo_LibroDiario>> entrada : periodosPorPartida.entrySet()) {
            int partidaId = entrada.getKey();
            ArrayList<Modelo_LibroDiario> periodos = entrada.getValue();

            System.out.println("\nPartida número : " + partidaId);
            System.out.println("+----------------------------------------------------------------+");
            System.out.printf("| %-13s | %-24s | %-8s | %-8s |\n", "Fecha", "Cuenta", "Debe", "Haber");
            System.out.println("+----------------------------------------------------------------+");

            double totalDebe = 0;
            double totalHaber = 0;

            for (Modelo_LibroDiario periodo : periodos) {
                String fecha = periodo.getFecha().toString();
                String nombreCuenta = periodo.getNombre_cuenta();
                String tipoSaldo = periodo.getTipo_saldo();
                double saldo = periodo.getSaldo();

                String debe = "";
                String haber = "";

                if (tipoSaldo.equalsIgnoreCase("Deudor")) {
                    debe = String.format("%.2f", saldo);
                    totalDebe += saldo;
                } else if (tipoSaldo.equalsIgnoreCase("Acreedor")) {
                    haber = String.format("%.2f", saldo);
                    totalHaber += saldo;
                }

                System.out.printf("| %-13s | %-24s | %-8s | %-8s |\n", fecha, nombreCuenta, debe, haber);
            }

            System.out.println("+----------------------------------------------------------------+");
            System.out.printf("| %-13s | %-24s | %-8s | %-8s |\n", "SUBTOTALES ", "", String.format("%.2f", totalDebe), String.format("%.2f", totalHaber));
            System.out.println("+----------------------------------------------------------------+\n");
        }

        conexionDB.close();
        return periodosPorPartida;
    }

}
