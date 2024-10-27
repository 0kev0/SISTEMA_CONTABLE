package Modelos.Contador;

import Conexion.ClaseConexion;
import static Funciones.Funciones.TiemSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void insertarPartidas(ArrayList<Modelo_Partida> partidas, String Concepto) throws SQLException {
        // Iniciamos una conexión
        conexionDB = claseConectar.iniciarConexion();

        String sqlInsert = """
    INSERT INTO public."Tbl_Partida"("Cuenta_id", "Tipo_saldo_id", "Tipo_documento_id", "Monto", "Fecha", "LibroDiario_id")
    VALUES (?, ?, ?, ?, ?, ?)
    RETURNING "id_Partida"  -- Esto devolverá el ID generado
""";

        pstm = conexionDB.prepareStatement(sqlInsert);

        List<Integer> id_Partidas = new ArrayList<>(); // Lista para almacenar los IDs de Partida insertadas

        int id_LibroDiario = partidas.get(0).getId_Partida();//id da libro diario en comun

        for (Modelo_Partida partida : partidas) {
            System.out.println("\nInsertando partida:");
            pstm.setInt(1, partida.getId_Cuenta());
            pstm.setInt(2, partida.getId_TipoSaldo());
            pstm.setInt(3, partida.getId_TipoDocumento());
            pstm.setDouble(4, partida.getMonto());
            pstm.setDate(5, new java.sql.Date(partida.getFecha().getTime()));
            pstm.setInt(6, id_LibroDiario);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int idInsertado = rs.getInt("id_Partida"); //  ID insertado
                id_Partidas.add(idInsertado);
                System.out.println("ID de Partida insertado: " + idInsertado + " hay " + id_Partidas.size());

            }

        }

        Set_idPartidasToLibroDiario(id_Partidas, id_LibroDiario, Concepto);

        conexionDB.close();

    }

    private void Set_idPartidasToLibroDiario(List<Integer> id_Partidas, int id_LibroDiario, String Concepto) throws SQLException {
        // Actualizar en Tbl_LibroDiario los id de las partidas
        String sqlUpdate = """
                                       UPDATE public."Tbl_LibroDiario"
                                       SET "Partida_id" = ? , "Concepto" = ?
                                       WHERE "id_Libro_diario" = ?;
                                   """;

        System.out.println("\n//////update a tbl_librodiario ");
        pstm = conexionDB.prepareStatement(sqlUpdate);

        for (int i = 0; i < id_Partidas.size(); i++) {
            System.out.println("\nActualizando Tbl_LibroDiario:");

            pstm.setInt(1, id_Partidas.get(i)); // ID de Partida
            pstm.setString(2, Concepto); // ID de LibroDiario
            pstm.setInt(3, id_LibroDiario); // ID de LibroDiario

            System.out.println("id partida " + id_Partidas.get(i) + " insertado en librodiario id " + id_LibroDiario);

            int respuesta = pstm.executeUpdate();
            System.out.println((respuesta == 1) ? "***UPDATE EXITOSO***" : "***UPDATE FALLIDO***");
            id_LibroDiario--;
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
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
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
