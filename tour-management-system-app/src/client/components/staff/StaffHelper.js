import { useNavigate } from "react-router";
import { REQUEST_TYPE, serverRequest } from "../../../axios";
import React, { useState } from "react";

const StaffHelper = () => {
  const navigate = useNavigate();
  const [userDetails, setUserDetails] = useState({
    password: "",
    userRole: "",
  });

  const onInputChange = (event) => {
    setUserDetails({ ...userDetails, [event.target.name]: event.target.value });
  };

  const addStaff = async (userDetails) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.POST,
        "/login/add",
        userDetails
      );
      console.log(response.data);
      if (response.status === 200) {
        alert(response.data);
        navigate("/");
      }
    } catch (err) {
      console.log(err);
    }
  };

  const onSubmit = (event) => {
    event.preventDefault();
    addStaff(userDetails);
  };

  return (
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
              ADD STAFF
            </a>
          </li>
        </ul>
        <div id="login" className="container tab-pane active">
          <div className="tab-content">
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
            <label htmlFor="userRole" className="sr-only">
              User Role :
            </label>
            <input
              type="text"
              id="userRole"
              name="userRole"
              className="form-control mb-4"
              placeholder="User Role"
              value={userDetails.userRole}
              onChange={onInputChange}
              required
              autoFocus
            />
            <button
              className="btn btn-lg btn-dark btn-block"
              type="submit"
              onClick={onSubmit}
            >
              Add Staff
            </button>
          </div>
        </div>
      </form>
    </div>
  );
};

export default StaffHelper;
