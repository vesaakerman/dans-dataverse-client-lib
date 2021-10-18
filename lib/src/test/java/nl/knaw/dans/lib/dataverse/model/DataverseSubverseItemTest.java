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

import nl.knaw.dans.lib.dataverse.model.dataverse.DataverseItem;
import nl.knaw.dans.lib.dataverse.model.dataverse.DataverseSubverseItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataverseSubverseItemTest extends ModelFixture {
    private static final Class<?> classUnderTest = DataverseSubverseItem.class;

    @Test
    public void canDeserialize() throws Exception {
        DataverseItem i = mapper.readValue(getTestJsonFileFor(classUnderTest), DataverseItem.class);
        assertEquals(classUnderTest, i.getClass());
    }

    @Test
    public void roundTrip() throws Exception {
        DataverseItem i = roundTrip(getTestJsonFileFor(classUnderTest), DataverseItem.class);
        assertEquals(classUnderTest, i.getClass());
    }
}
