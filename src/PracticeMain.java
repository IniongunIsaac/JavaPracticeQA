import java.util.HashMap;

public class PracticeMain {
    public static void main(String[] args) {
        System.out.println("sameNumberOfFactors: "+ sameNumberOfFactors(6, 6));

        int[] input = { 10, 3, 3, 3, 4, 4, 4, 5, 5};
        System.out.println("isStepped: " + isStepped(input));

        int[] paired = { 8, 8, 8, 8, 7, 7, 7 };
        System.out.println("isPaired: " + isPairedN(paired, 15));
    }

    private static int sameNumberOfFactors(int num1, int num2) {
        if (num1 < 0 || num2 < 0) {
            return -1;
        }

        int num1Factors = 2;
        int num2Factors = 2;

        for (int i = 2; i < num1; i++) {
            if (num1 % i == 0) {
                num1Factors++;
            }
        }

        for (int i = 2; i < num2; i++) {
            if (num2 % i == 0) {
                num2Factors++;
            }
        }

        return num1Factors == num2Factors ? 1 : 0;
    }
    
    private static int isStepped(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i + 1] < input[i]) {
                return 0;
            }
        }

        HashMap<Integer, Integer> inputOccurrences = new HashMap<>();

        for (int i : input) {
            if (inputOccurrences.containsKey(i)) {
                int value = inputOccurrences.get(i);
                inputOccurrences.put(i, value + 1);
            } else {
                inputOccurrences.put(i, 1);
            }
        }

        int threesOccurrencies = 0;

        for (Integer value : inputOccurrences.values()) {
            if (value >= 3) {
                threesOccurrencies++;
            }

            if (threesOccurrencies >= 3) {
                break;
            }
        }

        return threesOccurrencies == 3 ? 1 : 0;
    }

    private static int isPairedN(int[] input, int n) {
        if (input.length < 2 || n <= 0) {
            return 0;
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i] != input[j] && (input[i] + input[j] == n) && (i + j == n)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public static int isPairedNChatGPT(int[] a, int n) {
        // Check if the array length is less than 2 or if n is less than or equal to 0
        if (a.length < 2 || n <= 0) {
            return 0; // array cannot be paired-N
        }

        // Check if the array contains two distinct elements that sum to n
        int num1 = -1;
        int num2 = -1;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] + a[j] == n) {
                    num1 = a[i];
                    num2 = a[j];
                    break; // found two distinct elements that sum to n, exit loop
                }
            }
            if (num1 != -1 && num2 != -1) {
                break; // found two distinct elements that sum to n, exit outer loop
            }
        }

        // Check if the indexes of the two distinct elements also sum to n
        if (num1 != -1 && num2 != -1) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i+1; j < a.length; j++) {
                    if (a[i] == num1 && a[j] == num2 && i+j == n) {
                        return 1; // array is paired-N
                    } else if (a[i] == num2 && a[j] == num1 && i+j == n) {
                        return 1; // array is paired-N
                    }
                }
            }
        }

        return 0; // array is not paired-N
    }
}