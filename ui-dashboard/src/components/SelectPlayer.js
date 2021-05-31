import React, { Component } from 'react'
import { Row, Col, Button, Select } from 'antd';
import TeamService from '../services/TeamService'
import PlayersSelection from './PlayersSelection';

const { Option } = Select;
export default class SelectPayers extends Component {

    constructor(props) {
        super(props);
        this.state = {
            leftTeam: {
                selectedPlayers: [],
                teamName: null,
                captain: -1,
                wicketKeeper: -1,
                isComplete:false,
            },
            rightTeam: {
                selectedPlayers: [],
                teamName: null,
                captain: -1,
                wicketKeeper: -1,
                isComplete:false,

            },
        }
    }
    componentDidMount() {
        TeamService.getAllPlayerOfTeam(this.props.teamOne).then((response) => {
            this.setState({ leftTeam: { ...this.state.leftTeam, selectedPlayers: response.data , teamName : this.props.teamOne} })
        });
        TeamService.getAllPlayerOfTeam(this.props.teamTwo).then((response) => {
            this.setState({ rightTeam: { ...this.state.rightTeam, selectedPlayers: response.data, teamName : this.props.teamTwo } })
        });
    }
    handleCompletePlayerSelection(whichOne, isComplete) {
        // if(whichOne == 0)
        //     this.setState({ leftTeam: { ...this.state.leftTeam, isComplete}})
        // if(whichOne == 1)
        //     this.setState({ rightTeam: { ...this.state.rightTeam, isComplete}})
    }
    render() {

        const { teamSelected } = this.props;
        const children = [];
        for (let i = 10; i < 36; i++) {
            children.push(<Option key={i.toString(36) + i}>{i.toString(36) + i}</Option>);
        }
        return (
            <div>
                <Row>
                    <Col span={10} style={{ paddingLeft: "8px" }}>
                        <PlayersSelection teamName = {this.state.leftTeam.teamName} players={this.state.leftTeam.selectedPlayers} maxAllowedPlayer={4} onCompletePlayerSelection={(isComplete) => this.handleCompletePlayerSelection(0, isComplete)} />
                    </Col>
                    <Col span={4} >
                        <Button type="primary" shape="circle" size="large" >
                            VS
                    </Button>
                    </Col>
                    <Col span={10} style={{ paddingRight: "8px" }}>
                        <PlayersSelection teamName = {this.state.rightTeam.teamName} players={this.state.rightTeam.selectedPlayers} maxAllowedPlayer={4} onCompletePlayerSelection={(isComplete) => this.handleCompletePlayerSelection(1, isComplete)} />
                    </Col>
                </Row>

            </div>
        )
    }
}
