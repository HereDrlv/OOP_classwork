package displaySystem_OOPclasswork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class displaySystemTEST {

	public static void main(String[] args) throws IOException{
		readData();//读取csv文件数据。新建Society与Activity类的数据，并将相关活动与社团双向绑定在对方属性中
	
		
		//Display 照片墙展示功能演示
		
			//1.每社团随机选2张照片播放
			//Display.showImg(Display.randomlySelectImg(),Display.randomlySelectImg());
		 
		
		//Interaction 用户交互功能演示：
			//2.主界面上显示所有社团与活动
			//Interaction.showIndexPage();
	  		//3.查找社团。
	  		//Society.search("");//若填空字符串则显示所有社团
			//Society.search("协会");//若填入内容则按名称搜索
			//3.6.7.查找活动与条件筛选
			//Activity.search("赛","","");//第一个参数为按名称搜索
			//Activity.search("","2011","");//第二个参数为按时间筛选。输入格式为年.月.日。筛选出输入时间之后的活动
			//Activity.search("","","散打社");//第三个参数为按相关社团筛选。
			//Activity.search("","","")//三个参数均可填可不填。不填则无筛选，多填则多条件筛选
			//5.用户点击对应活动时显示详细信息
	        //Activity.showActicityDetails(Activity.getActivityByName("星座书上"));//可填任意活动名。模拟用户点击
			//4.用户点击对应社团时显示详细信息
			//Society.showSocietyDetails(Society.getSocietyByName("散打社")); //可填任意社团名。模拟用户点击。

        
		//Administration 后台功能演示：
			
			//8.查看社团全部成员			
			//Administration.viewMembers("话剧社");//可填任意社团名。
			//9.按成员数量对社团进行排序
			//Society.search("");//显示排序前的社团名单
			//Administration.rankSocietyByMemberNumber();
			//Society.search("");//显示排序后的社团名单
			//10.按举办活动次数对社团进行排序
			//Administration.rankSocietyByActivityNumber();
			//Society.search("");//显示排序后的社团名单			
			//11.修改备注信息。
			//Administration.editInformation("升龙拳教学", "主讲人：王老师。国家一级运动员。前世锦赛冠军");//可对应填写任意社团名，及修改后的备注内容
			//System.out.println(Activity.getActivityByName("升龙拳教学").getPs());//显示修改后的备注内容
			 
		
	}
	
	
	
	
	static void readData() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/活动表.csv"));
        reader.readLine();//skip the head
        String line = null; 
        line=reader.readLine();

        while((line=reader.readLine())!=null) {
       	 String item[] = line.split(",");
       	 Activity.addActivity(new Activity (item[0],item[1],item[2],item[3],item[5]));
        }
        reader.close();      
         
        reader=new BufferedReader(new FileReader("src/社团表.csv"));
        reader.readLine();//skip the head
        line = null; 

        while((line=reader.readLine())!=null) {
       	 String item[] = line.split(",");
       	 Society newSociety=new Society (item[0],item[1],item[2],item[3],item[4],item[5],item[7]);
       	 Society.addSociety(newSociety);
	         
       	 for(int i=0;i<Activity.getActivities().size();i++) {
	        	 Activity iActivity=Activity.getActivities().get(i);
	        	 String activityTitle =iActivity.getTitle();       		 
	        	 String pattern = ".*"+activityTitle+".*";//RegularExpression
	        	 if ( Pattern.matches(pattern, item[6])) {
	        		 if(null==newSociety.getRelatedActivities()) {
	        			 ArrayList<Activity> newActArray=new ArrayList<Activity>();
	        			 newActArray.add(iActivity);
	        			 newSociety.setRelatedActivities(newActArray);
	        		 }else{
	        			 newSociety.getRelatedActivities().add(iActivity);
	        		 }
	        	 }
       	 }
       	 for(int j=0 ; j<newSociety.getRelatedActivities().size(); j++) {
       		 Activity jActivity=newSociety.getRelatedActivities().get(j);
       		 if(null==jActivity.getOrganizers()) {
       			 ArrayList<Society> newOgnzrs= new ArrayList<Society>();
       			 jActivity.setOrganizers(newOgnzrs);
       			 jActivity.getOrganizers().add(newSociety);
       		 }
       		 else {        			 
       		 jActivity.getOrganizers().add(newSociety);
       		 }
       	 }
       	 
        }
        reader.close();
	        
	};

}
