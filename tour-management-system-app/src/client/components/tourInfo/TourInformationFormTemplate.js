import React,{ useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { REQUEST_TYPE, serverRequest } from "../../../axios";
import TourInfoAction from "../../../redux/action/TourInfoAction";
import { useNavigate } from "react-router-dom";

const TourInformationFormTemplate = () => {
  const { tourInfoId } = useParams();
  const tourInfoAction = TourInfoAction();
  const [tourInformation, setTourInformation] = useState({});
  const navigate = useNavigate();
  useEffect(() => {
    if (tourInfoId) {
      getTourInformationById();
    }
  }, []);

  const getTourInformationById = async () => {
    try {
      console.log(tourInfoId);
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/admin/tourInfo/${tourInfoId}`
      );
      if (response.status === 200) {
        setTourInformation({ ...response.data });
      }
    } catch (err) {
      console.log(err);
    }
  };

  const onInputChange = (event) => {
    setTourInformation({
      ...tourInformation,
      [event.target.name]: event.target.value,
    });
  };

  const onSubmit = (event) => {
    event.preventDefault();
    if (tourInfoId) {
      tourInfoAction.editTourInformation(tourInformation, navigate);
    } else {
      tourInfoAction.addTourInformation(tourInformation);
    }
  };
  return (
    <div className="container">
      <form className="form-signin rounded-sm shadow">
        <ul className="nav nav-pills mb-4">
          <li className="nav-item pill-1">
            <a
              className="nav-link active rounded-0"
              data-toggle="tab"
              href="tourInfo"
            >
              {tourInfoId ? "Update TourInformation" : "Add New TourInformation"}
            </a>
          </li>
        </ul>
        <div className="tab-content">
          <div id="tourInfo" className="container tab-pane active">
            <label htmlFor="location" className="sr-only">
            Enter location
            </label>
            <input
              type="text"
              id="location"
              name="location"
              className="form-control mb-4"
              placeholder="Enter location "
              value={tourInformation.location || ""}
              onChange={onInputChange}
              required
              autoFocus
            />
            <label htmlFor="hotelDescription" className="sr-only">
            Enter travelType
            </label>
            <input
              type="text"
              id="travelType"
              name="travelType"
              className="form-control mb-4"
              value={tourInformation.travelType || ""}
            onChange={onInputChange}
              placeholder="Enter travelType"
              required
            />
            <label htmlFor="tourDescription" className="sr-only">
            Enter tourDescription
            </label>
            <input
              type="text"
              id="tourDescription"
              name="tourDescription"
              value={tourInformation.tourDescription || ""}
              onChange={onInputChange}
              className="form-control mb-4"
              placeholder="Enter Hotel location"
              required
            />
            <label htmlFor="totalCost" className="sr-only">
            Enter totalCost
            </label>
            <input
              type="text"
              id="totalCost"
              name="totalCost"
              value={tourInformation.totalCost || ""}
              onChange={onInputChange}
              className="form-control mb-4"
              placeholder="Enter totalCost"
              required
            />
            <label htmlFor="hotelServiceCost" className="sr-only">
            Enter days
            </label>
            <input
              type="text"
              id="days"
              name="days"
              value={tourInformation.days || ""}
              onChange={onInputChange}
              className="form-control mb-4"
              placeholder="Enter days"
              required
            />
            <button
              className="btn btn-lg btn-dark btn-block"
              type="submit"
              onClick={onSubmit}
            >
              {tourInfoId ? "Update TourInformation" : "Add TourInformation"}
            </button>
            &nbsp;&nbsp;
            <Link to={"/tourInformation"}>
              <button className="btn btn-lg btn-dark btn-block">Cancel</button>{" "}
            </Link>
          </div>
        </div>
      </form>
    </div>
  );
};
export default TourInformationFormTemplate;
