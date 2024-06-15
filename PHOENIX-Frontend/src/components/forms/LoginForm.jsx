import { useState } from "react";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Swal from "sweetalert2"
import { loginUser } from "../../fetch/index";
import { actions } from "../../store";
import Input from "./Input";

export default function LoginForm(props) {
  const { dispatch, onClose, setIsLogin } = props;

  const initialState = {
    email: "",
    password: "",
  };
  const [values, setValues] = useState(initialState);
  const [errors, setErrors] = useState(initialState);

  const showRegister = () => setIsLogin(false);
  const onChange = (e) => {
    setValues((prevValues) => {
      return { ...prevValues, [e.target.name]: e.target.value };
    });
  };
  const onSubmit = (e) => {
    e.preventDefault();
    loginUser(values)
      .then((res) => {
        let timerInterval
        Swal.fire({
          title: 'Logging In',
          html: '',
          timer: 2000,
          timerProgressBar: true,
          didOpen: () => {
            Swal.showLoading()
          },
        }).then((result) => {
          /* Read more about handling dismissals below */
          if (result.dismiss === Swal.DismissReason.timer) {
            console.log('I was closed by the timer')
          }
          Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'You have been successfully LoggedIn',
            showConfirmButton: false,
            timer: 1500
          })
          dispatch(actions.authActions.login(res));
        })
        onClose();
      })
      .catch((error) => {
        if (!error.props) {
          alert("Cannot connect to server");
          onClose();
        }
        setErrors(error.props);
      });
  };

  return (
    <div className={"card"} style={{ width: "400px" }}>
      <div className="card-body">
        <h3 className="card-title">Login</h3>
        <hr />

        <form onSubmit={onSubmit}>
          <Input
            name="email"
            label="Email"
            type="email"
            value={values.email}
            error={errors.email}
            onChange={onChange}
          />
          <Input
            name="password"
            label="Password"
            type="password"
            value={values.password}
            error={errors.password}
            onChange={onChange}
          />
          <div className="d-flex justify-content-end mb-5">
            <button className="btn btn-light" onClick={onClose}>
              Cancel
            </button>
            <button className="btn btn-dark" type="submit">
              Confirm
            </button>
          </div>
        </form>
        <p>
          Don't have an account?{" "}
          <span className="highlight-link" onClick={showRegister}>
            Register
          </span>
        </p>
      </div>
    </div>
  );
}
