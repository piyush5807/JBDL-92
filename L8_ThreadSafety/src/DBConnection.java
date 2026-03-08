public class DBConnection {

    private static String connection = "";

    private String numberOfConnections;

    public synchronized static void setConnection(String connection){
        System.out.println("Inside setConnection entry section..., thread - " + Thread.currentThread());
//        synchronized (DBConnection.class) {
            System.out.println("Inside setConnection critical section..., thread - " + Thread.currentThread());
            DBConnection.connection = connection;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Exiting setConnection critical section..., thread - " + Thread.currentThread());
//        }
        System.out.println("Inside setConnection exit section..., thread - " + Thread.currentThread());
    }

    public void setNumberOfConnections(String numberOfConnections){
        synchronized (this) {
            this.numberOfConnections = numberOfConnections;
        }
    }

    public static String getConnection() {
        return connection;
    }
}
