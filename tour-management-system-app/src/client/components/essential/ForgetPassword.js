import React from "react";
import NavBar from "../HomePage/NavBar";
import Footer from "../HomePage/Footer";
import Forget from "./Forget";

const ForgetPassword = ()=>{
    return(
        <React.Fragment>
            <NavBar/>
            <Forget/>
            <Footer/>
        </React.Fragment>
    );
}
export default ForgetPassword;
