package comp152.project5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class PhoneNumberController implements Initializable {


    @FXML
    private ListView<HashMap> ListControl;

    private PhoneNumberDataHandler Model;


    public void loadDataCountries(){
        var site="http://country.io/names.json";

        Model=new PhoneNumberDataHandler(site);
        var countryList=Model.getPhoneData();
        ObservableList<HashMap> dataToShow=
                FXCollections.observableArrayList(countryList);
        ListControl.setItems(dataToShow);


    }


    @FXML
    public void closeWindowPhoneNumber(ActionEvent event){
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
