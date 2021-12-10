package comp152.project5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MakeupController implements Initializable {
    @FXML
    private TextField brandField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField ProductTypeField;

    @FXML
    private TextField PriceField;

    @FXML
    private TextField websiteDisplayField;
    @FXML
    private ListView<MakeupHandler.MakeupDataType> ListControl;
    private MakeupHandler Model;

    public void loadData() {
        var site = "http://makeup-api.herokuapp.com/api/v1/products.json";
        var params = getQueryParams();
        var query = site + params;
        Model = new MakeupHandler(query);
        var makeupList = Model.getData();
        ObservableList<MakeupHandler.MakeupDataType> dataToShow =
                FXCollections.observableArrayList(makeupList);
        ListControl.setItems(dataToShow);
    }

    private String getQueryParams() {
        TextInputDialog inputGrabber = new TextInputDialog("ColourPop");
        inputGrabber.setHeaderText("Gathering Information for query");
        inputGrabber.setContentText("What makeup product would you like to search for:");
        var name = inputGrabber.showAndWait();
        if (name.isPresent()) {
            return name.get();
        } else {
            return "";
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
        ListControl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MakeupHandler.MakeupDataType>() {
            @Override
            public void changed(ObservableValue<? extends MakeupHandler.MakeupDataType> observable, MakeupHandler.MakeupDataType oldValue, MakeupHandler.MakeupDataType newValue) {
                brandField.setText(newValue.brand);
                nameField.setText(newValue.name);
                ProductTypeField.setText(newValue.productType);
                PriceField.setText(newValue.price);
                websiteDisplayField.setText(newValue.web_pages.toString());
            }
        });
    }
}
