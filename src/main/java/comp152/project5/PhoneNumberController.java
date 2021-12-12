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
    private ListView<Map<String, String>> ListControl;
    @FXML
    private TextField NameField;
    @FXML
    private TextField CodeField;
    @FXML
    private TextField PrefixField;

    private PhoneNumberDataHandler ModelNames;
    private PhoneNumberDataHandler ModelPhone;


    public void loadDataNames(){
        var siteNames="http://country.io/names.json";

        ModelNames=new PhoneNumberDataHandler(siteNames);
        var NamesList=ModelNames.getPhoneDataNames();
        ObservableList<Map<String, String>> dataToShowNames=
                FXCollections.observableArrayList(NamesList);
        ListControl.setItems(dataToShowNames);
    }


    @FXML
    public void closeWindowPhoneNumber(ActionEvent event){
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
