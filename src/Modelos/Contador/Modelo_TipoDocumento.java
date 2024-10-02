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
public class Modelo_TipoDocumento {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

    private int id_TipoDocumento;
    private String TipoDocumento;

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

    public int getId_TipoDocumento() {
        return id_TipoDocumento;
    }

    public void setId_TipoDocumento(int id_TipoDocumento) {
        this.id_TipoDocumento = id_TipoDocumento;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public Modelo_TipoDocumento(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm, int id_TipoDocumento, String TipoDocumento) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;

        this.id_TipoDocumento = id_TipoDocumento;
        this.TipoDocumento = TipoDocumento;
    }

    public Modelo_TipoDocumento() {
        this.claseConectar = new ClaseConexion();
    }

    public ArrayList<Modelo_TipoDocumento> Get_TiposDocumentos() {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                SELECT "id_TipoDoc", "Tipo_documento"
                FROM public."Tbl_TipoDocumento";""";

            pstm = conexionDB.prepareStatement(sql);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_TipoDocumento> TipoDocumentos_Listado = new ArrayList<>();
            
            while (consulta.next()) {
                Modelo_TipoDocumento TipoDocumento = new Modelo_TipoDocumento();

                TipoDocumento.setId_TipoDocumento(consulta.getInt("id_TipoDoc"));
                TipoDocumento.setTipoDocumento(consulta.getString("Tipo_documento"));

                System.out.println("ID Tipo Documento: " + TipoDocumento.getId_TipoDocumento() +
                       ", Tipo Documento: " + TipoDocumento.getTipoDocumento());

                TipoDocumentos_Listado.add(TipoDocumento);
            }

            conexionDB.close();
            return TipoDocumentos_Listado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_TipoDocumento.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public Modelo_TipoDocumento Get_TipoDocumento(int id_Documento) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                SELECT "id_Tipo_cuenta", "Tipo_cuenta"
        	FROM public."Tbl_TipoCuenta"
                WHERE "id_Tipo_cuenta" = ? ;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, id_Documento);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            Modelo_TipoDocumento TipoDocumento = new Modelo_TipoDocumento();

            while (consulta.next()) {
                TipoDocumento.setId_TipoDocumento(consulta.getInt("id_TipoDoc"));
                TipoDocumento.setTipoDocumento(consulta.getString("Tipo_documento"));

            }

            conexionDB.close();
            return TipoDocumento;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_TipoDocumento.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }

        return null;
    }

}
