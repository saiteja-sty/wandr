# Wandr — Setup Guide for VS Code & GitHub

## 🚀 Quick Setup (for the Vercel deployment fix)

If your previous Vercel deployment is broken, the simplest fix:

1. **Delete the old `wandr` folder on your computer**
2. **Unzip this project** somewhere clean (e.g. `C:\projects\wandr\`)
3. Push to GitHub (instructions below)

The `index.html` is at the **root level**, so Vercel finds it automatically with no special configuration.

---

## 📁 What's in This Project

```
wandr/
├── index.html              ← Frontend (Vercel serves this)
├── frontend/index.html     Same file (kept for organization)
├── backend/                Java Spring Boot REST API
├── .vscode/                VS Code settings & extensions
├── README.md
└── vercel.json
```

---

## 🖥️ Open in VS Code

1. Open VS Code
2. **File → Open Folder...** → select your `wandr` folder
3. VS Code will prompt: *"Do you want to install recommended extensions?"* → Click **Install**
4. Wait ~30 seconds for Java extensions to set up

### Run the Frontend
- Right-click `index.html` → **Open with Live Server**
- Or just double-click the file in your file manager

### Run the Backend
- Open `backend/src/main/java/com/wandr/api/WandrApiApplication.java`
- Click the **▶ Run** button above the `main` method
- API runs on http://localhost:8080
- Test it: open http://localhost:8080/api/cities in your browser

---

## 🐙 Push to GitHub

Open a terminal in your `wandr` folder and run:

```bash
git init
git add .
git commit -m "Initial commit: Wandr full-stack project"
git branch -M main
git remote add origin https://github.com/saiteja-sty/wandr.git
git push -u origin main --force
```

> Use `--force` if you want to **overwrite** the messy state from yesterday. Skip `--force` if your repo is empty.

When asked for password, use a **GitHub Personal Access Token**:
- Get one at https://github.com/settings/tokens (Generate new token classic, check `repo`)

---

## 🌐 Deploy to Vercel

If your Vercel project is already connected to GitHub:
- Vercel will auto-redeploy after `git push` (~30 seconds)
- Check **https://wandr-eight-lilac.vercel.app**

If the auto-deploy fails:
1. Go to **https://vercel.com/saiteja-stys-projects/wandr/settings/build-and-deployment**
2. **Output Directory:** Override OFF (leave blank)
3. **Root Directory:** completely blank
4. Save → Redeploy

---

## ✅ Verify Everything Works

| Check | URL |
|---|---|
| Live site | https://wandr-eight-lilac.vercel.app |
| GitHub repo | https://github.com/saiteja-sty/wandr |
| Local frontend | Open `index.html` in browser |
| Local backend | http://localhost:8080/api/cities |

---

## 🆘 Troubleshooting

**Backend won't start?**
- Check Java version: `java -version` → must be 17+
- Check Maven: `mvn -version` → must be 3.6+
- If Maven isn't installed, the backend folder includes Maven Wrapper. Use `./mvnw spring-boot:run` instead.

**Vercel still shows 404?**
- Make sure `index.html` is at the **root** of your repo (not in any subfolder)
- Make sure GitHub shows it correctly: https://github.com/saiteja-sty/wandr/blob/main/index.html

**VS Code Java errors?**
- Open Command Palette (Ctrl+Shift+P) → "Java: Clean Java Language Server Workspace"
- Reload window

---

## 📝 Next Steps

- [ ] Wire frontend to backend (call `/api/cities` from the JS)
- [ ] Add Supabase auth or Spring Security
- [ ] Add PostgreSQL persistence
- [ ] Add real MBTA + MTA API integration
- [ ] Add user dashboard page
