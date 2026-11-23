package diaryTasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {

    private Diary myDiary;
    @BeforeEach
    public void setUp() {
        myDiary = new Diary("Ajoke" , "correctPassword");
        assertFalse(myDiary.isLocked());

    }

    @Test
    public void testThatICreateMyDiary_AndItIsLocked_IOpenIt_ItOpens() {
        assertFalse(myDiary.isLocked());

        myDiary.unLockDiary("correctPassword");
        assertTrue(myDiary.isLocked());

    }

    @Test
    public void testThatICreateMyDiary_AndItIsLocked_IOpenIt_AndInputedTheWrongPassword_ItThrowsAnException_AndDoNotOpen() {
        assertFalse(myDiary.isLocked());

        assertThrows(IllegalArgumentException.class , () -> myDiary.unLockDiary("correctpassword"));
        assertFalse(myDiary.isLocked());

    }

    @Test
    public void testThatICreateMyDiary_AndItIsLocked_IOpenIt_ItOpens_ILockIt_ItLocks() {
        assertFalse(myDiary.isLocked());

        myDiary.unLockDiary("correctPassword");
        assertTrue(myDiary.isLocked());

        myDiary.lockDiary();
        assertFalse(myDiary.isLocked());

    }

    @Test
    public void testThatIHaveADiary_IUnlockIt_ICreateAnEntry_ItWasCreated() {
        myDiary.unLockDiary("correctPassword");

        Entry bob = myDiary.createEntry("Hello" , "Today is going to be a good day");

        assertEquals(1 , myDiary.getNumberOfRegisteredEntries());

    }

    @Test
    public void testThatIHaveADiary_IDidNotUnlockIt_ICreateAnEntry_ItThrowsAnException_AndWasNotCreated() {
        assertThrows(IllegalArgumentException.class, () -> myDiary.createEntry("Hello" , "Today is going to be a good day"));

        assertEquals(0 , myDiary.getNumberOfRegisteredEntries());

    }

    @Test
    public void testThatIHaveADiary_IUnlockIt_MoreThanOnePersonCreateAnEntry_ItWasCreated() {
        myDiary.unLockDiary("correctPassword");

        Entry bob = myDiary.createEntry("Hello" , "Today is going to be a good day");
        assertEquals(1 , myDiary.getNumberOfRegisteredEntries());

        Entry bobby = myDiary.createEntry("Worst day" , "I can't do this any more");
        assertEquals(2 , myDiary.getNumberOfRegisteredEntries());

    }

    @Test
    public void testThatIUnlockMyDiary_ICreateAnEntry_ItWasCreated_IWantToGetMyEntryDetails_IGetIt() {
        myDiary.unLockDiary("correctPassword");

        Entry bob = myDiary.createEntry("Hello" , "Today is going to be a good day");
        assertEquals(bob , myDiary.findEntryById(bob.getId()));

    }

    @Test
    public void testThatIUnlockMyDiary_ICreateAnEntry_ItWasCreated_ILockMyDiary_IWantToGetMyEntryDetails_ItThrowsAnException_IDidNotGetIt() {
        myDiary.unLockDiary("correctPassword");
        Entry bob = myDiary.createEntry("Hello" , "Today is going to be a good day");

        myDiary.lockDiary();
        assertThrows(IllegalArgumentException.class , () -> myDiary.findEntryById(bob.getId()));

    }

    @Test
    public void testThatIUnlockMyDiary_ICreateAnEntry_ItWasCreated_IWantToGetMyEntryDetails_IPassInTheWrongId_IDidNotGetIt() {
        myDiary.unLockDiary("correctPassword");

        Entry bob = myDiary.createEntry("Hello" , "Today is going to be a good day");
        assertThrows(IllegalArgumentException.class , () -> myDiary.findEntryById(24688));

    }

    @Test
    public void testThatIUnlockMyDiary_ICreateAnEntry_ItWasCreated_IWantToUpdateMyEntryDetails_IGotItUpdated() {
        myDiary.unLockDiary("correctPassword");

        Entry bob = myDiary.createEntry("Hello" , "Today is going to be a good day");
        assertEquals("Great day" , bob.getTitle());

        myDiary.updateEntry(bob.getId() , "Sweet morning" , "I'm so glad i woke up at the right side of the bed");
        assertEquals("Graduation" , bob.getTitle());

    }

    @Test
    public void testThatIUnlockMyDiary_ICreateAnEntry_ItWasCreated_IWantToUpdateMyEntryDetails_IPassInTheWrongId_IThrowsAnException_ItDidWasNotUpdated() {
        myDiary.unLockDiary("correctPassword");

        Entry bob = myDiary.createEntry("Hello" , "Today is going to be a good day");
        assertEquals("Great day" , bob.getTitle());

        assertThrows(IllegalArgumentException.class , () -> myDiary.updateEntry(20005 , "Sweet morning" , "I'm so glad i woke up at the right side of the bed"));
        assertEquals("Great day" , bob.getTitle());

    }

    @Test
    public void testThatIUnlockMyDiary_ICreateAnEntry_ItWasCreated_IDeletedIt_ItWasGone() {
        myDiary.unLockDiary("correctPassword");

        Entry bob = myDiary.createEntry("Hello" , "Today is going to be a good day");
        assertEquals(1 , myDiary.getNumberOfRegisteredEntries());

        Entry bobby = myDiary.createEntry("Worst day" , "I can't do this any more");
        assertEquals(2 , myDiary.getNumberOfRegisteredEntries());

        myDiary.deleteEntry(bob.getId());
        assertEquals(1 , myDiary.getNumberOfRegisteredEntries());

    }

    @Test
    public void testThatIUnlockMyDiary_ICreateAnEntry_ItWasCreated_IDeletedIt_AndIPassedInTheWrongId_ItThrowsAnException_ItDidNotDelete() {
        myDiary.unLockDiary("correctPassword");

        Entry bob = myDiary.createEntry("Hello" , "Today is going to be a good day");
        assertEquals(1 , myDiary.getNumberOfRegisteredEntries());

        Entry bobby = myDiary.createEntry("Worst day" , "I can't do this any more");
        assertEquals(2 , myDiary.getNumberOfRegisteredEntries());

        assertThrows(IllegalArgumentException.class , () -> myDiary.deleteEntry(3456));
        assertEquals(2 , myDiary.getNumberOfRegisteredEntries());

    }

}