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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Response from Dataverse. A typical response from Dataverse is a JSON document with the following format:
 *
 * <pre>
 * {
 *      "status": "OK",
 *      "data": {
 *          // A JSON object for the specific API endpoint
 *      }
 *  }
 * </pre>
 *
 *
 *
 * {@link nl.knaw.dans.lib.dataverse.model}.
 *
 * @param <D> the type of the payload of the response message
 */
public class DataverseResponse<D> {

    private static final Logger log = LoggerFactory.getLogger(DataverseResponse.class);
    private static final ObjectMapper defaultResponseMapper = new ObjectMapper();
    private final ObjectMapper mapper;

    private final String bodyText;
    private final JavaType dataType;

    protected DataverseResponse(String bodyText, Class<D> dataClass) {
        this(bodyText, dataClass, null);
    }

    protected DataverseResponse(String bodyText, Class<D> dataClass, ObjectMapper customMapper) {
        log.trace(bodyText);
        this.bodyText = bodyText;
        this.dataType = getMapper().getTypeFactory().constructParametricType(DataverseEnvelope.class, dataClass);
        this.mapper = customMapper;
    }

    private ObjectMapper getMapper() {
        if (mapper == null)
            return defaultResponseMapper;
        else
            return mapper;
    }

    public DataverseEnvelope<D> getEnvelope() throws IOException {
        return getMapper().readValue(bodyText, dataType);
    }

    public D getData() throws IOException {
        return getEnvelope().getData();
    }
}
