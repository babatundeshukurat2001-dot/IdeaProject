public abstract class User {

    private int age;
    private String email;
    private Address homeAddress;
    private String name;
    private String password;
    private String phone;

    public User(int age, String email,
                Address homeAddress, String name,
                String password, String phone) {

        this.age = age;
        this.email = email;
        this.homeAddress = homeAddress;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}