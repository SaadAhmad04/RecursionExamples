
import java.util.*;

public class StringUsingRecursion {

    public static void reverseString(String str, int i) {
        if (i == -1) {
            return;
        }
        System.out.print(str.charAt(i));
        reverseString(str, i - 1);
    }

    public static void findOccurence(String str, char ch, int first, int last, int i) {
        if (i == str.length()) {
            if (first == -1) {                                          // if chacracter ch is not present in the string
                System.out.println(ch + " is not present in the string");
            } else {
                System.out.println("First occurrence of " + ch + " is at index " + first);
                System.out.println("Last occurrence of " + ch + " is at index " + last);
            }
            return;
        }
        if (str.charAt(i) == ch) {
            if (first == -1) {
                first = i;
            }
            last = i;

        }
        findOccurence(str, ch, first, last, i + 1);
    }

    public static StringBuilder moveCharacters(String str, StringBuilder newStr, char x, int i, int count) {
        if (i == str.length()) {
            while (count > 0) {
                newStr.append(x);
                count--;
            }
            return newStr;
        }
        if (x == str.charAt(i)) {
            count++;
        } else {
            newStr.append(str.charAt(i));
        }
        return moveCharacters(str, newStr, x, i + 1, count);
    }

    public static StringBuilder removeDuplicates(StringBuilder sb, int i, boolean[] map) {
        if (i == sb.length()) {
            return sb;
        }
        int currentChar = Character.isUpperCase(sb.charAt(i)) ? sb.charAt(i) - 'A' : sb.charAt(i) - 'a';
        if (map[currentChar]) {
            sb.deleteCharAt(i);
            return removeDuplicates(sb, i, map);
        } else {
            map[currentChar] = true;
            return removeDuplicates(sb, i + 1, map);
        }

    }

    public static void printSubsequences(String str , int i , String newStr){
        if(i == str.length()){
            System.out.println(newStr);
            return;
        }
        //if a character want to come in subsequence
        printSubsequences(str, i + 1 , newStr + str.charAt(i));

        //if a character do not want to come in subsequence
        printSubsequences(str, i + 1 , newStr);
    }


    public static void printUniqueSubsequences(String str , int i , String newStr , HashSet<String> set){
        if(i == str.length()){
            if(!set.contains(newStr)){
                System.out.println(newStr);
                set.add(newStr);
                return;
            }
            return;
        }

        printUniqueSubsequences(str, i + 1, newStr + str.charAt(i),set);
        printUniqueSubsequences(str, i + 1, newStr , set);
    }


    public static void printKeypadComnbination(String str , int i , String combination , String[] keypad){

        if(i == str.length()){
            System.out.println(combination);
            return;
        }

        char currentChar = str.charAt(i);
        String mapping = keypad[currentChar - '0']; 
    
        for(int j = 0; j < mapping.length(); j++){
            printKeypadComnbination(str, i+1, combination + mapping.charAt(j), keypad);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ///-----------------------------print string in reverse order----------------------------------------------------
        
        // System.out.print("Enter a string : ");
        // String str = sc.nextLine();
        // System.out.print("Reverse of " + str + " is ");
        // reverseString(str, str.length()-1);


         ///-----------------------------find first and last occurrence of an element in the string---------------------------
        
        // System.out.print("Enter a string : ");
        // String str = sc.nextLine();
        // System.out.print("Enter the element you want to find : ");
        // char ch = sc.next().charAt(0);
        // findOccurence(str, ch, -1, -1, 0);


         ///--------------------------------------move all x to the end of the string-----------------------------------
        
        // System.out.print("Enter a string : ");
        // String str = sc.nextLine();
        // System.out.print("Enter the element you want to move : ");
        // char x = sc.next().charAt(0);
        // StringBuilder sb = new  StringBuilder();
        // sb = moveCharacters(str, sb , x, 0, 0);         //using string builder to reduce space complexity
        // System.out.println("New string = " + sb);


        ///--------------------------------------remove duplicates from a string-----------------------------------
        
        // System.out.print("Enter a string(without space): ");
        // String str = sc.next();
        // boolean[] map = new boolean[26];
        // StringBuilder sb = new StringBuilder(str);
        // sb = removeDuplicates(sb, 0, map);
        // System.out.println("String after removing duplicates = " + sb);


        ///--------------------------------------print all subsequences of a string-----------------------------------
        
        // System.out.print("Enter a string(without space): ");
        // String str = sc.next();
        // printSubsequences(str, 0, "");                           //time complexity = O(2^n) 


        ///--------------------------------------print all UNIQUE subsequences of a string-----------------------------------
        
        // System.out.print("Enter a string(without space): ");
        // String str = sc.next();
        // HashSet<String> set = new HashSet<String>();
        // printUniqueSubsequences(str, 0, "" , set);


        ///--------------------------------------print keypad combination like-----------------------------------
        // 0 -> .
        // 1 -> abc
        // 2 -> def
        // 3 -> ghi
        // 4 -> jkl
        // 5 -> mno
        // 6 -> pqrs
        // 7 -> tu
        // 8 -> vwx
        // 9 -> yz
        // if input is "23" then output should be - dg , dh , di , eg , eh , ei , fg , fh , fi
        
        String[] keypad = {"." , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tu" , "vwx" , "yz"};
        System.out.print("Enter string : ");
        String str = sc.next(); 
        printKeypadComnbination(str, 0, "", keypad);                //time complexity = O(4^n)  because maximum 4 can be the combination length 
    }   
}
