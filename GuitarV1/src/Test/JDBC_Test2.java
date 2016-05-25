package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test2 {
	// ������̬ȫ�ֱ���
    static Connection conn;
 
    static Statement st;
 
    public static void main(String[] args) {
        insert();   //������Ӽ�¼
        query();    //��ѯ��¼����ʾ
    }
     
    /* �������ݼ�¼���������������ݼ�¼��*/
    public static void insert() {
         
        conn = getConnection(); // ����Ҫ��ȡ���ӣ������ӵ����ݿ�
 
        try {
            String sql = "INSERT INTO guitar(serialNumber, price, builder,model, type, backWood, topWood)"
                    + " VALUES ('55514', 3000, 'Ted', 'HH', 'electric', 'Alex', 'Wood')";  // �������ݵ�sql���
             
            st = (Statement) conn.createStatement();    // ��������ִ�о�̬sql����Statement����
             
            int count = st.executeUpdate(sql);  // ִ�в��������sql��䣬�����ز������ݵĸ���
             
            System.out.println("��guitar���в��� " + count + " ������"); //�����������Ĵ�����
             
            conn.close();   //�ر����ݿ�����
             
        } catch (SQLException e) {
            System.out.println("��������ʧ��" + e.getMessage());
        }
    }
     
    /* ���·���Ҫ��ļ�¼�������ظ��µļ�¼��Ŀ*/
    /*public static void update() {
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
        try {
            String sql = "update guitar set wage='2200' where serilNumber = 'V95693'";// �������ݵ�sql���
             
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����
             
            int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���
             
            System.out.println("guitar���и��� " + count + " ������");      //������²����Ĵ�����
             
            conn.close();   //�ر����ݿ�����
             
        } catch (SQLException e) {
            System.out.println("��������ʧ��");
        }
    }*/
 
    /* ��ѯ���ݿ⣬�������Ҫ��ļ�¼�����*/
    public static void query() {
         
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
        try {
            String sql = "select * from guitar";     // ��ѯ���ݵ�sql���
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����
             
            ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����
            System.out.println("���Ĳ�ѯ���Ϊ��");
            while (rs.next()) { // �ж��Ƿ�����һ������
                 
                // �����ֶ�����ȡ��Ӧ��ֵ
                String serialNumber = rs.getString("serialNumber");
                double price = rs.getInt("price");
                String builder = rs.getString("builder");
                String model = rs.getString("model");
                String type = rs.getString("type");
                String backWood = rs.getString("backWood");
                String topWood = rs.getString("topWood");
                 
                //����鵽�ļ�¼�ĸ����ֶε�ֵ
                System.out.println(serialNumber + " " + price + " " + builder + " " + model
                        + " " + type + " " + backWood + " " + topWood);
             
            }
            conn.close();   //�ر����ݿ�����
             
        } catch (SQLException e) {
            System.out.println("��ѯ����ʧ��");
        }
    }
 
  
    /* ��ȡ���ݿ����ӵĺ���*/
    public static Connection getConnection() {
        Connection con = null;  //���������������ݿ��Connection����
        try {
            Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������
             
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/guitar", "root", "123456");// ������������
             
        } catch (Exception e) {
            System.out.println("���ݿ�����ʧ��" + e.getMessage());
        }
        return con; //���������������ݿ�����
    }

}
