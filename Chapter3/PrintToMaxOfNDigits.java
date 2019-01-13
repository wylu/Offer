package Offer.Chapter3;

public class PrintToMaxOfNDigits {
    private void printNumber(char[] num){
        boolean isZero = true;
        for (int i = 0; i < num.length; i++){
            if (isZero && num[i] != '0') isZero = false;
            if (!isZero) System.out.print(num[i]);
        }
        if (isZero) System.out.println("0");
        else System.out.println();
    }

    private void printRecursively(char[] num, int index) {
        if (index == num.length - 1){
            printNumber(num);
            return;
        }
        for (int i = 0; i < 10; i++){
            num[index + 1] = (char) (i + '0');
            printRecursively(num, index + 1);
        }
    }

    public void printToMaxOfNDigits(int n){
        if (n <= 0) return;
        char[] num = new char[n];
        for (int i = 0; i < 10; i++){
            num[0] = (char) (i + '0');
            printRecursively(num, 0);
        }
    }

    public static void main(String[] args){
        new PrintToMaxOfNDigits().printToMaxOfNDigits(2);
    }
}
