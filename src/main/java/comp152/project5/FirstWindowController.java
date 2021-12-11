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
            System.out.println("Error loading second window");
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

}
