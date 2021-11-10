import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int[] x = {1, 2,3};
        int[] y = {0, 11};
        
        System.out.println(y[0]);
        y = x;
        x = new int[3];
        System.out.println(x[2]);
    }

    public static void printDefaultMap(int size, int seed) {
        Random random = new Random(seed);
        Boolean[][] map = new Boolean[size][size];

        for (Boolean[] row : map) {
            for (Boolean cell : row) {
                cell = random.nextBoolean();
                char cellVal = cell ? 'O':' ';
                System.out.print(cellVal);
            }
            System.out.println();
        }

    }
}      

