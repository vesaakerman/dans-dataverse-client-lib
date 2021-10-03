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

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;

import java.io.IOException;

/**
 * Response from Dataverse. It gives access both to the raw HTTP response and the message as an object of one of the types in
 * {@link nl.knaw.dans.lib.dataverse.model}.
 *
 * @param <D> the type of the payload of the response message
 */
public class DataverseResponse<D> {

    private static final ObjectMapper defaultResponseMapper = new ObjectMapper();
    private final ObjectMapper mapper;

    private final HttpResponse httpResponse;
    private final String entityString;
    private final JavaType dataType;

    protected DataverseResponse(HttpResponse httpResponse, Class<D> dataClass, ObjectMapper customMapper) {
        this.httpResponse = httpResponse;
        this.entityString = null;
        this.dataType = getMapper().getTypeFactory().constructParametricType(DataverseMessage.class, dataClass);
        this.mapper = customMapper;
    }

    protected DataverseResponse(String entityString, Class<D> dataClass, ObjectMapper customMapper) {
        this.httpResponse = null;
        this.entityString = entityString;
        this.dataType = getMapper().getTypeFactory().constructParametricType(DataverseMessage.class, dataClass);
        this.mapper = customMapper;
    }

    private ObjectMapper getMapper() {
        if (mapper == null)
            return defaultResponseMapper;
        else
            return mapper;
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public DataverseMessage<D> getMessage() throws IOException {
        if (httpResponse == null)
            return getMapper().readValue(entityString, dataType);
        else
            return getMapper().readValue(httpResponse.getEntity().getContent(), dataType);
    }

    public D getData() throws IOException {
        return getMessage().getData();
    }
}
