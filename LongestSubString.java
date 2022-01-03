import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static Integer lengthOfLongestSubString(String str) {
        if (str.length() == 0) {
            return 0;
        }
        Integer start = 0;
        Integer end = 0;
        Map<Character, Integer> seqWindowMap = new HashMap<>();
        Integer maxLength = 0;
        while (end < str.length()) {
            if (seqWindowMap.containsKey(str.charAt(end))) {
                start = Math.max(start, seqWindowMap.get(str.charAt(end)) + 1);
            }
            seqWindowMap.put(str.charAt(end), end);
            maxLength = Math.max(maxLength, (end - start) + 1);
            end += 1;
        }
        return maxLength;
    }

    public static void main(String args[]) {
        String s = "abcabcbb";
        // String s = "bbbbb";
        // String s = "dvdf";

        Integer max = lengthOfLongestSubString(s);
        System.out.println(max);
    }
}
