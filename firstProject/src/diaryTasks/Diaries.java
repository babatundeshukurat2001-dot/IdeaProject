package diaryTasks;

import java.util.ArrayList;
import java.util.List;

public class Diaries {

    private List<Diary> dairies = new ArrayList<>();

    public void add(String userName , String password) {
        Diary myDiary = new Diary(userName , password);

        dairies.add(myDiary);

    }

    public int getNumberOfDiary() {
        return dairies.size();

    }

    public Diary findByUsername(String userName) {
        for (Diary diary : dairies) {
            if (diary.getUsername().equals(userName)) {
                return diary;
            }
        }

        throw new IllegalArgumentException("Username not found");

    }

    public void delete(String userName, String password) {
        Diary eachDiary = findByUsername(userName);
        if (!password.equals(eachDiary.getPassword())) {
            throw new IllegalArgumentException("Passwords don't match");
        }

        dairies.remove(eachDiary);

    }

}