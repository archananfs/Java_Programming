
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part1 {
    
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

    
    public void testFindStopCodon(){
        String dna = "ATGACTAAATGATAA";
        String stopCodon = "TGA";
        System.out.println(findStopCodon(dna, 0, stopCodon));
        
        dna = "ATGAACGATGATAA";
        stopCodon = "TAA";
        System.out.println("DNA is " + dna + " length of dna is " + dna.length());
        System.out.println(findStopCodon(dna, 0, stopCodon));
    
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
    
    public void testFindGene(){
        String dna = "ATGACTAAATGATAA";
        System.out.println("DNA is " + dna + " length of dna is " + dna.length());
        System.out.println("GENE: "+ findGene(dna, 0));
        
        dna = "AGATGAACTGCATGATAA";
        System.out.println("DNA is " + dna + " length of dna is " + dna.length());
        System.out.println("GENE: "+ findGene(dna, 0));
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
}


