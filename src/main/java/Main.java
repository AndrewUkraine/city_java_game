
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static String inputFile = "/Users/andriishatov/Downloads/city_java_AndrewUkraine/src/main/resources/input.txt";
    private static String outputFile = "/Users/andriishatov/Downloads/city_java_AndrewUkraine/src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {

       List<String> availableCities = Files.lines(Paths.get(inputFile)).map(s -> s.toLowerCase()).collect(Collectors.toList());
       List<String> citiesList = Solver.solve(availableCities);
       new Writer().write(outputFile, citiesList);

    }
}
