package nl.knaw.dans.lib.dataverse.model.dataset;

public class License {
    private String label;
    private String uri; // TODO: change to URI

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
