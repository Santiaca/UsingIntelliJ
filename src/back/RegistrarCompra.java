package back;

import bussines.Registro;

import java.io.FileWriter;
import java.io.PrintWriter;

public class RegistrarCompra {

    public boolean registrarCompra(String rutaArchivoACrear, Registro objRegistro) {

        boolean registroCompra = false;
        FileWriter fichero = null;
        PrintWriter printWriter = null;
        try {
            fichero = new FileWriter(rutaArchivoACrear,true);
            printWriter = new PrintWriter(fichero);
            printWriter.println(objRegistro.getCantidadProductosComprados() + ":" + objRegistro.getProductoComprado() + ":" + objRegistro.getValorPagado());
            registroCompra = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // asegurarnos que se cierra el fichero
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return registroCompra;
    }
}
