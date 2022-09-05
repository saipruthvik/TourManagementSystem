import React, {useState} from "react";
import { useNavigate, Link } from "react-router-dom";
import { serverRequest,REQUEST_TYPE } from "../../../axios";


const Forget = () => {
    const navigate = useNavigate();
    const [userId, setUserId] = useState("");
  
    const onInputChange = (event) => {
        setUserId(event.target.value);
    };  
  
    const getPassword = async (userId) => {
      try {
        console.log(userId);
        const response = await serverRequest(
          REQUEST_TYPE.GET,
          `/login/getPassword/${userId}`
        );
        console.log(response.data);
        if (response.status === 200) {
          alert("Password : "+response.data);
          navigate("/");
        }
      } catch (err) {
        console.log(err);
      }
    };


    const onSubmit = (event) => {
        event.preventDefault();
        getPassword(userId);
      };

  return (
    <div className="container">
      <form className="form-signin rounded-sm shadow">
        {/* <!-- Nav tabs --> */}
        <ul className="nav nav-pills mb-4">
          <li className="nav-item pill-1">
            <a
              className="nav-link active rounded-0"
              data-toggle="tab"
              href="#login"
            >
              Forget Password
            </a>
          </li>
        </ul>
        <div id="login" className="container tab-pane active">
          <div className="tab-content">
            <label htmlFor="userId" className="sr-only">
              userId
            </label>
            <input
              type="userId"
              id="userId"
              name="userId"
              className="form-control mb-4"
                value={userId}
              onChange={onInputChange}
              placeholder="userId"
              required
            />

            <button
              className="btn btn-lg btn-dark btn-block"
              type="submit"
              onClick={onSubmit}
            >
              Get Password
            </button>
            <Link className="btn btn-lg btn-dark btn-block" to="/">
                Cancel
              </Link>
          </div>
        </div>
      </form>
    </div>
  );
};
export default Forget;
