package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.*;

import dao.IInstrument;
import util.DBUtil;

public class InstrumentImpl implements IInstrument {

	@Override
	public List<Instrument> getAllInstruments(){
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "select * from Instrument";
		List<Instrument> inventory = new ArrayList<Instrument>();
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Map<String, Enum> properties = new HashMap<String, Enum>();
				properties.put("builder",  Builder.fromString(rs.getString("builder")));
				properties.put("backWood", Wood.fromString(rs.getString("backWood")));
				properties.put("topWood", Wood.fromString(rs.getString("topWood")));
				properties.put("style", Style.fromString(rs.getString("style")));
				properties.put("type", Type.fromString(rs.getString("type")));
				InstrumentSpec spec = new InstrumentSpec(properties);
				
				Instrument instrument = new Instrument(rs.getString("serialNumber"),rs.getDouble("price"),spec);
				inventory.add(instrument);				
			}			
			rs.close();
			pstmt.close();
			Conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e){
		    e.printStackTrace();	
		}finally{
			try{
		         if(Conn!=null)
		        	 Conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		return inventory;
	}
}
