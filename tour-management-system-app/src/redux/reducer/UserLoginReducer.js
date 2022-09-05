export const LOGIN = 'LOGIN';
export const LOGOUT = 'LOGOUT';

const UserLoginReducer = (state=null,action) =>{
    switch(action.type){
        case LOGIN : 
            return action.payload;
        case LOGOUT :
            return null;
        default :
            return state;
    }
}

export default UserLoginReducer;