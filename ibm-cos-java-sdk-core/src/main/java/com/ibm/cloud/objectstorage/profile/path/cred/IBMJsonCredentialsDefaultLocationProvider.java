/* 
* Copyright 2017 IBM Corp. All Rights Reserved. 
* 
* Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with 
* the License. You may obtain a copy of the License at 
* 
* http://www.apache.org/licenses/LICENSE-2.0 
* 
* Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on 
* an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the 
* specific language governing permissions and limitations under the License. 
*/ 
package com.ibm.cloud.objectstorage.profile.path.cred;

import java.io.File;

import com.ibm.cloud.objectstorage.annotation.SdkInternalApi;
import com.ibm.cloud.objectstorage.profile.path.AwsDirectoryBasePathProvider;

/**
 * Load shared credentials file from the default location (~/.bluemix/cos_credentials).
 */
@SdkInternalApi
public class IBMJsonCredentialsDefaultLocationProvider extends AwsDirectoryBasePathProvider {

    private static final String DEFAULT_CREDENTIAL_JSON_FILENAME = "cos_credentials";

    @Override
    public File getLocation() {
        File credentialProfiles = new File(getIbmDirectory(), DEFAULT_CREDENTIAL_JSON_FILENAME);
        if (credentialProfiles.exists() && credentialProfiles.isFile()) {
            return credentialProfiles;
        }
        return null;
    }
}
