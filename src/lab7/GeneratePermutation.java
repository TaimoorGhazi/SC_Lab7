package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneratePermutation {
    public static void main(String[] args) {
        // Set up a scanner to receive input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String input = scanner.nextLine();
        scanner.close(); // Close scanner to free resources

        // Check if the input string is blank and handle this case
        if (input.isEmpty()) {
            System.out.println("You entered an empty string.");
        } else {
            // Generate and retrieve all possible permutations of the input string
            List<String> permutations = getAllPermutations(input);

            // Check if any permutations were generated and print them
            if (permutations.isEmpty()) {
                System.out.println("No permutations generated for the given input.");
            } else {
                System.out.println("All permutations of the input string:");
                // Loop through the list and display each permutation
                for (String permutation : permutations) {
                    System.out.println(permutation);
                }
            }
        }
    }

    /**
     * Generates all possible arrangements of characters in the provided string.
     *
     * @param str The original string for which permutations are needed.
     * @return A list containing all unique permutations of the given string.
     */
    public static List<String> getAllPermutations(String str) {
        // A list to collect all permutations
        List<String> results = new ArrayList<>();

        // Begin recursive generation of permutations with an empty prefix
        generatePermutationsRecursive("", str, results);

        return results;
    }

    /**
     * Recursively generates permutations by updating the prefix and removing used characters.
     *
     * @param prefix  The current prefix built for the permutation.
     * @param remaining The characters left to use in the permutation.
     * @param storage  The list that stores each unique permutation generated.
     */
    private static void generatePermutationsRecursive(String prefix, String remaining, List<String> storage) {
        int n = remaining.length();

        // Base case: no characters remain to add; add prefix to results
        if (n == 0) {
            storage.add(prefix);
        } else {
            // Loop through remaining characters, select one, and recursively build permutation
            for (int i = 0; i < n; i++) {
                String newPrefix = prefix + remaining.charAt(i);
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

                // Recurse with updated prefix and remaining characters
                generatePermutationsRecursive(newPrefix, newRemaining, storage);
            }
        }
    }
}
