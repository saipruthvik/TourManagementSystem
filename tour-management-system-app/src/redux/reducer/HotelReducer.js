import { LOGOUT } from "./UserLoginReducer";
export const GET_HOTELS = "GET_HOTELS";
export const ADD_HOTEL = "ADD_HOTEL";
export const DELETE_HOTEL = "DELETE_HOTEL";
export const EDIT_HOTEL = "EDIT_HOTEL";
export const GET_HOTEL_BY_ID = "GET_HOTEL_BY_ID";

const HotelReducer = (state = [], action) => {
  let hotels = [...state];
  switch (action.type) {
    case GET_HOTELS:
      return [...action.payload];
    case ADD_HOTEL: {
      hotels.push(action.payload);
      return hotels;
    }
    case EDIT_HOTEL: {
      const index = hotels.findIndex(
        (hotel) => hotel.hotelId === action.payload.hotelId
      );
      hotels[index] = { ...hotels[index], ...action.payload };
      return hotels;
    }
    case DELETE_HOTEL: {
      hotels = hotels.filter((hotel) => hotel.hotelId !== action.payload);
      return hotels;
    }
    case GET_HOTEL_BY_ID: {
      const hotel = hotels.filter((hotel) => hotel.hotelId === action.payload);
      return hotel;
    }
    case LOGOUT: {
      return [];
    }
    default:
      return state;
  }
};
export default HotelReducer;
