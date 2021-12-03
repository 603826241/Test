public class TTest {
    public static void main(String[] args) {
        String hex = "0xFEB65DFF";
        Long x = Long.parseLong(hex.substring(2),16);//从第2个字符开始截取
        System.out.println(toBin(x));
    }
    public static String toBin(Long num) {
        char[] chs = new char[Integer.SIZE];
        for (int i = 0; i < Integer.SIZE; i++) {
            chs[Integer.SIZE - 1 - i] = (char) ((num >> i & 1) + '0');
        }
        return new String(chs);
    }
}