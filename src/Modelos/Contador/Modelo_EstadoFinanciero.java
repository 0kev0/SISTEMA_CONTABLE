package Modelos.Contador;

import Conexion.ClaseConexion;
import Funciones.Funciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public ArrayList<Modelo_EstadoFinanciero> Get_EstadoFinanciero() throws SQLException {

        conexionDB = claseConectar.iniciarConexion(); // Iniciamos la conexión
        String sql = """
SELECT TBL_P."Fecha", TBL_TC."id_Tipo_cuenta", TBL_TC."Tipo_cuenta", 
           TBL_C."id_Cuenta", TBL_C."Nombre_cuenta", TBL_TS."Tipo_saldo", 
           SUM(TBL_P."Monto") AS Total_Monto
    FROM public."Tbl_LibroDiario" AS TBL_LD
    INNER JOIN "Tbl_Partida" AS TBL_P ON TBL_P."id_Partida" = TBL_LD."Partida_id"
    INNER JOIN "Tbl_Catalogo" AS TBL_C ON TBL_C."id_Cuenta" = TBL_P."Cuenta_id"
    INNER JOIN "Tbl_TipoSaldo" AS TBL_TS ON TBL_TS."id_Tipo_saldo" = TBL_P."Tipo_saldo_id"
    INNER JOIN "Tbl_TipoCuenta" AS TBL_TC ON TBL_TC."id_Tipo_cuenta" = TBL_C."Tipo_cuenta_id"
    WHERE EXTRACT(MONTH FROM TBL_P."Fecha") = ?
    GROUP BY TBL_TC."id_Tipo_cuenta", TBL_TC."Tipo_cuenta", 
             TBL_C."id_Cuenta", TBL_C."Nombre_cuenta", 
             TBL_TS."Tipo_saldo", TBL_P."Fecha"
    ORDER BY TBL_TC."id_Tipo_cuenta", TBL_C."Nombre_cuenta" ASC;""";

        int mes = Funciones.Get_MES_Actual();

        pstm = conexionDB.prepareStatement(sql);
        pstm.setInt(1, mes);

        ResultSet consulta = pstm.executeQuery();

        ArrayList<Modelo_EstadoFinanciero> periodosPorPartida = new ArrayList<>();

        while (consulta.next()) {
            System.out.println("Agregando cuenta ");
            String nombreCuenta = consulta.getString("Nombre_cuenta");
            double monto = consulta.getDouble("Total_Monto");

            // Buscar si la cuenta ya existe en el ArrayList
            boolean cuentaExistente = false;
            for (Modelo_EstadoFinanciero cuenta : periodosPorPartida) {
                if (cuenta.getNombre_cuenta().equals(nombreCuenta)) {
                    // Si existe, restamos el monto
                    cuenta.setSaldo(cuenta.getSaldo() - monto);
                    cuentaExistente = true;
                    break; // Salimos del bucle ya que encontramos la cuenta
                }
            }

            // Si la cuenta no existe, la añadimos
            if (!cuentaExistente) {
                Modelo_EstadoFinanciero nuevaCuenta = new Modelo_EstadoFinanciero();
                nuevaCuenta.setNombre_cuenta(nombreCuenta);
                nuevaCuenta.setSaldo(monto);
                nuevaCuenta.setTipo_saldo(consulta.getString("Tipo_saldo"));
                periodosPorPartida.add(nuevaCuenta);
            }
        }

// Filtrar cuentas con saldo positivo
        periodosPorPartida.removeIf(cuenta -> cuenta.getSaldo() < 0);

// Imprimir las cuentas finales
        for (Modelo_EstadoFinanciero cuenta : periodosPorPartida) {
            System.out.println("Cuenta: " + cuenta.getNombre_cuenta() + " tipo saldo: " + cuenta.getTipo_saldo() + ", Saldo: " + cuenta.getSaldo());
        }

        conexionDB.close();
        return periodosPorPartida;
    }

    public ArrayList<Modelo_EstadoFinanciero> Get_EstadoFinanciero_MES(int mes) throws SQLException {

        conexionDB = claseConectar.iniciarConexion(); // Iniciamos la conexión
        String sql = """
SELECT TBL_P."Fecha", TBL_TC."id_Tipo_cuenta", TBL_TC."Tipo_cuenta", 
           TBL_C."id_Cuenta", TBL_C."Nombre_cuenta", TBL_TS."Tipo_saldo", 
           SUM(TBL_P."Monto") AS Total_Monto
    FROM public."Tbl_LibroDiario" AS TBL_LD
    INNER JOIN "Tbl_Partida" AS TBL_P ON TBL_P."id_Partida" = TBL_LD."Partida_id"
    INNER JOIN "Tbl_Catalogo" AS TBL_C ON TBL_C."id_Cuenta" = TBL_P."Cuenta_id"
    INNER JOIN "Tbl_TipoSaldo" AS TBL_TS ON TBL_TS."id_Tipo_saldo" = TBL_P."Tipo_saldo_id"
    INNER JOIN "Tbl_TipoCuenta" AS TBL_TC ON TBL_TC."id_Tipo_cuenta" = TBL_C."Tipo_cuenta_id"
    WHERE EXTRACT(MONTH FROM TBL_P."Fecha") = ?
    GROUP BY TBL_TC."id_Tipo_cuenta", TBL_TC."Tipo_cuenta", 
             TBL_C."id_Cuenta", TBL_C."Nombre_cuenta", 
             TBL_TS."Tipo_saldo", TBL_P."Fecha"
    ORDER BY TBL_TC."id_Tipo_cuenta", TBL_C."Nombre_cuenta" ASC;""";

        pstm = conexionDB.prepareStatement(sql);
        pstm.setInt(1, mes);

        ResultSet consulta = pstm.executeQuery();

        ArrayList<Modelo_EstadoFinanciero> periodosPorPartida = new ArrayList<>();

        while (consulta.next()) {
            System.out.println("Agregando cuenta ");
            String nombreCuenta = consulta.getString("Nombre_cuenta");
            double monto = consulta.getDouble("Total_Monto");

            // Buscar si la cuenta ya existe en el ArrayList
            boolean cuentaExistente = false;
            for (Modelo_EstadoFinanciero cuenta : periodosPorPartida) {
                if (cuenta.getNombre_cuenta().equals(nombreCuenta)) {
                    // Si existe, restamos el monto
                    cuenta.setSaldo(cuenta.getSaldo() - monto);
                    cuentaExistente = true;
                    break; // Salimos del bucle ya que encontramos la cuenta
                }
            }

            // Si la cuenta no existe, la añadimos
            if (!cuentaExistente) {
                Modelo_EstadoFinanciero nuevaCuenta = new Modelo_EstadoFinanciero();
                nuevaCuenta.setNombre_cuenta(nombreCuenta);
                nuevaCuenta.setSaldo(monto);
                nuevaCuenta.setTipo_saldo(consulta.getString("Tipo_saldo"));
                periodosPorPartida.add(nuevaCuenta);
            }
        }

// Filtrar cuentas con saldo positivo
        periodosPorPartida.removeIf(cuenta -> cuenta.getSaldo() < 0);

// Imprimir las cuentas finales
        for (Modelo_EstadoFinanciero cuenta : periodosPorPartida) {
            System.out.println("Cuenta: " + cuenta.getNombre_cuenta() + " tipo saldo: " + cuenta.getTipo_saldo() + ", Saldo: " + cuenta.getSaldo());
        }

        conexionDB.close();
        return periodosPorPartida;
    }

}
