# Azure Spring Cloud Getting Started

Overview

## Description

## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage
### 00. Prerequisite
#### Install Azure CLI
```
$ brew update
$ brew install azure-cli
```
#### Login Azure
```
$ az login

$ az account list -o table
Name            CloudName    SubscriptionId                        State    IsDefault
--------------  -----------  ------------------------------------  -------  -----------
PA-syanagihara  AzureCloud   aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee  Enabled  True
```

```
$ az account set --subscription <target subscription ID>
```

#### Install the Azure CLI extension
```
$ az extension add --name spring-cloud

The installed extension 'spring-cloud' is in preview.
```

### 01. Create a Service Instance on the Azure portal

- [Azure Portal for ASC](https://ms.portal.azure.com/#create/Microsoft.AppPlatform)

![portal](images/portal-default.png)

#### Fill out the form
![portal-filled](images/portal-filled.png)

- **Resource group**: `azure-spring-cloud`
- **Service Instance Name**: `azure-spring-cloud-gs`

- `Review and create` -> `Create`

![created-instance](images/created-instance.png)

#### Configure the CLI to use Service Instance

```
$ az configure --defaults group=<RESOURCE_GROUP_NAME>
$ az configure --defaults spring-cloud=<SERVICE_INSTANCE_NAME>
$ az configure -l
```

### 02. Create a First Simple App
`Azure Spring Cloud Resource Group` -> `Create App`

![create-app](images/create-app.png)

- App name
- Java environment
- CPU
- Memory/GB
- App Instance Count

![create-app-basic](images/create-app-basic.png)

#### Deploy a First App
##### By GUI
```
$ az spring-cloud app deploy -n hello-azure --jar-path hello-azure/build/libs/hello-azure-0.0.1-SNAPSHOT.jar
```
```json
Command group 'spring-cloud' is in preview. It may be changed/removed in a future release.
{
  "id": "/subscriptions/7accdeff-e6fd-4e03-839a-9011201fdea9/resourceGroups/azure-spring-cloud/providers/Microsoft.AppPlatform/Spring/azure-spring-cloud-gs/apps/hello-azure/deployments/default",
  "name": "default",
  "properties": {
    "active": true,
    "appName": "hello-azure",
    "createdTime": null,
    "deploymentSettings": {
      "cpu": 1,
      "environmentVariables": null,
      "instanceCount": 1,
      "jvmOptions": null,
      "memoryInGb": 1,
      "runtimeVersion": "Java_8"
    },
    "instances": [
      {
        "discoveryStatus": "DOWN",
        "name": "hello-azure-default-11-6c776599bc-db5wl",
        "reason": null,
        "status": "Running"
      },
      {
        "discoveryStatus": "UP",
        "name": "hello-azure-default-11-d9d55fcbd-2gbhw",
        "reason": null,
        "status": "Retiring"
      }
    ],
    "provisioningState": "Succeeded",
    "source": {
      "artifactSelector": null,
      "relativePath": "resources/453cde82348c45cdd99ebc1614151706fd9b2d00c8727dcdeb4a9150d0e82a74-2019112111-1fdc2c6e-905f-41ba-bf2c-d809f891f523",
      "type": "Jar",
      "version": null
    },
    "status": "Upgrading"
  },
  "resourceGroup": "azure-spring-cloud",
  "type": "Microsoft.AppPlatform/Spring/apps/deployments"
}
```

##### By CLI
```
$ az spring-cloud app create -n hello-azure -g azure-spring-cloud
```

```json
Command group 'spring-cloud' is in preview. It may be changed/removed in a future release.
{
  "id": "/subscriptions/7accdeff-e6fd-4e03-839a-9011201fdea9/resourceGroups/azure-spring-cloud/providers/Microsoft.AppPlatform/Spring/azure-spring-cloud-gs/apps/hello-azure",
  "name": "hello-azure",
  "properties": {
    "activeDeployment": {
      "id": "/subscriptions/7accdeff-e6fd-4e03-839a-9011201fdea9/resourceGroups/azure-spring-cloud/providers/Microsoft.AppPlatform/Spring/azure-spring-cloud-gs/apps/hello-azure/deployments/default",
      "name": "default",
      "properties": {
        "active": true,
        "appName": "hello-azure",
        "createdTime": null,
        "deploymentSettings": {
          "cpu": 1,
          "environmentVariables": null,
          "instanceCount": 1,
          "jvmOptions": null,
          "memoryInGb": 1,
          "runtimeVersion": "Java_8"
        },
        "instances": [
          {
            "discoveryStatus": "DOWN",
            "name": "hello-azure-default-11-84849db567-wch8n",
            "reason": "Not ready for connecting",
            "status": "Starting"
          }
        ],
        "provisioningState": "Succeeded",
        "source": {
          "artifactSelector": null,
          "relativePath": "<default>",
          "type": "Jar",
          "version": null
        },
        "status": "Upgrading"
      },
      "resourceGroup": "azure-spring-cloud",
      "type": "Microsoft.AppPlatform/Spring/apps/deployments"
    },
    "activeDeploymentName": "default",
    "createdTime": "2019-11-21T12:10:32.443000+00:00",
    "persistentDisk": {
      "mountPath": "/persistent",
      "sizeInGb": 0,
      "usedInGb": 0
    },
    "provisioningState": "Succeeded",
    "public": false,
    "temporaryDisk": {
      "mountPath": "/tmp",
      "sizeInGb": 5
    },
    "url": null
  },
  "resourceGroup": "azure-spring-cloud",
  "type": "Microsoft.AppPlatform/Spring/apps"
}
```
```
$ az spring-cloud app deploy -n hello-azure -g azure-spring-cloud --jar-path hello-azure/build/libs/hello-azure-0.0.1-SNAPSHOT.jar
```
```json
Command group 'spring-cloud' is in preview. It may be changed/removed in a future release.
{
  "id": "/subscriptions/7accdeff-e6fd-4e03-839a-9011201fdea9/resourceGroups/azure-spring-cloud/providers/Microsoft.AppPlatform/Spring/azure-spring-cloud-gs/apps/hello-azure/deployments/default",
  "name": "default",
  "properties": {
    "active": true,
    "appName": "hello-azure",
    "createdTime": null,
    "deploymentSettings": {
      "cpu": 1,
      "environmentVariables": null,
      "instanceCount": 1,
      "jvmOptions": null,
      "memoryInGb": 1,
      "runtimeVersion": "Java_8"
    },
    "instances": [
      {
        "discoveryStatus": "DOWN",
        "name": "hello-azure-default-11-55765d59bd-2tlrb",
        "reason": null,
        "status": "Running"
      },
      {
        "discoveryStatus": "UP",
        "name": "hello-azure-default-11-84849db567-wch8n",
        "reason": null,
        "status": "Retiring"
      }
    ],
    "provisioningState": "Succeeded",
    "source": {
      "artifactSelector": null,
      "relativePath": "resources/453cde82348c45cdd99ebc1614151706fd9b2d00c8727dcdeb4a9150d0e82a74-2019112112-389a331f-15ab-4093-a7ad-65f0ec63a8a8",
      "type": "Jar",
      "version": null
    },
    "status": "Upgrading"
  },
  "resourceGroup": "azure-spring-cloud",
  "type": "Microsoft.AppPlatform/Spring/apps/deployments"
}
```


#### Running App

![running-app](images/running-app.png)

```
$ curl <TEST_ENDPOINT>
```
### 03.Query App logs
`Log Analytics Workspace` -> `Display Logs`

- Query
```
AppPlatformLogsforSpring
| where AppName == "hello-azure"
| limit 50
```

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
