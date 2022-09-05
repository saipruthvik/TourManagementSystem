import React, { useEffect } from "react";
import { useSelector } from "react-redux";
import StaffAction from "../../../redux/action/StaffAction";
import Footer from "../HomePage/Footer";
import NavBar from "../HomePage/NavBar";

const Adminview = () => {
    const prepareDate = (dateStr) => {
        const date = new Date(dateStr);
        return [date.getDate(), date.getMonth() + 1, date.getFullYear()].join("/");
    };

    const staffAction = StaffAction();
    useEffect(() => {
        staffAction.getPackageBookings();
    }, []);

    const { packageBookings } = useSelector((state) => {
        const copy = { ...state };
        return {
            packageBookings: copy.packageBookings || [],
        };
    });

    return (
        <div>
            <NavBar />
            <div className="card shadow-lg p-3 mb-5 bg-white rounded">
                <div className="text-center h2 p-3 bg-secondary text-white">
                    Package Bookings Details
                </div>


            </div>

            <React.Fragment>
                <table
                    className="table table-striped m-5 rounded border border-primary"
                    width="50%"
                    border="0"
                >
                    <thead>
                        <tr >
                            <th>Booking Id</th>
                            <th>Booking Status</th>
                            <th>Customer Id</th>
                            <th>Payment Type</th>
                            <th>Tour Information Id</th>
                            <th>Trip Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        {packageBookings &&
                            packageBookings.map((booking) => (
                                <tr key={booking.bookingId}>
                                    <td>{booking.bookingId}</td>
                                    <td>{booking.bookingStatus}</td>
                                    <td>{booking.customerInfoDto.customerId}</td>
                                    <td>{booking.paymentType}</td>
                                    <td>{booking.tourInformationDto.tourInformationId}</td>
                                    <td>{prepareDate(booking.tripDate)}</td>

                                </tr>
                            ))}
                    </tbody>
                </table>
            </React.Fragment>

            <Footer />
        </div>
    );
};

export default Adminview;
