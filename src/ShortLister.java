import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ShortLister {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";

        ArrayList<String> list = new ArrayList<>();

        try
        {

            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));


                while (reader.ready())
                {
                    rec = reader.readLine();

                    String[] record = rec.split(", ");

                    String word = record[0];

                    list.add(word);

                }

                reader.close();

                System.out.println("\nShort Words from File:\n");

                ArrayList<String> filteredList = collectAll(list);

                for (String word: filteredList) {
                    System.out.println(word);
                }

            }

            else {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    public static ArrayList<String> collectAll(ArrayList<String> list) {

        ShortWordFilter filter = new ShortWordFilter();

        ArrayList<String> filteredList = new ArrayList<>();

        for (String word: list) {
            if (filter.accept(word)) {
                filteredList.add(word);
            }
        }

        return filteredList;
    }

}