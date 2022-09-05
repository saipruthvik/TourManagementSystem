import React, { useState } from "react";
import { Navigate } from "react-router-dom";
import { useSelector } from "react-redux/es/exports";
import UserLoginAction from "../../../redux/action/UserLoginAction";
import "./Login.css";
import Register from "./Register";
import { Link } from "react-router-dom";
const LoginHelper = () => {
  //userLogin
  const [userDetails, setUserDetails] = useState({ userId: "", password: "" });
  const userLoginAction = UserLoginAction();
  const userLogin = useSelector((state) => state.userLogin);

  const onInputChange = (event) => {
    setUserDetails({ ...userDetails, [event.target.name]: event.target.value });
  };

  const onSubmitLogin = (event) => {
    event.preventDefault();
    userLoginAction.login(userDetails);
  };

  return userLogin ? (
    <Navigate to="/" />
  ) : (
    <React.Fragment>
      <div className="container">
        <form className="form-signin rounded-sm shadow">
          {/* <!-- Nav tabs --> */}
          <ul className="nav nav-pills mb-4">
            <li className="nav-item pill-1">
              <a
                className="nav-link active rounded-0"
                data-toggle="tab"
                href="#login"
              >
                Login
              </a>
            </li>
            <li className="nav-item pill-2">
              <a
                className="nav-link  rounded-0"
                data-toggle="tab"
                href="#register"
              >
                Register
              </a>
            </li>
          </ul>

          {/* <!-- Tab panes --> */}
          <div className="tab-content">
            {/* <!-- Tab1 --> */}
            <div id="login" className="container tab-pane active">
              <label htmlFor="UserID" className="sr-only">
                User ID :
              </label>
              <input
                type="text"
                id="UserID"
                name="userId"
                className="form-control mb-4"
                placeholder="User ID"
                value={userDetails.userName}
                onChange={onInputChange}
                required
                autoFocus
              />
              <label htmlFor="inputPassword" className="sr-only">
                Password
              </label>
              <input
                type="password"
                id="inputPassword"
                name="password"
                className="form-control mb-4"
                value={userDetails.password}
                onChange={onInputChange}
                placeholder="Password"
                required
              />
              <div className="one-line mb-2">
                <Link className="forgot" to="/forgetPassword">
                  Forgot password?
                </Link>
              </div>
              <button
                className="btn btn-lg btn-dark btn-block"
                type="submit"
                onClick={onSubmitLogin}
              >
                Login
              </button>

              <Link to="/">
                <button className="btn btn-lg btn-dark btn-block mt-3">Back</button>
              </Link>
            </div>

            <Register />
          </div>
        </form>
      </div>
    </React.Fragment>
  );
};
export default LoginHelper;
