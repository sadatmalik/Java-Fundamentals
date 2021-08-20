package labs_examples.input_output.labs;

import java.io.*;

public class ObjectIoStreamDemo {
    public static void main(String[] args) {
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream("src/labs_examples/input_output/files/object_data"));

            Pojo pojo = new Pojo(1, 2.0d, "Serialize this");

            System.out.println("Writing Pojo to object stream");

            out.writeInt(pojo.getI());
            out.writeDouble(pojo.getD());
            out.writeUTF(pojo.getS());


        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {
            in = new ObjectInputStream(new FileInputStream("src/labs_examples/input_output/files/object_data"));

            boolean eof = false;
            while (!eof) {
                try {
                    System.out.println("Reading Pojo from object stream");
                    int i = in.readInt();
                    double d = in.readDouble();
                    String s = in.readUTF();

                    Pojo pojo2 = new Pojo(i, d, s);

                    System.out.println(pojo2.toString());

                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class Pojo {
    private int i;
    private double d;
    private String s;

    public Pojo(int i, double d, String s) {
        this.i = i;
        this.d = d;
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public double getD() {
        return d;
    }

    public String getS() {
        return s;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "i=" + i +
                ", d=" + d +
                ", s='" + s + '\'' +
                '}';
    }
}
