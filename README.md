# Getting Started

[English](./README.md) | [简体中文](./README_cn.md)

1. 💝 SDK: <a target="_blank" href="https://search.maven.org/artifact/com.apihug/it-bom"><img src="https://img.shields.io/maven-central/v/com.apihug/it-bom.svg" /></a>
2. 💝 Plugin: [ApiHug - API design Copilot](https://plugins.jetbrains.com/plugin/23534-apihug--api-design-copilot)

## Quick Build

### 0. Build All

Pass by flag `-DonlyProto=true` to build proto modules separately: `gradlew clean build -x test -x wireTest -DonlyProto=true` (remove the `-x stubTest` as only application modules has this task).

```shell - windows
#windows
./gradlew.bat clean build -x test -x wireTest -x stubTest
```

```shell - other
#others
sh gradlew clean build -x test -x wireTest -x stubTest
```

### 1. Build Wire (Individual Optional)

```shell - windows
#windows
./gradlew.bat demo-app-proto:clean wire build -x test -x wireTest
```
```shell - others
#others
sh gradlew demo-app-proto:clean wire build -x test -x wireTest
```

Build proto **ONLY**, check [settings.gradle](settings.gradle) for detail, pass `-DonlyProto=true`:

```shell - windows
#windows
./gradlew.bat clean build -x test -x wireTest -DonlyProto=true
```

```shell - others
#others
sh gradlew clean build -x test -x wireTest -DonlyProto=true
```


### 2. Build Stub (Individual)

Everytime you update application's dependence proto libraries, please run this command to re-generate your stubs.

```shell - windows
#windows
./gradlew.bat demo-app:clean stub build -x test -x stubTest
```

**Lite** compile quick(since [0.7.8-RELEASE](https://github.com/apihug/apihug.com/blob/master/docs/framework/versions/0.7.8.md) default as true, you can switch to `false` manually `-Dlite=false`:

```shell - windows
#windows
./gradlew.bat demo-app:clean stub build -x test -x stubTest
```

```shell - others
#others
sh gradlew demo-app:clean stub build -x test -x stubTest
```

**Lite** compile quick:

```shell - others
#others
sh gradlew demo-app:clean stub build -x test -x stubTest -Dlite=true
```

### 3. Run Application

```shell - windows
#windows
./gradlew.bat demo-app:bootRun
``` 

```shell - others
#others
sh gradlew demo-app:bootRun
``` 

👍Then just kick off the application, in logger output you will find:

```shell
Application 'demo-app' is running! Access URLs:

	Local                             http://localhost:18899/                                         
	External                          http://192.168.0.1:18899/                                        
	OAS                               http://192.168.0.1:18899/v3/api-docs                             
	Actuator                          http://192.168.0.1:18899/management                              
	Profile(s)                        dev    
```

🥳 Congratulations! You have successfully started your application!

## Reference Documentation

For further reference, please consider the following sections:

1. [Apihug.com GitHub](https://github.com/apihug/apihug.com/)
2. [Apihug Wire Plugin](https://github.com/apihug/apihug.com/blob/master/docs/handbook/004_dsl_implement_wire.md)
3. [Apihug Stub Plugin](https://github.com/apihug/apihug.com/blob/master/docs/handbook/005_dsl_implement_stub.md)
4. [Apihug Trivial](https://github.com/apihug/apihug.com/blob/master/docs/handbook/099_trivial.md)
5. [Apihug FAQ](https://github.com/apihug/apihug.com/blob/master/docs/handbook/999_faq.md)
6. [Official Gradle documentation](https://docs.gradle.org)
7. [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/gradle-plugin/reference/html/)
8. [ApiHug - API design Copilot IDEA Plugin](https://plugins.jetbrains.com/plugin/23534-apihug--api-design-copilot) 
9. [ApiHug - IDEA FAQ](https://github.com/apihug/apihug.com/blob/master/docs/IDE/999_FAQ.md)
10. [ApiHug - IDEA Handbook](https://github.com/apihug/apihug.com/blob/master/docs/IDE/README.md)
11. [ApiHug101-Bilibili](https://www.bilibili.com/video/BV1KK421k7J8/)
12. [ApiHug101-Youtube](https://youtube.com/@ApiHug?si=C1yw0poHA01zbmyj)
13. [ApiHug Home](https://apihug.github.io)