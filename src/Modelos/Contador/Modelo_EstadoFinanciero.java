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
import java.util.Map;

/**
 *
 * @author kev
 */
public class Modelo_EstadoFinanciero {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

    private int id_EstadoResultado;
    private String Nombre_cuenta;
    private String Tipo_saldo;
    private Double SaldoDebe;
    private Double Saldo;
    private int id_CodigoCuenta;
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

    public int getId_EstadoResultado() {
        return id_EstadoResultado;
    }

    public void setId_EstadoResultado(int id_EstadoResultado) {
        this.id_EstadoResultado = id_EstadoResultado;
    }

    public String getNombre_cuenta() {
        return Nombre_cuenta;
    }

    public void setNombre_cuenta(String Nombre_cuenta) {
        this.Nombre_cuenta = Nombre_cuenta;
    }

    public String getTipo_saldo() {
        return Tipo_saldo;
    }

    public void setTipo_saldo(String Tipo_saldo) {
        this.Tipo_saldo = Tipo_saldo;
    }

    public Double getSaldoDebe() {
        return SaldoDebe;
    }

    public void setSaldoDebe(Double SaldoDebe) {
        this.SaldoDebe = SaldoDebe;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double Saldo) {
        this.Saldo = Saldo;
    }

    public int getId_CodigoCuenta() {
        return id_CodigoCuenta;
    }

    public void setId_CodigoCuenta(int id_CodigoCuenta) {
        this.id_CodigoCuenta = id_CodigoCuenta;
    }

    public int getId_Tipo_saldo() {
        return id_Tipo_saldo;
    }

    public void setId_Tipo_saldo(int id_Tipo_saldo) {
        this.id_Tipo_saldo = id_Tipo_saldo;
    }

    public Modelo_EstadoFinanciero(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm, int id_EstadoResultado,
            String Nombre_cuenta, String Tipo_saldo, Double Saldo, int id_CodigoCuenta, int id_Tipo_saldo) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;
        this.id_EstadoResultado = id_EstadoResultado;
        this.Nombre_cuenta = Nombre_cuenta;
        this.Tipo_saldo = Tipo_saldo;
        this.Saldo = Saldo;
        this.id_CodigoCuenta = id_CodigoCuenta;
        this.id_Tipo_saldo = id_Tipo_saldo;
    }

    public Modelo_EstadoFinanciero() {
        this.claseConectar = new ClaseConexion();
    }

    public Map<String, ArrayList<Modelo_EstadoFinanciero>> Get_EstadoFinanciero() throws SQLException {

        conexionDB = claseConectar.iniciarConexion(); // Iniciamos la conexión
        String sql = """
SELECT "id_Libro_diario",TBL_TC."id_Tipo_cuenta",TBL_TC."Tipo_cuenta",TBL_C."id_Cuenta",TBL_C."Nombre_cuenta",TBL_TS."Tipo_saldo",TBL_P."Monto"
FROM public."Tbl_LibroDiario" AS TBL_LD
INNER JOIN "Tbl_Partida" AS TBL_P ON TBL_P."id_Partida" = TBL_LD."Partida_id"
INNER JOIN "Tbl_Catalogo" AS TBL_C ON TBL_C."id_Cuenta" = TBL_P."Cuenta_id"
INNER JOIN "Tbl_TipoSaldo" AS TBL_TS ON TBL_TS."id_Tipo_saldo" = TBL_P."Tipo_saldo_id"
INNER JOIN "Tbl_TipoCuenta" AS TBL_TC ON TBL_TC."id_Tipo_cuenta" = TBL_C."Tipo_cuenta_id"
ORDER BY TBL_TC."id_Tipo_cuenta" ASC;""";

        pstm = conexionDB.prepareStatement(sql);

        ResultSet consulta = pstm.executeQuery();

        Map<String, ArrayList<Modelo_EstadoFinanciero>> periodosPorPartida = new HashMap<>();

        while (consulta.next()) {
            Modelo_EstadoFinanciero Cuenta = new Modelo_EstadoFinanciero();
            //   System.out.println("numero de libro diario" + consulta.getInt("id_Libro_diario"));
            Cuenta.setNombre_cuenta(consulta.getString("Nombre_cuenta"));
            if (Cuenta.setTipo_saldo(consulta.getString("Tipo_saldo").equals("Deudor"))) {
                
            }
            Cuenta.setSaldo(consulta.getDouble("Monto"));

            String TipoCuenta = consulta.getInt("id_Libro_diario") + consulta.getString("Tipo_cuenta");

            periodosPorPartida.putIfAbsent(TipoCuenta, new ArrayList<>());

            periodosPorPartida.get(TipoCuenta).add(Cuenta);
        }

        for (Map.Entry<String, ArrayList<Modelo_EstadoFinanciero>> entrada : periodosPorPartida.entrySet()) {
            String TipoCuenta = entrada.getKey();
            ArrayList<Modelo_EstadoFinanciero> periodos = entrada.getValue();

            System.out.println("\t tipo cuenta: " + TipoCuenta);
            System.out.println("+----------------------------------------------------------------+");
            System.out.printf("| %-13s | %-24s | %-8s |\n", "Cuenta", "Debe", "Haber");
            System.out.println("+----------------------------------------------------------------+");

            double totalDebe = 0;
            double totalHaber = 0;

            for (Modelo_EstadoFinanciero periodo : periodos) {
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

                System.out.printf("| %-13s | %-24s | %-8s |\n", nombreCuenta, debe, haber);
            }

            System.out.println("+----------------------------------------------------------------+");
            System.out.printf("| %-13s | %-24s | %-8s | %-8s |\n", "SUBTOTALES ", "", String.format("%.2f", totalDebe), String.format("%.2f", totalHaber));
            System.out.println("+----------------------------------------------------------------+\n");
        }

        conexionDB.close();
        return periodosPorPartida;
    }

}
