import java.io.FileReader;
import java.util.ArrayList;

public class ReadFile {
	
	ArrayList<String> arr_tip = new ArrayList<String>();
	ArrayList<String> arr_notinstr = new ArrayList<String>();
	ArrayList<String> arr_hiddenstr = new ArrayList<String>();
	ArrayList<String> arr_countdown = new ArrayList<String>();
	
	public ReadFile()  throws Exception {
	    
	    FileReader fr = new FileReader("files\\questions.txt");
	    
        int i;
        int counter = 0;
        ArrayList<Character> arr1 = new ArrayList<Character>();
        ArrayList<Character> arr2 = new ArrayList<Character>();
        ArrayList<Character> arr3 = new ArrayList<Character>();
        ArrayList<Character> arr4 = new ArrayList<Character>();
        
        while ((i = fr.read()) != -1) {
            if((char)i == '\n'){
            	counter = 0;
                arr1 = new ArrayList<Character>();
                arr2 = new ArrayList<Character>();
                arr3 = new ArrayList<Character>();
                arr4 = new ArrayList<Character>();
                
            }
        
            if((char)i == ','){
                if(counter == 0) {
                	StringBuilder builder = new StringBuilder(arr1.size());
                    for(Character ch: arr1)
                    {
                        builder.append(ch);
                    }
                    String str = builder.toString();
                    arr_tip.add(str);
                }
                if(counter == 1) {
                    StringBuilder builder = new StringBuilder(arr2.size());
                    for(Character ch: arr2)
                    {
                        builder.append(ch);
                    }
                    String str = builder.toString();
                    arr_notinstr.add(str);
                }
                if(counter == 2){
                	StringBuilder builder = new StringBuilder(arr3.size());
                    for(Character ch: arr3)
                    {
                        builder.append(ch);
                    }
                    String str = builder.toString();
                    arr_hiddenstr.add(str);
                }
                counter++;
            }
            if(counter == 0) {
                if((char)i != ',') {
                	arr1.add((char)i);
                }
            }
            if(counter == 1) {
                if((char)i != ',') {
                	arr2.add((char)i);
                	arr2.add(' ');
                }
            }
            if(counter == 2){
                if((char)i != ',') {
                	arr3.add((char)i);
                }
            }
        
           
            if(counter == 3) {
                if(((char)i != ',') && ((char)i != '\r')){
                	arr4.add((char)i);
                	StringBuilder builder = new StringBuilder(arr4.size());
                    for(Character ch: arr4)
                    {
                        builder.append(ch);
                    }
                    String str = builder.toString();
                    arr_countdown.add(str);
                    
                    
                }
            }
            
        }

     
	}

}
