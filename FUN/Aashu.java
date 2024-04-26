package FUN;

public class Aashu {
    public static void main(String[] args) {
        System.out.println(Aashu.factorial(6));
    }
    
    public static int factorial(int num)
{
	if(num == 1)
		return 1;
	else
		return num * factorial (num-1);
} 

}
