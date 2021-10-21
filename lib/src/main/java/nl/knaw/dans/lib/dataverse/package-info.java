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
/**
 * Main package for the DANS Dataverse Client Library
 * ==================================================
 *
 * The starting point to work with the libary is the class {@link nl.knaw.dans.lib.dataverse.DataverseClient}. It is instantiated with a
 * {@link nl.knaw.dans.lib.dataverse.DataverseClientConfig} to point it to a particular Dataverse server and provide it with the necessary credentials,
 * e.g. an API token.
 *
 * Dataverse's API is divided up into several endpoints that allow you to query and modify various entities on the server, such as dataverses, datasets, files,
 * user acounts, etc. The following example shows how you would retrieve the description for the root dataverse. The API token should of course be replaced with
 * a valid one, if you try this out.
 *
 * <!-- @formatter:off -->
 * ```java
 *  // Replace the second constructor argument with your Dataverse API token
 *  DataverseClientConfig config = new DataverseClientConfig(new URI("http://localhost:8080"), "d679391a-75bf-4735-a46a-2ff4a79b9919");
 *  DataverseClient client = new DataverseClient(config);
 *  DataverseHttpResponse<Dataverse> r = client.dataverse("root").view();
 *  System.out.println(r.getData().getDescription());
 * ```
 * <!-- @formatter:on -->
 *
 */
package nl.knaw.dans.lib.dataverse;


/*



 */