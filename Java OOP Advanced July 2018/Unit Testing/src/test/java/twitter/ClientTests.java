package twitter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.System.*;
import static javax.management.Query.in;

public class ClientTests {
    private static final String TARGET_INTERFACE = "Client";
    public static final String EXTECTED_OUTPUT_STRING = "Test";
    private Client client;
    private ServerImpl server;
    private Tweet messageMock;

    @Before
    public void initClient(){
        this.server = new ServerImpl();
        this.client = new MicrowaveOven(this.server);
        this.messageMock = Mockito.mock(Message.class);
        Mockito.when(messageMock.retrieveMessage()).thenReturn("Test");
    }

    @Test
    public void microwaveShouldImplementsClientInterface() throws ClassNotFoundException {
        Class<?> clientClass = MicrowaveOven.class;
        Class<?>[] interfaces = clientClass.getInterfaces();
        String microwaveovenInterface = interfaces[0].getSimpleName();
        Assert.assertEquals(TARGET_INTERFACE, microwaveovenInterface);
    }

    @Test
    public void receiveMessagesFromTweetAndSentToServer(){
        this.client.tweet(messageMock);
        String receivedMessageFromServer = this.server.getMessages().get(0);
        Assert.assertEquals(EXTECTED_OUTPUT_STRING, receivedMessageFromServer);
    }


    /* TODO More Tests*/


}
