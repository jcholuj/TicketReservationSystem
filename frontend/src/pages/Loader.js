import React from "react";
import { Spin } from "antd";
import "../styles/general/base.less"

const Loader = () => {
	return (
		<div className='cover'>
			<Spin size='large' />
		</div>
	);
};

export default Loader;
