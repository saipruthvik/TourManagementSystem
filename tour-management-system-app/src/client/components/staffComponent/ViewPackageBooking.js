import { useParams } from "react-router-dom";
import React, { useEffect } from "react";
import { useSelector } from "react-redux";
import { prepareDate } from "../../../client/constants/GlobalConstants";
import { Link } from "react-router-dom";
import StaffAction from "../../../redux/action/StaffAction";
import { useNavigate } from "react-router-dom";
import NavBar from "../HomePage/NavBar";
import Footer from "../HomePage/Footer";

const ViewPackageBooking = () => {
  const staffAction = StaffAction();
  const { bookingId } = useParams();
  const navigate = useNavigate();
  useEffect(() => {
    if (bookingId) {
      staffAction.getBookingByBookingId(bookingId);
      staffAction.getHotelReservation(bookingId);
      staffAction.getTicketReservation(bookingId);
    }
  }, []);

  const {
    packageBooking,
    user,
    hotelReservation,
    ticketReservation,
  } = useSelector((state) => {
    const copy = { ...state };
    return {
      packageBooking: copy.packageBooking || [],
      user: copy.user || [],
      hotelReservation: copy.hotelReservation || [],
      ticketReservation: copy.ticketReservation || [],
    };
  });

  const isStaff = user;
  // && user.userRole === "staff";

  const updateBookingStatus = () => {
    staffAction.updateBookingStatusByBookingId(bookingId);
  };

  const canCancel =
    (packageBooking.bookingStatus === "Cancelled" &&
      ((hotelReservation.length !== 0 &&
        ticketReservation.length !== 0 &&
        hotelReservation.reservationStatus !== "Cancelled") ||
        ticketReservation.reservationStatus !== "Cancelled")) ||
    false;

  const CancelButton = () => {
    return (
      <button
        className="btn btn-lg btn-dark"
        onClick={() => {
          staffAction.cancelHotelReservation(
            hotelReservation.hotelReservationId
          );
          staffAction.cancelTicketReservation(
            ticketReservation.ticketReservationId
          );
          navigate("/getPackageBookings");
        }}
      >
        Cancel Reservation
      </button>
    );
  };

  const processButton = (status) => {
    if (status === "Payment Pending") {
      return (
        <button className="btn btn-lg btn-dark" onClick={updateBookingStatus}>
          Accept Payment
        </button>
      );
    } else {
      if (hotelReservation.length === 0 || ticketReservation.length === 0) {
        if (packageBooking.bookingStatus !== "Cancelled") {
          return (
            <Link className="btn btn-lg btn-dark" to="/gethotelslist">
              <div>Reserve Hotel and Ticket</div>
            </Link>
          );
        }
      } else {
        return (
          <div>
            <div className="text-center h3 p-3 ">Hotel Reservation:</div>
            <form>
              <div className="form-group row">
                <label htmlFor="staticEmail" className="col-sm col-form-label">
                  {" "}
                  Hotel Id:
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    className="form-control-plaintext"
                    value={hotelReservation.hotel.hotelId}
                    readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="staticEmail" className="col-sm col-form-label">
                  Hotel Name:
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    className="form-control-plaintext"
                    value={hotelReservation.hotel.hotelName}
                    readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="staticEmail" className="col-sm col-form-label">
                  Hotel Reservation Status
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    className="form-control-plaintext"
                    value={hotelReservation.reservationStatus}
                    readOnly
                  />
                </div>
              </div>
              <div className="text-center h3 p-3 ">Ticket Reservation:</div>
              <div className="form-group row">
                <label htmlFor="staticEmail" className="col-sm col-form-label">
                  Ticket Reservation ID{" "}
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    className="form-control-plaintext"
                    value={ticketReservation.ticketReservationId}
                    readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="staticEmail" className="col-sm col-form-label">
                  Ticket Reservation Status
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    className="form-control-plaintext"
                    value={ticketReservation.reservationStatus}
                    readOnly
                  />
                </div>
              </div>
              {canCancel && (
                <React.Fragment>
                  <CancelButton />
                </React.Fragment>
              )}
            </form>
          </div>
        );
      }
    }
  };

  return (
    <div>
      <NavBar />
      <Link to="/getPackageBookings" className="btn btn-lg btn-dark ml-5">
        <div>Back</div>
      </Link>
      {isStaff && (
        <div className="d-flex flex-column justify-content-center align-items-center">
          <div className="text-center h2 p-3">Package Booking</div>

          <form className="card p-3 rounded m-3">
            <div className="form-group row">
              <label htmlFor="staticEmail" className="col-sm col-form-label">
                Booking Id
              </label>
              <div className="col-sm">
                <input
                  type="text"
                  className="form-control-plaintext"
                  value={packageBooking.bookingId}
                  readOnly
                />
              </div>
            </div>
            <div className="form-group row">
              <label htmlFor="staticEmail" className="col-sm col-form-label">
                Booking Status:
              </label>
              <div className="col-sm">
                <input
                  type="text"
                  className="form-control-plaintext"
                  value={packageBooking.bookingStatus}
                  readOnly
                />
              </div>
            </div>
            <div className="form-group row">
              <label htmlFor="staticEmail" className="col-sm col-form-label">
                Payment Type:
              </label>
              <div className="col-sm">
                <input
                  type="text"
                  className="form-control-plaintext"
                  value={packageBooking.paymentType}
                  readOnly
                />
              </div>
            </div>
            <div className="form-group row">
              <label htmlFor="staticEmail" className="col-sm col-form-label">
                Trip Date
              </label>
              <div className="col-sm">
                <input
                  type="text"
                  className="form-control-plaintext"
                  value={prepareDate(packageBooking.tripDate)}
                  readOnly
                />
              </div>
            </div>
            <div className="form-group row">
              <label htmlFor="staticEmail" className="col-sm col-form-label">
                Total Cost
              </label>
              <div className="col-sm">
                <input
                  type="text"
                  className="form-control-plaintext"
                  value={packageBooking.packageCost}
                  readOnly
                />
              </div>
            </div>
            {processButton(packageBooking.bookingStatus)}
          </form>
        </div>
      )}
      <Footer />
    </div>
  );
};

export default ViewPackageBooking;
