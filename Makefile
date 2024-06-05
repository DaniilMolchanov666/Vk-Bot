.DEFAULT_GOAL := build-run

run:
	java -jar ./build/libs/VK_Bot-0.0.1-SNAPSHOT.jar

build:
	./gradlew build

test:
	./gradlew test
report:
	./gradlew jacocoTestReport
build-run: build run

.PHONY: build
