import { Col, Layout, Row, Typography } from 'antd';
import React, { useEffect, useState } from 'react';

const { Header } = Layout;
const { Title } = Typography;

const Topheader = () => {
	const [headerClass, setHeaderClass] = useState('');
	const [scrollTrigger, setScrollTrigger] = useState(false);

	useEffect(() => {
		const handleScroll = (_) => {
			console.log(`${headerClass} - ${scrollTrigger} - ${window.scrollY}`);
			if (window.scrollY >= 50.0 && headerClass === '') {
				setHeaderClass('scrolled');
				setScrollTrigger(false);
				console.log('added class!');
			}
			if (headerClass && !scrollTrigger && window.scrollY > 100.0) {
				setScrollTrigger(true);
				console.log('trigger is true!');
			}
			if (window.scrollY === 0 && scrollTrigger && headerClass) {
				setHeaderClass('');
				setScrollTrigger(false);
				console.log('removed class!');
			}
		};

		window.addEventListener('scroll', handleScroll);
		return () => window.removeEventListener('scroll', handleScroll);
	}, [headerClass, scrollTrigger]);

	return (
		<Header className={`timetable-top-header ${headerClass}`}>
			<Row align='bottom' justify='center'>
				<Col
					className='header-station-title'
					span={8}
					style={{ textAlign: 'right' }}
				>
					<Title level={2}>Totenham Court</Title>
				</Col>
				<Col className='arrow'>
					<svg fill='none' xmlns='http://www.w3.org/2000/svg'>
						<line
							x1='100%'
							y1='50%'
							y2='50%'
							stroke='#00474F'
							strokeWidth='3.75'
						/>
					</svg>
					<svg
						viewBox='0 0 100 100'
						fill='none'
						xmlns='http://www.w3.org/2000/svg'
					>
						<path
							fillRule='evenodd'
							clipRule='evenodd'
							d='M54.9173 1.98869L98.0164 45.1989C100.661 47.8505 100.661 52.1495 98.0164 54.8011L54.9173 98.0113C52.2725 100.663 47.9845 100.663 45.3397 98.0113C42.6949 95.3597 42.6949 91.0606 45.3397 88.409L76.8777 56.7898H0V43.2102H76.8777L45.3397 11.591C42.6949 8.93936 42.6949 4.64029 45.3397 1.98869C47.9845 -0.662898 52.2725 -0.662898 54.9173 1.98869Z'
							fill='#00474F'
						/>
					</svg>
				</Col>
				<Col className='header-station-title' span={8}>
					<Title level={2}>Shepherd's Bush</Title>
				</Col>
			</Row>
			<Row justify='center'>
				<Col>
					<Title level={4} className='header-meta'>
						DEPARTING ON 21.05.2021 AT 15:20
					</Title>
				</Col>
			</Row>
		</Header>
	);
};

export default Topheader;
