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

// Java Import Statements:
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

// Public 'GDPDataHandler' Class:
public class GDPDataHandler {

    // Creating Private 'GDPDataReceiver' Object:
    private HttpClient GDPDataReceiver;

    // Creating Private 'webLocation' Object:
    private String webLocation;

    // 'GDPDataType' Class:
    class GDPDataType {

        // 'countryiso3code' String Variable that Represents the GDP Data's Country Value (In the Form of an ISO 3166-1 alpha-3 Code) and Is Used to Initialize the 'CountryName' TextField Variable:
        String countryiso3code;

        // Creating 'toString' Method:
        @Override
        public String toString() {

            // Returning the 'countryiso3code' Value as a String:
            return countryiso3code;

        }

        // 'value' Int Variable that Represents the GDP Data's GDP Value and Is Used to Initialize the 'GDPData' TextField Variable:
        int value;

        // Creating 'toInt' Method:
        @Override
        public int toInt() {

            // Returning the (GDP) 'value' as an Integer:
            return value;

        }

        // 'date' Int Variable that Represents the GDP Data's GDP Year Value and Is Used to Initialize the 'Year' TextField Variable:
        int date;

        // Creating 'toInt' Method:
        @Override
        public int toInt() {

            // Returning the 'date' Value as an Integer:
            return date;

        }

    }

    // Public 'GDPDataHandler' Class with 'webLocation' Parameter(s):
    public GDPDataHandler(String webLocation){

        // Creating 'dataGrabber' Object:
        GDPDataReceiver = HttpClient.newHttpClient();

        // Initializing This Web Location as the Web Location:
        this.webLocation = webLocation;
    }

    // Public 'getData' Method:
    public GDPDataType[] getData() {

        /** The Following Code in Under Construction and In Need of Comments and Rename: */
        var httpbuilder = HttpRequest.newBuilder();

        // Creates Request Object:
        var dataRequest = httpbuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;
        try{
            response = GDPDataReceiver.send(dataRequest, HttpResponse.BodyHandlers.ofString());
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