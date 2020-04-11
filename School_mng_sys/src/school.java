import java.sql.*;
import java.util.Scanner;


public class school {
	public class Person{
		int contact;
		String name;
		String RegNo; 
	public String getName() {
		System.out.println("Your name is" + name);
		return name;
		
	}
	public String getRegno() {
		System.out.println("Your regestration number is" + RegNo);
		return RegNo;
		
	}
	public int getContact() {
		System.out.println("Your contact is" + contact);
		return contact;
		
	}
	}
	public class Admin extends Person{
		private void createTableS() {
			
            Connection con = null;
			
    		String url = "jdbc:mysql://localhost:3306/skool?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    		try {
    			con = DriverManager.getConnection(url,"root","");
    			String query = " CREATE TABLE lecturer(id INT NOT NULL AUTO_INCREMENT = 4000,name VARCHAR(255) NOT NULL,idnum VARCHAR(255) NOT NULL,PRIMARY KEY(id));"
    					+ "CREATE TABLE students(ID INT NOT NULL AUTO_INCREMENT = 1000,name VARCHAR(255) NOT NULL,program VARCHAR(255) NOT NULL,PRIMARY KEY(ID));"
    					+ "CREATE TABLE course(ID INT NOT NULL AUTO_INCREMENT = 3000,name VARCHAR(255) NOT NULL,time INT NOT NULL,lecturer_name VARCHAR(255) NOT NULL,PRIMARY KEY(id));"
    					+ "CREATE TABLE take_course(course_id INT REFERENCES course(ID) ,student_id INT REFERENCES student(ID),grade CHAR,lecturer_id INT REFERENCES lecturer(id));";
    			PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.execute();
                System.out.println("YOU'VE CREATED TABLES SUCCESSFULLY!!!!");
                con.close();	
    		}catch(SQLException ex) {
    			System.out.println("SQLExceptiona: "+ ex.getMessage());
    		}
			
		}
		private void addLecturers(String lec_name,String idnum) {
            Connection con = null;
			
    		String url = "jdbc:mysql://localhost:3306/skool?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    		try {
    			    con = DriverManager.getConnection(url,"root","");
    			    String query = "INSERT INTO lecturer(name,idnum) VALUES(?,?);";
    			    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(2, idnum);
                    preparedStmt.setString (1,lec_name);
                    preparedStmt.execute();
               
                    System.out.println("SUCCESSFULL!!"); 
    			con.close();	
    			}catch(SQLException ex) {
    			System.out.println("SQLExceptiona: "+ ex.getMessage());
    		}
    		
			
		}
		private void addStudents(String stud_name,String program) {
			Connection con = null;
				
	    	String url = "jdbc:mysql://localhost:3306/skool?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    	try {
	    			con = DriverManager.getConnection(url,"root","");
	    		    String query = "INSERT INTO students(name,program) VALUES(?,?);";
	    		    PreparedStatement preparedStmt = con.prepareStatement(query);
	                preparedStmt.setString  (1,stud_name);
	                preparedStmt.setString (2,program);
	                preparedStmt.execute();
	                System.out.println("SUCCESSFULL!!");
	    		 con.close();
	    		}catch(SQLException ex) {
	    			System.out.println("SQLExceptiona: "+ ex.getMessage());
	    		}
	    		
		}
		private void addcourses(String course_name,int time,String lecturer) {
			Connection con = null;
			
	    	String url = "jdbc:mysql://localhost:3306/skool?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    	try {
	    			con = DriverManager.getConnection(url,"root","");
	    		    String query = "INSERT INTO course(name,time,lecturer_name) VALUES(?,?,?)";
	    		    PreparedStatement preparedStmt = con.prepareStatement(query);	
	                preparedStmt.setString  (1,course_name);
	                preparedStmt.setInt(2,time);
	                preparedStmt.setString (3,lecturer);
	                preparedStmt.execute();
	                System.out.println("SUCCESSFULL!!");
	    		con.close();
	    		}catch(SQLException ex) {
	    			System.out.println("SQLExceptiona: "+ ex.getMessage());
	    		}
			
		}
	   
	}
    public class Lecturer extends Person{
    	
    	
    	public void viewData(int lecturer_id) {
    		Connection con = null;
    		String url = "jdbc:mysql://localhost:3306/skool?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    		try {
    			String query = "SELECT name,student_id,course_id,lecturer_id,grade FROM students,take_course WHERE students.id = take_course.student_id AND lecturer_id = ?;";
    			con = DriverManager.getConnection(url,"root","");
    			PreparedStatement stmt1 = con.prepareStatement(query);
    			stmt1.setInt(1,lecturer_id);
                ResultSet rs1 = stmt1.executeQuery();
                System.out.println("NAME       |STUDENT ID|Course ID|GRADE  |Lecturer ID ");
                while ( rs1.next() ) {
                	String course_id = rs1.getString("course_id");
                    String student_id = rs1.getString("student_id");
                    String grade = rs1.getString("grade");
                    String name = rs1.getString("name");
                    String lec_name = rs1.getString("lecturer_id");
                    System.out.println(name +"        " +student_id +"   " + course_id + "   " + grade + "  " + lec_name);
                      
                }
  
                con.close();	
    		}catch(SQLException ex) {
    			System.out.println("SQLExceptiona: "+ ex.getMessage());
    		}
    		
    	}

		private void assignMarks(int stud_id,int course_id,String studgrade){
			
			Connection con = null;
			
    		String url1 = "jdbc:mysql://localhost:3306/skool?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    		try {
    			con = DriverManager.getConnection(url1,"root","");
    			String query = "UPDATE take_course SET grade = ? WHERE student_id = ? AND course_id = ?";
    			PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString  (1, studgrade);
                preparedStmt.setInt (2,stud_id);
                preparedStmt.setInt(3, course_id);
                preparedStmt.execute();
                System.out.println("YOU'VE UPDATED DATA SUCCESSFULLY!!");
                con.close();	
    		}catch(SQLException ex) {
    			System.out.println("SQLExceptiona: "+ ex.getMessage());
    		}
    		
		}
    	
    	
    }
    public class Student extends Person{
    	
    	
    	public void viewMarks(int student) {
    		Connection con = null;
    		String url = "jdbc:mysql://localhost:3306/skool?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    		try {
    			String query = "SELECT name,student_id,course_id,grade FROM students,take_course WHERE students.id = take_course.student_id AND student_id=?;";
    			con = DriverManager.getConnection(url,"root","");
    			PreparedStatement stmt = con.prepareStatement(query);
    			stmt.setInt(1, student);
                ResultSet rs1 = stmt.executeQuery();
                System.out.println("NAME       |STUDENT ID|Course ID|GRADE ");
                while ( rs1.next() ) {
                	String course_id = rs1.getString("course_id");
                    String student_id = rs1.getString("student_id");
                    String grade = rs1.getString("grade");
                    String name = rs1.getString("name");
                    System.out.println(name +"        " +student_id +"   " + course_id + "   " + grade);
                      
                }
  
                con.close();	
    		}catch(SQLException ex) {
    			System.out.println("SQLExceptiona: "+ ex.getMessage());
    		}
    		
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		school sc = new school();
		Person per = sc.new Person();
		Admin adm = sc.new Admin();
		Student stud = sc.new Student();
		Lecturer lec = sc.new Lecturer();
		
		System.out.println("-----------SCHOOL MANAGEMENT SYTEM-------------");
		System.out.println("1.ADMIN\n2.LECTURER\n3.STUDENT \n");
		System.out.println("PLease select");
		
		Scanner choice = new Scanner(System.in);
		int cho = choice.nextInt();
		if (cho==1) {
			System.out.println("1.CREATE TABLES\n2.ADD NEW LECTURERS\n3.ENROLL NEW STUDENTS\n4.ADD NEW COURSE");
			System.out.println("PLease select");
			int admin = choice.nextInt();
			if (admin==1) {
				adm.createTableS();
				
		     }
			else if(admin==2) {
				Scanner nam = new Scanner(System.in);
				System.out.println("ENTER LECTURERS NAME: ");
				String lec_name = nam.next();
				System.out.println("ENTER LECTURERS WORKNO: ");
				String lec_num = nam.next();
				
				adm.addLecturers(lec_name,lec_num);
			}
			else if (admin==3) {
				Scanner nam = new Scanner(System.in);
				System.out.println("ENTER STUDENTS NAME: ");
				String stud_name = nam.next();
				System.out.println("ENTER PROGRAM: "); 
				String program = nam.next();
				adm.addStudents(stud_name, program);
			}
			else if (admin==4) {
				Scanner nam = new Scanner(System.in);
				System.out.println("ENTER COURSE NAME: ");
				String course_name = nam.next();
				System.out.println("ENTER LECTURER NAME: ");
				String lecname = nam.next();
				System.out.println("ENTER TIME FOR THE COURSE: ");
				int time = nam.nextInt();
			}
		}
		
		else if (cho ==2) {
			System.out.println("1.UPDATE MARKS\n2.VIEW MARKS");
			System.out.println("PLease select");
			
			int lec1 = choice.nextInt();
			if (lec1==1) {
				System.out.println("Enter Lecturer ID: ");
				int lecturer_id = choice.nextInt();
				lec.viewData(lecturer_id);
					
				System.out.println("Select students ID:  ");
				Scanner stud2 = new Scanner(System.in);
				int id = stud2.nextInt();
				
				System.out.println("Select Course ID:  ");
				Scanner course_id = new Scanner(System.in);
				int course = course_id.nextInt();
					
				System.out.println("Enter Student grade: ");
				String score = choice.next();
					
	 			lec.assignMarks(id,course,score);
	 			lec.viewData(lecturer_id);
				
			}
			else if(lec1==2) {
				System.out.println("Enter Lecturer ID: ");
				int lecturer_id = choice.nextInt();
				lec.viewData(lecturer_id);
						
			}
			else {
				System.out.println("INVALID CHOICE"); 
				
			}
		}
		else if (cho==3) {
				System.out.println("1.VIEW MARKS");
				
				int stud1 = choice.nextInt();
				if(stud1==1) {
					System.out.println("Select students ID:  ");
					Scanner stud2 = new Scanner(System.in);
					int id = stud2.nextInt();
					stud.viewMarks(id);	
			}
				else {
					System.out.println("INVALID INPUT!!!!!!");
				}
		}
			
			
		}
		
	}



