package org.example;
import java.util.Comparator;

public class Main {

    public static void main(String args[]){
    RoleName teacher;
//    由於會自動去看teacher中inteface有哪個函數，是一個參數並且為String，如果有則不會報error，
//       並且定義這個函數(outPutName)
    teacher = (String name) ->{
        System.out.println(name);
    };
    teacher.outPutName("小白");
    }
}
interface RoleName{
    void outPutName(String test);
}