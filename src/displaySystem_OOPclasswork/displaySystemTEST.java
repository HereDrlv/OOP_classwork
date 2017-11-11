package displaySystem_OOPclasswork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class displaySystemTEST {

	public static void main(String[] args) throws IOException{
		readData();//��ȡcsv�ļ����ݡ��½�Society��Activity������ݣ�������ػ������˫����ڶԷ�������
	
		
		//Display ��Ƭǽչʾ������ʾ
		
			//1.ÿ�������ѡ2����Ƭ����
			//Display.showImg(Display.randomlySelectImg(),Display.randomlySelectImg());
		 
		
		//Interaction �û�����������ʾ��
			//2.����������ʾ����������
			//Interaction.showIndexPage();
	  		//3.�������š�
	  		//Society.search("");//������ַ�������ʾ��������
			//Society.search("Э��");//��������������������
			//3.6.7.���һ������ɸѡ
			//Activity.search("��","","");//��һ������Ϊ����������
			//Activity.search("","2011","");//�ڶ�������Ϊ��ʱ��ɸѡ�������ʽΪ��.��.�ա�ɸѡ������ʱ��֮��Ļ
			//Activity.search("","","ɢ����");//����������Ϊ���������ɸѡ��
			//Activity.search("","","")//��������������ɲ����������ɸѡ�������������ɸѡ
			//5.�û������Ӧ�ʱ��ʾ��ϸ��Ϣ
	        //Activity.showActicityDetails(Activity.getActivityByName("��������"));//������������ģ���û����
			//4.�û������Ӧ����ʱ��ʾ��ϸ��Ϣ
			//Society.showSocietyDetails(Society.getSocietyByName("ɢ����")); //����������������ģ���û������

        
		//Administration ��̨������ʾ��
			
			//8.�鿴����ȫ����Ա			
			//Administration.viewMembers("������");//����������������
			//9.����Ա���������Ž�������
			//Society.search("");//��ʾ����ǰ����������
			//Administration.rankSocietyByMemberNumber();
			//Society.search("");//��ʾ��������������
			//10.���ٰ����������Ž�������
			//Administration.rankSocietyByActivityNumber();
			//Society.search("");//��ʾ��������������			
			//11.�޸ı�ע��Ϣ��
			//Administration.editInformation("����ȭ��ѧ", "�����ˣ�����ʦ������һ���˶�Ա��ǰ�������ھ�");//�ɶ�Ӧ��д���������������޸ĺ�ı�ע����
			//System.out.println(Activity.getActivityByName("����ȭ��ѧ").getPs());//��ʾ�޸ĺ�ı�ע����
			 
		
	}
	
	
	
	
	static void readData() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/���.csv"));
        reader.readLine();//skip the head
        String line = null; 
        line=reader.readLine();

        while((line=reader.readLine())!=null) {
       	 String item[] = line.split(",");
       	 Activity.addActivity(new Activity (item[0],item[1],item[2],item[3],item[5]));
        }
        reader.close();      
         
        reader=new BufferedReader(new FileReader("src/���ű�.csv"));
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
