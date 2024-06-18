# 📚 Monorepo für die Technikerschule Erlangen

Dieses Repository enthält alle Programmierprojekte, die im Rahmen der Ausbildung an der Technikerschule Erlangen erstellt wurden.

## 📂 Projektstruktur

Die Projekte sind in einer hierarchischen Struktur organisiert:

1. **1. Ebene:** Jahr der Ausbildung
2. **2. Ebene:** Fach
3. **3. Ebene:** Projekte

Beispiel:

```
/YY-YY
    /FACH1
        /Projekt1
        /Projekt2
    /FACH2
        /Projekt1
```

## 💻 Installationsanleitung

Folgen Sie diesen Schritten, um das Repository auf Ihrem lokalen Rechner einzurichten:

1. **Repository klonen**:
   ```sh
   git clone https://github.com/username/technikerschule-erlangen-monorepo.git
   ```
2. **In das Projektverzeichnis wechseln**:
   ```sh
   cd technikerschule-erlangen-monorepo
   ```
3. **Abhängigkeiten installieren (optional)**:
   Navigieren Sie in das entsprechende Projektverzeichnis und installieren Sie die Abhängigkeiten. Beispiel:
   ```sh
   cd jahr1/fach1/project1
   npm install
   ```

## 📝 Beitragen

Beiträge sind willkommen! Bitte folgen Sie diesen Schritten, um beizutragen:

1. **Fork dieses Repositories**
2. **Einen neuen Branch erstellen**:
   ```sh
   git checkout -b feature/neues-projekt
   ```
3. **Änderungen durchführen und committen**:
   ```sh
   git commit -m 'feat(ProjektName): Beschreibung der Änderungen'
   ```
4. **Branch pushen**:
   ```sh
   git push origin feature/neues-projekt
   ```
5. **Pull-Request erstellen**
