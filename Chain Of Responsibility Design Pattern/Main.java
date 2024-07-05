package ChainOfResponsibilityPattern;


public class Main {

    public static void main(String args[]) {

        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logObject.log(LogProcessor.ERROR, "Exception Happenend");
        logObject.log(LogProcessor.DEBUG, "Need To Debug This");
        logObject.log(LogProcessor.INFO, "Just For Info");

    }
}
