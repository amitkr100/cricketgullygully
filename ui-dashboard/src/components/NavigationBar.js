import React from 'react'
import { Layout, Menu } from 'antd';
import { Link } from 'react-router-dom';
function NavigationBar() {
    const { Header } = Layout;
    return (
        <Header>
            <div className="logo" />
            <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
                <Menu.Item key="1"><Link to = "/">Home</Link></Menu.Item>
                <Menu.Item key="2"><Link to = "/team">Teams</Link></Menu.Item>
                <Menu.Item key="3"><Link to = "/player"> Players </Link></Menu.Item>
            </Menu>
        </Header>
    )
}

export default NavigationBar
