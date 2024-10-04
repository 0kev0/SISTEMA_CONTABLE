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
public class Modelo_Catalogo {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

    private int id_Cuenta;
    private String NombreCuenta;
    private String TipoCuenta;
    private int id_TipoCuenta;

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

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(String TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    public int getid_TipoCuenta() {
        return id_TipoCuenta;
    }

    public void setid_TipoCuenta(int id_TipoCuenta) {
        this.id_TipoCuenta = id_TipoCuenta;
    }

    public Modelo_Catalogo(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int id_Cuenta, String NombreCuenta, String TipoCuenta, int id_TipoCuenta) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;

        this.id_Cuenta = id_Cuenta;
        this.NombreCuenta = NombreCuenta;
        this.TipoCuenta = TipoCuenta;
        this.id_TipoCuenta = id_TipoCuenta;
    }

    public Modelo_Catalogo() {
        this.claseConectar = new ClaseConexion();
    }

    public ArrayList<Modelo_Catalogo> Get_Catalogo() {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                SELECT "id_Cuenta", "Nombre_cuenta", "Tipo_cuenta_id" , TBL_TC."Tipo_cuenta"
                FROM public."Tbl_Catalogo" AS TBL_C
                INNER JOIN "Tbl_TipoCuenta" AS TBL_TC ON TBL_TC."id_Tipo_cuenta" = TBL_C."Tipo_cuenta_id" ;""";

            pstm = conexionDB.prepareStatement(sql);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_Catalogo> Catalogo = new ArrayList<>();

            while (consulta.next()) {
                Modelo_Catalogo Cuenta = new Modelo_Catalogo();

                Cuenta.setId_Cuenta(consulta.getInt("id_Cuenta"));
                Cuenta.setNombreCuenta(consulta.getString("Nombre_cuenta"));
                Cuenta.setTipoCuenta(consulta.getString("Tipo_cuenta"));
                Cuenta.setid_TipoCuenta(consulta.getInt("Tipo_cuenta_id"));

                if (consulta.isFirst()) {
                    System.out.println("\n\n+------------+--------------------------+--------------------+----------------+");
                    System.out.println("| ID Cuenta  | Nombre de la Cuenta      | Tipo de Cuenta     | Tipo Cuenta ID |");
                    System.out.println("+------------+--------------------------+--------------------+----------------+");
                }

                System.out.println(String.format("| %-10d | %-24s | %-18s | %-14d |",
                        consulta.getInt("id_Cuenta"),
                        consulta.getString("Nombre_cuenta"),
                        consulta.getString("Tipo_cuenta"),
                        consulta.getInt("Tipo_cuenta_id")));

                Catalogo.add(Cuenta);
            }

            System.out.println("+------------+--------------------------+--------------------+----------------+\n");

            conexionDB.close();
            return Catalogo;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Catalogo.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public Modelo_Catalogo Get_Cuenta(int id_cuenta) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                SELECT "id_Cuenta", "Nombre_cuenta", "Tipo_cuenta_id" , TBL_TC."Tipo_cuenta"
                FROM public."Tbl_Catalogo" AS TBL_C
                INNER JOIN "Tbl_TipoCuenta" AS TBL_TC ON TBL_TC."id_Tipo_cuenta" = TBL_C."Tipo_cuenta_id" 
                WHERE "id_Cuenta" = ?;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, id_cuenta);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            Modelo_Catalogo Cuenta = new Modelo_Catalogo();

            while (consulta.next()) {
                Cuenta.setId_Cuenta(consulta.getInt("id_Cuenta"));
                Cuenta.setNombreCuenta(consulta.getString("Nombre_cuenta"));
                Cuenta.setTipoCuenta(consulta.getString("Tipo_cuenta"));
                Cuenta.setid_TipoCuenta(consulta.getInt("Tipo_cuenta_id"));

            }

            conexionDB.close();
            return Cuenta;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Catalogo.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }

        return null;
    }

    public ArrayList<Modelo_Catalogo> Get_CatalogoFiltrado(int id_Tipocuenta) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                SELECT "id_Cuenta", "Nombre_cuenta", TBL_TC."Tipo_cuenta"
                FROM public."Tbl_Catalogo" AS TBL_C
                INNER JOIN "Tbl_TipoCuenta" AS TBL_TC ON TBL_TC."id_Tipo_cuenta" = TBL_C."Tipo_cuenta_id"
                WHERE TBL_TC."id_Tipo_cuenta" = ? ;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, id_Tipocuenta);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_Catalogo> Catalogo = new ArrayList<>();

            while (consulta.next()) {
                Modelo_Catalogo Cuenta = new Modelo_Catalogo();

                Cuenta.setId_Cuenta(consulta.getInt("id_Cuenta"));
                Cuenta.setNombreCuenta(consulta.getString("Nombre_cuenta"));
                Cuenta.setTipoCuenta(consulta.getString("Tipo_cuenta"));

                Catalogo.add(Cuenta);

            }

            conexionDB.close();
            return Catalogo;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Catalogo.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }

        return null;
    }

}
