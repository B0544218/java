package org.example;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String args[]){
        Map<String, Integer> nameToAgeMap = new HashMap<>();

        nameToAgeMap.put("Alice", 25);
        nameToAgeMap.put("Bob", 30);

        System.out.println("Alice's age: " + nameToAgeMap.get("Alice"));
        System.out.println("Bob's age: " + nameToAgeMap.get("Bob"));

//        Map map = new HashMap();
//        Map是一個接口，HashMap是具體的實現類。
//        由於接口是類的藍圖，是一個抽象的概念，不能被實例化，因此接口需要由具體的類來實現。
//        這條代碼指明：由HashMap類來實現接口Map中描述的方法。
//        HashMap map = new HashMap();
//        聲明一個HashMap類型的map，由HashMap類實現。
//        為什麼更推薦第一種用接口的聲明方式？
//        這個問題等同於為什麼要在編程中使用接口，而不是直接使用實現類。
//        其實這就是面對對象編程（OOP）的思想精髓。
        
//        簡單來說就是：上層接口描述的功能不變，下層的具體實現可以不斷修改替換。
//        上層的調用者只用知道map的功能，不必關心map的具體實現。
//        例如，某天開發人員開發出一個各方面性能都優於HashMap的SuperMap類，
//        則map可以直接改成由SuperMap來實現：Map map = new SuperMap()。
//        對於外部調用者來說，使用的還是那個map，殊不知底層實現的升級已經讓他們用上了優化版的map。
//        如果一開始就定義map為HasMap類型，無法做出這樣的優化，
//        很明顯HashMap map = new SuperMap() 是條錯誤的代碼。
//        這就是使用接口聲明的好處，增加系統靈活性，隔離性等。
    }
}
