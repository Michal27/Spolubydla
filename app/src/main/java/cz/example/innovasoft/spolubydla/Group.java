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

    private String getName() {
        return this.name;
    }

    private String getSettings() {
        return this.settings;
    }

    private String getCode() {
        return this.code;
    }

    private String getId() {
        return this.id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSettings(String settings) {
        this.settings = settings;
    }

    private void setCode(String code) {
        this.code = code;
    }

    private void setId(String id) {
        this.id = id;
    }

}
