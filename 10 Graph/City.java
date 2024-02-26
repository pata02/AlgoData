import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.ArrayList;

//En stad har ett namn och neighbours
public class City {
    public String name;
    public ArrayList<Connections> neighbours;

    //Connectios håller en stad och en tid
    public class Connections {
        public City city;
        public Integer distance;

        public Connections(City city, Integer distance) {
            this.city = city;
            this.distance = distance;
        }

    }

    public City(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

    //Lägger till en stad till denna stads granne
    public void connect(City nxt, int dst) {
        neighbours.add(new Connections(nxt, dst));
        //System.out.println("Added " + nxt.name);
    }

    public void printAllN() {
        System.out.println("Printing all connections");
        for (Connections con : neighbours) {
            System.out.println(con.city.name);
        }
    }

}