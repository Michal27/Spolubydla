package cz.example.innovasoft.spolubydla;

/**
 * Created by tom on 25.11.15.
 */
public class Member {

    public String name;

    public String id;

    public String group_id;

    public Boolean admin;

    private String getName() {
        return this.name;
    }

    private String getSettings() {
        return this.group_id;
    }

    private Boolean getCode() {
        return this.admin;
    }

    private String getId() {
        return this.id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSettings(String group_id) {
        this.group_id = group_id;
    }

    private void setCode(Boolean admin) {
        this.admin = admin;
    }

    private void setId(String id) {
        this.id = id;
    }
}
