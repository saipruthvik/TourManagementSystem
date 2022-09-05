export const GET_PACKAGE_BOOKINGS = "GET_PACKAGE_BOOKINGS";
export const UPDATE_PACKAGE_BOOKING_BOOKING_STATUS =
  "UPDATE_PACKAGE_BOOKING_BOOKING_STATUS";
const PackageBookingsReducer = (state = [], action) => {
  let packageBookings = [...state];
  switch (action.type) {
    case GET_PACKAGE_BOOKINGS:
      packageBookings = action.payload;
      return action.payload;
    case UPDATE_PACKAGE_BOOKING_BOOKING_STATUS:
      let index = packageBookings.findIndex(
        (booking) => booking.bookingId === action.payload.bookingId
      );
      packageBookings[index] = { ...packageBookings[index], ...action.payload };
      return packageBookings;
    default:
      return state;
  }
};

export default PackageBookingsReducer;
