class Logger {

    HashMap<String, Integer> printedMap;

    public Logger() {
        printedMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (printedMap.containsKey(message)) {
            int initTimeStamp = printedMap.get(message);
            if (timestamp - initTimeStamp >= 10) {
                printedMap.put(message, timestamp);
                return true;
            }else {
                return false;
            }
        }
        else {
            printedMap.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
