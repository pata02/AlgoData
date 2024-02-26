import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class Zip6 {
    Node [] data;
    int max;
    int m = 14000;

    public class Node {
        Integer code;
        String name;
        Integer pop;

        public Node(Integer code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public Zip6(String file) {
        
        data = new Node[300000];
        

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                Node entry = new Node(code, row[1], Integer.valueOf(row[2]));

                int index = code % m;
                while(true){
                if(data[index]==null){
                data[index] = entry;
                break;
                }
                index++;
               }
                max = code;
            }
        } catch (Exception e) {
            System.out.println("File " + file + " not found");
        }
    }

    public Node lookup(String Zip6) {
        Integer code = Integer.valueOf(Zip6.replaceAll("\\s", ""));
        int index = code % m;

        int probeCount = 0;
        
        while(true){
        Node compare = data[index];
        probeCount++;
        if(compare.code.equals(code)){
        System.out.println("Probes: " + probeCount);
        return compare;
        }
        index++;
        if(index==data.length){
        System.out.println("Probes: " + probeCount);
        return null;

        }

        }

        
    }

    public static void main(String[] args) {
        Zip6 Zip6Table = new Zip6("postnummer.csv");

        Node result1 = Zip6Table.lookup("111 15");
        Node result2 = Zip6Table.lookup("984 99");

        if (result1 != null) {
            System.out.println("Result 1: " + result1.code + ", " + result1.name + ", " + result1.pop);
        } else {
            System.out.println("Zip6 code '111 15' not found.");
        }

        if (result2 != null) {
            System.out.println("Result 2: " + result2.code + ", " + result2.name + ", " + result2.pop);
        } else {
            System.out.println("Zip6 code '984 99' not found.");
        }
    }
}
