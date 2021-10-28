package nl.knaw.dans.lib.dataverse.example;

import nl.knaw.dans.lib.dataverse.DataverseException;
import nl.knaw.dans.lib.dataverse.DataverseHttpResponse;
import nl.knaw.dans.lib.dataverse.DataverseResponse;
import nl.knaw.dans.lib.dataverse.model.DataMessage;
import nl.knaw.dans.lib.dataverse.model.dataverse.Dataverse;
import nl.knaw.dans.lib.dataverse.ExampleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DataverseSetMetadataBlocksRoot extends ExampleBase {

    private static final Logger log = LoggerFactory.getLogger(DataverseSetMetadataBlocksRoot.class);

    private static void setMetadataBlocksRoot(String alias, boolean isRoot) throws IOException, DataverseException {
        log.info("Setting metadata blocks isRoot to: {} for dataverse with alias: {}", isRoot, alias);
        DataverseHttpResponse<DataMessage> r = client.dataverse(alias).setMetadataBlocksRoot(false);
        log.info("Status Line: {}", r.getHttpResponse().getStatusLine());
        log.info("Message: {}", r.getData().getMessage());
    }

    public static void main(String[] args) throws Exception {
        // There should always be a 'root' verse
        String verseAlias = "root";
        // We can set this to false, which is a bit odd, it is a root, but not for blocks inheritance behaviour
        setMetadataBlocksRoot(verseAlias, false);
        // And then to true
        setMetadataBlocksRoot(verseAlias, true);
    }
}
