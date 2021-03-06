
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
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
    String dna = "ATATGAAACTCTAA";
    System.out.println("The DNA is "+dna);
    String gene = findSimpleGene(dna);
    System.out.println("Gene is" + gene);
    
    dna = "ATATAAACTCTAA";
    System.out.println("The DNA is "+dna);
    gene = findSimpleGene(dna);
    System.out.println("Gene is" + gene);
    
    dna = "ATATGAAACTCTTAA";
    System.out.println("The DNA is "+dna);
    gene = findSimpleGene(dna);
    System.out.println("Gene is" + gene);
    }

}
