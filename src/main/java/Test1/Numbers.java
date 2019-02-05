package Test1;

public class Numbers {
    public String fizzBuzz(final int number) {
        if (number == 0) {
            System.out.println("Число должно быть отличное от нуля");
        } else if (number / 15 * 15 == number) {
            return "FizzBuzz";
        } else if (number / 5 * 5 == number) {
            return "Buzz";
        } else if (number / 3 * 3 == number) {
            return "Fizz";
        }
        return Integer.toString(number);
    }
    public String buildFizzBuzz(int fizz, int buzz, int limit) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= limit; i++) {
            boolean shouldAppendNum = true;
            if (i % fizz == 0) {
                sb.append("Fizz");
                shouldAppendNum = false;
            }
            if (i % buzz == 0) {
                sb.append("Buzz");
                shouldAppendNum = false;
            }
            if (i != fizz && i != buzz) {
                sb.append(i);
            }
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
