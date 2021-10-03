import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque<Character> dq = palindrome.wordToDeque("Headkadsal");
        StringBuilder actual = new StringBuilder();
        for (int i = 0; i < "Headkadsal".length(); i++) {
            actual.append(dq.removeFirst());
        }
        assertEquals("Headkadsal", actual.toString());
    }

    @Test
    public void testPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("bag"));
        assertFalse(palindrome.isPalindrome("aabbcc"));
        assertTrue(palindrome.isPalindrome("abcba"));
        assertTrue(palindrome.isPalindrome("wxllxw"));
        assertTrue(palindrome.isPalindrome("toohottohoot"));
    }

    @Test
    public void testPalindromeOffByOne() {
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("cat", cc));
        assertFalse(palindrome.isPalindrome("bag", cc));
        assertFalse(palindrome.isPalindrome("word", cc));
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome("aedfb", cc));
    }

    @Test
    public void testPalindromeOffByN() {
        CharacterComparator cc = new OffByN(5);
        assertFalse(palindrome.isPalindrome("cat", cc));
        assertFalse(palindrome.isPalindrome("baf", cc));
        assertFalse(palindrome.isPalindrome("word", cc));
        assertFalse(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("aedfb", cc));
    }
}
