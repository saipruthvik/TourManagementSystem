import { GET_PACKAGE_BOOKINGS } from "../reducer/StaffReducers/PackageBookingsReducer";
import { GET_PACKAGE_BOOKING } from "../reducer/StaffReducers/PackageBookingReducer";
import { UPDATE_PACKAGE_BOOKING_BOOKING_STATUS } from "../reducer/StaffReducers/PackageBookingsReducer";
import { UPDATE_PACKAGE_BOOKING } from "../reducer/StaffReducers/PackageBookingReducer";
import { GET_HOTELS } from "../reducer/StaffReducers/HotelsReducer";
import { serverRequest } from "../../axios";
import { REQUEST_TYPE } from "../../axios";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { GET_HOTEL_RESERVATION_BY_BOOKING_ID } from "../reducer/StaffReducers/HotelReservationReducer";
import { NO_HOTEL_RESERVATION_ADDED } from "../reducer/StaffReducers/HotelReservationReducer";
import { GET_TICKET_RESERVATION_BY_BOOKING_ID } from "../reducer/StaffReducers/TicketReservationReducer";
import { NO_TICKET_RESERVED } from "../reducer/StaffReducers/TicketReservationReducer";
import {
  ADD_HOTEL_RESERVATION,
  CANCEL_HOTEL_RESERVATION_BY_BOOKING_ID,
} from "../reducer/StaffReducers/HotelReservationReducer";
import {
  ADD_TICKET_RESERVATION,
  CANCEL_TICKET_RESERVATION_BY_TICKET_ID,
} from "../reducer/StaffReducers/TicketReservationReducer";
const StaffAction = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const getPackageBookings = async () => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        "/staff/packagebookings"
      );
      if (response.status === 200) {
        dispatch({ type: GET_PACKAGE_BOOKINGS, payload: response.data });
      }
    } catch (err) {
      console.log(err);
    }
  };

  const getBookingByBookingId = async (bookingId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/staff/packagebooking/${bookingId}`
      );
      if (response.status === 200) {
        dispatch({ type: GET_PACKAGE_BOOKING, payload: response.data });
      }
    } catch (err) {
      console.log("errors");
    }
  };

  const updateBookingStatusByBookingId = async (bookingId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.PUT,
        `/staff/updatepackagebooking/${bookingId}`
      );
      if (response.status === 200) {
        dispatch({
          type: UPDATE_PACKAGE_BOOKING_BOOKING_STATUS,
          payload: response.data,
        });
        dispatch({ type: UPDATE_PACKAGE_BOOKING, payload: response.data });
      }
    } catch (err) {
      console.log("errors");
    }
  };

  const confirmBookingStatusByBookingId = async (bookingId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.PUT,
        `/staff/updatepackagebooking/${bookingId}`
      );
      if (response.status === 200) {
        dispatch({
          type: UPDATE_PACKAGE_BOOKING_BOOKING_STATUS,
          payload: response.data,
        });
        dispatch({ type: UPDATE_PACKAGE_BOOKING, payload: response.data });
        navigate("/getPackageBookings");
      }
    } catch (err) {
      console.log("errors");
    }
  };

  const getHotelsByLocationAndCost = async (location, cost) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/staff/gethotels/${location}/${cost}`
      );
      if (response.status === 200) {
        dispatch({ type: GET_HOTELS, payload: response.data });
      }
    } catch (err) {}
  };

  const addHotelReservation = async (reservation) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.POST,
        `/staff/hotelreservation`,
        reservation
      );
      if (response.status === 200) {
        console.log("hotel reserved successfully");
        dispatch({ type: ADD_HOTEL_RESERVATION, payload: response.data });
      }
    } catch (err) {
      console.log("hotel reservation failed");
    }
  };

  const addTicketReservation = async (bookingId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.POST,
        `/staff/ticketreservation/${bookingId}`
      );
      if (response.status === 200) {
        dispatch({ type: ADD_TICKET_RESERVATION, payload: response.data });
        console.log("ticket reserved successfully");
      }
    } catch (err) {
      console.log("ticket reservation failed");
    }
  };

  const getHotelReservation = async (bookingId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/staff/gethotelreservation/${bookingId}`
      );
      if (response.status === 200) {
        dispatch({
          type: GET_HOTEL_RESERVATION_BY_BOOKING_ID,
          payload: response.data,
        });
      }
      if (response.status === 500) {
        dispatch({ type: NO_HOTEL_RESERVATION_ADDED, payload: null });
      }
    } catch (err) {
      dispatch({ type: NO_HOTEL_RESERVATION_ADDED, payload: null });
      console.log("no reservation found");
    }
  };

  const getTicketReservation = async (bookingId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/staff/getticketreservation/${bookingId}`
      );
      if (response.status === 200) {
        dispatch({
          type: GET_TICKET_RESERVATION_BY_BOOKING_ID,
          payload: response.data,
        });
      }
      if (response.status === 404) {
        dispatch({ type: NO_TICKET_RESERVED, payload: null });
      }
    } catch (err) {
      console.log("no reservation found");
      dispatch({ type: NO_TICKET_RESERVED, payload: null });
    }
  };

  const cancelHotelReservation = async (hotelReservationId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.PUT,
        `/staff/cancelhotelreservation/${hotelReservationId}`
      );
      if (response.status === 200) {
        dispatch({
          type: CANCEL_HOTEL_RESERVATION_BY_BOOKING_ID,
          payload: response.data,
        });
      }
      if (response.status === 404) {
        dispatch({ type: NO_HOTEL_RESERVATION_ADDED, payload: null });
      }
    } catch (err) {
      console.log("no reservation found");
      dispatch({ type: NO_HOTEL_RESERVATION_ADDED, payload: null });
    }
  };

  const cancelTicketReservation = async (ticketReservationId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.PUT,
        `/staff/cancelticketreservation/${ticketReservationId}`
      );
      if (response.status === 200) {
        dispatch({
          type: CANCEL_TICKET_RESERVATION_BY_TICKET_ID,
          payload: response.data,
        });
        navigate("/getPackageBookings");
      }
      if (response.status === 404) {
        dispatch({ type: NO_TICKET_RESERVED, payload: null });
      }
    } catch (err) {
      console.log("no reservation found");
      dispatch({ type: NO_TICKET_RESERVED, payload: null });
    }
  };
  return Object.freeze({
    getPackageBookings,
    getBookingByBookingId,
    updateBookingStatusByBookingId,
    getHotelsByLocationAndCost,
    addHotelReservation,
    getHotelReservation,
    getTicketReservation,
    addTicketReservation,
    confirmBookingStatusByBookingId,
    cancelHotelReservation,
    cancelTicketReservation,
  });
};

export default StaffAction;
