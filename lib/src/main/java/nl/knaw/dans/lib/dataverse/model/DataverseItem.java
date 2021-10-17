package nl.knaw.dans.lib.dataverse.model;

public abstract class DataverseItem {
    private DataverseItemType type;
    private int id;

    public DataverseItem() {
    }

    public DataverseItem(DataverseItemType type, int id) {
        this.type = type;
        this.id = id;
    }

    public DataverseItemType getType() {
        return type;
    }

    public void setType(DataverseItemType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
