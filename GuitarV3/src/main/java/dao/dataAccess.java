package dao;

public class dataAccess {
	private static String db = "sqlite";

	public static IInstrument createInstrumentDao() {
		IInstrument result = null;
		switch (db) {
		case "sqlite":
			result = new sqliteDao.InstrumentImpl();
			break;
		case "mysql":
			result = new mysqlDao.InstrumentImpl();
			break;

		}
		return result;
	}

	public static IUser createUserDao() {
		IUser ret = null;
		switch (db) {
		case "sqlite":
			ret = new sqliteDao.UserImpl();
			break;
		case "mysql":
			ret = new mysqlDao.UserImpl();
			break;
		}
		return ret;

	}
}
