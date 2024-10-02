package Modelos.Secretaria;

import Conexion.ClaseConexion;
import static Funciones.Funciones.TiemSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Transacciones {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

//lado Servidor
//lado escritorio
    private int id;
    private int NIES_Responsable;
    private int Estudiante_id;

    private int id_tipo_transaccion;
    private int Cantidades;
    private String detalles;
    private String Responsable;
    private String Estudiante;
    private String Correo;

    private Double montos;
    private Double ganancias;
    private Double Precio;
    private Double Costos;

    private Date fecha;

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

    public int getNIES_Responsable() {
        return NIES_Responsable;
    }

    public void setNIES_Responsable(int NIES_Responsable) {
        this.NIES_Responsable = NIES_Responsable;
    }

    public int getEstudiante_id() {
        return Estudiante_id;
    }

    public void setEstudiante_id(int Estudiante_id) {
        this.Estudiante_id = Estudiante_id;
    }

    public int getId_tipo_transaccion() {
        return id_tipo_transaccion;
    }

    public void setId_tipo_transaccion(int id_tipo_transaccion) {
        this.id_tipo_transaccion = id_tipo_transaccion;
    }

    public int getCantidades() {
        return Cantidades;
    }

    public void setCantidades(int Cantidades) {
        this.Cantidades = Cantidades;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Double getMontos() {
        return montos;
    }

    public void setMontos(Double montos) {
        this.montos = montos;
    }

    public Double getGanancias() {
        return ganancias;
    }

    public void setGanancias(Double ganancias) {
        this.ganancias = ganancias;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public Double getCostos() {
        return Costos;
    }

    public void setCostos(Double Costos) {
        this.Costos = Costos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String Responsable) {
        this.Responsable = Responsable;
    }

    public String getEstudiante() {
        return Estudiante;
    }

    public void setEstudiante(String Estudiante) {
        this.Estudiante = Estudiante;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Modelo_Transacciones(int NIES_Responsable, int Estudiante_id, String Responsable, String Estudiante, String Correo) {
        this.NIES_Responsable = NIES_Responsable;
        this.Estudiante_id = Estudiante_id;
        this.Responsable = Responsable;
        this.Estudiante = Estudiante;
        this.Correo = Correo;
    }

    
    
    public Modelo_Transacciones(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int id, int NIES_Responsable, int id_tipo_transaccion, int Estudiante_id, Date fecha, int Cantidades, String detalles,
            Double montos, Double Precio, Double ganancias, Double Costos, String Responsable, String Estudiante) {
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;
        this.id = id;
        this.NIES_Responsable = NIES_Responsable;
        this.id_tipo_transaccion = id_tipo_transaccion;
        this.Cantidades = Cantidades;
        this.detalles = detalles;
        this.montos = montos;
        this.ganancias = ganancias;
        this.Costos = Costos;
        this.Precio = Precio;
        this.fecha = fecha;
        this.Estudiante_id = Estudiante_id;
        this.Estudiante = Estudiante;
        this.Responsable = Responsable;

    }

    public Modelo_Transacciones() {
        this.claseConectar = new ClaseConexion();
    }

    /**
     * @param id_tipoProducto
     * @param periodo
     * @param idmateria
     * @return
     * *******************************************************************************************************************
     */
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

    public Modelo_Transacciones Get_DatosRecibo(int Id_Responsable, int NIE) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT "NIE", "Nombres", "Apellidos",Tbl_Res."Apellidos_A",Tbl_Res."Nombres_A",Tbl_Res."Correo"
	FROM public."tbl_Estudiante"
	INNER JOIN "Tbl_Responsabless" AS Tbl_Res ON Tbl_Res.id = "tbl_Estudiante"."Responsables_id"
	WHERE "Responsables_id"= ? AND "NIE" = ?;""";

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement.setInt(1, Id_Responsable);
            preparedStatement.setInt(2, NIE);

            ResultSet Consulta_Productos = preparedStatement.executeQuery(); // Ejecutamos la consulta
            //System.out.println("consulta:  " + preparedStatement.toString());

            TiemSql();

            Modelo_Transacciones Datos = new Modelo_Transacciones();
            while (Consulta_Productos.next()) {
                Datos.setEstudiante_id(Consulta_Productos.getInt("NIE"));
                Datos.setEstudiante(Consulta_Productos.getString("Nombres") + " " + Consulta_Productos.getString("Apellidos"));
                Datos.setResponsable(Consulta_Productos.getString("Nombres_A") + " " + Consulta_Productos.getString("Apellidos_A"));
                Datos.setCorreo(Consulta_Productos.getString("Correo") );

            }

            conexionDB.close();

            return Datos;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Responsables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_Transacciones> Get_Productos() {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaNotasPorNIE = """
SELECT  Tbl_Pr.id ,"Nombre", Tbl_TpR."Nombre_tipo", "Costo", "Precio", "Descripcion_producto", "Cantidad_Disponible"
	FROM "Tbl_Productos" AS Tbl_Pr
	INNER JOIN "Tbl_Tipo_Producto" AS Tbl_TpR ON Tbl_TpR.id = Tbl_Pr."Tipo_Producto_id";
            """;

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);

            ResultSet Consulta_Productos = preparedStatement.executeQuery(); // Ejecutamos la consulta
            //System.out.println("consulta:  " + preparedStatement.toString());

            TiemSql();

            ArrayList<Modelo_Transacciones> ListaProductos = new ArrayList<>();

            while (Consulta_Productos.next()) {

                Modelo_Transacciones Producto = new Modelo_Transacciones();

//                Producto.setid(Consulta_Productos.getInt("id"));
//                Producto.setNombre_Producto(Consulta_Productos.getString("Nombre"));
//                Producto.setTipo_Producto(Consulta_Productos.getString("Nombre_tipo"));
//                Producto.setDescripcion(Consulta_Productos.getString("Descripcion_producto"));
//                Producto.setCant_Disponible(Consulta_Productos.getInt("Cantidad_Disponible"));
//                Producto.setCosto(Consulta_Productos.getDouble("Costo"));
//                Producto.setPrecio(Consulta_Productos.getDouble("Precio"));
//
//                System.out.println("agregado " + Producto.getNombre_Producto());
//                ListaProductos.add(Producto);
            }

            System.out.println("\t-> Agregados: " + ListaProductos.size());
            conexionDB.close();

            return ListaProductos;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Transacciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Modelo_Transacciones> Get_Productos_filtrado(int id_tipoProducto) {
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

            ArrayList<Modelo_Transacciones> ListaProductos = new ArrayList<>();
            while (Consulta_Productos.next()) {

                Modelo_Transacciones Producto = new Modelo_Transacciones();

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
            Logger.getLogger(Modelo_Transacciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int Insert_Transaccion(Modelo_Transacciones Transaccion) {
        try {
            String sql = """
INSERT INTO public."Tbl_Transaccion"("Detalle", "Cantidad", "Fecha", "Monto", "Tipo_Transaccion_id", "Costo", "Ganancia", "Responsable_id")
VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);""";
            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareCall(sql);

            pstm.setString(1, Transaccion.getDetalles());
            pstm.setInt(2, Transaccion.getCantidades());

            pstm.setDouble(4, Transaccion.getMontos());
            pstm.setInt(5, Transaccion.getId_tipo_transaccion());
            pstm.setDouble(6, Transaccion.getCostos());
            pstm.setDouble(7, Transaccion.getGanancias());
            pstm.setInt(8, Transaccion.getNIES_Responsable());

            java.util.Date fechaUtil = Transaccion.getFecha();
            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

            pstm.setDate(3, fechaSQL);

            int respuesta = pstm.executeUpdate();

            System.out.println(">>" + respuesta);

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Transacciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int Edit_Resta_inventario(Modelo_Transacciones ProductoVendido) {
        try {

            String sql = """
                         UPDATE public."Tbl_Productos" SET   "Cantidad_Disponible" = ? WHERE id = ?;""";

            conexionDB = claseConectar.iniciarConexion();
            pstm = conexionDB.prepareStatement(sql);

            int id = ProductoVendido.getId();
            Modelo_Productos cantidad = new Modelo_Productos();
            int cantidaddisponible = cantidad.Get_Data_Cant(id);

            int nuevoTotal = cantidaddisponible - ProductoVendido.getCantidades();

            System.out.println("tome la cantidad " + cantidaddisponible);
            System.out.println("para vender " + ProductoVendido.Cantidades);
            System.out.println("y queda " + nuevoTotal);

            System.out.println("id a modificar" + ProductoVendido.getId());
            pstm.setInt(1, ProductoVendido.getCantidades());
            pstm.setInt(2, nuevoTotal);

            int respuesta = pstm.executeUpdate();

            return respuesta;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Modelo_Transacciones.class
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
            java.util.logging.Logger.getLogger(Modelo_Transacciones.class
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
            java.util.logging.Logger.getLogger(Modelo_Transacciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

}
