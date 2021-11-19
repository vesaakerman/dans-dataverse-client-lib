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
package nl.knaw.dans.lib.dataverse.model.workflow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LockTest extends ModelWorkflowFixture {
    private static final Class<Lock> classUnderTest = Lock.class;

    @Test
    public void canDeserialize() throws Exception {
        Lock lock = mapper.readValue(getTestJsonFileFor(classUnderTest), classUnderTest);
        assertEquals(classUnderTest, lock.getClass());
        assertEquals("test", lock.getLockType());
        assertEquals("2021-11-19", lock.getDate());
        assertEquals("user001", lock.getUser());
        assertEquals("just for fun...", lock.getMessage());
    }

    @Test
    public void roundTrip() throws Exception {
        Lock lock = roundTrip(getTestJsonFileFor(classUnderTest), classUnderTest);
        assertEquals(classUnderTest, lock.getClass());
    }
}
