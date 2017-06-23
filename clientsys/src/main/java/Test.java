import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;

/**
 * Created by jb.liang on 2017/6/22.
 */
public class Test {

    public static Log LOGGER = LogFactory.getLog(Test.class);

//    public static Connection conn;
//
//    static {
//        String url = "jdbc:mysql://localhost:3306/clientsys" ;
//        String username = "root" ;
//        String password = "root" ;
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(url, username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static Connection getSqlConnection(){
//        if(conn != null){
//            return conn;
//        }
        return null;
    }

    public static int findAllCount(String tableName) {
//        Connection con = getSqlConnection();
//        if(con == null){
//            LOGGER.info("数据源获取失败！");
//            return 0;
//        }
//        try {
//            PreparedStatement ps = con.prepareStatement("select count(*) allcount from " + tableName);
//            ResultSet rs = ps.executeQuery();
//            if(rs != null){
//                while(rs.next()){
//                    return rs.getInt("allcount");
//                }
//            }
//        } catch (SQLException e) {
//            //e.printStackTrace();
//            LOGGER.error("数据库交互出错！", e);
//        }
        return 0;
    }

    public static void main(String[] str) {
        //int allCount = findAllCount("um_company");
        //System.out.println(allCount);
        RunnableTest rt = new RunnableTest();
        Thread t = new Thread(rt);
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }

}
