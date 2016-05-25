package DAO;

import java.util.List;

public interface IGuitarDao {

	void addGuitar(Guitar guitar) throws Exception;

	Guitar getGuitarByNum(Guitar guitar);

	void delete(Guitar guitar);

	void update(Guitar guitar);

	List<Guitar> search();

}
