
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {

    public int howMany(String stringa, String stringb){
        int startIndex = stringb.indexOf(stringa);
        int count = 0;
        while (startIndex != -1){
        startIndex = stringb.indexOf(stringa, startIndex);
        if(startIndex != -1){
            count += 1;
            startIndex = startIndex + stringa.length();
        }
        
        
        }
    
    return count;
    }
    
    public void testHowMany(){
    String stringb = "aaBGHHaaJJKKlaaGHkjaa";
    String stringa = "aa";
    System.out.println("The occurrence of " + stringa + " in " + stringb + " is " + howMany(stringa, stringb) + " times.");
    
    stringa = "GAA";
    stringb = "ATGAACGAATTGAATC";
    System.out.println("The occurrence of " + stringa + " in " + stringb + " is " + howMany(stringa, stringb) + " times.");
    }
}

