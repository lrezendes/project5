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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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

}