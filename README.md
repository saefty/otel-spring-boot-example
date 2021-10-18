## Scope

This repo includes the AWS Open Telemetry Agent for logging and monitoring the application.

## Issues

* When using logback, the MDC context is set and logged properly.
* When using log4j2, there is no MDC context being set, nor is there the possibility to log the trace ids.

## How to use this project for reproducing the issue

The otel agent can be changed in the dedicated `*-build.gradle` file.
The native otel agent aswell aas the aws otel agent are included into this repository.

```groovy
bootRun {
	jvmArgs("-javaagent:" + project.rootDir.path + "/aws-opentelemetry-agent.jar")
}
```

### Logback Test

```shell
cp build-logback.gradle build.gradle
./gradlew bootRun -Djavaagent:/Users/saeftaher/Downloads/demo/src/aws-opentelemetry-agent.jar
./gradlew bootRun
```

### Log4j Test

```shell
cp build-log4j2.gradle build.gradle
./gradlew bootRun
```
