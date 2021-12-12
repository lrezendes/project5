package comp152.project5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class PhoneNumberController implements Initializable {


    @FXML
    private ListView<Map> ListControl;
    @FXML
    private TextField NameField;
    @FXML
    private TextField CodeField;
    @FXML
    private TextField PrefixField;

    private PhoneNumberDataHandler Model;


    public void loadDataCountries(){
        var site="http://country.io/names.json";

        Model=new PhoneNumberDataHandler(site);
        var countryList=Model.getPhoneData();
        ObservableList<Map> dataToShow=
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
