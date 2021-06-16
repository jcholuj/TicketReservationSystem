import React from 'react';
import PersonalData from './PaneVariants/PersonalData';
import Tickets from './PaneVariants/Tickets';

const ContentPane = (props) => {
	const option = props.paneKey;
	return (
		<>
			{option === '1' && <PersonalData />}
			{option === '2' && <Tickets />}
		</>
	);
};

export default ContentPane;
