package filppingArray;

public class FilpArray {
    public static int[] flipNumbers(int[] numbers) {
        int count = 0;
        int index = 0;
        for (index = 0; index < 10; index++) {
            int sum = numbers[index] + numbers[count];
            if (sum % 2 != 0) {
                int temp = numbers[index];
                numbers[index] = numbers[count];
                numbers[count] = temp;
            }
            count+=2;

        }
        return numbers;


    }
}
