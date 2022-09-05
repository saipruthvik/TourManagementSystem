import React, { useEffect } from "react";
import { Link } from "react-router-dom";
import HotelAction from "../../../redux/action/HotelAction";
import { useSelector } from "react-redux/es/exports";
import NavBar from "../HomePage/NavBar";
import Footer from "../HomePage/Footer";

const GetAllHotels = () => {
  const hotelAction = HotelAction();
  const hotels = useSelector((state) => state.hotels);
  useEffect(() => {
    if (hotels.length === 0) {
      hotelAction.getHotels();
    }
  }, []);

  const roomTypeSplit = (roomType) => {
    var arr = roomType;
    return arr.join(",");
  };



  return (
    <div className="">
      <NavBar />
      <div className="text-center h2 p-3 bg-secondary text-white">
        Hotel Details
      </div>
      <div>
      <Link to={"/hotel/new"} className="m-5">
        <button className="btn btn-lg btn-dark">Add Hotel</button>
      </Link>
      </div>
      <table
        className="table table-striped m-3"
        align="center"
        width="50%"
        border="0"
      >
        <thead>
          <tr align="center">
            <th>Hotel Id</th>
            <th>Hotel Name</th>
            <th>Hotel Description</th>
            <th>Location</th>
            <th>Hotel Room Types</th>
            <th>Hotel Service Cost</th>
          </tr>
        </thead>
        <tbody>
          {hotels.map((hotel) => (
            <tr key={hotel.hotelId}>
              <td>{hotel.hotelId}</td>
              <td>{hotel.hotelName}</td>
              <td>{hotel.hotelDescription}</td>
              <td>{hotel.location}</td>
              <td> {roomTypeSplit(hotel.roomType)}</td>
              <td>{hotel.hotelServiceCost} </td>

              <td>
                <Link to={`/hotel/${hotel.hotelId}`}>
                  <button className="btn btn-warning">Update</button>
                </Link>
              </td>
              <td>
                <div
                  onClick={() => {
                    console.log(hotel.hotelId);
                    hotelAction.deleteHotel(hotel.hotelId);
                  }}
                >
                  <button className="btn btn-danger">Delete</button>
                </div>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <Footer/>
    </div>
  );
};
export default GetAllHotels;
