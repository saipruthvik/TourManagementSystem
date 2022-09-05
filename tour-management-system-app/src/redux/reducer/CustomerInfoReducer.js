import {LOGOUT} from './UserLoginReducer';

export const GET_CUSTINFO_BY_USERID = "GET_CUSTINFO_BY_USERID";
export const ADD_CUSTINFO = "ADD_CUSTINFO";
export const GET_CUSTOMERINFOS ="GET_CUSTOMERINFOS";

const CustomerInfoReducer = (state=[],action)=>{
    const customerInfos = [...state];
    switch(action.type){
        case GET_CUSTINFO_BY_USERID:
            return customerInfos.filter((custInfo)=>custInfo.id === action.payload);
        case ADD_CUSTINFO:
            customerInfos.push({...action.payload});
            console.log("CustomerInfos After Login: ",customerInfos);
            return customerInfos;
        case GET_CUSTOMERINFOS:
            return [...action.payload];
        case LOGOUT :
            return [];
        default:
            return state;
    }
}
export default CustomerInfoReducer;