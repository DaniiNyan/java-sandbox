public class ConcatenationWithStringBuilder {
    public static void main(String[] args) {

        StringBuilder myString = new StringBuilder();
        for(int i = 0; i < 1_000_000; i++) {
            myString.append(i);
        }
        System.out.println(myString);
    }
}
