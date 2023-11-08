import java.util.Scanner;

public interface Cli {

    private static Method2[] methodsSetter(Method2[] methods) {

        Method2[] arr = new Method2[methods.length + 2];
        arr[0] = Cli::clearTerminal;
        for(int i = 1; i < arr.length - 2; i++) {
            arr[i] = methods[i-1];
        };
        arr[arr.length - 1] = Cli::exit;
        return arr;
    }

    private static String[] optionsSetter(String[] options) {
        String[] arr = new String[options.length + 2];
        arr[0] = "0. Wyczyść terminal.";
        for(int i = 1; i < arr.length - 1; i++) {
            arr[i] = i + ". " + options[i-1] + ".";
        };
        arr[arr.length - 1] = (arr.length - 1) + ". Wyjdź z programu.";
        return arr;
    }

    private static int TakeInput() {
        int input = -1;
        Scanner in = new Scanner(System.in);
        try {
            input = in.nextInt();
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return input;
    }

    static void optionsLoop(String message, String[] optionsIn, Method2[] methodsIn) {
        String[] options = optionsSetter(optionsIn);
        Method2[] methods = methodsSetter(methodsIn);

        int input = 0;
        do {
            System.out.println(message);
            for (String opt : options) {
                System.out.println(opt);
            }
            System.out.println();



            for(int i = 0; i < methods.length - 1; i++) {
                System.out.println("Podaj liczbę odpowiadającą opcji.");
                input = TakeInput();
                methods[i].executeMethod();
            }
        } while (input != (options.length - 1));
    }

    static int[] collectIntegerArray() {
        System.out.println("Podaj długość tabeli.");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        Integer length = null;

        length = Math.abs(input);

        int[] arr = new int[length];

        for(int i = 0; i < (length - 1); i++) {
            System.out.println("Podaj liczbę całkowitą.");
            arr[i] = input;
        }

        return arr;
    }

    static void delegateInput(int input) {
        String[] opts = new String[10];
        Method2[] meths = new Method2[10];

    }

    static void clearTerminal() {
        System.out.flush();
    }

    static void exit() {
        System.out.println("Exiting.");
        System.exit(0);
    }
}
