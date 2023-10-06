  public String decodeString(String s) {
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder multiplier = new StringBuilder();
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!str.isEmpty()) {
                    deque.push(str.toString());
                    str = new StringBuilder();
                }
                multiplier.append(c);
            } else if (c == '[') {
                deque.push(multiplier.toString());
                multiplier = new StringBuilder();
            } else if (c == ']') {
                while (!deque.isEmpty() && !Character.isDigit(deque.peek().charAt(0))) {
                    str.insert(0, deque.pop());
                }
                deque.push(str.toString().repeat(Integer.parseInt(deque.pop())));
                str = new StringBuilder();
            } else {
                str.append(c);
            }
        }
        while (!deque.isEmpty()) {
            str.insert(0, deque.pop());
        }
        return str.toString();
    }
}
