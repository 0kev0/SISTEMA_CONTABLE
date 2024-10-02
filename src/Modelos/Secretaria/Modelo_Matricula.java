package Modelos.Secretaria;

import Conexion.ClaseConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class Modelo_Matricula {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

//lado Servidor
    private int NIE;
    private int Id_Responsables;
    private int Year;
    private Date Fecha;
    private double MontoNeto;
    private int Id_Descuento;
    private double Descuento;
    private double MontoFinal;
    private int Id_Grado;
//lado escritorio

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

    public int getId_Responsables() {
        return Id_Responsables;
    }

    public void setId_Responsables(int Id_Responsables) {
        this.Id_Responsables = Id_Responsables;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public double getMontoNeto() {
        return MontoNeto;
    }

    public void setMontoNeto(double MontoNeto) {
        this.MontoNeto = MontoNeto;
    }

    public int getId_Descuento() {
        return Id_Descuento;
    }

    public void setId_Descuento(int Id_Descuento) {
        this.Id_Descuento = Id_Descuento;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public double getMontoFinal() {
        return MontoFinal;
    }

    public void setMontoFinal(double MontoFinal) {
        this.MontoFinal = MontoFinal;
    }

    public int getId_Grado() {
        return Id_Grado;
    }

    public void setId_Grado(int Id_Grado) {
        this.Id_Grado = Id_Grado;
    }

    public Modelo_Matricula(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm, int NIE, int Id_Responsables, int Year, Date Fecha, double MontoNeto, int Id_Descuento, double Descuento, double MontoFinal, int Id_Grado) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;
        this.NIE = NIE;
        this.Id_Responsables = Id_Responsables;
        this.Year = Year;
        this.Fecha = Fecha;
        this.MontoNeto = MontoNeto;
        this.Id_Descuento = Id_Descuento;
        this.Descuento = Descuento;
        this.MontoFinal = MontoFinal;
        this.Id_Grado = Id_Grado;
    }

    public Modelo_Matricula() {
        this.claseConectar = new ClaseConexion();
    }

    public int Insert_Matricula(Modelo_Matricula Matricula) {
        try {
            String sql = """
INSERT INTO 
    public."Tbl_Matricula"("Estudiante_id", "Responsables_id", "Año", "Fecha", "Monto_neto", "Descuento_id", "Monto_final", "Grado_id")
    VALUES (?, ?, ?, ?, ?, ?, ?, ?);""";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareCall(sql);

            pstm.setInt(1, Matricula.getNIE());
            pstm.setInt(2, Matricula.getId_Responsables());
            pstm.setInt(3, Matricula.getYear());

// Suponiendo que asistenciaInsert.getFecha() devuelve un java.util.Date

            java.util.Date fechaUtil = Matricula.getFecha();
            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

            pstm.setDate(4, fechaSQL);

            pstm.setDouble(5, Matricula.getMontoNeto());
            pstm.setInt(6, Matricula.getId_Descuento());
            pstm.setDouble(7, Matricula.getMontoFinal());
            pstm.setInt(8, Matricula.getId_Grado());

            int respuesta = pstm.executeUpdate();

            System.out.println(">> se registro asistencia del NIE " + Matricula.getNIE());

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * @param grado
     * @return
     * *******************************************************************************************************************
     */
//    public ArrayList<Modelo_Matricula> GetListado(int grado) {
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
//AND tbEst."Grado_id" = ?
//
//GROUP BY tbEst."NIE", tbEst."Nombres", tbEst."Apellidos";""";
//
//            pstm = conexionDB.prepareStatement(sql);
//            pstm.setInt(1, grado);
//
//            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta
//
////            ArrayList<Modelo_RegistroAsistencia> DataListado = new ArrayList<>();
////            while (consulta.next()) {
////                Modelo_RegistroAsistencia Estudiante = new Modelo_RegistroAsistencia();
////
////                Estudiante.setNIE(consulta.getInt("NIE"));
////                Estudiante.setNombreEstudiante(consulta.getString("Nombres"));
////                Estudiante.setApellidoEstudiante(consulta.getString("Apellidos"));
////                Estudiante.setCantAsistencias(consulta.getInt("Numero_Asistencias"));
////                Estudiante.setCantAusencias(consulta.getInt("Numero_Fallas"));
////                Estudiante.setCantAusenciaJustificadas(consulta.getInt("Numero_Fallas_Justificadas"));
////
////                DataListado.add(Estudiante);
////            }
//
//            conexionDB.close();
//            return DataListado;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Modelo_Matricula.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
//        }
//        return null;
//    }
//    public ArrayList<Modelo_RegistroAsistencia> GetListadoCustom(int Grado, int Mes, int Year) {
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
//            ArrayList<Modelo_RegistroAsistencia> DataListado = new ArrayList<>();
//
//            while (consulta.next()) {
//                Modelo_RegistroAsistencia Estudiante = new Modelo_RegistroAsistencia();
//
//                Estudiante.setNIE(consulta.getInt("NIE"));
//                Estudiante.setNombreEstudiante(consulta.getString("Nombres"));
//                Estudiante.setApellidoEstudiante(consulta.getString("Apellidos"));
//                Estudiante.setCantAsistencias(consulta.getInt("Numero_Asistencias"));
//                Estudiante.setCantAusencias(consulta.getInt("Numero_Fallas"));
//                Estudiante.setCantAusenciaJustificadas(consulta.getInt("Numero_Fallas_Justificadas"));
//
//                DataListado.add(Estudiante);
//            }
//
//            conexionDB.close();
//            return DataListado;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
//        }
//        return null;
//    }
//
//    public ArrayList<Modelo_RegistroAsistencia> GetListadoCustom_dia(int Grado, int dia, int Mes, int Year) {
//        try {
//            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
//            System.out.println("dia mes year " + dia + Mes + Year);
//            String sql = """
//SELECT tbEst."NIE", tbEst."Nombres", tbEst."Apellidos",
//                        (CASE WHEN TbAsi."Estado_id" = 1 THEN 1 ELSE 0 END) AS "Numero_Asistencias",
//                        (CASE WHEN TbAsi."Estado_id" = 2 THEN 1 ELSE 0 END) AS "Numero_Fallas",
//                        (CASE WHEN TbAsi."Estado_id" = 3 THEN 1 ELSE 0 END) AS "Numero_Fallas_Justificadas"
//                                                                                                                    	
//                         FROM public."Tbl_Asistencias" AS TbAsi
//                                INNER JOIN "tbl_Estudiante" AS tbEst ON tbEst."NIE" = TbAsi."Estudiante_id"
//                					WHERE EXTRACT(DAY FROM TbAsi."Fecha") = ?                       
//                                      AND EXTRACT(MONTH FROM TbAsi."Fecha") = ? 
//                                      AND EXTRACT(YEAR FROM TbAsi."Fecha") = ? 
//                                      AND tbEst."Grado_id" = ?;""";
//
//            pstm = conexionDB.prepareStatement(sql);
//            pstm.setInt(1, dia);
//            pstm.setInt(2, Mes);
//            pstm.setInt(3, Year);
//            pstm.setInt(4, Grado);
//
//            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta
//
//            ArrayList<Modelo_RegistroAsistencia> DataListado = new ArrayList<>();
//
//            while (consulta.next()) {
//                Modelo_RegistroAsistencia Estudiante = new Modelo_RegistroAsistencia();
//
//                Estudiante.setNIE(consulta.getInt("NIE"));
//                Estudiante.setNombreEstudiante(consulta.getString("Nombres"));
//                Estudiante.setApellidoEstudiante(consulta.getString("Apellidos"));
//                Estudiante.setCantAsistencias(consulta.getInt("Numero_Asistencias"));
//                Estudiante.setCantAusencias(consulta.getInt("Numero_Fallas"));
//                Estudiante.setCantAusenciaJustificadas(consulta.getInt("Numero_Fallas_Justificadas"));
//
//                DataListado.add(Estudiante);
//            }
//
//            conexionDB.close();
//            return DataListado;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Modelo_Matricula.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
//        }
//        return null;
//    }
//
//    public int Insert_Matricula(Modelo_Matricula asistenciaInsert) {
//        try {
//            String sql = """
//    INSERT INTO public."Tbl_Asistencias" 
//                         ("Docente_id", "Estudiante_id", "Fecha", "Estado_id", "Justificacion")
//                         	VALUES (?, ?, ?, ?, ?);""";
//
//            conexionDB = claseConectar.iniciarConexion();
//            pstm = conexionDB.prepareCall(sql);
//
//            pstm.setInt(1, asistenciaInsert.getIdDocente());
//            pstm.setInt(2, asistenciaInsert.getNIE());
//// Suponiendo que asistenciaInsert.getFecha() devuelve un java.util.Date
//            java.util.Date fechaUtil = asistenciaInsert.getFecha();
//            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());
//
//            pstm.setDate(3, fechaSQL);
//
//            pstm.setInt(4, asistenciaInsert.getIdEstadoAsistencia());
//            pstm.setString(5, asistenciaInsert.getJustificacion());
//
//            int respuesta = pstm.executeUpdate();
//
//            System.out.println(">> se registro asistencia del NIE " + asistenciaInsert.getNIE());
//
//            return respuesta;
//
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(Modelo_Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
//
//    public int editPersonas(Modelo_Matricula PersonasEdit) {
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
//            java.util.logging.Logger.getLogger(Modelo_Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
//            //  System.out.println("cambio->> el ID: " + NIE + " membresia " + idMembresia + " >? " + respuesta);
//            return respuesta;
//
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(Modelo_Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
//            java.util.logging.Logger.getLogger(Modelo_Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
}
