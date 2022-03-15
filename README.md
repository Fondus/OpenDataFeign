# OpenDataFeign
[![Java CI Build](https://github.com/Vipcube/OpenDataFeign/actions/workflows/maven.yml/badge.svg)](https://github.com/Vipcube/OpenDataFeign/actions/workflows/maven.yml)

OpenDataFeign provides Taiwan's OpenData OpenFeign integrations for Spring Boot apps through autoconfiguration.

## Building

To build the source you will need to install JDK (>=11) and Maven (>=3.3.3).

This project uses Maven for most build-related activities, and you should be able to get off the ground quite quickly by cloning the project you are interested in and typing:

```shell
mvn install
```

## Requirements

These projects compile with Spring Boot `2.5.10` and Spring Cloud `2020.0.5`.

But when used it, you still provided your spring boot dependencies. Because we set Spring Boot and Spring Cloud dependencies scope is `provided`.

## Implements OpenData

Feign client implements Taiwan's OpenData as below:

| Module         | API URL |
|:--------------:|:-----:|
| WRA-FHY OpenData | https://fhy.wra.gov.tw/WraApi |
| CWB-Weather OpenData | https://opendata.cwb.gov.tw/index |

## Authors and Contributors

This project are developed by：

- [@Vipcube](https://github.com/Vipcube)
- [@JackChao1111](https://github.com/JackChao1111)

And maintained by [@Vipcube](https://github.com/Vipcube)
