package twitter;

public class Main {
    public static void main(String[] args) {
        Client client = new MicrowaveOven(new ServerImpl());
        client.tweet(new Message());
        String debug = "";
    }
}
