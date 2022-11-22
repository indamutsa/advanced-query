import React from 'react';
import ReactLoading from 'react-loading';

const Spinner = ({ type, color }) => (
    <div>
        <ReactLoading type={type} color={color} height={'100%'} width={'100%'} />
    </div>
);

export default Spinner;