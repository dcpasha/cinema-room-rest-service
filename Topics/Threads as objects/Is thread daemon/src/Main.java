class ThreadUtil {
    public static void printIfDaemon(Thread thread) {
        // implement logic
        if (thread.isDaemon()) {
            System.out.print("daemon");
        } else {
            System.out.print("not daemon");
        }
    }
}
