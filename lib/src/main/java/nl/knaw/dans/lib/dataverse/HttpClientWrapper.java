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
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Helper class that wraps an HttpClient, the configuration data and a Jackson object mapper. It implements generic methods for
 * sending HTTP requests to the server and deserializing the responses received.
 */
class HttpClientWrapper {

    private final DataverseClientConfig config;
    private final HttpClient httpClient;
    private final ObjectMapper mapper;

    HttpClientWrapper(DataverseClientConfig config, HttpClient httpClient, ObjectMapper mapper) {
        this.config = config;
        this.httpClient = httpClient;
        this.mapper = mapper;
    }

    public <T> HttpResponse post(Path subPath, T json) throws IOException {
        HttpPost post = new HttpPost(config.getBaseUrl().resolve(subPath.toString()));
        post.setEntity(new StringEntity(mapper.writeValueAsString(json)));
        return httpClient.execute(post);
    }

    public <D> DataverseHttpResponse<D> get(Path subPath, Class<D> outputClass) throws IOException, DataverseException {
        HttpGet get = new HttpGet(config.getBaseUrl().resolve(subPath.toString()));
        HttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            return new DataverseHttpResponse<>(httpClient.execute(get), outputClass, mapper);
        else
            throw new DataverseException("Status: " + response.getStatusLine(), null);
    }

}
