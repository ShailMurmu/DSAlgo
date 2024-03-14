package StringProblems;

class GenerateAllCombinations {
    public static void printCombinations(String str) {
        printCombinationsHelper(str, "");
    }

    private static void printCombinationsHelper(String str, String prefix) {
        System.out.println(prefix);

        for (int i = 0; i < str.length(); i++) {
            printCombinationsHelper(str.substring(i + 1), prefix + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        printCombinations("abcd");
    }
}
