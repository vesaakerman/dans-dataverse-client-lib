/*
 * Copyright (C) 2021 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.knaw.dans.lib.dataverse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import nl.knaw.dans.lib.dataverse.model.dataset.CompoundField;
import nl.knaw.dans.lib.dataverse.model.dataset.ControlledMultiValueField;
import nl.knaw.dans.lib.dataverse.model.dataset.ControlledSingleValueField;
import nl.knaw.dans.lib.dataverse.model.dataset.MetadataBlock;
import nl.knaw.dans.lib.dataverse.model.dataset.MetadataField;
import nl.knaw.dans.lib.dataverse.model.dataset.PrimitiveMultiValueField;
import nl.knaw.dans.lib.dataverse.model.dataset.PrimitiveSingleValueField;
import nl.knaw.dans.lib.dataverse.model.dataset.SingleValueField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

public class MetadataFieldDeserializerTest {

    private static final File testFileDirectory = new File("src/test/resources/dataverse-response/");

    private ObjectMapper mapper;

    @BeforeEach
    public void beforeEach() {
        mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(MetadataField.class, new MetadataFieldDeserializer());
        mapper.registerModule(module);
    }

    private File getTestFile(String name) {
        return new File(testFileDirectory, name);
    }

    @Test
    public void canDeserializePrimitiveSingleValueField() throws Exception {
        MetadataField f = mapper.readValue(getTestFile("primitive-single.json"), MetadataField.class);
        Assertions.assertEquals(PrimitiveSingleValueField.class, f.getClass());
    }

    @Test
    public void canDeserializePrimitiveMultiValueField() throws Exception {
        MetadataField f = mapper.readValue(getTestFile("primitive-multi.json"), MetadataField.class);
        Assertions.assertEquals(PrimitiveMultiValueField.class, f.getClass());
    }

    @Test
    public void canDeserializeControlledSingleValueField() throws Exception {
        MetadataField f = mapper.readValue(getTestFile("controlled-single.json"), MetadataField.class);
        Assertions.assertEquals(ControlledSingleValueField.class, f.getClass());
    }

    @Test
    public void canDeserializeControlledMultiValueField() throws Exception {
        MetadataField f = mapper.readValue(getTestFile("controlled-multi.json"), MetadataField.class);
        Assertions.assertEquals(ControlledMultiValueField.class, f.getClass());
    }

    @Test
    public void canDeserializeCompoundField() throws Exception {
        MetadataField f = mapper.readValue(getTestFile("compound.json"), MetadataField.class);
        Assertions.assertEquals(CompoundField.class, f.getClass());
        CompoundField compoundField = (CompoundField) f;
        Assertions.assertEquals("DANS", compoundField.getValue().get(0).get("authorAffiliation").getValue());
    }

    @Test
    public void canReadAsPartOfLargerObject() throws Exception {
        MetadataBlock block = mapper.readValue(getTestFile("metadatablock.json"), MetadataBlock.class);
        Assertions.assertEquals(PrimitiveSingleValueField.class, block.getFields().get(0).getClass());
        Assertions.assertEquals("Citation Metadata", block.getDisplayName());
    }

}
