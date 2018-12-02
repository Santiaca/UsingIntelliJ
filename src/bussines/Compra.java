package bussines;

public class Compra {

    private String producto;
    private int diaSemana;
    private int cantidad;

    public Compra() {
        this.producto="";
        this.diaSemana=0;
        this.cantidad=0;
    }

    public String getProducto() {return producto;}

    public void setProducto(String producto) {this.producto = producto;}

    public int getDiaSemana() {return diaSemana;}

    public void setDiaSemana(int diaSemana) {this.diaSemana = diaSemana;}

    public int getCantidad() {return cantidad;}

    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

}
