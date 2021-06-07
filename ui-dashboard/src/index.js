import 'antd/dist/antd.css';
import './index.css';

import React from 'react'
import ReactDOM from 'react-dom'
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'

import Homepage from './components/Homepage'
import Player from './components/Player'
import Nav from './components/NavigationBar'
import CreateMatch from './components/CreateMatch'
import Test from './components/Test'


import { Layout } from 'antd';

const { Content, Footer } = Layout;

ReactDOM.render(
  <Layout>
    <Router>
      <Nav />
      <Content className="site-layout" style={{height: "calc(100vh - 100px)" , backgroundColor:"#fff"}}>
        <Switch>
          <Route path="/" exact><Homepage /></Route>
          <Route path="/player"><Player /></Route>
          <Route path="/createMatch"><CreateMatch /></Route>
          <Route path="/test" ><Test/></Route>
        </Switch>
      </Content>
    </Router>

    <Footer style={{ textAlign: 'center', backgroundColor: "#eee" }} className="footer">Cricketgullygully ©2020 Created with &lt;3</Footer>
  </Layout>,
  document.getElementById('root'),
);

