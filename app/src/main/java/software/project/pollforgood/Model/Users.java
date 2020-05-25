package software.project.pollforgood.Model;

public class Users
{
    private String name, phone, password, roll;

    public Users()
    {

    }

    public Users(String name, String phone, String password, String image, String roll) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.roll = roll;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
}

