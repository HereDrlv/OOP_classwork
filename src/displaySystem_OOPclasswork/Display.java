package displaySystem_OOPclasswork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Display {

	static int randomlySelectImg() {

		Random random=new Random();
		int r =random.nextInt(10);
		return r+1;
	};
	static void showImg(int n,int m) throws IOException {
		for(int i=1;i<11;i++) {
			System.out.println("ÉçÍÅ"+i+":");
		
			
			BufferedReader reader = new BufferedReader(new FileReader("src/img/"+i+"/testImg ("+((n+i)%10+1)+").txt"));
			String line = null; 												
			while((line=reader.readLine())!=null) {
				String imgContent=line;
				System.out.print(imgContent);
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader("src/img/"+i+"/testImg ("+((m+i)%10+1)+").txt"));
			line = null; 
			while((line=reader.readLine())!=null) {
				String imgContent=line;
				System.out.println(imgContent);
			}
			reader.close();
			
		}

		
	};
	
	
}
