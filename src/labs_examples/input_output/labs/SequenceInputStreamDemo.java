package labs_examples.input_output.labs;

import java.io.*;

public class SequenceInputStreamDemo {

    public static void main(String[] args) {

        SequenceInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new SequenceInputStream(
                    new FileInputStream("src/labs_examples/input_output/files/char_data.txt"),
                    new FileInputStream("src/labs_examples/input_output/files/byte_data")
            );

            out = new FileOutputStream("src/labs_examples/input_output/files/char_data3.txt");

            int b;

            while ((b = in.read()) != -1) {
                out.write(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {

            try {
                in.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }

            try {
                out.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }

        }




    }
}
