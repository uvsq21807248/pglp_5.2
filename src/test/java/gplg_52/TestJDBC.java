package gplg_52;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestJDBC {

	private Connection connection = null;
	private Statement statement;
	@SuppressWarnings("unused")
	private File db;

	@Before
	public void initialization() {

		db = new File("my_db");
		try {
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:derby:my_db;create=true");
			statement = connection.createStatement();

			String tablePersennel = "CREATE TABLE  PERSONNEL (id int PRIMARY KEY NOT NULL,nom varchar(50) , prenom  varchar(50), datenaissance DATE,fonction varchar(50))";
			statement.execute(tablePersennel);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	}

	@Test
	public void testCreateFindPersonnelDao() throws IOException, ClassNotFoundException {
		List<Integer> tels = new ArrayList<Integer>();
		DAO<Personnel> perDAO = AbstractFactoryDAO.getDAOFactory(AbstractFactoryDAO.DaoType.JDBC).getPersonneDAO();
		tels.add(456789328);
		tels.add(655638644);
		Personnel p1 = new Personnel.Builder(12, "aa", "jj", LocalDate.parse("1997-08-01", DateTimeFormatter.ISO_DATE))
				.addDateNumeroTelephone(tels).addFonction("developer").build();
		perDAO.create(p1);
		Personnel p2 = perDAO.read(p1.getId());
		assertNotNull(p2);
		System.out.println(p2.getTels());

	}

	@Test
	public void testDeletePersonnelDao() throws IOException, ClassNotFoundException {
		List<Integer> tels = new ArrayList<Integer>();
		DAO<Personnel> perDAO = AbstractFactoryDAO.getDAOFactory(AbstractFactoryDAO.DaoType.JDBC).getPersonneDAO();
		tels.add(456789328);
		tels.add(655638644);
		Personnel p1 = new Personnel.Builder(13, "nom", "prenom",
				LocalDate.parse("1996-03-20", DateTimeFormatter.ISO_DATE)).addDateNumeroTelephone(tels)
						.addFonction("developer").build();
		perDAO.create(p1);
		perDAO.delete(p1.getId());
		Personnel p2 = perDAO.read(p1.getId());
		assertNull(p2);

	}

	@Test
	public void testCreateFindGroupDao() throws IOException, ClassNotFoundException {
		List<Integer> tels = new ArrayList<Integer>();
		DAO<CompositePersonnels> grpDAO = AbstractFactoryDAO.getDAOFactory(AbstractFactoryDAO.DaoType.JDBC)
				.getGroupeDAO();
		tels.add(456789328);
		tels.add(655638644);
		Personnel p1 = new Personnel.Builder(23, "ATMANI", "Hajar",
				LocalDate.parse("1996-03-20", DateTimeFormatter.ISO_DATE)).addDateNumeroTelephone(tels)
						.addFonction("developer").build();
		CompositePersonnels groupe = new CompositePersonnels(516);
		CompositePersonnels groupe2 = new CompositePersonnels(617);
		groupe.addPersonnel(p1);
		groupe.addPersonnel(groupe2);
		grpDAO.create(groupe);
		CompositePersonnels g = grpDAO.read(groupe.getId());
		assertNotNull(g);
		System.out.println(g.listperso);

	}

	@Test
	public void testDeleteGroupeDao() throws IOException, ClassNotFoundException {
		List<Integer> tels = new ArrayList<Integer>();
		DAO<CompositePersonnels> grpDAO = AbstractFactoryDAO.getDAOFactory(AbstractFactoryDAO.DaoType.JDBC)
				.getGroupeDAO();
		tels.add(456789328);
		tels.add(655638644);
		Personnel p1 = new Personnel.Builder(23, "ATMANI", "Hajar",
				LocalDate.parse("1996-03-20", DateTimeFormatter.ISO_DATE)).addDateNumeroTelephone(tels)
						.addFonction("developer").build();
		CompositePersonnels groupe = new CompositePersonnels(516);
		CompositePersonnels groupe2 = new CompositePersonnels(617);
		groupe.addPersonnel(p1);
		groupe.addPersonnel(groupe2);
		grpDAO.create(groupe);
		grpDAO.delete(groupe.getId());
		CompositePersonnels g = grpDAO.read(groupe.getId());
		assertNull(g);
	}

}
