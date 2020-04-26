import java.util.ArrayList;

public class Semester 
{
	private boolean semesterName;//fall == true, spring == false
	private ArrayList<Course> semesterCourses;
	private int year;
	
	public Semester()
	{
		semesterName = false;
		semesterCourses = new ArrayList<Course>();
		year = 0;
	}
	
	public void setSemesterName(boolean s)
	{
		this.semesterName = s;
	}
	
	public boolean getSemesterName()
	{
		return semesterName;
	}
	
	public void setYear(int y)
	{
		this.year = y;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setSemesterCourses(ArrayList<Course> semester)
	{
		this.semesterCourses = semester;
	}
	
	public ArrayList<Course> getSemesterCourses()
	{
		return semesterCourses;
	}
	
	public int addUpCreditHours(ArrayList<Course> semester)
	{
		int creditHours = 0;
		
		for(int i = 0; i<semester.size();i++)
		{
			creditHours = creditHours + semester.get(i).getCreditHours();
		}
		
		return creditHours;
	}
	
	public String toString()
	{
		String s = "";
		
		if(semesterName)
		{
			s = "Fall "+year+"\n";
		}
		else
		{
			s = "Spring "+year+"\n";
		}
		
		for(int i = 0; i< semesterCourses.size();i++)
		{
			s = s + semesterCourses.get(i).generateCourse()+"\n";
		}
		
		return s;
	}
}
