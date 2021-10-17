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
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Helper class that wraps an HttpClient, the configuration data and a Jackson object mapper. It implements generic methods for sending HTTP requests to the server and deserializing the responses
 * received.
 */
class HttpClientWrapper implements MediaTypes {
    private static final Logger log = LoggerFactory.getLogger(HttpClientWrapper.class);

    private final DataverseClientConfig config;
    private final HttpClient httpClient;
    private final ObjectMapper mapper;

    HttpClientWrapper(DataverseClientConfig config, HttpClient httpClient, ObjectMapper mapper) {
        this.config = config;
        this.httpClient = httpClient;
        this.mapper = mapper;
    }

    public HttpResponse postString(Path subPath, String s, String mediaType, Map<String, String> parameters, Map<String, String> headers) throws IOException {
        HttpPost post = new HttpPost(buildURi(subPath, parameters));
        post.setHeader(HttpHeaders.CONTENT_TYPE, mediaType);
        post.setHeader("X-Dataverse-key", config.getApiToken());
        headers.forEach(post::setHeader);
        post.setEntity(new StringEntity(s));
        return httpClient.execute(post);
    }

    public HttpResponse postJsonString(Path subPath, String s, Map<String, String> parameters, Map<String, String> headers) throws IOException {
        return postString(subPath, s, APPLICATION_JSON, parameters, headers);
    }

    public HttpResponse postJsonLdString(Path subPath, String s, Map<String, String> parameters, Map<String, String> headers) throws IOException {
        return postString(subPath, s, APPLICATION_JSON_LD, parameters, headers);
    }

    public <T> DataverseHttpResponse<T> postModelObjectAsJson(Path subPath, T modelObject, Map<String, String> parameters, Map<String, String> headers, Class<?>... c) throws IOException {
        return new DataverseHttpResponse<T>(postJsonString(subPath, mapper.writeValueAsString(modelObject), parameters, headers), mapper, c);
    }

    public <T> HttpResponse post(Path subPath, T json) throws IOException {
        HttpPost post = new HttpPost(config.getBaseUrl().resolve(subPath.toString()));
        post.setEntity(new StringEntity(mapper.writeValueAsString(json)));
        return httpClient.execute(post);
    }

    public <D> DataverseHttpResponse<D> get(Path subPath, Class<?>... outputClass) throws IOException, DataverseException {
        return get(subPath, new HashMap<>(), outputClass);
    }

    public <D> DataverseHttpResponse<D> get(Path subPath, Map<String, String> parameters, Class<?>... outputClass) throws IOException, DataverseException {
        HttpGet get = new HttpGet(buildURi(subPath, parameters));

        HttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            return new DataverseHttpResponse<>(httpClient.execute(get), mapper, outputClass);
        else
            throw new DataverseException("Status: " + response.getStatusLine(), null);
    }

    private URI buildURi(Path subPath, Map<String, String> parameters) {
        try {
            URI uri = new URIBuilder(config.getBaseUrl().resolve(subPath.toString())).setParameters(parameters.entrySet().stream()
                .map(e -> new BasicNameValuePair(e.getKey(), e.getValue()))
                .collect(Collectors.toList())).build();
            log.debug("buildUri: {}", uri.toASCIIString());
            return uri;
        }
        catch (URISyntaxException e) {
            throw new IllegalStateException("Programming error? Constructed invalid URI internally", e);
        }
    }

}
