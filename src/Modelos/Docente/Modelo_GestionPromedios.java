package Modelos.Docente;

import Conexion.ClaseConexion;
import static Funciones.Funciones.TiemSql;
import Modelos.Secretaria.Modelo_Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_GestionPromedios {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

//lado Servidor
//lado escritorio
    private int NIE;

    private int Grado;
    private String Nombre;
    private List<Double> NotasActividades;

    private Double Parcial;
    private Double AutoE;

    private Double NotaPeriodo_1;
    private Double NotaPeriodo_2;
    private Double NotaPeriodo_3;
    private Double NotaPeriodo_4;

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

    public int getGrado() {
        return Grado;
    }

    public void setGrado(int Grado) {
        this.Grado = Grado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public List<Double> getNotasActividades() {
        return NotasActividades;
    }

    public void setNotasActividades(List<Double> NotasActividades) {
        this.NotasActividades = NotasActividades;
    }

    public Double getParcial() {
        return Parcial;
    }

    public void setParcial(Double Parcial) {
        this.Parcial = Parcial;
    }

    public Double getAutoE() {
        return AutoE;
    }

    public void setAutoE(Double AutoE) {
        this.AutoE = AutoE;
    }

    public Double getNotaPeriodo_1() {
        return NotaPeriodo_1;
    }

    public void setNotaPeriodo_1(Double NotaPeriodo_1) {
        this.NotaPeriodo_1 = NotaPeriodo_1;
    }

    public Double getNotaPeriodo_2() {
        return NotaPeriodo_2;
    }

    public void setNotaPeriodo_2(Double NotaPeriodo_2) {
        this.NotaPeriodo_2 = NotaPeriodo_2;
    }

    public Double getNotaPeriodo_3() {
        return NotaPeriodo_3;
    }

    public void setNotaPeriodo_3(Double NotaPeriodo_3) {
        this.NotaPeriodo_3 = NotaPeriodo_3;
    }

    public Double getNotaPeriodo_4() {
        return NotaPeriodo_4;
    }

    public void setNotaPeriodo_4(Double NotaPeriodo_4) {
        this.NotaPeriodo_4 = NotaPeriodo_4;
    }

    public Modelo_GestionPromedios(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int NIE, int Grado, String Nombre, List<Double> NotasActividades, Double Parcial, Double AutoE,
            Double NotaPeriodo_1, Double NotaPeriodo_2, Double NotaPeriodo_3, Double NotaPeriodo_4) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = claseConectar;
        this.pstm = pstm;
        this.NIE = NIE;
        this.Grado = Grado;
        this.Nombre = Nombre;
        this.NotasActividades = NotasActividades;
        this.Parcial = Parcial;
        this.AutoE = AutoE;
        this.NotaPeriodo_1 = NotaPeriodo_1;
        this.NotaPeriodo_2 = NotaPeriodo_2;
        this.NotaPeriodo_3 = NotaPeriodo_3;
        this.NotaPeriodo_4 = NotaPeriodo_4;
    }

    public Modelo_GestionPromedios() {
        this.claseConectar = new ClaseConexion();
    }

    /**
     * @param NIE
     * @param Grado
     * @return
     * *******************************************************************************************************************
     */
    public ArrayList<Modelo_GestionPromedios> Get_Promedio(int NIE, int Grado, int periodo) {
        try {
            System.out.println("---CARGAR NOTAS PROMEDIO ");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta
///////////////////////////////////

            ArrayList<Modelo_GestionPromedios> ListaPromedios = new ArrayList<>();

            Modelo_Materias objMateria = new Modelo_Materias();
            ArrayList<Modelo_Materias> ListadoMaterias = objMateria.Get_Id_ListadoMaterias(Grado);

            for (Modelo_Materias itemMateria : ListadoMaterias) {
                System.out.println("//////Materia" + itemMateria.getNombreMateria() + " id " + itemMateria.getidMateria());

            }

            Modelo_Estudiante objEstudiante = new Modelo_Estudiante();
            ArrayList<Modelo_Estudiante> ListadoNIES = objEstudiante.Get_Listado_NIES_porGrado(Grado);

            String ConsultaNotasPorMateria = """
SELECT "Estudiante_id", TipAct."TipoActividad", "NotaObtenida", Tmat."Nombre"
FROM public."Tbl_Nota_Actividad"
INNER JOIN "Tbl_Actividades" AS Tact ON Tact.id = "Tbl_Nota_Actividad"."Actividad_id"
INNER JOIN "Tbl_Materias" AS Tmat ON Tmat.id = Tact."Materia_id"
INNER JOIN "Tbl_TipoActividad" AS TipAct ON TipAct."id_Act" = Tact."TipoActividad_id"
WHERE "Estudiante_id" = ? AND Tact."Materia_id" = ?
ORDER BY Tact."TipoActividad_id" ASC ;
""";

            String tipoActividad = "";

            for (Modelo_Estudiante itemNIE : ListadoNIES) {
                Modelo_GestionPromedios PromediosEstudiante = new Modelo_GestionPromedios();
                ArrayList<Double> notas = new ArrayList<>();

                for (Modelo_Materias itemMateria : ListadoMaterias) {
                    System.out.println("//////Materia" + itemMateria.getNombreMateria());
                    PromediosEstudiante.setNombre(itemMateria.getNombreMateria());

                }

                for (Modelo_Materias itemMateria : ListadoMaterias) {

                    PreparedStatement preparedStatement1 = conexionDB.prepareStatement(ConsultaNotasPorMateria);

                    preparedStatement1.setInt(1, itemNIE.getNIE());
                    preparedStatement1.setInt(2, itemMateria.getidMateria());

                    ResultSet Consulta_notasActividades = preparedStatement1.executeQuery();

                    while (Consulta_notasActividades.next()) {
                        tipoActividad = Consulta_notasActividades.getString("TipoActividad");
                        System.out.println("##########buscando notas de  materia " + Consulta_notasActividades.getString("Nombre"));

                        switch (tipoActividad) {
                            case "Tarea" -> {
                                notas.add(Consulta_notasActividades.getDouble("NotaObtenida"));
                                System.out.println("Tarea");
                            }
                            case "Auto-Evaluacion" -> {
                                PromediosEstudiante.setAutoE(Consulta_notasActividades.getDouble("NotaObtenida"));
                                System.out.println("autoe");
                            }
                            case "Examen" -> {
                                PromediosEstudiante.setParcial(Consulta_notasActividades.getDouble("NotaObtenida"));
                                System.out.println("parcial");
                            }
                            default ->
                                throw new AssertionError();
                        }
                    }
                }

                if (PromediosEstudiante.getAutoE() == null) {
                    PromediosEstudiante.setAutoE(0.0);
                }

                if (PromediosEstudiante.getParcial() == null) {
                    PromediosEstudiante.setParcial(0.0);
                }

                while (notas.size() < 4) {
                    notas.add(0.0);
                }

                String ConsultaNotasPorNIE = """
SELECT Tb_Np."NIE", Tb_Mat."Nombre" , Tb_Np."Promedio_1", Tb_Np."Promedio_2", Tb_Np."Promedio_3", Tb_Np."Promedio_4"
FROM public."Tbl_NotasPromediadas" AS Tb_Np
INNER JOIN "Tbl_Materias" AS Tb_Mat ON Tb_Mat.id = Tb_Np."Materia_id"
INNER JOIN "Tbl_Grados" AS Tb_Gr ON Tb_Gr.id = Tb_Mat."Grado_id"
WHERE Tb_Np."NIE" = ?  AND Tb_Gr.id = ? ;
""";

                PreparedStatement preparedStatement2 = conexionDB.prepareStatement(ConsultaNotasPorNIE);
                preparedStatement2.setInt(1, itemNIE.getNIE());
                preparedStatement2.setInt(2, itemNIE.getId_Grado());

                ResultSet Consulta_Promedios = preparedStatement2.executeQuery();
                System.out.println("sql2 > " + preparedStatement2.toString());
                TiemSql();

                while (Consulta_Promedios.next()) {
                    System.out.println("Tomando las notas Trimestrales para nie " + itemNIE.getNIE() + " y el grado " + itemNIE.getId_Grado());
                    PromediosEstudiante.setNombre(Consulta_Promedios.getString("Nombre"));
                    PromediosEstudiante.setNotaPeriodo_1(Consulta_Promedios.getDouble("Promedio_1"));
                    PromediosEstudiante.setNotaPeriodo_2(Consulta_Promedios.getDouble("Promedio_2"));
                    PromediosEstudiante.setNotaPeriodo_3(Consulta_Promedios.getDouble("Promedio_3"));
                    PromediosEstudiante.setNotaPeriodo_4(Consulta_Promedios.getDouble("Promedio_4"));
                }

                PromediosEstudiante.setNotasActividades(notas);
                ListaPromedios.add(PromediosEstudiante);
            }

            conexionDB.close();

            return ListaPromedios;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_GestionPromedios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_GestionPromedios> Get_NotasPeriodo_NIE(int NIE, int Grado, int periodo) {
        try {
            System.out.println("---CARGAR NOTAS PROMEDIO ");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta
///////////////////////////////////

            Modelo_Materias objMateria = new Modelo_Materias();
            ArrayList<Modelo_Materias> ListadoMaterias = objMateria.Get_Id_ListadoMaterias(Grado);
            System.out.println("///////////hay materias" + ListadoMaterias.size());

            for (Modelo_Materias ListadoMateria : ListadoMaterias) {
                System.out.println(">>> " + ListadoMateria.getNombreMateria() + " " + ListadoMateria.getidMateria());
            }

            conexionDB.close();

            String ConsultaNotasPorMateria = """
SELECT "Estudiante_id", TipAct."TipoActividad", "NotaObtenida", Tmat."Nombre"
FROM public."Tbl_Nota_Actividad"
INNER JOIN "Tbl_Actividades" AS Tact ON Tact.id = "Tbl_Nota_Actividad"."Actividad_id"
INNER JOIN "Tbl_Materias" AS Tmat ON Tmat.id = Tact."Materia_id"
INNER JOIN "Tbl_TipoActividad" AS TipAct ON TipAct."id_Act" = Tact."TipoActividad_id"
WHERE "Estudiante_id" = ? AND Tact."Materia_id" = ?
ORDER BY Tact."TipoActividad_id" ASC ;
""";

            String tipoActividad = "";

            ArrayList<Modelo_GestionPromedios> ListaPromedios = new ArrayList<>();

            for (Modelo_Materias itemMateria : ListadoMaterias) {
                ArrayList<Double> notas = new ArrayList<>();
                conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
                Modelo_GestionPromedios PromediosEstudiante = new Modelo_GestionPromedios();
                    PromediosEstudiante.setNombre(itemMateria.getNombreMateria());

                System.out.println(">>>>>>>>>>>>>>>>>>> " + itemMateria.getNombreMateria());
                PreparedStatement preparedStatement1 = conexionDB.prepareStatement(ConsultaNotasPorMateria);

                preparedStatement1.setInt(1, NIE);
                preparedStatement1.setInt(2, itemMateria.getidMateria());

                ResultSet Consulta_notasActividades = preparedStatement1.executeQuery();

                System.out.println("SQL >  " + preparedStatement1.toString());
                if (Consulta_notasActividades.next()) {
                    System.out.println("SQL>>>>>>>>>>>>>>>>> RESULTADOS ENCONTRADOS");

                    while (Consulta_notasActividades.next()) {

                        tipoActividad = Consulta_notasActividades.getString("TipoActividad");
                        System.out.println("##########buscando notas de  materia " + Consulta_notasActividades.getString("Nombre"));
                        PromediosEstudiante.setNombre(itemMateria.getNombreMateria());

                        System.out.println("\nSQL > " + preparedStatement1.toString() + "\n");

                        switch (tipoActividad) {
                            case "Tarea" -> {
                                notas.add(Consulta_notasActividades.getDouble("NotaObtenida"));
                                System.out.println("Tarea");
                            }
                            case "Auto-Evaluacion" -> {
                                PromediosEstudiante.setAutoE(Consulta_notasActividades.getDouble("NotaObtenida"));
                                System.out.println("autoe");
                            }
                            case "Examen" -> {
                                PromediosEstudiante.setParcial(Consulta_notasActividades.getDouble("NotaObtenida"));
                                System.out.println("parcial");
                            }
                            default ->
                                throw new AssertionError();
                        }
                    }

                    if (PromediosEstudiante.getAutoE() == null) {
                        PromediosEstudiante.setAutoE(0.0);
                    }

                    if (PromediosEstudiante.getParcial() == null) {
                        PromediosEstudiante.setParcial(0.0);
                    }

                    while (notas.size() < 4) {
                        notas.add(0.0);
                    }
                } else {
                    System.out.println("SQL>>>>>>>>>>>>>>>> SIN RESULTADOS agragando vacio a  " + itemMateria.getNombreMateria());

                    if (PromediosEstudiante.getAutoE() == null) {
                        PromediosEstudiante.setAutoE(0.0);
                    }

                    if (PromediosEstudiante.getParcial() == null) {
                        PromediosEstudiante.setParcial(0.0);
                    }

                    while (notas.size() < 4) {
                        notas.add(0.0);
                    }
                    
                    PromediosEstudiante.setNotasActividades(notas);

                }

                PromediosEstudiante.setNotasActividades(notas);

                ListaPromedios.add(PromediosEstudiante);
                System.out.println("Termino materia --------------------------------------------\n\n");
                conexionDB.close();

            }

            conexionDB.close();
            return ListaPromedios;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_GestionPromedios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_GestionPromedios> Get_TrimestresPeriodo_NIE(int NIE, int Grado, int periodo) {
        try {
            System.out.println("---CARGAR NOTAS PROMEDIO ");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta
///////////////////////////////////

            String ConsultaNotasPorNIE = """
SELECT Tb_Np."NIE", Tb_Mat."Nombre" , Tb_Np."Promedio_1", Tb_Np."Promedio_2", Tb_Np."Promedio_3", Tb_Np."Promedio_4"
FROM public."Tbl_NotasPromediadas" AS Tb_Np
INNER JOIN "Tbl_Materias" AS Tb_Mat ON Tb_Mat.id = Tb_Np."Materia_id"
INNER JOIN "Tbl_Grados" AS Tb_Gr ON Tb_Gr.id = Tb_Mat."Grado_id"
WHERE Tb_Np."NIE" = ?  AND Tb_Gr.id = ? ;
""";

            PreparedStatement preparedStatement2 = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement2.setInt(1, NIE);
            preparedStatement2.setInt(2, Grado);

            ResultSet Consulta_Promedios = preparedStatement2.executeQuery();
            System.out.println("sql2 > " + preparedStatement2.toString());
            TiemSql();

            ArrayList<Modelo_GestionPromedios> ListaPromedios = new ArrayList<>();

            while (Consulta_Promedios.next()) {
                Modelo_GestionPromedios PromediosEstudiante = new Modelo_GestionPromedios();
                System.out.println("Tomando las notas Trimestrales para nie " + NIE + " y el grado " + Grado);
                PromediosEstudiante.setNotaPeriodo_1(Consulta_Promedios.getDouble("Promedio_1"));
                PromediosEstudiante.setNotaPeriodo_2(Consulta_Promedios.getDouble("Promedio_2"));
                PromediosEstudiante.setNotaPeriodo_3(Consulta_Promedios.getDouble("Promedio_3"));
                PromediosEstudiante.setNotaPeriodo_4(Consulta_Promedios.getDouble("Promedio_4"));
                System.out.println("Notas : " + Consulta_Promedios.getDouble("Promedio_1") + Consulta_Promedios.getDouble("Promedio_2") + Consulta_Promedios.getDouble("Promedio_3") + Consulta_Promedios.getDouble("Promedio_4"));

                ListaPromedios.add(PromediosEstudiante);
            }

            conexionDB.close();

            return ListaPromedios;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_GestionPromedios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Integer> Get_ListadoNIES() throws SQLException {
        System.out.println("---CARGAR NIES");
        conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
        statement = conexionDB.createStatement(); // Creamos la consulta
        String sql_lista = """
            SELECT "NIE" FROM public."tbl_Estudiante"
            WHERE "Grado_id" = 1;
        """;

        ArrayList<Integer> ListaNies = new ArrayList<>(); // Lista para almacenar los NIE de los estudiantes del grado

        ResultSet ConsultaListaNies = statement.executeQuery(sql_lista); // Ejecutamos la consulta con la query dada

        while (ConsultaListaNies.next()) {
            ListaNies.add(ConsultaListaNies.getInt("NIE"));
        }
        return ListaNies;
    }
////
////    public ArrayList<Modelo_GestionPromedios> getBusqueda(String Palabra, String ParametroBusqueda, int Periodo, int grado) {
////        try {
////            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
////            statement = conexionDB.createStatement(); // Creamos la consulta
////
////            ArrayList<Integer> ListaNies = new ArrayList<>(); // Lista para almacenar los NIE de los estudiantes
////
////            if (ParametroBusqueda.equalsIgnoreCase(" TbEst.\"NIE\" ")) {
////                System.out.println("====>BUSQUEDA NIE");
////
////                String BUsquedaPorNIE = """
////                SELECT "NIE" FROM public."tbl_Estudiante"
////                        WHERE "Grado_id" = 1 AND "NIE" = ?;
////                        """;
////
////                int nieBUscar = Integer.parseInt(Palabra);
////
////                pstm = conexionDB.prepareStatement(BUsquedaPorNIE);
////                pstm.setInt(1, nieBUscar);
////
////                ResultSet ConsultaListaNies = pstm.executeQuery(); // Ejecutamos la consulta con la query dada
////                TiemSql();
////
////                while (ConsultaListaNies.next()) {
////                    ListaNies.add(ConsultaListaNies.getInt("NIE"));
////                }
////
////                ArrayList<Modelo_GestionPromedios> BusquedaNota = new ArrayList<>(); // Lista para almacenar los datos de actividades
////
////                for (Integer nie : ListaNies) {
////                    String ConsultaNotasPorNIE = """
////SELECT TbEst."NIE", TbEst."Apellidos", TbEst."Nombres" ,
////tna."NotaObtenida",
////tbA."Nombre_Actividad"
////                	FROM public."Tbl_Nota_Actividad" AS tna
////                	INNER JOIN "tbl_Estudiante" AS TbEst ON TbEst."NIE" = tna."Estudiante_id"
////                	INNER JOIN "Tbl_Actividades" AS tbA ON tbA.id = tna."Actividad_id"
////                	INNER JOIN "Tbl_TipoActividad" AS tbtA ON tbtA.id = tbA."TipoActividad_id"
////                                                                     
////               	WHERE TbEst."NIE" = ? AND tbA."Periodo_id" = ? ;""";
////
////                    PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
////                    preparedStatement.setInt(1, nie);
////                    preparedStatement.setInt(2, Periodo);
////
////                    System.out.println("consulta:  " + pstm.toString());
////
////                    ResultSet consulta_Notas = preparedStatement.executeQuery(); // Ejecutamos la consulta
////                    TiemSql();
////
////                    ArrayList<Double> notas = new ArrayList<>(); // Lista para almacenar las notas del estudiante
////                    Modelo_GestionPromedios NotaAlumno = new Modelo_GestionPromedios();
////
////                    while (consulta_Notas.next()) {
////                        System.out.println("agregando nota de: " + consulta_Notas.getString("Nombres"));
////                        notas.add(consulta_Notas.getDouble("NotaObtenida"));
////                        NotaAlumno.setNIE(nie);
////                        NotaAlumno.setNombre(consulta_Notas.getString("Nombres"));
////                        NotaAlumno.setNotas(notas); // Asignar la lista de notas al estudiante
////
////                    }
////
////                    while (notas.size() < 6) {
////                        notas.add(0.0);
////                    }
////
////                    NotaAlumno.setNotas(notas); // Asignar la lista de notas al estudiante
////
////                    NotaAlumno.setNotas(notas); // Asignar la lista de notas al estudiante
////
////                    if (NotaAlumno.getNIE() != 0) {
////                        BusquedaNota.add(NotaAlumno); // Agregar el estudiante a la lista de actividades
////
////                    }
////                }
////
////                System.out.println("                        -> Agregados: " + BusquedaNota.size());
////                conexionDB.close();
////
////                return BusquedaNota;
////            } else {
////                System.out.println("====>BUSQUEDA POR " + ParametroBusqueda);
////
////                String BusquedaGeneral = """
////SELECT TbEst."NIE", TbEst."Apellidos", TbEst."Nombres" ,
////tna."NotaObtenida",
////tbA."Nombre_Actividad"
////                	FROM public."Tbl_Nota_Actividad" AS tna
////                	INNER JOIN "tbl_Estudiante" AS TbEst ON TbEst."NIE" = tna."Estudiante_id"
////                	INNER JOIN "Tbl_Actividades" AS tbA ON tbA.id = tna."Actividad_id"
////                	INNER JOIN "Tbl_TipoActividad" AS tbtA ON tbtA.id = tbA."TipoActividad_id"
////                                                                                                          
////                                                    	WHERE tbA."Periodo_id" = ? AND """;
////
////                BusquedaGeneral += " unaccent( " + ParametroBusqueda + " ) " + " LIKE unaccent( ? ) ;";
////
////                pstm = conexionDB.prepareStatement(BusquedaGeneral);
////
////                pstm.setInt(1, Periodo);
////                pstm.setString(2, Palabra + "%");
////
////                System.out.println("consulta:  " + pstm.toString());
////
////                ArrayList<Modelo_GestionPromedios> BusquedaNota = new ArrayList<>(); // Lista para almacenar los datos de actividades
////
////                ResultSet consulta_Notas = pstm.executeQuery(); // execute the query
////                TiemSql();
////
////                ArrayList<Double> notas = new ArrayList<>(); // Lista para almacenar las notas del estudiante
////                Modelo_GestionPromedios NotaAlumno = new Modelo_GestionPromedios();
////
////                int i = 1;
////                while (consulta_Notas.next()) {
////                    System.out.println(i + "agregando nota de: " + consulta_Notas.getString("Nombres"));
////                    notas.add(consulta_Notas.getDouble("NotaObtenida"));
////                    NotaAlumno.setNIE(consulta_Notas.getInt("NIE"));
////                    NotaAlumno.setNombre(consulta_Notas.getString("Nombres"));
////                    NotaAlumno.setNotas(notas); // Asignar la lista de notas al estudiante
////                    i++;
////                }
////
////                try {
////                    while (notas.size() < 6) {
////                        notas.add(0.0);
////                    }
////
////                } catch (NullPointerException ex) {
////                    System.out.println("La lista NotaAlumno.getNotas() está vacía.");
////                }
////
////                NotaAlumno.setNotas(notas); // Asignar la lista de notas al estudiante
////
////                if (NotaAlumno.getNIE() != 0) {
////                    BusquedaNota.add(NotaAlumno); // Agregar el estudiante a la lista de actividades
////
////                }
////                System.out.println("-> Agregados: " + BusquedaNota.size());
////                conexionDB.close();
////
////                return BusquedaNota;
////
////            }
////
////        } catch (SQLException ex) {
////            Logger.getLogger(Modelo_GestionPromedios.class.getName()).log(Level.SEVERE, null, ex);
////        }
////
////        return null;
////    }
//////adaprar los dos tipos de busquyeda
////
////    public ArrayList<Modelo_GestionPromedios> getBusquedaNombres(String Palabra, String ParametroBusqueda, int Periodo, int grado) {
////        try {
////            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
////            statement = conexionDB.createStatement(); // Creamos la consulta
////
////            System.out.println("====>BUSQUEDA POR " + ParametroBusqueda);
////
////            String BusquedaGeneral = """
////SELECT TbEst."NIE", TbEst."Apellidos", TbEst."Nombres" ,
////tna."Nota ",
////tbA."Nombre_Actividad"
////                	FROM public."Tbl_Nota_Actividad" AS tna
////                	INNER JOIN "tbl_Estudiante" AS TbEst ON TbEst."NIE" = tna."Estudiante_id"
////                	INNER JOIN "Tbl_Actividades" AS tbA ON tbA.id = tna."Actividad_id"
////                	INNER JOIN "Tbl_TipoActividad" AS tbtA ON tbtA.id = tbA."TipoActividad_id"
////                                                                                                          
////                                                    	WHERE  """;
////
////            BusquedaGeneral += ParametroBusqueda + " LIKE ? ;";
////
////            pstm = conexionDB.prepareStatement(BusquedaGeneral);
////            pstm.setString(1, Palabra + "%");
////
////            ArrayList<Modelo_GestionPromedios> NotaBuscar = new ArrayList<>(); // Lista para almacenar los datos de actividades
////
////            ResultSet consulta_Notas = pstm.executeQuery(); // execute the query
////
////            ArrayList<Double> notas = new ArrayList<>(); // Lista para almacenar las notas del estudiante
////            Modelo_GestionPromedios NotaAlumno = new Modelo_GestionPromedios();
////
////            int i = 1;
////            while (consulta_Notas.next()) {
////                System.out.println(i + "\nagregando nota de: " + consulta_Notas.getString("Nombres"));
////                notas.add(consulta_Notas.getDouble("Nota "));
////                NotaAlumno.setNIE(consulta_Notas.getInt("NIE"));
////                NotaAlumno.setNombre(consulta_Notas.getString("Nombres"));
////                NotaAlumno.setNotas(notas); // Asignar la lista de notas al estudiante
////                i++;
////            }
////
////            while (NotaAlumno.getNotas().size() < 6) {
////                notas.add(0.0);
////            }
////
////            NotaAlumno.setNotas(notas); // Asignar la lista de notas al estudiante
////
////            if (NotaAlumno.getNIE() != 0) {
////                NotaBuscar.add(NotaAlumno); // Agregar el estudiante a la lista de actividades
////
////            }
////            System.out.println("                        -> Agregados: " + NotaBuscar.size());
////            conexionDB.close();
////
////            return NotaBuscar;
////
////        } catch (SQLException ex) {
////            Logger.getLogger(Modelo_GestionPromedios.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        return null;
////    }
////
////    public ArrayList<Modelo_GestionPromedios> GetInforme() {
////        try {
////            conexionDB = claseConectar.iniciarConexion();//iniciamos una coneccion 
////            statement = conexionDB.createStatement();//crear consulta
////
////            String sql = """
////                         SELECT *,TM."Descuento",TM."Membresia",TR."Consumo",TR."Consumo_Final"  
////                         FROM public."Tbl_Cliente"  
////                         INNER JOIN "Tbl_Membresias" AS TM on TM."id_Membresia" = "Tbl_Cliente"."id_Membresia"
////                         INNER JOIN "Tbl_RegistroConsumo" AS TR ON TR."id_Cliente" = "Tbl_Cliente".idpersona""";
////
////            ResultSet consulta = statement.executeQuery(sql);//ejecutamos la consulta
////
////            ArrayList<Modelo_GestionPromedios> DataPersonas = new ArrayList<>();
////            while (consulta.next()) {
////
////                Modelo_GestionPromedios Persona = new Modelo_GestionPromedios();
////
//////                Persona.setId(consulta.getInt("idpersona"));
//////                Persona.setNombre(consulta.getString("Actividad"));
//////                Persona.setApellido_paterno(consulta.getString("apellido paterno"));
//////                Persona.setApellido_materno(consulta.getString("apellido materno"));
//////                Persona.setTipo_doc(consulta.getString("tipo_documneto"));
//////                Persona.setNum_doc(consulta.getString("num_documento"));
//////                Persona.setDireccion(consulta.getString("direccion"));
//////                Persona.setTelefono(consulta.getString("telefono"));
//////                Persona.setEmail(consulta.getString("email"));
//////                Persona.setPassword(consulta.getString("Password"));
//////                Persona.setMembresia(consulta.getDouble("Descuento"));
//////                Persona.setTierMembresia(consulta.getString("Membresia"));
//////                Persona.setConsumo(consulta.getDouble("Consumo"));
//////                Persona.setConsumoFinal(consulta.getDouble("Consumo_Final"));
////                DataPersonas.add(Persona);
////            }
////
////            conexionDB.close();
////            return DataPersonas;
////
////        } catch (SQLException ex) {
////            Logger.getLogger(Modelo_GestionPromedios.class
////                    .getName()).log(Level.SEVERE, null, ex);
////        }
////        return null;
////    }

    public Modelo_GestionPromedios GetPersona(int id) {
        try {
            conexionDB = claseConectar.iniciarConexion(); // initiate a connection

            String sql = "SELECT *,TM.\"Descuento\",TM.\"Membresia\"  FROM public.\"Tbl_Cliente\" INNER JOIN \"Tbl_Membresias\" AS TM on TM.\"id_Membresia\" = \"Tbl_Cliente\".\"id_Membresia\" WHERE idpersona = ?";
            pstm = conexionDB.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet consulta = pstm.executeQuery(); // execute the query

            Modelo_GestionPromedios Persona = null;
            if (consulta.next()) {
                Persona = new Modelo_GestionPromedios();
//
//                Persona.setId(consulta.getInt("idpersona"));
//                Persona.setNombre(consulta.getString("Actividad"));
//                Persona.setApellido_paterno(consulta.getString("apellido paterno"));
//                Persona.setApellido_materno(consulta.getString("apellido materno"));
//                Persona.setTipo_doc(consulta.getString("tipo_documneto"));
//                Persona.setNum_doc(consulta.getString("num_documento"));
//                Persona.setDireccion(consulta.getString("direccion"));
//                Persona.setTelefono(consulta.getString("telefono"));
//                Persona.setEmail(consulta.getString("email"));
//                Persona.setPassword(consulta.getString("Password"));
//                Persona.setMembresia(consulta.getDouble("Descuento"));
//                Persona.setTierMembresia(consulta.getString("Membresia"));
            }

            conexionDB.close();
            return Persona;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_GestionPromedios.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertNuevoCliente(Modelo_GestionPromedios PersonasInsert) {
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
            java.util.logging.Logger.getLogger(Modelo_GestionPromedios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int editPersonas(Modelo_GestionPromedios PersonasEdit) {
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
            java.util.logging.Logger.getLogger(Modelo_GestionPromedios.class
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
            //  System.out.println("cambio->> el ID: " + NIE + " membresia " + idMembresia + " >? " + respuesta);
            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_GestionPromedios.class
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
            java.util.logging.Logger.getLogger(Modelo_GestionPromedios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

}
