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

// Java Import Statements:
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Public 'GDPApplication' Class:
public class GDPApplication extends Application {

    // TODO: Figure out where to create window with three textfields and a dropdown window displaying selectable year values.

    // Public 'start' Method with 'stage' Parameter(s):
    @Override
    public void start(Stage stage) {

    // Initializing 'GDPView.fxml' to 'GDPViewWindow' Variable:
    FXMLLoader GDPViewWindow = new FXMLLoader(GDPApplication.class.getResource("GDPView.fxml"));

    // Creating 'scene' Object:
    Scene scene = null;

    // Initializing a Try and Catch Loop:
    try {

        // Using 'scene' Object to Set Display Window Dimensions:
        scene = new Scene(GDPViewWindow.load(), 700, 700);

    }
    catch(IOException sceneIOException) {

        // Printing "Error Loading FXML File" Message:
        System.out.println("There Was an Error Loading the FXML File.");

    }

    // Continue Code Here.

    }
}