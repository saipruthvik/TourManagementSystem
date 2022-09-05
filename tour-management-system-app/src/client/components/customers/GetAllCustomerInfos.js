import React, { useEffect, useState } from "react";
import { REQUEST_TYPE, serverRequest } from "../../../axios";
import NavBar from "../HomePage/NavBar";
import Footer from "../HomePage/Footer";

const GetAllCustomerInfos = () => {
  const [customerInfo, setCustomerInfo] = useState();

  useEffect(() => {
    if (typeof customerInfo === "undefined") {
      getCustomerInfos();
    }
  }, []);

  const getCustomerInfos = async () => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        "/admin/customerInfo"
      );

      if (response.status === 200) {
        setCustomerInfo(response.data);
      }
    } catch (err) {
      console.log(err);
    }
  };

  console.log(customerInfo);
  return (
    <div className="">
      <NavBar />
      <div className="text-center h2 p-3 bg-secondary text-white">
        Customer Details
      </div>
      <table
        className="table table-striped m-3"
        align="center"
        width="50%"
        border="0"
      >
        <thead>
          <tr>
            <th>Customer Id</th>
            <th>Customer Name</th>
            <th>Customer Age</th>
            <th>PhoneNo</th>
            <th>User Id</th>
          </tr>
        </thead>
        <tbody>
          {customerInfo &&
            customerInfo.map((customerInfo) => (
              <tr key={customerInfo.customerId}>
                <td>{customerInfo.customerId}</td>
                <td>{customerInfo.customerName}</td>
                <td>{customerInfo.customerAge}</td>
                <td>{customerInfo.phoneNo}</td>
                <td>{customerInfo.userLogin.userId} </td>
              </tr>
            ))}
        </tbody>
      </table>
      <Footer />
    </div>
  );
};
export default GetAllCustomerInfos;
