import React, { useState } from "react";
import { useNavigate } from "react-router";
import { REQUEST_TYPE, serverRequest } from "../../../axios";
import "./Login.css";
import { Link } from "react-router-dom";

const Register = () => {
  const navigate = useNavigate();
  //customer
  const [custAddressInfo, setCustAddressInfo] = useState({
    customerName: "",
    customerAge: "",
    phoneNo: "",
    houseNo: "",
    street: "",
    city: "",
    state: "",
    pincode: "",
  });

  const onInputChange = (event) => {
    setCustAddressInfo({
      ...custAddressInfo,
      [event.target.name]: event.target.value,
    });
  };

  const addCustomer = async (customer) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.POST,
        "/customer/cust",
        customer
      );
      if (response.status === 200) {
        console.log(response.data);
        alert("Please Login with Given Credentials : " + response.data);
        navigate("/login");
      }
    } catch (err) {
      alert("error");
      console.log(err);
    }
  };

  const onSubmit = (event) => {
    event.preventDefault();
    if (
      window.confirm(
        "Please Verify the details :\n" + JSON.stringify(custAddressInfo)
      )
    ) {
      console.log(custAddressInfo);
      addCustomer(custAddressInfo);
      navigate("/");
    } else {
      alert("Modify!!!");
      navigate("/register");
    }
  };
  return (
    <div id="register" className="container tab-pane fade">
      <label htmlFor="customerName" className="sr-only">
        Enter Name
      </label>
      <input
        type="text"
        id="customerName"
        name="customerName"
        className="form-control mb-4"
        placeholder="Enter Your Name "
        value={custAddressInfo.customerName}
        onChange={onInputChange}
        required ={true}
        autoFocus
      />
      <label htmlFor="customerAge" className="sr-only">
        Enter Age
      </label>
      <input
        type="text"
        id="customerAge"
        name="customerAge"
        className="form-control mb-4"
        value={custAddressInfo.customerAge}
        onChange={onInputChange}
        placeholder="Enter Age (e.g., 25)"
        required
      />
      <label htmlFor="phoneNo" className="sr-only">
        Enter Phone Number
      </label>
      <input
        type="text"
        id="phoneNo"
        name="phoneNo"
        value={custAddressInfo.phoneNo}
        onChange={onInputChange}
        className="form-control mb-4"
        placeholder="Enter Phone Number"
        required
      />

      {/* Address */}
      <label htmlFor="houseNo" className="sr-only">
        Enter House No
      </label>
      <input
        type="text"
        id="houseNo"
        name="houseNo"
        value={custAddressInfo.houseNo}
        onChange={onInputChange}
        className="form-control mb-4"
        placeholder="Enter House Number"
        required
      />
      <label htmlFor="street" className="sr-only">
        Enter street Name
      </label>
      <input
        type="text"
        id="street"
        name="street"
        value={custAddressInfo.street}
        onChange={onInputChange}
        className="form-control mb-4"
        placeholder="Enter Street Name"
        required
      />
      <label htmlFor="city" className="sr-only">
        Enter City Name
      </label>
      <input
        type="text"
        id="city"
        name="city"
        value={custAddressInfo.city}
        onChange={onInputChange}
        className="form-control mb-4"
        placeholder="Enter City Name"
        required
      />
      <label htmlFor="state" className="sr-only">
        Enter State Name
      </label>
      <input
        type="text"
        id="state"
        name="state"
        value={custAddressInfo.state}
        onChange={onInputChange}
        className="form-control mb-4"
        placeholder="Enter State Name"
        required = {true}
      />
      <label htmlFor="pincode" className="sr-only">
        Pincode
      </label>
      <input
        type="text"
        id="pincode"
        name="pincode"
        value={custAddressInfo.pincode}
        onChange={onInputChange}
        className="form-control mb-4"
        placeholder="Enter Pincode"
        required ={true}
      />
      <div className="d-flex justify-content-between">
        <button
          className="btn btn-lg btn-dark"
          type="submit"
          onClick={onSubmit}
        >
          Register
        </button>
        <Link className="btn btn-lg btn-dark" type="submit" to="/">
          Cancel
        </Link>
      </div>
    </div>
  );
};
export default Register;
