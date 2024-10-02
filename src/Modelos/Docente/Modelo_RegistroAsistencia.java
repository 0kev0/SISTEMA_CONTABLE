package Modelos.Docente;

import Conexion.ClaseConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_RegistroAsistencia {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

//lado Servidor
    private int idDocente;
    private int idEstado;
    private int idEstadoAsistencia;

//lado escritorio
    private int NIE;
    private int id;
    private String NombreEstudiante;
    private String ApellidoEstudiante;
    private String EstadoAsistencia;

    private Date Fecha;
    private int CantAsistencias;
    private int CantAusencias;
    private int CantAusenciaJustificadas;
    private String Justificacion;

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

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdEstadoAsistencia() {
        return idEstadoAsistencia;
    }

    public void setIdEstadoAsistencia(int idEstadoAsistencia) {
        this.idEstadoAsistencia = idEstadoAsistencia;
    }

    public int getNIE() {
        return NIE;
    }

    public void setNIE(int NIE) {
        this.NIE = NIE;
    }

    public String getNombreEstudiante() {
        return NombreEstudiante;
    }

    public void setNombreEstudiante(String NombreEstudiante) {
        this.NombreEstudiante = NombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return ApellidoEstudiante;
    }

    public void setApellidoEstudiante(String ApellidoEstudiante) {
        this.ApellidoEstudiante = ApellidoEstudiante;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getCantAsistencias() {
        return CantAsistencias;
    }

    public void setCantAsistencias(int CantAsistencias) {
        this.CantAsistencias = CantAsistencias;
    }

    public String getJustificacion() {
        return Justificacion;
    }

    public void setJustificacion(String Justificacion) {
        this.Justificacion = Justificacion;
    }

    public int getCantAusencias() {
        return CantAusencias;
    }

    public void setCantAusencias(int CantAusencias) {
        this.CantAusencias = CantAusencias;
    }

    public int getCantAusenciaJustificadas() {
        return CantAusenciaJustificadas;
    }

    public void setCantAusenciaJustificadas(int CantAusenciaJustificadas) {
        this.CantAusenciaJustificadas = CantAusenciaJustificadas;
    }

    public Modelo_RegistroAsistencia(int CantAusencias, int CantAusenciaJustificadas) {
        this.CantAusencias = CantAusencias;
        this.CantAusenciaJustificadas = CantAusenciaJustificadas;
    }

    public String getEstadoAsistencia() {
        return EstadoAsistencia;
    }

    public void setEstadoAsistencia(String EstadoAsistencia) {
        this.EstadoAsistencia = EstadoAsistencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Modelo_RegistroAsistencia(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int NIE, String ApellidoEstudiante, String NombreEstudiante, int CantAsistencias, String Justificacion, Date Fecha,
            int idEstadoAsistencia, int idDocente, int idEstado, int CantAusencias, int CantAusenciaJustificadas, String EstadoAsistencia, int id) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;
        ////////////////////////////////////////////////
        this.NIE = NIE;
        this.Fecha = Fecha;
        this.idDocente = idDocente;
        this.idEstado = idEstado;
        this.NombreEstudiante = NombreEstudiante;
        this.ApellidoEstudiante = ApellidoEstudiante;
        this.CantAsistencias = CantAsistencias;
        this.Justificacion = Justificacion;
        this.idEstadoAsistencia = idEstadoAsistencia;
        this.CantAusencias = CantAusencias;
        this.CantAusenciaJustificadas = CantAusenciaJustificadas;
        this.EstadoAsistencia = EstadoAsistencia;
        this.id = id;

    }

    public Modelo_RegistroAsistencia() {
        this.claseConectar = new ClaseConexion();
    }

    /**
     * @param grado
     * @return
     * *******************************************************************************************************************
     */
    public ArrayList<Modelo_RegistroAsistencia> GetListado(int grado) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
SELECT
    tbEst."NIE", tbEst."Nombres", tbEst."Apellidos",
    SUM(CASE WHEN TbAsi."Estado_id" = 1 THEN 1 ELSE 0 END) AS "Numero_Asistencias",
    SUM(CASE WHEN TbAsi."Estado_id" = 2 THEN 1 ELSE 0 END) AS "Numero_Fallas",
    SUM(CASE WHEN TbAsi."Estado_id" = 3 THEN 1 ELSE 0 END) AS "Numero_Fallas_Justificadas"
	
FROM public."Tbl_Asistencias" AS TbAsi
INNER JOIN "tbl_Estudiante" AS tbEst ON tbEst."NIE" = TbAsi."Estudiante_id"

AND tbEst."Grado_id" = ?

GROUP BY tbEst."NIE", tbEst."Nombres", tbEst."Apellidos";""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, grado);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_RegistroAsistencia> DataListado = new ArrayList<>();
            while (consulta.next()) {
                Modelo_RegistroAsistencia Estudiante = new Modelo_RegistroAsistencia();

                Estudiante.setNIE(consulta.getInt("NIE"));
                Estudiante.setNombreEstudiante(consulta.getString("Nombres"));
                Estudiante.setApellidoEstudiante(consulta.getString("Apellidos"));
                Estudiante.setCantAsistencias(consulta.getInt("Numero_Asistencias"));
                Estudiante.setCantAusencias(consulta.getInt("Numero_Fallas"));
                Estudiante.setCantAusenciaJustificadas(consulta.getInt("Numero_Fallas_Justificadas"));

                DataListado.add(Estudiante);
            }

            conexionDB.close();
            return DataListado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public ArrayList<Modelo_RegistroAsistencia> GetListadoCustom(int Grado, int Mes, int Year) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
SELECT
    tbEst."NIE", tbEst."Nombres", tbEst."Apellidos",
    SUM(CASE WHEN TbAsi."Estado_id" = 1 THEN 1 ELSE 0 END) AS "Numero_Asistencias",
    SUM(CASE WHEN TbAsi."Estado_id" = 2 THEN 1 ELSE 0 END) AS "Numero_Fallas",
    SUM(CASE WHEN TbAsi."Estado_id" = 3 THEN 1 ELSE 0 END) AS "Numero_Fallas_Justificadas"
	
FROM public."Tbl_Asistencias" AS TbAsi
INNER JOIN "tbl_Estudiante" AS tbEst ON tbEst."NIE" = TbAsi."Estudiante_id"

WHERE EXTRACT(MONTH FROM TbAsi."Fecha") = ?
AND EXTRACT(YEAR FROM TbAsi."Fecha") = ?
AND tbEst."Grado_id" = ?

GROUP BY tbEst."NIE", tbEst."Nombres", tbEst."Apellidos";""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, Mes);
            pstm.setInt(2, Year);
            pstm.setInt(3, Grado);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_RegistroAsistencia> DataListado = new ArrayList<>();

            while (consulta.next()) {
                Modelo_RegistroAsistencia Estudiante = new Modelo_RegistroAsistencia();

                Estudiante.setNIE(consulta.getInt("NIE"));
                Estudiante.setNombreEstudiante(consulta.getString("Nombres"));
                Estudiante.setApellidoEstudiante(consulta.getString("Apellidos"));
                Estudiante.setCantAsistencias(consulta.getInt("Numero_Asistencias"));
                Estudiante.setCantAusencias(consulta.getInt("Numero_Fallas"));
                Estudiante.setCantAusenciaJustificadas(consulta.getInt("Numero_Fallas_Justificadas"));

                DataListado.add(Estudiante);
            }

            conexionDB.close();
            return DataListado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public ArrayList<Modelo_RegistroAsistencia> GetListadoCustom_dia(int Grado, int dia, int Mes, int Year) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            System.out.println("dia mes year " + dia + Mes + Year);
            String sql = """
SELECT tbEst."NIE", tbEst."Nombres", tbEst."Apellidos",
                        (CASE WHEN TbAsi."Estado_id" = 1 THEN 1 ELSE 0 END) AS "Numero_Asistencias",
                        (CASE WHEN TbAsi."Estado_id" = 2 THEN 1 ELSE 0 END) AS "Numero_Fallas",
                        (CASE WHEN TbAsi."Estado_id" = 3 THEN 1 ELSE 0 END) AS "Numero_Fallas_Justificadas"
                                                                                                                    	
                         FROM public."Tbl_Asistencias" AS TbAsi
                                INNER JOIN "tbl_Estudiante" AS tbEst ON tbEst."NIE" = TbAsi."Estudiante_id"
                					WHERE EXTRACT(DAY FROM TbAsi."Fecha") = ?                       
                                      AND EXTRACT(MONTH FROM TbAsi."Fecha") = ? 
                                      AND EXTRACT(YEAR FROM TbAsi."Fecha") = ? 
                                      AND tbEst."Grado_id" = ?;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, dia);
            pstm.setInt(2, Mes);
            pstm.setInt(3, Year);
            pstm.setInt(4, Grado);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_RegistroAsistencia> DataListado = new ArrayList<>();

            while (consulta.next()) {
                Modelo_RegistroAsistencia Estudiante = new Modelo_RegistroAsistencia();

                Estudiante.setNIE(consulta.getInt("NIE"));
                Estudiante.setNombreEstudiante(consulta.getString("Nombres"));
                Estudiante.setApellidoEstudiante(consulta.getString("Apellidos"));
                Estudiante.setCantAsistencias(consulta.getInt("Numero_Asistencias"));
                Estudiante.setCantAusencias(consulta.getInt("Numero_Fallas"));
                Estudiante.setCantAusenciaJustificadas(consulta.getInt("Numero_Fallas_Justificadas"));

                DataListado.add(Estudiante);
            }

            conexionDB.close();
            return DataListado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public ArrayList<Modelo_RegistroAsistencia> Get_List_DetalleAsistencia(int NIE, int Grado, int Mes) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            int Year = Funciones.Funciones.Get_Year_Actual();
            System.out.println("dia mes/ year " + Mes + "/" + Year);
            String sql = """
SELECT TbAsi."Fecha" , TBE."Estado" , TbAsi."Justificacion",tbEst."NIE"
                                                                                                                  	
             FROM public."Tbl_Asistencias" AS TbAsi
             INNER JOIN "tbl_Estudiante" AS tbEst ON tbEst."NIE" = TbAsi."Estudiante_id"
            INNER JOIN "Tbl_estado_aistencia" AS TBE ON TBE.id = TbAsi."Estado_id"
                         
                				WHERE EXTRACT(MONTH FROM TbAsi."Fecha") = ? 
                                          AND EXTRACT(YEAR FROM TbAsi."Fecha") = ? 
                                          AND tbEst."Grado_id" = ? 
					AND tbEst."NIE" = ? ;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, Mes);
            pstm.setInt(2, Year);
            pstm.setInt(3, Grado);
            pstm.setInt(4, NIE);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta
            System.out.println("sql>" + pstm.toString());
            ArrayList<Modelo_RegistroAsistencia> DataListado = new ArrayList<>();

            while (consulta.next()) {
                Modelo_RegistroAsistencia Estudiante = new Modelo_RegistroAsistencia();

                Estudiante.setFecha(consulta.getDate("Fecha"));
                Estudiante.setEstadoAsistencia(consulta.getString("Estado"));
                Estudiante.setJustificacion(consulta.getString("Justificacion"));
//                Estudiante.setCantAsistencias(consulta.getInt("Numero_Asistencias"));
//                Estudiante.setCantAusencias(consulta.getInt("Numero_Fallas"));
//                Estudiante.setCantAusenciaJustificadas(consulta.getInt("Numero_Fallas_Justificadas"));
                System.out.println("fecha" + consulta.getDate("Fecha"));
                DataListado.add(Estudiante);
            }
            System.out.println("hay en > " + DataListado.size());
            conexionDB.close();
            return DataListado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public Modelo_RegistroAsistencia Get_DetalleAsistencia(int NIE, int Grado, int Mes) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            int Year = Funciones.Funciones.Get_Year_Actual();
            System.out.println("dia mes/ year " + Mes + "/" + Year);
            String sql = """
            SELECT TbAsi.id, TbAsi."Fecha" , TBE."Estado" , TbAsi."Justificacion",
                        tbEst."NIE",tbEst."Apellidos",tbEst."Nombres"
                                                                                                                              	
                            FROM public."Tbl_Asistencias" AS TbAsi
                            INNER JOIN "tbl_Estudiante" AS tbEst ON tbEst."NIE" = TbAsi."Estudiante_id"
                            INNER JOIN "Tbl_estado_aistencia" AS TBE ON TBE.id = TbAsi."Estado_id"
                                     
                                    WHERE EXTRACT(MONTH FROM TbAsi."Fecha") = ? 
                                    AND EXTRACT(YEAR FROM TbAsi."Fecha") = ? 
                                    AND tbEst."Grado_id" = ? 
                                    AND tbEst."NIE" = ? ;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, Mes);
            pstm.setInt(2, Year);
            pstm.setInt(3, Grado);
            pstm.setInt(4, NIE);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta
            System.out.println("sql>" + pstm.toString());
            Modelo_RegistroAsistencia Data_Estudiante = new Modelo_RegistroAsistencia();

            while (consulta.next()) {
                Data_Estudiante.setId(consulta.getInt("id"));
                Data_Estudiante.setNIE(consulta.getInt("NIE"));
                Data_Estudiante.setFecha(consulta.getDate("Fecha"));
                Data_Estudiante.setEstadoAsistencia(consulta.getString("Estado"));
                Data_Estudiante.setNombreEstudiante(consulta.getString("Nombres"));
                Data_Estudiante.setApellidoEstudiante(consulta.getString("Apellidos"));
                System.out.println("fecha" + consulta.getDate("Fecha"));
            }
            conexionDB.close();
            return Data_Estudiante;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public ArrayList<Modelo_RegistroAsistencia> Get_DetalleAsistencia_FiltroTipoAsistencia(int NIE, int Grado, int Mes, int Tipo) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            int Year = Funciones.Funciones.Get_Year_Actual();
            System.out.println("dia mes/ year " + Mes + "/" + Year);
            String sql = """
SELECT TbAsi."Fecha" , TBE."Estado" , TbAsi."Justificacion",tbEst."NIE"
                                                                                                                  	
             FROM public."Tbl_Asistencias" AS TbAsi
             INNER JOIN "tbl_Estudiante" AS tbEst ON tbEst."NIE" = TbAsi."Estudiante_id"
            INNER JOIN "Tbl_estado_aistencia" AS TBE ON TBE.id = TbAsi."Estado_id"
                         
                				WHERE EXTRACT(MONTH FROM TbAsi."Fecha") = ? 
                                          AND EXTRACT(YEAR FROM TbAsi."Fecha") = ? 
                                          AND tbEst."Grado_id" = ? 
					AND tbEst."NIE" = ? 
					AND  TBE.id = ?;""";

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, Mes);
            pstm.setInt(2, Year);
            pstm.setInt(3, Grado);
            pstm.setInt(4, NIE);
            pstm.setInt(5, Tipo);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta
            System.out.println("sql>" + pstm.toString());
            ArrayList<Modelo_RegistroAsistencia> DataListado = new ArrayList<>();

            while (consulta.next()) {
                Modelo_RegistroAsistencia Estudiante = new Modelo_RegistroAsistencia();

                Estudiante.setFecha(consulta.getDate("Fecha"));
                Estudiante.setEstadoAsistencia(consulta.getString("Estado"));
                Estudiante.setJustificacion(consulta.getString("Justificacion"));
//                Estudiante.setCantAsistencias(consulta.getInt("Numero_Asistencias"));
//                Estudiante.setCantAusencias(consulta.getInt("Numero_Fallas"));
//                Estudiante.setCantAusenciaJustificadas(consulta.getInt("Numero_Fallas_Justificadas"));
                System.out.println("fecha" + consulta.getDate("Fecha"));
                DataListado.add(Estudiante);
            }
            System.out.println("hay en > " + DataListado.size());
            conexionDB.close();
            return DataListado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public int RegistrarAsistencia(Modelo_RegistroAsistencia asistenciaInsert) {
        try {
            String sql = """
    INSERT INTO public."Tbl_Asistencias" 
                         ("Docente_id", "Estudiante_id", "Fecha", "Estado_id", "Justificacion")
                         	VALUES (?, ?, ?, ?, ?);""";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareCall(sql);

            pstm.setInt(1, asistenciaInsert.getIdDocente());
            pstm.setInt(2, asistenciaInsert.getNIE());
// Suponiendo que asistenciaInsert.getFecha() devuelve un java.util.Date
            java.util.Date fechaUtil = asistenciaInsert.getFecha();
            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

            pstm.setDate(3, fechaSQL);

            pstm.setInt(4, asistenciaInsert.getIdEstadoAsistencia());
            pstm.setString(5, asistenciaInsert.getJustificacion());

            int respuesta = pstm.executeUpdate();

            System.out.println(">> se registro asistencia del NIE " + asistenciaInsert.getNIE());

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int Edit_Asistencia(Modelo_RegistroAsistencia AsistenciaEdit) {
        try {

            String sql = """
UPDATE public."Tbl_Asistencias"
                         	SET "Estado_id"= ?, "Justificacion"= ?
                         	WHERE id= ? ;""";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareStatement(sql);

            System.out.println("id a modificar" + AsistenciaEdit.getNIE());
            pstm.setInt(1, AsistenciaEdit.getIdEstado());
            pstm.setString(2, AsistenciaEdit.getJustificacion());
            pstm.setInt(3, AsistenciaEdit.getId());

            System.out.println("sQL > " + pstm.toString());
            int respuesta = pstm.executeUpdate();

            if (respuesta > 0) {
                Funciones.Funciones.showMessageDialog("info", "Se edito la asistencia del NIE : " + AsistenciaEdit.getNIE() + "\n En la fecha: " + AsistenciaEdit.getFecha() + "correctamente");
            }
            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            //  System.out.println("cambio->> el ID: " + NIE + " membresia " + idMembresia + " >? " + respuesta);
            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

}
