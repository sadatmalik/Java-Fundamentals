package labs_examples.input_output.labs;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringRW {

    public static void main(String[] args) {
        String s = "How now brown cow";
        StringReader r = new StringReader(s);

        int c;

        System.out.println("Reading string one char at a time:");
        try {
            while((c = r.read()) != -1) {
                System.out.println((char) c);;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nWriting string one char at a time:");
        StringWriter w = new StringWriter();

        try {
            r.reset();

            while ((c = r.read()) != -1) {
                w.write(c);
            }

            String s2 = w.toString();

            System.out.println(s2);

            r.close();
            w.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
