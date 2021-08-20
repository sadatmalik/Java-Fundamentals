package labs_examples.input_output.labs;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayRWDemo {

    public static void main(String[] args) {
        CharArrayReader reader = null;
        char[] chars = new char[] {'S', 'a', 'd', 'a', 't'};

        // note doesn't throw any exceptions
        reader = new CharArrayReader(chars);

        int c;

        System.out.println("Reading from character array");
        try {
            while ((c = reader.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        CharArrayWriter writer = new CharArrayWriter();
        System.out.println("Writing to character array");
        try {
            reader.reset();

            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] written = writer.toCharArray();
        for (char ch : written) {
            System.out.println(ch);
        }

        reader.close();
        writer.close();
    }

}
