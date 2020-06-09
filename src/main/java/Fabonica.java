//递归算法的精髓就是把通项的计算方式写在方法里。fn = f(n-1)+ f(n-2),还有特列声明。n1=1，n2 =1.
public class Fabonica {

    public static void main(String[] args) {
        for (int i = 1;i<=11;i++){

            System.out.print(f(i) + "  ");
        }
    }

    public static int f(int n){
        if(n==1||n==2){
            return 1;
        }
        else{
            return f(n-1)+f(n-2);
        }
    }
}
