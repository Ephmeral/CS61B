public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            dq.addLast(word.charAt(i));
        }
        return dq;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> dq = wordToDeque(word);
        if (dq.size() <= 1) {
            return true;
        }

        boolean flag = true;
        while (dq.size() > 1) {
            if (dq.removeFirst() != dq.removeLast()) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> dq = wordToDeque(word);
        if (dq.size() <= 1) {
            return true;
        }
        while (dq.size() > 1) {
            if (!cc.equalChars(dq.removeFirst(), dq.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
