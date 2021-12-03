import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char wt[] = new char[32*n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            String hexstr = sc.next();
            Long x = Long.parseLong(hexstr.substring(2),16);//从第2个字符开始截取
            String a1 = toBin(x);
            for (int k = 0; k < a1.length(); k++) {
                wt[j] =  a1.charAt(k);
                j++;

            }
        }
        bitmap_show(wt);
        for (int i = 0; i < 25; i++) {
            for (int k = 0; k < wt.length; k++) {
                if (wt[k]=='0'){
                    wt[k] = '1';
                    System.out.println("Allocation:"+k);
                    bitmap_show(wt);
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            int ss = sc.nextInt();
            for (int k = 0; k < wt.length; k++) {
                if (wt[ss]=='1'){
                    wt[ss]='0';
                    System.out.println("free:"+ss);
                    bitmap_show(wt);
                    break;
                }else {
                    System.out.println("Error：try to free unused block:"+k+"!");
                    break;
                }
            }
        }

    }

    public static void bitmap_show(char s[]){
        System.out.println("===============================================================================================");
        System.out.println("31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9  8  7  6  5  4  3  2  1  0");
        for (int i = 0; i < s.length; i++) {
            if ((i+1)%32==0){
                System.out.println(s[i]);
            }else{
                System.out.print(s[i] + "  ");
            }
        }
        System.out.println("===============================================================================================");
    }

    public static String toBin(Long num) {
        char[] chs = new char[Integer.SIZE];
        for (int i = 0; i < Integer.SIZE; i++) {
            chs[Integer.SIZE - 1 - i] = (char) ((num >> i & 1) + '0');
        }
        return new String(chs);
    }
}
