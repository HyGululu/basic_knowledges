package algorithm;

import org.junit.jupiter.api.Test;

public class FenZhiSolution {

    /**
     * IPv4 和 IPv6 地址均是由特定的分界符隔开的字符串组成，并且每个子字符串具有相同格式
     * 因此，可以将地址分为多个块，然后逐块进行验证。
     * 仅当每个块都有效时，该地址才有效。这种方法称为 *分治法*
     * *算法**
     * - 对于 IPv4 地址，通过界定符 `.` 将地址分为四块；对于 IPv6 地址，通过界定符 `:` 将地址分为八块。
     * - 对于 IPv4 地址的每一块，检查它们是否在 `0 - 255` 内，且没有前置零。
     * - 对于 IPv6 地址的每一块，检查其长度是否为 `1 - 4` 位的十六进制数。
     */
    //验证IPv4
    public String validateIPv4(String IP) {
        String[] split = IP.split("\\.", -1);
        for (String str : split) {
            // Validate integer in range (0, 255):
            // 1. length of chunk is between 1 and 3
            if (str.length() == 0 || str.length() > 3) {
                return ">3 or <0  UnValidate";
            }
            // 2. no extra leading zeros
            if (str.charAt(0) == '0' && str.length() != 1) {
                return "0xx UnValidate";
            }
            // 3. only digits are allowed
            for (char ch : str.toCharArray()) {
                //检查其参数是否为十进制数字字符
                if (!Character.isDigit(ch)) {
                    return "not digits UnValidate";
                }
            }
            // 4. less than 255
            if (Integer.parseInt(str) > 255) {
                return ">255 UnValidate";
            }
        }
        return IP + "  is IPv4";
    }

    @Test
    public void validateIPv4Test() {
        //String ip ="0.0.0.0";
        //String ip ="192.168.68.113";
        //String ip ="192.168.68.";
        //String ip ="192.168.68.1234";
        //String ip ="192.168.68.1234";
        //String ip ="192.168.68.abc";
        String ip = "192.168.68.256";
        String result = validateIPv4(ip);
        System.out.println(result);
    }

    //验证IPv6
    public String validateIPv6(String IP) {
        String[] split = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String str : split) {
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (str.length() == 0 || str.length() > 4) {
                return ">4 或 =0 UnValidate v6";
            }
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (char ch : str.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) {
                    return "not 0-9, a-f, A-F digits UnValidate v6";
                }

            }
        }
        return IP + "  is IPv6";
    }

    @Test
    public void validateIPv6Test() {
        //String ip ="fe80::50f8:f6ff:feab:5a39";
        String ip = "fe80::8cda:b5ff:fe3d:76f6";
        String result = validateIPv6(ip);
        System.out.println(result);
    }

    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        }
        return "error IPchar";
    }

}
