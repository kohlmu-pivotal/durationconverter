plugins {
  kotlin("jvm") version "2.0.0"
  id("io.spring.dependency-management") version "1.1.5"
  id("org.springframework.boot") version "2.7.18"
}

group = "com.vmware.gemfire"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  maven {
    credentials {
      username = property("gemfireRepoUsername") as String
      password = property("gemfireRepoPassword") as String
    }
    url = uri("https://packages.broadcom.com/artifactory/gemfire/")
  }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.vmware.gemfire:gemfire-core:10.0.2")
  implementation("com.vmware.gemfire:gemfire-cq:10.0.2")
  implementation("com.vmware.gemfire:spring-boot-2.7-gemfire-10.0:1.0.5")
  implementation("com.vmware.gemfire:spring-boot-actuator-2.7-gemfire-10.0:1.0.5")
  implementation("com.vmware.gemfire:spring-boot-session-2.7-gemfire-10.0:1.0.5")
}

tasks.test {
  useJUnitPlatform()
}
kotlin {
  jvmToolchain(8)
}
