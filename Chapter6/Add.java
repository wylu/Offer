package Offer.Chapter6;

public class Add {
    public static int add(int num1, int num2){
        int sum, carry;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while (num2 != 0);
        return num1;
    }

    public static void main(String[] args){
        System.out.println(add(3, 8));
    }
}
