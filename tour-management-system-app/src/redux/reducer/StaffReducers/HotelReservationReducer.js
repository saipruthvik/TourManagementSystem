export const GET_HOTEL_RESERVATION_BY_BOOKING_ID="GET_HOTEL_RESERVATION_BY_BOOKING_ID";
export const NO_HOTEL_RESERVATION_ADDED="NO_HOTEL_RESERVATION_ADDED";
export const ADD_HOTEL_RESERVATION="ADD_HOTEL_RESERVATION";
export const CANCEL_HOTEL_RESERVATION_BY_BOOKING_ID="CANCEL_HOTEL_RESERVATION_BY_BOOKING_ID";

const HotelReservationReducer = (state=[], action) =>{
    switch(action.type){
        case GET_HOTEL_RESERVATION_BY_BOOKING_ID:
            return action.payload;
        case NO_HOTEL_RESERVATION_ADDED:
            return null;
        case ADD_HOTEL_RESERVATION:
            return action.payload;
        case CANCEL_HOTEL_RESERVATION_BY_BOOKING_ID:
            return action.payload;
        default:
            return state;
    }

}

export default HotelReservationReducer;