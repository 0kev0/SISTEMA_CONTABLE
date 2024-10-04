package Log_Iin.Usuario;

import Conexion.ClaseConexion;
import Funciones.Funciones;
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
    private int id;
    private String Nombres;
    private String Apellidos;
    private String Contraseña;
    private String Rol;
    private int id_Rol;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public int getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        this.id_Rol = id_Rol;
    }

    public Modelo_Usuario(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm, int id, String Nombres, String Apellidos, String Contraseña, String Rol, int id_Rol) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;

        this.id = id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Contraseña = Contraseña;
        this.Rol = Rol;
        this.id_Rol = id_Rol;
    }

    public Modelo_Usuario() {
        this.claseConectar = new ClaseConexion();
    }

    /**
     * @param user
     * @param pass
     * @return
     * *******************************************************************************************************************
     */
    public Modelo_Usuario Validar_Usuario(String user, String pass) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
                SELECT "id_Usuario", "Nombres", "Apellidos", "Contrasena", "Rol_id",TBL_R."Nombre_rol"
                FROM public."Tbl_Usuario" AS TBL_U
                INNER JOIN "Tbl_Roles" AS TBL_R ON TBL_R."id_Rol" = TBL_U."Rol_id"
            	WHERE "Nombres" = ? AND "Contrasena" = ? ;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setString(1, pass);
            pstm.setString(2, user);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            Modelo_Usuario Usuario = new Modelo_Usuario();

            String loginfo = " Intento de inicio de secion por usuario ***";
            String Log = Funciones.Registro_Log(loginfo);
            Funciones.escribirEnArchivo(Log);

            while (consulta.next()) {
                Usuario.setId(consulta.getInt("id_Usuario"));
                Usuario.setNombres(consulta.getString("Nombres"));
                Usuario.setApellidos(consulta.getString("Apellidos"));
                Usuario.setId_Rol(consulta.getInt("Rol_id"));
                Usuario.setRol(consulta.getString("Nombre_rol"));

            }

//            System.out.println("ID: " + Usuario.getId());
//            System.out.println("Rol ID: " + Usuario.getId_Rol());
//            System.out.println("Rol : " + Usuario.getRol());
//            System.out.println("Nombres: " + Usuario.getNombres());
//            System.out.println("Apellidos: " + Usuario.getApellidos());
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
