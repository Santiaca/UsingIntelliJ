package bussines;

import back.ConsultarDescuento;
import back.ConsultarPrecio;

public class CalcularDatos {

    public CalcularDatos(){
    }

    public Pago calcularDatos(Compra objCompra) {

        front.Controller controller = new front.Controller();
        String rutaLocal = controller.rutaLocal;

        ConsultarPrecio objConsultarPrecio = new ConsultarPrecio();
        objConsultarPrecio.consultarPrecio(rutaLocal+"//Producto.txt", 1, 2, objCompra);

        ConsultarDescuento objConsultarDescuento = new ConsultarDescuento();
        objConsultarDescuento.consultarDescuento(rutaLocal+"//Descuento.txt",2,  objCompra);

        Pago objPago = new Pago();

        //valor unitario
        objPago.setValorUnitarioProducto(objConsultarPrecio.getPrecioProducto());

        //porcentaje descuento
        objPago.setPorcentajeDescuento(objConsultarDescuento.getDescuentoProducto()* 100);

        //valor descuento total
        objPago.setValorDescuento((objPago.getValorUnitarioProducto() * objCompra.getCantidad() * objConsultarDescuento.getDescuentoProducto()));

        //valor total
        objPago.setTotalPagar(objPago.getValorUnitarioProducto() * objCompra.getCantidad() - objPago.getValorDescuento());

        return objPago;
    }

}
