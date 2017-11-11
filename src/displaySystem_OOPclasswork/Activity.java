package displaySystem_OOPclasswork;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.GOTO;

public class Activity{

	
	private String title;
	private String time;
	private String place;
	private String brief;
	private String ps;
	private ArrayList<Society> organizers;
	
	static 	private ArrayList<Activity> activities = new ArrayList<Activity>();
	//ȫ�֡����ڴ����csv�ļ��ж�ȡ�õ�������Ϣ 


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

	public static void setActivities(ArrayList<Activity> activities){
		Activity.activities = activities;
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
	
	public static ArrayList<String> getActivityTitleList() {
		ArrayList<String> resultList=new ArrayList();
		for(Activity a : Activity.activities) {
			resultList.add(a.title);
		}
		return resultList;
	}
	static public Activity getActivityByName(String title){
		for(Activity a:Activity.getActivities()) {
			if(a.getTitle().equals(title)) {
				return a;
			}
		}
		return null;
	}
	
	public static void showActicityDetails(Activity goalActivity) {
		
		System.out.println("����⣺"+goalActivity.getTitle());
		System.out.println("�ʱ�䣺"+goalActivity.getTime());
		System.out.println("��ص㣺"+goalActivity.getPlace());
		System.out.println("��飺"+goalActivity.getBrief());
		System.out.println("��ע��"+goalActivity.getPs());
		for(Society o: goalActivity.getOrganizers()) {			
			System.out.println("�������ţ�"+o.getName());
		}

	}

	public static void search(String searchingTitle,String fTime,String fRAct) {
	     //������������������ʾ�����б� 
        ArrayList<String> searchResult=Interaction.searchByTitleOrName(Activity.getActivityTitleList(),searchingTitle);//INPUT
        //<filter>        
        	//filterByTime
        	ArrayList<String> filterResult= Interaction.filterActivityByTime(fTime);//INPUT ��������ɸѡЧ��
        	searchResult.retainAll(filterResult);
        	//filterByRelatedSociety
        	Society goalSociety=Society.getSocietyByName(fRAct);//INPUT ��������ɸѡЧ��
        	if(null!=goalSociety) {	
            	filterResult.clear();
	         	for(Activity a:goalSociety.getRelatedActivities()) {         		
	         		filterResult.add(a.getTitle());
	         	}
        	}
        	searchResult.retainAll(filterResult);
        //</filter>
        
        if(searchResult.isEmpty()) {
       	 System.out.println("δ�ҵ���������������");        	 
        }else {
       	 System.out.println("�ҵ��Ļ���£�");       
       	 for(int i=0;i<searchResult.size();i++) {        		 
       		 System.out.println(i+1+". "+searchResult.get(i));        	 
       	 }
        }
   //</searchViaNameOrTitle(withFilter)(also can show the whole list)>      

	}
}
