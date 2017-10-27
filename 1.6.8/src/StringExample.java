public class StringExample {
    public static void main(String[] args) {
        String s1 = new String("you are a student"),
                s2 = new String("how are you");
        if (s1.equals(s2)) {
            System.out.println("s1与s2不相同");
        }
        String s3 = new String("620102197210015331");
        if (s3.startsWith("620102")) {
            System.out.println("甘肃省的身份证");
        }
        String temp = "" + 123;

    }

    public String toString() {
        return "" + 123 + "123";

    }
}
