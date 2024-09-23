package Tasks;

import java.util.Scanner;

public class Calculator {
   public static void main(String[] args) {
   

  String input []= Calculator.input();

  System.out.println("Answer= " +  Calculator.function(input));

   }
   
   private static int function(String [] input) {
    int result=0;
    int num1= Integer.parseInt(input[0]);
    int num2= Integer.parseInt(input[1]);
  
    char operator= input[2].charAt(0);




    switch (operator) {
        case '+':

                result = num1+num2;
            
            break;
            case '-':

                result = num1-num2;
            
            break;
            case '*':

                result = num1*num2;
            
            break;
            
                case '/':
                {
                    try{
                        result = num1/num2;
                        
                    }
                    catch(Exception e){
                        System.out.println(e);
                        
                    }
            
                
            }
            
            
            
            break;
            case '%':

                result = num1%num2;
            
            break;
     
        default:
            break;
    }
    

    return result;  
}
public static String[] input(){

    String input[]= new String[3] ;

   Scanner scanner= new Scanner(System.in);
   System.out.println("Enter first number");
   int num1=scanner.nextInt();

   System.out.println("Enter second number");
   int num2=scanner.nextInt();
  
   System.out.println("Enter operator");
   char operator =scanner.next().charAt(0);
 
   scanner.close();
   input[0]= Integer.toString(num1);
   input[1]= Integer.toString(num2);
   input[2]=Character.toString(operator);
   return input;

   }


}
