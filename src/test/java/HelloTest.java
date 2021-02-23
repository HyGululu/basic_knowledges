import org.junit.Test;

public class HelloTest {
    @Test
    public void twoSumTest() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int[] ints = Hello.twoSum(nums, 5);
        System.out.println("结果是？ " + ints[1]);
    }
}
