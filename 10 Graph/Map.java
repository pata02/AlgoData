import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {
    
    public ArrayList<City>[] bucket;
    private final int mod = 541;

    public Map(String file) {
        // Skapar 541 st, arraylists
        bucket = new ArrayList[mod];
        for (int i = 0; i < mod; i++) {
            bucket[i] = new ArrayList<City>();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                // System.out.println("Added");
                String[] row = line.split(",");

                // Hashar och skapar en ny stad
                String newCityName = row[0].replaceAll("\\s", "");
                String new2CityName = row[1].replaceAll("\\s", "");
                int hashedString = hash(row[0].replaceAll("\\s", ""));
                int hashed2String = hash(row[1].replaceAll("\\s", ""));

                City city1 = cityExists(newCityName, hashedString);
                City city2 = cityExists(new2CityName, hashed2String);

                Integer distance = Integer.valueOf(row[2]);

                // Skapa så att båda städerna finns
                if (city1 == null) {
                    city1 = new City(newCityName);
                    bucket[hashedString].add(city1);
                }

                if (city2 == null) {
                    city2 = new City(new2CityName);
                    bucket[hashed2String].add(city2);
                }

                // Anslut åt båda hållern
                city1.connect(city2, distance);
                city2.connect(city1, distance);

            }
        } catch (IOException e) {
            System.out.println("File " + file + " not found or corrupt");
        }

    }

    public City cityExists(String name, int hashVal) {

        // Om staden finns i hinken, returnera staden
        for (City c : bucket[hashVal]) {
            if (c.name.equals(name)) {
                return c;
            }
        }

        // Stadens namn finns inte, return null
        return null;
    }

    // Kollar om staden finns, annars skapar och lägger till en
    public City lookup(String cityName) {
        int hashVal = hash(cityName);

        for (City c : bucket[hashVal]) {
            if (c.name.equals(cityName)) {
                return c;
            }
        }

        // Skapa ny och lägg till
        bucket[hashVal].add(new City(cityName));
        return null;
    }

    public Integer hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }

        return hash % mod;
    }

    public void collisions() {
        int total = 0;
        int total1 = 0;
        int total2 = 0;


        for (int i = 0; i < mod; i++) {
            total += bucket[i].size();

            if (bucket[i].size() == 1) {
                total1++;
            }

            if (bucket[i].size() == 2) {
                total2++;
            }
        }
        System.out.println("Total:" + total);
        System.out.println("Total 1s:" + total1);
        System.out.println("Total 2s:" + total2);
    }

}
