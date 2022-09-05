import React, { useEffect ,useState} from "react";
import { useSelector } from "react-redux";
import StaffAction from "../../../redux/action/StaffAction";
import { Link } from "react-router-dom";
import NavBar from "../HomePage/NavBar";
const GetHotelsAvailable = () => {
  const hotelReservationButtonProps = {
    color: "blue",
    text: "Reserve Hotel",
    hotelId: null,
    bookingId: null,
  };

  const ticketReservationButtonProps = {
    color: "blue",
    text: "Add Ticket Reservation",
  };

  const [
    hotelReservationButtonProperties,
    setHotelReservationButtonProperties,
  ] = useState(hotelReservationButtonProps);
  const [
    TicektReservationButtonProperties,
    setTicketReservationButtonProperties,
  ] = useState(ticketReservationButtonProps);

  const changeSelectedHotelStatus = (hotelId) => {
    setHotelReservationButtonProperties({
      color: "grey",
      text: "Selected",
      hotelId: hotelId,
      bookingId: packageBooking.bookingId,
    });
  };

  const changeTicketButtonStatus = () => {
    setTicketReservationButtonProperties({
      color: "grey",
      text: "Ticket Reserved",
    });
  };

  const getContactNumber=(hotelDescription)=> {
    let index=hotelDescription.indexOf("||")
    let contactNumber=hotelDescription.substring(index+2,index+12);
    return contactNumber;
  }

  const staffAction = StaffAction();
  const {
    hotels,
    packageBooking,
    user,
    hotelReservation,
    ticketReservation,
  } = useSelector((state) => {
    const copy = { ...state };
    return {
      hotels: copy.hotels || [],
      packageBooking: copy.packageBooking || [],
      user: copy.userLogin || [],
      hotelReservation: copy.hotelReservation || [],
      ticketReservation: copy.ticketReservation || [],
    };
  });

  const isStaff = user 
  // && user.userRole === "staff") || false;

  useEffect(() => {
    staffAction.getHotelsByLocationAndCost(
      packageBooking.tourInformationDto.location,
      packageBooking.tourInformationDto.totalCost
    );
    staffAction.getHotelReservation(packageBooking.bookingId);
    staffAction.getTicketReservation(packageBooking.bookingId);
  }, []);

  const reservation = {
    bookingId: packageBooking.bookingId,
    hotelId: null,
  };

  const ConfirmReservationButton = () => {
    return (
      <div>
        <button
          className="btn btn-lg btn-dark"
          onClick={() => {
            reservation.hotelId = hotelReservationButtonProperties.hotelId;
            reservation.bookingId = packageBooking.bookingId;
            staffAction.addTicketReservation(packageBooking.bookingId);
            staffAction.addHotelReservation(reservation);
            staffAction.confirmBookingStatusByBookingId(
              packageBooking.bookingId
            );
          }}
        >
          Confirm
        </button>
         <Link to={`/packageBooking/${packageBooking.bookingId}`}>
            <button className="btn btn-lg btn-dark">Cancel</button>
          </Link>
      </div>
    );
  };

  const canConfirm =
    hotelReservationButtonProperties.hotelId !== null &&
    TicektReservationButtonProperties.text === "Ticket Reserved";
  const isSelected = (id) => {
    if (id === hotelReservationButtonProperties.hotelId) {
      return true;
    } else {
      return false;
    }
  };
  const HotelReservationButton = ({ hotelId }) => {
    if (hotelReservation.length === 0) {
      if (isSelected(hotelId)) {
        return (
          <button
            className="btn btn-lg btn-dark"
            onClick={() => changeSelectedHotelStatus(hotelId)}
            color={hotelReservationButtonProperties.color}
          >
            {hotelReservationButtonProperties.text}
          </button>
        );
      } else {
        return (
          <button
            onClick={() => changeSelectedHotelStatus(hotelId)}
            background-color="blue"
            className="btn btn-dark"
          >
            Reserve Hotel
          </button>
        );
      }
    } else {
      return <div></div>;
    }
  };

  const TicketReservationButton = () => {
    if (ticketReservation.length === 0) {
      return (
        <div>
        <button
          className="btn btn-lg btn-dark ml-5 mb-5"
          onClick={() => changeTicketButtonStatus()}
          color={TicektReservationButtonProperties.color}
        >
          {TicektReservationButtonProperties.text}
        </button>
        </div>
      );
    } else {
      return <div></div>;
    }
  };

  return (
    <div>
      <NavBar />
      {isStaff && (
        <React.Fragment>
          <div className="text-center h2 p-3 bg-secondary text-white">
            Hotel Reservation
          </div>
          <div className="text-center h4 p-3 text-info">
            Hotels Available In Location
          </div>
          <Link to={`/packageBooking/${packageBooking.bookingId}`}>
            <button className="btn btn-lg btn-dark ml-5">Back</button>
          </Link>
          <table
            className="table table-striped m-5 rounded border border-primary"
            align="center"
            width="50%"
            border="0"
          >
            <thead>
              <tr>
                <th>Hotel Id</th>
                <th>Hotel Name</th>
                <th>Cost</th>
                <th>Contact Number:</th>
              </tr>
            </thead>
            <tbody>
              {hotels.map((hotel) => (
                <tr key={hotel.hotelId}>
                  <td>{hotel.hotelId}</td>
                  <td>{hotel.hotelName}</td>
                  <td>
                    {hotel.hotelServiceCost *
                      (packageBooking.packageCost /
                        packageBooking.tourInformationDto.totalCost)}
                  </td>
                  <td>{getContactNumber(hotel.hotelDescription)}</td>
                  <td>
                    <HotelReservationButton hotelId={hotel.hotelId} />
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          <div style={{"display": "flex","flex-direction": "row" ,"justifyContent ": "center","textAlign": "center"}}>
          <TicketReservationButton />
          {canConfirm && (
            <React.Fragment>
              <ConfirmReservationButton />
            </React.Fragment>
          )}
          </div>
         
        </React.Fragment>
      )}
    </div>
  );
};

export default GetHotelsAvailable;
