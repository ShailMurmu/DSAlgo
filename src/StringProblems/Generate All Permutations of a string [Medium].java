package StringProblems;

class GenerateAllPermutations {
    public static void permute(StringBuilder str, int idx, int N) {
        if(idx == N) System.out.println(str.toString());
        else{
            for(int i = idx; i<= N; i++) {
                swap(str, idx, i);
                permute(str, idx + 1, N);
                swap(str, idx, i);
            }
        }
    }

    private static void swap(StringBuilder str, int idx, int i) {
        char temp = str.charAt(idx);
        str.setCharAt(idx, str.charAt(i));
        str.setCharAt(i, temp);
    }

    private static void generateAllPermutations(String str) {
        StringBuilder sb = new StringBuilder(str);
        permute(sb, 0, str.length() - 1);
    }

    public static void main(String[] args) {
        generateAllPermutations("abc");
    }
}
