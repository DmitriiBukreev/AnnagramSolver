import java.util.*;

public class AnagramChecker {

    private static final Set<String> stringSet = new HashSet<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Anagram Checker!");
        promptUser();
        System.out.println("Thank you for using Anagram Checker.");
    }

    private static void promptUser() {
        System.out.println("\nEnter 'check' to check anagrams, 'find' to find anagrams, or 'exit' to exit:");
        String command = scanner.nextLine().trim().toLowerCase();

        switch (command) {
            case "check":
                checkAnagrams();
                break;
            case "find":
                findAnagrams();
                break;
            case "exit":
                System.out.println("Exiting the program.");
                return;
            default:
                System.out.println("Invalid command. Please enter 'check', 'find', or 'exit'.");
                break;
        }
        promptUser();
    }

    private static void checkAnagrams() {
        System.out.println("Enter the first string:");
        String first = scanner.nextLine();
        System.out.println("Enter the second string:");
        String second = scanner.nextLine();

        if (isAnagram(first, second)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }

    private static void findAnagrams() {
        System.out.println("Enter a string to find anagrams for:");
        String target = scanner.nextLine();

        if (stringSet.stream().noneMatch(str -> isAnagram(str, target))) {
            stringSet.add(target);
        }

        List<String> anagrams = getAnagrams(target);
        System.out.println("Anagrams for \"" + target + "\": " + anagrams);
    }

    private static List<String> getAnagrams(String target) {
        return stringSet.stream()
                .filter(candidate -> isAnagram(target, candidate) && !candidate.equals(target))
                .toList();
    }

    private static boolean isAnagram(String str1, String str2) {
        char[] word1 = str1.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] word2 = str2.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }
}
