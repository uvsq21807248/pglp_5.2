package gplg_52;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TestGroupDao {

	@Test
	public void testCreat() throws IOException {

		DAO<CompositePersonnels> goupdao = FactoryDAO.getGroupeDAO();
		Personnel p1 = new Personnel.Builder(13, "ATMANI", "Hajar",
				LocalDate.parse("1996-03-20", DateTimeFormatter.ISO_DATE)).build();
		CompositePersonnels groupe = new CompositePersonnels(1);
		groupe.addPersonnel(p1);
		goupdao.create(groupe);

	}

	@Test
	public void testRead() throws IOException, ClassNotFoundException {

		DAO<CompositePersonnels> goupdao = FactoryDAO.getGroupeDAO();
		CompositePersonnels p;
		Personnel p1 = new Personnel.Builder(13, "ATMANI", "Hajar",
				LocalDate.parse("1996-03-20", DateTimeFormatter.ISO_DATE)).build();
		CompositePersonnels groupe = new CompositePersonnels(2);
		groupe.addPersonnel(p1);
		goupdao.create(groupe);
		p = goupdao.read(2);
		assertTrue(p.getId() == 2);

	}

}
