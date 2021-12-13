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
    public void openWindowPhoneNumber(ActionEvent event){  //method to open sams window with button, assigned to button
        var secondLoc=new FXMLLoader(PhoneNumberApplication.class.getResource("PhoneNumber-View.fxml"));  //loads fxml file into window
        Scene secondScene=null;
        try{
            secondScene=new Scene(secondLoc.load(),500,500); //creates scene variable with set height and width
        }
        catch (IOException e){
            System.out.println("Error loading Phone Number window");  //exception for if the window doesnt load
            e.printStackTrace();
        }
        Stage secondWindow=new Stage();  //creates new stage variable for second window
        secondWindow.setScene(secondScene);  //sets scene for the second scene variable declared above
        secondWindow.setTitle("PhoneNumber API  Sam");  //sets title for second window
        secondWindow.show();                            //shows second window
    }

    @FXML
    public void closeFirstWindow(ActionEvent event){
        System.exit(0);
    }  //closes the application with an exit button

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

}
