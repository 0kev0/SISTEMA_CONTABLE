package Modelos.Secretaria;

import Conexion.ClaseConexion;
import static Funciones.Funciones.TiemSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Estudiante {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

//lado Servidor
//lado escritorio
    private int NIE;
    private String Nombres_Estudiante;
    private String Apellidos_Estudiante;
    private String Grado;
    private int id_Responsables;
    private int Id_Grado;
    private int Edad;

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

    public String getNombres_Estudiante() {
        return Nombres_Estudiante;
    }

    public void setNombres_Estudiante(String Nombres_Estudiante) {
        this.Nombres_Estudiante = Nombres_Estudiante;
    }

    public String getApellidos_Estudiante() {
        return Apellidos_Estudiante;
    }

    public void setApellidos_Estudiante(String Apellidos_Estudiante) {
        this.Apellidos_Estudiante = Apellidos_Estudiante;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
    }

    public int getId_Responsables() {
        return id_Responsables;
    }

    public void setId_Responsables(int id_Responsables) {
        this.id_Responsables = id_Responsables;
    }

    public int getId_Grado() {
        return Id_Grado;
    }

    public void setId_Grado(int Id_Grado) {
        this.Id_Grado = Id_Grado;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public Modelo_Estudiante(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int NIE, String Nombres_Estudiante, String Apellidos_Estudiante, String Grado, int id_Responsables, int Id_Grado, int Edad) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;
        this.NIE = NIE;
        this.Nombres_Estudiante = Nombres_Estudiante;
        this.Apellidos_Estudiante = Apellidos_Estudiante;
        this.Grado = Grado;
        this.id_Responsables = id_Responsables;
        this.Id_Grado = Id_Grado;
        this.Edad = Edad;
    }

    public Modelo_Estudiante() {
        this.claseConectar = new ClaseConexion();

    }

    /**
     * @param id_tipoProducto
     * @param periodo
     * @param idmateria
     * @return
     * *******************************************************************************************************************
     */
    public ArrayList<Modelo_Estudiante> Get_Inscripciones() {
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

            ArrayList<Modelo_Estudiante> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_Estudiante Inscripcion = new Modelo_Estudiante();

//                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
//                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
//                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
//                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
//                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
//                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
//                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
//                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
//                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));
                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int Get_IdReciente() {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String UltimoId = """
SELECT id
FROM public."Tbl_Responsabless"
ORDER BY id DESC
LIMIT 1;""";

            PreparedStatement preparedStatement = conexionDB.prepareStatement(UltimoId);

            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery(); // Ejecutamos la consulta
            //System.out.println("consulta:  " + preparedStatement.toString());

            TiemSql();

            int id = 0;

            while (Conaulta_Inscripcion.next()) {
                id = Conaulta_Inscripcion.getInt("id");

            }

            conexionDB.close();

            return id;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public ArrayList<Modelo_Estudiante> Get_Inscripciones_Filtro_Grados(int grado) {
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

            ArrayList<Modelo_Estudiante> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_Estudiante Inscripcion = new Modelo_Estudiante();

//                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
//                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
//                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
//                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
//                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
//                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
//                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
//
//                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
//                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));
                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_Estudiante> Get_NIES_ParaMEnsualidades() {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT "NIE" FROM public."tbl_Estudiante"; """;

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);

            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery();

            TiemSql();

            ArrayList<Modelo_Estudiante> Lista_NIES = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_Estudiante NewNIE = new Modelo_Estudiante();

                NewNIE.setNIE(Conaulta_Inscripcion.getInt("NIE"));

                Lista_NIES.add(NewNIE);
            }

            System.out.println("\t-> Agregados: " + Lista_NIES.size());
            conexionDB.close();

            return Lista_NIES;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_Estudiante> Get_Listado_NIES_porGrado(int Grado) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT "NIE", "Nombres", "Apellidos", "Grado_id", "Edad", "Responsables_id"
FROM public."tbl_Estudiante"
WHERE "Grado_id" = ? ;""";

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement.setInt(1, Grado);

            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery();

            TiemSql();

            ArrayList<Modelo_Estudiante> Lista_NIES = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_Estudiante NewNIE = new Modelo_Estudiante();

                NewNIE.setNIE(Conaulta_Inscripcion.getInt("NIE"));

                Lista_NIES.add(NewNIE);
            }

            System.out.println("\t-> RETORNANDO LISTA DE NIES, CANTIDAD : " + Lista_NIES.size());
            conexionDB.close();

            return Lista_NIES;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Modelo_Estudiante Get_DataEstudiante(int NIE) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT "NIE", "Nombres", "Apellidos", "Grado_id", "Edad", "Responsables_id"
	FROM public."tbl_Estudiante" 
	WHERE "NIE" = ? ;""";

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement.setInt(1, NIE);

            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery();

            TiemSql();
            Modelo_Estudiante DataEstudiante = new Modelo_Estudiante();
            System.out.println("sql> " + preparedStatement.toString());
            while (Conaulta_Inscripcion.next()) {

                DataEstudiante.setNIE(Conaulta_Inscripcion.getInt("NIE"));
                DataEstudiante.setNombres_Estudiante(Conaulta_Inscripcion.getString("Nombres"));
                DataEstudiante.setApellidos_Estudiante(Conaulta_Inscripcion.getString("Apellidos"));
//                DataEsrudiante.setGrado(Conaulta_Inscripcion.getString("Tipo_Responsable_id"));
                DataEstudiante.setId_Grado(Conaulta_Inscripcion.getInt("Grado_id"));
                DataEstudiante.setEdad(Conaulta_Inscripcion.getInt("Edad"));
                DataEstudiante.setId_Responsables(Conaulta_Inscripcion.getInt("Responsables_id"));

            }

            conexionDB.close();

            return DataEstudiante;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_Estudiante> Get_Inscripciones_Filtro_Year(int Year) {
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

            ArrayList<Modelo_Estudiante> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_Estudiante Inscripcion = new Modelo_Estudiante();

//                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
//                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
//                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
//                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
//                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
//                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
//                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
//                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
//                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));
                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_Estudiante> Get_Inscripciones_Filtro_Mes(int mes) {
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

            ArrayList<Modelo_Estudiante> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_Estudiante Inscripcion = new Modelo_Estudiante();

//                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
//                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
//                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
//                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
//                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
//                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
//                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
//                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
//                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));
                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_Estudiante> Get_Productos_filtrado(int id_tipoProducto) {
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

            ArrayList<Modelo_Estudiante> ListaProductos = new ArrayList<>();
            while (Consulta_Productos.next()) {

                Modelo_Estudiante Producto = new Modelo_Estudiante();

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
            Logger.getLogger(Modelo_Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int Insert_Estudiante(Modelo_Estudiante Estudiante) {
        try {
            String sql = """
INSERT INTO public."tbl_Estudiante"(
	"NIE", "Nombres", "Apellidos", "Grado_id", "Edad", "Responsables_id")
	VALUES (?, ?, ?, ?, ?, ?);""";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareCall(sql);

            pstm.setInt(1, Estudiante.getNIE());
            pstm.setString(2, Estudiante.getNombres_Estudiante());
            pstm.setString(3, Estudiante.getApellidos_Estudiante());
            pstm.setInt(4, Estudiante.getId_Grado());
            pstm.setInt(5, Estudiante.getEdad());
            pstm.setInt(6, Estudiante.getId_Responsables());

            int respuesta = pstm.executeUpdate();

            System.out.println(">>" + respuesta);

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Estudiante.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int EDIT_Reinscripcion(int NIE, int Grado, int Edad) {
        try {
            String sql = """
                     UPDATE public."tbl_Estudiante"
                     SET "Grado_id" = ?, "Edad" = ?
                     WHERE "NIE" = ?;""";

            conexionDB = claseConectar.iniciarConexion();
            PreparedStatement preparedStatement = conexionDB.prepareStatement(sql);
            preparedStatement.setInt(1, Grado);
            preparedStatement.setInt(2, Edad);
            preparedStatement.setInt(3, NIE);

            System.out.println("SQL > " + pstm.toString());

            int respuesta = preparedStatement.executeUpdate();

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Modelo_Estudiante.class
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
            java.util.logging.Logger.getLogger(Modelo_Estudiante.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

}
