/* Maria Barczuk
 * Bridgewater State University
 * COMP 152-001: Computer Science II F21
 * Dr. John F. Santore
 * Fall 2021
 * Project 5
 * Currently Due on December 12th, 2021 @ 11:59 P.M.
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
    public void loadDataUSA() {

        // Creating 'siteUSA' to Represent the URL Containing GDP Data from the USA:
        var siteUSA = "http://api.worldbank.org/v2/countries/USA/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";

        // Creating 'paramsUSA' to Obtain Possible Query Parameters for 'siteUSA':
        var paramsUSA = getQueryParams();

        // Creating 'queryUSA' to Gather URL Query by Adding 'siteUSA' and 'paramsUSA':
        var queryUSA = siteUSA + paramsUSA;

        GDPModel = new GDPDataHandler(queryUSA);

        // Creating 'listDataUSA' to Use the 'GDPModel' to Obtain Data:
        var listDataUSA = GDPModel.getData();

        // Creating 'displayDataUSA' to Display 'listDataUSA' Value:
        ObservableList<GDPDataHandler.GDPDataType> displayDataUSA = FXCollections.observableArrayList(listDataUSA);

        // Using 'GDPListControl' to Add GDP Values (from GDPDataType) to 'displayDataUSA' Variable:
        GDPListControl.setItems(displayDataUSA);

    }

    // Public 'loadDataCHN' Method:
    public void loadDataCHN() {

        // Creating 'siteCHN' to Represent the URL Containing GDP Data from China:
        var siteCHN = "http://api.worldbank.org/v2/countries/CHN/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";

        // Creating 'paramsUSA' to Obtain Possible Query Parameters for 'siteUSA':
        var paramsCHN = getQueryParams();

        // Creating 'queryUSA' to Gather URL Query by Adding 'siteUSA' and 'paramsUSA':
        var queryCHN = siteCHN + paramsCHN;

        GDPModel = new GDPDataHandler(queryCHN);

        // Creating 'listDataCHN' to Use the 'GDPModel' to Obtain Data:
        var listDataCHN = GDPModel.getData();

        // Creating 'displayDataCHN' to Display 'listDataCHN' Value:
        ObservableList<GDPDataHandler.GDPDataType> displayDataCHN = FXCollections.observableArrayList(listDataCHN);

        // Using 'GDPListControl' to Add GDP Values (from GDPDataType) to 'displayDataCHN' Variable:
        GDPListControl.setItems(displayDataCHN);

    }

    // Public 'loadDataIND' Method:
    public void loadDataIND() {

        // Creating 'siteIND' to Represent the URL Containing GDP Data from India:
        var siteIND = "http://api.worldbank.org/v2/countries/IND/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";

        // Creating 'paramsUSA' to Obtain Possible Query Parameters for 'siteUSA':
        var paramsIND = getQueryParams();

        // Creating 'queryUSA' to Gather URL Query by Adding 'siteUSA' and 'paramsUSA':
        var queryIND = siteIND + paramsIND;

        GDPModel = new GDPDataHandler(queryIND);

        // Creating 'listDataIND' to Use the 'GDPModel' to Obtain Data:
        var listDataIND = GDPModel.getData();

        // Creating 'displayDataIND' to Display 'listDataIND' Value:
        ObservableList<GDPDataHandler.GDPDataType> displayDataIND = FXCollections.observableArrayList(listDataIND);

        // Using 'GDPListControl' to Add GDP Values (from GDPDataType) to 'displayDataIND' Variable:
        GDPListControl.setItems(displayDataIND);

    }

    // Private 'getQueryParams' Method:
    private String getQueryParams() {
        TextInputDialog yearInput = new TextInputDialog("Click Here to Select Year");
        yearInput.setHeaderText("Gathering Information...");
        yearInput.setContentText("Please Select Which Year to View GDP Data:");
        var name = yearInput.showAndWait();
        if (name.isPresent()) {
            return name.get();
        } else {
            return "";
        }
    }

    /** The Following Code in Under Construction and In Need of Comments and Rename: */
    @Override
    public void initializeGDPData(URL location, ResourceBundle resources) {
        loadDataUSA();
        // Add addListener with changeListener field
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

        // TODO: Create DataType class to "getData" from GDP site

        // TODO: Throw/catch possible exceptions and type print errors

    }