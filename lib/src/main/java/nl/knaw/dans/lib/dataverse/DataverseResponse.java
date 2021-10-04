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
 * <!-- @formatter:off -->
 * ```json
 *  {
 *    "status": "OK",
 *    "data": {
 *        "myfield": "myvalue"
 *    }
 *  }
 * ```
 * <!-- @formatter:on -->
 *
 * {@link nl.knaw.dans.lib.dataverse.model}.
 *
 * @param <D> the type of the payload of the response message
 */
public class DataverseResponse<D> {

    private static final Logger log = LoggerFactory.getLogger(DataverseResponse.class);
    private final ObjectMapper mapper;

    private final String bodyText;
    private final JavaType dataType;

    protected DataverseResponse(String bodyText, Class<D> dataClass, ObjectMapper mapper) {
        log.trace(bodyText);
        this.bodyText = bodyText;
        this.mapper = mapper;
        this.dataType = mapper.getTypeFactory().constructParametricType(DataverseEnvelope.class, dataClass);
    }

    /**
     * @return
     * @throws IOException
     */
    public DataverseEnvelope<D> getEnvelope() throws IOException {
        return mapper.readValue(bodyText, dataType);
    }

    public D getData() throws IOException {
        return getEnvelope().getData();
    }
}
