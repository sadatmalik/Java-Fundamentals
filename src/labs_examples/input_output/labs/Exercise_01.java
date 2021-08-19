package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 1: File input/output
 *
 *      Using the BufferedInputStream, read a text file 5 bytes at a time and write each byte to a new file.
 *      Make sure you close the connections to both files.
 *
 *
 */

class Example {
    public static void main(String[] args) {

        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
            in = new BufferedInputStream(new FileInputStream("src/labs_examples/input_output/files/char_data.txt"));
            out = new BufferedOutputStream(new FileOutputStream("src/labs_examples/input_output/files/char_data3.txt"));
            byte[] bytes = new byte[5];
            int read;

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                out.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }

    }
}