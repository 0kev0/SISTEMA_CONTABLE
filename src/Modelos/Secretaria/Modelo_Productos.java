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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Productos {

    private Connection conexionDB;
    private Statement statement;
    private ClaseConexion claseConectar;
    private PreparedStatement pstm;

//lado Servidor
//lado escritorio
    private int id;
    private int NIES;

    private int Cant_Disponible;
    private int Cant_venta;

    private String Nombre_Producto;
    private String Tipo_Producto;
    private String Descripcion;

    private Double Precio;
    private Double Costo;
    private List<Double> notas;

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

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public String getTipo_Producto() {
        return Tipo_Producto;
    }

    public void setTipo_Producto(String Tipo_Producto) {
        this.Tipo_Producto = Tipo_Producto;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double Costo) {
        this.Costo = Costo;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setnotas(List<Double> notas) {
        this.notas = notas;
    }

    public int getNIES() {
        return NIES;
    }

    public void setNIES(int NIES) {
        this.NIES = NIES;
    }

    public int getCant_Disponible() {
        return Cant_Disponible;
    }

    public void setCant_Disponible(int Cant_Disponible) {
        this.Cant_Disponible = Cant_Disponible;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCant_venta() {
        return Cant_venta;
    }

    public void setCant_venta(int Cant_venta) {
        this.Cant_venta = Cant_venta;
    }

    public Modelo_Productos(Connection conexionDB, Statement statement, ClaseConexion claseConectar, PreparedStatement pstm,
            int id, String Nombre_Producto, String Tipo_Producto, String Descripcion, Double Precio, Double Costo, int Cant_Disponible, int Cant_venta) {

        //LADO DEL SERVIDOR
        this.conexionDB = conexionDB;
        this.statement = statement;
        this.claseConectar = new ClaseConexion();
        this.pstm = pstm;

        //LADO APLICAION ESCRITORIO
        this.id = id;
        this.Nombre_Producto = Nombre_Producto;
        this.Tipo_Producto = Tipo_Producto;
        this.Descripcion = Descripcion;
        this.Cant_Disponible = Cant_Disponible;

        this.Precio = Precio;
        this.Costo = Costo;
        this.Cant_venta = Cant_venta;

    }

    public Modelo_Productos() {
        this.claseConectar = new ClaseConexion();
    }

    /**
     * @param id_tipoProducto
     * @param periodo
     * @param idmateria
     * @return
     * *******************************************************************************************************************
     */
    public ArrayList<Modelo_Productos> Get_Productos() {
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

            ArrayList<Modelo_Productos> ListaProductos = new ArrayList<>();

            while (Consulta_Productos.next()) {

                Modelo_Productos Producto = new Modelo_Productos();

                Producto.setid(Consulta_Productos.getInt("id"));
                Producto.setNombre_Producto(Consulta_Productos.getString("Nombre"));
                Producto.setTipo_Producto(Consulta_Productos.getString("Nombre_tipo"));
                Producto.setDescripcion(Consulta_Productos.getString("Descripcion_producto"));
                Producto.setCant_Disponible(Consulta_Productos.getInt("Cantidad_Disponible"));
                Producto.setCosto(Consulta_Productos.getDouble("Costo"));
                Producto.setPrecio(Consulta_Productos.getDouble("Precio"));

                System.out.println("agregado " + Producto.getNombre_Producto());
                ListaProductos.add(Producto);
            }

            System.out.println("\t-> Agregados: " + ListaProductos.size());
            conexionDB.close();

            return ListaProductos;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Double Get_Data(int id) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaCosto = """
SELECT  "Costo" FROM "Tbl_Productos" AS Tbl_Pr WHERE Tbl_Pr.id = ?;
            """;

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaCosto);
            preparedStatement.setInt(1, id);

            ResultSet Consulta_Productos = preparedStatement.executeQuery(); // Ejecutamos la consulta
            Double costo = 0.0;

            while (Consulta_Productos.next()) {
                costo = Consulta_Productos.getDouble("Costo");

            }

            conexionDB.close();

            return costo;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int Get_Data_Cant(int id) {
        try {
            System.out.println("---CARGAR PRODUCTOS");
            conexionDB = claseConectar.iniciarConexion(); // Iniciamos una conexión
            statement = conexionDB.createStatement(); // Creamos la consulta

            String ConsultaCosto = """
SELECT  "Cantidad_Disponible"
	FROM public."Tbl_Productos" WHERE id = ?;
            """;

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaCosto);
            preparedStatement.setInt(1, id);

            ResultSet Consulta_Productos = preparedStatement.executeQuery(); // Ejecutamos la consulta
            int cant = 0;

            while (Consulta_Productos.next()) {
                cant = Consulta_Productos.getInt("Cantidad_Disponible");

            }

            conexionDB.close();

            return cant;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public ArrayList<Modelo_Productos> Get_Productos_filtrado(int id_tipoProducto) {
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

            if (id_tipoProducto == 4) {
                ConsultaNotasPorNIE = """
SELECT  Tbl_Pr.id ,"Nombre", Tbl_TpR."Nombre_tipo", "Costo", "Precio", "Descripcion_producto", "Cantidad_Disponible"
	FROM "Tbl_Productos" AS Tbl_Pr
	INNER JOIN "Tbl_Tipo_Producto" AS Tbl_TpR ON Tbl_TpR.id = Tbl_Pr."Tipo_Producto_id" ;
            """;

                PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
                ResultSet Consulta_Productos = preparedStatement.executeQuery(); // Ejecutamos la consulta

                ArrayList<Modelo_Productos> ListaProductos = new ArrayList<>();
                while (Consulta_Productos.next()) {

                    Modelo_Productos Producto = new Modelo_Productos();

                    Producto.setid(Consulta_Productos.getInt("id"));
                    Producto.setNombre_Producto(Consulta_Productos.getString("Nombre"));
                    Producto.setTipo_Producto(Consulta_Productos.getString("Nombre_tipo"));
                    Producto.setDescripcion(Consulta_Productos.getString("Descripcion_producto"));
                    Producto.setCant_Disponible(Consulta_Productos.getInt("Cantidad_Disponible"));
                    Producto.setCosto(Consulta_Productos.getDouble("Costo"));
                    Producto.setPrecio(Consulta_Productos.getDouble("Precio"));

                    System.out.println("agregado " + Producto.getNombre_Producto());
                    ListaProductos.add(Producto);
                }

                System.out.println("\t-> Agregados: " + ListaProductos.size());
                conexionDB.close();

                return ListaProductos;
            }

            PreparedStatement preparedStatement = conexionDB.prepareStatement(ConsultaNotasPorNIE);
            preparedStatement.setInt(1, id_tipoProducto);

            ResultSet Consulta_Productos = preparedStatement.executeQuery(); // Ejecutamos la consulta
            //System.out.println("consulta:  " + preparedStatement.toString());

            TiemSql();

            ArrayList<Modelo_Productos> ListaProductos = new ArrayList<>();
            while (Consulta_Productos.next()) {

                Modelo_Productos Producto = new Modelo_Productos();

                Producto.setid(Consulta_Productos.getInt("id"));
                Producto.setNombre_Producto(Consulta_Productos.getString("Nombre"));
                Producto.setTipo_Producto(Consulta_Productos.getString("Nombre_tipo"));
                Producto.setDescripcion(Consulta_Productos.getString("Descripcion_producto"));
                Producto.setCant_Disponible(Consulta_Productos.getInt("Cantidad_Disponible"));
                Producto.setCosto(Consulta_Productos.getDouble("Costo"));
                Producto.setPrecio(Consulta_Productos.getDouble("Precio"));

                System.out.println("agregado " + Producto.getNombre_Producto());
                ListaProductos.add(Producto);
            }

            System.out.println("\t-> Agregados: " + ListaProductos.size());
            conexionDB.close();

            return ListaProductos;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int insertNuevoCliente(Modelo_Productos PersonasInsert) {
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
            java.util.logging.Logger.getLogger(Modelo_Productos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int editPersonas(Modelo_Productos PersonasEdit) {
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
            java.util.logging.Logger.getLogger(Modelo_Productos.class
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
            java.util.logging.Logger.getLogger(Modelo_Productos.class
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
            java.util.logging.Logger.getLogger(Modelo_Productos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }

}
