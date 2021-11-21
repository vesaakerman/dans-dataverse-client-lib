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

import java.net.URI;

public class DataverseClientConfig {
    private final URI baseUrl;
    private final String apiToken;
    private int awaitLockStateMaxNumberOfRetries =  30;
    private int awaitLockStateMillisecondsBetweenRetries = 500;

    public DataverseClientConfig(URI baseUrl, String apiToken, int awaitLockStateMaxNumberOfRetries, int awaitLockStateMillisecondsBetweenRetries) {
        this(baseUrl, apiToken);
        this.awaitLockStateMaxNumberOfRetries = awaitLockStateMaxNumberOfRetries;
        this.awaitLockStateMillisecondsBetweenRetries = awaitLockStateMillisecondsBetweenRetries;
    }

    /**
     * Configuration data for the {@link DataverseClient}.
     *
     * @param baseUrl the base URL of the Dataverse server to communicate with
     * @param apiToken the API token used for authorization
     */
    public DataverseClientConfig(URI baseUrl, String apiToken) {
        this.baseUrl = baseUrl;
        this.apiToken = apiToken;
    }

    public URI getBaseUrl() {
        return baseUrl;
    }

    public String getApiToken() {
        return apiToken;
    }

    public int getAwaitLockStateMaxNumberOfRetries() {
        return awaitLockStateMaxNumberOfRetries;
    }

    public void setAwaitLockStateMaxNumberOfRetries(int awaitLockStateMaxNumberOfRetries) {
        this.awaitLockStateMaxNumberOfRetries = awaitLockStateMaxNumberOfRetries;
    }

    public int getAwaitLockStateMillisecondsBetweenRetries() {
        return awaitLockStateMillisecondsBetweenRetries;
    }

    public void setAwaitLockStateMillisecondsBetweenRetries(int awaitLockStateMillisecondsBetweenRetries) {
        this.awaitLockStateMillisecondsBetweenRetries = awaitLockStateMillisecondsBetweenRetries;
    }
}
