import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://1.94.15.19:8083/empdb?useUnicode=true&characterEncoding=utf-8";
    private static final String username = "root";
    private static final String PASSWORD ="3100880856";

    protected static Connection conn = null;
    protected static PreparedStatement ps = null;
    private static ResultSet rs = null;

    //连接数据库

    public  void getConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, username, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //释放资源
    public void connClose(){
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }

            if (conn != null) {
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
