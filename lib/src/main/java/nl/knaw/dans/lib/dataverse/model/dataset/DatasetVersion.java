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
package nl.knaw.dans.lib.dataverse.model.dataset;

public class DatasetVersion {
    private int id;
    private int datasetId;
    private String datasetPersistentId;
    private String storageIdentifier;
    private int versionNumber;
    private int versionMinorNumber;
    private String versionState; // TODO: to enum
    private String unf;
    private String lastUpdateTime; // TODO: timestamp?
    private String releaseTime; // TODO: timestamp?
    private String createTime; // TODO: timestamp?
    private boolean fileAccessRequest;
//    private termsOfUse: Option[String] = None,
//    license: Option[String] = None,
//    protocol: Option[String] = None,
//    authority: Option[String] = None,
//    identifier: Option[String] = None,
//    metadataBlocks: MetadataBlocks = Map.empty,
//    files: List[FileMeta] = List.empty

}
