
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class Duplicate {

    public static void main(String[] args)  {
        
        
        Map <Integer, String> Obj = new ConcurrentHashMap<Integer, String>();
       
        Obj.put(1,"I");
        Obj.put(2,"came");
        Obj.put(3,"I");
        Obj.put(4,"Saw");
        Obj.put(5,"I");
        Obj.put(6,"conquered");
        Obj.put(7,"I");
        Obj.put(8,"went");
         
         
         
          for (Integer key : Obj.keySet()) {
            String temp= Obj.get(key);
           
           Iterator<Map.Entry<Integer, String>> iterator = Obj.entrySet().iterator();
             while(iterator.hasNext()){
                 Map.Entry<Integer, String> entry1 = iterator.next();
                try {
<<<<<<< HEAD
                 if(temp.equalsIgnoreCase(entry1.getValue())&& key!=entry1.getKey()) {
                   iterator.remove();
                  
                    
                  }
                 throw new NullPointerException("value is null");
                }
                catch(Exception e) {
                	
=======
                    if(temp.equalsIgnoreCase(entry1.getValue())&& key!=entry1.getKey()) {
                        iterator.remove();
                    }
                    throw new NullPointerException("value is null");
                }
                catch(Exception e) {
                e.getMessage();	
>>>>>>> 0f5829fbdefd27a3f2191747f2efd215336ad187
                }
         
                 
             }
          }
           for (Integer key1 : Obj.keySet())
                System.out.print(Obj.get(key1)+" ");
                 
        
    }
}

            
            

            

            

        
   
