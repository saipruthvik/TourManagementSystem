import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { REQUEST_TYPE, serverRequest } from "../../../axios";
import { Link,useNavigate  } from "react-router-dom";
import NavBar from "../HomePage/NavBar";
import Footer from "../HomePage/Footer";

const UpdateProfile = () => {
  const navigate = useNavigate();
  const [custInfo] = useSelector((state) => state.customerInfos);

  const [customerInfo, setCustomerInfo] = useState();
  
  useEffect(() => {
    if (typeof customerInfo === "undefined") {
      getCustomerInfo();
    }
  }, []);

  const getCustomerInfo = async () => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/customer/custinfo/${custInfo.customerId}`
      );
      console.log(response.data);
      if (response.status === 200) {
        setCustomerInfo(response.data);
      }
    } catch (err) {
      console.log(err);
    }
  };

  const onInputChange = (event) => {
    setCustomerInfo({
      ...customerInfo,
      [event.target.name]: event.target.value,
    });

  };

  const UpdateProfile = async(customerInfo)=>{
    try{
        const response = await serverRequest(REQUEST_TYPE.PUT,`/customer/custinfo/${custInfo.customerId}`,customerInfo);
        console.log(response.data);
        if(response.status === 200){
          navigate("/");
        }
    }catch(err){
        console.log(err);
    }
  }

  const onSubmit = (event) => {
    event.preventDefault();
      UpdateProfile(customerInfo);
  };
  console.log(customerInfo);
  return customerInfo ? (
    <div>
      <NavBar/>
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
                value={customerInfo.customerId}
                onChange={onInputChange}
                required
                readOnly
              />
              <label htmlFor="userId">User Id</label>
              <input
                type="text"
                id="userId"
                name="userId"
                className="form-control mb-4"
                // placeholder="Enter Your Name "
                value={customerInfo.userLogin.userId}
                onChange={onInputChange}
                required
                readOnly
              />
              <label htmlFor="customerName">Customer Name</label>
              <input
                type="text"
                id="customerName"
                name="customerName"
                className="form-control mb-4"
                //placeholder="Enter Your Name "
                value={customerInfo.customerName}
                onChange={onInputChange}
                required
              />
              <label htmlFor="customerAge">Customer Age</label>
              <input
                type="text"
                id="customerAge"
                name="customerAge"
                className="form-control mb-4"
                value={customerInfo.customerAge}
                onChange={onInputChange}
                //placeholder="Enter Age (e.g., 25)"
                required
              />
              <label htmlFor="phoneNo">Phone Number</label>
              <input
                type="text"
                id="phoneNo"
                name="phoneNo"
                value={customerInfo.phoneNo}
                onChange={onInputChange}
                className="form-control mb-4"
                //placeholder="Enter Phone Number"
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
      <Footer/>
    </div>
    ):<></>
//   );
};

export default UpdateProfile;