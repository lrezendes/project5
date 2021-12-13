/* Maria Barczuk
 * Bridgewater State University
 * COMP 152-001: Computer Science II F21
 * Dr. John F. Santore
 * Fall 2021
 * Project 5
 * Due on December 12th, 2021 @ 11:59 P.M.
 */

// Java Package:
package comp152.project5;

// Java Import Statement(s):
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

// Public 'GDPController' Class that Implements Initializable:
public class GDPController implements Initializable {

    // Private 'Year' TextField Variable to Represent the GDP Data's 'date' Value:
    @FXML
    private TextField Year;

    // Private 'CountryName' TextField Variable to Represent the GDP Data's 'countryiso3code' Value:
    @FXML
    private TextField CountryName;

    // Private 'GDPData' TextField Variable to Represent the GDP Data's 'value':
    @FXML
    private TextField GDPData;

    // Private 'List Control' ListView Variable to Represent GDP Values (Such as 'year', 'countryiso3code', and 'value' Values):
    @FXML
    private ListView<GDPDataHandler.GDPDataType> GDPListControl;

    // Private 'GDPModel' Variable to Represent the 'GDPDataHandler' Class's Data:
    private GDPDataHandler GDPModel;

    // Public 'loadDataUSA' Method:
    /** This Method Will Gather Data From the GDP Site to Be Used for the USA TextField on the 'GDPView.fxml' File: */
    public void loadDataUSA() {

        // Creating 'siteUSA' to Represent the URL Containing GDP Data from the USA:
        var siteUSA = "http://api.worldbank.org/v2/countries/USA/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";

        // Creating 'paramsUSA' to Obtain Query Parameters from 'siteUSA':
        var paramsUSA = getYearQueryParams();

        // Creating 'queryUSA' to Gather URL Query by Adding 'siteUSA' and 'paramsUSA':
        var queryUSA = siteUSA + paramsUSA;

        // Creating New 'GDPDataHandler' Object Called 'GDPModel' Using 'queryUSA':
        GDPModel = new GDPDataHandler(queryUSA);

        // Creating 'listDataUSA' to Use the 'GDPModel' to Obtain Data:
        var listDataUSA = GDPModel.getData();

        // Creating 'displayDataUSA' to Display 'listDataUSA' Value:
        ObservableList<GDPDataHandler.GDPDataType> displayDataUSA = FXCollections.observableArrayList(listDataUSA);

        // Using 'GDPListControl' to Add GDP Values (from GDPDataType) to 'displayDataUSA' Variable:
        GDPListControl.setItems(displayDataUSA);

    }

    // Public 'loadDataCHN' Method:
    /** This Method Will Gather Data From the GDP Site to Be Used for the CHN TextField on the 'GDPView.fxml' File: */
    public void loadDataCHN() {

        // Creating 'siteCHN' to Represent the URL Containing GDP Data from China:
        var siteCHN = "http://api.worldbank.org/v2/countries/CHN/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";

        // Creating 'paramsCHN' to Obtain Query Parameters from 'siteCHN':
        var paramsCHN = getYearQueryParams();

        // Creating 'queryCHN' to Gather URL Query by Adding 'siteCHN' and 'paramsCHN':
        var queryCHN = siteCHN + paramsCHN;

        // Creating New 'GDPDataHandler' Object Called 'GDPModel' Using 'queryCHN':
        GDPModel = new GDPDataHandler(queryCHN);

        // Creating 'listDataCHN' to Use the 'GDPModel' to Obtain Data:
        var listDataCHN = GDPModel.getData();

        // Creating 'displayDataCHN' to Display 'listDataCHN' Value:
        ObservableList<GDPDataHandler.GDPDataType> displayDataCHN = FXCollections.observableArrayList(listDataCHN);

        // Using 'GDPListControl' to Add GDP Values (from GDPDataType) to 'displayDataCHN' Variable:
        GDPListControl.setItems(displayDataCHN);

    }

    // Public 'loadDataIND' Method:
    /** This Method Will Gather Data From the GDP Site to Be Used for the IND TextField on the 'GDPView.fxml' File: */
    public void loadDataIND() {

        // Creating 'siteIND' to Represent the URL Containing GDP Data from India:
        var siteIND = "http://api.worldbank.org/v2/countries/IND/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";

        // Creating 'paramsIND' to Obtain Query Parameters from 'siteIND':
        var paramsIND = getYearQueryParams();

        // Creating 'queryIND' to Gather URL Query by Adding 'siteIND' and 'paramsIND':
        var queryIND = siteIND + paramsIND;

        // Creating New 'GDPDataHandler' Object Called 'GDPModel' Using 'queryIND':
        GDPModel = new GDPDataHandler(queryIND);

        // Creating 'listDataIND' to Use the 'GDPModel' to Obtain Data:
        var listDataIND = GDPModel.getData();

        // Creating 'displayDataIND' to Display 'listDataIND' Value:
        ObservableList<GDPDataHandler.GDPDataType> displayDataIND = FXCollections.observableArrayList(listDataIND);

        // Using 'GDPListControl' to Add GDP Values (from GDPDataType) to 'displayDataIND' Variable:
        GDPListControl.setItems(displayDataIND);

    }

    // Private 'getYearQueryParams' Method:
    /** This Method Includes Data That Will Be Displayed in the Year ScrollPane on the 'GDPView.fxml' File: */
    private String getYearQueryParams() {

        // Printing Default 'Click Here to Select Year' Message:
        TextInputDialog yearInput = new TextInputDialog("Click Here to Select Year");

        // TODO: Continue Commenting Code for 'getYearQueryParams' Method

        yearInput.setHeaderText("Gathering Information...");
        yearInput.setContentText("Please Select Which Year to View GDP Data:");
        var name = yearInput.showAndWait();
        if (name.isPresent()) {
            return name.get();
        }
        else {
            return "";
        }
    }

    // Public 'initializeDataUSA' Method:
    /** This Method Includes Data That Will Be Displayed in the USA TextField on the 'GDPView.fxml' File: */
    @Override
    public void initializeDataUSA(URL location, ResourceBundle resources) {

        // Calling 'loadDataUSA' Method to Load USA Data:
        loadDataUSA();

        GDPListControl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<GDPDataHandler.GDPDataType>() {
            @Override
            public void changed(ObservableValue<? extends GDPDataHandler.GDPDataType> observable, GDPDataHandler.GDPDataType oldValue, GDPDataHandler.GDPDataType newValue) {

                // Initializing 'date' GDP Value to 'Year' NameField Variable:
                Year.setText(newValue.date);

                // Initializing 'countryiso3code' Value to 'CountryName' TextField Variable:
                CountryName.setText(newValue.countryiso3code);

                // Initializing 'value' to 'GDPData' TextField Variable:
                GDPData.setText(newValue.value);

            }
        });

    }

    // Public 'initializeDataCHN' Method:
    /** This Method Includes Data That Will Be Displayed in the CHN TextField on the 'GDPView.fxml' File: */
    @Override
    public void initializeDataCHN(URL location, ResourceBundle resources) {

        // Calling 'loadDataCHN' Method to Load CHN Data:
        loadDataCHN();

        GDPListControl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<GDPDataHandler.GDPDataType>() {
            @Override
            public void changed(ObservableValue<? extends GDPDataHandler.GDPDataType> observable, GDPDataHandler.GDPDataType oldValue, GDPDataHandler.GDPDataType newValue) {

                // Initializing 'date' GDP Value to 'Year' NameField Variable:
                Year.setText(newValue.date);

                // Initializing 'countryiso3code' Value to 'CountryName' TextField Variable:
                CountryName.setText(newValue.countryiso3code);

                // Initializing 'value' to 'GDPData' TextField Variable:
                GDPData.setText(newValue.value);

            }
        });

    }

    // Public 'initializeDataIND' Method:
    /** This Method Includes Data That Will Be Displayed in the IND TextField on the 'GDPView.fxml' File: */
    @Override
    public void initializeDataIND(URL location, ResourceBundle resources) {

        // Calling 'loadDataIND' Method to Load IND Data:
        loadDataIND();

        GDPListControl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<GDPDataHandler.GDPDataType>() {
            @Override
            public void changed(ObservableValue<? extends GDPDataHandler.GDPDataType> observable, GDPDataHandler.GDPDataType oldValue, GDPDataHandler.GDPDataType newValue) {

                // Initializing 'date' GDP Value to 'Year' NameField Variable:
                Year.setText(newValue.date);

                // Initializing 'countryiso3code' Value to 'CountryName' TextField Variable:
                CountryName.setText(newValue.countryiso3code);

                // Initializing 'value' to 'GDPData' TextField Variable:
                GDPData.setText(newValue.value);

            }
        });

    }
}