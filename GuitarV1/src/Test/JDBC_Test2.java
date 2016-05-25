package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test2 {
	// 创建静态全局变量
    static Connection conn;
 
    static Statement st;
 
    public static void main(String[] args) {
        insert();   //插入添加记录
        query();    //查询记录并显示
    }
     
    /* 插入数据记录，并输出插入的数据记录数*/
    public static void insert() {
         
        conn = getConnection(); // 首先要获取连接，即连接到数据库
 
        try {
            String sql = "INSERT INTO guitar(serialNumber, price, builder,model, type, backWood, topWood)"
                    + " VALUES ('55514', 3000, 'Ted', 'HH', 'electric', 'Alex', 'Wood')";  // 插入数据的sql语句
             
            st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象
             
            int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数
             
            System.out.println("向guitar表中插入 " + count + " 条数据"); //输出插入操作的处理结果
             
            conn.close();   //关闭数据库连接
             
        } catch (SQLException e) {
            System.out.println("插入数据失败" + e.getMessage());
        }
    }
     
    /* 更新符合要求的记录，并返回更新的记录数目*/
    /*public static void update() {
        conn = getConnection(); //同样先要获取连接，即连接到数据库
        try {
            String sql = "update guitar set wage='2200' where serilNumber = 'V95693'";// 更新数据的sql语句
             
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量
             
            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数
             
            System.out.println("guitar表中更新 " + count + " 条数据");      //输出更新操作的处理结果
             
            conn.close();   //关闭数据库连接
             
        } catch (SQLException e) {
            System.out.println("更新数据失败");
        }
    }*/
 
    /* 查询数据库，输出符合要求的记录的情况*/
    public static void query() {
         
        conn = getConnection(); //同样先要获取连接，即连接到数据库
        try {
            String sql = "select * from guitar";     // 查询数据的sql语句
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量
             
            ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集
            System.out.println("最后的查询结果为：");
            while (rs.next()) { // 判断是否还有下一个数据
                 
                // 根据字段名获取相应的值
                String serialNumber = rs.getString("serialNumber");
                double price = rs.getInt("price");
                String builder = rs.getString("builder");
                String model = rs.getString("model");
                String type = rs.getString("type");
                String backWood = rs.getString("backWood");
                String topWood = rs.getString("topWood");
                 
                //输出查到的记录的各个字段的值
                System.out.println(serialNumber + " " + price + " " + builder + " " + model
                        + " " + type + " " + backWood + " " + topWood);
             
            }
            conn.close();   //关闭数据库连接
             
        } catch (SQLException e) {
            System.out.println("查询数据失败");
        }
    }
 
  
    /* 获取数据库连接的函数*/
    public static Connection getConnection() {
        Connection con = null;  //创建用于连接数据库的Connection对象
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动
             
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/guitar", "root", "123456");// 创建数据连接
             
        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
        return con; //返回所建立的数据库连接
    }

}
