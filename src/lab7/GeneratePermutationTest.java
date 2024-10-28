package lab7;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GeneratePermutationTest {
    private GeneratePermutation generator;

    @Before
    public void setUp() {
        // Instantiate the GeneratePermutation class before each test
        generator = new GeneratePermutation();
    }

    @Test
    public void testPermutationsWithDistinctCharacters() {
        // Example input: string with unique characters
        String input = "nab";
        
        // Retrieve permutations using the method from the class
        List<String> permutations = generator.getAllPermutations(input);

        // Expected count of permutations for a 3-character string (3!)
        int expectedCount = 6;
        
        // Check that the generated permutations match the expected count
        assertEquals(expectedCount, permutations.size());
        
        // Verify that specific permutations are part of the result
        assertTrue(permutations.contains("ban"));
        assertTrue(permutations.contains("abn"));
        assertTrue(permutations.contains("bna"));
        assertTrue(permutations.contains("nba"));
    }

    @Test
    public void testPermutationsWithEmptyString() {
        // Edge case: empty string input
        String emptyInput = "";

        // Generate permutations with the class method
        List<String> permutations = generator.getAllPermutations(emptyInput);

        // Expect only one permutation: the empty string itself
        assertEquals(1, permutations.size());
        assertTrue(permutations.contains(""));
    }

    @Test
    public void testPermutationsWithSingleCharacter() {
        // Test input: single character string
        String singleCharacter = "a";

        // Generate permutations with the class method
        List<String> permutations = generator.getAllPermutations(singleCharacter);

        // Expect one permutation: the single character itself
        assertEquals(1, permutations.size());
        assertTrue(permutations.contains("a"));
    }

    @Test
    public void testPermutationsWithDuplicateCharacters() {
        // Test input: string with repeating characters
        String repeatedChars = "aa";

        // Generate permutations with the class method
        List<String> permutations = generator.getAllPermutations(repeatedChars);

        // For input "aa", the possible outputs are ["aa", "aa"]
        // Duplicates are considered separately due to positional difference
        assertEquals(2, permutations.size());
        assertTrue(permutations.contains("aa"));
    }
}
