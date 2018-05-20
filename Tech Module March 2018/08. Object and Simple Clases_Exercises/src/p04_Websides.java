import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p04_Websides {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputStr = scanner.nextLine();

        ArrayList<String> queries = new ArrayList<>();
        ArrayList<Website> websites = new ArrayList<>();

        while (!inputStr.equals("end")) {
            String[] inputTokens = inputStr.split(" \\| ");
            String host = inputTokens[0];
            String domain = inputTokens[1];


            if (inputTokens.length > 2) {
                    queries = Arrays.stream(inputTokens[2].split(","))
                            .collect(Collectors.toCollection(ArrayList::new));
                websites.add(Website.parseWebQuery(host,domain,queries));
                }else {
                websites.add(Website.parseWeb(host, domain));
            }

            inputStr = scanner.nextLine();
        }

        websites.stream()
                .forEach(w->{
                    System.out.printf("https://www.%s.%s",w.getHost(),w.getDomain());
                    if(w.getQueries().size()>0){
                        System.out.print("/query?=");
                        System.out.println(w.getQueries().stream()
                                .map(q->q = "["+q+"]")
                                .collect(Collectors.joining("&")));
                    }
                });
    }
}
class Website{
    private String host;
    private String domain;
    private ArrayList<String> queries;

    public Website(String hostIn, String domainIn, ArrayList<String> queriesIn){
        this.host = hostIn;
        this.domain = domainIn;
        this.queries = queriesIn;
    }

    public static Website parseWeb(String host,String domain){
        return new Website(host,domain,new ArrayList<>());
    }
    public static Website parseWebQuery(String host,String domain, ArrayList<String> queries){
        return new Website(host,domain,queries);
    }
    public String getHost(){ return host; }
    public String getDomain(){ return domain; }
    public ArrayList<String> getQueries() { return queries; }
}
