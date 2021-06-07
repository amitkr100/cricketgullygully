import React, { Component } from 'react'
import { Row, Col, Typography } from 'antd'
import CurrentPlayerSection from './CurrentPlayerSection'
import ScoreBoardSection from './ScoreBoardSection'
import MatchControllerSection from './MatchControllerSection'
import MiniPlayerScoreSection from './MiniPlayerScoreSection'
const { Title } = Typography
export default class MatchConsole extends Component {
    constructor(props) {
        super(props)
    }
    
    render() {
        const { scoreboard } = this.props
        if (!scoreboard) return null;
        return (
            <div>
                <Row gutter={[16, 16]}>
                    <Col span={24} style={{ border: "1px solid #e0e0e0", textAlign: "center"}}><Title level={2}>{scoreboard.teamOne.name} VS {scoreboard.teamTwo.name}</Title></Col>
                    <Col span={12} style={{ border: "1px solid #e0e0e0" }}><CurrentPlayerSection inning={scoreboard.scoreboard.innings[scoreboard.scoreboard.innings.length - 1]} /></Col>
                    <Col span={12} style={{ border: "1px solid #e0e0e0" }}><ScoreBoardSection /></Col>
                    <Col span={12} style={{ border: "1px solid #e0e0e0" }}><MatchControllerSection /></Col>
                    <Col span={12} style={{ border: "1px solid #e0e0e0" }}><MiniPlayerScoreSection /></Col>
                </Row>
            </div>
        )
    }
}
