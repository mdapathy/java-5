import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        final short[][] arrB = {{32, 1, 12, 5, 2}, {3, 5, 6, 3, 8}};

        final int a = 3;  //2147483647

        long[][] arrC; // C = a*B

        long maxSum = 0;
        long minSum = 0;

        if (!valid(arrB)) {

            System.out.print("Your two-dimensional "
                    + "array cannot be treated as a matrix! ");
            return;
        }

       arrC = new long[arrB.length][arrB[0].length];

        for (int i = 0; i < arrB.length; i++) {

            for (int j = 0; j < arrB[0].length; j++) {

                arrC[i][j] = (long) a * arrB[i][j];
            }
        }


        //Обчислити суму найбільших елементів в стовпцях матриці
        // з парними номерами та найменших
        // елементів в стовпцях матриці з непарними номерами

        //Calculating sum of max values

        for (int j = 0; j < arrC[0].length; j += 2) {

            long max = arrC[0][j];

            for (int i = 1; i < arrC.length; i++) {

                if (arrC[i][j] > max) {

                   max = arrC[i][j];

                }

            }

            maxSum +=  max;
        }

        //Calculating sum of min values


        for (int  j = 1; j < arrC[0].length; j += 2) {

            long min = arrC[0][j];

            for (int i = 0; i < arrC.length; i++) {

                if (arrC[i][j] < min) {

                    min = arrC[i][j];

                }

            }

            minSum +=  min;
        }



       //Simultaneous comparison of both
/*
     for (int j = 0; j < arrC[0].length; j++) {

            long compareto = arrC[0][j];

            for (int i = 0; i < arrC.length; i++) {
                if (((j % 2 == 0) && arrC[i][j] > compareto)
                        || ((j % 2 == 1) && arrC[i][j] < compareto)) {

                    compareto = arrC[i][j];

                }

            }

            if (j % 2 == 0) {
                maxSum += compareto;

            } else {

                minSum += compareto;
            }

        }*/


        System.out.println("Resulting matrix: ");

        printMatrix(arrC); //alternatively
        // System.out.println(Arrays.deepToString(C));

        System.out.println("Sum of max values: " + maxSum);
        System.out.println("Sum of min values: " + minSum);


    }


    private static boolean valid(final short[][] matrix) {

        if (matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int compSize = matrix[0].length;

         for (int i = 1; i < matrix.length; i++) {

            if (compSize != matrix[i].length) {
                return false;
            }
         }

            return true;

    }

    private static void printMatrix(final long[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            String line = "";

            for (int j = 0; j < matrix[0].length; j++) {
                line += matrix[i][j] + " ";
            }

            System.out.println(line);

        }
    }
}
