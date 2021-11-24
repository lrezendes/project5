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
import javafx.scene.control.TextField;

// 'GDPController' Class:
public class GDPController {

    // 'Year' Variable to Represent the GDP Data's Year:
    @FXML
    private TextField Year;

    // 'CountryName' Variable to Represent the GDP Data's Country:
    @FXML
    private TextField CountryName;

    // 'GDPData' Variable to Represent the GDP Data (This Value May Be Updated/Edited by the User):
    @FXML
    private TextField GDPData;

}