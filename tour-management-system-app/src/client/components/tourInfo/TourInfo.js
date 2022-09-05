
import React, { useEffect } from "react";
import { useSelector } from "react-redux";
import TourInfoAction from "../../../redux/action/TourInfoAction";
import Footer from "../HomePage/Footer";
import NavBar from "../HomePage/NavBar";
import TourCard from "./TourCard";

const TourInfo = () => {
  const tourInfoAction = TourInfoAction();
  const tourInfo = useSelector((state) => state.tourInfo);

  useEffect(() => {
    if (tourInfo.length === 0) {
      tourInfoAction.getTourInfo();
    }
  });

  return (
    <div>
      <NavBar/>
      <h1 className="text-center bg-secondary text-white m-2 p-3">Packages</h1>
      <form>
        <div className="row m-3 ">
          {tourInfo.map((tour) => (
            <TourCard tour={tour} key={tour.tourInfoId}/>
          ))}
          ;
        </div>
      </form>
      <Footer/>
    </div>
  );
};

export default TourInfo;
