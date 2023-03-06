import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static final String url= "jdbc:mysql://localhost:3306/skillbox";
    public static final String user = "root";
    public static final String password = "Voblya1!";

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            ResultSet dateRes = statement.executeQuery("SELECT month(max(subscription_date))" +
                    " - month(min(subscription_date)) FROM  purchaselist  LIMIT 0, 1000;" );
            int months=1;
            while (dateRes.next()){
                months = dateRes.getInt(1);
                System.out.println("Количество месяцев для расчета средних  равно "+ months);
                System.out.println();
            }
            String query="SELECT pl.course_name,count(pl.subscription_date)/"+months+
                    " FROM  Purchaselist pl  GROUP BY(pl.course_name);";
            ResultSet resultSet= statement.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString(2)+"\t"+
                        resultSet.getString(1);
                System.out.println(name);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
