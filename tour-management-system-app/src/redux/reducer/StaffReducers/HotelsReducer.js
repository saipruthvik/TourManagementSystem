export const GET_HOTELS ="GET_HOTELS";

const HotelsReducer=(state=[],action)=>{
    switch(action.type){
        case GET_HOTELS:
            return action.payload;
        default:
            return state;
    }
}

export default HotelsReducer;