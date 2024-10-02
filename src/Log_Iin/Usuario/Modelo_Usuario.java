package Log_Iin.Usuario;

import Conexion.ClaseConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Usuario {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

//lado escritorio
    private int NIE;
    private int iD_Grado;
    private int id_Materia;
    private int id_Rol;
    private String Nombres;
    private String Apellidos;
    private String Contraseña;

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

    public int getNIE() {
        return NIE;
    }

    public void setNIE(int NIE) {
        this.NIE = NIE;
    }

    public int getiD_Grado() {
        return iD_Grado;
    }

    public void setiD_Grado(int iD_Grado) {
        this.iD_Grado = iD_Grado;
    }

    public int getId_Materia() {
        return id_Materia;
    }

    public void setId_Materia(int id_Materia) {
        this.id_Materia = id_Materia;
    }

    public int getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        this.id_Rol = id_Rol;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public Modelo_Usuario(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm, int NIE, int iD_Grado, int id_Materia, int id_Rol, String Nombres, String Apellidos, String Contraseña) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;

        this.NIE = NIE;
        this.iD_Grado = iD_Grado;
        this.id_Materia = id_Materia;
        this.id_Rol = id_Rol;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Contraseña = Contraseña;
    }

    public Modelo_Usuario() {
        this.claseConectar = new ClaseConexion();
    }

    /**
     * @param Pass
     * @param NIE
     * @return
     * *******************************************************************************************************************
     */
    public Modelo_Usuario Validar_Usuario(String Pass, int NIE) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
            SELECT "NIE", "Nombres", "Apellidos", "Rol_id", "Grado_id", "Materia_id"
            FROM public."Tbl_Personal" WHERE "NIE" = ? AND "Contraseña" = ? ;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, NIE);
            pstm.setString(2, Pass);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            Modelo_Usuario Usuario = new Modelo_Usuario();

            while (consulta.next()) {
                Usuario.setNIE(consulta.getInt("NIE"));
                Usuario.setId_Rol(consulta.getInt("Rol_id"));
                Usuario.setiD_Grado(consulta.getInt("Grado_id"));
                Usuario.setId_Materia(consulta.getInt("Materia_id"));

                Usuario.setNombres(consulta.getString("Nombres"));
                Usuario.setApellidos(consulta.getString("Apellidos"));
            }
            System.out.println("NIE: " + Usuario.getNIE());
            System.out.println("Rol ID: " + Usuario.getId_Rol());
            System.out.println("Grado ID: " + Usuario.getiD_Grado());
            System.out.println("Materia ID: " + Usuario.getId_Materia());
            System.out.println("Nombres: " + Usuario.getNombres());
            System.out.println("Apellidos: " + Usuario.getApellidos());

            conexionDB.close();
            return Usuario;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Usuario.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public int editPersonas(Modelo_Usuario PersonasEdit) {
        try {

            String sql = """
                         UPDATE public."Tbl_Cliente"
                         	SET  nombre=?, "apellido paterno"=?, "apellido materno"=?, tipo_documneto=?, num_documento=?, direccion=?, telefono=?, email=?, "Password"=?, "id_Membresia"=?
                         	WHERE idpersona=?;""";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareStatement(sql);

            //   System.out.println("id a modificar" + PersonasEdit.getNIE());
//            pstm.setString(1, PersonasEdit.getNombre());
//            pstm.setString(2, PersonasEdit.getApellido_paterno());
//            pstm.setString(3, PersonasEdit.getApellido_materno());
//            pstm.setString(4, PersonasEdit.getTipo_doc());
//            pstm.setString(5, PersonasEdit.getNum_doc());
//            pstm.setString(6, PersonasEdit.getDireccion());
//            pstm.setString(7, PersonasEdit.getTelefono());
//            pstm.setString(8, PersonasEdit.getEmail());
//            pstm.setString(9, PersonasEdit.getPassword());
//            pstm.setInt(10, PersonasEdit.getIdMembresia());
//            pstm.setInt(11, PersonasEdit.getNIE());
            int respuesta = pstm.executeUpdate();

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int CambioMembresia(int id, int id_membresia) {
        try {

            String sql = """
                         UPDATE public."Tbl_Cliente"SET   "id_Membresia"=?
                              WHERE idpersona=?;""";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareCall(sql);

            pstm.setInt(1, id_membresia);
            pstm.setInt(2, id);

            int respuesta = pstm.executeUpdate();
            //  System.out.println("cambio->> el ID: " + id + " membresia " + idMembresia + " >? " + respuesta);
            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int deletePersonas(int id) {
        try {
            String sql = "DELETE FROM public.personas WHERE idpersona=? ;";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareCall(sql);

            pstm.setInt(1, id);

            int respuesta = pstm.executeUpdate();

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

}
