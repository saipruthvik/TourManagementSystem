import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import TourInfoAction from "../../../redux/action/TourInfoAction";
import { useSelector } from "react-redux/es/exports";
import NavBar from "../HomePage/NavBar";
import Footer from "../HomePage/Footer";

const GetAllTourInfo = () => {
  const tourInfoAction = TourInfoAction();
  let [tourInfoResult, setTourInfoResult] = useState([]);
  const tourInfo = useSelector((state) => state.tourInfo);
  console.log(tourInfo);
  console.log(tourInfoResult);

  useEffect(() => {
    if (tourInfo.length < 1) {
      tourInfoAction.getTourInfo();
    }
    setTourInfoResult(tourInfo);
  }, [tourInfo]);

  const handleSearch = (event) => {
    let value = event.target.value;
    tourInfoResult = tourInfo.filter((data) => {
      return data.location.search(value) !== -1;
    });
    setTourInfoResult(tourInfoResult);
  };

  return (
    <div>
      <NavBar />
      <div className="text-center h2 p-3 bg-secondary text-white">
        Tour Information Details
      </div>
      <div>
        <div className="d-flex justify-content-between">
          <Link to={"/"} className="m-2">
            <button className="btn btn-lg btn-dark">Back</button>
          </Link>
          <Link to={"/tourInformation/new"} className="m-2">
            <button className="btn btn-lg btn-dark">Add TourInformation</button>
          </Link>
        </div>
        
        <div className="form-outline nav-item ml-5 mr-5">
          <input
            type="search"
            className="form-control"
            id="datatable-search-input"
            placeholder="Search By location.. Ex..  Hyderabad"
            onChange={handleSearch}
          />
        </div>
      </div>
      <table
        className="table table-striped m-5 rounded border border-primary"
        align="center"
        width="50%"
        border="0"
      >
        <thead>
          <tr >
            <th>Tour Id</th>
            <th>Location</th>
            <th>Travel Type</th>
            <th>Tour Description</th>
            <th>TotalCost</th>
            <th>No of Days</th>
          </tr>
        </thead>
        <tbody>
          {tourInfoResult.length > 0 &&
            tourInfoResult.map((tourInformation) => (
              <tr key={tourInformation.tourInfoId}>
                <td>{tourInformation.tourInfoId}</td>
                <td>{tourInformation.location}</td>
                <td>{tourInformation.travelType}</td>
                <td>{tourInformation.tourDescription}</td>
                <td>{tourInformation.totalCost}</td>
                <td>{tourInformation.days} </td>

                <td>
                  <Link to={`/tourInformation/${tourInformation.tourInfoId}`}>
                    <button className="btn btn-warning">Update</button>
                  </Link>
                </td>
                <td>
                  <div
                    onClick={() => {
                      tourInfoAction.deleteTourInformation(tourInformation.tourInfoId);
                    }}
                  >
                    <button className="btn btn-danger">Delete</button>
                  </div>
                </td>
              </tr>
            ))}
        </tbody>
      </table>
      <Footer />
    </div>
  );
};
export default GetAllTourInfo;
