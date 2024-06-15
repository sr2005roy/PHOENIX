import React from "react";
import insta1 from "../../assets/img/insta/1.jpg"
import insta2 from "../../assets/img/insta/2.jpg"
import insta3 from "../../assets/img/insta/3.jpg"
import insta4 from "../../assets/img/insta/4.jpg"
import insta5 from "../../assets/img/insta/5.jpg"
export default function Footer() {
    return (
        <footer className="mt-5 py-5">
            <div className="row container mx-auto pt-5">
                <div className="footer-one col-lg-3 col-md-6 col-12">
                    <img src="" alt="" />
                    <p className="pt-3">
                        Lorem, ipsum dolor sit amet consectetur adipisicing elit. Excepturi
                        dolor rerum optio assumenda neque eius totam nobis, qui saepe inventore!
                    </p>
                </div>
                <div className="footer-one col-lg-3 col-md-6 col-12 mb-3">
                    <h5 className="pb-2">Featured</h5>
                    <ul className="text-uppercase list-unstyled">
                        <li>
                            <a href="#">men</a>
                        </li>
                        {/* <li><a href="#">women</a></li> */}
                        <li>
                            <a href="#">boys</a>
                        </li>
                        {/* <li><a href="#">girls</a></li> */}
                        <li>
                            <a href="#">new arrivals</a>
                        </li>
                        <li>
                            <a href="#">shoes</a>
                        </li>
                        <li>
                            <a href="#">clothes</a>
                        </li>
                        <li>
                            <a href="#">watches</a>
                        </li>
                    </ul>
                </div>
                <div className="footer-one col-lg-3 col-md-6 col-12 mb-3">
                    <h5 className="pb-2">Contact Us</h5>
                    <div>
                        <h6 className="text-uppercase">Address</h6>
                        <p> IIIT Lucknow Chak Ganjaria, C. G. City Lucknow – 226002</p>
                    </div>
                    <div>
                        <h6 className="text-uppercase">Phone</h6>
                        <p>(123) 456-7890</p>
                    </div>
                    <div>
                        <h6 className="text-uppercase">Email</h6>
                        <p>MAIL@EXAMPLE.COM</p>
                    </div>
                </div>
                <div className="footer-one col-lg-3 col-md-6 col-12">
                    <h5 className="pb-2">Instagram</h5>
                    <div className="row">
                        <img
                            className="img-fluid w-25 h-100 m-2"
                            src={insta1}
                            alt=""
                        />
                        <img
                            className="img-fluid w-25 h-100 m-2"
                            src={insta2}
                            alt=""
                        />
                        <img
                            className="img-fluid w-25 h-100 m-2"
                            src={insta3}
                            alt=""
                        />
                        <img
                            className="img-fluid w-25 h-100 m-2"
                            src={insta4}
                            alt=""
                        />
                        <img
                            className="img-fluid w-25 h-100 m-2"
                            src={insta5}
                            alt=""
                        />
                    </div>
                </div>
            </div>
            <div className="copyright mt-5">
                <div className="row container mx-auto">
                    <div className="col-lg-3 col-md-6 col-12 mb-4">
                        <img src="" alt="" />
                    </div>
                    <div className="col-lg-3 col-md-6 col-12 text-nowrap mb-2">
                        <p>PHOENIX © 2023. All Rights Reserved</p>
                    </div>
                    <div className="col-lg-3 col-md-6 col-12">
                        <a href="">
                            <i className="fab fa-facebook-f" />
                            {/* <i className="fa-brands fa-facebook-f" /> */}
                        </a>
                        <a href="">
                            <i className="fab fa-twitter" />
                            {/* <i className="fa-brands fa-facebook-f" /> */}
                        </a>
                        <a href="">
                            <i className="fab fa-linkedin-in" />
                            {/* <i className="fa-brands fa-facebook-f" /> */}
                        </a>
                    </div>
                </div>
            </div>
        </footer>

    )
}