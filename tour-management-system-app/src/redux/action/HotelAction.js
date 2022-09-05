import { useDispatch } from "react-redux";
import { useNavigate } from "react-router";
import { REQUEST_TYPE, serverRequest } from "../../axios";
import {
  ADD_HOTEL,
  DELETE_HOTEL,
  EDIT_HOTEL,
  GET_HOTELS,
} from "../reducer/HotelReducer";

function HotelAction() {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const getHotels = async () => {
    try {
      const response = await serverRequest(REQUEST_TYPE.GET, "/admin/hotel");
      if (response.status === 200) {
        dispatch({ type: GET_HOTELS, payload: response.data });
      }
    } catch (err) {
      console.log(err);
    }
  };

  const addHotel = async (hotel) => {
    try {
      const roomtype = hotel.roomType.split(",");
      hotel.roomType = roomtype;
      const response = await serverRequest(
        REQUEST_TYPE.POST,
        `/admin/hotel`,
        hotel
      );
      if (response.status === 200) {
        navigate("/hotel");
        return dispatch({ type: ADD_HOTEL, payload: response.data });
      }
    } catch (err) {
      console.log(err);
    }
  };
  const deleteHotel = async (hotelId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.DELETE,
        `/admin/hotel/${hotelId}`
      );
      if (response.status === 200) {
        alert("hotel is deleted");
        return dispatch({ type: DELETE_HOTEL, payload: hotelId });
      }
    } catch (err) {
      console.log(err);
    }
  };
  const editHotel = async (hotel, navigate) => {
    try {
      console.log({ hotel });
      const roomtype1 = hotel.roomType.split(",");
      hotel.roomType = roomtype1;
      const response = await serverRequest(
        REQUEST_TYPE.PUT,
        "/admin/hotel",
        hotel
      );
      console.log({ hotel });
      if (response.status === 200) {
        navigate("/hotel");
        return dispatch({ type: EDIT_HOTEL, payload: hotel });
      }
    } catch (err) {
      console.log(err);
    }
  };

  const getHotelById = async (hotelId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/admin/hotelById/${hotelId}`
      );
      if (response.status === 200) {
        return response;
      }
    } catch (err) {
      console.log(err);
    }
  };
  return Object.freeze({
    addHotel,
    getHotels,
    editHotel,
    deleteHotel,
    getHotelById,
  });
}

export default HotelAction;
