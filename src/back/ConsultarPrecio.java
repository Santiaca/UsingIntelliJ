package back;

import bussines.Compra;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConsultarPrecio {

    private double precioProducto;

    public boolean consultarPrecio(String rutaArchivoAConsultar, int indiceCampoAConsultar, int indiceCampoAObtener, Compra objCompra) {
        boolean consultaPrecio = false;

        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(rutaArchivoAConsultar);
            bufferedReader = new BufferedReader(fileReader);
            String sCurrentLine;
            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                if ((sCurrentLine.split(":")[indiceCampoAConsultar]).equals(String.valueOf((objCompra.getProducto())))) {
                    precioProducto = Double.parseDouble(sCurrentLine.split(":")[indiceCampoAObtener]);
                    consultaPrecio = true;
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return consultaPrecio;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

}
