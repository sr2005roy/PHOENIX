import React from "react";
import styles from "../../pages/AboutUs.module.css"
import image from "../../assets/img/image-placeholder.jpg"
export default function AboutContainer({ name, role, description }) {
    return (
        <div className={styles.aboutUs}>
            <img src={image} className={styles.pic} />
            <div className={styles.text}>
                <h1>{name}</h1>
                <h5>
                    {role} &amp; <span>Designer</span>
                </h5>
                <p>
                    {description}
                </p>
                {/* <div className="data"><a href="#" class="hire">Hire Me</a></div> */}
            </div>
        </div>
    )
}