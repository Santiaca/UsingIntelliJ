package bussines;

public class Registro {

    private String productoComprado;
    private int cantidadProductosComprados;
    private double valorPagado;

    public Registro() {

        this.productoComprado = "";
        this.cantidadProductosComprados = 0;
        this.valorPagado = 0;
    }

    public String getProductoComprado() {
        return productoComprado;
    }

    public void setProductoComprado(String productoComprado) {this.productoComprado = productoComprado;}

    public int getCantidadProductosComprados() {return cantidadProductosComprados;}

    public void setCantidadProductosComprados(int cantidadProductosComprados) {
        this.cantidadProductosComprados = cantidadProductosComprados;
    }

    public double getValorPagado() {return valorPagado;}

    public void setValorPagado(double valorPagado) {this.valorPagado = valorPagado;}
}
