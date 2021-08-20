package labs_examples.input_output.labs;

import java.io.*;

public class BufferedIO {

    public static void main(String[] args) {

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("src/labs_examples/input_output/files/char_data.txt"));

            char[] chars = new char[11];

            reader.read(chars);

            System.out.println(chars);

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new PrintWriter(System.out));

            char[] chars = {'S', 'a', 'd', 'a', 't', ' ', 'w', 'a', 's', ' ', 'h', 'e', 'r', 'e', '!'};

            for (char c : chars) {
                writer.write(c);
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
