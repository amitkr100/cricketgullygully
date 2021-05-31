import axios from 'axios'

const GET_PLAYER_BY_TEAM_URL = "http://localhost:8080/team/players/CSK"

class TeamService {
    getAllTeam()
    {
        return axios.get(GET_PLAYER_BY_TEAM_URL)
    }
}

export default new TeamService()