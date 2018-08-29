package twitter;

public class MicrowaveOven implements Client {
    private Server server;

    public MicrowaveOven(Server server) {
        this.server = server;
    }

    public void tweet(Tweet tweet) {
        String tweetMessage = tweet.retrieveMessage();
        System.out.println(tweetMessage);
        this.server.receiveMessage(tweetMessage);
    }
}
