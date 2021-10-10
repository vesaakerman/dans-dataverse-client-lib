package nl.knaw.dans.lib.dataverse;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.knaw.dans.lib.dataverse.model.Ab;
import nl.knaw.dans.lib.dataverse.model.DataverseEnvelope;
import nl.knaw.dans.lib.dataverse.model.TestObject;
import nl.knaw.dans.lib.dataverse.model.dataset.DatasetVersion;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class Test {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonText = FileUtils.readFileToString(new File("/Users/janm/git/test/dans-dataverse-client-lib/lib/src/test/resources/dataverse-response/test2.json"), StandardCharsets.UTF_8);

        JavaType inner = mapper.getTypeFactory().constructParametricType(List.class, DatasetVersion.class);
        JavaType outer = mapper.getTypeFactory().constructParametricType(DataverseEnvelope.class, inner);

        DataverseEnvelope<List<DatasetVersion>> e = mapper.readValue(jsonText, outer);

        System.out.println(e.getData().get(0).getCreateTime());






    }
}