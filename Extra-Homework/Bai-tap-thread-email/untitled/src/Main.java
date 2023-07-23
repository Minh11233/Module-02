public class Main {
    public static void main(String[] args) {
        User user1 = new User("Minh@gmail.com",500);
        User user2 = new User("Lam@gmail.com",1500);
        User user3 = new User("Thai@gmail.com",3500);
        user1.start();
        user2.start();
        user3.start();
    }
}