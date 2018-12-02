package back;

import bussines.Compra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConsultarDescuento {

    private double descuentoProducto;

    public boolean consultarDescuento(String rutaArchivoAConsultar, int indiceCampoAConsultar, Compra objCompra ){

        boolean consultaDescuento=false;

        BufferedReader br = null;
        FileReader fr = null;
        try{
            fr = new FileReader(rutaArchivoAConsultar);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine())!=null){
                if((sCurrentLine.split(":")[indiceCampoAConsultar]).equals(String.valueOf((objCompra.getProducto()))))
                {
                    if ((sCurrentLine.split(":")[0]).equals(String.valueOf(objCompra.getDiaSemana()))) {
                        descuentoProducto = Double.parseDouble(sCurrentLine.split(":")[3]) ;
                        consultaDescuento = true;
                        break;
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return consultaDescuento;

    }

    public double getDescuentoProducto() {return descuentoProducto;}

    public void setDescuentoProducto(double descuentoProducto) {this.descuentoProducto = descuentoProducto;}
}
