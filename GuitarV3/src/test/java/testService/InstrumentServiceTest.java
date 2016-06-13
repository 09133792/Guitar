package testService;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.IInstrument;
import dao.dataAccess;
import dao.dataAccess1;
import model.Instrument;

public class InstrumentServiceTest {

	@Test
	public void test() {
		IInstrument i = dataAccess1.createInstrumentDao();
		List<Instrument> list = i.getAllInstruments();
		assertEquals(list.size(),4);
	}

}
