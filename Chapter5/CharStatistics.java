package Offer.Chapter5;

public class CharStatistics {
    private int index;
    private int[] occurrence = new int[256];

    {
        for (int i = 0; i < 256; i++) occurrence[i] = -1;
    }

    public void insert(char ch){
        if (occurrence[ch] == -1) occurrence[ch] = index;
        else if (occurrence[ch] >= 0) occurrence[ch] = -2;
        index++;
    }

    public char firstAppearingOnce(){
        char ch = '#';
        int minIdx = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++){
            if (occurrence[i] >= 0 && occurrence[i] < minIdx){
                ch = (char) i;
                minIdx = occurrence[i];
            }
        }
        return ch;
    }

    public static void main(String[] args){
        CharStatistics statistics = new CharStatistics();
        for (char ch : "google".toCharArray()) {
            statistics.insert(ch);
            System.out.println(statistics.firstAppearingOnce());
        }
    }
}
