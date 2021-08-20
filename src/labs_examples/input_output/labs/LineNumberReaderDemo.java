package labs_examples.input_output.labs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {

    public static void main(String[] args) {
        LineNumberReader reader = null;

        try {
            reader = new LineNumberReader(new FileReader("src/labs_examples/input_output/files/char_data.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(reader.getLineNumber() + ": " + line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
