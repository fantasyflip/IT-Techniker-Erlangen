## Task 1

Ein Schwimmverein bereitet sich auf einen Wettkampf vor. 15 Schwimmer möchten sich vor dem Wettkampf im Becken aufwärmen.
Allerdings gibt es im Aufwärmbecken nur 3 freie Schwimmbahnen. Die anderen Bahnen sind gesperrt.
Nachdem ein Schwimmer mit dem Aufwärmen fertig ist, muss er zu seinem Trainer gehen und sich in das Trainingsbuch (eine Textdatei) eintragen lassen, um zu bestätigen, dass er das Warm-up absolviert hat. Der Trainer kann aber immer nur einen Schwimmer auf einmal eintragen.

## Task 2

Nach dem Aufwärmtraining absolvieren die Schwimmer einen Sprint-Test. Jeder Schwimmer schwimmt 3 kurze Sprints hintereinander. Der Trainer notiert die drei Zeiten (in Sekunden) in einer Textdatei namens `sprint_zeiten.txt`.
Um sich für das Finale zu qualifizieren, muss ein Schwimmer in seinen drei Sprints mindestens ein einziges Mal exakt 42 Sekunden geschwommen sein.
Gib an wie viele Schwimmer sich für das Finale qualifiziert haben, indem du die Textdatei `sprint_zeiten.txt` ausliest und die Zeiten analysierst.

> **Ein kleiner Regex-Tipp vorab:**
> Wenn du einfach nur nach "42" suchst, würde Java auch die 142 finden. Um das zu verhindern, solltest du dir das Konzept von sogenannten Wortgrenzen (Word Boundaries) in Regex ansehen. In Java schreibt man das oft mit `\\b`.