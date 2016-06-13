package testSqliteDao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class InstrumentImplTest {

	@Test
	public void test(){
		sqliteDao.InstrumentImpl impl = new sqliteDao.InstrumentImpl();
		assertEquals(impl.getAllInstruments().size(),4);
	}


}
