public class Messenger {
    public static void main(String[] arg){
        System.out.println("Message send to the user!");
        Messenger message = new Messenger();
        message.sendMessage();
    }
    public void sendMessage(){
        System.out.println("Send message from method");
    }
}
