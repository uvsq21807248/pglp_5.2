package gplg_52;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TestPersonnelDAO {

	@Test
	public void testcreate() throws IOException {
		DAO<Personnel> perDAO = FactoryDAO.getPersonneDAO();
		Personnel p1 = new Personnel.Builder(12, "ATMANI", "Hajar",
				LocalDate.parse("1996-20-03", DateTimeFormatter.ISO_DATE)).build();
		perDAO.create(p1);

	}

	@Test
	public void testRead() throws IOException, ClassNotFoundException {
		DAO<Personnel> perDAO = FactoryDAO.getPersonneDAO();
		Personnel p1 = new Personnel.Builder(13, "ATMANI", "Hajar",
				LocalDate.parse("1996-20-03", DateTimeFormatter.ISO_DATE)).build();
		perDAO.create(p1);
		Personnel p2;
		p2 = perDAO.read(13);
		assertTrue(p2.getId() == 13);

	}

}
