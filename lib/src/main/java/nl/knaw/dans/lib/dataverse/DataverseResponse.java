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

import org.apache.http.HttpResponse;

/**
 * Response from Dataverse. It gives access both to the raw HTTP response and the message as an object of one of the types in
 * {@link nl.knaw.dans.lib.dataverse.model}.s
 *
 * @param <T> the payload of the response
 */
public class DataverseResponse<T> {

    private final HttpResponse httpResponse;
    private final T message;

    protected DataverseResponse(HttpResponse httpResponse, T message) {
        this.httpResponse = httpResponse;
        this.message = message;
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public T getMessage() {
        return message;
    }
}
