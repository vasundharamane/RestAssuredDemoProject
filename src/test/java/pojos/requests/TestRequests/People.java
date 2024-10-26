package pojos.requests.TestRequests;

public class People {

    private String name;
    private int age;
    private String email;
    private Boolean isEmployed;

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

    public Boolean getEmployed() {
        return isEmployed;
    }

    public void setEmployed(Boolean employed) {
        isEmployed = employed;
    }


}

//   {
//      "name": "John Doe",
//      "age": 30,
//      "email": "johndoe@example.com",
//      "isEmployed": true
//    },