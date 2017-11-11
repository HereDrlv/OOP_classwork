package displaySystem_OOPclasswork;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.naming.directory.SearchResult;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Interaction {

	static void showIndexPage() {//主页面上显示所有社团&所有活动
		Society.search(""); 	
		Activity.search("", "","");
	};

	static ArrayList<String> searchByTitleOrName(ArrayList<String> goalList,String input){
		String pattern = ".*"+input+".*";//RegularExpression
		ArrayList<String> searchResult=new ArrayList();
		for(String s :goalList) {
			if ( Pattern.matches(pattern, s)) {
				searchResult.add(s);
			}
		}
		return searchResult;
	}
	

	void showMoreDetails() {
		
	};
	static ArrayList<String> filterActivityByTime(String inputTime) {
		ArrayList<String> filterResult =new ArrayList<String>();
		for(Activity a:Activity.getActivities()) {
			if(a.getTime().compareTo(inputTime)>0) {
				filterResult.add(a.getTitle());
			}
		}
		return filterResult;
	};
	
}
