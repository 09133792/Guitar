package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class GuitarDao {
	
	public static void addGuitar(Guitar guitar){
		
		//连接数据库
		Connection conn=DBAccess.getConnection();
		
		String str="INSERT INTO guitar(serialNumber, price, builder,model, type, backWood, topWood) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(str);
			ps.setString(1,guitar.getSerialNumber());
			ps.setDouble(2,guitar.getPrice());
			ps.setString(3,guitar.getBuilder());
			ps.setString(4,guitar.getModel());
			ps.setString(5,guitar.getType());
			ps.setString(6,guitar.getBackWood());
			ps.setString(7,guitar.getTopWood());
			int flag=ps.executeUpdate();
			if(flag>0){
				System.out.println("fffffff");
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public static Guitar getGuitarByNum(String Number) {
		//连接数据库
		Connection conn=DBAccess.getConnection();
		String sql="select * from guitar where serialNumber=?";
		PreparedStatement ps;
		Guitar guitar = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,Number);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String serialNumber=rs.getString("serialNumber");
				Double price=rs.getDouble("price");
				String builder=rs.getString("builder");
				String model=rs.getString("model");
				String type=rs.getString("type");
				String backWood=rs.getString("backWood");
				String topWood=rs.getString("topWood");
				guitar=new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
				System.out.println("su");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return guitar;
	}
	
	/*public static Guitar search(Guitar guitar) {
		//连接数据库
		Connection conn=DBAccess.getConnection();
		String sql="select * from guitar where serialNumber like %"+"?"+"%";
		PreparedStatement ps;
		Guitar guitar2 = null;
		try {
			ps = conn.prepareStatement(sql);
			if(guitar.getSerialNumber()!=null){
				ps.setString(1,guitar.getSerialNumber());
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					String serialNumber=rs.getString("serialNumber");
					Double price=rs.getDouble("price");
					String builder=rs.getString("builder");
					String model=rs.getString("model");
					String type=rs.getString("type");
					String backWood=rs.getString("backWood");
					String topWood=rs.getString("topWood");
					guitar2=new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
					System.out.println("su");
				}
			}
			ps.setString(1,guitar);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String serialNumber=rs.getString("serialNumber");
				Double price=rs.getDouble("price");
				String builder=rs.getString("builder");
				String model=rs.getString("model");
				String type=rs.getString("type");
				String backWood=rs.getString("backWood");
				String topWood=rs.getString("topWood");
				guitar2=new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
				System.out.println("su");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return guitar2;
	}*/	
}
