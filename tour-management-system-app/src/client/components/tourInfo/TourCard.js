import { Link } from "react-router-dom";
import React from "react";

const TourCard = (props) => {
  const tour = props.tour;
  return (
    <div className="col-sm-6">
      <div className="card m-1">
        <div className="card-body">
          <h4 className="card-title">{tour.location}</h4>
          <p className="card-text">
            <b>Description :</b>
            {tour.tourDescription}
          </p>
          <p className="card-text">
            <b>Number of Days :</b>
            {tour.days}
          </p>
          <p className="card-text">
            <b>Travel Type :</b> By {tour.travelType}
          </p>
          <Link
            data-toggle="collapse"
            href="#collapseExample"
            role="button"
            aria-expanded="false"
            aria-controls="collapseExample"
            to={`/tourInfoSpecific/${tour.tourInfoId}`}
          >
            View Package...
          </Link>
        </div>
      </div>
    </div>
  );
};

export default TourCard;
