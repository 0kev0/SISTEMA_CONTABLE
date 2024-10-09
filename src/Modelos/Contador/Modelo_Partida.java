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
public class Modelo_Partida {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

    private int id_transaccion;
    private int id_Cuenta;
    private String NombreCuenta;
    private String TipoSaldo;
    private String TipoDocumento;
    private Date Fecha;
    private Double Monto;
    private int id_TipoDocumento;
    private int id_TipoSaldo;
    private int id_Partida;

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

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getId_Cuenta() {
        return id_Cuenta;
    }

    public void setId_Cuenta(int id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
    }

    public String getNombreCuenta() {
        return NombreCuenta;
    }

    public void setNombreCuenta(String NombreCuenta) {
        this.NombreCuenta = NombreCuenta;
    }

    public String getTipoSaldo() {
        return TipoSaldo;
    }

    public void setTipoSaldo(String TipoSaldo) {
        this.TipoSaldo = TipoSaldo;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    public int getId_TipoDocumento() {
        return id_TipoDocumento;
    }

    public void setId_TipoDocumento(int id_TipoDocumento) {
        this.id_TipoDocumento = id_TipoDocumento;
    }

    public int getId_TipoSaldo() {
        return id_TipoSaldo;
    }

    public void setId_TipoSaldo(int id_TipoSaldo) {
        this.id_TipoSaldo = id_TipoSaldo;
    }

    public int getId_Partida() {
        return id_Partida;
    }

    public void setId_Partida(int id_Partida) {
        this.id_Partida = id_Partida;
    }

    public Modelo_Partida(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int id_transaccion, int id_Cuenta, String NombreCuenta, String TipoSaldo, String TipoDocumento, Date Fecha, Double Monto,
            int id_TipoDocumento, int id_TipoSaldo, int id_Partida) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;

        this.id_transaccion = id_transaccion;
        this.id_Cuenta = id_Cuenta;
        this.NombreCuenta = NombreCuenta;
        this.TipoSaldo = TipoSaldo;
        this.TipoDocumento = TipoDocumento;
        this.Fecha = Fecha;
        this.Monto = Monto;
        this.id_TipoDocumento = id_TipoDocumento;
        this.id_TipoSaldo = id_TipoSaldo;
        this.id_Partida = id_Partida;
    }

    public Modelo_Partida() {
        this.claseConectar = new ClaseConexion();
    }

    public ArrayList<Modelo_Partida> Get_Transacciones() {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                SELECT "id_Transaccion", TBL_C."Nombre_cuenta", TBL_TS."Tipo_saldo",TBL_TD."Tipo_documento", "Monto", "Fecha",
                TBL_LD."Cuenta_id"
                FROM public."Tbl_Transacciones" AS TBL_T
                INNER JOIN "Tbl_Catalogo" AS TBL_C ON TBL_C."id_Cuenta" = TBL_T."Cuenta_id"
                INNER JOIN "Tbl_TipoSaldo" AS TBL_TS ON TBL_TS."id_Tipo_saldo" = TBL_T."Tipo_saldo_id"
                INNER JOIN "Tbl_TipoDocumento" AS TBL_TD ON TBL_TD."id_TipoDoc" = TBL_T."Tipo_documento_id"
                INNER JOIN "Tbl_LibroDiario" AS TBL_LD ON TBL_LD."Cuenta_id" = TBL_C."id_Cuenta";""";

            pstm = conexionDB.prepareStatement(sql);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_Partida> Transaccion = new ArrayList<>();

            while (consulta.next()) {
                Modelo_Partida movimiento = new Modelo_Partida();

                movimiento.setId_Cuenta(consulta.getInt("id_Transaccion"));
                movimiento.setNombreCuenta(consulta.getString("Nombre_cuenta"));
                movimiento.setTipoSaldo(consulta.getString("Tipo_saldo"));
                movimiento.setTipoDocumento(consulta.getString("Tipo_documento"));
                movimiento.setMonto(consulta.getDouble("Monto"));
                movimiento.setFecha(consulta.getDate("Fecha"));
                movimiento.setId_Partida(consulta.getInt("Cuenta_id"));

                Transaccion.add(movimiento);
            }

            conexionDB.close();
            return Transaccion;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Partida.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public void insertarPartidas(ArrayList<Modelo_Partida> partidas) throws SQLException {
        conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión

        String sql = """
        INSERT INTO public."Tbl_Partida"("Cuenta_id", "Tipo_saldo_id", "Tipo_documento_id", "Monto", "Fecha", "LibroDiario_id")
        VALUES (?, ?, ?, ?, ?, ?);
    """;
        pstm = conexionDB.prepareCall(sql);

        for (Modelo_Partida partida : partidas) {
            pstm.setInt(1, partida.getId_Cuenta());
            pstm.setInt(2, partida.getId_TipoSaldo()); // Asegúrate de tener este método en Modelo_Partida
            pstm.setInt(3, partida.getId_TipoDocumento()); // Asegúrate de tener este método en Modelo_Partida
            pstm.setDouble(4, partida.getMonto());
            pstm.setDate(5, new java.sql.Date(partida.getFecha().getTime())); // Convertir java.util.Date a java.sql.Date
            pstm.setInt(6, partida.getId_Partida()); // Asegúrate de tener este método en Modelo_Partida

            System.out.println("Insertando partida:");
            System.out.println("Cuenta ID: " + partida.getId_Cuenta());
            System.out.println("Tipo Saldo ID: " + partida.getId_TipoSaldo());
            System.out.println("Tipo Documento ID: " + partida.getId_TipoDocumento());
            System.out.println("Monto: " + partida.getMonto());
            System.out.println("Fecha: " + partida.getFecha().getTime());
            System.out.println("Libro Diario ID: " + partida.getId_Partida() + " con id tra " + partida.getId_transaccion());

            int respuesta = pstm.executeUpdate();

            System.out.println(">>" + respuesta);
        }

        String sql2 = """
UPDATE public."Tbl_LibroDiario"
SET  "Partida_id"=?
WHERE "id_Libro_diario"=?;
    """;
        pstm = conexionDB.prepareCall(sql2);

        for (Modelo_Partida partida : partidas) {
            pstm.setInt(1, partida.getId_Partida());
            pstm.setInt(2, partida.getId_transaccion()); // Asegúrate de tener este método en Modelo_Partida
            pstm.setInt(3, partida.getId_TipoDocumento()); // Asegúrate de tener este método en Modelo_Partida
            pstm.setDouble(4, partida.getMonto());
            pstm.setDate(5, new java.sql.Date(partida.getFecha().getTime())); // Convertir java.util.Date a java.sql.Date
            pstm.setInt(6, partida.getId_Partida()); // Asegúrate de tener este método en Modelo_Partida

            System.out.println("Insertando partida:");
            System.out.println("id libro diario : " + partida.getId_Cuenta());
            System.out.println("partida ID: " + partida.getId_Partida());

            int respuesta = pstm.executeUpdate();

            System.out.println(">>" + respuesta);
        }

    }

    public ArrayList<Modelo_Partida> Get_idPartidaActual(int numeroDeseado) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
            SELECT "id_Libro_diario","Partida_id" FROM public."Tbl_LibroDiario" 
                        ORDER BY "id_Libro_diario" DESC 
                        LIMIT ?;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, numeroDeseado); // Establecemos el límite de resultados

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_Partida> Transaccion = new ArrayList<>();

            while (consulta.next()) {
                Modelo_Partida Id_afectados = new Modelo_Partida();

                Id_afectados.setId_Partida(consulta.getInt("id_Libro_diario"));
                System.out.println("Id afectados > " + Id_afectados.getId_Partida());
                Transaccion.add(Id_afectados);
            }

            conexionDB.close();
            return Transaccion;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Partida.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }
    
        public ArrayList<Modelo_Partida> Get_idTransaccionActual(int numeroDeseado) {
        try {
            conexionDB = claseConectar.iniciarConeion(); // Iniciamos una conexión
            String sql = """
            SELECT "id_Libro_diario","Partida_id" FROM public."tbl_" 
                                    ORDER BY "id_Libro_diario" DESC 
                                    LIMIT ?;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, numeroDeseado); // Establecemos el límite de resultados

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_Partida> Transaccion = new ArrayList<>();

            while (consulta.next()) {
                Modelo_Partida Id_afectados = new Modelo_Partida();

                Id_afectados.setId_Partida(consulta.getInt("id_Libro_diario"));
                System.out.println("Id afectados > " + Id_afectados.getId_Partida());
                Transaccion.add(Id_afectados);
            }

            conexionDB.close();
            return Transaccion;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Partida.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public void InsertarLibroDiario() {
        conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión

        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                         INSERT INTO public."Tbl_LibroDiario"( "Partida_id")
                         VALUES ( null );""";

            pstm = conexionDB.prepareStatement(sql);

            int filasInsertadas = pstm.executeUpdate(); // Ejecutamos la inserción

            if (filasInsertadas > 0) {
                System.out.println("Inserción exitosa en Tbl_LibroDiario.");
            } else {
                System.out.println("No se insertaron filas en Tbl_LibroDiario.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Partida.class.getName()).log(Level.SEVERE, "Error al insertar en Tbl_LibroDiario", ex);
        } finally {
            // Cerrar recursos
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conexionDB != null) {
                    conexionDB.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(Modelo_Partida.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", e);
            }
        }
    }

}
