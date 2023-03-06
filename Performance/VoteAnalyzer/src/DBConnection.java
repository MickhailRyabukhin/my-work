import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    private static int recordsCount = 0;
    private static int totalRecords = 0;
    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "Voblya1!";
    private static StringBuilder insertQuery = new StringBuilder();
    private static long start;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + dbName +
                                "?user=" + dbUser + "&password=" + dbPass + "&useSSL=false&serverTimezone=UTC");
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "`count` INT NOT NULL, " +
                        "PRIMARY KEY(id)) ");
                // При трех запросах время составило 8672, 8562, 8567, 8671,8644
                // При использовании одного запроса и фуункции ON DUPLICATE KEY UPDATE
                // время выполнения составило 6934, 6774, 6810, 7122, 6918
                // При использовании executeMultiInsert  752,844,785,1067,810
                // с использованием DOM - парсера для файла 1 Мб
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        start = System.currentTimeMillis();
        return connection;
    }

    public static void executeMultyinsert() throws SQLException {
        String sql = "INSERT INTO voter_count(name, birthDate, `count`)" +
                " VALUES" + insertQuery.toString() +
                "ON DUPLICATE KEY UPDATE count=count+1";
        connection.createStatement().execute(sql);
        totalRecords += recordsCount;
        System.out.print("Прочитано " + totalRecords + " записей за " +
                (System.currentTimeMillis() - start) + " мс \n");
    }

    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');
        insertQuery.append((insertQuery.length() == 0 ? "" : ",") + "('" + name + "', '" + birthDay + "', 1)");
        recordsCount++;
        if (recordsCount > 50000)
        // 50_000 - время 146270, 500000 - 148739, 1 000 000 - 164602, 10 000 - 154140
        // Оптимальный объем буфера 40 000 - 50 000.
        {
            executeMultyinsert();
            recordsCount = 0;
            insertQuery.delete(0, insertQuery.length());
        }
    }

    public static int getTotalRecords() {
        return totalRecords;
    }
}
