package displaySystem_OOPclasswork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Administration {


	static void viewMembers (String socName) {
		System.out.println(socName+"全部成员：");
		Society goalSoc= Society.getSocietyByName(socName);
		System.out.println(goalSoc.getMembers());
		
	};	
	
	static void rankSocietyByMemberNumber () {
	     for (int i = 1; i < Society.getSocieties().size(); i++) {  
	         Society tmp=Society.getSocieties().get(i);
	         int j = i - 1;  
	         for (; j >= 0 && Society.getSocieties().get(j).getMembers().length() > tmp.getMembers().length(); j--) {  
	        	 Society.getSocieties().set(j + 1, Society.getSocieties().get(j));  
	         }  
	         Society.getSocieties().set(j + 1, tmp);  
	     }  
		
	};
	static void rankSocietyByActivityNumber () {
	     for (int i = 1; i < Society.getSocieties().size(); i++) {  
	         Society tmp=Society.getSocieties().get(i);
	         int j = i - 1;  
	         for (; j >= 0 && Society.getSocieties().get(j).getRelatedActivities().size() > tmp.getRelatedActivities().size(); j--) {  
	        	 Society.getSocieties().set(j + 1, Society.getSocieties().get(j));  
	         }  
	         Society.getSocieties().set(j + 1, tmp);  
	     }  
		
	};
	static void editInformation (String actName,String newContent){
		Activity toEditAct= Activity.getActivityByName(actName);
		System.out.println("原内容："+toEditAct.getPs());		
		toEditAct.setPs(newContent);
		System.out.println("修改成功");
	};	
}
