package back;

import bussines.Compra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConsultarPrecio {

    private double precioProducto;

    public boolean consultarPrecio(String rutaArchivoAConsultar, int indiceCampoAConsultar, int indiceCampoAObtener, Compra objCompra){
        boolean consultaPrecio=false;

        BufferedReader br = null;
        FileReader fr = null;
        try{
            fr = new FileReader(rutaArchivoAConsultar);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine())!=null){
                if((sCurrentLine.split(":")[indiceCampoAConsultar]).equals(String.valueOf((objCompra.getProducto()))))
                {
                    precioProducto = Double.parseDouble(sCurrentLine.split(":")[indiceCampoAObtener]);
                    consultaPrecio=true;
                    break;
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return consultaPrecio;


    }

    public double getPrecioProducto() {
        return precioProducto;
    }
}
