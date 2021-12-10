package comp152.project5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstWindowApplication extends Application {
    @Override
    public void start(Stage stage)throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(FirstWindowApplication.class.getResource())
    }
}
