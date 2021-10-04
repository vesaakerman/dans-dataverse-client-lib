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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Object that lets your code talk to a Dataverse server.
 */
public class DataverseClient {

    private final HttpClientWrapper httpClientWrapper;
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Creates a DataverseClient.
     *
     * @param config configuration for this DataverseClient
     */
    public DataverseClient(DataverseClientConfig config) {
        this(config, HttpClients.createDefault());
    }

    /**
     * Creates a DataverseClient with a custom HttpClient.
     *
     * @param config     configuration for this DataverseClient
     * @param httpClient the `org.apache.http.client.HttpClient` to use when interacting with Dataverse
     */
    public DataverseClient(DataverseClientConfig config, HttpClient httpClient) {
        this.httpClientWrapper = new HttpClientWrapper(config, httpClient, mapper);
    }

    public WorkflowsApi workflows() {
        return new WorkflowsApi(httpClientWrapper);
    }

    public DatasetApi dataset(String pid) {
        return new DatasetApi();
    }

    public DataverseApi dataverse(String alias) {
        return new DataverseApi(httpClientWrapper, alias);
    }

}
