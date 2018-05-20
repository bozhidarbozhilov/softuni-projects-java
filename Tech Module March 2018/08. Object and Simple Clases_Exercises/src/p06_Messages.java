import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;


public class p06_Messages {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> registeredUsers = new ArrayList<>();

        LinkedHashMap<String,User> users = new LinkedHashMap<>();

        String inputStr = scanner.nextLine();

        while(!inputStr.equals("exit")){
            String[] inputTokens = inputStr.split("\\s+");

            if(inputTokens[0].equals("register")){
                users.putIfAbsent(inputTokens[1], new User(inputTokens[1]));
            }else{
                String sender = inputTokens[0];
                String recipient = inputTokens[2];
                String messageContent = inputTokens[3];

                if(users.containsKey(sender)&&users.containsKey(recipient)) {
                    User senderUser = users.get(sender);
                    users.get(recipient).receivedMessages.add(new Message(senderUser,messageContent));

                }
            }
            inputStr = scanner.nextLine();
        }
        String[] userNames = scanner.nextLine().split("\\s+");
        String chatSender = userNames[0];
        String chatRecipient = userNames[1];

        ArrayList<Message> senderMessages = users.get(chatRecipient).receivedMessages.stream()
                .filter(m->m.getSender().getUserName().equals(chatSender)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Message> recipientMessages = users.get(chatSender).receivedMessages.stream()
                .filter(m->m.getSender().getUserName().equals(chatRecipient)).collect(Collectors.toCollection(ArrayList::new));

        int index = 0;

        if(senderMessages.isEmpty()&&recipientMessages.isEmpty()){
            System.out.println("No messages");
        }

        while(index<senderMessages.size()&&index<recipientMessages.size()){
            System.out.printf("%s: ",chatSender);
            System.out.println(senderMessages.get(index).getContent());
            System.out.print(recipientMessages.get(index).getContent());
            System.out.printf(" :%s%n",chatRecipient);
            index++;
        }

        while(index<senderMessages.size()){
            System.out.printf("%s: ",chatSender);
            System.out.println(senderMessages.get(index).getContent());
            index++;
        }
        while(index<recipientMessages.size()){
            System.out.print(recipientMessages.get(index).getContent());
            System.out.printf(" :%s%n",chatRecipient);
            index++;
        }
    }
}

