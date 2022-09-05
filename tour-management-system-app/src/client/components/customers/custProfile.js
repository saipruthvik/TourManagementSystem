import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { REQUEST_TYPE, serverRequest } from "../../../axios";
import { Link } from "react-router-dom";
import NavBar from "../HomePage/NavBar";
import Footer from "../HomePage/Footer";

const CustProfile = () => {
  
  const [custInfo] = useSelector((state) => state.customerInfos);
  const [address, setAddress] = useState();

  useEffect(() => {
    if (typeof address === "undefined") {
      getAddress();
    }
    console.log("Customer Info in useEffect : " + custInfo);
  }, []);

  const getAddress = async () => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/customer/address/${custInfo.customerId}`
      );
      console.log(response.data);
      if (response.status === 200) {
        setAddress(response.data);
      }
    } catch (err) {
      console.log(err);
    }
  };

  return address ? (
    <div>
      <NavBar />
      <div className="container">
        <form className="form-signin rounded-sm shadow">
          {/* <!-- Nav tabs --> */}
          <ul className="nav nav-pills mb-4">
            <li className="nav-item pill-1">
              <a 
                className="nav-link active rounded-0 "
                data-toggle="tab"
                href="#login"
              >
                Profile
              </a>
            </li>
          </ul>
          <div className="tab-content">
            <div id="login" className="container tab-pane active">
              <div className="form-group row">
                <label htmlFor="customerId" className="col-sm col-form-label">
                  Customer
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    id="customerId"
                    name="customerId"
                    className="form-control-plaintext"
                    value={address.customerInfo.customerId}
                    readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="customerName" className="col-sm col-form-label">
                  Customer Name
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    id="customerName"
                    name="customerName"
                    className="form-control-plaintext"
                    value={address.customerInfo.customerName}
                    readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="customerAge" className="col-sm col-form-label">
                  Customer Age
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    id="customerAge"
                    name="customerAge"
                    className="form-control-plaintext"
                    value={address.customerInfo.customerAge}
                    readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="phoneNo" className="col-sm col-form-label">
                  Phone Number
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    id="phoneNo"
                    name="phoneNo"
                    className="form-control-plaintext"
                    value={address.customerInfo.phoneNo}
                    readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="houseNo" className="col-sm col-form-label">
                  House No
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    id="houseNo"
                    name="houseNo"
                    className="form-control-plaintext"
                    value={address.houseNo}
                    readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="street" className="col-sm col-form-label">
                  Street Name
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    id="street"
                    name="street"
                    className="form-control-plaintext"
                    value={address.street}
                    readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="city" className="col-sm col-form-label">
                  City Name
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    id="city"
                    name="city"
                    className="form-control-plaintext"
                    value={address.city}
                    readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="state" className="col-sm col-form-label">
                  State Name
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    id="state"
                    name="state"
                    className="form-control-plaintext"
                    value={address.state}
                    readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="pincode" className="col-sm col-form-label">
                  Pincode
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    id="pincode"
                    name="pincode"
                    className="form-control-plaintext"
                    value={address.pincode}
                    readOnly
                  />
                </div>
              </div>
              <Link
                className="btn btn-lg btn-dark btn-block "
                type="submit"
                to="/updateprofile"
              >
                Update Customer Info
              </Link>

              <Link
                className="btn btn-lg btn-dark btn-block"
                type="submit"
                to="/updateaddress"
              >
                Update Address
              </Link>

              <Link className="btn btn-lg btn-dark btn-block" to="/">
                Cancel
              </Link>
            </div>
          </div>
        </form>
      </div>
      <Footer />
    </div>
  ) : (
    <></>
  );
};

export default CustProfile;
