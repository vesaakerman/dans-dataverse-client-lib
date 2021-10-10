package nl.knaw.dans.lib.dataverse.model;

import java.util.List;

public class TestObject<T> {
    private List<T> myList;

    public List<T> getMyList() {
        return myList;
    }

    public void setMyList(List<T> myList) {
        this.myList = myList;
    }
}
