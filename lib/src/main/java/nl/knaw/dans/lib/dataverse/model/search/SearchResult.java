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
package nl.knaw.dans.lib.dataverse.model.search;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Map;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SearchResult {
    private String q;
    private int totalCount;
    private int start;
    private Map<String, String> spellingAlternatives;
    private List<ResultItem> items;
    private int countInResponse;

    public SearchResult() {
    }

    public SearchResult(String q, int totalCount, int start, Map<String, String> spellingAlternatives, List<ResultItem> items, int countInResponse) {
        this.q = q;
        this.totalCount = totalCount;
        this.start = start;
        this.spellingAlternatives = spellingAlternatives;
        this.items = items;
        this.countInResponse = countInResponse;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Map<String, String> getSpellingAlternatives() {
        return spellingAlternatives;
    }

    public void setSpellingAlternatives(Map<String, String> spellingAlternatives) {
        this.spellingAlternatives = spellingAlternatives;
    }

    public List<ResultItem> getItems() {
        return items;
    }

    public void setItems(List<ResultItem> items) {
        this.items = items;
    }

    public int getCountInResponse() {
        return countInResponse;
    }

    public void setCountInResponse(int countInResponse) {
        this.countInResponse = countInResponse;
    }
}
