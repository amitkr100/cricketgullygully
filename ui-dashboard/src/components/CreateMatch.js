import React, { Component } from 'react'
import SelectTeam from './SelectTeam'
import SelectPlayers from './SelectPlayer'
import { Steps, Button } from 'antd';
import TeamService from '../services/TeamService'
const { Step } = Steps;
export default class CreateMatch extends Component {

    constructor(props) {
        super(props);
        this.state = {
            current: 0,
            completed: -1,
            teams: [],
            steps: [
                {
                    id: 0,
                    title: "Select Teams",
                    status: "process",
                    isDisabled: false,
                },
                {
                    id: 1,
                    title: "Select Playing 11",
                    status: "wait",
                    isDisabled: false,
                },
                {
                    id: 2,
                    title: "Toss",
                    status: "wait",
                    isDisabled: true,
                },
                {
                    id: 3,
                    title: "Select Openers",
                    status: "wait",
                    isDisabled: true,
                },
            ],
            teamSelected: ["", ""],
        };

    }
    componentDidMount() {
        TeamService.getAllTeam().then((response) => {
            this.setState({ teams: response.data }, this.updateSelectTeamContent)
        });
    }
    updateSelectTeamContent() {
        let steps = this.state.steps.slice();
        let teampSelectedContent = steps[0]
        teampSelectedContent = { ...teampSelectedContent, content: <SelectTeam teams={this.state.teams} teamSelected={this.state.teamSelected} onTeamSelected={(i, value) => this.handleTeamSelected(i, value)} /> }
        steps[0] = teampSelectedContent;
        this.setState({ steps })

    }
    handleTeamSelected(i, value) {
        console.log("handleTeamSelected called", i, value)
        const teamSelected = this.state.teamSelected.slice();
        teamSelected[i] = value;
        this.setState({ teamSelected }, () => {
            if (this.state.teamSelected[0] !== "" && this.state.teamSelected[1] !== "") {
                console.log(this.state.teamSelected)
                this.setState({ completed: this.state.current })
            }


        });
    }
    next() {
        this.setState({ current: this.state.current + 1 }, () => {
            console.log("Hello Team", this.state.teamSelected, this.state.current);
            if (this.state.current == 1) {
                console.log("Hello Team", this.state.teamSelected);
                let steps = this.state.steps.slice();
                let playerSelectedContent = steps[1]
                playerSelectedContent = { ...playerSelectedContent, content: <SelectPlayers teamOne={this.state.teamSelected[0]} teamTwo={this.state.teamSelected[1]} /> }
                steps[1] = playerSelectedContent;
                // console.log(steps)
                this.setState({ steps })
            }
            // else if(this.state.current == 2) {
            //     console.log("Hello Team", this.state.teamSelected);
            //     let steps = this.state.steps.slice();
            //     let playerSelectedContent = steps[1]
            //     playerSelectedContent = { ...playerSelectedContent, content: <SelectPlayers teamOne = {this.state.teamSelected[0]} teamTwo = {this.state.teamSelected[1]}/> }
            //     steps[1] = playerSelectedContent;
            //     // console.log(steps)
            //     this.setState({ steps })
            // }
        });
    }
    prev() {
        this.setState({ current: this.state.current - 1 });
    }
    onChange = current => {
        console.log('onChange:', current);
        this.setState({ current });
    };

    render() {
        const { current, steps, completed } = this.state;
        return (
            <div style={{ textAlign: "center" }}>
                <Steps
                    type="navigation"
                    current={current}
                    onChange={this.onChange}
                    className="site-navigation-steps"
                    responsive
                >
                    {steps.map(item => (
                        <Step key={item.id} title={item.title} disabled={item.id > completed + 1} />
                    ))}
                </Steps>
                <div style={{ marginTop: 8 }}>
                    <div className="steps-action">
                        {current >= 0 && (
                            <div style={{ float: "left", paddingLeft: 24 }}>
                                <Button onClick={() => this.prev()} size="large" disabled={current === 0}>
                                    Previous
                                </Button>
                            </div>
                        )}
                        {current < steps.length - 1 && (
                            <div style={{ float: "right", paddingRight: 24 }}>
                                <Button type="primary" onClick={() => this.next()} size="large" disabled={completed < current}>
                                    Next
                                </Button>
                            </div>
                        )}
                        {current === steps.length - 1 && (
                            <div style={{ float: "right", paddingRight: 24 }} >
                                <Button type="primary" onClick={() => console.log("Done")} size="large">
                                    Done
                                </Button>
                            </div>
                        )}

                    </div>
                    <div className="step-content">
                        {steps[current].content}
                    </div>
                </div>
            </div>
        )
    }
}
