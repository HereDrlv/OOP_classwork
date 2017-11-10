package displaySystem_OOPclasswork;

import java.util.ArrayList;

public class Society {
	private String name;
	private	String birthday;
	private String leader;
	private String tel;
	private String mail;
	private String members;
	private String brief;
	private ArrayList<Activity> relatedActivities;

 	static private ArrayList<Society> societies = new ArrayList<Society>();
 	//全局。用于储存从csv中读取得的社团
 	public Society(String name, String birthday, String leader, String tel,String mail, String members , String brief) {
 		this.name = name;
 		this.birthday = birthday;
 		this.leader = leader;
 		this.tel = tel;
 		this.mail = mail;
 		this.setMembers(members);
 		this.brief = brief;
 	}
 	
 	
 	
 	//<setter&getter>
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}



	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public ArrayList<Activity> getRelatedActivities() {
		return relatedActivities;
	}

	public void setRelatedActivities(ArrayList<Activity> relatedActivities) {
		this.relatedActivities = relatedActivities;
	}

	public static void addSociety(Society a) {
		Society.societies.add(a);
	}
	
	public static ArrayList<Society> getSocieties(){
		return Society.societies;
	}

	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getMembers() {
		return members;
	}



	public void setMembers(String members) {
		this.members = members;
	}

	//</setter&getter>


}
