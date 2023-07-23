public class User extends Thread {
    private String email;
    private int replyTime;
    private Thread myThread;

    public User() {
    }

    public User(String email, int replyTime) {
        this.email = email;
        this.replyTime = replyTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(int replyTime) {
        this.replyTime = replyTime;
    }

    public void sendMail(String email,int replyTime) {
        try {
            System.out.println(email);
            sleep(replyTime);
            System.out.println("Sent successfully to: " + getEmail());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        sendMail(this.getEmail(), this.getReplyTime());
    }
}
