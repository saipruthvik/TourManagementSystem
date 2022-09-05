import { Link } from "react-router-dom";
import React from "react";
import { useSelector } from "react-redux";
import UserLoginAction from "../../../redux/action/UserLoginAction";

const NavBar = () => {
  const userLogin = useSelector((state) => state.userLogin);

  const userLoginAction = UserLoginAction();

  const logoutClick = () => {
    if (window.confirm("Are you sure to logout ?")) {
      userLoginAction.logout();
    }
  };

  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light bg-light p-3 h5 sticky-top">
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav mr-auto">
            <li className="nav-item">
              <span className="nav-link">
                <Link to="/">My Home Tourism</Link>
              </span>
            </li>
            <li className="nav-item">
              <Link to="/" className="nav-link ">
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/packages" className="nav-link ">
                Packages
              </Link>
            </li>
            {userLogin && userLogin.userRole === "admin" ? (
              <div className="navbar-nav mr-auto">
                <li className="nav-item">
                  <Link to="/tourInformation" className="nav-link">
                    TourInformation
                  </Link>
                </li>
                <li className="nav-item">
                  <Link to="/hotel" className="nav-link">
                    Hotels
                  </Link>
                </li>
                <li className="nav-item">
                  <Link to="/adminview" className="nav-link">
                    Package Bookings
                  </Link>
                </li>
                <li className="nav-item">
                  <Link to="/custInfo" className="nav-link">
                    Customers
                  </Link>
                </li>
                <li className="nav-item">
                  <Link to="/addstaff" className="nav-link">
                    Add Staff
                  </Link>
                </li>
              </div>
            ) : userLogin && userLogin.userRole === "staff" ? (
              <div className="navbar-nav mr-auto">
                <li className="nav-item">
                  <Link to="/getPackageBookings" className="nav-link">
                    Package Bookings
                  </Link>
                </li>
              </div>
            ) : userLogin && userLogin.userRole === "customer" ? (
              <div className="navbar-nav mr-auto">
                 <li className="nav-item">
                  <Link to="/bookinghistory" className="nav-link">
                    Booking History
                  </Link>
                </li>
                <li className="nav-item">
                  <Link to="/profile" className="nav-link">
                    Profile
                  </Link>
                </li>
              </div>
            ) : (
              <li></li>
            )}

            <div className="nav-item">
              {userLogin ? (
                <div className="nav-item" onClick={logoutClick}>
                  <Link to="/" className="nav-link ">
                    Logout
                  </Link>
                </div>
              ) : (
                <div className="navbar-nav mr-auto">
                  <li className="nav-item">
                    <Link to="/login" className="nav-link">
                      Login
                    </Link>
                  </li>
                </div>
              )}
            </div>
          </ul>
        </div>
      </nav>
    </div>
  );
};
export default NavBar;
