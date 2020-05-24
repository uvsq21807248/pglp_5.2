package gplg_52;

public class SerializeFactoryDAO extends AbstractFactoryDAO {
	
	
	@Override
	public DAO<Personnel> getPersonneDAO() {

		return new SerpersonnelDAO();

		
	}

	@Override
	public DAO<CompositePersonnels> getGroupeDAO() {
		// TODO Auto-generated method stub
		return new SerGroupeDAO();
	}

	

	

	

}
