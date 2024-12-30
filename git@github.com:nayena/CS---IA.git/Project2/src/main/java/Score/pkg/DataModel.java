package Score.pkg;

import java.io.File;
import java.io.FileInputStream;
import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataModel {

// private variables so not all external classes can have access to them
	    private String name;
	    private String residence;
	    private String origin;
	  private String atls; 
	  
	  private long lastInsertedId = -1; 
	
		private String subjects;
	    private String scores;
	    private String essay;
	    private String Uni; 
	    
	    public String getName1() {
			return Name1;
		}

		public void setName1(String name1) {
			Name1 = name1;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPassword1() {
			return password1;
		}

		public void setPassword1(String password1) {
			this.password1 = password1;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		private String Name1; 
	    private String lastName; 
	    private String password; 
	    private String password1; 
	    private String email; 
	    
	    
	    
	    private String comment; 
	    
	    public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		private String Accomp ; 
	    
	    //Instantiates the the column headers of the CALC table from the SQLite Database
	    
	    public String getAccomp() {
			return Accomp;
		}
	 
		public void setAccomp(String accomp) {
			Accomp = accomp;
		}

		   //Accessors - returns the values of an object state
		//This is for selected internal classes to access this private variables 
		public String getAtls() {
			return atls;
		}

		
		// Mutators - set the value of an object states
		public void setAtls(String atls) {
			this.atls = atls;
		}
		
	    
		public String getUni() {
			return Uni;
		}
		
		public void setUni(String Uni) {
			this.Uni = Uni;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getResidence() {
			return residence;
		}
		public void setResidence(String residence) {
			this.residence = residence;
		}
		public String getOrigin() {
			return origin;
		}
		public void setOrigin(String origin) {
			this.origin = origin;
		}
		public String getSubjects() {
			return subjects;
		}
		public void setSubjects(String subjects) {
			this.subjects = subjects;
		}
		public String getScores() {
			return scores;
		}
		public void setScores(String scores) {
			this.scores = scores;
		}
		public String getEssay() {
			return essay;
		}
		public void setEssay(String essay) {
			this.essay = essay;
		}

		public void setBinaryStream(FileInputStream inputStream, int length) {
			// TODO Auto-generated method stub
			
		}

		public long getLastInsertedId() {
			return lastInsertedId;
		}

		public void setLastInsertedId(long lastInsertedId) {
			this.lastInsertedId = lastInsertedId;
		}



	    // Getters and setters for the fields
	}


