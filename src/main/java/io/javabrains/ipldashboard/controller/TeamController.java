package io.javabrains.ipldashboard.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ipldashboard.model.Team;
import io.javabrains.ipldashboard.repository.MatchRepository;
import io.javabrains.ipldashboard.repository.TeamRepository;

@RestController
public class TeamController {

	private TeamRepository teamRepository;
	private MatchRepository matchRepository;

	public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
		this.teamRepository = teamRepository;
		this.matchRepository = matchRepository;
	}

	@GetMapping("/team")
	public List<Team> getAllTeam() {
//		Iterable<Team> teams = this.teamRepository.findAll();
//		for (Team t : teams) {
//			Team team = this.teamRepository.findByTeamName(t.getTeamName());
//			team.setMatches(matchRepository.findLatestMatchesbyTeam(t.getTeamName(), 4));
//		}
//		return teams;
		Iterable<Team> teams = this.teamRepository.findAll();
		Stream<Team> s = StreamSupport.stream(teams.spliterator(), false);
		return s.map(t -> {
			Team team = this.teamRepository.findByTeamName(t.getTeamName());
			team.setMatches(matchRepository.findLatestMatchesbyTeam(t.getTeamName(), 4));
			return team;

		}).collect(Collectors.toList());
	}

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		Team team = this.teamRepository.findByTeamName(teamName);
		team.setMatches(matchRepository.findLatestMatchesbyTeam(teamName, 4));

		return team;
	}
}
