import React from "react";
import {useLocation,Link} from "react-router-dom";

const FallBack = () =>{
    const location = useLocation();
    return (
        <React.Fragment>
            <h1>{`404. That’s an error. The requested URL ${location.pathname} was not found on this
    server. That’s all we know.`}</h1>
            <Link to="/">click here to go to homepage</Link>
        </React.Fragment>
    );
}

export default FallBack;