# DFS / 回溯算法模板

这份模板按 LeetCode 常见题型整理，默认使用 Java。

## 1. 回溯通用骨架

```java
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> solve(int[] nums) {
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
```

- `path`：当前路径
- `result`：最终答案
- `for`：当前层的选择列表
- `递归`：进入下一层
- `撤销选择`：回到上一层

## 2. 子集 / 组合模板

适用题型：
- 子集
- 组合
- 组合总和
- 递增子序列

核心特征：
- 结果通常在每层开头收集
- 用 `startIndex` 控制下一层从哪里开始选

```java
class Solution {
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
```

如果是 `k` 组合，只需要加终止条件：

```java
if (path.size() == k) {
    result.add(new ArrayList<>(path));
    return;
}
```

如果是组合总和这类“可以重复选当前元素”的题：

```java
backtrack(candidates, i, target - candidates[i]);
```

不是 `i + 1`，而是 `i`。

## 3. 排列模板

适用题型：
- 全排列
- 全排列 II

核心特征：
- 没有 `startIndex`
- 用 `used[]` 记录哪些元素已经选过

```java
class Solution {
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
```

如果要去重，先排序，再加这段剪枝：

```java
if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
    continue;
}
```

## 4. 字符串切割模板

适用题型：
- 分割回文串
- 复原 IP 地址

核心特征：
- `startIndex` 表示当前切割起点
- 每次截取一个区间 `[startIndex, i]`

```java
class Solution {
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
            if (!isValid(s, startIndex, i)) {
                continue;
            }

            path.add(s.substring(startIndex, i + 1));
            backtrack(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(String s, int left, int right) {
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
```

## 5. 棋盘搜索模板

适用题型：
- N 皇后
- 数独
- 单词搜索

核心特征：
- 按“位置”递归
- 当前位置不能改时，直接跳到下一格
- 找到答案后立刻返回

```java
class Solution {
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
```

## 6. 回溯题判断套路

拿到题先看这 4 件事：

1. `path` 里放什么
2. 什么时候收集答案
3. 下一层从哪里开始
4. 递归返回时要撤销什么

常见对应关系：

- 子集 / 组合：`startIndex`
- 排列：`used[]`
- 切割：区间 `[startIndex, i]`
- 棋盘：当前位置 `index` 或 `(row, col)`

## 7. 常见错误

- 把“组合”写成“排列”，漏了 `startIndex`
- 把“排列”写成“组合”，少了 `used[]`
- 找到答案后没有立刻 `return`
- 递归后忘了撤销选择
- 一边用 `index`，一边又在函数里重新扫整张表，导致逻辑混乱
