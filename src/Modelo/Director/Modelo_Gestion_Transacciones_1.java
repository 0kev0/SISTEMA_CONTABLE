package Modelo.Director;

import Modelos.Docente.*;
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

public class Modelo_Gestion_Transacciones_1 {
//HACE REFACTOR DE ESTO TAMBIEN, NOMAS CAMBIAS LAS VARIABLES, GETTERS, SETTERS Y CONSTRUCTOR ANTES DE EMPEZAR A MODIFICARLO A LO QUE LO NECESITES
////////////////////////////////////////////////////lado Servidor
    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

///////////////////////////////////////////////////lado escritorio
    private int id;
    private int NIE;
    private String Detalle;
    private int Cantidad;
    private int Estudiante_id;
    private Date Fecha;
    private String Correo;
    private Double Monto;
    private Double Costo;
    private Double Ganancia;
    private Double Precio;

    //DALE CLICK DERECHO, INSERT GETTERS Y SETTERS, Y CONSTRUCTOR
    ///////////////////////////////////////////////////GETTERS Y SETTERS
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

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getEstudiante_id() {
        return Estudiante_id;
    }

    public void setEstudiante_id(int Estudiante_id) {
        this.Estudiante_id = Estudiante_id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    public Double getCosto() {
        return Costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCosto(Double Costo) {
        this.Costo = Costo;
    }

    public Double getGanancia() {
        return Ganancia;
    }

    public void setGanancia(Double Ganancia) {
        this.Ganancia = Ganancia;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    //        this.claseConectar = new ClaseConexion();
    ///////////////////////////////////////////////////CONSTRUCTORES
    public Modelo_Gestion_Transacciones_1(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int NIE, String Detalle, int Cantidad, int Estudiante_id, Date Fecha, String Correo, Double Monto, Double Precio, Double Ganancia, Double Costo, int id) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;
        //ESTAS PRIMERAS 4 LINEAS SIEMPRE MANTENELAS IGUAL
        this.id = id;

        this.NIE = NIE;
        this.Detalle = Detalle;
        this.Cantidad = Cantidad;
        this.Estudiante_id = Estudiante_id;
        this.Fecha = Fecha;
        this.Correo = Correo;
        this.Monto = Monto;
        this.Costo = Costo;
        this.Precio = Precio;
        this.Ganancia = Ganancia;

    }

    //ESTE CONSTRUCTOR SIEMPRE SE MANTIENE
    public Modelo_Gestion_Transacciones_1() {
        this.claseConectar = new ClaseConexion();
    }

    /**r = new ClaseConexion();
    }

    /**
     * @param grado
     * @return
     * *******************************************************************************************************************
     */
    //DEVUELVE LISTA DE FILAS PARA MOSTRAR EN TABLA
    public ArrayList<Modelo_Gestion_Transacciones_1> get_Transacciones() {
        try {
            conexionDB = claseConectar.iniciarConexion();//iniciamos una coneccion 
            statement = conexionDB.createStatement();//crear consulta
            System.out.println("###BUSQUEDA GENERAL");

            //EDITA LA CONSULTA A LO QUE USES
            String sql = """
SELECT TB_TR.id, "Detalle" , "Cantidad", "Fecha", "Monto", "Costo",TB_RE."Correo", "Estudiante_id"  ,"Costo", "Ganancia"
FROM public."Tbl_Transaccion" AS TB_TR
	INNER JOIN "Tbl_Responsabless" AS TB_RE ON TB_RE.id = TB_TR."Responsable_id";""";

            //CONSULTA NORMAL SOLO LLEVA ESTO
            pstm = conexionDB.prepareStatement(sql);
            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            //CAMBIA NOMBRE DE LA LISTA A LLENAR
            ArrayList<Modelo_Gestion_Transacciones_1> Data_Inscripcion = new ArrayList<>();

            while (consulta.next()) {
                //OBJETO A LLENAR , CAMBIA EL TIPO DE OBJETO A LLENAR
                Modelo_Gestion_Transacciones_1 Inscripcion = new Modelo_Gestion_Transacciones_1();

                Inscripcion.setId(consulta.getInt("id"));
                Inscripcion.setNIE(consulta.getInt("Estudiante_id"));
                Inscripcion.setDetalle(consulta.getString("Detalle"));
                Inscripcion.setCantidad(consulta.getInt("Cantidad"));
                Inscripcion.setFecha(consulta.getDate("Fecha"));
                Inscripcion.setMonto(consulta.getDouble("Monto"));
                Inscripcion.setCosto(consulta.getDouble("Costo"));
                Inscripcion.setGanancia(consulta.getDouble("Ganancia"));

                Inscripcion.setCorreo(consulta.getString("Correo"));

                //UNA VEZ CREADO EL OBJETO CON LOS SETTERS NEDCESARIOS LO AGREGAS A LA LISTA
                Data_Inscripcion.add(Inscripcion);
            }

            conexionDB.close();
            return Data_Inscripcion;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Gestion_Transacciones_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //GET DE FILAS CON FILTRO DE FECHA
    //
    public ArrayList<Modelo_Gestion_Transacciones_1> Get_transacciones_PorFecha(int Mes, int Year) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            System.out.println(" mes year " + Mes + Year);
            String sql = """
SELECT TB_TR.id, "Detalle" , "Cantidad", "Fecha", "Monto", "Costo",TB_RE."Correo", "Estudiante_id"  ,"Costo", "Ganancia"
FROM public."Tbl_Transaccion" AS TB_TR
	INNER JOIN "Tbl_Responsabless" AS TB_RE ON TB_RE.id = TB_TR."Responsable_id"
                         	
		WHERE 
		EXTRACT(MONTH FROM TB_TR."Fecha") = ? 
		AND EXTRACT(YEAR FROM TB_TR."Fecha") = ? ;""";

            pstm = conexionDB.prepareStatement(sql);
            //pstm.setInt(1, dia);
            pstm.setInt(1, Mes);
            pstm.setInt(2, Year);
            //pstm.setInt(4, Grado);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_Gestion_Transacciones_1> Data_Inscripcion_Filtrado = new ArrayList<>();

            while (consulta.next()) {
                Modelo_Gestion_Transacciones_1 Inscripcion = new Modelo_Gestion_Transacciones_1();

                Inscripcion.setId(consulta.getInt("id"));
                Inscripcion.setNIE(consulta.getInt("Estudiante_id"));
                Inscripcion.setDetalle(consulta.getString("Detalle"));
                Inscripcion.setCantidad(consulta.getInt("Cantidad"));
                Inscripcion.setFecha(consulta.getDate("Fecha"));
                Inscripcion.setMonto(consulta.getDouble("Monto"));
                Inscripcion.setCosto(consulta.getDouble("Costo"));
                Inscripcion.setGanancia(consulta.getDouble("Ganancia"));

                Inscripcion.setCorreo(consulta.getString("Correo"));

                Data_Inscripcion_Filtrado.add(Inscripcion);
            }

            conexionDB.close();
            return Data_Inscripcion_Filtrado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistroAsistencia.class.getName()).log(Level.SEVERE, "Error al obtener el listado", ex);
        }
        return null;
    }

    public ArrayList<Modelo_Gestion_Transacciones_1> get_ListadoActividades_Filtrada(int Criterio, String Parametro) {
        try {
            conexionDB = claseConectar.iniciarConexion();//iniciamos una coneccion 
            statement = conexionDB.createStatement();//crear consulta
            System.out.println("###BUSQUEDA FILTRADA\n criterio de busqueda : " + Parametro + "\n Id del criterio  " + Criterio);

            String sql = """
      SELECT Tb_Est."NIE",Tb_Est."Nombres",Tb_Est."Apellidos", 
                              			Tb_Act."Nombre_Actividad", Tb_Tact."Ponderacion",Tb_EsAc."EstadoActividad",
                              			Tbl_NAct."NotaObtenida"
                                                  FROM public."Tbl_Nota_Actividad" AS Tbl_NAct
                                                  INNER JOIN "Tbl_EstadoActividad" AS Tb_EsAc ON  Tb_EsAc.id = Tbl_NAct."EstadoActividad_id"
                                                  INNER JOIN "Tbl_Actividades" AS Tb_Act ON Tb_Act.id = Tbl_NAct."Actividad_id"
                  								INNER JOIN "Tbl_TipoActividad" AS Tb_Tact ON Tb_Tact.id = Tb_Act."TipoActividad_id"
                                                  INNER JOIN "tbl_Estudiante" AS Tb_Est ON Tb_Est."NIE" = Tbl_NAct."Estudiante_id"
            					
            					WHERE """ + Parametro;

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, Criterio);

            ResultSet consulta = pstm.executeQuery(); // Ejecutamos la consulta

            ArrayList<Modelo_Gestion_Transacciones_1> DataActividades = new ArrayList<>();
            while (consulta.next()) {

                Modelo_Gestion_Transacciones_1 Actividades = new Modelo_Gestion_Transacciones_1();

//                Actividades.setNIE(consulta.getInt("NIE"));
//                Actividades.setNombreEstudiante(consulta.getString("Nombres"));
//                Actividades.setApellidoEstudiante(consulta.getString("Apellidos"));
//                Actividades.setNombreActividad(consulta.getString("Nombre_Actividad"));
//                Actividades.setEstadoActividad(consulta.getString("EstadoActividad"));
//                Actividades.setPonderacion(consulta.getDouble("Ponderacion"));
//                Actividades.setNota(consulta.getDouble("NotaObtenida"));
                DataActividades.add(Actividades);
            }

            conexionDB.close();
            return DataActividades;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Gestion_Transacciones_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Modelo_Gestion_Transacciones_1> GetInforme() {
        try {
            conexionDB = claseConectar.iniciarConexion();//iniciamos una coneccion 
            statement = conexionDB.createStatement();//crear consulta

            String sql = """
                        
                         """;

            ResultSet consulta = statement.executeQuery(sql);//ejecutamos la consulta

            ArrayList<Modelo_Gestion_Transacciones_1> DataPersonas = new ArrayList<>();
            while (consulta.next()) {

                Modelo_Gestion_Transacciones_1 Persona = new Modelo_Gestion_Transacciones_1();

                DataPersonas.add(Persona);
            }

            conexionDB.close();
            return DataPersonas;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Gestion_Transacciones_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Modelo_Gestion_Transacciones_1 GetPersona(int id) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // initiate a connection

            String sql = " ";
            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet consulta = pstm.executeQuery(); // execute the query

            Modelo_Gestion_Transacciones_1 Persona = null;
            if (consulta.next()) {
                Persona = new Modelo_Gestion_Transacciones_1();

            }

            conexionDB.close();
            return Persona;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Gestion_Transacciones_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertNuevoCliente(Modelo_Gestion_Transacciones_1 PersonasInsert) {
        try {
            String sql = """
                         INSERT INTO public."Tbl_Cliente"( nombre, "apellido paterno", "apellido materno", tipo_documneto, num_documento, direccion, telefono, email, "Password", "id_Membresia")
                         \tVALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);""";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareCall(sql);

//            pstm.setString(1, PersonasInsert.getNombre());
//            pstm.setString(2, PersonasInsert.getApellido_paterno());
//            pstm.setString(3, PersonasInsert.getApellido_materno());
//            pstm.setString(4, PersonasInsert.getTipo_doc());
//            pstm.setString(5, PersonasInsert.getNum_doc());
//            pstm.setString(6, PersonasInsert.getDireccion());
//            pstm.setString(7, PersonasInsert.getTelefono());
//            pstm.setString(8, PersonasInsert.getEmail());
//            pstm.setString(9, PersonasInsert.getPassword());
//            pstm.setInt(10, PersonasInsert.getIdMembresia());//Sin membresia
            int respuesta = pstm.executeUpdate();

            System.out.println(">>" + respuesta);

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Gestion_Transacciones_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int editPersonas(Modelo_Gestion_Transacciones_1 PersonasEdit) {
        try {

            String sql = """
                         UPDATE public."Tbl_Cliente"
                         	SET  nombre=?, "apellido paterno"=?, "apellido materno"=?, tipo_documneto=?, num_documento=?, direccion=?, telefono=?, email=?, "Password"=?, "id_Membresia"=?
                         	WHERE idpersona=?;""";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareStatement(sql);

            //   System.out.println("id a modificar" + PersonasEdit.getId());
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
//            pstm.setInt(11, PersonasEdit.getId());
            int respuesta = pstm.executeUpdate();

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Gestion_Transacciones_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Modelo_Gestion_Transacciones_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Modelo_Gestion_Transacciones_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

}
