package Offer.Chapter4;

public class VerifySequenceOfBST {
    private boolean verifyCore(int[] sequence, int left, int right){
        if (left >= right) return true;
        int root = sequence[right], sep = left;
        while (sep < right && sequence[sep] < root) sep++;
        for (int i = sep + 1; i < right; i++)
            if (sequence[i] < root) return false;
        return verifyCore(sequence, left, sep - 1)
                && verifyCore(sequence, sep, right - 1);
    }

    public boolean verifySequenceOfBST(int[] sequence){
        if (sequence == null || sequence.length == 0) return false;
        return verifyCore(sequence, 0, sequence.length - 1);
    }
}
