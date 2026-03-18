import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BacktrackingTemplates {
    static class SubsetTemplate {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, 0);
            return result;
        }

        private void backtrack(int[] nums, int startIndex) {
            result.add(new ArrayList<>(path));
            for (int i = startIndex; i < nums.length; i++) {
                path.add(nums[i]);
                backtrack(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    static class CombineTemplate {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtrack(n, k, 1);
            return result;
        }

        private void backtrack(int n, int k, int startIndex) {
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i <= n; i++) {
                path.add(i);
                backtrack(n, k, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    static class PermuteTemplate {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];
            backtrack(nums);
            return result;
        }

        private void backtrack(int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                used[i] = true;
                path.add(nums[i]);
                backtrack(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    static class PermuteUniqueTemplate {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backtrack(nums);
            return result;
        }

        private void backtrack(int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                used[i] = true;
                path.add(nums[i]);
                backtrack(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    static class PartitionTemplate {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        public List<List<String>> partition(String s) {
            backtrack(s, 0);
            return result;
        }

        private void backtrack(String s, int startIndex) {
            if (startIndex == s.length()) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i < s.length(); i++) {
                if (!isPalindrome(s, startIndex, i)) {
                    continue;
                }

                path.add(s.substring(startIndex, i + 1));
                backtrack(s, i + 1);
                path.remove(path.size() - 1);
            }
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    static class SudokuTemplate {
        boolean found = false;

        public void solveSudoku(char[][] board) {
            backtrack(board, 0);
        }

        private void backtrack(char[][] board, int index) {
            if (index == 81) {
                found = true;
                return;
            }
            if (found) {
                return;
            }

            int row = index / 9;
            int col = index % 9;

            if (board[row][col] != '.') {
                backtrack(board, index + 1);
                return;
            }

            for (char num = '1'; num <= '9'; num++) {
                if (!isValid(board, row, col, num)) {
                    continue;
                }

                board[row][col] = num;
                backtrack(board, index + 1);
                if (found) {
                    return;
                }
                board[row][col] = '.';
            }
        }

        private boolean isValid(char[][] board, int row, int col, char num) {
            for (int j = 0; j < 9; j++) {
                if (board[row][j] == num) {
                    return false;
                }
            }

            for (int i = 0; i < 9; i++) {
                if (board[i][col] == num) {
                    return false;
                }
            }

            int startRow = row / 3 * 3;
            int startCol = col / 3 * 3;
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[i][j] == num) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
