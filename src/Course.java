import java.util.ArrayList;

public class Course
{
	private String nameCourse;
	private int creditHours;
	private ArrayList<Course> prerequisite; 
	
	public Course()
	{
		creditHours = 0;
		nameCourse = null;
		prerequisite = new ArrayList<Course>();
	}
	
	public void setCreditHours(int c)
	{
		this.creditHours = c;
	}
	
	public int getCreditHours()
	{
		return creditHours;
	}
	
	public void setCourseName(String n)
	{
		this.nameCourse = n;
	}
	
	public String getName()
	{
		return nameCourse;
	}
	
	public void setPrereqs(ArrayList<Course> p)
	{
		this.prerequisite = p;
	}
	
	public ArrayList<Course> getPrereqs()
	{
		return prerequisite;
	}
	
	public String generateCourse()
	{
		String s = "";
		for(int i = 0; i < prerequisite.size();i++)
		{
			if(prerequisite.get(i).getName().equals(""))
			{
				s = "none";
			}
			else
			{
				s = s + prerequisite.get(i).getName();
			}
			
		}
		return nameCourse+" Credit Hours: "+creditHours+" Prerequisites: "+s;
	}
	
	public String toString()
	{
		return nameCourse+" "+creditHours+" "+prerequisite;
	}
	
	public String toButton()
	{
		String s = "";
		String courseNumber = "";
		String courseName = "";
		if(nameCourse.equals("MTH 105"))
		{
			courseNumber = nameCourse.substring(0, 6);
		}
		else
		{
			courseNumber = nameCourse.substring(0, 6);
			//courseName = nameCourse.substring(7,s.length());
		}
			
		s = courseNumber+"\n"+courseName;
		return nameCourse.substring(0, 7);
	}
}
