
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while (currIndex != -1){
            int diff = currIndex - startIndex;
            if (diff % 3 == 0){
                return currIndex;
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return -1;
    }
    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
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
    public void printAllGenes(String dna){
        int startIndex = 0;
        
        while (true){
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty()){
                break;
            }
            
            System.out.println("Gene:" + gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
           
    }
    public void testPrintAllGenes() {
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        printAllGenes(dna);
    }
    
    public int countGenes(String dna){
        int startIndex = 0;
        int count = 0;
        while(true){
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty()){
                break;
            }
            count += 1;
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return count;
    }
    
    public void testCountGenes(){
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        System.out.println("Number of Genes in the give  dna is " + countGenes(dna));
    }
}
