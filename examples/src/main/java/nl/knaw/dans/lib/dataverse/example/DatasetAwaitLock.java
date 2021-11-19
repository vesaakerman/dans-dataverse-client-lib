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
package nl.knaw.dans.lib.dataverse.example;

import nl.knaw.dans.lib.dataverse.DataverseException;
import nl.knaw.dans.lib.dataverse.ExampleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DatasetAwaitLock extends ExampleBase {

    private static final Logger log = LoggerFactory.getLogger(DatasetAwaitLock.class);

    // Notice: Because there are no locks active in this test situation,
    // this program should always return a message about RuntimeException.
    public static void main(String[] args) throws Exception {
        String persistentId = args[0];
        int awaitLockStateMaxNumberOfRetries = Integer.parseInt(args[1]);
        int awaitLockStateMillisecondsBetweenRetries = Integer.parseInt(args[2]);
        try {
            client.dataset(persistentId).awaitLock("test", awaitLockStateMaxNumberOfRetries, awaitLockStateMillisecondsBetweenRetries);
            log.info("awaitUnLock method executed successfully");
        } catch (RuntimeException e) {
            log.error(String.format("awaitLock method threw a RuntimeException: %s", e.getMessage()));
        }
        catch (IOException | DataverseException | InterruptedException e) {
            log.error(String.format("awaitLock method threw an Exception: %s", e.getMessage()));
        }
    }
}
