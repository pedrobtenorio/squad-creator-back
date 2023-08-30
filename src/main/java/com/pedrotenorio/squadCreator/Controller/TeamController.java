package com.pedrotenorio.squadCreator.Controller;

import com.pedrotenorio.squadCreator.Domain.Player;
import com.pedrotenorio.squadCreator.Domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import com.pedrotenorio.squadCreator.Service.TeamService;

@Controller
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create-teams")
    public ResponseEntity<List<Team>> createTeams(@RequestBody List<Player> players, @RequestBody Integer playersPerTeam) {
        List<Team> teams = this.teamService.createTeams(players, playersPerTeam);
        return ResponseEntity.ok(teams);
    }
}