import React, { useEffect } from "react";
import { useSelector } from "react-redux";
import { Link, Navigate } from "react-router-dom";
import { useState } from "react";
import Footer from "../HomePage/Footer";
import NavBar from "../HomePage/NavBar";
import { REQUEST_TYPE, serverRequest } from "../../../axios";

const BookingHistory = () => {

  const [custInfo] = useSelector((state) => state.customerInfos);
  const [packageBooking, setPackageBooking] = useState();

  const prepareDate = (dateStr) => {
    const date = new Date(dateStr);
    return [date.getDate(), date.getMonth() + 1, date.getFullYear()].join("/");
  };

  useEffect(() => {
    getPackageBookingsById();
  },[packageBooking]);

  const getPackageBookingsById = async () => {
    try {
      console.log(custInfo);
      const response = await serverRequest(REQUEST_TYPE.GET, `/customer/packagebookings/all/${custInfo.customerId}`);

      if (response.status === 200) {
        setPackageBooking(response.data);
      }
    } catch (err) {
      console.log(err);
    }
  }

    const cancelPackageBooking = async (bookingId) => {
        try {
          console.log(bookingId);
          const response = await serverRequest(REQUEST_TYPE.PUT, `/customer/packagebookings/${bookingId}`);
          console.log(response.data);
          if (response.status === 200) {
            // dispatch({ type: GET_CUSTOMERINFOS, payload: response.data });
            Navigate("/bookinghistory");
          }
        } catch (err) {
          console.log(err);
        }
      };
      const canCancelButton=(bookingId,bookingStatus)=>{
        if(bookingStatus !== "Cancelled")
        {
        return(
          <div>
              <button className="btn btn-lg btn-dark" onClick={()=>cancelPackageBooking(bookingId)}>Cancel Booking</button>
        </div>
            )
        }
      }
      
  return (
    <div>
      <NavBar />
      <div className="card shadow-lg p-3 mb-5 bg-white rounded">
        <div className="text-center h2 p-3 bg-secondary text-white">
          Package Bookings Details
        </div>
      </div>

      <div className=" d-flex justify-content-start flex-wrap">
        <Link className="m-2" to="/">
          <button className="btn btn-dark">Back</button>
        </Link>
      </div>

      <React.Fragment>
        <table
          className="table table-striped m-5 rounded border border-primary"
          align="center"
          width="50%"
          border="0"
        >
          <thead>
            <tr align="center">
              <th>Booking Id</th>
              <th>Booking Status</th>
              <th>Customer Id</th>
              <th>Payment Type</th>
              <th>Trip Date</th>
            </tr>
          </thead>
          <tbody>
            {packageBooking &&
              packageBooking.map((booking) => (
                <tr key={booking.bookingId}>
                  <td>{booking.bookingId}</td>
                  <td>{booking.bookingStatus}</td>
                  <td>{booking.customerInfo.customerId}</td>
                  <td>{booking.paymentType}</td>
                  <td>{prepareDate(booking.tripDate)}</td>
                  <td>
                    <Link to={`/viewbookinghistory/${booking.bookingId}`}>
                      <button className="btn btn-lg btn-dark">View</button>
                    </Link>
                  </td>

                  <td>
                  {canCancelButton(booking.bookingId,booking.bookingStatus)}
                  </td>
                  
                </tr>
              ))}
          </tbody>
        </table>
      </React.Fragment>

      <Footer />
    </div>
  );
};

export default BookingHistory;