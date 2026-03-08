public class DBConnectionThread extends Thread{

    private String connection;
    private DBConnection dbConnection;

    DBConnectionThread(String connection, DBConnection dbConnection) {
        this.connection = connection;
        this.dbConnection = dbConnection;
    }
    @Override
    public void run() {
        if (connection.equals("pqr.com")) {
            this.dbConnection.setNumberOfConnections("10");
            DBConnection.setConnection(this.connection); // t1 - goes inside static fn               // t2 - waits for t1 to release lock for static fn
        } else {
            DBConnection.setConnection(this.connection); // t1 - goes inside static fn               // t2 - waits for t1 to release lock for static fn
            this.dbConnection.setNumberOfConnections("10"); // t1  - executes this non-static fn     // t2
        }
    }
}
