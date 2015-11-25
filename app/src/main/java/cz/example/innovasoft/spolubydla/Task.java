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

    private String getDescription() {
        return this.description;
    }

    private String getGroup_id() {
        return this.group_id;
    }

    private String getDueDate() {
        return this.due_date;
    }

    private String getMember_id() {
        return this.member_id;
    }

    private String getId() {
        return this.id;
    }

    private void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    private void setDue_date(String group_id) {
        this.due_date = due_date;
    }

    private void setDescription(String admin) {
        this.description = description;
    }

    private void setMember_id(String id) {
        this.member_id = member_id;
    }

    private void setId(String id) {
        this.id = id;
    }
}
