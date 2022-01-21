import java.util.*;

class LRUCache {
    
    HashMap<Character,Integer>db = new HashMap<Character,Integer>();
    Stack<Integer> s = new Stack<Integer>();
    //LinkedList<Integer> ll = new LinkedList<Integer>();
    ArrayList<Character> aL = new ArrayList<Character>();
    int cap =0;
    int capacity;
    int remo =0;
    
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
    }
    
    public int get(Character key) {
        if(db.containsKey(key)){
            System.out.println("Yes I contain "+ db.get(key));
            if(aL.get(0)==key){
                Character n = aL.get(0);
                aL.remove(0);
                aL.add(n);
            }
            return db.get(key);
        }
        else {
            System.out.println("nope dont have "+ key);
            
            return -1;
        }
        //return value of the key if it exists
        //else return -1
        
    }
    
    public void put(Character key, int value) {
      
        if(db.containsKey(key)){
            System.out.println("already have"+ key);
              db.remove(key);  
              db.put(key,value);  
             if(aL.get(0)==key){
                Character n = aL.get(0);
                aL.remove(0);
                aL.add(n);
            }
            return;

              //cap++;  
        }
        
        if(cap<capacity){
            
            
             System.out.println("adding "+ key);   
            aL.add(key);
            //s.add(key);
            db.put(key,value);
            
            cap++;
            }
        
        
        else{
            
            db.remove(aL.get(0));
            System.out.println("removing "+aL.get(0));
            aL.remove(0);
            
            db.put(key,value);
            aL.add(key);
            System.out.println(aL.get(0));
            
        }
        //update SINGLE VALUE OF KEY
        //ELSE ADD THE KEY VALUE PAIR TO THRE CACHE
        
        
        
    }
}
