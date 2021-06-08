package io.github.laplacedemon.fasterdoubleparser;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class FasterDoubleParserFromByteArrayTest {

    @Test
    public void parseDouble() {
        int COUNT = 10000000;

        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < COUNT; i++) {
            double value = rnd.nextDouble();
            String valueStr = String.valueOf(value);

            double v0 = FasterDoubleParserFromByteArray.parseDouble(String.valueOf(value).getBytes());
            String valueStr0 = String.valueOf(v0);

//            System.out.println(value + ", " + valueStr0);
            Assert.assertEquals(valueStr, valueStr0);
        }
    }
}
