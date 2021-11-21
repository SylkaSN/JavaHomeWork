package com.pb.ssn.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileNumbers {
    private static final Logger LOGGER = Logger.getLogger(FileNumbers.class.getName());
    private static final String PATH_TO_FILE = "src/com/pb/ssn/hw9/Files/";

    private static void createNumbersFile() {
        LOGGER.entering("FileNumbers", "createNumbersFile");

        Random random = new Random();
        Path path = Paths.get(PATH_TO_FILE + "numbers.txt");

        LOGGER.log(Level.INFO, "---===>>> write to file \"" + path.toAbsolutePath() + "\" start!");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int i=1; i<=10; i++) {
                for (int j=1; j<=10; j++) {
                    writer.write(random.nextInt(100) + " ");
                }
                writer.newLine();
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error with file write: " + ex.getCause());
        }
        LOGGER.log(Level.INFO, "---===>>> write to file \"" + path.toAbsolutePath() + "\" done!");

        LOGGER.exiting("FileNumbers", "createNumbersFile");
    }

    private static int[][] getArrayFromFile(String fileName) {
        int[][] newArr = new int[10][10];
        Path path = Paths.get(PATH_TO_FILE + fileName);

        LOGGER.log(Level.INFO, "---===>>> read from file \"" + path.toAbsolutePath() + "\" start");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            int i = 0;
            while((line = reader.readLine()) != null) {
                String[] numbers = line.split(" ");
                int j = 0;
                for (String number: numbers) {
                    int iTmp = Integer.parseInt(number);
                    newArr[i][j++] = iTmp;
                }
                i++;
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error with file read: " + ex.getCause());
        }

        LOGGER.log(Level.INFO, "---===>>> read from file \"" + path.toAbsolutePath() + "\" done!");

        return newArr;
    }

    private static void createOddNumbersFile() {
        LOGGER.entering("FileNumbers", "createOddNumbersFile");

        int[][] oldArr = getArrayFromFile("numbers.txt");

        Path path = Paths.get(PATH_TO_FILE + "odd-numbers.txt");

        LOGGER.log(Level.INFO, "---===>>> write to file \"" + path.toAbsolutePath() + "\" start!");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            System.out.println("---===>>> numbers.txt");
            for (int i=0; i<=9; i++) {
                for (int j=0; j<=9; j++) {
                    System.out.print(oldArr[i][j] + " ");
                    int tmp = oldArr[i][j];
                    if ( tmp % 2 == 0 ) tmp = 0;
                    writer.write(tmp + " ");
                }
                System.out.print("\n");
                writer.newLine();
            }
            System.out.println("----------------------------------");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error with file read: " + ex.getCause());
        }
        LOGGER.log(Level.INFO, "---===>>> write to file \"" + path.toAbsolutePath() + "\" done!");

        LOGGER.log(Level.INFO, "---===>>> read from file \"" + path.toAbsolutePath() + "\" start");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            System.out.println("---===>>> odd-numbers.txt");
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------------------------------");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error with file read: " + ex.getCause());
        }
        LOGGER.log(Level.INFO, "---===>>> read from file \"" + path.toAbsolutePath() + "\" done!");

        LOGGER.exiting("FileNumbers", "createOddNumbersFile");
    }

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "---===>>> Start Program");

        createNumbersFile();

        createOddNumbersFile();

        LOGGER.log(Level.INFO, "---===>>> End Program");
    }

}
