package bussines;

public class Pago {

    private double valorUnitarioProducto;
    private double porcentajeDescuento;
    private double valorDescuento;
    private double totalPagar;

    public Pago() {
        this.valorUnitarioProducto = 0;
        this.porcentajeDescuento = 0;
        this.valorDescuento = 0;
        this.totalPagar = 0;
    }

    public double getValorUnitarioProducto() {
        return valorUnitarioProducto;
    }

    public void setValorUnitarioProducto(double valorUnitarioProducto) {
        this.valorUnitarioProducto = valorUnitarioProducto;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
}
