import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import Swal from "sweetalert2";
import { actions } from "../../store";
import { ReactComponent as CartIcon } from "../../assets/svg/cart-shopping-solid.svg";
import { ReactComponent as AboutIcon } from "../../assets/svg/address-card-solid.svg";
import { ReactComponent as TruckIcon } from "../../assets/svg/truck-solid.svg";
import { ReactComponent as ProfileIcon } from "../../assets/svg/user-solid.svg";
import { ReactComponent as BlogIcon } from "../../assets/svg/blog-solid.svg";
import { ReactComponent as ContactIcon } from "../../assets/svg/info.svg";
import WarningModal from "../modals/WarningModal";
import styles from "./Menu.module.css";

export default function Profile() {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const auth = useSelector((state) => state.auth);
  const [isWarningOpen, setIsWarningOpen] = useState(false);

  const promptForLogin = () => dispatch(actions.loginModalActions.open());

  function handleLogOut() {
    Swal.fire({
      title: 'Are you sure you want to LogOut?',
      text: "Leaving us so soon!!!!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Confirm'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          dispatch(actions.authActions.logout()),
          setIsWarningOpen(false)
        )
      }
      else {
        setIsWarningOpen(false)
      }
    })
  }
  if (!auth.isLoggedIn)
    return (
      <>
        <li className="nav-item">
          <button
            className={`btn btn-dark bold ${styles["btn-header"]}`}
            onClick={() => navigate("/about")}
          >
            <AboutIcon
              style={{
                width: "20px",
                height: "20px",
                fill: "white",
                marginRight: "8px",
              }}
            />
            About
          </button>
        </li>
        <li className="nav-item">
          <button
            className={`btn btn-dark bold ${styles["btn-header"]}`}
            onClick={() => navigate("/contact")}
          >
            <ContactIcon
              style={{
                width: "20px",
                height: "20px",
                fill: "white",

              }}
            />
            Contact
          </button>
        </li>
        <li className="nav-item">
          <button
            className={`btn btn-dark bold ${styles["btn-header"]}`}
            onClick={() => navigate("/blog")}
          >
            <BlogIcon
              style={{
                width: "20px",
                height: "20px",
                fill: "white",
                marginRight: "8px",
              }}
            />
            Blog
          </button>
        </li>
        <li className="nav-item">
          <div
            className={`btn btn-dark bold ${styles["btn-header"]}`}
            onClick={promptForLogin}
          >
            <ProfileIcon
              style={{
                width: "20px",
                height: "20px",
                fill: "white",
                marginRight: "8px",
              }}
            />
            Login
          </div>
        </li>
      </>
    );

  return (
    <>
      <li className="nav-item">
        <button
          className={`btn btn-dark bold ${styles["btn-header"]}`}
          onClick={() => navigate("/about")}
        >
          <AboutIcon
            style={{
              width: "20px",
              height: "20px",
              fill: "white",
              marginRight: "8px",
            }}
          />
          About
        </button>
      </li>
      <li className="nav-item">
        <button
          className={`btn btn-dark bold ${styles["btn-header"]}`}
          onClick={() => navigate("/contact")}
        >
          <ContactIcon
            style={{
              width: "20px",
              height: "20px",
              fill: "white",
              marginRight: "8px",
            }}
          />
          Contact
        </button>
      </li>
      <li className="nav-item">
        <button
          className={`btn btn-dark bold ${styles["btn-header"]}`}
          onClick={() => navigate("/blog")}
        >
          <BlogIcon
            style={{
              width: "20px",
              height: "20px",
              fill: "white",
              marginRight: "8px",
            }}
          />
          Blog
        </button>
      </li>
      <li className="nav-item">
        <button
          className={`btn btn-dark bold ${styles["btn-header"]}`}
          onClick={() => navigate("/cart")}
        >
          <CartIcon
            style={{
              width: "20px",
              height: "20px",
              fill: "white",
              marginRight: "8px",
            }}
          />
          Cart
        </button>
      </li>
      <li className="nav-item">
        <button
          className={`btn btn-dark bold ${styles["btn-header"]}`}
          onClick={() => navigate("/orders")}
        >
          <TruckIcon
            style={{
              width: "20px",
              height: "20px",
              fill: "white",
              marginRight: "8px",
            }}
          />
          Orders
        </button>
      </li>
      <li className="nav-item">
        <button
          className={`btn btn-dark bold ${styles["btn-header"]}`}
          onClick={handleLogOut}
        >
          <ProfileIcon
            style={{
              width: "20px",
              height: "20px",
              fill: "white",
              marginRight: "8px",
            }}
          />
          Logout
        </button>
      </li>
      <WarningModal
        isOpen={isWarningOpen}
        title="Logout"
        message="Are you sure you want to logout?"
        onCancel={() => setIsWarningOpen(false)}
        onConfirm={() => {
          dispatch(actions.authActions.logout());
          setIsWarningOpen(false);
        }}
      />
    </>
  );
}
