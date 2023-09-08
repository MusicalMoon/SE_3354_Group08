import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {

    public static boolean LoadFile(String fileName, int[][] data) {
        //Create a fileStream object
        try {
            FileInputStream input = new FileInputStream(fileName);
            FileInputStream redo = new FileInputStream(fileName);
            Scanner reader = new Scanner(input);
            Scanner reader2 = new Scanner(redo);
            int counter = 0;

            //Create loop to check how many values there are
            while (reader.hasNext()) {
                counter++;
                //makes sure there is no an infinite loop
                reader.nextInt();
            }
            reader.close();
                //System.out.println(counter);
            //If not 81 values not a proper sudoku board, exit method with false.
            if(counter < 81 || counter > 81)
            {
                return false;
            }
            else
            {
                while (reader2.hasNextLine())
                {
                    for (int row = 0; row < data.length; row++)
                    {
                        //creates a string array for the line
                        String Line[] = reader2.nextLine().trim().split(" ");

                        //inner loop for column
                        for (int column = 0; column < data.length; column++) {
                            data[row][column] = Integer.parseInt(Line[column]);
                        }
                    }
                    return true;
                }
            }
        }
        //Use this to catch the error if there is no file found
        catch(FileNotFoundException e) {
            //System.out.println("b");
            return false;
        }
        return true;
    }

    public static boolean TestColumn(int[][] data, int col)
    {
        int holder[] = {0,0,0,0,0,0,0,0,0,0};

            for(int b = 0; b < data.length; b++)
            {
                for(int num = 1; num <= 9; num++)
                {
                    if(data[b][col] == num)
                    {
                        holder[num] ++;
                        num = 10;
                    }
                }
            }

            //checks for repeated numbers
        for(int c = 1; c <= 9; c++)
        {
            //System.out.println(holder[c]);
            if(holder[c] > 1) {
                c = 10;
                return false;
            }
        }
        return true;
    }

    public static boolean TestRow(int[][] data, int row)
    {
        int holder[] = {0,0,0,0,0,0,0,0,0,0};
        for(int a = 0; a < data.length; a++)
        {

                for(int num = 0; num < 9; num++)
                {
                    if(data[row][a] == num + 1)
                    {
                        holder[num] ++;
                        num = 10;
                    }
                }

        }
        for(int c = 0; c < 9; c++)
        {
            if(holder[c] > 1) {
                c = 10;
                return false;
            }
        }
        return true;
    }

    public static boolean TestBox(int[][] data, int box)
    {
        int holder[] = {0,0,0,0,0,0,0,0,0,0};

        if(box == 0)
        {
            for(int a = 0; a <= 2; a++)
            {
                for(int b = 0; b <= 2; b++)
                {
                    for (int num = 0; num < 9; num++) {
                        if (data[a][b] == num + 1) {
                            holder[num]++;
                            num = 10;
                        }
                    }
                }
            }
        }
        else if(box == 1)
        {
            for(int a = 0; a <= 2; a++)
            {
                for(int b = 3; b <= 5; b++)
                {
                    for (int num = 0; num < 9; num++) {
                        if (data[a][b] == num + 1) {
                            holder[num]++;
                            num = 10;
                        }
                    }
                }
            }
        }
        else if(box == 2)
        {
            for(int a = 0; a <= 2; a++)
            {
                for(int b = 6; b <= 8; b++)
                {
                    for (int num = 0; num < 9; num++) {
                        if (data[a][b] == num + 1) {
                            holder[num]++;
                            num = 10;
                        }
                    }
                }
            }
        }
        else if(box == 3)
        {
            for(int a = 3; a <= 5; a++)
            {
                for(int b = 0; b <= 2; b++)
                {
                    for (int num = 0; num < 9; num++) {
                        if (data[a][b] == num + 1) {
                            holder[num]++;
                            num = 10;
                        }
                    }
                }
            }
        }
        else if(box == 4)
        {
            for(int a = 3; a <= 5; a++)
            {
                for(int b = 3; b <= 5; b++)
                {
                    for (int num = 0; num < 9; num++) {
                        if (data[a][b] == num + 1) {
                            holder[num]++;
                            num = 10;
                        }
                    }
                }
            }
        }

        else if(box == 5)
        {
            for(int a = 3; a <= 5; a++)
            {
                for(int b = 6; b <= 8; b++)
                {
                    for (int num = 0; num < 9; num++) {
                        if (data[a][b] == num + 1) {
                            holder[num]++;
                            num = 10;
                        }
                    }
                }
            }
        }
        else if(box == 6)
        {
            for(int a = 6; a <= 8; a++)
            {
                for(int b = 0; b <= 2; b++)
                {
                    for (int num = 0; num < 9; num++) {
                        if (data[a][b] == num + 1) {
                            holder[num]++;
                            num = 10;
                        }
                    }
                }
            }
        }
        else if(box == 7)
        {
            for(int a = 6; a <= 8; a++)
            {
                for(int b = 3; b <= 5; b++)
                {
                    for (int num = 0; num < 9; num++) {
                        if (data[a][b] == num + 1) {
                            holder[num]++;
                            num = 10;
                        }
                    }
                }
            }
        }
        else if(box == 8)
        {
            for(int a = 6; a <= 8; a++)
            {
                for(int b = 6; b <= 8; b++)
                {
                    for (int num = 0; num < 9; num++) {
                        if (data[a][b] == num + 1) {
                            holder[num]++;
                            num = 10;
                        }
                    }
                }
            }
        }

        for(int c = 0; c < 9; c++)
        {
            if(holder[c] > 1) {
                c = 10;
                return false;
            }
        }
        return true;
    }

    public static void Display(int[][] data)
    {

        for (int a = 0; a < data.length; a++)
        {
            for (int b = 0; b < data.length; b++) {
                System.out.print(data[a][b]);
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String fileName;
        boolean checker;
        int countErrors = 0;

        //Take in file name
        System.out.println("Enter the filename: ");
        fileName = scnr.nextLine();

        //Create array
        int sudoku[][] = new int[9][9];

        //Call the load file
        checker = LoadFile(fileName, sudoku);

        //If file isn't loaded skip to display
        if(checker == false)
        {
            System.out.println("Error reading file.");
        }
        //Otherwise test array
        else {
            Display(sudoku);

            for(int row = 0; row < 9; row++)
            {
                checker = TestRow(sudoku, row);

                if(checker == false)
                {
                    countErrors++;
                    System.out.println("Row " + (row + 1) + " is invalid.");
                }
            }

            for(int column = 0; column < 9; column++)
            {
                checker = TestColumn(sudoku, column);

                if(checker == false)
                {
                    countErrors++;
                    System.out.println("Column " + (column + 1) + " is invalid.");
                }
            }

            for(int box = 0; box < 9; box++)
            {
                checker = TestBox(sudoku, box);
                if(checker == false)
                {
                    countErrors++;
                    System.out.println("Box " + (box + 1) + " is invalid.");
                }
            }
            if(countErrors == 0)
            {
                System.out.println("The solution is valid.");
            }

        }

    }
}