public class ConcatenationWithString {
    public static void main(String[] args) {

        String myString = "";
        for(int i = 0; i < 1000; i++) {
            myString += i;
        }
        System.out.println(myString);
    }
}
