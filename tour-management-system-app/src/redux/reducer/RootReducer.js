import {combineReducers} from 'redux';
import TourInfoReducer from './TourInfoReducer';
import UserLoginReducer from './UserLoginReducer';
import CustomerInfoReducer from './CustomerInfoReducer';
import HotelReducer from './HotelReducer';
import PackageBookingsReducer from './StaffReducers/PackageBookingsReducer';
import HotelReservationReducer from './StaffReducers/HotelReservationReducer';
import TicketReservationReducer from './StaffReducers/TicketReservationReducer';
import PackageBookingReducer from './StaffReducers/PackageBookingReducer';

const RootReducer = combineReducers({
    userLogin : UserLoginReducer,
    tourInfo : TourInfoReducer,
    customerInfos : CustomerInfoReducer,
    hotels : HotelReducer,
    packageBookings : PackageBookingsReducer,
    hotelReservation : HotelReservationReducer,
    ticketReservation : TicketReservationReducer,
    packageBooking : PackageBookingReducer
});

export default RootReducer;