import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { REQUEST_TYPE, serverRequest } from "../../../axios";
import HotelAction from "../../../redux/action/HotelAction";
import { useNavigate } from "react-router-dom";

const HotelFormTemplate = () => {
  const { hotelId } = useParams();
  const hotelAction = HotelAction();
  const [hotel, setHotel] = useState({});
  const navigate = useNavigate();
  
  useEffect(() => {
    if (hotelId) {
      getHotelById();
    }
  }, []);

  const getHotelById = async () => {
    try {
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/admin/hotelById/${hotelId}`
      );
      if (response.status === 200) {
        setHotel({ ...response.data });
      }
    } catch (err) {
      console.log(err);
    }
  };

  const onInputChange = (event) => {
    setHotel({ ...hotel, [event.target.name]: event.target.value });
  };

  const onSubmit = (event) => {
    event.preventDefault();
    if (hotelId) {
      hotelAction.editHotel(hotel, navigate);
    } else {
      hotelAction.addHotel(hotel);
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
              href="Hotel"
            >
              {hotelId ? "Update Hotel" : "Add New Hotel"}
            </a>
          </li>
        </ul>
        <div className="tab-content">
          <div id="Hotel" className="container tab-pane active">
            <label htmlFor="hotelName" className="sr-only">
              Hotel Name
            </label>
            <input
              type="text"
              id="hotelName"
              name="hotelName"
              className="form-control mb-4"
              placeholder="Enter Hotel Name "
              value={hotel.hotelName || ""}
              onChange={onInputChange}
              required
              autoFocus
            />
            <label htmlFor="hotelDescription" className="sr-only">
              Enter hotelDescription
            </label>
            <input
              type="text"
              id="hotelDescription"
              name="hotelDescription"
              className="form-control mb-4"
              value={hotel.hotelDescription || ""}
              onChange={onInputChange}
              placeholder="Enter Hotel Description"
              required
            />
            <label htmlFor="location" className="sr-only">
              Enter Hotel location
            </label>
            <input
              type="text"
              id="location"
              name="location"
              value={hotel.location || ""}
              onChange={onInputChange}
              className="form-control mb-4"
              placeholder="Enter Hotel location"
              required
            />
            <label htmlFor="roomType" className="sr-only">
              Enter Hotel roomTypes
            </label>
            <input
              type="text"
              id="roomType"
              name="roomType"
              value={hotel.roomType || ""}
              onChange={onInputChange}
              className="form-control mb-4"
              placeholder="Enter Hotel roomType (AC/NONAC)"
              required
            />
            <label htmlFor="hotelServiceCost" className="sr-only">
              Enter hotelServiceCost
            </label>
            <input
              type="text"
              id="hotelServiceCost"
              name="hotelServiceCost"
              value={hotel.hotelServiceCost || ""}
              onChange={onInputChange}
              className="form-control mb-4"
              placeholder="Enter hotelServiceCost"
              required
            />
            <button
              className="btn btn-lg btn-dark btn-block"
              type="submit"
              onClick={onSubmit}
            >
              {hotelId ? "Update Hotel" : "Add Hotel"}
            </button>
            &nbsp;&nbsp;
            <Link to={"/hotel"}>
              <button className="btn btn-lg btn-dark btn-block">Cancel</button>{" "}
            </Link>
          </div>
        </div>
      </form>
    </div>
  );
};
export default HotelFormTemplate;
