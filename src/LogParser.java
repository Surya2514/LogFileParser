import java.io.*;
import java.util.Scanner;

public class LogParser {

    public static void main(String[] args) {

        try {

            PrintWriter errors = new PrintWriter("errors.txt");
            PrintWriter warnings = new PrintWriter("warnings.txt");
            PrintWriter currentLog = null;

            Scanner s = new Scanner(new File("C:\\Users\\91753\\IdeaProjects\\LogFileParser\\src\\log.txt"));
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.startsWith("error"))
                    currentLog = errors;
                else if (line.startsWith("warning"))
                    currentLog = warnings;
                else if (currentLog != null)
                    currentLog.println(line);
            }

            errors.close();
            warnings.close();
            s.close();
        } catch (IOException ioex) {
            // handle exception...
        }
    }
}