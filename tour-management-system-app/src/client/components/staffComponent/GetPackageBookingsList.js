import React, { useEffect } from "react";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import StaffAction from "../../../redux/action/StaffAction";
import { useState } from "react";
import Footer from "../HomePage/Footer";
import NavBar from "../HomePage/NavBar";

const GetPackageBookingsList = () => {
  const prepareDate = (dateStr) => {
    const date = new Date(dateStr);
    return [date.getDate(), date.getMonth() + 1, date.getFullYear()].join("/");
  };

  const staffAction = StaffAction();
  useEffect(() => {
    staffAction.getPackageBookings();
  }, []);

  const { packageBookings } = useSelector((state) => {
    const copy = { ...state };
    return {
      packageBookings: copy.packageBookings || [],
    };
  });

  const [packageBookingslist, setPackageBookingsList] = useState(
    packageBookings
  );


  const getPackageBookingsWithPaymentPending = () => {
    let packageBookingslistTemp = packageBookings.filter(
      (booking) => booking.bookingStatus === "Payment Pending"
    );
    setPackageBookingsList(packageBookingslistTemp);
  };

  const getPackageBookingsWithPaymentCompleted = () => {
    let packageBookingslistTemp = packageBookings.filter(
      (booking) => booking.bookingStatus === "Payment Completed and Processing"
    );
    setPackageBookingsList(packageBookingslistTemp);
  };

  const getPackageBookingsCancelled = () => {
    let packageBookingslistTemp = packageBookings.filter(
      (booking) => booking.bookingStatus === "Cancelled"
    );
    setPackageBookingsList(packageBookingslistTemp);
  };

  const getPackageBookings = () => {
    let packageBookingslistTemp = packageBookings;
    setPackageBookingsList(packageBookingslistTemp);
  };

  return (
    <div>
      <NavBar />
      <div className="card shadow-lg p-3 mb-5 bg-white rounded">
        <div className="text-center h2 p-3 bg-secondary text-white">
          Package Bookings Details
        </div>


        <div className=" d-flex justify-content-around flex-wrap">
          <Link className="m-2" to="/">
            <button className="btn btn-dark">Back</button>
          </Link>
          <div className="m-2">
            <button
              className="btn btn-dark"
              onClick={() => getPackageBookingsWithPaymentPending()}
            >
              View with Payment Pending
            </button>
          </div>

          <div className="m-2">
            <button
              className="btn  btn-dark"
              onClick={() => getPackageBookingsWithPaymentCompleted()}
            >
              View With Payment Completed
            </button>
          </div>
          <div className="m-2">
            <button
              className="btn  btn-dark"
              onClick={() => getPackageBookingsCancelled()}
            >
              View Cancelled
            </button>
          </div>
          <div className="m-2">
            <button
              className="btn btn-dark"
              onClick={() => getPackageBookings()}
            >
              View All
            </button>
          </div>
        </div>

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
              <th>Tour Information Id</th>
              <th>Trip Date</th>
            </tr>
          </thead>
          <tbody>
            {packageBookingslist.length > 0 &&
              packageBookingslist.map((booking) => (
                <tr key={booking.bookingId}>
                  <td>{booking.bookingId}</td>
                  <td>{booking.bookingStatus}</td>
                  <td>{booking.customerInfoDto.customerId}</td>
                  <td>{booking.paymentType}</td>
                  <td>{booking.tourInformationDto.tourInformationId}</td>
                  <td>{prepareDate(booking.tripDate)}</td>
                  <td>
                    <Link to={`/packageBooking/${booking.bookingId}`}>
                      <button className="btn btn-lg btn-dark">View</button>
                    </Link>
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

export default GetPackageBookingsList;
