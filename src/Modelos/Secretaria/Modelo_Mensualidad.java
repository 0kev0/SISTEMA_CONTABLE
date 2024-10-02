package Modelos.Secretaria;

import Conexion.ClaseConexion;
import Funciones.Funciones;
import static Funciones.Funciones.obtenerFechaActual;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Modelo_Mensualidad {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

//lado Servidor
    private int NIE;
    private String nombre_estudiante;
    private String nombre_ResponsableA;
    private String nombre_ResponsableB;
    private String estado;
    private int Id_Responsable;
    private int mes;
    private int Year;
    private double Mora;
    private double MontoFinal;
    private int id_Estado;
    private int id_Grado;

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

    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getNombre_ResponsableA() {
        return nombre_ResponsableA;
    }

    public void setNombre_ResponsableA(String nombre_ResponsableA) {
        this.nombre_ResponsableA = nombre_ResponsableA;
    }

    public String getNombre_ResponsableB() {
        return nombre_ResponsableB;
    }

    public void setNombre_ResponsableB(String nombre_ResponsableB) {
        this.nombre_ResponsableB = nombre_ResponsableB;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_Responsable() {
        return Id_Responsable;
    }

    public void setId_Responsable(int Id_Responsable) {
        this.Id_Responsable = Id_Responsable;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public double getMora() {
        return Mora;
    }

    public void setMora(double Mora) {
        this.Mora = Mora;
    }

    public double getMontoFinal() {
        return MontoFinal;
    }

    public void setMontoFinal(double MontoFinal) {
        this.MontoFinal = MontoFinal;
    }

    public int getId_Estado() {
        return id_Estado;
    }

    public void setId_Estado(int id_Estado) {
        this.id_Estado = id_Estado;
    }

    public int getId_Grado() {
        return id_Grado;
    }

    public void setId_Grado(int id_Grado) {
        this.id_Grado = id_Grado;
    }

    public Modelo_Mensualidad(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm, int NIE, String nombre_estudiante, String nombre_ResponsableA, String nombre_ResponsableB, String estado, int Id_Responsable, int mes, int Year, double Mora, double MontoFinal, int id_Estado, int id_Grado) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;
        //////////////////////
        this.NIE = NIE;
        this.nombre_estudiante = nombre_estudiante;
        this.nombre_ResponsableA = nombre_ResponsableA;
        this.nombre_ResponsableB = nombre_ResponsableB;
        this.estado = estado;
        this.Id_Responsable = Id_Responsable;
        this.mes = mes;
        this.Year = Year;
        this.Mora = Mora;
        this.MontoFinal = MontoFinal;
        this.id_Estado = id_Estado;
        this.id_Grado = id_Grado;
    }

    public Modelo_Mensualidad() {
        this.claseConectar = new ClaseConexion();
    }

    public int Insert_Mensualidad_MesActual(int year, int mes) {
        try {
            Modelo_Estudiante NewNIE = new Modelo_Estudiante();
            ArrayList<Modelo_Estudiante> Lista_NIES = NewNIE.Get_NIES_ParaMEnsualidades();

            String SqlInsertMensualidad = """
            INSERT INTO public."Tbl_Mensualidades"(
                "NIE", "Mes", "Year", "Mora", "MontoFinal", "Estado_id")
            VALUES (?, ?, ?, ?, ?, ?);""";

            conexionDB = claseConectar.iniciarConexion();
            int respuesta = 0; // Inicializamos la variable respuesta

            for (Modelo_Estudiante ItemNIE : Lista_NIES) {
                pstm = conexionDB.prepareCall(SqlInsertMensualidad);

                pstm.setInt(1, ItemNIE.getNIE());
                pstm.setInt(2, mes);
                pstm.setInt(3, year);
                pstm.setDouble(4, 0.0);
                pstm.setInt(5, 100);
                pstm.setInt(6, 0);

                respuesta = pstm.executeUpdate();
            }

            if (respuesta > 0) {
                Funciones.showMessageDialog("Info", "Talonario mensual generado.");
            }

            conexionDB.close();
            return respuesta;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Mensualidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Modelo_Mensualidad> Get_list_MensualidadesFiltrada(int grado, int estado, int mes) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
SELECT TBE."NIE",TBE."Apellidos",TBE."Nombres",TBE."Grado_id",
TBR."Apellidos_A",TBR."Nombres_A",TBR."Apellidos_B",TBR."Nombres_B",
"Mes", "Year", "Mora", "MontoFinal",
TBEP."Estado"

	FROM public."Tbl_Mensualidades" AS TBM
	INNER JOIN "tbl_Estudiante" AS  TBE ON TBM."NIE" = TBE."NIE"
	INNER JOIN "Tbl_Responsabless" AS TBR ON TBR.id = TBE."Responsables_id"
	INNER JOIN "Tbl_EstadoPagos" AS TBEP ON TBEP.id = TBM."Estado_id"

	
		WHERE TBE."Grado_id" = ? AND TBM."Estado_id" = ? AND TBM."Mes" = ? AND TBM."Year" = ? ;
                         """;

            int year = Funciones.Get_Year_Actual();

            PreparedStatement preparedStatement = conexionDB.prepareStatement(sql);
            preparedStatement.setInt(1, grado);
            preparedStatement.setInt(2, estado);
            preparedStatement.setInt(3, mes);
            preparedStatement.setInt(4, year);

            java.sql.ResultSet Consulta = preparedStatement.executeQuery();

            ArrayList<Modelo_Mensualidad> DataListado = new ArrayList<>();

            while (Consulta.next()) {
                Modelo_Mensualidad Estudiante = new Modelo_Mensualidad();

                Estudiante.setNIE(Consulta.getInt("NIE"));
                // Estudiante.setId_Responsable(Consulta.getInt("Responsables_id"));
                Estudiante.setNombre_ResponsableA(Consulta.getString("Apellidos_A") + Consulta.getString("Nombres_A"));
                Estudiante.setNombre_ResponsableB(Consulta.getString("Apellidos_B") + Consulta.getString("Nombres_B"));
                Estudiante.setNombre_estudiante(Consulta.getString("Apellidos") + Consulta.getString("Nombres"));

                Estudiante.setEstado(Consulta.getString("Estado"));
                Estudiante.setId_Grado(Consulta.getInt("Grado_id"));
                Estudiante.setMes(Consulta.getInt("Mes"));
                Estudiante.setYear(Consulta.getInt("Year"));

                Estudiante.setMontoFinal(Consulta.getDouble("MontoFinal"));
                Estudiante.setMora(Consulta.getDouble("Mora"));
                DataListado.add(Estudiante);
            }
            conexionDB.close();
            return DataListado;

        } catch (SQLException ex) {

            System.out.println("error" + ex.getMessage());
        }
        return null;
    }

    public boolean Validartalonario(int mes) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
SELECT "NIE"
	FROM public."Tbl_Mensualidades"
	WHERE "Mes" = ? AND "Year" = ? ;""";

            int year = Funciones.Get_Year_Actual();

            PreparedStatement preparedStatement = conexionDB.prepareStatement(sql);
            preparedStatement.setInt(1, mes);
            preparedStatement.setInt(2, year);
            System.out.println("validando " + mes + " year " + year);

            java.sql.ResultSet Consulta = preparedStatement.executeQuery();

            while (Consulta.next()) {
                conexionDB.close();

                return true;

            }

        } catch (SQLException ex) {

            System.out.println("error" + ex.getMessage());
        }

        return false;
    }

    public ArrayList<Modelo_Mensualidad> Get_list_FechaActual_Mensualidades(int year, int mes) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
SELECT TBE."NIE",TBE."Apellidos",TBE."Nombres",TBE."Grado_id",
TBR."Apellidos_A",TBR."Nombres_A",TBR."Apellidos_B",TBR."Nombres_B",
"Mes", "Year", "Mora", "MontoFinal",
TBEP."Estado"

	FROM public."Tbl_Mensualidades" AS TBM
	INNER JOIN "tbl_Estudiante" AS  TBE ON TBM."NIE" = TBE."NIE"
	INNER JOIN "Tbl_Responsabless" AS TBR ON TBR.id = TBE."Responsables_id"
	INNER JOIN "Tbl_EstadoPagos" AS TBEP ON TBEP.id = TBM."Estado_id"
	
	WHERE TBM."Year" = ? AND TBM."Mes" = ? ;  """;

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, year);
            pstm.setInt(2, mes);

            java.sql.ResultSet Consulta = pstm.executeQuery(); // Ejecutamos la consulta
System.out.println("sql> " +pstm.toString());
            ArrayList<Modelo_Mensualidad> DataListado = new ArrayList<>();

            while (Consulta.next()) {
                Modelo_Mensualidad Estudiante = new Modelo_Mensualidad();

                Estudiante.setNIE(Consulta.getInt("NIE"));
                // Estudiante.setId_Responsable(Consulta.getInt("Responsables_id"));
                Estudiante.setNombre_ResponsableA(Consulta.getString("Apellidos_A") + Consulta.getString("Nombres_A"));
                Estudiante.setNombre_ResponsableB(Consulta.getString("Apellidos_B") + Consulta.getString("Nombres_B"));
                Estudiante.setNombre_estudiante(Consulta.getString("Apellidos") + Consulta.getString("Nombres"));

                Estudiante.setEstado(Consulta.getString("Estado"));
                Estudiante.setId_Grado(Consulta.getInt("Grado_id"));
                Estudiante.setMes(Consulta.getInt("Mes"));
                Estudiante.setYear(Consulta.getInt("Year"));

                Estudiante.setMontoFinal(Consulta.getDouble("MontoFinal"));
                Estudiante.setMora(Consulta.getDouble("Mora"));
                DataListado.add(Estudiante);
            }
            conexionDB.close();
            return DataListado;

        } catch (SQLException ex) {

            System.out.println("error" + ex.getMessage());
        }
        return null;
    }

    public ArrayList<Modelo_Mensualidad> Get_NIES_MensualidadesAtrasadas(int year, int mes) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
SELECT TBE."NIE" FROM public."Tbl_Mensualidades" AS TBM
	INNER JOIN "tbl_Estudiante" AS  TBE ON TBM."NIE" = TBE."NIE"
	INNER JOIN "Tbl_Responsabless" AS TBR ON TBR.id = TBE."Responsables_id"
	INNER JOIN "Tbl_EstadoPagos" AS TBEP ON TBEP.id = TBM."Estado_id"
	
	WHERE TBM."Year" = ? AND TBM."Mes" < ? AND TBM."Estado_id"= 0  ;
                         """;

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, year);
            pstm.setInt(2, mes);

            java.sql.ResultSet Consulta = pstm.executeQuery(); // Ejecutamos la consulta
            System.out.println("SQL> " + pstm.toString());

            ArrayList<Modelo_Mensualidad> List_MensualidadesAtrasadas = new ArrayList<>();

            while (Consulta.next()) {
                Modelo_Mensualidad MensualidadAtrasada = new Modelo_Mensualidad();

                MensualidadAtrasada.setNIE(Consulta.getInt("NIE"));

                List_MensualidadesAtrasadas.add(MensualidadAtrasada);
            }

            System.out.println("######CANT NIES CON MENSUALIDADES ATRASADAS " + List_MensualidadesAtrasadas.size());

            conexionDB.close();
            return List_MensualidadesAtrasadas;

        } catch (SQLException ex) {

            System.out.println("error" + ex.getMessage());
        }
        return null;
    }

    public void Edit_AtrasoMensualidad(int year, int mes) {
        try {
            String sql = """
UPDATE public."Tbl_Mensualidades"
	SET "Mora"= 3, "MontoFinal"= 103 , "Estado_id"= 2
	WHERE  "NIE"= ?  ;
        """;

            Modelo_Mensualidad objMensualidad = new Modelo_Mensualidad();
            ArrayList<Modelo_Mensualidad> List_MensualidadesAtrasadas = objMensualidad.Get_NIES_MensualidadesAtrasadas(year, mes);

            conexionDB = claseConectar.iniciarConexion();
            int cantidadAtrasos = 0;

            for (Modelo_Mensualidad item : List_MensualidadesAtrasadas) {
                pstm = conexionDB.prepareStatement(sql);
                pstm.setDouble(1, item.getNIE());
                System.out.println("sql > " + pstm.toString());
                cantidadAtrasos++;

                int respuesta = pstm.executeUpdate();
                System.out.println(">" + respuesta);

            }

            if (cantidadAtrasos > 0) {
                Funciones.showMessageDialog("Info", "Hay " + cantidadAtrasos + " mensualidades pendientes de pago, realizar aviso correspondiente.");
            }

            conexionDB.close();

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            // Aquí podrías mostrar un mensaje de error al usuario
        }
    }

    public Modelo_Mensualidad Get_DatoMensualidad(int year, int mes, int NIE, int grado) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            String sql = """
SELECT TBE."NIE",TBE."Apellidos",TBE."Nombres",TBE."Grado_id" ,
TBR."Apellidos_A",TBR."Nombres_A",TBR."Apellidos_B",TBR."Nombres_B",
"Mes", "Year", "Mora", "MontoFinal",
TBEP."Estado"

	FROM public."Tbl_Mensualidades" AS TBM
	INNER JOIN "tbl_Estudiante" AS  TBE ON TBM."NIE" = TBE."NIE"
	INNER JOIN "Tbl_Responsabless" AS TBR ON TBR.id = TBE."Responsables_id"
	INNER JOIN "Tbl_EstadoPagos" AS TBEP ON TBEP.id = TBM."Estado_id"
	
	WHERE TBM."Year" = ? AND TBM."Mes" = ? AND TBE."NIE" = ?  AND TBE."Grado_id" = ? ;
                         """;

            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, year);
            pstm.setInt(2, mes);
            pstm.setInt(3, NIE);
            pstm.setInt(4, grado);

            java.sql.ResultSet Consulta = pstm.executeQuery(); // Ejecutamos la consulta
            Modelo_Mensualidad Estudiante = new Modelo_Mensualidad();
            while (Consulta.next()) {

                Estudiante.setNIE(Consulta.getInt("NIE"));
                // Estudiante.setId_Responsable(Consulta.getInt("Responsables_id"));
                Estudiante.setNombre_ResponsableA(Consulta.getString("Apellidos_A") + Consulta.getString("Nombres_A"));
                Estudiante.setNombre_ResponsableB(Consulta.getString("Apellidos_B") + Consulta.getString("Nombres_B"));
                Estudiante.setNombre_estudiante(Consulta.getString("Apellidos") + Consulta.getString("Nombres"));

                Estudiante.setEstado(Consulta.getString("Estado"));
                Estudiante.setId_Grado(Consulta.getInt("Grado_id"));
                Estudiante.setMes(Consulta.getInt("Mes"));
                Estudiante.setYear(Consulta.getInt("Year"));

                Estudiante.setMontoFinal(Consulta.getDouble("MontoFinal"));
                Estudiante.setMora(Consulta.getDouble("Mora"));
                System.out.println(">" + Consulta.getInt("Year"));
            }
            conexionDB.close();
            return Estudiante;

        } catch (SQLException ex) {

            System.out.println("error" + ex.getMessage());
        }
        return null;
    }

    public int Edit_PagoMensualidad(Modelo_Mensualidad DatosMensualidad) {
        try {
            String sql = """
UPDATE public."Tbl_Mensualidades"
            	SET  "MontoFinal"=?, "Estado_id"=?
            	WHERE "NIE"=? AND "Mes"=? AND "Year"=? ;
        """;

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareStatement(sql);

            Date fecha = new Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            double MONTOFINAL = DatosMensualidad.getMora() + DatosMensualidad.getMontoFinal();

            System.out.println("ID a modificar: " + DatosMensualidad.getNIE() + "MES" + DatosMensualidad.getMes()
                    + "YEAR" + DatosMensualidad.getYear());

            System.out.println("DATOS FECHA: " + fechaSQL + " MORA " + DatosMensualidad.getMora()
                    + " MONTO FINAL " + MONTOFINAL);

            pstm.setDouble(1, MONTOFINAL);
            pstm.setInt(2, 1); // ID de estado pagado
            pstm.setInt(3, DatosMensualidad.getNIE());
            pstm.setInt(4, DatosMensualidad.getMes());
            pstm.setInt(5, DatosMensualidad.getYear());
            System.out.println("sql > " + pstm.toString());

            int respuesta = pstm.executeUpdate();

            if (respuesta > 0) {
                Funciones.showMessageDialog("Info", "Pago satisfactorio");
            }

            conexionDB.close();
            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            // Aquí podrías mostrar un mensaje de error al usuario
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
            java.util.logging.Logger.getLogger(Modelo_Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Modelo_Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }
}
