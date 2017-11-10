package displaySystem_OOPclasswork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class displaySystemTEST {

	public static void main(String[] args) throws IOException {
		
	
	//<readDataFromCsv&saveInStaticVariety> 
		 //<activity>
		 BufferedReader reader = new BufferedReader(new FileReader("活动表.csv"));
         reader.readLine();//skip the head
         String line = null; 
         line=reader.readLine();

         while((line=reader.readLine())!=null) {
        	 String item[] = line.split(",");
        	 Activity.addActivity(new Activity (item[0],item[1],item[2],item[3],item[5]));
         }
         reader.close();
         	 /*
	         //<test>
	         for(int i=0;i<Activity.getActivities().size();i++) { 
	        	 System.out.println(Activity.getActivities().get(i).getTitle());		 
	        	 System.out.println(Activity.getActivities().get(i).getTime());		 
	         }
             */
         	 //</test>

         //</activity>
         
         //<society>   
         reader=new BufferedReader(new FileReader("社团表.csv"));
         reader.readLine();//skip the head
         line = null; 

         while((line=reader.readLine())!=null) {
        	 String item[] = line.split(",");
        	 Society newSociety=new Society (item[0],item[1],item[2],item[3],item[4],item[5],item[7]);
        	 Society.addSociety(newSociety);
	         
        	 //<bilateralConnecting>
        	 //<add relatedActivities for every Society>
        	 			//	item[6]:relatedActivities
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
        	 //</add relatedActivities for every Society>
        	 //<add oganizers for every Activity>
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
        	 
        	 //</add oganizers for every Activity>
        	 //</bilateralConnecting>
        	 
         }
         reader.close();
	         /*
	         //<test>
	         for(int i=0;i<Society.getSocieties().size();i++) { 
	        	 System.out.println(Society.getSocieties().get(i).getName());		 
	        	 System.out.println(Society.getSocieties().get(i).getBirthday());		 
	        	 System.out.println(Society.getSocieties().get(i).getLeader());		
	        	 System.out.println(Society.getSocieties().get(i).getMembers());		
	        	 System.out.println(Society.getSocieties().get(i).getBrief());
	        	 System.out.println(Society.getSocieties().get(i).getRelatedActivities().get(0).getTitle());
	        	 System.out.println();
	    	     
	         }
         	 */
         	 //</test>
         	 /*         	  
	         //<test>
	         for(int i=0;i<Activity.getActivities().size();i++) { 
	        	 System.out.println(Activity.getActivities().get(i).getTitle());		 
	        	 System.out.println(Activity.getActivities().get(i).getTime());
	        	 System.out.println(Activity.getActivities().get(i).getOrganizers().get(0).getName());
	         }
	     	 //</test>
         	  */
         //</society>
    //</readDataFromCsv&saveInStaticVariety>     
	
         
	
	}

}
