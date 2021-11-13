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
package nl.knaw.dans.lib.dataverse.model.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchResultTest extends ModelSearchFixture {
    private static final Class<SearchResult> classUnderTest = SearchResult.class;

    @Test
    public void canDeserialize() throws Exception {
        SearchResult r = mapper.readValue(getTestJsonFileFor(classUnderTest), classUnderTest);
        assertEquals(classUnderTest, r.getClass());
        assertEquals(0, r.getStart());
        assertEquals("*", r.getQ());
        assertEquals("Manual test", r.getItems().get(0).getName());
        assertEquals("doi:10.5072/DAR/NYBJJT", r.getItems().get(0).getGlobalId());
        assertEquals("Positor01, D", r.getItems().get(0).getContacts().get(0).getName());
    }

    @Test
    public void roundTrip() throws Exception {
        SearchResult c = roundTrip(getTestJsonFileFor(classUnderTest), classUnderTest);
        assertEquals(classUnderTest, c.getClass());
    }
}