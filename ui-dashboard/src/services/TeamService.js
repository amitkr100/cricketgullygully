import axios from 'axios'
const SERVER = "http://10.213.175.245:8080/"
const GET_TEAMS_URL = SERVER + "team/"
const GET_PLAYERS_BY_TEAM_URL = SERVER + "team/players/"
class TeamService {
    getAllTeam()
    {
        return axios.get(GET_TEAMS_URL)
    }
    getAllPlayerOfTeam(teamName)
    {
        return axios.get(GET_PLAYERS_BY_TEAM_URL+teamName)
    }
}

export default new TeamService()