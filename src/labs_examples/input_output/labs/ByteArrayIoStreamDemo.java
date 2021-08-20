package labs_examples.input_output.labs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayIoStreamDemo {
    public static void main(String[] args) {

        ByteArrayInputStream in = null;

        // note this doesn't have to go in a try catch
        byte[] bytes = {3, 4, 5, 6};
        in = new ByteArrayInputStream(bytes);

        int b;

        System.out.println("Bytes read from ByteArrayInputStream: ");
        while((b = in.read()) != -1 ) {
            System.out.println(b);
        }

        ByteArrayOutputStream out = null;

        // note this doesn't throw any exceptions
        out = new ByteArrayOutputStream();

        in.reset();

        while((b = in.read()) != -1) {
            out.write(b);
        }

        byte[] bytesOut = out.toByteArray();
        System.out.println("\nBytes written by ByteArrayOutputStream: ");

        for (byte element : bytesOut) {
            System.out.println(element);
        }

        try {
            in.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }



    }
}
