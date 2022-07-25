import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Main {

	private static Scanner in;
	
	public static boolean linearIn(String[] a, String b) {

		   //Return the values of arrays.
		   return Arrays.asList(a).contains(b); 
		}
	
	public static void main(String[] args) throws Exception{
		 in = new Scanner(new File("input.txt"));
	
		//ArrayList of papers
		ArrayList<Paper> Papers = new ArrayList<Paper>(); 
		//ArrayList of authors
		ArrayList<Author> authors = new ArrayList<Author>(); 
		String[] auth = in.nextLine().split(","); 
		 
		 System.out.println(Arrays.toString(auth));
		 System.out.println("");
		
		 while(in.hasNext()){
			 
			ArrayList<String> author = new ArrayList<String>(); 

		    ArrayList<String> coauther = new ArrayList<String>(); 
			 
			 String ID = in.next(); 
			 System.out.print(ID + " ");
			 String Title = in.next();
			 System.out.print(Title + " ");
			 
			 String Quartile = in.nextLine().replace(",", "").replace(" ", "");
			 System.out.println(Quartile + " ");
			 int quartile = Integer.parseInt(Quartile);
			 
			String[] authors1 = in.nextLine().replace(" ", "").split(",");  
			for (int c = 0; c < authors1.length ; c ++){ 
					System.out.println(authors1[c]);
					author.add(authors1[c]);		
			}
			
			String[] scores = in.nextLine().replace(" ", "").split(",");
			System.out.println(Arrays.toString(scores));
			System.out.println("");
			 
			//Converting scores to integer.
			int[] score = Arrays.stream(scores).mapToInt(Integer::parseInt).toArray(); 
	
			//Creating new paper object and add them to arraylist.
			Paper p = new Paper(ID, Title, quartile, author, coauther, score); 
			Papers.add(p);
		 }
		 
		 System.out.println("Total number of papers: "+ Papers.size());
		 System.out.println("");
		 
		 System.out.println("Calculating average score for each paper:");
		 System.out.println("");
		 
		 pSort(Papers,Papers.size()); 
		 
		 System.out.println("GPA of "+Papers.size()+" Papers is : "+ GPA(Papers, Papers.size()));

		 for (int i = 0; i < auth.length; i++ ){
			 ArrayList<Paper> authorp = new ArrayList<Paper>(); //Create a new ArrayList for each author
			 //to contain the papers associated with each one

			 System.out.println("");
			 
			 System.out.println("Papers written by " + auth[i] + ":"); 
			 
			 
		 for(Paper p : Papers){ 
				 
			 if(p.getAuthors() != null && p.getAuthors().contains(auth[i])) {
				  
			System.out.println("Paper Title: " +p.getTitle() +" Paper ID: "+ p.getID() + " REF = "+ p.getREF()+ ", Average Score = "+ p.getavg());
			
			 }  
		 }
		
			//Creating a new author object.
		Author autherobj = new Author(auth[i], authorp); 
	        
		//Add the new author object to the list of main authors.
	    authors.add(autherobj); 
			 
	    //By the use of pSort method, show how many papers 
	    int xN = 5;
	    pSort(authors.get(i).Authorpapers,xN);
		}
		
		 int x = authors.size();
		 int n = (int) Math.ceil(x * 2.5); // 2.5 Times the amount of authors,  converted to an int, then rounded UP
		 System.out.println("");
		 System.out.println("Number of best papers: "+ n);
		 System.out.println("Showing the " + n + " papers:");
		 System.out.println("");
		 
		 int papersort_ = pSort(Papers,n); //As shown below, PapSort returns an int value, so the result of the function can be stored as a variable
		 Double gpa = GPA(Papers,papersort_); //Same with the GPA, but returns a Double. Feed the value of papsort_ into the GPA function
		 System.out.println("GPA of top "+ n +" papers = "+gpa);
	}

	public static int pSort(ArrayList<Paper> paperstoSort, int N){
		//Sort the Papers
		Collections.sort(paperstoSort); 
		
		if (N <= paperstoSort.size()) {
		 for (int i = 0 ; i < N; i++)
		 {
			if (i+1 < N) {

			//To check if the average scores of current paper is equal to the next paper, then checks if the quartile of current paper is larger than the next paper.
		    if (paperstoSort.get(i).getavg() == paperstoSort.get(i+1).getavg()) { 
					 
			if (paperstoSort.get(i).getQuartile() > paperstoSort.get(i+1).getQuartile()){
				//Swaps their position in the array.
				Collections.swap(paperstoSort, i, i+1); //Put the next position's paper in the place of the current paper
			}
		    }
			}
	
		System.out.println("Title: " + paperstoSort.get(i).getTitle());
	    System.out.println("Avrage Score: " + paperstoSort.get(i).getavg()+ ", REF = " +paperstoSort.get(i).getREF() + ", Quartile = " + paperstoSort.get(i).getQuartile());
	    System.out.println("");
		 }
		}
		
		return N; //N value returned as an int
	 }
	
	public static double GPA (ArrayList<Paper> papers, int n){
		
		double gpa = 0;
		double sum = 0;
		
		if (n <= papers.size()){
		
			for(int i = 0; i < n; i++){
				
				sum += papers.get(i).getREF();  
			}
			gpa = sum/n; 
		}
		
		if (n > papers.size()){
			
			for(int i = 0; i < papers.size(); i++) 
			{
				sum += papers.get(i).getREF();
			}
			gpa = sum/papers.size();
		}
		return gpa;	
	}
}