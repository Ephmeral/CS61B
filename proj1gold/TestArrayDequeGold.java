import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testArray() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                sad2.addLast(i);
            } else {
                sad1.addFirst(i);
                sad2.addFirst(i);
            }
        }

        for (int i = 0; i < 4; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                Integer actual = sad1.removeLast();
                Integer expected = sad2.removeLast();
                assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                                + " not equal to " + expected + "!",
                        expected, actual);
            } else {
                Integer actual = sad1.removeFirst();
                Integer expected = sad2.removeFirst();
                assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                                + " not equal to " + expected + "!",
                        expected, actual);
            }
        }
    }
}
