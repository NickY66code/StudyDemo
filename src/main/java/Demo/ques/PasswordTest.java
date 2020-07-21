package Demo.ques;

import java.util.Scanner;

public class PasswordTest {
    public static final String STRONG_PWD="^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";
    public String pwdCheck(String checks){
        //密码长度不能小于8
        if (checks.length()<8){
            return "NO";
        }
        //密码开头不能为数字
        if (checks.charAt(0)>='0'&&checks.charAt(0)<='9'){
            return "NO";
        }

        //密码至少由大写字母，小写字母和数字这三种字符类型中的两种
        int count1 = 0,count2=0,count3=0;
        for (int i=0;i<checks.length();i++){
            if (checks.charAt(i)>'0'&&checks.charAt(i)<'9'){
                count1=1;
            }
            if (checks.charAt(i)>'a'&&checks.charAt(i)<'z'){
                count2=1;
            }
            if (checks.charAt(i)>'A'&&checks.charAt(i)<'Z'){
                count3=1;
            }
        }

        if ((count1+count2+count3)>=2){
            return "YES";
        }else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        System.out.print("请输入要检验的密码个数: ");
        int num=sc1.nextInt();
        System.out.print("请输入多组密码(以空格隔开): ");
        Scanner sc2=new Scanner(System.in);
        String str=sc2.nextLine();
        String[] arr=str.split(" ");
        PasswordTest passwordTest=new PasswordTest();
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i].matches(STRONG_PWD));
            //System.out.println("输出结果"+passwordTest.pwdCheck(arr[i]));
        }
    }

}
