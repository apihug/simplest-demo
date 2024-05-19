# 现在开始

[English](./README.md) | [简体中文](./README_cn.md)

1. 💝 SDK: <a target="_blank" href="https://search.maven.org/artifact/com.apihug/it-bom"><img src="https://img.shields.io/maven-central/v/com.apihug/it-bom.svg" /></a>
2. 💝 Plugin: [ApiHug - API design Copilot](https://plugins.jetbrains.com/plugin/23534-apihug--api-design-copilot)

## 快速构建

### 0. 整体构建项目

可以传入 `-DonlyProto=true` 独立编译proto模块: `gradlew clean build -x test -x wireTest -DonlyProto=true` (不要带 `-x stubTest` 这个是实现模块独有任务). 

```shell - windows
#windows
./gradlew.bat clean build -x test -x wireTest -x stubTest
```

```shell - others
#others
sh gradlew clean build -x test -x wireTest -x stubTest
```

### 1. 单独构建 Wire(协议) (可选)

```shell - windows
#windows
./gradlew.bat demo-app-proto:clean wire build -x test -x wireTest
```
```shell - others
#others
./gradlew.bat demo-app-proto:clean wire build -x test -x wireTest
```

**只** 编译 proto 模块, 检查 [settings.gradle](settings.gradle) 关于 `-DonlyProto=true` 配置说明:

```shell - windows
#windows
./gradlew.bat clean build -x test -x wireTest -DonlyProto=true
```

```shell - others
#others
sh gradlew clean build -x test -x wireTest -DonlyProto=true
```

### 2. 单独构建 Stub(应用)

每次修改了应用的依赖协议(自己、第三方)，都要重新跑下这个命令，重新生成 stubs。


```shell - windows
#windows
./gradlew.bat demo-app:clean stub build -x test -x stubTest
```

**轻量** 快速编译([0.7.8-RELEASE](https://gitee.com/dearxuecom/apihug.com/blob/master/docs/framework/versions/0.7.8_cn.md)以后SDK 已经默认轻量级, 你可以转成 `-Dlite=false`:

```shell - windows
#windows
./gradlew.bat demo-app:clean stub build -x test -x stubTest 
```

```shell - others
#others
sh gradlew demo-app:clean stub build -x test -x stubTest
```

**轻量** 快速编译:

```shell - others
#others
sh gradlew demo-app:clean stub build -x test -x stubTest
```

### 3. 启动应用

```shell - windows
#windows
./gradlew.bat demo-app:bootRun
``` 
```shell - others
#others
sh gradlew demo-app:bootRun
``` 

👍 跑完上面命令后，在控制台可以发现输出如下:

```shell
Application 'demo-app' is running! Access URLs:

	Local                             http://localhost:18899/                                         
	External                          http://192.168.0.1:18899/                                        
	OAS                               http://192.168.0.1:18899/v3/api-docs                             
	Actuator                          http://192.168.0.1:18899/management                              
	Profile(s)                        dev    
```

🥳 恭喜! 开启您愉悦的开发之旅吧!

## 参考

更多内容敬请参考:

1. [Apihug.com GitHub](https://github.com/apihug/apihug.com/)
2. [Apihug Wire 插件](https://github.com/apihug/apihug.com/blob/master/docs/handbook/004_dsl_implement_wire.md)
3. [Apihug Stub 插件](https://github.com/apihug/apihug.com/blob/master/docs/handbook/005_dsl_implement_stub.md)
4. [Apihug 其他](https://github.com/apihug/apihug.com/blob/master/docs/handbook/099_trivial.md)
5. [Apihug FAQ](https://github.com/apihug/apihug.com/blob/master/docs/handbook/999_faq.md)
6. [Gradle 官方文档](https://docs.gradle.org)
7. [Spring Boot Gradle 插件参考](https://docs.spring.io/spring-boot/docs/3.2.0/gradle-plugin/reference/html/)
8. [ApiHug - API设计助手IDEA插件](https://plugins.jetbrains.com/plugin/23534-apihug--api-design-copilot)
9. [ApiHug - IDEA FAQ](https://github.com/apihug/apihug.com/blob/master/docs/IDE/999_FAQ.md)
10. [ApiHug - IDEA 手册](https://github.com/apihug/apihug.com/blob/master/docs/IDE/README.md)
11. [ApiHug101-Bilibili](https://www.bilibili.com/video/BV1KK421k7J8/)
12. [ApiHug101-Youtube](https://youtube.com/@ApiHug?si=C1yw0poHA01zbmyj)
13. [ApiHug Home](https://apihug.github.io)