package StringProblems;

import java.util.ArrayList;
import java.util.List;

class GenerateAllBinaryStringsWithoutConsecutiveOnes {
    public static void generateAllBinaryWithoutConsecutiveOnes(int length, StringBuffer sb, int idx, List<String> result) {
        if(idx == length) {
            result.add(sb.toString());
            return;
        }

        // If number in previous index is 0, then set 0 and 1 at current index and generate next binary recursively
        if(sb.charAt(idx - 1) == '0') {
            sb.setCharAt(idx, '0');
            generateAllBinaryWithoutConsecutiveOnes(length, sb, idx+1, result);

            sb.setCharAt(idx, '1');
            generateAllBinaryWithoutConsecutiveOnes(length, sb, idx+1, result);
        }

        // If number in previous index is 1, then set 0 only at current index and generate next binary recursively
        if(sb.charAt(idx - 1) == '1') {
            sb.setCharAt(idx, '0');
            generateAllBinaryWithoutConsecutiveOnes(length, sb, idx+1, result);
        }
    }


    public static void main(String[] args) {
        List<String> binaryStr = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        sb.setLength(4);
        sb.setCharAt(0, '0');
        generateAllBinaryWithoutConsecutiveOnes(4, sb, 1, binaryStr);

        sb.setCharAt(0, '1');
        generateAllBinaryWithoutConsecutiveOnes(4, sb, 1, binaryStr);

        System.out.println(binaryStr);
    }
}
