package Offer.Chapter4;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation {
    private void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void permutationCore(char[] arr, int start, ArrayList<String> res){
        if (start == arr.length) res.add(new String(arr));
        for (int i = start; i < arr.length; i++){
            if (i != start && arr[i] == arr[start]) continue;
            swap(arr, i, start);
            permutationCore(arr, start + 1, res);
            swap(arr, i, start);
        }
    }

    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;
        permutationCore(str.toCharArray(), 0, res);
        Collections.sort(res);
        return res;
    }
}
