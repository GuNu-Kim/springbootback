# 1단계: Gradle로 빌드
FROM gradle:8.2.1-jdk17 AS build

# 작업 디렉터리 설정
WORKDIR /app

# 프로젝트 파일 복사
COPY --chown=gradle:gradle . .

# dos2unix 설치 (gradlew 줄바꿈 변환용)
# Window에서는 개행을 CRLF(\r\n) 으로 표현
# MAC에서는 LF(\n) 으로 표현하기 때문에 줄 바꿈 변환 필요
USER root
RUN apt-get update && apt-get install -y dos2unix && rm -rf /var/lib/apt/lists/*

# gradlew에 실행 권한 부여
RUN chmod +x ./gradlew
RUN dos2unix ./gradlew

# 빌드파일 삭제
RUN rm -rf /app/build
RUN chown -R gradle:gradle /app

# 빌드 실행 (테스트 제외)
# Gradle 캐시 디렉토리 활용
USER gradle
RUN ./gradlew clean build -x test --no-daemon --stacktrace

# 2단계: 경량 OpenJDK 이미지로 실행 (Temurin)
FROM eclipse-temurin:17-jdk-jammy

# 작업 디렉터리 설정
WORKDIR /app

# 빌드 결과 JAR 복사
COPY --from=build /app/build/libs/*.jar app.jar

# 포트 설정
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]