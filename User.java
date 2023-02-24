public class User {
    private String fullname;
    private String username;
    private String password;

    public User(String fullname,String username,String password)
    {
        this.fullname=fullname;
        this.username=username;
        this.password=password;
    }
    public  String getFullname()
    {
        return fullname;
    }
    public void setFullname()
    {
        this.fullname=fullname;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername()
    {
        this.username=username;
    }
    public String getPassword()
    {
        return password;
    }
    public  void setPassword(String password)
    {
        this.password=password;
    }
}
