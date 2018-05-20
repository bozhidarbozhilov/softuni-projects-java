import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p05_1_Message_v1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String inputStr = scanner.nextLine();
        LinkedHashMap<String, User> users = new LinkedHashMap<>();

        while(!inputStr.equals("exit")){
            String[] inputTokens = inputStr.split("\\s+");
            if(inputTokens[0].equals("register")){
                String userName = inputTokens[1];
                users.putIfAbsent(userName,new User(userName));
            }else{
                String sender= inputTokens[0];
                String recipient = inputTokens[2];
                String content = inputTokens[3];

                if(users.containsKey(sender)&&users.containsKey(recipient)){
                    User senderName = new User(sender);
                    users.get(recipient).receivedMessages.add(new Message(senderName,content));
                }
            }
            inputStr = scanner.nextLine();
        }
        String[] chatParticipants = scanner.nextLine().split(" ");
        String chatSender = chatParticipants[0];
        String chatRecipient = chatParticipants[1];

        ArrayList<Message> senderMessages = users.get(chatRecipient)
                .receivedMessages.stream()
                .filter(m->m.getSender().getUserName().equals(chatSender))
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Message> recipientMessages = users.get(chatSender)
                .receivedMessages.stream()
                .filter(m->m.getSender().getUserName().equals(chatRecipient))
                .collect(Collectors.toCollection(ArrayList::new));

        int index = 0;
        if(senderMessages.isEmpty()&&recipientMessages.isEmpty()){
            System.out.println("No messages");
        }

        while(index < senderMessages.size() && index < recipientMessages.size()){
            System.out.printf("%s: %s%n",chatSender,senderMessages.get(index).getContent());
            System.out.printf("%s :%s%n",recipientMessages.get(index).getContent(),chatRecipient);
            index++;
        }

        while(index<senderMessages.size()){
            System.out.printf("%s: %s%n",chatSender,senderMessages.get(index).getContent());
            index++;
        }
        while(index<recipientMessages.size()){
            System.out.printf("%s :%s%n",recipientMessages.get(index).getContent(),chatRecipient);
            index++;
        }
    }
}
class Message{
    private User sender;
    private String content;

    public Message(User senderIn, String contentIn){
        this.sender = senderIn;
        this.content = contentIn;
    }
    public User getSender(){return sender;}
    public String getContent(){return content;}
}
class User{

    private String userName;
    public ArrayList<Message> receivedMessages;

    public User(String name){
        this.userName = name;
        this.receivedMessages = new ArrayList<>();
    }

    public String getUserName(){return userName;}
    public ArrayList getReceivedMessages(String name){return receivedMessages;}
}
