

public class Hello {
/*    public static void main(String[] args) throws IOException {
        System.out.println("Say Hello ");
        *//*两数求和*//*
        System.out.println("请输入一个整数：");
        final byte t[] = new byte[10];
        System.in.read(t);
        final String sl = new String(t);
        final int a = Integer.parseInt(sl.trim());
        System.out.println("请输入一个小数：");
        System.in.read(t);
        final String s2 = new String(t);
        final double b = Double.parseDouble(s2.trim());
        // 处理数据
        final double c = a + b;
        System.out.println("计算结果为：" + c);
    }*/

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //如果数组为空，或者数组长度是0，直接返回
        if (null == nums || nums.length == 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

}
