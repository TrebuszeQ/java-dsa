import java.util.Scanner;
public class Cli {
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

    public static void SwitchLoop(String message, String[] options, Method2[] methods) {
        final int OPTLEN = options.length;
        if(OPTLEN == 0) return;
        int input = 0;
        do {
            System.out.println(message);
            for (String opt : options) {
                System.out.println(opt);
            }
            System.out.println();

            input = TakeInput();
            System.out.println("Provide integer number for option.");
            int c = 0;
            for(Method2 method : methods) {
                if(input == c) method.executeMethod();
                c++;
            }
        } while(input != options.length);

    }

    public static void delegateInput(int option, Method2[] methods) {


    }

    protected void clearTerminal() {
        System.out.flush();
    }
}
