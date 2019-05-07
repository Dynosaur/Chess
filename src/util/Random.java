package util;

public class Random {

    public static int generate(int min, int max) {
        double base = (1 - Math.random()) * (max - min) + min;
        return (base - (int)base < 0.5D) ? (int)Math.floor(base) : (int)Math.ceil(base);
    }

    public static <E> E pickRandom(E[] array) {
        if(array.length == 0) throw new IllegalArgumentException("Array has no length!");
        if(array.length == 1) return array[0];

        int index = generate(0, array.length);
        return array[index];
    }

}
