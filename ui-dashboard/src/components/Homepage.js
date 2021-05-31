import React from 'react'
import ReactDOM from 'react-dom'
import { Layout, Menu, Breadcrumb, Typography } from 'antd';
import { PlayCircleFilled, StarOutlined, StarFilled, StarTwoTone } from '@ant-design/icons';
import { Row, Col } from 'antd';

const homepage = () => {
    const { Title, Link } = Typography;
    const style = {
        // border: "1px solid black",

    }
    return (
        // <div className="site-layout-background" style={{ padding: '0 50px', marginTop: 128, minHeight: 380 }} >
        //     <Title>Create A Match</Title>
        //     <br />
        //     <Link href="/match"><PlayCircleFilled style={{ fontSize: '128px' }} /></Link>
        //     <br />
        //     <Link href="/team" style={{ padding: '20px', fontSize: '20px' }}>
        //         Manage you team
        //     </Link>
        // </div
        <div style ={{textAlign: "center"}}>
            <Row style={{ flexDirection: "column" }} gutter={[0, 16]}>
                <Col style={style}>
                    <div style={{ marginTop: "150px" }}>
                        <Title>Create A Match</Title>
                    </div>

                </Col>
                <Col style={style}>
                    <div>
                        <Link href="/createMatch">
                            <PlayCircleFilled style={{ fontSize: '128px' }} />
                        </Link>
                    </div>
                </Col>


                <Col style={style}>
                    <Link href="/team" style={{ padding: '20px', fontSize: '20px' }}>
                        Manage your teams
             </Link>
                </Col>

            </Row>
        </div>
    )
}
export default homepage;