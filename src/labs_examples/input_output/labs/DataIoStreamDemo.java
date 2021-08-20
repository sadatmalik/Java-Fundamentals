package labs_examples.input_output.labs;

import java.io.*;

public class DataIoStreamDemo {

    public static void main(String[] args) {
        DataOutputStream out = null;
        DataInputStream in = null;

        byte b = 1;
        short s = 2;
        int i = 83;
        long l = 3L;
        float f = 3.456f;
        double d = 2.0d;
        char c = 'S';
        boolean bool = false;

        try {
            out = new DataOutputStream(new FileOutputStream("src/labs_examples/input_output/files/data.txt"));

            out.writeByte(b);
            out.writeShort(s);
            out.writeInt(i);
            out.writeLong(l);
            out.writeFloat(f);
            out.writeDouble(d);
            out.writeChar(c);
            out.writeBoolean(bool);

            out.close();

            in = new DataInputStream(new FileInputStream("src/labs_examples/input_output/files/data.txt"));

            byte b2 = in.readByte();
            System.out.println(b2);

            short s2 = in.readShort();
            System.out.println(s2);

            int i2 = in.readInt();
            System.out.println(i2);

            long l2 = in.readLong();
            System.out.println(l2);

            float f2 = in.readFloat();
            System.out.println(f2);

            double d2 = in.readDouble();
            System.out.println(d2);

            char c2 = in.readChar();
            System.out.println(c2);

            boolean bool2 = in.readBoolean();
            System.out.println(bool2);

            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}