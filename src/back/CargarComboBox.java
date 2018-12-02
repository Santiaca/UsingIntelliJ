package back;

import javafx.scene.control.ComboBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargarComboBox {

    public void cargarDatosEnComboBox(String rutaArchivoAConsultar, int indiceCampoAConsultar, ComboBox<String> comboBox){
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivoAConsultar));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                //Add Item
                // comboBox.getItems().add(line);
                comboBox.getItems().addAll(line.split(":")[indiceCampoAConsultar]);
                sb.append(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No se encontro archivo");

        }
    }
}
