/* Maria Barczuk
 * Bridgewater State University
 * COMP 152-001: Computer Science II F21
 * Dr. John F. Santore
 * Fall 2021
 * Project 5
 * Currently Due on December 12th, 2021 @ 11:59 P.M.
 */

// Java Package:
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

// Public 'GDPDataHandler' Class:
public class GDPDataHandler {

    // Check following:
    private HttpClient dataGrabber;
    private String webLocation;

    class GDPDataType {

        // 'countryiso3code' that
        String countryiso3code;

        @Override
        public String toString() {
            return countryiso3code;
        }

        int value;

        @Override
        public int toInt() {
            return value;
        }

        int date;

        @Override
        public int toInt() {
            return date;
        }
    }

    public GDPDataHandler(String webLocation){
        dataGrabber = HttpClient.newHttpClient();
        // This web location is the location we're passing in:
        this.webLocation = webLocation;
    }

    public GDPDataType[] getData() {
        var httpbuilder = HttpRequest.newBuilder();

        // Creates Request Object:
        var dataRequest = httpbuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;
        try{
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException exception){
            System.out.println("Error with the network");
        }
        catch (InterruptedException e){
            System.out.println("Error completing data transfer");
        }
        if(response == null){
            System.out.println("Something went very wrong, quitting program");
            // Negative number represents error code:
            System.exit(-1);
        }
        var responseBody = response.body();
        // creating new gson object:
        var jsonInterpreter = new Gson();
        var GDPData = jsonInterpreter.fromJson(responseBody,GDPDataType[].class);
        return GDPData;
    }

}