import React from "react";
import { Navigate } from "react-router-dom";
import { useSelector } from "react-redux/es/exports";
import './Login.css';
import LoginHelper from "./LoginHelper";
import NavBar from "../HomePage/NavBar";
import Footer from "../HomePage/Footer";

const Login = () => {
  const userLogin = useSelector((state) => state.userLogin);

  return userLogin ? (
    <Navigate to="/" />
  ) : (
    <React.Fragment>
      <NavBar/>
      <LoginHelper/>
      <Footer/>
    </React.Fragment>
  );
};
export default Login;
