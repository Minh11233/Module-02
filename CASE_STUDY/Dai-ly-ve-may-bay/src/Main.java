import Utils.MySQLConnection;
import View.LoginView;
public class Main {
    public static void main(String[] args) {
        //LoginView.LoginView();

        MySQLConnection mySQLConnection = new MySQLConnection();
        mySQLConnection.selectCustomer(1);
        mySQLConnection.selectStaff(1);
        mySQLConnection.selectFlightTicket(1);
        mySQLConnection.selectUsersInfo(1);
        mySQLConnection.selectRevenue(1);
    }
}
