package diaryTasks;

import java.util.ArrayList;
import java.util.List;

public class Diary {

    private final String username;
    private final String password;
    boolean isLocked;
    private int id = 2400;
    private List<Entry> entries = new ArrayList<>();

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public boolean isLocked() {
        return isLocked;

    }

    public void unLockDiary(String password) {
        if (!this.password.equals(password)) {
            throw new IllegalArgumentException("Wrong password");
        }
        isLocked = true;

    }

    public void lockDiary() {
        isLocked = false;

    }

    public Entry createEntry(String title, String body) {
        if (isLocked == false) {
            throw new IllegalArgumentException("Diary is already locked");
        }
        Entry myEntry = new Entry(title , body , ++id);
        entries.add(myEntry);

        return myEntry;

    }

    public int getNumberOfRegisteredEntries() {
        return entries.size();

    }

    public Entry findEntryById(int id) {
        if (isLocked == false) {
            throw new IllegalArgumentException("Diary is already locked");
        }

        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }

        throw new IllegalArgumentException("Entry with id " + id + " not found");

    }

    public void updateEntry(int id, String newTitle , String newBody) {
        if (isLocked == false) {
            throw new IllegalArgumentException("Diary is already locked");
        }

        boolean found = false;
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                entry.setTitle(newTitle);
                entry.setBody(newBody);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Entry with id " + id + " not found");
        }

    }

    public void deleteEntry(int id) {
        if (isLocked == false) {
            throw new IllegalArgumentException("Diary is already locked");
        }

        boolean found = false;
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                entries.remove(entry);
                found = true;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Entry with id " + id + " not found");
        }

    }

    public String getUsername() {
        return this.username;

    }

    public String getPassword() {
        return this.password;

    }

}