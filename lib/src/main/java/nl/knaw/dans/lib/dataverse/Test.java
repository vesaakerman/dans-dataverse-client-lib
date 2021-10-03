package nl.knaw.dans.lib.dataverse;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.knaw.dans.lib.dataverse.model.Dataverse;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class Test {

    public static void main(String[] args) throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        String m = FileUtils.readFileToString(new File("/Users/janm/git/test/dans-dataverse-client-lib/lib/src/test/resources/dataverse-info.json"), "UTF-8");
        System.out.println(m);
        DataverseResponse<Dataverse> r = new DataverseResponse<Dataverse>(m, Dataverse.class);

        System.out.println(r.getData().getAlias());
        System.out.println(r.getData().getName());
        System.out.println(r.getMessage().getMessage());
    }

}
