package diaryTasks;

import java.time.LocalDateTime;

public class Entry {
    private final int id;
    private String title;
    private String body;
    private final LocalDateTime dateCreated;

    public Entry(String title,String body, int id){
        this.id = id;
        this.title = title;
        this.body = body;
        this.dateCreated = LocalDateTime.now();
    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getBody(){
        return body;
    }

    public void setBody(String newBody){
        this.body = body;
    }

    public LocalDateTime getDateCreated(){
        return dateCreated;
    }


}
