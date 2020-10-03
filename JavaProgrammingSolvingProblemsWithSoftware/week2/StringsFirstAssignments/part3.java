
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int lastIndex = 0;
        int firstIndex = 0;
        
        firstIndex = stringb.indexOf(stringa);
        lastIndex = stringb.lastIndexOf(stringa);
        
        if(firstIndex != lastIndex){
            return true;
        }
        else {
            return false;
        }
        
    }
    
    public void testTwoOccurrences(){
        String stringa = "a";
        String stringb = "banana";
        System.out.println(stringa +  " Occurs atleast twice in " + stringb + " is");
        System.out.println(twoOccurrences(stringa,stringb));
        
        stringa = "by";
        stringb = "Having two similar sentences";
        System.out.println(stringa +  " Occurs atleast twice in " + stringb + " is");
        System.out.println(twoOccurrences(stringa,stringb));
    }
    
    public String lastPart(String stringa, String stringb){
        int lastIndex = 0;
        int firstIndex = 0;
        
        firstIndex = stringb.indexOf(stringa);
        lastIndex = stringb.lastIndexOf(stringa);
        
        if(firstIndex != lastIndex){
            return stringb.substring(lastIndex);
        }
        else {
            return stringb;
        }
        
    }
    
    public void testlastPart(){
        String stringa = "an";
        String stringb = "banana";
        //System.out.println(stringa +  " Occurs atleast twice in " + stringb + " is");
        System.out.println(lastPart(stringa,stringb));
        
        stringa = "zoo";
        stringb = "forest";
        //System.out.println(stringa +  " Occurs atleast twice in " + stringb + " is");
        System.out.println(lastPart(stringa,stringb));
    }
}


