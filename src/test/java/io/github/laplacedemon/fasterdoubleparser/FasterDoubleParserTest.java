package io.github.laplacedemon.fasterdoubleparser;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class FasterDoubleParserTest {

    @Test
    public void parseDouble() {
        int COUNT = 10000000;

        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < COUNT; i++) {
            double value = rnd.nextDouble();
            String valueStr = String.valueOf(value);

            double v0 = FasterDoubleParser.parseDouble(String.valueOf(value));
            String valueStr0 = String.valueOf(v0);

//            System.out.println(value + ", " + valueStr0);
            Assert.assertEquals(valueStr, valueStr0);
        }
    }

    @Test
    public void parseDoublePerformance() {
        int COUNT = 100000000;
        String valueString = "123456789.0123456789";
        byte[] valueBytes = valueString.getBytes();

        long t0 = System.nanoTime();

        for (int i = 0; i < COUNT; i++) {
//            double v0 = FasterDoubleParserFromByteArray.parseDouble(valueBytes);
            double v = Double.parseDouble(valueString);
        }

        long t1 = System.nanoTime();
        double dt = t1 - t0;
        double dtSeconds = dt / (1000 * 1000 * 1000);
        System.out.println("ops:" + COUNT/dtSeconds + ", dt : " + dtSeconds + "s");
    }
}
