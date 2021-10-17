package nl.knaw.dans.lib.dataverse.model;

import java.net.URI;

public class DataverseDatasetItem extends DataverseItem {
    private String identifier;
    private URI persistentUrl;
    private String protocol;
    private String authority;
    private String publisher;
    private String publicationDate;
    private String storageIdentifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public URI getPersistentUrl() {
        return persistentUrl;
    }

    public void setPersistentUrl(URI persistentUrl) {
        this.persistentUrl = persistentUrl;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getStorageIdentifier() {
        return storageIdentifier;
    }

    public void setStorageIdentifier(String storageIdentifier) {
        this.storageIdentifier = storageIdentifier;
    }
}
