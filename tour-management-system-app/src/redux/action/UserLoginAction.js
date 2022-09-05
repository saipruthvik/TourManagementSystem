import { useDispatch } from "react-redux";
import { REQUEST_TYPE, serverRequest } from "../../axios";
import { LOGIN, LOGOUT } from "../reducer/UserLoginReducer";
import {ADD_CUSTINFO} from '../reducer/CustomerInfoReducer';

const UserLoginAction = () => {
    const dispatch = useDispatch();
    const login = async (user) =>{
        try{
            const response = await serverRequest(REQUEST_TYPE.POST,"/login",user);
            if(response.status === 200){
                console.log(response.data);
                dispatch({
                    type:LOGIN,payload:response.data
                });
            }
            if(response.data && response.data.userRole === 'customer'){
                const response1 = await serverRequest(REQUEST_TYPE.GET,`/customer/custinfo/user/${user.userId}`);
                if(response1.status === 200){
                    console.log(response1.data);
                    dispatch({
                        type:ADD_CUSTINFO,
                        payload:response1.data
                    })
                }
            }
            
        }catch(err){
            alert("Enter Valid Credentials !!!!");
            console.log(err);
        }
    }

    const logout = () =>{
        return dispatch({type:LOGOUT});
    }
    return Object.freeze({login,logout});
}

export default UserLoginAction;