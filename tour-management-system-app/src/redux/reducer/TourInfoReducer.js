import { LOGOUT } from "./UserLoginReducer";

export const GET_TOURINFO = "GET_TOURINFO";
export const ADD_TOURINFORMATION = "ADD_TOURINFORMATION";
export const DELETE_TOURINFORMATION = "DELETE_TOURINFORMATION";
export const EDIT_TOURINFORMATION = "EDIT_TOURINFORMATION";
export const GET_TOURINFORMATION_BY_ID = "GET_TOURINFORMATION_BY_ID";

const TourInfoReducer = (state = [], action) => {
  const tourInfo = [...state];
  switch (action.type) {
    case GET_TOURINFO:
      return [...action.payload];
    case ADD_TOURINFORMATION: {
      tourInfo.push(action.payload);
      return tourInfo;
    }
    case EDIT_TOURINFORMATION: {
      const index = tourInfo.findIndex(
        (tourInformation) =>
          tourInformation.tourInfoId === action.payload.tourInfoId
      );
      tourInfo[index] = {
        ...tourInfo[index],
        ...action.payload,
      };
      return tourInfo;
    }
    case DELETE_TOURINFORMATION: {
      return tourInfo.filter(
        (tourInformation) => tourInformation.tourInfoId !== action.payload
      );
    }
    case GET_TOURINFORMATION_BY_ID: {
      const tourInformation = tourInfo.filter(
        (tourInformation) => tourInformation.tourInfoId === action.payload
      );
      return tourInformation;
    }
    case LOGOUT:
      return [];
    default:
      return state;
  }
};
export default TourInfoReducer;
