export const GET_PACKAGE_BOOKING = "GET_PACKAGE_BOOKING";
export const UPDATE_PACKAGE_BOOKING_BOOKING_STATUS =
  "UPDATE_PACKAGE_BOOKING_BOOKING_STATUS";
export const UPDATE_PACKAGE_BOOKING = "UPDATE_PACKAGE_BOOKING";
export const ADD_PACKAGE_BOOKING = "ADD_PACKAGE_BOOKING";

const PackageBookingReducer = (state = [], action) => {
  switch (action.type) {
    case GET_PACKAGE_BOOKING:
      return action.payload;
    case UPDATE_PACKAGE_BOOKING:
      return action.payload;
    case ADD_PACKAGE_BOOKING:
      return action.payload;
    default:
      return state;
  }
};

export default PackageBookingReducer;