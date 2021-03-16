package mayibishi;

import java.math.BigDecimal;

public class RandomUtil {
    public static BigDecimal random(BigDecimal start, BigDecimal end) {

        BigDecimal startMultiplyingPower = new BigDecimal(getMultiplyingPower(start));
        BigDecimal endMultiplyingPower = new BigDecimal(getMultiplyingPower(end));
        BigDecimal multiplyingPower = startMultiplyingPower;
        if (endMultiplyingPower.compareTo(startMultiplyingPower) > 0) {
            multiplyingPower = endMultiplyingPower;
        }

        start = start.multiply(multiplyingPower);
        end = end.multiply(multiplyingPower);

        Long random = random(start.longValue(), end.longValue());

        BigDecimal value = new BigDecimal(random).divide(multiplyingPower);
        return value;
    }

        private static Integer getMultiplyingPower(BigDecimal start) {
        if (start.compareTo(new BigDecimal(start.intValue())) == 0) {
            return 1;
        }
        Integer multiplyingPower = 1;
        while (start.compareTo(new BigDecimal(start.intValue())) > 0) {
            start = start.multiply(new BigDecimal(10));
            multiplyingPower *= 10;
        }
        return multiplyingPower;
    }

    public static long random(long start, long end) {
        return (long) (Math.random() * (end - start + 1)) + start;
    }
}
