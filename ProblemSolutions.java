import java.util.*;
class ProblemSolutions {

    // 1. Check if string can be palindrome after removing one character
    public static String canBePalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return (isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1)) ? "YES" : "NO";
            }
        }
        return "YES";
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    // 2. Generate all valid parentheses
    public static String generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);

        // OPTIONAL
        // Collections.reverse(result);  // reverse to match the output in the description

        return String.join(", ", result);
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (open < max) backtrack(result, current + "{", open + 1, close, max);
        if (close < open) backtrack(result, current + "}", open, close + 1, max);
    }


    // 3. Merge two sorted lists
    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) result.add(list1.get(i++));
            else result.add(list2.get(j++));
        }
        while (i < list1.size()) result.add(list1.get(i++));
        while (j < list2.size()) result.add(list2.get(j++));
        return result;
    }

    // 4. Remove zero and form largest number (plus one)
    public static List<Integer> plusOne(List<Integer> digits) {
        int n = digits.size();
        for (int i = n - 1; i >= 0; i--) {
            if (digits.get(i) < 9) {
                digits.set(i, digits.get(i) + 1);
                return digits;
            }
            digits.set(i, 0); 
        }
        digits.add(0, 1);
        return digits;
    }

    // 5. Max area (container with most water)
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = h * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }


    public static void main(String[] args) {
        // Test 1:
        String testStr = "afga";
        System.out.println("1. Palindrome substring in '" + testStr + "': " + canBePalindrome(testStr));

        // Test 2:
        int n = 2;
        System.out.println("2. Valid parentheses for n=" + n + ": " + generateParenthesis(n));

        // Test 3:
        List<Integer> list1 = Arrays.asList(1, 2, 4);
        List<Integer> list2 = Arrays.asList(1, 3, 4);
        System.out.println("3. Merged list: " + merge(list1, list2));

        // Test 4:
        List<Integer> digits = new ArrayList<>(Arrays.asList(1, 2, 9));
        System.out.println("4. Plus one result: " + plusOne(digits));

        // Test 5:
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println("5. Max area: " + maxArea(heights));
    }
}