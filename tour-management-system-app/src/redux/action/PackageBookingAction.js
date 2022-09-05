import { useDispatch } from "react-redux";
import { useNavigate } from "react-router";
import { REQUEST_TYPE, serverRequest } from "../../axios";
import { ADD_PACKAGE_BOOKING } from "../reducer/PackageBookingReducer";

const PackageBookingAction = () =>{
    const dispatch = useDispatch();

    const navigate = useNavigate();
    const addPackageBooking = async(packageBooking)=>{
        try{
            const response = await serverRequest(REQUEST_TYPE.POST,"/customer/packagebookings",packageBooking);
            if(response.status === 200) {
                dispatch({
                    type:ADD_PACKAGE_BOOKING,
                    payload:response.data
                })
            }
            alert(response.data)
        }catch(err){
            console.log(err);
            alert("Login !!!");
            navigate("/login");
        }
    }

     //   const cancelPackageBooking = async (bookingId) => {
    //     try {
    //       const response = await serverRequest(REQUEST_TYPE.PUT, "/customer/packageBookings/${bookingId}");
    //       console.log(response.data);
    //       if (response.status === 200) {
    //         dispatch({ type: GET_CUSTOMERINFOS, payload: response.data });
    //       }
    //     } catch (err) {
    //       console.log(err);
    //     }
    //   };

    return Object.freeze({addPackageBooking});
}

export default PackageBookingAction;