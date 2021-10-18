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
package nl.knaw.dans.lib.dataverse.model;

import com.fasterxml.jackson.databind.JavaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataverseItemListTest extends ModelFixture {
    private static final Class<?> classUnderTest = DataverseItem.class;
    private JavaType listOfDataverseItemType;

    @BeforeEach
    public void setUp() {
        listOfDataverseItemType = mapper.getTypeFactory().constructParametricType(List.class, DataverseItem.class);
    }

    @Test
    public void canDeserialize() throws Exception {
        List<DataverseItem> list = mapper.readValue(getTestJsonFileFor(classUnderTest), listOfDataverseItemType);
        assertEquals(DataverseSubverseItem.class, list.get(0).getClass());
        assertEquals(DataverseSubverseItem.class, list.get(1).getClass());
        assertEquals(DataverseSubverseItem.class, list.get(2).getClass());
        assertEquals(DataverseDatasetItem.class, list.get(3).getClass());
    }

    @Test
    public void roundTrip() throws Exception {
        List<DataverseItem> list = roundTrip(getTestJsonFileFor(classUnderTest), listOfDataverseItemType);
        assertEquals(DataverseSubverseItem.class, list.get(0).getClass());
        assertEquals(DataverseSubverseItem.class, list.get(1).getClass());
        assertEquals(DataverseSubverseItem.class, list.get(2).getClass());
        assertEquals(DataverseDatasetItem.class, list.get(3).getClass());
    }
}
