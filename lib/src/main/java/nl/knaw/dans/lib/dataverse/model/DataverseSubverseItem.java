package nl.knaw.dans.lib.dataverse.model;

public class DataverseSubverseItem extends DataverseItem {
    private String title;

    public DataverseSubverseItem() {
    }

    public DataverseSubverseItem(String title, int id) {
        super(DataverseItemType.dataverse, id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
