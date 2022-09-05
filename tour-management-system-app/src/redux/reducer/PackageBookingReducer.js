
export const ADD_PACKAGE_BOOKING = "ADD_PACKAGE_BOOKING";
const PackageBookingReducer = (state=[],action) => {
    const packageBookings = [...state];
    switch(action.type){
        case ADD_PACKAGE_BOOKING:
            return packageBookings;
        default:
            return state;
    }
}

export default PackageBookingReducer;