package nl.knaw.dans.lib.dataverse;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import nl.knaw.dans.lib.dataverse.model.DataverseDatasetItem;
import nl.knaw.dans.lib.dataverse.model.DataverseItemType;
import nl.knaw.dans.lib.dataverse.model.DataverseSubverseItem;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

public class DataverseItemDeserializer extends StdDeserializer {

    public DataverseItemDeserializer() {
        this(null);
    }


    public DataverseItemDeserializer(Class vc) {
        super(vc);
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode n = p.getCodec().readTree(p);
        if (DataverseItemType.dataverse.toString().equals(n.get("type").asText())) {
            return new DataverseSubverseItem(n.get("title").asText(), n.get("id").asInt());
        } else if (DataverseItemType.dataset.toString().equals(n.get("type").asText())) {
            DataverseDatasetItem item = new DataverseDatasetItem();
            Optional.ofNullable(n.get("id")).ifPresent(id -> item.setId(id.asInt()));
            Optional.ofNullable(n.get("persistentUrl")).ifPresent(purl -> item.setPersistentUrl(new URI(purl.asText())));


        return null;
    }
}
