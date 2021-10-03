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
package nl.knaw.dans.lib.dataverse.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dataverse {
    private int id;
    private int ownerId;
    private String name;
    private String alias;
    private boolean permissionRoot;
    private String affiliation;
    private String description;
    private String dataverseType;
    private String storageDriverLabel;
    private String creationDate;

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty
    public int getOwnerId() {
        return ownerId;
    }

    @JsonProperty
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getAlias() {
        return alias;
    }

    @JsonProperty
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @JsonProperty
    public boolean isPermissionRoot() {
        return permissionRoot;
    }

    @JsonProperty
    public void setPermissionRoot(boolean permissionRoot) {
        this.permissionRoot = permissionRoot;
    }

    @JsonProperty
    public String getAffiliation() {
        return affiliation;
    }

    @JsonProperty
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    public String getDataverseType() {
        return dataverseType;
    }

    @JsonProperty
    public void setDataverseType(String dataverseType) {
        this.dataverseType = dataverseType;
    }

    @JsonProperty
    public String getStorageDriverLabel() {
        return storageDriverLabel;
    }

    @JsonProperty
    public void setStorageDriverLabel(String storageDriverLabel) {
        this.storageDriverLabel = storageDriverLabel;
    }

    @JsonProperty
    public String getCreationDate() {
        return creationDate;
    }

    @JsonProperty
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
