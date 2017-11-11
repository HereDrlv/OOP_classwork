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

	
	public static ArrayList<String> getSocietyNameList() {
		ArrayList<String> resultList=new ArrayList();
		for(Society a : Society.societies) {
			resultList.add(a.name);
		}
		return resultList;

	}

	static public Society getSocietyByName(String title){
		for(Society a:Society.getSocieties()) {
			if(a.getName().equals(title)) {
				return a;
			}
		}
		return null;
	}
	
	public static void showSocietyDetails(Society goalSociety) {
		
		System.out.println("社团名："+goalSociety.getName());
		System.out.println("建立时间："+goalSociety.getBirthday());
		System.out.println("负责人："+goalSociety.getLeader());
		System.out.println("联系电话："+goalSociety.getTel());
		System.out.println("邮箱："+goalSociety.getMail());
		System.out.println("简介："+goalSociety.getBrief());
		for(Activity o: goalSociety.getRelatedActivities()) {			
			System.out.println("相关活动："+o.getTitle());
		}

	}
	
	public static void search(String searchingName) {
		    //<searchViaNameOrTitle(withFilter)(also can show the whole list)>
	        //不填入搜索内容则显示完整列表

	        ArrayList<String> searchResult=Interaction.searchByTitleOrName(Society.getSocietyNameList(),searchingName);//INPUT
	        
	        if(searchResult.isEmpty()) {
	       	 System.out.println("未找到符合条件的内容");        	 
	        }else {
	       	 System.out.println("找到的社团如下：");       
	       	 for(int i=0;i<searchResult.size();i++) {        		 
	       		 System.out.println(i+1+". "+searchResult.get(i));        	 
	       	 }
	        }
	}
	
	
}
