package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class House {
    private static int blocksForFloorAndWall = 2;
    private static int blocksForWindow = 2;
    private static String symbolForFloorAndWall = "0";
    private static String symbolForWindow = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter how many floors do you need: ");
        int floors = Integer.parseInt(buffer.readLine());
        System.out.println("How many windows?: ");
        int windows = Integer.parseInt(buffer.readLine());
        long timeStart = System.currentTimeMillis();
        new House().buildHouse(floors, windows);
        long timeFinish = System.currentTimeMillis();
        System.out.println("\n\nTime: " + (timeFinish - timeStart) + " ms.");
    }

    private void buildHouse(int floors, int windows) {
        int blocks = blocksForFloorAndWall + blocksForWindow;
        int horizontalBlocks = floors * blocks + blocksForFloorAndWall;
        int verticalBlocks = windows * blocks + blocksForFloorAndWall;

        System.out.println();
        System.out.println("Window: " + blocksForWindow + " x " + blocksForWindow + " symbols");
        System.out.println("Symbol for windows: \"" + symbolForWindow + "\"\n");
        System.out.println("Floor and wall: " + blocksForFloorAndWall + " symbols");
        System.out.println("Symbol for floor and walls: \"" + symbolForFloorAndWall + "\"\n");
        System.out.println(horizontalBlocks + " x " + verticalBlocks);

        for (int i = 0; i < horizontalBlocks; i++) {
            int modForHorizontal = i % blocks;
            if (modForHorizontal < blocksForFloorAndWall) {
                System.out.println();
                for (int j = 0; j < verticalBlocks; j++) {
                    System.out.print(symbolForFloorAndWall);
                }
            }
            else {
                System.out.println();
                String str= "";
                for (int j = 0; j < verticalBlocks; j++) {
                    int modForVertical = j % blocks;
                    if (modForVertical < blocksForFloorAndWall) {
                        str += symbolForFloorAndWall;
                    }
                    else {
                        str += symbolForWindow;
                    }
                    if (j > verticalBlocks - 1) str += symbolForFloorAndWall;
                }
                System.out.print(str);
            }
            if (modForHorizontal == blocksForFloorAndWall) {
                System.out.print("\t\t" + (floors - i / blocks) + " floor");
            }
        }
        //System.out.println("\n==========\n");
    }
}
