// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.HashMap;

public class Main implements Options {


    public static void main(String[] args) {
        String message = "Aplikacja została stworzona dla potrzeby nauki algorytmów i struktur danych.\n\nOpcje\n";
        String[] options = {
                "Cwiczenia z rozdzialu pierwszego",
        };

        Method2[] methods = {
                () -> Exercises1.main(null),
                () -> System.exit(0),
        };

        Cli.optionsLoop(message, options, methods);
    }

    @Override
    public HashMap<String, Method2> mapSetter() {
        HashMap<String, Method2> lol = new HashMap<>();
        lol.put("Cwiczenia z rozdzialu pierwszego", () -> Exercises1.main(null));
        return lol;
    }
}
