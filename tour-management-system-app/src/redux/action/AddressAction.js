import { useDispatch } from "react-redux"
import { REQUEST_TYPE, serverRequest } from "../../axios";
import { ADD_ADDRESS } from "../reducer/AddressReducer";

const AddressAction = () =>{
    const dispatch = useDispatch();
    const addAddress = async(address) =>{
        try{
            const response = await serverRequest(REQUEST_TYPE.POST,"/customer/address",address);
            if(response.status === 200){
                dispatch({
                    type : ADD_ADDRESS,
                    payload : response.data
                })
            }
        }catch(err){
            console.log("Error : ",err);
        }
    }
    return Object.freeze({addAddress});
}
export default AddressAction;