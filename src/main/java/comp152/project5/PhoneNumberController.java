package comp152.project5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class PhoneNumberController implements Initializable {


    @FXML
    private ListView<HashMap<String, String>> listControlNames;
    @FXML
    private ListView<HashMap<String, String>> listControlPhone;
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
        ObservableList<HashMap<String, String>> dataToShowNames=
                FXCollections.observableArrayList(NamesList);
        listControlNames.setItems(dataToShowNames);
    }

    public void loadDataPhone(){
        var sitePhone="http://country.io/phone.json";

        ModelPhone=new PhoneNumberDataHandler(sitePhone);
        var PhoneList=ModelPhone.getPhoneDataPhone();
        ObservableList<HashMap<String,String>> dataToShowPhone=
                FXCollections.observableArrayList(PhoneList);
        listControlPhone.setItems(dataToShowPhone);
    }


    @FXML
    public void closeWindowPhoneNumber(ActionEvent event){
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
