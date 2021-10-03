public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int x) {
        n = x;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y == n) || (x - y == -n);
    }
}
