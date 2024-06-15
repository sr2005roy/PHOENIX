import React from "react";
import brand1 from "../../assets/img/1-5.jpg"
import brand2 from "../../assets/img/2-8.jpg"
import brand3 from "../../assets/img/4-5.jpg"
import brand4 from "../../assets/img/5-5.jpg"
import brand5 from "../../assets/img/6-4.jpg"
import brand6 from "../../assets/img/7-4.jpg"
export default function BrandContainer() {
    return (
        <section id="brand" className="container">
            <div className="row m-0 py-5">
                <img className="img-fluid col-lg-2 col-md-4 col-6" src={brand1} alt="" />
                <img className="img-fluid col-lg-2 col-md-4 col-6" src={brand2} alt="" />
                <img className="img-fluid col-lg-2 col-md-4 col-6" src={brand3} alt="" />
                <img className="img-fluid col-lg-2 col-md-4 col-6" src={brand4} alt="" />
                <img className="img-fluid col-lg-2 col-md-4 col-6" src={brand5} alt="" />
                <img className="img-fluid col-lg-2 col-md-4 col-6" src={brand6} alt="" />
            </div>
        </section>
    )
}