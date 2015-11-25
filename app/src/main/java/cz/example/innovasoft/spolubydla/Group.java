package cz.example.innovasoft.spolubydla;

/**
 * Created by tom on 25.11.15.
 */
public class Group {

    public String name;

    public String settings;

    public String code;

    public String id;

    Group() {
    }

    public String getName() {
        return this.name;
    }

    public String getSettings() {
        return this.settings;
    }

    public String getCode() { return this.code;}

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setId(String id) {
        this.id = id;
    }

}
