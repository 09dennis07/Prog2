package tha.prog2.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Die Klasse {@code GameDataProvider} stellt Spieldaten der Bundesliga zur Verfügung,
 * die aus einer Ressourcendatei geladen werden. Die Daten werden lokal gehalten und
 * nicht live aus dem Internet bezogen.
 */
public class GameDataProvider {
    private Map<Integer, ArrayList<Game>> games = new HashMap<>();

    /**
     * Erstellt ein neues {@code GameDataProvider}-Objekt und lädt Spieldaten aus einer Ressourcendatei.
     *
     * @throws IOException falls ein Fehler beim Laden oder Lesen der Datei auftritt
     */
    public GameDataProvider() throws IOException {
        InputStream is = GameDataProvider.class.getClassLoader().getResourceAsStream("gamedata.txt");
        BufferedReader bs = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = bs.readLine()) != null) {
            String[] parts = line.split(",");
            int gameDay = Integer.parseInt(parts[0].trim());
            Game g = new Game(
                    gameDay,
                    parts[1].trim(),
                    parts[2].trim(),
                    Integer.parseInt(parts[3].trim()),
                    Integer.parseInt(parts[4].trim())
            );

            this.games.computeIfAbsent(gameDay, k -> new ArrayList<>()).add(g);
        }
    }

    /**
     * Liefert eine Liste von Spielergebnissen für einen Spieltag der Bundesliga in der aktuellen Situation.
     * Die Spieltagszählung beginnt bei 1. Die Ergebnisse sind offline gespeichert.
     * Mit {@link #getMatchDays()} kann ermittelt werden, wie viele Spieltage verfügbar sind.
     *
     * @param matchDay der gewünschte Spieltag
     * @return eine Liste von {@code Game}-Objekten für den angegebenen Spieltag oder {@code null}, wenn keine vorhanden sind
     */
    public ArrayList<Game> getGames(int matchDay) {
        return this.games.get(matchDay);
    }

    /**
     * Liefert die Anzahl der hinterlegten Spieltage der Saison zurück.
     *
     * @return die größte vorhandene Spieltagsnummer
     */
    public int getMatchDays() {
        return Collections.max(this.games.keySet());
    }
}
