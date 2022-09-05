import React, { useEffect, useState } from "react";
import NavBar from "../HomePage/NavBar";
import Footer from "../HomePage/Footer";
import { useParams } from "react-router";
import { REQUEST_TYPE, serverRequest } from "../../../axios";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router";
import PackageBookingAction from "../../../redux/action/PackageBookingAction";

const TourInfoSpecific = () => {
  const navigate = useNavigate();
  const [customerInfo] = useSelector((state) => state.customerInfos);

  const packageBookingAction = PackageBookingAction();
  const { tourId } = useParams();
  const [tourInformation, setTourInformation] = useState("");

  const [persons, setPersons] = useState(1);

  const [packageBooking, setPackageBooking] = useState({
    tourInfoId: "",
    customerId: "",
    typeOfPayment: "",
    tripDate: "",
    packageCost: "",
  });

  useEffect(() => {
    if (tourId) {
      getTourInformationById();
    }
  }, []);

  const onInputChange = (event) => {
    setPackageBooking({
      ...packageBooking,
      [event.target.name]: event.target.value,
    });
  };

  const onInputChangePerson = (event) => {
    setPersons(event.target.value);
  };

  const onSubmit = (event) => {
    event.preventDefault();
    if (typeof customerInfo === "undefined") {
      alert("Login Please !!!");
      navigate("/login");
    } else {
      if (new Date(packageBooking.tripDate).getTime() > new Date().getTime()) {
        packageBooking.packageCost = eval(persons * tourInformation.totalCost);
        if (window.confirm("total Cost is : " + packageBooking.packageCost)) {
          packageBooking.customerId = customerInfo.customerId;
          console.log("customerInfo ", customerInfo);
          packageBooking.tourInfoId = tourId;
          console.log(persons);
          console.log("package Booking : ", packageBooking);
          packageBookingAction.addPackageBooking(packageBooking);
          navigate("/");
        } else {
          navigate("/packages");
        }
      } else {
        alert("Select Valid Date!!!");
      }
    }
  };

  const getTourInformationById = async () => {
    try {
      console.log(tourId);
      const response = await serverRequest(
        REQUEST_TYPE.GET,
        `/admin/tourInfo/${tourId}`
      );
      if (response.status === 200) {
        setTourInformation({ ...response.data });
      }
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div>
      <NavBar />
      <Link to="/packages" className="btn btn-lg btn-dark ml-5">
        <div>Back</div>
      </Link>
      {tourInformation && (
        <div className="d-flex flex-column justify-content-center align-items-center">
          <div className="text-center h2 p-3">Package Details</div>

          <div className="card p-3 rounded m-3">
            <div className="form-group row">
              <label htmlFor="staticEmail" className="col-sm col-form-label">
                Tour Location
              </label>
              <div className="col-sm">
                <input
                  type="text"
                  className="form-control-plaintext text-wrap"
                  value={tourInformation.location}
                  readOnly
                />
              </div>
            </div>
            <div className="form-group row">
              <label htmlFor="staticEmail" className="col-sm col-form-label">
                Tour Description
              </label>
              <div className="col-sm">{tourInformation.tourDescription}</div>
            </div>
            <div className="form-group row">
              <label htmlFor="staticEmail" className="col-sm col-form-label">
                Number of Days
              </label>
              <div className="col-sm">
                <input
                  type="text"
                  className="form-control-plaintext"
                  value={tourInformation.days}
                  readOnly
                />
              </div>
            </div>
            <div className="form-group row">
              <label htmlFor="staticEmail" className="col-sm col-form-label">
                Travel Type
              </label>
              <div className="col-sm">
                <input
                  type="text"
                  className="form-control-plaintext"
                  value={tourInformation.travelType}
                  readOnly
                />
              </div>
            </div>
            <div className="form-group row">
              <label htmlFor="staticEmail" className="col-sm col-form-label">
                Cost
              </label>
              <div className="col-sm">
                <input
                  type="text"
                  className="form-control-plaintext"
                  value={tourInformation.totalCost}
                  readOnly
                />
              </div>
            </div>
            <form>
              <div className="form-group row">
                <label htmlFor="tripDate" className="col-sm col-form-label">
                  Select Booking Date :
                </label>
                <div className="col-sm">
                  <input
                    type="date"
                    name="tripDate"
                    id="tripDate"
                    className="form-control"
                    onChange={onInputChange}
                    value={tourInformation.tripDate}
                    //   readOnly
                  />
                </div>
              </div>
              <div className="form-group row">
                <label
                  htmlFor="typeOfPayment"
                  className="col-sm col-form-label"
                >
                  Select Payment Type :{" "}
                </label>
                <div className="col-sm">
                  <select
                    name="typeOfPayment"
                    id="typeOfPayment"
                    onChange={onInputChange}
                    className="form-control"
                    required
                  >
                    <option value="">--Select--</option>
                    <option value="Online">Online</option>
                    <option value="ByCash">By Cash</option>
                  </select>
                </div>
              </div>
              <div className="form-group row">
                <label htmlFor="persons" className="col-sm col-form-label">
                  Number of persons
                </label>
                <div className="col-sm">
                  <input
                    type="text"
                    name="persons"
                    id="persons"
                    className="form-control"
                    onChange={onInputChangePerson}
                    value={persons}
                  />
                </div>
              </div>
              <div className="d-flex justify-content-between">
                <button
                  className="btn btn-dark"
                  type="submit"
                  onClick={onSubmit}
                  id={tourId}
                >
                  Book
                </button>
                <Link className="btn btn-dark" type="submit" to="/packages">
                  Cancel
                </Link>
              </div>
            </form>
          </div>
        </div>
      )}
      <Footer />
    </div>
  );
};
export default TourInfoSpecific;
