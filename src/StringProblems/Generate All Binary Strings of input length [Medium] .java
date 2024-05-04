package StringProblems;

import java.util.ArrayList;
import java.util.List;

class GenerateAllBinaryStrings {
    public static void generateAllBinaryStringsOfInputLength(int length, StringBuffer sb, int idx, List<String> result) {
        if(idx == length) {
            result.add(sb.toString());
            return;
        }

        // Set 0 at idx and recursively generate binary at next position
        sb.setCharAt(idx, '0');
        generateAllBinaryStringsOfInputLength(length, sb, idx+1, result);

        // Set 1 at idx and recursively generate binary at next position
        sb.setCharAt(idx, '1');
        generateAllBinaryStringsOfInputLength(length, sb, idx+1, result);
    }

    public static void main(String[] args) {
        List<String> binaryStr = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        sb.setLength(4);
        generateAllBinaryStringsOfInputLength(4, sb, 0, binaryStr);
        System.out.println(binaryStr);
    }
}
