# Wandr 🌆

> *Travel, like a local.*

A polished, location-aware tourist platform that helps visitors navigate cities like the people who actually live there. Live demo and full-stack project showcasing Java Spring Boot + modern frontend design.

**Live demo:** https://wandr-eight-lilac.vercel.app · **Stack:** Java 17 · Spring Boot 3.5 · Maven · HTML/CSS/JS · Vercel

---

## Why Wandr?

Most travel apps spread thin across the world and end up shallow everywhere. Wandr goes the other way — deep on a single city before adding the next. Currently live in **Boston** and **New York**.

Tourists juggle ten apps to plan an afternoon: Maps for directions, transit sites for schedules, Yelp for food, Fandango for movies, Reddit for everything else. Wandr stitches it all into one experience — curated by locals, verified by the team.

## Features

- 🚇 **Public transit** — Live MBTA / MTA schedules
- 🚌 **Free shuttles** — Hospital, university, downtown shuttles tourists never find
- 🍽️ **Food** — Where locals actually eat
- 🛍️ **Shopping** — Boutiques, vintage corners, outlets — by neighborhood
- 🎬 **Movies** — Nearby theaters, indie cinemas, IMAX
- 💎 **Hidden gems** — Locally curated spots Google won't surface
- 📡 **Offline mode** — Save your day's plan without service
- 🤝 **Community-sourced** — Real residents submit; the team verifies
- 🌍 **Smart location detection** — Auto-detects your city; soft-prompts when not yet supported

## Architecture

```
┌─────────────────┐         ┌──────────────────┐         ┌────────────────┐
│   Frontend      │  HTTPS  │  Java Backend    │   SQL   │   PostgreSQL   │
│   HTML/CSS/JS   │ ──────▶ │  Spring Boot 3.5 │ ──────▶ │   (planned)    │
│   (Vercel)      │         │  Maven · Java 17 │         │                │
└─────────────────┘         └──────────────────┘         └────────────────┘
```

**Frontend:** Static single-page app with Apple-style scroll reveals, city-aware data switching, animated SVG icons, and floating gradient orbs. Hosted free on Vercel.

**Backend:** Spring Boot REST API exposing `/api/cities`, `/api/submissions`, `/api/health`. Currently in-memory; Phase C migrates to PostgreSQL.

## Project Status

| Phase | Status |
|---|---|
| Landing page (Boston + NYC, multi-city UX) | ✅ Complete |
| GitHub setup | ✅ Complete |
| Vercel deployment | ✅ Complete |
| Java Spring Boot backend skeleton | ✅ Complete |
| Backend → frontend wiring | 🚧 In progress |
| User auth (Supabase or Spring Security) | 🔜 Planned |
| PostgreSQL persistence | 🔜 Planned |
| Real MBTA + MTA integration | 🔜 Planned |

## Repository Structure

```
wandr/
├── index.html              ← Frontend entry (Vercel finds this)
├── frontend/
│   └── index.html          Same file, also kept here for organization
├── backend/                Java Spring Boot REST API
│   ├── pom.xml             Maven config
│   ├── src/main/java/com/wandr/api/
│   │   ├── WandrApiApplication.java
│   │   ├── config/WebConfig.java
│   │   ├── controller/    REST endpoints
│   │   ├── model/         Data classes
│   │   └── service/       Business logic
│   └── README.md           Backend run instructions
├── .vscode/                VS Code workspace settings
├── docs/screenshots/
├── README.md               This file
├── LICENSE                 MIT
├── .gitignore
└── vercel.json             Vercel config (uses root index.html)
```

## Run Locally

### Frontend
Just open `index.html` in any browser, or run a static server:

```bash
python3 -m http.server 8000
# Visit http://localhost:8000
```

### Backend
Requires Java 17+ and Maven 3.6+:

```bash
cd backend
mvn spring-boot:run
# API runs on http://localhost:8080
# Try:  curl http://localhost:8080/api/cities
```

See [`backend/README.md`](backend/README.md) for endpoint details.

## VS Code Setup

This repo includes `.vscode/settings.json` with sensible defaults. Recommended extensions:

- **Live Server** (frontend preview)
- **Extension Pack for Java** (Spring Boot, Maven, debugger)
- **Spring Boot Extension Pack**
- **GitHub Pull Requests and Issues**

VS Code will prompt you to install these when you open the project.

## License

MIT — see [LICENSE](LICENSE) for details.

## About

Built by [@saiteja-sty](https://github.com/saiteja-sty) as a portfolio project demonstrating full-stack development with Java Spring Boot, location intelligence, and refined frontend design.

---

*Made with care.*
