# 02 - Java + Gradle (Spring Boot) 🌱

A tiny Spring Boot REST API built with **Gradle**. It's your **deployment practice target**: a small, real, runnable app that *you* will Dockerize, ship, and run. The app code is done - the DevOps is your job.

---

## The 7 DevOps Questions

| # | Question | Answer |
|---|----------|--------|
| 1 | **Language / runtime?** | Java 17 (Spring Boot) |
| 2 | **How do you build it?** | `./gradlew build` (or `gradle build` if Gradle is installed) |
| 3 | **What's the artifact?** | An executable `.jar` in `build/libs/` |
| 4 | **Start command?** | `java -jar build/libs/*.jar` (or `./gradlew bootRun` for dev) |
| 5 | **Which port?** | `8080` (override with the `SERVER_PORT` env var) |
| 6 | **Config / secrets?** | Environment variables (e.g. `SERVER_PORT`) - never hardcode |
| 7 | **Health check URL?** | `GET /health` -> `{"status":"ok"}` |

These are the only things your Dockerfile / pipeline / Kubernetes manifests need to know. Once you have them, the universal recipe never changes.

---

## Run it locally

You need **Java 17+** installed. Gradle is optional - if you don't have it, use the wrapper (`./gradlew`).

> No Gradle installed? That's fine. Use the `./gradlew` wrapper that ships with the repo. If the wrapper files aren't present, install Gradle (`sdk install gradle` / `brew install gradle` / `choco install gradle`) and use `gradle` instead of `./gradlew`.

### 1. Build it

```bash
./gradlew build          # macOS / Linux
gradlew.bat build        # Windows
# or, if Gradle is installed globally:
gradle build
```

This produces the artifact: `build/libs/demo-0.0.1-SNAPSHOT.jar`.

### 2. Start it

```bash
# Run the built jar:
java -jar build/libs/*.jar

# OR run straight from source during development:
./gradlew bootRun
```

By default it listens on **http://localhost:8080**.
To use a different port:

```bash
SERVER_PORT=9090 java -jar build/libs/*.jar     # macOS / Linux
```

### 3. Test all 3 endpoints

```bash
curl http://localhost:8080/
# {"message":"Welcome! This is a Java + Gradle (Spring Boot) practice app.","stack":"Java 17 / Spring Boot / Gradle"}

curl http://localhost:8080/health
# {"status":"ok"}

curl http://localhost:8080/api/items
# [{"id":1,"name":"Notebook"},{"id":2,"name":"Pen"},{"id":3,"name":"Backpack"},{"id":4,"name":"Water Bottle"}]
```

(JSON key order may vary - that's normal.)

---

## Your Practice Mission 🎯

The app is intentionally **just the app** - no Dockerfile, no CI, no Kubernetes. **Building those is the practice.** Work through this checklist, mapping each step to the module where you learned it:

- [ ] **Dockerize it** - write a `Dockerfile` (base image `eclipse-temurin:17`), build the image, run a container. **(M14)**
- [ ] **Compose it** - add a `docker-compose.yml` to run it (and any services) together. **(M15)**
- [ ] **CI/CD** - write a `Jenkinsfile`: build -> test -> image -> deploy. **(M17)**
- [ ] **VM** - run it on a Vagrant / VirtualBox VM. **(M13)**
- [ ] **Configure** - provision the server with Ansible. **(M16)**
- [ ] **Kubernetes** - Deployment + Service + Ingress; then scale it. **(M18 / M19)**
- [ ] **Cloud** - deploy on AWS (EC2), then rebuild the infra with Terraform. **(M20 / M21)**

> 💡 Stuck? Open the matching TaskBoard module and adapt its files - the pattern transfers directly. The tools don't care that this app is in Java. That's the whole point.
