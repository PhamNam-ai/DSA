class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String isBalanced(String s) {
        if (s == null || s.length() == 0) return "YES";
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return "NO";
                char top = stack.pop();
                if (c == ')' && top != '(') return "NO";
                if (c == ']' && top != '[') return "NO";
                if (c == '}' && top != '{') return "NO";
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }