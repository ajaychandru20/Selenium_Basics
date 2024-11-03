public class MethodPara {
    static String name = "Ajay";
    static int age = 24;
    public static void main(String[] arg){
        yourDetails(name, age);
        System.out.println(userName());
        System.out.println(addNum(2,3));

    }
    public static void yourDetails(String username,int usage){
    System.out.println("Hello," + username +
            ".You are " + usage + " Old!");
    }

    public static String userName(){
        return  "Ajay!";
    }
    public static int addNum(int number1, int number2){
        return  number1 + number2;
    }
}
