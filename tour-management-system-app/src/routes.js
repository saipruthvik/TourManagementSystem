import { Provider } from "react-redux";
import { PersistGate } from "redux-persist/es/integration/react";
import { persistor, store } from "./redux/store";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import FallBack from './client/components/essential/FallBack';
import React from 'react';
import HomePage from "./client/components/HomePage/HomePage";
import Login from "./client/components/authentication/Login";
import HotelFormTemplate from "./client/components/hotel/HotelFormTemplate";
import GetAllHotels from "./client/components/hotel/getAllHotels";
import GetAllTourInfo from "./client/components/tourInfo/GetAllTourInfo";
import TourInformationFormTemplate from "./client/components/tourInfo/TourInformationFormTemplate";
import GetAllCustomerInfos from "./client/components/customers/GetAllCustomerInfos";
import AddStaff from "./client/components/staff/addStaff";
import ForgetPassword from "./client/components/essential/ForgetPassword";
import TourInfo from "./client/components/tourInfo/TourInfo";
import CustProfile from "./client/components/customers/custProfile";
import UpdateProfile from "./client/components/customers/UpdateProfile";
import GetPackageBookingsList from "./client/components/staffComponent/GetPackageBookingsList";
import TourInfoSpecific from "./client/components/tourInfo/TourInfoSpecific";
import BookingHistory from "./client/components/customers/BookingHistory";
import UpdateAddress from "./client/components/customers/UpdateAddress";
import GetHotelsAvailable from "./client/components/staffComponent/GetHotelsAvailable";
import ViewPackageBooking from "./client/components/staffComponent/ViewPackageBooking";
import ViewBookingHistory from "./client/components/customers/ViewBookingHistory";
import Adminview from "./client/components/customers/Adminview";
import Footer from "./client/components/HomePage/Footer";

const Routing = ()=>{
    return(
        <Provider store={store}>
        <PersistGate loading={<h1>Loading</h1>} persistor={persistor}>
            <BrowserRouter>
                <Routes>
                    <Route path="/login" element={<Login/>}/>
                    <Route path = "/register" element ={<Login/>}/>
                    <Route path = "*" exact element ={<FallBack/>}/>
                    <Route path="/" element={<HomePage/>}/>
                    <Route path="/packages" element={<TourInfo/>}/>
                    <Route path="/tourInfoSpecific/:tourId" element={<TourInfoSpecific/>}/>
                    <Route path="/hotel/new" element={<HotelFormTemplate />} />
                    <Route path="/hotel/:hotelId" element={<HotelFormTemplate />} />
                    <Route path="/hotel" element={<GetAllHotels />} />
                    <Route path="/tourInformation/new" element={<TourInformationFormTemplate />} />
                    <Route path="/tourInformation/:tourInfoId" element={<TourInformationFormTemplate />} />
                    <Route path="/tourInformation" element={<GetAllTourInfo />} />
                    <Route path="/custInfo" element={<GetAllCustomerInfos/>}/>
                    <Route path="/addstaff" element={<AddStaff/>}/>
                    <Route path="/forgetPassword" element={<ForgetPassword/>}/>
                    <Route path="/profile" element={<CustProfile/>}/>
                    <Route path="/updateprofile" element={<UpdateProfile/>}/>
                    <Route path="/getPackageBookings" element={<GetPackageBookingsList/>}/>
                    <Route path="/packageBooking/:bookingId" element={<ViewPackageBooking/>}/>
                    <Route path="/gethotelslist" exact element={<GetHotelsAvailable/>}/>
                    <Route path="/updateaddress" element={<UpdateAddress/>}/>
                    <Route path="/bookinghistory" element={<BookingHistory/>}/>
                    <Route path="/viewbookinghistory/:bookingId" element={<ViewBookingHistory/>}/>
                    <Route path="/adminview" element={<Adminview/>}/>
                </Routes>
            </BrowserRouter>
        </PersistGate>
    </Provider>
    );
    
}

export default Routing;