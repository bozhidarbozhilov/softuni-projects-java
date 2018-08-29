package logger;

import logger.contollers.LoggerController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int appendersCount = Integer.parseInt(scanner.nextLine());

        LoggerController loggerController = new LoggerController(appendersCount);
        for (int i = 0; i < appendersCount; i++) {
            String[] loggerData = scanner.nextLine().split("\\s+");
            if(loggerData.length == 3){
                loggerController.createAppender(loggerData[0], loggerData[1], loggerData[2]);
            }else{
                loggerController.createAppender(loggerData[0], loggerData[1], "");
            }

        }

        loggerController.createLogger();
        String message = scanner.nextLine();
        while(!"END".equals(message)){
            loggerController.setLogger(message);
            message = scanner.nextLine();
        }

        loggerController.loggerInfo();
    }
}
