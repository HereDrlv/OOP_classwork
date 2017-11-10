package displaySystem_OOPclasswork;

import java.util.ArrayList;

public class Activity {

	
	private String title;
	private String time;
	private String place;
	private String brief;
	private String ps;
	private ArrayList<Society> organizers;
	
	static 	private ArrayList<Activity> activities = new ArrayList<Activity>();
	//全局。用于储存从csv文件中读取得的社团信息 


	public Activity(String title, String time, String place, String brief, String ps) {
		this.title = title;
		this.time = time;
		this.place = place;
		this.brief = brief;
		this.ps = ps;
	};

	public static void addActivity(Activity a) {
		Activity.activities.add(a);
	}
	
	
	
	
	//setter&getter:
	public static ArrayList<Activity> getActivities(){
		return Activity.activities;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public ArrayList<Society> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(ArrayList<Society> organizers) {
		this.organizers = organizers;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}
	//.
	

	
}
