package cz.example.innovasoft.spolubydla;

/**
 * Created by tom on 25.11.15.
 */
public class Member {

    public String name;

    public String id;

    public String group_id;

    public Boolean admin;

    public String color;


    public String getName() {
        return this.name;
    }

    public String getGroup_id() {
        return this.group_id;
    }

    public Boolean getAdmin() {
        return this.admin;
    }

    public String getId() {
        return this.id;
    }

    public String getColor() { return this.color; }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setColor(String color) { this.color = color; }

}
