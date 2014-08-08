import java.io.*;

class copy {
     BufferedReader brr = null;
     BufferedWriter brw = null;
     public void copyTo(String filepath1,String filepath2) throws FileNotFoundException, IOException {
        String line = "";
        int flag=0;
        try {
        brr = new BufferedReader(new FileReader(filepath1));
          brw = new BufferedWriter(new FileWriter(filepath2));
        while((line = brr.readLine()) != null)
            {
                brw.write(line);
                brw.newLine();
                
            }
            
        }
         finally {
            brr.close();
              brw.close();
        }
    
    }
    
}
     

public class fileCopy {
    public static void main(String[] args) throws IOException { 
        
        copy Obj=new copy();
        String path1="Traversing.java";
        String path2="Traversing.txt";
        try {
       
            try {
            
                Obj.copyTo(path1,path2);
                System.out.println("file copied");
           
            } 
            catch ( FileNotFoundException e) {
            
                System.out.println("Caught " + e);

            }
        }
        catch (IOException e) {
     
            e.printStackTrace();
        }
        
   
    
    }
}
