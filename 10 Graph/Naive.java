import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.sql.Connection;

public class Naive {
    public static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;



            Integer shortestDistance = Integer.MAX_VALUE;

            for (City.Connections c : from.neighbours) {
                // Kontrollera om avståndet är inom det tillåtna max-avståndet
                if (c.distance <= max) {
                    Integer temp = shortest(c.city, to, max - c.distance);
                    if (temp != null && temp + c.distance < shortestDistance) {
                        shortestDistance = temp + c.distance;
                    }
                }
            }
    
            return shortestDistance != Integer.MAX_VALUE ? shortestDistance : null;
        /*Integer shrt = Integer.MAX_VALUE;
        //Integer shrtVal = 69;
        //String kortastStad = "Ingen";

        // Kolla en stads alla connections,
        // Kolla denna connections alla connections
        for (City.Connections c : from.neighbours) {
            //System.out.println("Testar: " + c.city.name);

            //Shortest returnerar kortaste vägen
            Integer temp = shortest(c.city, to, max - c.distance);
            

            if (temp != null) {

                //Sätt kandidaten temp till den övre kortaste vägen
                //plus distansen till noden
                temp = temp + c.distance;

                //Om denna väg är den kortaste,
                // sätt den kortaste till denna väg
                if (temp < shrt) {
                    //kortastStad = c.city.name;
                    shrt = temp;
                }

            }
            //System.out.println("Kortaste hittad: " + kortastStad);
            //System.out.println("");
        }

        /*
         * gamla for (int i = 0; i < from.neighbours.size(); i++) {
         * if (from.neighbours[i] != null) {
         * Connection conn = from.neighbours[i];
         * }
         * }
         */

        //returnera den kortaste
        //return shrt;*/
    }

    public static void main(String[] args) {
        Map map = new Map("trains.csv");

        String[] testPaths = {
            "Malmo Goteborg",
            "Goteborg Stockholm",
            "Malmo Stockholm",
            "Stockholm Sundsvall",
            "Stockholm Umea",
            "Goteborg Sundsvall",
            "Sundsvall Umea",
            "Umea Goteborg",
            "Goteborg Umea"
        };
    
        for (String path : testPaths) {
            String[] cities = path.split(" ");
            String from = cities[0];
            String to = cities[1];
            
            int maxTime = 200;
            long t0;
            Integer dist;
            long time;

            while (true) {
                t0 = System.nanoTime();
                dist = shortest(map.lookup(from), map.lookup(to), maxTime);
                time = (System.nanoTime() - t0) / 1_000_000;

                if (dist != null) {
                    break;
                }

                maxTime += 200;
            }
    
            System.out.println(from + " - " + to + ": " + dist + " min (" + time + "ms) Maxtime:" + maxTime);
        }



    }
}