
/**
 * Write a description of part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class part4 {
    public void findLinks(){
        String url = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";
        URLResource urlResource = new URLResource(url);
       
        for(String line : urlResource.lines()){
            String lowerLine = line.toLowerCase();
            //System.out.println(line);
            if (lowerLine.contains("youtube.com")){
                //if (lowerLine.indexOf("youtube.com") != -1)
                int startIndex = lowerLine.indexOf("\"");
                int stopIndex = lowerLine.indexOf("\"", startIndex+1);
                String result = lowerLine.substring(startIndex+1, stopIndex);
                System.out.println(result);
                
            }
            
    } 
    
  
}
   

}
/*
import edu.duke.*;

public class Part4 {
    public void printUrls(String url) {
        URLResource myurl = new URLResource(url);
        for(String word : myurl.words()) {
            if(word.toLowerCase().indexOf("youtube.com") != -1) {
                int quoteIndex = word.indexOf("\"");
                int lastQouteIndex = word.indexOf("\"", quoteIndex+1);
                System.out.println(word.substring(quoteIndex+1, lastQouteIndex));
                
            }
        }
    }
    
    public void testUrl() {
        printUrls("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    }
    
    public static void main() {
        Part4 url = new Part4();
        url.testUrl();
    }
}
 */