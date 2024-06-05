plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.security:spring-security-core:6.3.0")
	implementation("org.springframework.security:spring-security-web:6.3.0")

	implementation("com.google.code.gson:gson:2.11.0")

	implementation("org.springframework.boot:spring-boot-starter-json:3.3.0")

	implementation("org.springframework.boot:spring-boot-starter-webflux:3.3.0")

	compileOnly("org.projectlombok:lombok")

	runtimeOnly("com.h2database:h2")

	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")

	// https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter
	implementation("io.springfox:springfox-boot-starter:3.0.0")

	// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent
	implementation("org.springframework.boot:spring-boot-starter-parent:3.3.0")
	// https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui
	implementation("io.springfox:springfox-swagger-ui:3.0.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// https://mvnrepository.com/artifact/org.springframework.restdocs/spring-restdocs-core
	implementation("org.springframework.restdocs:spring-restdocs-core:3.0.1")

	// https://mvnrepository.com/artifact/org.springframework/spring-context
	implementation("org.springframework:spring-context:6.1.8")
	// https://mvnrepository.com/artifact/org.springframework.restdocs/spring-restdocs-mockmvc
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc:3.0.1")

	// https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path
	implementation("com.jayway.jsonpath:json-path:2.9.0")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
