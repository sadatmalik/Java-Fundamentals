package labs_examples.input_output.labs;

import java.io.*;
import java.util.ArrayList;

/**
 *
 *      Following the video examples and source code found in the src/labs_examples/input_output/examples/csv_parser
 *      package, create a new application that will parse a custom CSV file that you created and map each line of the
 *      csv to a custom POJO that you create.
 *
 *      Then add that object to an arraylist. After you have mapped each row of the csv to objects
 *      and added each object to an arraylist, print out each object using the objects custom toString() method.
 *
 *      Then, write the arraylist of objects back out to a new .csv file. Ensure that the resulting csv file is valid.
 *
 */
class ReadWriteCsvDemo {

    public static void main(String[] args) {

        ArrayList<Player> players = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/labs_examples/input_output/files/players.csv"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String firstName = values[1];
                String lastName = values[2];
                int highScore = Integer.parseInt(values[3]);

                Player player = new Player(id, firstName, lastName, highScore);

                players.add(player);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Player p : players) {
            System.out.println(p.toString());
        }

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/labs_examples/input_output/files/players2.csv"))) {

            for (Player p : players) {
                writer.write(String.valueOf(p.getId()));
                writer.write(",");

                writer.write(p.getFirstName());
                writer.write(",");

                writer.write(p.getLastName());
                writer.write(",");

                writer.write(String.valueOf(p.getHighScore()));
                writer.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

class Player {
    private int id;
    private String firstName;
    private String lastName;
    private int highScore;

    public Player(int id, String firstName, String lastName, int highScore) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.highScore = highScore;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getHighScore() {
        return highScore;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", highScore=" + highScore +
                '}';
    }
}