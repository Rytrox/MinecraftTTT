# MinecraftTTT

# Planung des Projekts.

# Funktionalitäten:
- Optionaler MySQL-Support (Andernfalls lokale Speicherung in Files)
- Stats-System mit verfügbarem Ranking (Top-Spieler werden optional angezeigt.)
- Traitor, - Detectiveshop
- Tester (Aktivier und Deaktivierbar)
- Benutzerfreundliches Map-Setup
- Deathmatch für tote Spieler.
- Pässe-System
- Randomkill-Detector (+ maximale Falschkill-Quote)
- Bungeecord und Multiworld-Support (Multiworld = Bukkitserver mit mehreren Welten. Kein Multiverse nötig)
- Kurze Einführung in TTT (Spielereinführung / Tutorial)
- Gun or Bow (Einstellbar, ob Schusswaffen oder Bögen verwendet werden)

# Aufgabenplan:
```
1. Map-Setup
1.0 Configaufbau
1.1 Spawndefinierung für Spieler
1.2 Testerdefinierung
1.3 Fallendefinierung
1.4 Arenen
1.4.1 Eigene Worldborder (COD-like)
```

2. GameStates
```
2.1 Enums für GameStates
2.2 GameStateHandler
2.3 GameState-Klassen
2.3.1 LobbyPhase
(2.3.1.0 TutorialPhase)
2.3.2 GamePhase
(2.3.2.0 DeathMatchPhase)
2.3.2.1 Tester
2.3.2.2 Waffen / Bögen
2.3.3 ShutdownPhase
2.4 Shops / Benutzeroberfläche
```


3. Datenbank / Files
```
3.1 Mapconfigs
3.2 Stats
3.3 Custom-Events für StatsAPI
3.4 GUIs
```



# Aufgaben Timeout:
```
Map-Setup
Datenbank / Files
  1. ConfigManager und CustomLanguage integriert. Test mit Comments in Config erfolgreich (f091698d34fedd6eac3a8b7e3867b11bc1b9cb26)
```

# Aufgaben Sether:
```
GameStates
Datenbank / Files
```
