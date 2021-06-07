import React, { Component } from 'react'
import matchService from '../services/matchService';
import MatchConsole from './match-view/MatchConsole';

export default class Test extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             scoreboard: null,
        }
    }
    
    componentDidMount() {
        matchService.getScoreBoard(1).then((response) => {
            console.log(response.data)
            this.setState({ scoreboard: response.data })
        });
    }
    handleCompletePlayerSelection(whichOne)
    {
        console.log("Completed", whichOne)
    }
    render() {
        return <MatchConsole scoreboard = {this.state.scoreboard}/>
    }
}
