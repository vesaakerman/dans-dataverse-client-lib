package nl.knaw.dans.lib.dataverse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataverseMessage<D> {

    private String status;
    private String message;
    private D data;

    @JsonProperty
    public String getStatus() {
        return status;
    }

    @JsonProperty
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public D getData() {
        return data;
    }

    @JsonProperty
    public void setData(D data) {
        this.data = data;
    }
}
