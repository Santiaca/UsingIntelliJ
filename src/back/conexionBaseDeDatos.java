package back;

import bussines.Registro;
import java.sql.*;

public class conexionBaseDeDatos {

    Connection connection = null;

    public conexionBaseDeDatos() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }

    public void insertarDatosEnBD(Registro objRegistro) throws SQLException {
        String productoComprado = objRegistro.getProductoComprado();
        int cantidadProductosComprados = objRegistro.getCantidadProductosComprados();
        double valorpagado = objRegistro.getValorPagado();

        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO TABLA_COMPRAS VALUES " + "('" + productoComprado + "','" + cantidadProductosComprados + "','" + valorpagado + "',SYSDATE" + ")");
        statement.close();
    }

}
