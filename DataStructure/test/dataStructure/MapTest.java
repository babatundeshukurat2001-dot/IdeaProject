
package dataStructure;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class MapTest {

    @Test
    public void testThatWhenNewMapIsCreated_ItShouldBeEmpty() {
        Map Map = new Map();

        assertTrue(Map.isEmpty());
    }

    @Test
    public void testThatMapShouldNotBeEmpty_WhenKeyValuePairIsAdded() {
        Map Map = new Map();

        Map.put("Name", "Ola");

        assertFalse(Map.isEmpty());
    }

    @Test
    public void testThatMapShould_RemoveAllEntries_WhenMapIsCleared() {
        Map Map = new Map();

        Map.put("Name", "Ola");
        Map.put("Age", "25");

        Map.clear();

        assertTrue(Map.isEmpty());
        assertEquals(0, Map.size());
    }

    @Test
    public void testThatMapShould_RemoveKeyValuePair_WhenKeyIsRemoved() {
        Map Map = new Map();

        Map.put("Name", "Ola");
        Map.put("Age", "25");

        Map.remove("Name");

        assertNull(Map.get("Name"));
        assertEquals(1, Map.size());
    }

    @Test
    public void testThatMapShould_ReplaceExistingValueForGivenKey() {
        Map Map = new Map();

        Map.put("Name", "Ola");

        Map.replace("Name", "Tola");

        assertEquals("Tola", Map.get("Name"));
    }

    @Test
    public void testThatMapShould_ReturnValueAssociatedWithGivenKey() {
        Map Map = new Map();

        Map.put("Name", "Ola");

        assertEquals("Ola", Map.get("Name"));
    }

    @Test
    public void testThatMapShould_AddKeyValuePair_WhenPutIsCalled() {
        Map Map = new Map();

        Map.put("Name", "Ola");

        assertEquals(1, Map.size());
        assertEquals("Ola", Map.get("Name"));
    }

    @Test
    public void testThatMapShould_ReturnNumber_OfKeyValuePairs_InMap() {
        Map Map = new Map();

        Map.put("Name", "Ola");
        Map.put("Age", "25");
        Map.put("City", "Lagos");

        assertEquals(3, Map.size());
    }

    @Test
    public void testThatMapShould_UpdateExistingValue_WithoutIncreasing_MapSize() {
        Map Map = new Map();

        Map.put("Name", "Ola");
        Map.put("Name", "Tola");

        assertEquals("Tola", Map.get("Name"));
        assertEquals(1, Map.size());
    }
}
