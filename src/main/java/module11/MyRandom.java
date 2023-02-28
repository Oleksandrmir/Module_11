package module11;

public class MyRandom {
    private final long a;
    private final long c;
    private final long m;
    private long seed;

    public MyRandom seed(Long seed) {
        this.seed = seed;
        return this;
    }

    public MyRandom(long a, long c, long m) {
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public long next() {
        return (a * seed + c) % m;
    }
}