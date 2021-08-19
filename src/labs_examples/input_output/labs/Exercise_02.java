package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 2: File encryption
 *
 *      -Using the BufferedReader, read a file character by character and write an encrypted version to a new file.
 *      -For example, change every 'a' to '-' and every 'e' to '~' .
 *      -Make sure you close the connections to both files.
 *
 *      Then, ead back the encrypted file using the BufferedReader and
 *      print out the unencrypted version. Does it match the original file?
 *
 */

class Encryption {
    public static void main(String[] args) {

        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader("src/labs_examples/input_output/files/char_data.txt"));
            writer = new PrintWriter(new FileOutputStream("src/labs_examples/input_output/files/char_data3.txt"));
            int c;

            while ((c = reader.read()) != -1) {
                if (c == 'a') {
                    writer.write('-');
                } else if (c == 'e') {
                    writer.write("~");
                } else {
                    writer.write(c);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {

                reader.close();

            } catch (IOException ie) {
                ie.printStackTrace();
            }

            writer.close();
        }
    }


}