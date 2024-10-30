package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.requests.SimpleJsonExample;
import pojos.requests.TestRequests.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ComplexPojosTest {

    //Pojo creation for Test1.json
    @Test
    public void createTest1Pojo() {
        People people1 = new People();
        people1.setName("name1");
        people1.setAge(5);
        people1.setEmail("test1@gmail.com");
        people1.setEmployed(true);

        List<People> peopleList = new ArrayList<>();
        peopleList.add(people1);

        List<String> status = new ArrayList<>();
        status.add("sold");
        status.add("reserved");

        PeopleInfo peopleInfo = new PeopleInfo();
        peopleInfo.setPeople(peopleList);
        peopleInfo.setStatus(status);

        Response response = given().log().all()
                .body(peopleInfo)
                .header("content-type", "application/json")
                .when()
                .post("https://reqres.in/api/users")
                .then().log().all().extract().response();

        int id = response.jsonPath().getInt("id");

        System.out.println(id);

    }

    //Pojo creation for Test2.json
    @Test
    public void createTest2Pojo() {
        People people1 = new People();
        people1.setName("sampleName");
        people1.setEmail("samplename@gmail.com");
        people1.setEmployed(true);
        people1.setAge(25);

        People people2 = new People();
        people2.setName("SampleName2");
        people2.setEmail("samplename2@gmil.com");
        people2.setEmployed(false);
        people2.setAge(28);

        List<People> peopleList = new ArrayList<>();

        peopleList.add(people1);
        peopleList.add(people2);

        Response response = given().log().all()
                .header("content-type", "application/json")
                .body(peopleList)
                .when()
                .post("https://reqres.in/api/users");
    }

    //pojo creation for Test3.json
    @Test
    public void createTest3json() {
        Subject student1 = new Subject();
        student1.setSubjectName("Math");
        student1.setGrade("A");

        Subject student2 = new Subject();
        student2.setSubjectName("Science");
        student2.setGrade("B+");

        List<Subject> subjects = new ArrayList<>();
        subjects.add(student1);
        subjects.add(student2);


        Student student = new Student();
        student.setAge(16);
        student.setName("John Doe");

        student.setSubjects(subjects);

        List<Student> students = new ArrayList<>();
        students.add(student);

        School school = new School();
        school.setName("Greenwood High");
        school.setAddress("1234 Elm St");
        school.setStudents(students);

        SchoolInfo schoolInfo = new SchoolInfo();
        schoolInfo.setSchool(school);

        given().log().all()
                .header("content-type", "application/json")
                .body(schoolInfo)
                .when().log().all()
                .post("https://reqres.in/api/users");

    }

    //schema validation

}
