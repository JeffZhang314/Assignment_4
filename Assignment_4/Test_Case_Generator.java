import java.util.Random;
public class Test_Case_Generator {
    public static void main (String [] args) {
        Random rand = new Random();
        int numCs = 0;
        while (numCs <= 0) {
            numCs = 3 + (int) Math.round(3 * rand.nextGaussian());
        }
        int numRs = 0;
        while (numRs <= 0) {
            numRs = 3 + (int) Math.round(3 * rand.nextGaussian());
        }
        double [] [] ratings = new double [numRs] [numCs];
        System.out.println("{");
        for (int r = 0; r < numRs; r ++) {
            System.out.print("{");
            for (int c = 0; c < numCs; c ++) {
                ratings [r] [c] = rand.nextDouble() * 10;
                System.out.print(ratings [r] [c]);
                if (c < numCs - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("}");
            if (r < numRs - 1) {
                System.out.print(",");
            }
            System.out.println("");
        }
        System.out.println("}");
    }
}