package Modelos.Docente;

import Conexion.ClaseConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_DocenteGuia {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

//lado escritorio
    private int NIE;
    private int IdGradoGuia;
    private int IdMateriaImpartir;
    private String Nombres;
    private String Apellidos;
    private String MateriaImpartida;

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

    public int getIdGradoGuia() {
        return IdGradoGuia;
    }

    public void setIdGradoGuia(int IdGradoGuia) {
        this.IdGradoGuia = IdGradoGuia;
    }

    public int getIdMateriaImpartir() {
        return IdMateriaImpartir;
    }

    public void setIdMateriaImpartir(int IdMateriaImpartir) {
        this.IdMateriaImpartir = IdMateriaImpartir;
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

    public String getMateriaImpartida() {
        return MateriaImpartida;
    }

    public void setMateriaImpartida(String MateriaImpartida) {
        this.MateriaImpartida = MateriaImpartida;
    }

    public Modelo_DocenteGuia(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int NIE, int IdGradoGuia, int IdMateriaImpartir, String Nombres, String Apellidos, String MateriaImpartida) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;
        this.NIE = NIE;
        this.IdGradoGuia = IdGradoGuia;
        this.IdMateriaImpartir = IdMateriaImpartir;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.MateriaImpartida = MateriaImpartida;

    }

    public Modelo_DocenteGuia() {
        this.claseConectar = new ClaseConexion();
    }

    /**
     * @param NIE
     * @return
     * *******************************************************************************************************************
     */
    public Modelo_DocenteGuia Get_Docente(int NIE) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            System.out.println("nie " + NIE);
            String sql = """
SELECT "NIE", "Nombres", "Apellidos", "Rol_id", tbM."Grado_id", tbM."Nombre",TbP."Materia_id"
	FROM public."Tbl_Personal" AS TbP
	INNER JOIN "Tbl_Materias" AS tbM ON tbM.id = TbP."Materia_id"
	
	WHERE TbP."NIE"= ? """;
 
            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, NIE);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta
            Modelo_DocenteGuia docente = new Modelo_DocenteGuia();
            while (consulta.next()) {
                docente.setNIE(consulta.getInt("NIE"));
                docente.setNombres(consulta.getString("Nombre"));
                docente.setApellidos(consulta.getString("Apellidos"));
                docente.setMateriaImpartida(consulta.getString("Nombre"));
                docente.setIdGradoGuia(consulta.getInt("Grado_id"));
                docente.setIdMateriaImpartir(consulta.getInt("Materia_id"));

            }
            
            System.out.println("" + docente.getNombres()+docente.getNIE()+docente.getIdGradoGuia());

            conexionDB.close();
            return docente;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_DocenteGuia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }
    

    
//
//    public Modelo_DocenteGuia Get_Materia(int idDocente) {
//        try {
//            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
//            String sql = """
//SELECT TbMt."Nombre",TbMt."id",TbMt."Nombre"
//	FROM public."Tbl_Personal" AS TbPr
//	INNER JOIN "Tbl_Materias" AS TbMt ON TbMt.id = TbPr."Materia_id"
//        WHERE TbPr."NIE" = ? ;""";
//
//            pstm = conexionDB.prepareStatement(sql);
//            pstm.setInt(1, idDocente);
//
//            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta
//            Modelo_DocenteGuia DocenteGuia = new Modelo_DocenteGuia();
//
//            while (consulta.next()) {
//                DocenteGuia.setNombreMateria(consulta.getString("Nombre"));
//                DocenteGuia.setidMateria(consulta.getInt("id"));
//
//            }
//
//            conexionDB.close();
//            System.out.println("materia del docente guia es: " + DocenteGuia.getNombreMateria() + " id mat : " + DocenteGuia.getidMateria());
//            return DocenteGuia;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Modelo_DocenteGuia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
//        }
//        return null;
//    }
//
//    public ArrayList<Modelo_DocenteGuia> Get_Id_ListadoMaterias(int id_Grado) {
//        try {
//            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
//            String sql = """
//SELECT "Nombre" , "id"
//	FROM public."Tbl_Materias"
//		WHERE  "Grado_id" = ? ;""";
//
//            pstm = conexionDB.prepareStatement(sql);
//            pstm.setInt(1, id_Grado);
//
//            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta
//
//            ArrayList<Modelo_DocenteGuia> DataListado = new ArrayList<>();
//
//            while (consulta.next()) {
//                Modelo_DocenteGuia Estudiante = new Modelo_DocenteGuia();
//                Estudiante.setidMateria(consulta.getInt("id"));
//                Estudiante.setNombreMateria(consulta.getString("Nombre"));
//
//                DataListado.add(Estudiante);
//            }
//
//            conexionDB.close();
//
//            return DataListado;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Modelo_DocenteGuia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
//        }
//        return null;
//    }
//
//    public ArrayList<Modelo_DocenteGuia> GetListadoCustom(int Grado, int Mes, int Year) {
//        try {
//            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
//            String sql = """
//SELECT
//    tbEst."NIE", tbEst."Nombres", tbEst."Apellidos",
//    SUM(CASE WHEN TbAsi."Estado_id" = 1 THEN 1 ELSE 0 END) AS "Numero_Asistencias",
//    SUM(CASE WHEN TbAsi."Estado_id" = 2 THEN 1 ELSE 0 END) AS "Numero_Fallas",
//    SUM(CASE WHEN TbAsi."Estado_id" = 3 THEN 1 ELSE 0 END) AS "Numero_Fallas_Justificadas"
//	
//FROM public."Tbl_Asistencias" AS TbAsi
//INNER JOIN "tbl_Estudiante" AS tbEst ON tbEst."NIE" = TbAsi."Estudiante_id"
//
//WHERE EXTRACT(MONTH FROM TbAsi."Fecha") = ?
//AND EXTRACT(YEAR FROM TbAsi."Fecha") = ?
//AND tbEst."Grado_id" = ?
//
//GROUP BY tbEst."NIE", tbEst."Nombres", tbEst."Apellidos";""";
//
//            pstm = conexionDB.prepareStatement(sql);
//            pstm.setInt(1, Mes);
//            pstm.setInt(2, Year);
//            pstm.setInt(3, Grado);
//
//            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta
//
//            ArrayList<Modelo_DocenteGuia> DataListado = new ArrayList<>();
//
//            while (consulta.next()) {
//                Modelo_DocenteGuia Estudiante = new Modelo_DocenteGuia();
//
////                Estudiante.setNIE(consulta.getInt("NIE"));
////                Estudiante.setNombreEstudiante(consulta.getString("Nombres"));
////                Estudiante.setApellidoEstudiante(consulta.getString("Apellidos"));
////                Estudiante.setCantAsistencias(consulta.getInt("Numero_Asistencias"));
////                Estudiante.setCantAusencias(consulta.getInt("Numero_Fallas"));
////                Estudiante.setCantAusenciaJustificadas(consulta.getInt("Numero_Fallas_Justificadas"));
//                DataListado.add(Estudiante);
//            }
//
//            conexionDB.close();
//            return DataListado;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Modelo_DocenteGuia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
//        }
//        return null;
//    }
//
//    public int RegistrarAsistencia(Modelo_DocenteGuia asistenciaInsert) {
//        try {
//            String sql = """
//    INSERT INTO public."Tbl_Asistencias" 
//                         ("Docente_id", "Estudiante_id", "Fecha", "Estado_id", "Justificacion")
//                         	VALUES (?, ?, ?, ?, ?);""";
//
//            conexionDB = claseConectar.iniciarConexion();
//            pstm = conexionDB.prepareCall(sql);
//
////            pstm.setInt(1, asistenciaInsert.getIdDocente());
////            pstm.setInt(2, asistenciaInsert.getNIE());
////// Suponiendo que asistenciaInsert.getFecha() devuelve un java.util.Date
////            java.util.Date fechaUtil = asistenciaInsert.getFecha();
////            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());
////
////            pstm.setDate(3, fechaSQL);
////
////            pstm.setInt(4, asistenciaInsert.getIdEstadoAsistencia());
////            pstm.setString(5, asistenciaInsert.getJustificacion());
//            int respuesta = pstm.executeUpdate();
//
////            System.out.println(">> se registro asistencia del NIE " + asistenciaInsert.getNIE());
//            return respuesta;
//
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(Modelo_DocenteGuia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
//
//    public int editPersonas(Modelo_DocenteGuia PersonasEdit) {
//        try {
//
//            String sql = """
//                         UPDATE public."Tbl_Cliente"
//                         	SET  nombre=?, "apellido paterno"=?, "apellido materno"=?, tipo_documneto=?, num_documento=?, direccion=?, telefono=?, email=?, "Password"=?, "id_Membresia"=?
//                         	WHERE idpersona=?;""";
//
//            conexionDB = claseConectar.iniciarConexion();
//            pstm = conexionDB.prepareStatement(sql);
//
//            //   System.out.println("id a modificar" + PersonasEdit.getNIE());
////            pstm.setString(1, PersonasEdit.getNombre());
////            pstm.setString(2, PersonasEdit.getApellido_paterno());
////            pstm.setString(3, PersonasEdit.getApellido_materno());
////            pstm.setString(4, PersonasEdit.getTipo_doc());
////            pstm.setString(5, PersonasEdit.getNum_doc());
////            pstm.setString(6, PersonasEdit.getDireccion());
////            pstm.setString(7, PersonasEdit.getTelefono());
////            pstm.setString(8, PersonasEdit.getEmail());
////            pstm.setString(9, PersonasEdit.getPassword());
////            pstm.setInt(10, PersonasEdit.getIdMembresia());
////            pstm.setInt(11, PersonasEdit.getNIE());
//            int respuesta = pstm.executeUpdate();
//
//            return respuesta;
//
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(Modelo_DocenteGuia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
//
//    public int CambioMembresia(int id, int id_membresia) {
//        try {
//
//            String sql = """
//                         UPDATE public."Tbl_Cliente"SET   "id_Membresia"=?
//                              WHERE idpersona=?;""";
//
//            conexionDB = claseConectar.iniciarConexion();
//            pstm = conexionDB.prepareCall(sql);
//
//            pstm.setInt(1, id_membresia);
//            pstm.setInt(2, id);
//
//            int respuesta = pstm.executeUpdate();
//            //  System.out.println("cambio->> el ID: " + id + " membresia " + idMembresia + " >? " + respuesta);
//            return respuesta;
//
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(Modelo_DocenteGuia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
//
//    public int deletePersonas(int id) {
//        try {
//            String sql = "DELETE FROM public.personas WHERE idpersona=? ;";
//
//            conexionDB = claseConectar.iniciarConexion();
//            pstm = conexionDB.prepareCall(sql);
//
//            pstm.setInt(1, id);
//
//            int respuesta = pstm.executeUpdate();
//
//            return respuesta;
//
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(Modelo_DocenteGuia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        return 0;
//    }

}
