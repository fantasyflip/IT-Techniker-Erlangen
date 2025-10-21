# PRO – Projektunterricht (AI4All)

Dieses Verzeichnis enthält alle Inhalte des Projektunterrichts (PRO) für das Schuljahr 25/26. Das Projekt dreht sich um Künstliche Intelligenz (KI) und nutzt den öffentlich zugänglichen Kurs „AI4All“. Die Übungen und Trainings werden überwiegend in Jupyter Notebooks durchgeführt.

Ziel: eine praxisnahe Einführung in KI-Grundlagen, Datenbearbeitung und einfache ML-Workflows. Dazu erstellen und bearbeiten wir Jupyter Notebooks (`.ipynb`) in JupyterLab, führen Codezellen aus, visualisieren Ergebnisse und dokumentieren Erkenntnisse direkt im Notebook.

Kurslink: KI-Campus – „KI für alle“
https://ki-campus.org/lernangebote/kurse/ki-fuer-alle-1

## Inhalt dieses Ordners

- Notebooks zu den Kapiteln/Modulen des AI4All-Kurses
- Begleitende Skripte oder Hilfsdateien (z. B. kleine Datensätze, Utils)
- Optionale Lösungen/Beispiele und Zusatzmaterial

- `W01/`
  - `Notebooks/` – Jupyter Notebooks zu den Lektionen der Woche 01
  - `data/` – kleine Beispieldaten nur für diese Woche
  - `utils/` – optionale Hilfsfunktionen
- `W02/`
  - `Notebooks/`
  - `data/`
  - `utils/`
- `W03/` …

## Voraussetzungen

- Ein aktuelles Python 3 (empfohlen: 3.10 oder 3.11)
- Entweder Miniconda/Anaconda (empfohlen für Einsteiger) oder Python + venv
- JupyterLab (verbindlich; ersetzt das klassische Jupyter Notebook)

Die folgenden Anleitungen zeigen Installationswege für macOS und Windows. Empfohlen wird die Kommandozeilen-Installation mit Miniconda (schnell, reproduzierbar). Alternativ ist Python + venv möglich.

---

## Installation auf macOS (CLI, empfohlen)

Die folgenden Befehle führen eine stille Installation aus. Mit der stillen Installation akzeptierst du die Anaconda Terms of Service.

1. Öffne Terminal (zsh). Für Apple Silicon (M1/M2/M3) oder Intel unterscheiden sich die Installer-URLs. Beispiel Apple Silicon:
   ```zsh
   curl -L https://repo.anaconda.com/miniconda/Miniconda3-latest-MacOSX-arm64.sh -o miniconda.sh
   bash miniconda.sh -b -p "$HOME/miniconda"
   rm miniconda.sh
   ```
   Für Intel-Macs:
   ```zsh
   curl -L https://repo.anaconda.com/miniconda/Miniconda3-latest-MacOSX-x86_64.sh -o miniconda.sh
   bash miniconda.sh -b -p "$HOME/miniconda"
   rm miniconda.sh
   ```
2. Shell initialisieren und Terminal neu starten:
   ```zsh
   source "$HOME/miniconda/bin/activate"
   conda init zsh
   ```

3) Umgebung erstellen und JupyterLab installieren:

   ```zsh
   # Einmalig: Anaconda Terms of Service für die Standard-Channels akzeptieren
   conda tos accept --override-channels --channel https://repo.anaconda.com/pkgs/main
   conda tos accept --override-channels --channel https://repo.anaconda.com/pkgs/r

   conda create -n ai4all python=3.11 -y
   conda activate ai4all
   conda install -y jupyterlab
   ```

### Option B: Mit Python + venv

1. Stelle sicher, dass Python 3 installiert ist (z. B. via Homebrew):
   ```zsh
   brew install python@3.11
   ```
2. Erstelle und aktiviere ein virtuelles Environment im Projektordner:
   ```zsh
   python3 -m venv .venv
   source .venv/bin/activate
   ```

3) Installiere JupyterLab:
   ```zsh
   python -m pip install --upgrade pip
   pip install jupyterlab
   ```

---

## Installation auf Windows (CLI, empfohlen)

1. Öffne die Eingabeaufforderung (cmd) und führe den Quickstart aus (stille Installation):
   ```bat
   curl https://repo.anaconda.com/miniconda/Miniconda3-latest-Windows-x86_64.exe -o .\miniconda.exe
   start /wait "" .\miniconda.exe /S /InstallationType=JustMe /AddToPath=0 /RegisterPython=0 /D=%USERPROFILE%\miniconda3
   del .\miniconda.exe
   ```
2. Starte ein neues „Anaconda Prompt“ (oder setze temporär den Pfad) und initialisiere conda, falls nötig:
   ```bat
   "%USERPROFILE%\miniconda3\Scripts\activate.bat"
   conda init cmd.exe
   ```
   Danach die Eingabeaufforderung neu starten.

3) Umgebung erstellen und JupyterLab installieren:

   ```bat
   rem Einmalig: Anaconda Terms of Service für die Standard-Channels akzeptieren
   conda tos accept --override-channels --channel https://repo.anaconda.com/pkgs/main
   conda tos accept --override-channels --channel https://repo.anaconda.com/pkgs/r
   conda tos accept --override-channels --channel https://repo.anaconda.com/pkgs/msys2

   conda create -n ai4all python=3.11 -y
   conda activate ai4all
   conda install -y jupyterlab
   ```

### Option B: Mit Python + venv

1. Installiere Python von https://www.python.org/downloads/ und setze beim Installer das Häkchen „Add Python to PATH“.
2. Öffne PowerShell oder die Eingabeaufforderung und erstelle ein virtuelles Environment im Projektordner:
   ```bat
   python -m venv .venv
   .venv\Scripts\activate
   ```

3) Installiere JupyterLab:
   ```bat
   python -m pip install --upgrade pip
   pip install jupyterlab
   ```

---

## JupyterLab verwenden

1. In den Projektordner `PRO` und anschließend in den jeweiligen Wochenordner (z. B. `W01/`) wechseln. Innerhalb der Woche idealerweise im Unterordner `Notebooks/` arbeiten.
2. Die zuvor erstellte Umgebung aktivieren (conda oder venv).

3) JupyterLab starten:
   - macOS / Linux:
     ```zsh
         jupyter lab
     ```
   - Windows (Anaconda Prompt oder aktiviertes venv):
     ```bat
         jupyter lab
     ```
4) Ein Browserfenster öffnet sich (Standard: http://localhost:8888) mit der JupyterLab-Oberfläche. Navigiere zum gewünschten Ordner und erstelle/öffne ein Notebook (`+ Launcher` → `Notebook: Python 3 (ipykernel)`).

5. Zellen ausführen mit Shift+Enter. Schreibe Textdokumentation in Markdown-Zellen.
6. Regelmäßig speichern. Über „Kernel“ kannst du neu starten bzw. die Ausgaben zurücksetzen.

### Empfehlung: VS Code Integration

Wenn du ohnehin mit VS Code arbeitest, kannst du Notebooks direkt darin öffnen und ausführen:

- Installiere die VS Code Erweiterungen „Python“ und „Jupyter“.
- Öffne eine `.ipynb`-Datei, wähle oben rechts das Python-Environment (z. B. `ai4all`) als Kernel.
- Führe Zellen über die Play-Buttons aus, nutze die Variable- und Plot-Viewer.

---

## Tipps & Best Practices

- Trenne Umgebungen je Projekt/Kurs: verhindert Paketkonflikte.
- Committe keine großen Daten und keine automatisch erzeugten Ordner:
  - `.ipynb_checkpoints/`
  - `.venv/` oder `env/`
  - `__pycache__/`
- Falls der Kernel in Jupyter fehlt, installiere den Kernel explizit in der aktiven Umgebung:
  ```sh
  python -m ipykernel install --user --name ai4all --display-name "Python (ai4all)"
  ```
- Wenn Port 8888 schon belegt ist, starte mit einem anderen Port:
  ```sh
  jupyter lab --port 8889
  ```
- Aktualisiere regelmäßig `pip`/Pakete, wenn Installationen fehlschlagen.
- Fehler „CondaToSNonInteractiveError“: Akzeptiere die Anaconda Terms of Service für die Standard-Channels (einmalig), bevor du Umgebungen erstellst:
  ```sh
  conda tos accept --override-channels --channel https://repo.anaconda.com/pkgs/main
  conda tos accept --override-channels --channel https://repo.anaconda.com/pkgs/r
  ```

---

## Kurze Befehlsübersicht

- Umgebung (conda) erstellen/aktivieren:

  ```sh
   # Einmalig TOS akzeptieren (nur wenn noch nicht erfolgt)
   conda tos accept --override-channels --channel https://repo.anaconda.com/pkgs/main
   conda tos accept --override-channels --channel https://repo.anaconda.com/pkgs/r

  conda create -n ai4all python=3.11 -y
  conda activate ai4all
  ```

- JupyterLab installieren/ starten:
  ```sh
   conda install -y jupyterlab
   jupyter lab
  ```
- Alternativ mit venv:
  ```sh
  python -m venv .venv
  # macOS/Linux
  source .venv/bin/activate
  # Windows
  .venv\Scripts\activate
   pip install jupyterlab
   jupyter lab
  ```
