package pojos.requests.TestRequests;

import java.util.List;

public class PeopleInfo {
    private List<String> status;
    private List<People> people;

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }


}
