package comp152.project5;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberController implements Initializable {


    private PhoneNumberDataHandler Model;


    public void loadDataCountries(){
        var site="http://country.io/names.json";

        List<String>allLines=null;
        try {
            allLines= Files.readAllLines(Path.of(site));
        } catch (IOException e) {
            e.printStackTrace();
        }

        var siteData=new HashMap<String, String>();

    }
}
