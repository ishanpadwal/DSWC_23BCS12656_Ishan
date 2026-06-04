package day1;
class DNASequencer {
    private StringBuilder dnaSequence;

    public DNASequencer(int capacity) {
        dnaSequence = new StringBuilder(capacity);
    }

    public void ingestSequence(char[] sensorData) {
        for (char ch : sensorData)
            dnaSequence.append(ch);
    }

    public void mutateDNA(String target, String replacement) {
        int index = dnaSequence.indexOf(target);
        if (index != -1)
            dnaSequence.replace(index, index + target.length(), replacement);
    }

    public String getSequence() {
        return dnaSequence.toString();
    }
}

public class DNASequencing {
    public static void main(String[] args) {
        DNASequencer dna = new DNASequencer(100000);
        char[] sensorData = {'A', 'C', 'T', 'G', 'A', 'C', 'T', 'G'};
        dna.ingestSequence(sensorData);
        System.out.println("Original: " + dna.getSequence());
        dna.mutateDNA("ACT", "GGG");
        System.out.println("Mutated: " + dna.getSequence());
    }
}