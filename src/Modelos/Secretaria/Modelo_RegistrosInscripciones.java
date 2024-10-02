package Modelos.Secretaria;

import Modelos.Docente.*;
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

public class Modelo_RegistrosInscripciones {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

//lado Servidor
//lado escritorio
    private int id;
    private String Apellidos_A;
    private String Nombres_A;
    private String TipoResponsables_A;
    private String Apellidos_B;
    private String Nombres_B;
    private String TipoResponsables_B;
    private int NIE;
    private String Apellidos_Estudiante;
    private String Nombres_Estudiante;
    private String Grado;
    private String Direccion;
    private String Correo;

    private int year;
    private Date fecha;
    private double descuento;
    private double monto;

    ////////////////////////////////////GETTERS Y SETTERS
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

    public String getApellidos_A() {
        return Apellidos_A;
    }

    public void setApellidos_A(String Apellidos_A) {
        this.Apellidos_A = Apellidos_A;
    }

    public String getNombres_A() {
        return Nombres_A;
    }

    public void setNombres_A(String Nombres_A) {
        this.Nombres_A = Nombres_A;
    }

    public String getTipoResponsables_A() {
        return TipoResponsables_A;
    }

    public void setTipoResponsables_A(String TipoResponsables_A) {
        this.TipoResponsables_A = TipoResponsables_A;
    }

    public String getApellidos_B() {
        return Apellidos_B;
    }

    public void setApellidos_B(String Apellidos_B) {
        this.Apellidos_B = Apellidos_B;
    }

    public String getNombres_B() {
        return Nombres_B;
    }

    public void setNombres_B(String Nombres_B) {
        this.Nombres_B = Nombres_B;
    }

    public String getTipoResponsables_B() {
        return TipoResponsables_B;
    }

    public void setTipoResponsables_B(String TipoResponsables_B) {
        this.TipoResponsables_B = TipoResponsables_B;
    }

    public int getNIE() {
        return NIE;
    }

    public void setNIE(int NIE) {
        this.NIE = NIE;
    }

    public String getApellidos_Estudiante() {
        return Apellidos_Estudiante;
    }

    public void setApellidos_Estudiante(String Apellidos_Estudiante) {
        this.Apellidos_Estudiante = Apellidos_Estudiante;
    }

    public String getNombres_Estudiante() {
        return Nombres_Estudiante;
    }

    public void setNombres_Estudiante(String Nombres_Estudiante) {
        this.Nombres_Estudiante = Nombres_Estudiante;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    ////////////////////////////////CONSTRUCTORES
    public Modelo_RegistrosInscripciones(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int id, String Apellidos_A, String Nombres_A, String TipoResponsables_A, String Correo,
            String Apellidos_B, String Nombres_B, String TipoResponsables_B,
            int NIE, String Apellidos_Estudiante, String Nombres_Estudiante,
            String Grado, int year, Date fecha, double descuento, double monto, String Direccion) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;

        this.id = id;
        this.Apellidos_A = Apellidos_A;
        this.Nombres_A = Nombres_A;
        this.TipoResponsables_A = TipoResponsables_A;
        this.Apellidos_B = Apellidos_B;
        this.Nombres_B = Nombres_B;
        this.TipoResponsables_B = TipoResponsables_B;
        this.NIE = NIE;
        this.Apellidos_Estudiante = Apellidos_Estudiante;
        this.Nombres_Estudiante = Nombres_Estudiante;
        this.Grado = Grado;
        this.year = year;
        this.fecha = fecha;
        this.descuento = descuento;
        this.monto = monto;
        this.Direccion = Direccion;
        this.Correo = Correo;

    }

    public Modelo_RegistrosInscripciones() {
        this.claseConectar = new ClaseConexion();

    }

    /**
     * @param id_tipoProducto
     * @param periodo
     * @param idmateria
     * @return
     * *******************************************************************************************************************
     */
    public ArrayList<Modelo_RegistrosInscripciones> Get_Inscripciones() {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT  			Tb_Mat.id,Tb_Resp."Apellidos_A",Tb_Resp."Nombres_A",Tb_TipR."Tipo_de_responsable",Tb_Resp."Correo",
    				Tb_Resp."Apellidos_B",Tb_Resp."Nombres_B",Tb_TipRb."Tipo_de_responsable",
    				Tb_Est."Apellidos",Tb_Est."Nombres",Tb_Est."NIE",
    				"Año", "Fecha",Tb_Resp."Direccion" , "Monto_neto", Tb_Desc."Descuento", "Monto_final", Tb_Gr."Grado"
    						 
    	FROM public."Tbl_Matricula" AS Tb_Mat
    	INNER JOIN "tbl_Estudiante" AS Tb_Est ON Tb_Est."NIE" = Tb_Mat."Estudiante_id"
    	INNER JOIN "Tbl_Responsabless" AS Tb_Resp ON Tb_Resp.id = Tb_Mat."Responsables_id"
    	INNER JOIN "Tbl_Descuentos" AS Tb_Desc ON Tb_Desc.id = Tb_Mat."Descuento_id"
    	INNER JOIN "Tbl_Grados" AS Tb_Gr ON Tb_Gr.id = Tb_Est."Grado_id"
    	INNER JOIN "Tbl_Tipos_Responsables" AS Tb_TipR ON Tb_TipR.id = Tb_Resp."Tipo_Responsable_id"
    	INNER JOIN "Tbl_Tipos_Responsables" AS Tb_TipRb ON Tb_TipRb.id = Tb_Resp."Tipo_Responsable_id_B" 
                                         
                                         ORDER BY id ASC ;""";

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);

            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery(); // Ejecutamos la consulta
            //System.out.println("consulta:  " + preparedStatement.toString());

            TiemSql();

            ArrayList<Modelo_RegistrosInscripciones> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_RegistrosInscripciones Inscripcion = new Modelo_RegistrosInscripciones();

                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setNIE(Conaulta_Inscripcion.getInt("NIE"));
                Inscripcion.setApellidos_Estudiante(Conaulta_Inscripcion.getString("Apellidos"));
                Inscripcion.setNombres_Estudiante(Conaulta_Inscripcion.getString("Nombres"));
                Inscripcion.setGrado(Conaulta_Inscripcion.getString("Grado"));
                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));

                Inscripcion.setYear(Conaulta_Inscripcion.getInt("Año"));
                Inscripcion.setFecha(Conaulta_Inscripcion.getDate("Fecha"));
                Inscripcion.setDescuento(Conaulta_Inscripcion.getDouble("Descuento"));
                Inscripcion.setMonto(Conaulta_Inscripcion.getDouble("Monto_neto"));

                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistrosInscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_RegistrosInscripciones> Get_Inscripciones_Filtro_Grados(int grado) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT  			Tb_Mat.id,Tb_Resp."Apellidos_A",Tb_Resp."Nombres_A",Tb_TipR."Tipo_de_responsable",Tb_Resp."Correo",
				Tb_Resp."Apellidos_B",Tb_Resp."Nombres_B",Tb_TipRb."Tipo_de_responsable",
				Tb_Est."Apellidos",Tb_Est."Nombres",Tb_Est."NIE",
				"Año", "Fecha",Tb_Resp."Direccion" , "Monto_neto", Tb_Desc."Descuento", "Monto_final", Tb_Gr."Grado"
						 
	FROM public."Tbl_Matricula" AS Tb_Mat
	INNER JOIN "tbl_Estudiante" AS Tb_Est ON Tb_Est."NIE" = Tb_Mat."Estudiante_id"
	INNER JOIN "Tbl_Responsabless" AS Tb_Resp ON Tb_Resp.id = Tb_Mat."Responsables_id"
	INNER JOIN "Tbl_Descuentos" AS Tb_Desc ON Tb_Desc.id = Tb_Mat."Descuento_id"
	INNER JOIN "Tbl_Grados" AS Tb_Gr ON Tb_Gr.id = Tb_Mat."Grado_id"
	INNER JOIN "Tbl_Tipos_Responsables" AS Tb_TipR ON Tb_TipR.id = Tb_Resp."Tipo_Responsable_id"
	INNER JOIN "Tbl_Tipos_Responsables" AS Tb_TipRb ON Tb_TipRb.id = Tb_Resp."Tipo_Responsable_id_B"
	 
	 WHERE Tb_Gr.id = ?
	 ORDER BY id ASC ;""";

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement.setInt(1, grado);

            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery();

            TiemSql();

            ArrayList<Modelo_RegistrosInscripciones> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_RegistrosInscripciones Inscripcion = new Modelo_RegistrosInscripciones();

                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setNIE(Conaulta_Inscripcion.getInt("NIE"));
                Inscripcion.setApellidos_Estudiante(Conaulta_Inscripcion.getString("Apellidos"));
                Inscripcion.setNombres_Estudiante(Conaulta_Inscripcion.getString("Nombres"));
                Inscripcion.setGrado(Conaulta_Inscripcion.getString("Grado"));
                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));
                Inscripcion.setYear(Conaulta_Inscripcion.getInt("Año"));
                Inscripcion.setFecha(Conaulta_Inscripcion.getDate("Fecha"));
                Inscripcion.setDescuento(Conaulta_Inscripcion.getDouble("Descuento"));
                Inscripcion.setMonto(Conaulta_Inscripcion.getDouble("Monto_neto"));

                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistrosInscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_RegistrosInscripciones> Get_Inscripciones_Filtro_Year(int Year) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT  			Tb_Mat.id,Tb_Resp."Apellidos_A",Tb_Resp."Nombres_A",Tb_TipR."Tipo_de_responsable",Tb_Resp."Correo",
				Tb_Resp."Apellidos_B",Tb_Resp."Nombres_B",Tb_TipRb."Tipo_de_responsable",
				Tb_Est."Apellidos",Tb_Est."Nombres",Tb_Est."NIE",
				"Año", "Fecha",Tb_Resp."Direccion" , "Monto_neto", Tb_Desc."Descuento", "Monto_final", Tb_Gr."Grado"
						 
	FROM public."Tbl_Matricula" AS Tb_Mat
	INNER JOIN "tbl_Estudiante" AS Tb_Est ON Tb_Est."NIE" = Tb_Mat."Estudiante_id"
	INNER JOIN "Tbl_Responsabless" AS Tb_Resp ON Tb_Resp.id = Tb_Mat."Responsables_id"
	INNER JOIN "Tbl_Descuentos" AS Tb_Desc ON Tb_Desc.id = Tb_Mat."Descuento_id"
	INNER JOIN "Tbl_Grados" AS Tb_Gr ON Tb_Gr.id = Tb_Mat."Grado_id"
	INNER JOIN "Tbl_Tipos_Responsables" AS Tb_TipR ON Tb_TipR.id = Tb_Resp."Tipo_Responsable_id"
	INNER JOIN "Tbl_Tipos_Responsables" AS Tb_TipRb ON Tb_TipRb.id = Tb_Resp."Tipo_Responsable_id_B"
	
	WHERE EXTRACT(YEAR FROM "Fecha") = ?
	ORDER BY id ASC ;""";

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement.setInt(1, Year);

            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery();

            TiemSql();

            ArrayList<Modelo_RegistrosInscripciones> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_RegistrosInscripciones Inscripcion = new Modelo_RegistrosInscripciones();

                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setNIE(Conaulta_Inscripcion.getInt("NIE"));
                Inscripcion.setApellidos_Estudiante(Conaulta_Inscripcion.getString("Apellidos"));
                Inscripcion.setNombres_Estudiante(Conaulta_Inscripcion.getString("Nombres"));
                Inscripcion.setGrado(Conaulta_Inscripcion.getString("Grado"));
                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));
                Inscripcion.setYear(Conaulta_Inscripcion.getInt("Año"));
                Inscripcion.setFecha(Conaulta_Inscripcion.getDate("Fecha"));
                Inscripcion.setDescuento(Conaulta_Inscripcion.getDouble("Descuento"));
                Inscripcion.setMonto(Conaulta_Inscripcion.getDouble("Monto_neto"));

                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistrosInscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_RegistrosInscripciones> Get_Inscripciones_Filtro_Mes(int mes) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT  			Tb_Mat.id,Tb_Resp."Apellidos_A",Tb_Resp."Nombres_A",Tb_TipR."Tipo_de_responsable",Tb_Resp."Correo",
				Tb_Resp."Apellidos_B",Tb_Resp."Nombres_B",Tb_TipRb."Tipo_de_responsable",
				Tb_Est."Apellidos",Tb_Est."Nombres",Tb_Est."NIE",
				"Año", "Fecha",Tb_Resp."Direccion" , "Monto_neto", Tb_Desc."Descuento", "Monto_final", Tb_Gr."Grado"
						 
	FROM public."Tbl_Matricula" AS Tb_Mat
	INNER JOIN "tbl_Estudiante" AS Tb_Est ON Tb_Est."NIE" = Tb_Mat."Estudiante_id"
	INNER JOIN "Tbl_Responsabless" AS Tb_Resp ON Tb_Resp.id = Tb_Mat."Responsables_id"
	INNER JOIN "Tbl_Descuentos" AS Tb_Desc ON Tb_Desc.id = Tb_Mat."Descuento_id"
	INNER JOIN "Tbl_Grados" AS Tb_Gr ON Tb_Gr.id = Tb_Mat."Grado_id"
	INNER JOIN "Tbl_Tipos_Responsables" AS Tb_TipR ON Tb_TipR.id = Tb_Resp."Tipo_Responsable_id"
	INNER JOIN "Tbl_Tipos_Responsables" AS Tb_TipRb ON Tb_TipRb.id = Tb_Resp."Tipo_Responsable_id_B"
	
	WHERE EXTRACT(MONTH FROM "Fecha") = ?
	ORDER BY id ASC ;""";

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement.setInt(1, mes);

            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery();

            TiemSql();

            ArrayList<Modelo_RegistrosInscripciones> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_RegistrosInscripciones Inscripcion = new Modelo_RegistrosInscripciones();

                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setNIE(Conaulta_Inscripcion.getInt("NIE"));
                Inscripcion.setApellidos_Estudiante(Conaulta_Inscripcion.getString("Apellidos"));
                Inscripcion.setNombres_Estudiante(Conaulta_Inscripcion.getString("Nombres"));
                Inscripcion.setGrado(Conaulta_Inscripcion.getString("Grado"));
                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));
                Inscripcion.setYear(Conaulta_Inscripcion.getInt("Año"));
                Inscripcion.setFecha(Conaulta_Inscripcion.getDate("Fecha"));
                Inscripcion.setDescuento(Conaulta_Inscripcion.getDouble("Descuento"));
                Inscripcion.setMonto(Conaulta_Inscripcion.getDouble("Monto_neto"));

                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistrosInscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_RegistrosInscripciones> Get_Productos_filtrado(int id_tipoProducto) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT  Tbl_Pr.id ,"Nombre", Tbl_TpR."Nombre_tipo", "Costo", "Precio", "Descripcion_producto", "Cantidad_Disponible"
	FROM "Tbl_Productos" AS Tbl_Pr
	INNER JOIN "Tbl_Tipo_Producto" AS Tbl_TpR ON Tbl_TpR.id = Tbl_Pr."Tipo_Producto_id" 
	WHERE Tbl_TpR.id = ?;
            """;

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement.setInt(1, id_tipoProducto);

            ResultSet Consulta_Productos = preparedStatement.executeQuery(); // Ejecutamos la consulta
            //System.out.println("consulta:  " + preparedStatement.toString());

            TiemSql();

            ArrayList<Modelo_RegistrosInscripciones> ListaProductos = new ArrayList<>();
            while (Consulta_Productos.next()) {

                Modelo_RegistrosInscripciones Producto = new Modelo_RegistrosInscripciones();

//                Producto.setid(Consulta_Productos.getInt("id"));
//                Producto.setNombre_Producto(Consulta_Productos.getString("Nombre"));
//                Producto.setTipo_Producto(Consulta_Productos.getString("Nombre_tipo"));
//                Producto.setDescripcion(Consulta_Productos.getString("Descripcion_producto"));
//                Producto.setCant_Disponible(Consulta_Productos.getInt("Cantidad_Disponible"));
//                Producto.setCosto(Consulta_Productos.getDouble("Costo"));
//                Producto.setPrecio(Consulta_Productos.getDouble("Precio"));
//
//                System.out.println("agregado " + Producto.getNombre_Producto());
                ListaProductos.add(Producto);
            }

            System.out.println("\t-> Agregados: " + ListaProductos.size());
            conexionDB.close();

            return ListaProductos;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_RegistrosInscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int Insert_Transaccion(Modelo_RegistrosInscripciones Transaccion) {
        try {
            String sql = """
INSERT INTO public."Tbl_Transaccion"("Detalle", "Cantidad", "Fecha", "Monto", "Tipo_Transaccion_id", "Costo", "Ganancia", "Responsable_id")
VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);""";
            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareCall(sql);

//            pstm.setString(1, Transaccion.getDetalles());
//            pstm.setInt(2, Transaccion.getCantidades());
//
//            pstm.setDouble(4, Transaccion.getMontos());
//            pstm.setInt(5, Transaccion.getId_tipo_transaccion());
//            pstm.setDouble(6, Transaccion.getCostos());
//            pstm.setDouble(7, Transaccion.getGanancias());
//            pstm.setInt(8, Transaccion.getNIES_Responsable());
//
//            java.util.Date fechaUtil = Transaccion.getFecha();
//            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());
//            pstm.setDate(3, fechaSQL);
            int respuesta = pstm.executeUpdate();

            System.out.println(">>" + respuesta);

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_RegistrosInscripciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int Edit_VentaHecha(Modelo_RegistrosInscripciones ProductoVendido) {
        try {

            String sql = """
                         UPDATE public."Tbl_Productos" SET   "Cantidad_Disponible" = ? WHERE id = ?;""";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareStatement(sql);

//            int id = ProductoVendido.getId();
            Modelo_Productos cantidad = new Modelo_Productos();
            int cantidaddisponible = cantidad.Get_Data_Cant(id);

//            int nuevoTotal = cantidaddisponible - ProductoVendido.getCantidades();
//
//            System.out.println("tome la cantidad " + cantidaddisponible);
//            System.out.println("para vender " + ProductoVendido.Cantidades);
//            System.out.println("y queda " + nuevoTotal);
//
//            System.out.println("id a modificar" + ProductoVendido.getId());
//            pstm.setInt(1, ProductoVendido.getCantidades());
//            pstm.setInt(2, nuevoTotal);
            int respuesta = pstm.executeUpdate();

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_RegistrosInscripciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Modelo_RegistrosInscripciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Modelo_RegistrosInscripciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

}
