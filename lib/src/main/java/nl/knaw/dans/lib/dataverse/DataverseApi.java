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
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;

public class DataverseApi extends AbstractApi {

    private static final Logger log = LoggerFactory.getLogger(DataverseApi.class);
    private static final String subPath = "api/dataverses";
    private final String alias;
    private final URI targetUri;

    public DataverseApi(URI baseUrl, HttpClient httpClient, String alias) {
        super(baseUrl, httpClient);
        this.alias = alias;
        this.targetUri = baseUrl.resolve(subPath + "/").resolve(alias);
    }

    /**
     * See <a target="_blank" href="https://guides.dataverse.org/en/latest/api/native-api.html#view-a-dataverse-collection">View a Dataverse Collection</a>
     *
     * @return Information about a dataverse
     * @throws IOException when I/O problems occur during the interaction with Dataverse
     * @throws DataverseException when Dataverse fails to perform the request
     */
    public DataverseHttpResponse<Dataverse> view() throws IOException, DataverseException {
        log.trace("");
        HttpGet get = new HttpGet(targetUri);
        HttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            return new DataverseHttpResponse<>(httpClient.execute(get), Dataverse.class, null);
        else
            throw new DataverseException("Status: " + response.getStatusLine(), null);
    }

}
