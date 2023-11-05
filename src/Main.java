// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {

    public static void main(String[] args) {
        System.out.println("This app has been created through the progress of Uni course and books about Data Structures and Algorithms and has no purpose itself.\n");
        System.out.println("Opcje:");

        String[] options = {
                "0. Clear terminal.",
                "1. Sortings",
                "9. Exit."
        };

        String input = "";
        Integer result = 0;
        do
        {
            for (int i = 0; i < options.length; i++)
            {
                System.out.println(options[i]);
            }
            System.out.println();
            System.out.println("Provide option number.\n");

            input = System.console().readLine();

            switch(input) {
                case "0":
                    System.out.flush();
                    break;
                case "1":
                    break;

                case "9":
                    return;
                default:
                    System.out.println("Wrong input.");
                    break;
            }

        } while (input != "9");
    }
}