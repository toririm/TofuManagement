package com.tohu.tohumanagement.Services;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ranking {
    Map<String, Integer> ranking = new HashMap<String, Integer>(){
        {
            put("player1", 10);
            put("player2", 20);
            put("player3", 40);
        }
    };
    static Scoreboard scoreboard;

    public Ranking() {
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        if (scoreboardManager == null) return;
        scoreboard = scoreboardManager.getNewScoreboard();
    }
    public static void setScoreboard() {
        Criteria criteria = Criteria.create("HEALTH");
        Objective objective = scoreboard.registerNewObjective("example", criteria, "example");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = objective.getScore("playerName");
        score.setScore(10);
    }

    public static void updateScore(Player player, int newScore, String playerName) {
        Objective objective = scoreboard.getObjective("example");
        if (objective == null) return;
        Score score = objective.getScore(playerName);
        score.setScore(newScore);
        player.setScoreboard(scoreboard);
    }

}
