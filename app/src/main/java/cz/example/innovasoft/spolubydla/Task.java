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

    String member_name;

    Integer member_color;

    String points;

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

    public String getMemberName() {return this.member_name; }

    public Integer getMemberColor() {return this.member_color; }

    public String getPoints() { return this.points;}

    public void setPoints( String points) { this.points = points;}

    public void setMemberName(String member_name) { this.member_name = member_name;}

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

    public void setMember_color(Integer member_color) { this.member_color = member_color; }

    public void Clear() {
        this.id = "";
        this.group_id = "";
        this.member_id = "";
        this.description = "";
        this.due_date = "";
    }
}
