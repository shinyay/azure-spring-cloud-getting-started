# First Azure Spring Cloud App

Overview

## Description

### Configure build.gradle
#### Repository for Azure Dependency
```
repositories {
	maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
}
```

#### Dependency for Spring Cloud
```
extra["springCloudVersion"] = "Hoxton.RC2"

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}
```

#### Dependency for Azure Sprinc Cloud
```
dependencies {
	implementation("org.springframework.cloud:spring-cloud-starter-config")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
	implementation("com.microsoft.azure:spring-cloud-starter-azure-spring-cloud-client:2.1.0-SNAPSHOT")
}
```

## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
