
import java.io.*;


class wordNotfoundException extends Exception {
    
   private String detail;
   wordNotfoundException(String msg) {
  detail = msg;
    }
   public String toString() {
    return "MyException[" + detail + "]";
    }


    
}


class search {
    BufferedReader br = null;
    
    public void wordFound(String path) throws wordNotfoundException, FileNotFoundException, IOException {
        String line = "";
        int flag=0;
        try {
        br = new BufferedReader(new FileReader(path));
        while((line = br.readLine()) != null)
            {
                String[] words = line.split(" ");

                for (String word : words) {
                    if (word.equals("code;")) {
                      System.out.println("String found");
                      flag=1;
                      break;
                    }
                       
                }
                if(flag==1) {
                    break;
                }
                
            }
            if(flag==0) {
                
                throw new  wordNotfoundException("Word Not Found Exception");
              

            }
        
        }
         finally {
            br.close();
        }
    
    }
    
}
public class wordSearch {

    public static void main(String[] args) throws IOException {   
        search Obj=new search();
        String path="Traversing.java";
        try {
       
            try {
            
                Obj.wordFound(path);
           
            } 
            catch (wordNotfoundException e) {
            
                System.out.println("Caught " + e);

            }
        }
        catch (FileNotFoundException e) {
     
            e.printStackTrace();
        }
        catch (IOException e) {
     
            e.printStackTrace();
        }
     

   
    }
}
   
    
    
   
   
   

    
    
                      
                   
                   
                    
                  
                      
                  
                  
               


       


