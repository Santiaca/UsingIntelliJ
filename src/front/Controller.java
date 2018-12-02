package front;

import back.CargarComboBox;
import back.RegistrarCompra;
import bussines.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import back.conexionBaseDeDatos;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Controller  implements Initializable{

    public String rutaLocal="C://Users//santiaca//IdeaProjects//UsingIntelliJ";

   /* ObservableList<String> availableProducto = FXCollections.observableArrayList("Ipod","Screen","PS4","Memoria Ram 8GB","Camara");
    ObservableList<String> ava = FXCollections.observableArrayList("Ipod","Screen","PS4","Memoria Ram 8GB","Camara");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cboProducto.setItems(availableProducto);
    }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CargarComboBox carcarComboBox = new CargarComboBox();
        //Cargar lista del combo Semanas
        carcarComboBox.cargarDatosEnComboBox(rutaLocal+"//Descuento.txt", 0, cboDiaSemana);
        //Cargar lista del combo Producto
        carcarComboBox.cargarDatosEnComboBox(rutaLocal+"//Producto.txt", 1, cboProducto);
    }

    @FXML
    private ComboBox<String> cboProducto;

    @FXML
    private ComboBox<String> cboDiaSemana;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtPorcentajeDescuento;

    @FXML
    private TextField txtValorDescuento;

    @FXML
    private TextField txtValorTotalPagar;

    @FXML
    private TextField txtValorUnitario;

    @FXML
    private Button btnRegistrarCompra;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnCalcularDatos;

    @FXML
    private Label lblMensaje;

    @FXML
    private Label lblMensajeError;

    public boolean validarDatos() {
        boolean validado = false;

        if ("".equals(cboProducto.getValue())){
            validado = true;
        }
        if ("".equals(cboDiaSemana.getValue())) {
            validado = true;
        }
        if (txtCantidad.getText().equals("")) {
            validado = true;
        }
        return validado;
    }

    @FXML
    void clicCalcularDatos(ActionEvent event) {

        Compra objCompra = new Compra();

        boolean validaDatos = validarDatos();

        if (!validaDatos) {
            objCompra.setProducto(cboProducto.getSelectionModel().getSelectedItem());
            objCompra.setDiaSemana(Integer.parseInt(cboDiaSemana.getSelectionModel().getSelectedItem()));
            objCompra.setCantidad(Integer.parseInt(txtCantidad.getText()));
            CalcularDatos objCalcularDatos = new CalcularDatos();

            //Asignando al objPago el retorno de calcularDatos
            Pago objPago = objCalcularDatos.calcularDatos(objCompra);
            txtValorUnitario.setText(String.valueOf(objPago.getValorUnitarioProducto()));
            txtPorcentajeDescuento.setText(String.valueOf(objPago.getPorcentajeDescuento())+"%");
            txtValorDescuento.setText(String.valueOf(objPago.getValorDescuento()));
            txtValorTotalPagar.setText(String.valueOf(objPago.getTotalPagar()));
            lblMensajeError.setText("");
        } else {
            lblMensajeError.setText("Falta información por diligenciar");
        }
    }

    @FXML
    void clicLlimpiar(ActionEvent event) throws SQLException {
       cboDiaSemana.setValue("Seleccione:");
        cboProducto.setValue("Seleccione:");
        txtCantidad.setText("0");
        txtValorUnitario.setText("0");
        txtPorcentajeDescuento.setText("0");
        txtValorDescuento.setText("0");
        txtValorTotalPagar.setText("0");
        lblMensaje.setText("");
        lblMensajeError.setText("");
    }

    @FXML
    void clicRegistrarCompra(ActionEvent event) throws SQLException {

        Registro objRegistro = new Registro();
        objRegistro.setProductoComprado(cboProducto.getSelectionModel().getSelectedItem());
        objRegistro.setCantidadProductosComprados(Integer.parseInt(txtCantidad.getText()));
        objRegistro.setValorPagado(Double.parseDouble(txtValorTotalPagar.getText()));

        RegistrarCompra objRegistrarCompra = new RegistrarCompra();
        objRegistrarCompra.registrarCompra(rutaLocal+"//RegistroVentas.txt", objRegistro);

        conexionBaseDeDatos objCnxBD = new conexionBaseDeDatos();
        objCnxBD.insertarDatosEnBD(objRegistro);

        lblMensaje.setText("Compra registrada correctamente");

    }

    @FXML
    void seleccionarProducto(ActionEvent event) {
        cboDiaSemana.setValue("Seleccione:");
        txtCantidad.setText("0");
        txtValorUnitario.setText("0");
        txtPorcentajeDescuento.setText("0");
        txtValorDescuento.setText("0");
        txtValorTotalPagar.setText("0");
        lblMensaje.setText("");
        lblMensajeError.setText("");
    }
}
