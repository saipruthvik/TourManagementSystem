export const  ADD_ADDRESS = "ADD_ADDRESS";

const AddressReducer = (state=[],action) =>{
    switch(action.type){
        case ADD_ADDRESS : 
            return action.payload;
        default :
            return state;
    }
}
export default AddressReducer;