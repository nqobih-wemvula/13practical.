import java.lang.Math.*;   import java.io.*;   import java.text.*;
import java.util.Arrays;
import java.util.Random;

public class timeMethods {
        public static int N = 30;

        public static void main(String[] args) {

            DecimalFormat twoD = new DecimalFormat("0.00");
            DecimalFormat fourD = new DecimalFormat("0.0000");
            DecimalFormat fiveD = new DecimalFormat("0.00000");
            int n = N;
            int[] arr = new int[N];
            Random rand = new Random();
            for(int i=0 ; i < arr.length ; i++){
                arr[i]= rand.nextInt(32654) + 1;
            }

            long start, finish;
            double  time;
            //double totalTime = 0.0;

            int repetitions = 30;
// linear Search
           double runTimelinear = 0, runTime2linear = 0;
            for (int repetition = 0; repetition < repetitions; repetition++) {
                start = System.currentTimeMillis();

                int result = linearSearch(arr, 14);

                finish = System.currentTimeMillis();

                time = (double) (finish - start);
                runTimelinear += time;
                runTime2linear += (time * time);
            }

            double avelinear = runTimelinear / repetitions;
            double stdDevlinear = Math.sqrt(runTime2linear - repetitions * avelinear * avelinear) / (repetitions - 1);
// binary search
            Arrays.sort(arr);
            double runTimeBinary = 0, runTime2Binary = 0;
            for(int rep = 0; rep <repetitions; rep ++){
                start = System.currentTimeMillis();
                int result = binarySearch(arr, 14 , 0, arr.length-1);
                finish = System.currentTimeMillis();

                time = (double)(finish-start);
                runTimeBinary += time;
                runTime2Binary += (time * time);
            }
            double aveBinary  = runTimeBinary/repetitions;
            double stdDevBinary = Math.sqrt(runTime2Binary - repetitions * aveBinary * aveBinary)/(repetitions-1);
            System.out.printf("\n\n\fStatistics\n");
            System.out.println("________________________________________________");
            System.out.println("Linear Search");
            System.out.println("Total time   =           " + runTimelinear / 1000 + "s.");
            System.out.println("Total time\u00b2  =           " + runTime2linear);
            System.out.println("Average time =           " + fiveD.format(avelinear / 1000)
                    + "s. " + '\u00B1' + " " + fourD.format(stdDevlinear) + "ms.");
            System.out.println("Standard deviation =     " + fourD.format(stdDevlinear));
            System.out.println("n            =           " + n);
            System.out.println("Average time / run =     " + fiveD.format(avelinear / n * 1000)
                    + '\u00B5' + "s. ");

            System.out.println("Repetitions  =             " + repetitions);
            System.out.println("________________________________________________");
            System.out.println();
            System.out.println();
            System.out.println("________________________________________________");
            System.out.println("Binary Search");
            System.out.println("Total time   =           " + runTimeBinary / 1000 + "s.");
            System.out.println("Total time\u00b2  =           " + runTime2Binary);
            System.out.println("Average time =           " + fiveD.format(aveBinary / 1000)
                    + "s. " + '\u00B1' + " " + fourD.format(stdDevBinary) + "ms.");
            System.out.println("Standard deviation =     " + fourD.format(stdDevBinary));
            System.out.println("n            =           " + n);
            System.out.println("Average time / run =     " + fiveD.format(aveBinary / n * 1000)
                    + '\u00B5' + "s. ");

            System.out.println("Repetitions  =             " + repetitions);
            System.out.println("________________________________________________");
        }

        static int linearSearch(int[] arr, int n) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == n) {
                    return i;
                }
            }
            return -1;
        }
    static int binarySearch(int[] arr, int key, int low, int high) {
        if (high >= low) {
            int midP = low + (high - low) / 2;
            int midno = arr[midP];
            if (key == midno) {
                return midP;
            }
            if (key < midno){
                return binarySearch(arr, key, low, midP-1);
            }
            else{
                return binarySearch(arr, key, midP + 1, high);
            }
        }
        return -1;
    }
    }
