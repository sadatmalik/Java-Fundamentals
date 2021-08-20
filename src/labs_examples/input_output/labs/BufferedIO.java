package labs_examples.input_output.labs;

import java.io.*;

public class BufferedIO {

    public static void main(String[] args) {

        BufferedInputStream in = null;

        try {
            in = new BufferedInputStream(new ByteArrayInputStream(new byte[] {1, 2, 3, 4}));

            byte[] bytes = new byte[2];

            in.read(bytes);

            for (byte b : bytes) {
                System.out.print(b + " ");
            }
            System.out.println();

            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedOutputStream out = null;

        try {
            out = new BufferedOutputStream(new PrintStream(System.out));

            byte[] bytes = {'S', 'a', 'd', 'a', 't', ' ', 'w', 'a', 's', ' ', 'h', 'e', 'r', 'e', '!'};

            for (byte b : bytes) {
                out.write(b);
            }

            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
