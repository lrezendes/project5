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
    private ListView<HashMap<String, String>> listControlNames;  //list view variable for one of the apis
    @FXML
    private ListView<HashMap<String, String>> listControlPhone;  //list view variable for the other api
    @FXML
    private TextField NameField;  //textfield variable for one of the textfields for API variables
    @FXML
    private TextField CodeField;  //textfield variable for one of the textfields for API variables
    @FXML
    private TextField PrefixField;  //textfield variable for one of the textfields for API variables

    private PhoneNumberDataHandler ModelNames;  //datahandler object for one of the api urls
    private PhoneNumberDataHandler ModelPhone;  //datahandler object for the other of the api urls


    public void loadDataNames(){
        var siteNames="http://country.io/names.json";  //api url

        ModelNames=new PhoneNumberDataHandler(siteNames);  //sets one of the datahandler objects the api url above
        var NamesList=ModelNames.getPhoneDataNames();  //creates variable, uses ModelNames to call method and create hashmap
        ObservableList<HashMap<String, String>> dataToShowNames=
                FXCollections.observableArrayList(NamesList);  //creates observable list with hashmap variable above
        listControlNames.setItems(dataToShowNames);  //sets items of one of the listviews
    }

    public void loadDataPhone(){
        var sitePhone="http://country.io/phone.json";  //same as above but for the second url

        ModelPhone=new PhoneNumberDataHandler(sitePhone);
        var PhoneList=ModelPhone.getPhoneDataPhone();
        ObservableList<HashMap<String,String>> dataToShowPhone=
                FXCollections.observableArrayList(PhoneList);
        listControlPhone.setItems(dataToShowPhone);
    }


    @FXML
    public void closeWindowPhoneNumber(ActionEvent event){  //method to close application, mapped to button
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {  //this is most likely wrong. had a hard time being able to setText below
        loadDataPhone();
        listControlPhone.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<HashMap<String, String>>() {
            @Override
            public void changed(ObservableValue<? extends HashMap<String, String>> observable, HashMap<String, String> oldValue, HashMap<String, String> newValue) {
                NameField.setText(String.valueOf(newValue));
                CodeField.setText(String.valueOf(newValue));
                PrefixField.setText(String.valueOf(newValue));
            }
        });
        loadDataNames();
        listControlNames.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<HashMap<String, String>>() {
            @Override
            public void changed(ObservableValue<? extends HashMap<String, String>> observable, HashMap<String, String> oldValue, HashMap<String, String> newValue) {
                NameField.setText(String.valueOf(newValue));
                CodeField.setText(String.valueOf(newValue));
                PrefixField.setText(String.valueOf(newValue));
            }
        });
    }
}
