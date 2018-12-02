package back;

import javafx.scene.control.ComboBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargarComboBox {

    public void cargarDatosEnComboBox(String rutaArchivoAConsultar, int indiceCampoAConsultar, ComboBox<String> comboBox) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(rutaArchivoAConsultar));
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                //Add Item
                // comboBox.getItems().add(line);
                comboBox.getItems().addAll(line.split(":")[indiceCampoAConsultar]);
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("No se encontro archivo");

        }
    }
}
