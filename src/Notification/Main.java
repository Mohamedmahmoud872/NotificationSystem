package Notification;

public class Main {

    public static void main(String[] args) {
        Template template = new Template();
        String tem = template.read("Email Confirmation");
        System.out.println(tem);
    }
}
