public class Paths2 {
    City[] path;
    int sp;
    Integer maxDepth; // Maximum depth for the search

    public Paths2() {
        path = new City[54];
        sp = 0;
        maxDepth = null; // Initialize the maximum depth to null
    }

    public Integer shortest(City from, City to) {
        if (from == to) {
            return 0;
        }

        for (int i = 0; i < sp; i++) {
            if (path[i] == from) {
                return null; // City is already in the path, abort the search
            }
        }

        path[sp++] = from;

        Integer shortestDistance = Integer.MAX_VALUE;

        for (City.Connections c : from.neighbours) {
            if (maxDepth == null || c.distance + shortestDistance < maxDepth) {
                Integer temp = shortest(c.city, to);
                if (temp != null) {
                    int totalDistance = temp + c.distance;
                    if (totalDistance < shortestDistance) {
                        shortestDistance = totalDistance;
                        if (maxDepth == null || shortestDistance < maxDepth) {
                            maxDepth = shortestDistance;
                        }
                    }
                }
            }
        }

        path[--sp] = null;

        return shortestDistance != Integer.MAX_VALUE ? shortestDistance : null;
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
            "Goteborg Umea",
            "Malmo Kiruna"
        };
    
        for (String path : testPaths) {
            String[] cities = path.split(" ");
            String from = cities[0];
            String to = cities[1];
    
            long t0 = System.nanoTime();
    
            Paths paths = new Paths();
            Integer dist = paths.shortest(map.lookup(from), map.lookup(to));
            long time = (System.nanoTime() - t0) / 1_000_000;
    
            System.out.println(from + " - " + to + " min (" + time + " ms)");
        }
    }
}