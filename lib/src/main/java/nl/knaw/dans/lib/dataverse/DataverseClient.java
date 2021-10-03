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

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.URI;

/**
 * Object that lets your code talk to a Dataverse instance.
 */
public class DataverseClient {

    private final URI baseUrl;
    private final HttpClient httpClient;

    /**
     * Creates a DataverseClient.
     *
     * @param baseUrl the base URL of the Dataverse instance
     */
    public DataverseClient(URI baseUrl) {
        this(baseUrl, HttpClients.createDefault());
    }

    /**
     * Creates a DataverseClient with a custom HttpClient.
     *
     * @param baseUrl the base URL of the Dataverse instance
     * @param httpClient the <code>org.apache.http.client.HttpClient</code> to use when interacting with Dataverse
     */
    public DataverseClient(URI baseUrl, HttpClient httpClient) {
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
    }

    public WorkflowsApi workflows() {
        return new WorkflowsApi(baseUrl.resolve("api/workflows/"), httpClient);
    }

    public DatasetApi dataset(String pid) {
        return new DatasetApi();
    }

    public DataverseApi dataverse(String alias) {
        return new DataverseApi(baseUrl, httpClient, alias);
    }

}
