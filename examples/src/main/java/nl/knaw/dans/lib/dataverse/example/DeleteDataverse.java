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

import nl.knaw.dans.lib.dataverse.DataverseHttpResponse;
import nl.knaw.dans.lib.dataverse.ExampleBase;
import nl.knaw.dans.lib.dataverse.model.DataMessage;
import nl.knaw.dans.lib.dataverse.model.Dataverse;
import nl.knaw.dans.lib.dataverse.model.DataverseContact;
import nl.knaw.dans.lib.dataverse.model.DataverseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class DeleteDataverse extends ExampleBase {

    private static final Logger log = LoggerFactory.getLogger(DeleteDataverse.class);

    public static void main(String[] args) throws Exception {
        DataverseHttpResponse<DataMessage> r = client.dataverse("test").delete();
        log.info("Status Line: {}", r.getHttpResponse().getStatusLine());
        log.info("Message: {}", r.getData().getMessage());
    }
}
