import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { REQUEST_TYPE, serverRequest } from "../../../axios";
import { Link, useNavigate } from "react-router-dom";

const UpdateAddress = () => {
  const navigate = useNavigate();
  const [customerInfo] = useSelector((state) => state.customerInfos);
  const [address, setAddress] = useState();

  useEffect(() => {
    if (typeof address === "undefined") {
      getAddress();
    }
  }, []);

  const getAddress = async () => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/customer/address/${customerInfo.customerId}`
      );
      console.log(response.data);
      if (response.status === 200) {
        setAddress(response.data);
      }
    } catch (err) {
      console.log(err);
    }
  };

  const onInputChange = (event) => {
    setAddress({
      ...address,
      [event.target.name]: event.target.value,
    });
  };

  const UpdateAddress = async (address) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.PUT,
        "/customer/address",
        address
      );
      console.log(response.data);
      if (response.status === 200) {
        navigate("/");
      }
    } catch (err) {
      console.log(err);
    }
  };

  const onSubmit = (event) => {
    event.preventDefault();
    UpdateAddress(address);
  };
  console.log(address);
  return address ? (
    <div>
      <div className="container">
        <form className="form-signin rounded-sm shadow">
          <ul className="nav nav-pills mb-4">
            <li className="nav-item pill-1">
              <a
                className="nav-link active rounded-0"
                data-toggle="tab"
                href="#login"
              >
                Profile
              </a>
            </li>
          </ul>
          <div className="tab-content">
            <div id="login" className="container tab-pane active">
              <label htmlFor="customerId">Customer Id</label>
              <input
                type="text"
                id="customerId"
                name="customerId"
                className="form-control mb-4"
                value={address.customerInfo.customerId}
                onChange={onInputChange}
                required
                readOnly
              />

              <label htmlFor="houseNo">House No</label>
              <input
                type="text"
                id="houseNo"
                name="houseNo"
                value={address.houseNo}
                onChange={onInputChange}
                className="form-control mb-4"
                required
                readOnly
              />
              <label htmlFor="street">Street Name</label>
              <input
                type="text"
                id="street"
                name="street"
                value={address.street}
                onChange={onInputChange}
                className="form-control mb-4"
                required
              />
              <label htmlFor="city">City Name</label>
              <input
                type="text"
                id="city"
                name="city"
                value={address.city}
                onChange={onInputChange}
                className="form-control mb-4"
                required
              />
              <label htmlFor="state">State Name</label>
              <input
                type="text"
                id="state"
                name="state"
                value={address.state}
                onChange={onInputChange}
                className="form-control mb-4"
                required
              />
              <label htmlFor="pincode">Pincode</label>
              <input
                type="text"
                id="pincode"
                name="pincode"
                value={address.pincode}
                onChange={onInputChange}
                className="form-control mb-4"
                required
              />
              <button
                className="btn btn-lg btn-dark btn-block"
                type="submit"
                onClick={onSubmit}
              >
                Submit
              </button>
              <Link className="btn btn-lg btn-dark btn-block" to="/">
                Cancel
              </Link>
            </div>
          </div>
        </form>
      </div>
    </div>
  ) : (
    <></>
  );
  //   );
};

export default UpdateAddress;
