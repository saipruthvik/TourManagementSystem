import React from "react";
import NavBar from "./NavBar";
import HomePageBody from "./HomePageBody";
import Footer from './Footer';
import HomeCard from "./HomeCard";

const HomePage = () => {
    return(
        <React.Fragment>
            <NavBar/>
            <HomePageBody/>
            <div className="m-3"></div>
            <HomeCard />
            <Footer/>
        </React.Fragment>
    )
}

export default HomePage; 