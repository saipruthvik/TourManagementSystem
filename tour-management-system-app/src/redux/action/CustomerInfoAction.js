import { useDispatch } from "react-redux";
import { useSelector } from "react-redux/es/exports";
import { REQUEST_TYPE, serverRequest } from "../../axios";
import {GET_CUSTINFO_BY_USERID,ADD_CUSTINFO ,GET_CUSTOMERINFOS} from '../reducer/CustomerInfoReducer';
import { useNavigate } from "react-router-dom";

const CustomerInfoAction = () =>{
    const user = useSelector((state)=>state.userLogin);
    const dispatch = useDispatch();
    let navigate = useNavigate();

    const getCustInfoByUserId = async () =>{
        try{
            const response = await serverRequest(REQUEST_TYPE.GET,`/customer/custinfo/user/${user.userId}`);
            if(response.status === 200){
                dispatch({
                    type:GET_CUSTINFO_BY_USERID,
                    payload:response.data
                })
            }
        }catch(err){
            console.log(err);
        }
    }

    const addCustInfo = async (custInfo) =>{
        try{
            const response = await serverRequest(REQUEST_TYPE.POST,"/newuser/custinfo",custInfo);
            if(response.status === 200){
                dispatch({
                    type:ADD_CUSTINFO,
                    payload:custInfo
                })
                alert(response.data);
                navigate("/");
            }
        }catch(err){
            console.log(err);
        }
    }
    const getCustomerInfos = async () => {
        try {
          const response = await serverRequest(REQUEST_TYPE.GET, "/admin/customerInfo");
          console.log(response.data);
          if (response.status === 200) {
            dispatch({ type: GET_CUSTOMERINFOS, payload: response.data });
          }
        } catch (err) {
          console.log(err);
        }
      };

   
    return Object.freeze({getCustInfoByUserId,getCustomerInfos,addCustInfo})
}

export default CustomerInfoAction;