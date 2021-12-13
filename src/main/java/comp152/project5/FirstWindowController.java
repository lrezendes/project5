package comp152.project5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstWindowController {

    @FXML
    private Label welcomeText;

    @FXML
    public void openWindowPhoneNumber(ActionEvent event){
        var secondLoc=new FXMLLoader(PhoneNumberApplication.class.getResource("PhoneNumber-View.fxml"));
        Scene secondScene=null;
        try{
            secondScene=new Scene(secondLoc.load(),500,500);
        }
        catch (IOException e){
            System.out.println("Error loading Phone Number window");
            e.printStackTrace();
        }
        Stage secondWindow=new Stage();
        secondWindow.setScene(secondScene);
        secondWindow.setTitle("PhoneNumber API  Sam");
        secondWindow.show();
    }

    @FXML
    public void closeFirstWindow(ActionEvent event){
        System.exit(0);
    }

    @FXML
    public void openMakeupWindow(ActionEvent event){
        var makeupLoc = new FXMLLoader(MakeupApplication.class.getResource("Makeup-view.fxml"));
        Scene makeupScene = null;
        try {
            makeupScene = new Scene(makeupLoc.load(), 900, 600);
        } catch (IOException e) {
            System.out.println("Couldn't load makeup window");
            e.printStackTrace();
        }
        Stage makeupWindow = new Stage();
        makeupWindow.setScene(makeupScene);
        makeupWindow.setTitle("See - here is the makeup window");
        makeupWindow.show();
    }
    @FXML
    public void handleClose(ActionEvent event) {System.exit(0);}

}
