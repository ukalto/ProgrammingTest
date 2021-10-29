import java.util.Arrays;

public class FirstProgrammingTest {

    static int[][] reshape(int[][] inputArray) {
        if (inputArray == null) {
            return new int[][]{};
        }
        int counter = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                counter++;
            }
        }

        int length = 0;
        if (counter % 2 != 0) {
            length = (counter + 1) / 2;
        } else {
            length = counter / 2;
        }

        int[][] output = new int[length][2];

        int row = 0;
        int col = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (row % 2 == 0) {
                    output[row][col] = inputArray[i][j];
                } else {
                    output[row][1-col] = inputArray[i][j];
                }
                col++;
                if (col > 1) {
                    row++;
                    col = 0;
                }
            }
        }
        return output;
    }

    static void mask(int[][] inputArray) {
        for (int i = 0; i < inputArray.length-1; i++) {
            int firstLength = inputArray[i].length;
            int secondLength = inputArray[i+1].length;
            if(firstLength == secondLength){
                for (int j = 0, count = 0; j < inputArray[i].length; j++) {
                    if(inputArray[i][j] == inputArray[i+1][j]) {
                        count++;
                    }
                    if(count == firstLength) Arrays.fill(inputArray[i], -1);
                }
            }
        }
    }

    static int getMaxOppositeSum(int[] sequence, int start, int end) {
        if (start > end) return 0;
        return Math.max(sequence[start] + sequence[end], getMaxOppositeSum(sequence, start + 1, end - 1));
    }


    //TODO: Schreiben Sie hier die geforderten Methoden.
    public static void print(int[][] input) {
        System.out.println(Arrays.deepToString(input));
    }

    public static void main(String[] args) {
        //TODO: Erweitern Sie "main" laut Angabe.
        int[][] test1 = {{5, 2, 4}, {2, 7, 3}, {9, 5, 8}};
        int[][] test2 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] test3 = {{6}, {6, 7}, {6, 7}, {6, 7}, {7, 6}};
        int[] seq1 = {1, 2, 4, 4, 5, 5, 5, 10};

        int[][] result1 = reshape(test1);
        int[][] result2 = reshape(test3);
        print(result1);
        print(result2);
        print(reshape(new int[][]{{}}));
        mask(test1);
        mask(test2);
        mask(test3);

        print(test1);
        print(test2);
        print(test3);

        System.out.println(getMaxOppositeSum(seq1, 0, 7));
        System.out.println(getMaxOppositeSum(seq1, 0, 5));
        System.out.println(getMaxOppositeSum(seq1, 4, 7));
    }
}