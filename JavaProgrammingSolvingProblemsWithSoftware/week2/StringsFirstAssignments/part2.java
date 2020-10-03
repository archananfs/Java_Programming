
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String result = "";
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
        if (stopIndex == -1){
            return "";
        }
        result = dna.substring(startIndex, stopIndex+3);
        if (result.length() % 3 != 0){
            return "";
        }
        
        return result;
    }
    
    public void testFindSimpleGene(){
    String startCodon = "ATG" ;
    String stopCodon = "TAA";
    String dna = "ATATGAAACTCTAA";
    System.out.println("The DNA is "+dna);
    String gene = findSimpleGene(dna, startCodon, stopCodon);
    System.out.println("Gene is" + gene);
    
    dna = "ATATAAACTCTAA";
    System.out.println("The DNA is "+dna);
    gene = findSimpleGene(dna, startCodon, stopCodon);
    System.out.println("Gene is" + gene);
    
    dna = "ATATGAAACTCTTAA";
    System.out.println("The DNA is "+dna);
    gene = findSimpleGene(dna,  startCodon, stopCodon);
    System.out.println("Gene is" + gene);
    
    dna = "ATATGAAACTCTTAA";
    System.out.println("The DNA is "+dna);
    gene = findSimpleGene(dna,  startCodon, stopCodon);
    System.out.println("Gene is" + gene);
    }

}
