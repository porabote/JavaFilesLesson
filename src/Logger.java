public class Logger {

    private static StringBuilder logs = new StringBuilder("");

    public static void write(String $msg) {
        logs.append($msg + "\n");
    }

    public static String get() {
        return logs.toString();
    }
}
