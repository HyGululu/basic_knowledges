package mayibishi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedPacketHandle {
    /**
     * 红包分配算法
     *
     * @param amount
     * @param num
     * @param unit
     * @return
     */
    public static List<BigDecimal> makePackates(BigDecimal amount, Integer num, Integer unit) {
        if (num == 1) {
            return new ArrayList<BigDecimal>(Arrays.asList(amount));
        }
        List<BigDecimal> prs = new ArrayList<BigDecimal>();

        BigDecimal minAmount = new BigDecimal(Math.pow(10, -unit)).setScale(unit, RoundingMode.DOWN);

        BigDecimal randomStart = new BigDecimal(num);
        BigDecimal randomEnd = amount.divide(minAmount);
        for (int i = 0; i < num; i++) {
            prs.add(RandomUtil.random(randomStart, randomEnd));
        }
        BigDecimal totalPr = prs.stream().map(item -> item).reduce(BigDecimal.ZERO, BigDecimal::add);
        totalPr.setScale(unit * 2, RoundingMode.DOWN);
        List<BigDecimal> packages = new ArrayList<BigDecimal>();

        BigDecimal surplus = amount;
        for (BigDecimal pr : prs) {
            if (pr == prs.get(prs.size() - 1)) {
                packages.add(surplus.setScale(unit, RoundingMode.DOWN));
                continue;
            }
            BigDecimal value = amount.multiply(pr).divide(totalPr, unit * 2, RoundingMode.DOWN).setScale(unit,
                    RoundingMode.DOWN);
            surplus = surplus.subtract(value);
            packages.add(value);

        }
        return packages;
    }

    public static void main(String[] args) {
        /**
         * 红包金额
         */
        BigDecimal amount = new BigDecimal(100);

        /**
         * 红包个数
         */
        Integer num = 10;

        /**
         * 数值精度(小数位数)
         */
        Integer unit = 2;

        List<BigDecimal> list = makePackates(amount, num, unit);

        for (BigDecimal line : list) {
            System.out.println(line);
        }
    }

}
