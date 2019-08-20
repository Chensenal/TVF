package utilsbean;

/**
 * Created by master on 2019/8/11.
 */

public class User {
    private int id;
    private String firstLetter;
    private String username;
    private String headimagepath;
    private String password;
    private String pinyin;

    public User(){
        super();
    }
    public User(int id, String username, String headimagepath, String password) {
        super();
        this.id = id;
        this.username = username;
        this.headimagepath = headimagepath;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getHeadimagepath() {
        return headimagepath;
    }
    public void setHeadimagepath(String headimagepath) {
        this.headimagepath = headimagepath;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstLetter() {
        return firstLetter;
    }
    public void setFirstLetter(String FirstLetter) {
        this.firstLetter = firstLetter;
    }
    public String getPinyin() {
        return firstLetter;
    }
    public void setPinyin(String FirstLetter) {
        this.firstLetter = firstLetter;
    }


}
