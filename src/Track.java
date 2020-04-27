import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Track
{
	private ArrayList<Course> trackCourses;
	private String trackName;
	
	public Track()
	{
		trackCourses = new ArrayList<Course>();
		trackName = null;
	}
	
	public void setTrackName(String n)
	{
		this.trackName = n;
	}
	
	public String getTrackName()
	{
		return trackName;
	}
	
	public void setTrackCourses(ArrayList<Course> t)
	{
		this.trackCourses = t;
	}
	
	public ArrayList<Course> getTrackCourses()
	{
		return trackCourses;
	}
	
	public String toString()
	{
		return trackName+" "+trackCourses;
	}
	
	public String outputingTrack()
	{
		String s = "";
		s = trackName+"\n";
		for(int i = 0;i<trackCourses.size();i++)
		{
			s = s + trackCourses.get(i).generateCourse()+"\n";
		}
		return s;
	}
	
	public void generateTrack(ResultSet dbTrack) throws SQLException
	{	
		
		System.out.println("inside generateTrack");
		while(dbTrack.next())
		{
			//System.out.println("past while");
			Course c = new Course();
			Course p1 = new Course();
			
			c.setCourseName(dbTrack.getString("CourseNum&Name"));
			//System.out.println("past course name");
			
			c.setCreditHours(dbTrack.getInt("CreditHour"));
			//System.out.println("past credithour");
			
			p1.setCourseName(dbTrack.getString("PreReq"));
			c.getPrereqs().add(p1);
			//System.out.println("past prereq");
			
			trackCourses.add(c);
			//System.out.println("added course");
		}
	}
}

