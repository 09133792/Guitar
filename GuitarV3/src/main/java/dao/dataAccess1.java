package dao;

public class dataAccess1 {
	
	private static String daoName = "sqliteDao";

	public static IInstrument createInstrumentDao() {
		IInstrument result = null;
		try {
			Object o = Class.forName(daoName + "." + "InstrumentImpl").newInstance();
			result = (IInstrument)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
