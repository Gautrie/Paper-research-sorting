import java.util.ArrayList;

public class Author {
	
	String Name;
	ArrayList<Paper> Authorpapers;
	
	public Author(String name, ArrayList<Paper> authorpapers) {
		super();
		this.Name = name;
		this.Authorpapers = authorpapers;
	}

	public String getName(){return Name;}

	public void setName(String name){this.Name = name;}

	public ArrayList<Paper> getAuth_papers(){return Authorpapers;}

	public void setAuth_papers(ArrayList<Paper> auth_papers){this.Authorpapers = Authorpapers;}
}