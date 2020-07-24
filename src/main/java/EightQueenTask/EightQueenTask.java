package EightQueenTask; /**
 * @author Ana on 7/22/2020
 */

import java.util.Random;
import java.util.Scanner;

public class EightQueenTask {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter chessboard size: ");
        int arraySize = in.nextInt();
        char[][] chessboard = createArray(arraySize);
        fillArray(chessboard);
        int xCoord = 0;
        int counter = 1;
        while (xCoord < chessboard.length) {
            int yCoord = randomCoordinate(arraySize);
            if (isFreeFieldAvailableInTheLine(chessboard, xCoord)) {
                while (!isFieldAvailable(chessboard, xCoord, yCoord)) {
                    yCoord = randomCoordinate(arraySize);
                }
                chessboard[xCoord][yCoord] = 'X';
                fillUnavailableFields(chessboard, xCoord, yCoord);
                xCoord++;
            }
            else {
                xCoord = 0;
                fillArray(chessboard);
                counter++;
            }

        }
        printArrayToConsole(chessboard);
        System.out.println("Number of approaches " + counter);
    }


    public static char[][] createArray(int size) {
        char[][] chessboard = new char[size][size];
        return chessboard;
    }

    public static void fillArray(char[][] array) {
        char emptyField = 'o';
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = emptyField;
            }
        }
    }

    public static void printArrayToConsole(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();

        }
    }

    public static int randomCoordinate(int arraySize) {
        Random randomGenerator = new Random();
        int coordinate = randomGenerator.nextInt(arraySize);
        return coordinate;
    }

    public static boolean isFieldAvailable(char[][] array, int xCoord, int yCoord) {
        return (array[xCoord][yCoord] == 'o');
    }

    public static boolean isFreeFieldAvailableInTheLine(char[][] array, int xCoord) {
        for (int i = 0; i < array.length; i++) {
            if (array[xCoord][i] == 'o') {
                return true;
            }
        }
        return false;
    }


    public static char[][] fillUnavailableFields(char[][] array, int xCoord, int yCoord) {
        int i, j;
        for (i = 0; i < array[xCoord].length; i++) {
            if (array[xCoord][i] == 'o') {
                array[xCoord][i] = '-';
            }
        }
        for (i = 0; i < array.length; i++) {
            if (array[i][yCoord] == 'o') {
                array[i][yCoord] = '-';
            }
        }
        for (i = xCoord, j = yCoord; i >= 0 && j >= 0; i--, j--) {
            if (array[i][j] == 'o') {
                array[i][j] = '-';
            }
        }
        for (i = xCoord, j = yCoord; i < array.length && j < array[i].length; i++, j++) {
            if (array[i][j] == 'o') {
                array[i][j] = '-';
            }
        }
        for (i = xCoord, j = yCoord; i < array.length && j >= 0; i++, j--) {
            if (array[i][j] == 'o') {
                array[i][j] = '-';
            }
        }
        for (i = xCoord, j = yCoord; i >= 0 && j < array[i].length; i--, j++) {
            if (array[i][j] == 'o') {
                array[i][j] = '-';
            }
        }
        return array;
    }

}
