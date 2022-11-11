import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class JavaTask3 {
    public static void main(String[] args) {
        System.out.println("1 задача");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));

        System.out.println('\n');

        System.out.println("2 задача");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));

        System.out.println('\n');

        System.out.println("3 задача");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));

        System.out.println('\n');

        System.out.println("4 задача");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));

        System.out.println('\n');

        System.out.println("5 задача");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));

        System.out.println('\n');

        System.out.println("6 задача");
        System.out.println(same(new int[] {1, 3, 4, 4, 4}, new int[] {2, 5, 7}));
        System.out.println(same(new int[] {9, 8, 7, 6}, new int[] {4, 4, 3, 1}));
        System.out.println(same(new int[] {2}, new int[] {3, 3, 3, 3, 3}));

        System.out.println('\n');

        System.out.println("7 задача");
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));

        System.out.println('\n');

        System.out.println("8 задача");
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));

        System.out.println('\n');

        System.out.println("9 задача");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));

        System.out.println('\n');

        System.out.println("10 задача");
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));
    }

    public static int solutions(int a, int b, int c) {
        double D = Math.sqrt(b*b - 4*a*c);
        if (D > 0) {
            return 2;
        } else if (D == 0) {
            return 1;
        }
        return 0;
    }

    public static int findZip(String str) {
        int position1 = str.indexOf("zip");
        int position2 = str.indexOf("zip", position1 + 1);
        return position2;
    }

    public static boolean checkPerfect(int num) {
        int sum = 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        if (Math.sqrt(num) % 1 == 0) {
            sum += Math.sqrt(num);
        }
        if (sum == num) {
            return true;
        }
        return false;
    }

    public static String flipEndChars(String str) {
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        char[] chars = str.toCharArray();
        if (str.length() != 1) {
            if (first == last) {
                return "Two's a pair.";
            }
            chars[0] = last;
            chars[str.length() - 1] = first;
            str = String.valueOf(chars);
            return str;
        }
        return "Incompatible.";
    }

    public static boolean isValidHexCode(String str) {
        char[] chars = str.toCharArray();
        if (chars[0] == '#' && chars.length == 7 && str.matches("[#0-9a-fA-F]+")) {
            return true;
        }
        return false;
    }

    public static boolean same(int[] arr1, int[] arr2) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(arr1.length);
        for (int i : arr1){
            arrayList1.add(i);
        }
        Set<Integer> set1 = new LinkedHashSet<>(arrayList1);

        ArrayList<Integer> arrayList2 = new ArrayList<>(arr2.length);
        for (int i : arr2){
            arrayList2.add(i);
        }
        Set<Integer> set2 = new LinkedHashSet<>(arrayList2);

        return set1.size() == set2.size();
    }

    public static boolean isKaprekar(int num) {
        int multied = num*num;
        String str = Integer.toString(multied);
        int count = 1;
        while (multied / 10 > 0) {
            count++;
            multied /= 10;
        }

        String left = "";
        String right = "";

        for (int i = 0; i < count / 2; i++) {
            left += str.charAt(i);
        }
        if (left.length() == 0) {
            left += '0';
        }
        for (int i = count / 2; i < count; i++) {
            right += str.charAt(i);
        }
        int resLeft = Integer.parseInt(left);
        int resRight = Integer.parseInt(right);
        if (resLeft + resRight == num) {
            return true;
        }
        return false;
    }

    public static String longestZero(String str) {
        int max = 0;
        int maxLength = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '0' && str.charAt(i+1) == '0') {
                if (max == 0) {
                    max += 2;
                } else {
                    max += 1;
                }
            } else {
                max = 0;
            }
            if (max > maxLength) {
                maxLength = max;
            }
        }
        String res = "";
        for (int i = 0; i < maxLength; i++) {
            res += "0";
        }
        return res;
    }

    public static boolean isPrime(int number){
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        if (Math.sqrt(number) % 1 == 0) {
            return false;
        }
        return true;
    }

    public static int nextPrime(int num) {
        if (isPrime(num)) {
            return num;
        } else {
            int nextNum = num + 1;
            while (true) {
                if (isPrime(nextNum)) {
                    return nextNum;
                }
                nextNum++;
            }
        }
    }

    public static boolean rightTriangle(int side1, int side2, int side3) {
        if (side1*side1 + side2*side2 == side3*side3 || side1*side1 + side3*side3 == side2*side2 || side3*side3 + side2*side2 == side1*side1) {
            return true;
        }
        return false;
    }
}