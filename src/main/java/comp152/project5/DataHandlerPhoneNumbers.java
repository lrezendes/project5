package comp152.project5;

import java.net.http.HttpClient;

public class DataHandlerPhoneNumbers {
    private HttpClient dataGrabber;
    private String webLocation;

    public DataHandlerPhoneNumbers(String webLocation){
        dataGrabber=HttpClient.newHttpClient();
        this.webLocation=webLocation;
    }
    
}

