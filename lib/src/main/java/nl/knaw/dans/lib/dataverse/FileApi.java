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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileApi extends AbstractApi {

    private static final Logger log = LoggerFactory.getLogger(DatasetApi.class);
    private static final String persistendId = ":persistentId/";

    private final Path targetBase;
    private final String id;
    private final boolean isPersistentId;


    protected FileApi(HttpClientWrapper httpClientWrapper, String id, boolean isPersistentId) {
        super(httpClientWrapper);
        this.targetBase = Paths.get("api/files/");
        this.id = id;
        this.isPersistentId = isPersistentId;
    }

    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#restrict-files
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#uningest-a-file
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#reingest-a-file
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#redetect-file-type
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#replacing-files
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#getting-file-metadata
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#adding-file-metadata
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#updating-file-metadata
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#editing-variable-level-metadata
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#get-provenance-json-for-an-uploaded-file
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#get-provenance-description-for-an-uploaded-file
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#create-update-provenance-json-and-provide-related-entity-name-for-an-uploaded-file
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#create-update-provenance-description-for-an-uploaded-file
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#delete-provenance-json-for-an-uploaded-file
    // TODO: https://guides.dataverse.org/en/latest/api/native-api.html#datafile-integrity

}
