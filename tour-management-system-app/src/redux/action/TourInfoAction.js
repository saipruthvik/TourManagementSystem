import { useDispatch } from "react-redux";
import { useNavigate } from "react-router";
import { REQUEST_TYPE, serverRequest } from "../../axios";
import {
  ADD_TOURINFORMATION,
  DELETE_TOURINFORMATION,
  EDIT_TOURINFORMATION,
  GET_TOURINFO,
} from "../reducer/TourInfoReducer";

const TourInfoAction = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const getTourInfo = async () => {
    try {
      const response = await serverRequest(REQUEST_TYPE.GET, "/admin/tourInfo");

      if (response.status === 200) {
        dispatch({
          type: GET_TOURINFO,
          payload: response.data,
        });
      }
    } catch (err) {
      console.log("error");
      console.log(err);
    }
  };

  // const getTourInfoByTourId = async(tourId)=>{
  //     try{
  //         const response = await serverRequest(REQUEST_TYPE.GET,`/newuser/tourInfo/tourId/${tourId}`);
  //         if(response.status === 200){
  //             dispatch({
  //                 type:GET_TOURINFO_BY_TOURID,
  //                 payload:response.data
  //             })
  //         }
  //     }catch(err){
  //         console.log("error");
  //         console.log(err);
  //     }
  // }

  const addTourInformation = async (tourInformation) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.POST,
        `/admin/tourInfo`,
        tourInformation
      );
      if (response.status === 200) {
        navigate("/tourInformation");
        return dispatch({ type: ADD_TOURINFORMATION, payload: response.data });
      }
    } catch (err) {
      console.log(err);
    }
  };
  const deleteTourInformation = async (tourInfoId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.DELETE,
        `/admin/tourInfo/${tourInfoId}`
      );
      if (response.status === 200) {
        alert("tourInfo is deleted");
        return dispatch({ type: DELETE_TOURINFORMATION, payload: tourInfoId });
      }
    } catch (err) {
      console.log(err);
    }
  };
  const editTourInformation = async (tourInformation, navigate) => {
    try {
      console.log({ tourInformation });
      const response = await serverRequest(
        REQUEST_TYPE.PUT,
        `/admin/tourInfo`,
        tourInformation
      );

      if (response.status === 200) {
        navigate("/tourInformation");
        return dispatch({
          type: EDIT_TOURINFORMATION,
          payload: tourInformation,
        });
      }
    } catch (err) {
      console.log(err);
    }
  };

  const getTourInformationById = async (tourInfoId) => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/admin/tourInfo/${tourInfoId}`
      );
      if (response.status === 200) {
        return response;
      }
    } catch (err) {
      console.log(err);
    }
  };
  return Object.freeze({
    addTourInformation,
    getTourInfo,
    editTourInformation,
    deleteTourInformation,
    getTourInformationById,
  });
};

export default TourInfoAction;
