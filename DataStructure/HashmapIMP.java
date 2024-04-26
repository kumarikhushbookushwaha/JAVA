package JAVA.DataStructure;

import java.util.HashMap;

public class HashmapIMP {

    public static void main(String[] args) {

        HashMap<String,Integer> empId =  new HashMap<>();

        empId.put("Ram" , 12345);
        empId.put("John" , 123);
        empId.put("Carl" , 345);

        System.out.println(empId);

        System.out.println(empId.containsKey("Ram")+", "+empId.containsValue(123));
    }
}
