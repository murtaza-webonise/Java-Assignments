
import java.util.*;

class Address {

private String city;
private String state;
private long code;



Address(String city,String state, long code) {

this.city = city;
this.state = state;
this.code = code;
  
}

    String getCity() {
        
        return city;
        
    }

    String getState() {
        return state;
    }

    long getCode() {
        return code;
    }



}





public class Traversing {

    public static void main(String[] args) {
        
        List<Address> Obj=new ArrayList<Address>();
        Map <String, Address>Obj1 = new HashMap();            
       
        
        
      
        
        System.out.println("Enter city state and code");
        String city,state;
        long code;
        
        for(int counter=1;counter<=3;counter++)
        {      Scanner sc=new Scanner(System.in);
             city=sc.nextLine();
            
             state=sc.nextLine();
             code=sc.nextLong();
             Obj.add(new Address(city, state, code));
             Obj1.put("O1"+counter, new Address(city, state, code));  
             
            
        }
        
        System.out.println("Traversing of Arraylist through iterator"); /*Traversing of Arraylist through iterator*/
        Address temp;
        Iterator<Address> it= Obj.iterator();
        while(it.hasNext())
        {
            temp=it.next();
            System.out.println("city: "+temp.getCity()+" state: "+temp.getState()+" code: "+temp.getCode());
        
        
        
        }
        
         System.out.println("Traversing of Hashmap through entryset");  /*Traversing of Hashmap through entryset*/
        Set<Map.Entry<String, Address>> set = Obj1.entrySet();
        for(Map.Entry<String, Address> me : set) {
            
            System.out.print(me.getKey() + ": ");
            temp= me.getValue();
            System.out.println("city: "+temp.getCity()+" state: "+temp.getState()+" code: "+temp.getCode());
           
           
        
        }
        
        
        System.out.println("Traversing of Hashmap through KeySet"); /*Traversing of Hashmap through KeySet*/
        
        for (String key : Obj1.keySet()) {
            temp= Obj1.get(key);
            System.out.println("city: "+temp.getCity()+" state: "+temp.getState()+" code: "+temp.getCode());
            
            
            
        }
        
        System.out.println("Traversing of Hashmap through KeySetIterator");  /*Traversing of Hashmap through KeySetIterator*/
        
        Set<String> keySet = Obj1.keySet();
        Iterator<String> keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext()) {
            temp= Obj1.get(keySetIterator.next());
            System.out.println("city: "+temp.getCity()+" state: "+temp.getState()+" code: "+temp.getCode());
            
        }

           

       
       
        
        


      


    }

}

