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
import nl.knaw.dans.lib.dataverse.model.ResumeMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.net.URI;

public class WorkflowsApi {

    private static final ObjectMapper mapper = new ObjectMapper();

    private final URI baseUrl;
    private final HttpClient httpClient;

    public WorkflowsApi(URI baseUrl, HttpClient httpClient) {
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
    }

    public HttpResponse resume(String invocationId, ResumeMessage resumeMessage) throws IOException {
        HttpPost post = new HttpPost(baseUrl.resolve(invocationId));
        post.setEntity(new StringEntity(mapper.writeValueAsString(resumeMessage)));
        return httpClient.execute(post);
    }

}
