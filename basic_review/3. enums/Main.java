package org.example;

public class Main {
    public enum Grade {
        // 優先定義列舉實例，傳入二個參數
        A(9, "優異"),
        B(8, "佳"),
        C(7, "良好"),
        D(6, "普通"),
        F(5, "略差"),
        INCOMPLETE(4, "多努力");  // ’;’分號為必要，不可少

        // 新屬性需寫在列舉實例之後
        private int score;
        private String description;

        // 建構子預設為 private，可寫可不寫；不能定義為public
        // 建構子有二個參數
        Grade(int score, String desc) {
            this.score = score;
            this.description = desc;
        }

        public int getScore() {
            return score;
        }

        public String getDescription() {
            return description;
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int score = Grade.A.getScore(); //9
        String desc = Grade.A.getDescription(); //優異
        System.out.println(score + desc);
        int retValue =  Grade.INCOMPLETE.compareTo(Grade.D); //回傳值為正整數2(5-3=2)，表示大於Grade.D
        System.out.println(retValue);

        Grade[] grades = Grade.values(); //陣列長度為6，陣列內容為[Grade.A, Grade.B, Grade.C, Grade.D, Grade.F, Grade.INCOMPLETE]
        for (Grade grade : grades) {
            System.out.println(grade.score);
        }
    }
}
