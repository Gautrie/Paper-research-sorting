import java.util.ArrayList;
import java.util.stream.IntStream;

public class Paper implements Comparable<Paper>{ //Allows for the Paper objects to be compared
	
	String ID;
	String Title;
	int Quartile;
	int[] Scores;
	int REF;
	ArrayList<String> Authors;
	ArrayList<String> Coauthors;
	
	
	public Paper(String id, String title, int quartile, ArrayList<String> authors, ArrayList<String> coauthors, int[] scores){
		ID = id;
		this.Title = title;
		this.Quartile = quartile;
		this.Authors = authors;
		this.Coauthors = coauthors;
		this.Scores = scores;
	}
	
	public String getID() {return ID;}

	public void setID(String iD) {ID = iD;}
	
	public String getTitle() {return Title;}

	public void setTitle(String title) {this.Title = title;}

	public ArrayList<String> getAuthors() {return Authors;}

	public void setAuthors(ArrayList<String> authors) {this.Authors = authors;}

	public ArrayList<String> getCoauthors() {return Coauthors;}

	public void setCoauthors(ArrayList<String> coauthors) {this.Coauthors = coauthors;}

	public int[] getScores() {return Scores;}

	public double getavg(){
	
		double sum = IntStream.of(this.Scores).sum(); //Add up all the values in the score array, then convert into double format
	
		return sum/this.Scores.length;	
	}
	
	
	public void setScores(int[] scores) {this.Scores = scores;}

	public int getQuartile() {return Quartile;}

	public void setQuartile(int quartile) {this.Quartile = quartile;}
	
	public void setREF(int REF) {this.REF = REF;}

	public int getREF()
	{
		
		if (this.getavg() >= 0 && this.getavg() <1) {
			this.REF = 0;
		}
		if (this.getavg() >= 1 && this.getavg() <4) {
			this.REF = 1;
		}
		if (this.getavg() >= 4 && this.getavg() <7) {
			this.REF = 2;
		}
		if (this.getavg() >= 7 && this.getavg() <10) {
			this.REF =  3;
		}
		if (this.getavg() >= 10 && this.getavg() <=12) {
			this.REF = 4;
		}
		return this.REF;
	}

	public int compareTo(Paper o) {
		return Double.compare(o.getavg(), this.getavg()); //Used by collections in order to compare and sort objects.
		//In this case we are comparing and sorting based in the Paper's Avg value
	
	}
}