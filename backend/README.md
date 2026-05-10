# Wandr Backend — Spring Boot

Java 17 + Spring Boot 3.5 + Maven REST API powering Wandr's location-based recommendation engine.

## Run Locally

```bash
cd backend
./mvnw spring-boot:run         # macOS/Linux
mvnw.cmd spring-boot:run       # Windows
```

Or, if you have Maven installed system-wide:

```bash
mvn spring-boot:run
```

The API starts on **http://localhost:8080**.

## Quick Test

```bash
curl http://localhost:8080/api/
curl http://localhost:8080/api/health
curl http://localhost:8080/api/cities
curl http://localhost:8080/api/cities?status=live
curl http://localhost:8080/api/submissions
curl http://localhost:8080/api/submissions?city=Boston
```

## Endpoints

| Method | Path | Description |
|---|---|---|
| `GET`  | `/api/`                       | Service info |
| `GET`  | `/api/health`                 | Health check |
| `GET`  | `/api/cities`                 | All supported cities |
| `GET`  | `/api/cities?status=live`     | Filter by status: `live`, `coming_soon`, `in_progress`, `vote_next` |
| `GET`  | `/api/submissions`            | All community submissions |
| `GET`  | `/api/submissions?city=Boston`| Submissions for a city |
| `POST` | `/api/submissions`            | Create a new submission (JSON body) |

## Example POST

```bash
curl -X POST http://localhost:8080/api/submissions \
  -H "Content-Type: application/json" \
  -d '{
    "authorName": "Test User",
    "city": "Boston",
    "quote": "The best secret restaurant in the North End is...",
    "tag": "Hidden gem"
  }'
```

## Project Structure

```
backend/
├── pom.xml                    Maven config (Spring Boot 3.5, Java 17)
├── src/
│   ├── main/
│   │   ├── java/com/wandr/api/
│   │   │   ├── WandrApiApplication.java   Main entry point
│   │   │   ├── config/
│   │   │   │   └── WebConfig.java         CORS for frontend
│   │   │   ├── controller/
│   │   │   │   ├── HealthController.java  /api/, /api/health
│   │   │   │   ├── CityController.java    /api/cities
│   │   │   │   └── SubmissionController.java
│   │   │   ├── model/
│   │   │   │   ├── City.java
│   │   │   │   └── Submission.java
│   │   │   └── service/
│   │   │       ├── CityService.java
│   │   │       └── SubmissionService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/wandr/api/
│           └── WandrApiApplicationTests.java
```

## Tech Stack

- **Java 17** — LTS, supported by all major cloud platforms
- **Spring Boot 3.5** — current production-ready version
- **Maven** — build and dependency management
- **Spring Validation** — request validation via Jakarta annotations
- **Lombok** — reduces boilerplate (`@Data`, `@AllArgsConstructor`)

## Roadmap (Phase C)

- Replace in-memory storage with **PostgreSQL** via Spring Data JPA
- Add **Spring Security** + JWT auth
- Wire up **MBTA** and **MTA** real-time APIs via `RestClient`
- Add **Google Places** integration for restaurant/shopping data
- Containerize with Docker and deploy to Render or Fly.io
