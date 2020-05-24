package gplg_52;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerGroupeDAO extends DAO<CompositePersonnels> {
	
	public CompositePersonnels create(CompositePersonnels obj)  {
		// TODO Auto-generated method stub
		
		
		try (FileOutputStream fout = new FileOutputStream("groupe.ser");ObjectOutputStream out = new ObjectOutputStream(fout) ;){
			
			
	    	out.writeObject(obj) ; 
	    	out.close() ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}

	public CompositePersonnels read(Integer id) throws FileNotFoundException  {
		CompositePersonnels groupe=null;
	
		try(FileInputStream fileInput = new FileInputStream("groupe.ser");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInput);) {
			
	        
	        groupe = (CompositePersonnels) objectInputStream.readObject();
	        objectInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return groupe;
	}

	public CompositePersonnels update(CompositePersonnels obj) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		
		
		try (FileOutputStream fout = new FileOutputStream("groupe.ser") ;
    	      ObjectOutputStream out = new ObjectOutputStream(fout);){

			out.writeObject(obj) ;
			out.close() ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
		return obj;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
	}

}
