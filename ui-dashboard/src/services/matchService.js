import axios from 'axios'
const SERVER = "http://10.213.175.245:8080/"
const GET_SCOREBOARD = SERVER + "match/"
class MatchService {
    getScoreBoard(matchid)
    {
        return axios.get(GET_SCOREBOARD + matchid)
    }

}
export default new MatchService()