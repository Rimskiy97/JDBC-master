
import java.sql.*;



public class test3 {
    public static Connection  myTest;

    public static void main(String[] args) throws SQLException, NullPointerException {

        try {

            /** Подлючаемся к БД **/

            myTest = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/dexautomation", "dexautomation", "dexautomation");
            myTest.createStatement();
            System.out.println("Успешно подключено к БД");
        } catch (SQLException e) {
            System.out.println("Не могу подключиться к БД, проверьте логин и пароль!");
            e.printStackTrace();
        }

        /** Создаю запрос к БД**/
        Statement request1 = myTest.createStatement();
        String SQLAdd = "INSERT INTO Students(firstName, lastName, age, phone) VALUES (?, ?, ?, ?)"; // запрос на добавление данных
        try {
            PreparedStatement addToSQL = myTest.prepareStatement(SQLAdd);
            addToSQL.setString(1, "Vasya");
            addToSQL.setString(2, "Pupkin");
            addToSQL.setString(3, "23");
            addToSQL.setString(4, "89121337568");
            addToSQL.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Не удалось внести данные, проверьте введенные данные!");
            e.printStackTrace();
        }
        String SQLcheckout = "SELECT * FROM Students WHERE firstName = ? AND lastName = ? AND age = ? AND phone = ?";
        try {
            PreparedStatement checkInSQL = myTest.prepareStatement(SQLcheckout);
            checkInSQL.setString(1, "Rim");
            checkInSQL.setString(2, "Khabibullin");
            checkInSQL.setString(3, "22");
            checkInSQL.setString(4, "89170467568");
            ResultSet resultSet = request1.executeQuery(SQLcheckout);
        }
        catch (SQLException e) {
            System.out.println("Не удалось проверить внесенные данные:\n ");
            System.out.println(e.getMessage());
        }
    }
}
//        String userName = "dexautomation";
//        String password = "dexautomation";
//        String connectionUrl = "jdbc:mysql://db4free.net:3306/dexautomation";
