package cz.example.innovasoft.spolubydla;

/**
 * Created by tom on 25.11.15.
 */
public class Task {

    String id;

    String group_id;

    String description;

    String due_date;

    String member_id;


    String points;

    int day;

    int month;

    int year;

    public String getDescription() {
        return this.description;
    }

    public String getGroup_id() {
        return this.group_id;
    }

    public String getDueDate() {
        return this.due_date;
    }

    public String getMember_id() {
        return this.member_id;
    }

    public String getId() {
        return this.id;
    }

    public String getPoints() { return this.points;}

    public int getDay() { return this.day;}

    public int getMonth() { return this.month; }

    public int getYear() { return this.year; }

    public void setDay(int day) { this.day = day; }

    public void setYear(int year) { this.year = year; }

    public void setMonth(int month) { this.month = month;}

    public void setPoints( String points) { this.points = points;}


    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void Clear() {
        this.id = "";
        this.group_id = "";
        this.member_id = "";
        this.description = "";
        this.due_date = "";
    }
}
