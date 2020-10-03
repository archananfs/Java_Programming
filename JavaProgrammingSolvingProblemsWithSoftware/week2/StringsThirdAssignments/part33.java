
/**
 * Write a description of part33 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.lang.Math;
public class part33 {
    public double cgRatio(String dna){
        int totalCG = 0;
        for (int i = 0; i< dna.length(); i++){
            if(dna.toUpperCase().charAt(i) == 'C' || dna.toUpperCase().charAt(i) == 'G' ){
                totalCG +=1;
            }
        }
        return (double) totalCG / dna.length();
    }
    
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.toUpperCase().indexOf(stopCodon, startIndex+3);
        while (currIndex != -1){
            int diff = currIndex - startIndex;
            if (diff % 3 == 0){
                return currIndex;
            }
            else {
                currIndex = dna.toUpperCase().indexOf(stopCodon, currIndex+1);
            }
        }
        return -1;
    }
    
    public String findGene(String dna, int where){
        int startIndex = dna.toUpperCase().indexOf("ATG", where);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        //int minIndex = Math.min(tgaIndex, Math.min(taaIndex, tagIndex));
        int minIndex =0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        
        if (minIndex == -1){
            return "";
        }
        return dna.substring(startIndex, minIndex+3);
    }
    
     public StorageResource getAllGenes(String dna){
        int startIndex = 0;
        StorageResource geneList = new StorageResource();
        while (true){
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty()){
                break;
            }
            geneList.add(gene);
            
            
            startIndex = dna.toUpperCase().indexOf(gene, startIndex) + gene.length();
        }
        return geneList;
           
    }
    
    public void processGenes(StorageResource sr){
        int lengthCount = 0;
        int cgRatioCount = 0;
        int longestLength = Integer.MIN_VALUE ;
        
        for (String gene : sr.data()){
            int currLength = gene.length();
            double currCgRatio = cgRatio(gene);
            
            if (currLength > 60){
                lengthCount  += 1;
                System.out.println("Gene with length more than 9 character is " + gene + "\r\n") ;
            }
            
            if (currCgRatio > 0.35){
                cgRatioCount += 1;
                System.out.println("Gene with CgRatio more than 0.35 is " + gene + "\r\n");
            }
            
            longestLength = Math.max(longestLength, currLength);
        }
        
        System.out.println("Total number of genes " + sr.size());
        System.out.println("Total number of genes with more than 60 charecter long  " + lengthCount);
        System.out.println("Total number of genes with more than 0.35 cgratio  " + cgRatioCount);
        System.out.println("longest gene " + longestLength);
    }
    
    public void testprocessGenes(){
        FileResource fr = new FileResource("GRch38dnapart.fa.txt");
        String dna = fr.asString();
        
        StorageResource geneList = getAllGenes(dna);
        processGenes(geneList);
    }
}
