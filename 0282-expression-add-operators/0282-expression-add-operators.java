import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        helper(result, "", num, target, 0, 0, 0);
        return result;
    }

    private void helper(List<String> result, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) result.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break; // avoid numbers with leading zero
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(result, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(result, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                helper(result, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                helper(result, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addOperators("123", 6)); // Output: ["1*2*3","1+2+3"]
        System.out.println(solution.addOperators("232", 8)); // Output: ["2*3+2","2+3*2"]
        System.out.println(solution.addOperators("3456237490", 9191)); // Output: []
    }
}
