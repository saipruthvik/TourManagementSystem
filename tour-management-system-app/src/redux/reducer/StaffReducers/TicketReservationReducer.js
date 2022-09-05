export const GET_TICKET_RESERVATION_BY_BOOKING_ID = "GET_TICKET_RESERVATION_BY_BOOKING_ID";
export const NO_TICKET_RESERVED="NO_TICKET_RESERVED";
export const ADD_TICKET_RESERVATION="ADD_TICKET_RESERVATION";
export const CANCEL_TICKET_RESERVATION_BY_TICKET_ID="CANCEL_TICKET_RESERVATION_BY_TICKET_ID";

const TicketReservationReducer = (state=[], action) => {
    switch (action.type) {
        case GET_TICKET_RESERVATION_BY_BOOKING_ID:
            return action.payload;
        case NO_TICKET_RESERVED:
            return null;
        case ADD_TICKET_RESERVATION:
            return action.payload;
        case CANCEL_TICKET_RESERVATION_BY_TICKET_ID:
            return action.payload;
        default:
            return state;
    }
}

export default TicketReservationReducer;