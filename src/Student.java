import java.util.ArrayList;

public class Student 
{
	private String nameFirst;
	private String nameLast;
	private int studentID;
	private String username;
	private String password;
	private String trackName;
	private ArrayList<Course> completedCourses;
	
	public Student()
	{
		nameFirst = null;
		nameLast = null;
		studentID = 0;
		username = null;
		password = null;
		trackName = null;
		completedCourses = new ArrayList<Course>();
	}
	
	public void setNameFirst(String n)
	{
		this.nameFirst = n;
	}
	
	public String getNameFirst()
	{
		return nameFirst;
	}
	
	public void setNameLast(String n)
	{
		this.nameLast = n;
	}
	
	public String getNameLast()
	{
		return nameLast;
	}
	
	public void setStudentID(int s)
	{
		this.studentID = s;
	}
	
	public int getStudentID()
	{
		return studentID;
	}
	
	public void setUserName(String u)
	{
		this.username = u;
	}
	
	public String getUserName()
	{
		return username;
	}
	
	public void setPassword(String p)
	{
		this.password = p;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setTrackName(String t)
	{
		this.trackName = t;
	}
	
	public String getTrackName()
	{
		return trackName;
	}
	
	public void setCompletedCourses(ArrayList<Course> c)
	{
		this.completedCourses = c;
	}
	
	public ArrayList<Course> getCompletedCourses()
	{
		return completedCourses;
	}
	
	public String outputCompletedCourses()
	{
		String s = "";
		for(int i = 0;i<completedCourses.size();i++)
		{
			s = s + completedCourses.get(i).generateCourse()+"\n";
		}
		return s;
	}
	
	

}
