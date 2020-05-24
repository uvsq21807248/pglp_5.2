package gplg_52;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class CompositePersonnels implements InterfacePersonnel,Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	List<InterfacePersonnel> listperso= new ArrayList<InterfacePersonnel>();
	public void print() {
		// TODO Auto-generated method stub
		
		System.out.print("Id de groupe " +id);
		
		for(InterfacePersonnel pres:listperso ) {
			pres.print();
		}
	}
	
	public int getId() {
		return id;
	}

	

	public CompositePersonnels(int id) {
		super();
		this.id = id;
	}

	public CompositePersonnels addPersonnel(InterfacePersonnel inP) {
		this.listperso.add(inP);
		return this;
	}
	public CompositePersonnels removePersonnel(InterfacePersonnel inP) {
		this.listperso.remove(inP);
		return this;
	}
	
	public String toString(){
		  
		  return " Composite groupe id : " + this.id;
	}

}

