package com.pedrotenorio.squadCreator.Service;

import com.pedrotenorio.squadCreator.Domain.Player;
import com.pedrotenorio.squadCreator.Domain.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    public List<Team> createTeams(List<Player> players, int playersPerTeam) {
        players.sort((p1, p2) -> Integer.compare(p2.getRating(), p1.getRating()));

        List<Team> teams = new ArrayList<>();
        int numTeams = (int) Math.ceil(players.size() * 1.0 / playersPerTeam);

        for (int i = 0; i < numTeams; i++) {
            teams.add(new Team());
        }

        for (Player player : players) {
            Team minTotalRatingTeam = teams.get(0);
            for (Team team : teams) {
                if (team.getRating() < minTotalRatingTeam.getRating()) {
                    minTotalRatingTeam = team;
                }
            }

            minTotalRatingTeam.getPlayers().add(player);
            minTotalRatingTeam.setRating(player.getRating() + minTotalRatingTeam.getRating());
        }

        return teams;
    }
}
