package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<Integer, Location> locations = new HashMap<>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You're sitting in front of your PC :D"));
        locations.put(1, new Location(1, "You're at the main road"));
        locations.put(2, new Location(2, "You're at the top of the hill"));
        locations.put(3, new Location(3, "You're at the small building around the corner"));
        locations.put(4, new Location(4, "You're in the valley "));
        locations.put(5, new Location(5, "You're in the deep forest"));

        locations.get(1).addExits("W", 2);
        locations.get(1).addExits("E", 3);
        locations.get(1).addExits("S", 4);
        locations.get(1).addExits("N", 5);

        locations.get(2).addExits("N", 5);

        locations.get(3).addExits("W", 1);

        locations.get(4).addExits("N", 1);
        locations.get(4).addExits("W", 2);

        locations.get(5).addExits("W", 2);
        locations.get(5).addExits("S", 1);


        Map<String,String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("WEST","W");
        vocabulary.put("EAST","E");


        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String,Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are : ");


            for(String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            System.out.println("Enter your option : ");

            String direction = scanner.nextLine().toUpperCase();

            if(direction.length() > 1) {
                String [] words = direction.split(" ");
                for(String word : words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }else {
                System.out.println("You cannot go in that direction");
            }
        }


    }
}
