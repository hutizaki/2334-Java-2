package recursion_lecture;

public class ReverseString {

    public static String reverse(String str) {
        return reverse(str.substring(1)) + str.charAt(0);    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello"));
    }
}

