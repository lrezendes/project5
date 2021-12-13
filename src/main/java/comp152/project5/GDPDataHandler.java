/* Maria Barczuk
 * Bridgewater State University
 * COMP 152-001: Computer Science II F21
 * Dr. John F. Santore
 * Fall 2021
 * Project 5
 * Due on December 12th, 2021 @ 11:59 P.M.
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

        // TODO: Continue Commenting Code for 'getData' Method

        var httpbuilder = HttpRequest.newBuilder();
        var dataRequest = httpbuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;

        // Initializing a Try Loop:
        try{
            response = GDPDataReceiver.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }

        // Catching IOException (If Found):
        catch (IOException getDataIOException){

            // Printing "Network Error" Message:
            System.out.println("Network Error.");

        }

        // Catching IOException (If Found):
        catch (InterruptedException getDataInterruptedException){

            // Printing "Data Transferring Error" Message:
            System.out.println("Data Transferring Error.");

        }

        // Initializing If Loop:
        if(response == null){

            // Printing "Exiting" Message
            System.out.println("Now Exiting the Program.");

            // If The Status Equals a Negative Number, Then An Error Code Appeared and the Program Will Be Exited:
            System.exit(-1);

        }

        // Creating 'responseBody' Variable to Represent the 'response':
        var responseBody = response.body();

        // Creating New Gson Object Known as 'jsonInterpreter':
        var jsonInterpreter = new Gson();

        var GDPData = jsonInterpreter.fromJson(responseBody,GDPDataType[].class);
        return GDPData;
    }

}