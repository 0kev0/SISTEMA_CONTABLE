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

public class Modelo_Responsables {

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
    private int id_Tipoa;

    private String TelefonoA;
    private String Apellidos_B;
    private String Nombres_B;
    private String TipoResponsables_B;
    private int id_TipoB;
    private String TelefonoB;

    private String Direccion;
    private String Correo;

    private int CantidadInscritos;

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

    public String getTelefonoA() {
        return TelefonoA;
    }

    public void setTelefonoA(String TelefonoA) {
        this.TelefonoA = TelefonoA;
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

    public String getTelefonoB() {
        return TelefonoB;
    }

    public void setTelefonoB(String TelefonoB) {
        this.TelefonoB = TelefonoB;
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

    public int getId_TipoA() {
        return id_Tipoa;
    }

    public void setId_TipoA(int id_Tipoa) {
        this.id_Tipoa = id_Tipoa;
    }

    public int getId_TipoB() {
        return id_TipoB;
    }

    public void setId_TipoB(int id_TipoB) {
        this.id_TipoB = id_TipoB;
    }

    public int getCantidadInscritos() {
        return CantidadInscritos;
    }

    public void setCantidadInscritos(int CantidadInscritos) {
        this.CantidadInscritos = CantidadInscritos;
    }

    public Modelo_Responsables(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int id, String Apellidos_A, String Nombres_A, String TipoResponsables_A, String TelefonoA, int id_Tipoa,
            String Apellidos_B, String Nombres_B, String TipoResponsables_B, String TelefonoB, int id_TipoB, int CantidadInscritos,
            String Direccion, String Correo) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;
        this.id = id;

        this.Apellidos_A = Apellidos_A;
        this.Nombres_A = Nombres_A;
        this.TipoResponsables_A = TipoResponsables_A;
        this.TelefonoA = TelefonoA;
        this.id_Tipoa = id_Tipoa;

        this.Apellidos_B = Apellidos_B;
        this.Nombres_B = Nombres_B;
        this.TipoResponsables_B = TipoResponsables_B;
        this.TelefonoB = TelefonoB;
        this.id_TipoB = id_TipoB;

        this.CantidadInscritos = CantidadInscritos;

        this.Direccion = Direccion;
        this.Correo = Correo;
    }

    public Modelo_Responsables() {
        this.claseConectar = new ClaseConexion();

    }

    /**
     * @param id_tipoProducto
     * @param periodo
     * @param idmateria
     * @return
     * *******************************************************************************************************************
     */
    public ArrayList<Modelo_Responsables> Get_Inscripciones() {
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

            ArrayList<Modelo_Responsables> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_Responsables Inscripcion = new Modelo_Responsables();

                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));

                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public Boolean Valid_IdResponsable(int idResponsable) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta
            Boolean check = false;

            String UltimoId = """
SELECT id
FROM public."Tbl_Responsabless"
WHERE id = ?
ORDER BY id DESC
LIMIT 1;""";

            PreparedStatement preparedStatement = conexionDB.prepareStatement(UltimoId);
            preparedStatement.setInt(1, idResponsable);
            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery(); // Ejecutamos la consulta
            //System.out.println("consulta:  " + preparedStatement.toString());

            TiemSql();

            int id = 0;

            while (Conaulta_Inscripcion.next()) {
                id = Conaulta_Inscripcion.getInt("id");
            }
            if (id != 0) {
                check = true;

            }
            conexionDB.close();

            return check;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public String Get_CorreoporNIE(int NIE) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String SqlCorreo = """
SELECT  "Correo"
	FROM public."Tbl_Responsabless" AS TBR
	INNER JOIN "tbl_Estudiante" AS TBE ON TBE."Responsables_id" = TBR.id
	WHERE TBE."NIE" = ? ; """;

            PreparedStatement preparedStatement = conexionDB.prepareStatement(SqlCorreo);
            preparedStatement.setInt(1, NIE);

            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery();
            String CorreoBuscado = "";
            TiemSql();

            while (Conaulta_Inscripcion.next()) {
                CorreoBuscado = Conaulta_Inscripcion.getString("Correo");

            }

            conexionDB.close();

            return CorreoBuscado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public Modelo_Responsables Get_DataResponsable(int NIE) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT TBR.id, "Nombres_A", "Apellidos_A", "Telefono_A", "Tipo_Responsable_id",
    "Tipo_Responsable_id_B", "Nombres_B", "Apellidos_B", "Telefono_B",
    "Direccion", "Correo",
    (SELECT COUNT(*) FROM public."tbl_Estudiante" WHERE "Responsables_id" = TBR.id) AS Cantidad_Estudiantes
FROM public."Tbl_Responsabless" AS TBR
INNER JOIN "Tbl_Tipos_Responsables" AS TBTR ON TBTR.id = TBR."Tipo_Responsable_id_B"
WHERE TBR.id =  ? ; """;

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement.setInt(1, NIE);

            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery();

            TiemSql();
            Modelo_Responsables DataResponsable = new Modelo_Responsables();
            System.out.println("sql> " + preparedStatement.toString());
            while (Conaulta_Inscripcion.next()) {

                DataResponsable.setId(Conaulta_Inscripcion.getInt("id"));
                DataResponsable.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
                DataResponsable.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
                DataResponsable.setId_TipoA(Conaulta_Inscripcion.getInt("Tipo_Responsable_id"));
                DataResponsable.setTelefonoA(Conaulta_Inscripcion.getString("Telefono_A"));

                DataResponsable.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
                DataResponsable.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
                DataResponsable.setId_TipoB(Conaulta_Inscripcion.getInt("Tipo_Responsable_id_B"));
                DataResponsable.setTelefonoB(Conaulta_Inscripcion.getString("Telefono_B"));

                DataResponsable.setCantidadInscritos(Conaulta_Inscripcion.getInt("Cantidad_Estudiantes"));
                DataResponsable.setCorreo(Conaulta_Inscripcion.getString("Correo"));
                DataResponsable.setDireccion(Conaulta_Inscripcion.getString("Direccion"));

                System.out.println("sql> cant hijos> " + Conaulta_Inscripcion.getInt("Cantidad_Estudiantes"));

            }

            if (null != DataResponsable) {
                Funciones.Funciones.showMessageDialog("info", "Datos encontrados");
            }

            conexionDB.close();

            return DataResponsable;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Modelo_Responsables Get_DataResponsable_porNIE(int NIE) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT TBR.id, "Nombres_A", "Apellidos_A", "Telefono_A", "Tipo_Responsable_id",
    "Tipo_Responsable_id_B", "Nombres_B", "Apellidos_B", "Telefono_B",
    "Direccion", "Correo"
	
FROM public."Tbl_Responsabless" AS TBR
INNER JOIN "tbl_Estudiante" AS TBE ON TBE."Responsables_id" = TBR.id
WHERE TBE."NIE" = ? """;

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement.setInt(1, NIE);

            ResultSet Conaulta_Inscripcion = preparedStatement.executeQuery();

            TiemSql();
            Modelo_Responsables DataResponsable = new Modelo_Responsables();
            System.out.println("sql> " + preparedStatement.toString());
            while (Conaulta_Inscripcion.next()) {

                DataResponsable.setId(Conaulta_Inscripcion.getInt("id"));
                DataResponsable.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
                DataResponsable.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
                DataResponsable.setId_TipoA(Conaulta_Inscripcion.getInt("Tipo_Responsable_id"));
                DataResponsable.setTelefonoA(Conaulta_Inscripcion.getString("Telefono_A"));

                DataResponsable.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
                DataResponsable.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
                DataResponsable.setId_TipoB(Conaulta_Inscripcion.getInt("Tipo_Responsable_id_B"));
                DataResponsable.setTelefonoB(Conaulta_Inscripcion.getString("Telefono_B"));

                DataResponsable.setCorreo(Conaulta_Inscripcion.getString("Correo"));
                DataResponsable.setDireccion(Conaulta_Inscripcion.getString("Direccion"));

            }

            if (null != DataResponsable) {
                Funciones.Funciones.showMessageDialog("info", "Datos encontrados");
            }

            conexionDB.close();

            return DataResponsable;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_Responsables> Get_Inscripciones_Filtro_Grados(int grado) {
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

            ArrayList<Modelo_Responsables> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_Responsables Inscripcion = new Modelo_Responsables();

                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));

                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));

                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_Responsables> Get_Inscripciones_Filtro_Year(int Year) {
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

            ArrayList<Modelo_Responsables> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_Responsables Inscripcion = new Modelo_Responsables();

                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));

                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_Responsables> Get_Inscripciones_Filtro_Mes(int mes) {
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

            ArrayList<Modelo_Responsables> Lista_Inscripciones = new ArrayList<>();

            while (Conaulta_Inscripcion.next()) {

                Modelo_Responsables Inscripcion = new Modelo_Responsables();

                Inscripcion.setId(Conaulta_Inscripcion.getInt("id"));
                Inscripcion.setApellidos_A(Conaulta_Inscripcion.getString("Apellidos_A"));
                Inscripcion.setNombres_A(Conaulta_Inscripcion.getString("Nombres_A"));
                Inscripcion.setTipoResponsables_A(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setApellidos_B(Conaulta_Inscripcion.getString("Apellidos_B"));
                Inscripcion.setNombres_B(Conaulta_Inscripcion.getString("Nombres_B"));
                Inscripcion.setTipoResponsables_B(Conaulta_Inscripcion.getString("Tipo_de_responsable"));
                Inscripcion.setCorreo(Conaulta_Inscripcion.getString("Correo"));
                Inscripcion.setDireccion(Conaulta_Inscripcion.getString("Direccion"));

                Lista_Inscripciones.add(Inscripcion);
            }

            System.out.println("\t-> Agregados: " + Lista_Inscripciones.size());
            conexionDB.close();

            return Lista_Inscripciones;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_Estudiante> Get_Estudiantes_delResponsable(int Id_Responsable) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT "NIE", "Nombres", "Apellidos"
	FROM public."tbl_Estudiante"
	WHERE "Responsables_id"= ?;""";

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement.setInt(1, Id_Responsable);

            ResultSet Consulta_Productos = preparedStatement.executeQuery(); // Ejecutamos la consulta
            //System.out.println("consulta:  " + preparedStatement.toString());

            TiemSql();

            ArrayList<Modelo_Estudiante> List_Estudiantes = new ArrayList<>();
            while (Consulta_Productos.next()) {

                Modelo_Estudiante estudiante = new Modelo_Estudiante();

                estudiante.setNIE(Consulta_Productos.getInt("NIE"));
                estudiante.setNombres_Estudiante(Consulta_Productos.getString("Nombres"));
                estudiante.setApellidos_Estudiante(Consulta_Productos.getString("Apellidos"));

                List_Estudiantes.add(estudiante);
            }

            System.out.println("\t-> Agregados: " + List_Estudiantes.size());
            conexionDB.close();

            return List_Estudiantes;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int Insert_Responsables(Modelo_Responsables Responsables) {
        try {
            String sql = """
INSERT INTO public."Tbl_Responsabless"(
	"Nombres_A", "Apellidos_A", "Tipo_Responsable_id", "Telefono_A",
	 "Nombres_B", "Apellidos_B",  "Tipo_Responsable_id_B","Telefono_B",
	"Direccion", "Correo")
                         
	VALUES ( ?, ?, ?, ?,?, ?, ?, ?,?, ?);""";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareCall(sql);

            pstm.setString(1, Responsables.getNombres_A());
            pstm.setString(2, Responsables.getApellidos_A());
            pstm.setInt(3, Responsables.getId_TipoA());
            pstm.setString(4, Responsables.getTelefonoA());

            pstm.setString(5, Responsables.getNombres_B());
            pstm.setString(6, Responsables.getApellidos_B());
            pstm.setInt(7, Responsables.getId_TipoB());
            pstm.setString(8, Responsables.getTelefonoB());

            pstm.setString(9, Responsables.getDireccion());
            pstm.setString(10, Responsables.getCorreo());

            int respuesta = pstm.executeUpdate();

            System.out.println(">>" + respuesta);

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Responsables.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int Edit_VentaHecha(Modelo_Responsables ProductoVendido) {
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
            java.util.logging.Logger.getLogger(Modelo_Responsables.class
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
            java.util.logging.Logger.getLogger(Modelo_Responsables.class
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
            java.util.logging.Logger.getLogger(Modelo_Responsables.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

}
