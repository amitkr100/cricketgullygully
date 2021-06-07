import React, { Component } from 'react'
import { Select, Table, Divider, Space, Switch, Button, Tag, Tooltip } from 'antd';
import { ArrowUpOutlined, ArrowDownOutlined, CloseOutlined, PlusOutlined, PlusSquareTwoTone } from '@ant-design/icons';
const { Option } = Select;
export default class PlayersSelection extends Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedPlayer: [],
            captain: -1,
            wicketKeeper: -1,
        }
    }
    componentWillReceiveProps(nextProps) {
        if (nextProps.players !== this.props.players) {
            this.setState({ unselectedPlayer: nextProps.players })
        }
    }
    handlePlayerSelectionChange(playerName) {
        if (playerName) {
            const player = this.props.players.find(player => player.name === playerName)
            const selectedPlayer = this.state.selectedPlayer.slice()
            let unselectedPlayer = this.state.unselectedPlayer.slice().filter(player => player.name !== playerName)
            selectedPlayer.push(player)
            this.setState({ selectedPlayer, unselectedPlayer })
        }
    }
    getCaptainState(playerId) {
        const toolTipText = (this.state.captain == -1) ? "Select as Captain" : "Remove from Captain";
        const tagCaption = (this.state.captain == -1) ? "+" : "Captain";
        var content = (
            <Tooltip title={toolTipText}>
                <Tag style ={{cursor:"pointer"}} color="cyan" onClick = {()=>this.setState({captain: this.state.captain === -1 ? playerId : -1})}>{tagCaption}</Tag>
            </Tooltip>
        )
        if (this.state.captain == -1 || this.state.captain == playerId)
            return content

        return ""
        
    }
    getKeeperState(playerId) {
        const toolTipText = (this.state.wicketKeeper == -1) ? "Select as Wicket Keeper" : "Remove from WicketKeeper";
        const tagCaption = (this.state.wicketKeeper == -1) ? "+" : "WK";
        var content = (
            <Tooltip title={toolTipText}>
                <Tag style ={{cursor:"pointer"}} color="purple" onClick = {()=>this.setState({wicketKeeper: this.state.wicketKeeper === -1 ? playerId : -1})}>{tagCaption}</Tag>
            </Tooltip>
        )
        if (this.state.wicketKeeper == -1 || this.state.wicketKeeper == playerId)
            return content

        return ""
    }
    handleUnselectPlayer(playerId) {
        if (playerId) {
            const player = this.props.players.find(player => player.id === playerId)
            const selectedPlayer = this.state.selectedPlayer.filter(player => player.id !== playerId)
            const unselectedPlayer = this.state.unselectedPlayer.slice()
            unselectedPlayer.push(player)
            this.setState({ selectedPlayer, unselectedPlayer })
        }

    }
    handleMovePlayer(playerId, direction) {
        const selectedPlayer = this.state.selectedPlayer.slice()
        const currentPosition = selectedPlayer.findIndex(player => player.id == playerId)
        if ((currentPosition === 0 && direction === -1) || (currentPosition === currentPosition.length && direction === -1))
            return;

        const playerToMove = selectedPlayer.splice(currentPosition, 1)[0]
        selectedPlayer.splice(currentPosition + direction, 0, playerToMove)
        this.setState({ selectedPlayer });

    }
    checkIfStepCompleted()
    {
        if(this.state.selectedPlayer.length === this.props.maxAllowedPlayer && this.state.captain !==-1  && this.state.wicketKeeper!==-1)
            this.props.onCompletePlayerSelection(true)
        // else
        //     this.props.onCompletePlayerSelection(false)
    }
    render() {
        const { selectedPlayer, unselectedPlayer } = this.state;
        if (this.state.unselectedPlayer === undefined && this.props.players.length > 0) {
            this.setState({ unselectedPlayer: this.props.players })
        }
        this.checkIfStepCompleted();
        const columns = [{
            title: 'Players',
            dataIndex: 'name',
        },
        {
            width: "16%",
            render: (text, record) => (
                <div>
                    {this.getCaptainState(record.id)}
                    {this.getKeeperState(record.id)}
                </div>
            )
        },
        {
            title: 'Action',
            key: 'Action',
            width: "12%",
            render: (text, record) => (
                <Space size="small">
                    <Button type="primary" shape="circle" icon={<ArrowUpOutlined />} size="small" onClick={() => this.handleMovePlayer(record.id, -1)} />
                    <Button type="primary" shape="circle" icon={<ArrowDownOutlined />} size="small" onClick={() => this.handleMovePlayer(record.id, 1)} />
                    <Button type="primary" shape="circle" icon={<CloseOutlined />} size="small" onClick={() => this.handleUnselectPlayer(record.id)} />
                </Space>
            ),
        }
        ]
        let table;
        if (unselectedPlayer !== undefined && selectedPlayer.length > 0)
            table = (<div>
                    
                    <Table rowKey='id' columns={columns} dataSource={selectedPlayer} size="large" pagination={false} />
                    </div>
                    )
        else
            table = <h1>No Players Selected</h1>

        if (!unselectedPlayer)
            return null;
        return (
            <div>
                <h1>Select Players of {this.props.teamName}</h1>
                <Select
                    autoClearSearchValue={true}
                    allowClear
                    showSearch
                    disabled = {selectedPlayer.length == this.props.maxAllowedPlayer}
                    notFoundContent="No more player to add"
                    style={{ width: "100%" }}
                    placeholder="Select Player"
                    optionFilterProp="children"
                    onChange={(val) => this.handlePlayerSelectionChange(val)}
                    filterOption={(input, option) =>
                        option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                    }
                >
                    {unselectedPlayer.map(item => (<Option key={item.id} value={item.name}>{item.name}</Option>))}
                </Select>
                <Tag color="blue" style={{float:"left"}}>Selected {selectedPlayer.length}/{this.props.maxAllowedPlayer}</Tag>
                {table}


            </div>
        )
    }
}
