package pojos.requests;

public class People {

//     "name": "John Doe",
//      "age": 30,
//      "email": "johndoe@example.com",
//      "isEmployed": true

    private String name;
    private int age ;
    private   String email;
    private boolean isEmployed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsEmployed() {
        return isEmployed;
    }

    public void setIsEmployed(boolean isEmployed) {
        this.isEmployed = isEmployed;
    }





}
