public class Exercises1 {
    public static void main(String[] args) {
        String message = "Exercises from the first chapter, Polish edition.";
        String[] options = {
                "0. Clear terminal.",
                "1. Exercise 1.1.3",
                "2. Exercise 1.1.13",
                "3. Exercise histogram",
                "4. Go back.",
        };

        // temporary hard coded
        int x = 0;
        int y = 5;


        Method2[] methods = new Method2[] {
                Exercises1::ex113,
                () -> ex1113(x, y),

        };

        Cli.SwitchLoop(message, options, methods);
    }

    static void execute2(Method2 function) {
        function.executeMethod();
    }

    public static void ex113() {
        System.out.println("Exercise 1.1.3, page 66.");
        System.out.println("Write a program that takes three integer arguments from the command line and displays the word equal if the values are the same and unequal otherwise.\n");
        int[] nums = new int[3];
        for (int i = 0; i < 3; ) {
            boolean truth = true;
            System.out.println("Enter 3 integer values.");
            String input = System.console().readLine();
            int inputInt = 0;
            try {
                inputInt = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                truth = false;
            }
            if (truth) {
                if (i > 0 && nums[0] != inputInt) {
                    System.out.println("Not equal.");
                    return;
                }
                i++;
                nums[i] = inputInt;
            } else System.out.println("Wrong input.");
            System.out.println("Equal.");
        }
    }

    public static void ex1113(int row, int col) {
        System.out.println("Exercise 1.1.13, page 68");
        System.out.println("Write a code fragment to print the transposition (rows and columns changed) of a two-dimensional array with M rows and N columns.");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static int[] histogram(int[] a, int M) {
        System.out.println("Exercise 1.1.15, page 68.");
        System.out.println("Write a static method histogram() that takes an array a[] of int values and an integer M as arguments and returns an array of length M whose ith entry is the num ber of times the integer i appeared in the argument array. If the values in a[] are all between 0 and M–1, the sum of the values in the returned array should be equal to a.length.");
        int[] wtf = new int[M];
        for (int i = 0; i < wtf.length; i++) {
            int sum = 0;
            for(int j = 0; j < a.length; j++) {
                if (a[i] == j) sum++;
            }
            wtf[i] = sum;
        }
        return wtf;
    }
}