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

import nl.knaw.dans.lib.dataverse.model.Dataverse;
import org.apache.http.client.HttpClient;

import java.net.URI;

public class DataverseApi extends AbstractApi {

    private String alias;

    public DataverseApi(URI baseUrl, HttpClient httpClient, String alias) {
        super(baseUrl, httpClient);
    }

    public DataverseResponse<Dataverse> view() {
        //        HttpPost post = new HttpGet(baseUrl.resolve(invocationId));
        //        return httpClient.execute(post);
        return null;
    }
}
