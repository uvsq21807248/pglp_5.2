package gplg_52;

public class FactoryDAO extends AbstractFactoryDAO {

	@Override
	public DAO<Personnel> getPersonneDAO() {
		return new PersonnelDAO();

	}

	@Override
	public DAO<CompositePersonnels> getGroupeDAO() {
		return new GroupeDAO();

	}

}
