package diaryTasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiariesTest {

    private Diaries diaries;

    @BeforeEach
    public void setUp() {
        diaries = new Diaries();

    }

    @Test
    public void testThatIStoreDiary_AndItsStored(){
        diaries.add("Boys over flower" , "incorrectPassword");

        assertEquals(1 , diaries.getNumberOfDiary());

    }

    @Test
    public void testThatMoreThanOnePersonStoreTheirDiary_AndItsStored(){
        diaries.add("Boys over flower" , "incorrectPassword");
        assertEquals(1 , diaries.getNumberOfDiary());

        diaries.add("Rich man" , "incorrectPassword");
        assertEquals(2 , diaries.getNumberOfDiary());

    }

    @Test
    public void testThatIStoreDiary_AndItsStored_IWantToGetItBack_IGotIt(){
        diaries.add("Boys over flower" , "incorrectPassword");

        Diary mydiary = diaries.findByUsername("Boys over flower");
        assertEquals("Boys over flower", mydiary.getUsername());

    }

    @Test
    public void testThatIStoreDiary_AndItsStored_IWantToGetItBack_IPassInTheUsername_ItThrowsAnException(){
        diaries.add("Boys over flower" , "incorrectPassword");

        assertThrows(IllegalArgumentException.class , () -> diaries.findByUsername("Matthew"));
    }

    @Test
    public void testThatIStoreDiary_AndItsStored_IWantToDelete_ItsDeleted(){
        diaries.add("Boys over flower" , "incorrectPassword");
        assertEquals(1 , diaries.getNumberOfDiary());

        Diary mydiary = diaries.findByUsername("Merlin");
        assertEquals("Boys over flower", mydiary.getUsername());

        diaries.delete("Boys over flower" , "incorrectPassword");
        assertEquals(0 , diaries.getNumberOfDiary());

    }

}