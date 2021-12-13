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

import java.net.http.HttpClient;

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