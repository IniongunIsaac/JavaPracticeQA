import java.util.*;

public class PracticeMain {
    public static void main(String[] args) {
        /*System.out.println("sameNumberOfFactors: " + sameNumberOfFactors(0, 0));

        int[] input = { 10, 3, 3, 3, 4, 4, 4, 5, 5};
        System.out.println("isStepped: " + isStepped(input));

        int[] paired = { 8, 8, 8, 8, 7, 7, 7 };
        System.out.println("isPaired: " + isPairedN(paired, 15));

        String[] strings = { "good", "better", "best", "best", "first", "last", "last", "last", "good" };
        List<String> items = new ArrayList<>(List.of(strings));
        removeDuplicates(items);

        int[] sums = {1, 2, 3, 4, 5};
        System.out.println(testForSum(sums, 20));

        ObjectLinkedList linkedList = new ObjectLinkedList();
        String[] inputList = {"Straight", "Bent", "Equals", "Well", "Storm"};
        for (String s : inputList) {
            linkedList.add(s);
        }

        System.out.println("Input List => " + Arrays.toString(inputList));
        System.out.println("Search result for: " + "Well => " + linkedList.find("Well"));
        System.out.println("Search result for: " + "WellX => " + linkedList.find("WellX"));
        System.out.println(linkedList);

        GenericLinkedList<String> genericLinkedList = new GenericLinkedList<>();
        for (String s : inputList) {
            genericLinkedList.add(s);
        }

        System.out.println("========================================================");
        System.out.println("Input List => " + Arrays.toString(inputList));
        System.out.println("Search result for: " + "Well => " + genericLinkedList.find("Well"));
        System.out.println("Search result for: " + "WellX => " + genericLinkedList.find("WellX"));
        System.out.println(genericLinkedList);

        System.out.println("========================================================");
        int[] intArray = {1, 5, 4, 2};
        ArrayList<int[]> permutations = permutations(intArray);
        for (int[] permutation : permutations) {
            System.out.println(Arrays.toString(permutation));
        }

        int[] items = {3, 2, 1, 4, 5};
        System.out.println(isCentered(items));


        int[] items = {1, 2, 3};
        System.out.println(evenOddNumbersVariant(items));


        char[] items = {'a', 'b', 'c'};
        char[] subItems = subArrayBetweenRange(items, 1, -2);
        System.out.println(Arrays.toString(subItems));


        System.out.println(reverseInteger(1000));
         */

        int[] first = {1, 8, 3, 2, 6};
        int[] second = {2, 6, 1};
        int[] common = commonIntegers(first, second);
        System.out.println(Arrays.toString(common));
    }

    private static int sameNumberOfFactors(int num1, int num2) {
        if (num1 < 0 || num2 < 0) {
            return -1;
        }

        if (num1 == num2) {
            return 1;
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

    private static <T> void removeDuplicates(List<T> items) {
        if (items == null) {
            return;
        }
        Set<T> set = new LinkedHashSet<>(items);
        items.clear();
        items.addAll(set);

        System.out.println(items);
    }

    private static boolean testForSum(int[] intArray, int testInt) {
        if (intArray.length < 3) {
            return false;
        }

        for (int i : intArray) {
            for (int j : intArray) {
                for (int k : intArray) {
                    if ((i != j) && (i != k) && (j != k) && (i + j + k == testInt)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static ArrayList<ArrayList<Integer>> integerPermutations(int[] intArray) {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();

        for (int i : intArray) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(i);
            for (int j : intArray) {
                if (i != j) {
                    integers.add(j);
                }
            }
            permutations.add(integers);
        }

        return permutations;
    }

    public static ArrayList<int[]> permutations(int[] arr) {
        ArrayList<int[]> result = new ArrayList<>();
        if (arr.length == 0) {
            result.add(new int[0]);
            return result;
        }

        for (int i = 0; i < arr.length; i++) {
            int[] subArr = new int[arr.length - 1];
            for (int j = 0; j < i; j++) {
                subArr[j] = arr[j];
            }
            for (int j = i + 1; j < arr.length; j++) {
                subArr[j - 1] = arr[j];
            }

            ArrayList<int[]> subResult = permutations(subArr);
            for (int[] sub : subResult) {
                int[] perm = new int[arr.length];
                perm[0] = arr[i];
                for (int j = 0; j < sub.length; j++) {
                    perm[j + 1] = sub[j];
                }
                result.add(perm);
            }
        }

        return result;
    }

    private static int isCentered(int[] inputArray) {
        if (inputArray.length % 2 == 0) {
            return 0;
        }

        int middleIndex = inputArray.length / 2;
        int middleElement = inputArray[middleIndex];

        for (int i = 0; i < inputArray.length; i++) {
            if (i != middleIndex && inputArray[i] <= middleElement) {
                return 0;
            }
        }

        return 1;
    }

    private static int evenOddNumbersVariant(int[] items) {
        if (items.length == 0) {
            return 0;
        }

        int oddSum = 0;
        int evenSum = 0;

        for (int item : items) {
            if (item % 2 == 0) {
                evenSum += item;
            } else {
                oddSum += item;
            }
        }

        return oddSum - evenSum;
    }

    private static char[] subArrayBetweenRange(char[] inputArray, int start, int length) {
        if (inputArray.length == 0 || start < 0 || length < 0 ||
                length > inputArray.length - 1 || start > inputArray.length - 1 ||
                (start == inputArray.length - 1 && length >= inputArray.length - 1)) {
            return null;
        }

        char[] items = new char[length];

//        for (int i = start; i < length; i++) {
//            items[i] = inputArray[i];
//        }

        System.arraycopy(inputArray, start, items, 0, length);

        return items;
    }

    public static int reverseInteger(int num) {
        if (num == 0) {
            return 0;
        }
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    private static int[] commonIntegers(int[] first, int[] second) {
        if (first == null || second == null) {
            return null;
        }

        if (first.length == 0 || second.length == 0) {
            return new int[0];
        }

        ArrayList<Integer> common = new ArrayList<>();

        for (int j : first) {
            for (int k : second) {
                if (j == k) {
                    common.add(j);
                }
            }
        }

        int[] commonInts = new int[common.size()];
        for (int i = 0; i < common.size(); i++) {
            commonInts[i] = common.get(i);
        }

        return commonInts;
    }

}