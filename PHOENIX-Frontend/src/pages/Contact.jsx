import React from "react";
import ContactForm from "../components/forms/ContactForm"
export default function Contact() {
    return (
        <section id="contact-section" className="mt">
            <div className="contact-bg">
                <h3>Get in Touch with us</h3>
                <h2>Contact us</h2>
                <div className="line">
                    <div />
                    <div />
                    <div />
                </div>
                <p className="text">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nulla aperiam, et
                    eveniet corporis odio laudantium beatae consequatur dolorum quidem
                    distinctio! Libero illum saepe recusandae quae voluptatibus. Neque
                    pariatur vel voluptates, corporis distinctio quia hic.
                </p>
            </div>
            <div className="contact-body">
                <div className="contact-info">
                    <div>
                        <span>
                            <i className="fa-solid fa-mobile-screen-button" />
                        </span>
                        <span>Phone No.</span>
                        <span>91-7757944514</span>
                    </div>
                    <div>
                        <span>
                            <i className="fa-solid fa-envelope" />
                        </span>
                        <span>E-mail:</span>
                        <span>teamname@gamil.com</span>
                    </div>
                    <div>
                        <span>
                            <i className="fa-sharp fa-solid fa-location-dot" />
                        </span>
                        <span>Address</span>
                        <span>IIIT Lucknow Chak Ganjaria, C. G. City Lucknow – 226002</span>
                    </div>
                    <div>
                        <span>
                            <i className="fa-sharp fa-solid fa-clock" />
                        </span>
                        <span>Opening Hours</span>
                        <span>Monday-Friday(9:00Am to 5:00 P M)</span>
                    </div>
                </div>
                <ContactForm />
            </div>
            <div className="map">
                <iframe
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d14244.911912110629!2d81.01529668754527!3d26.800868632130268!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x399be37eb0826741%3A0x34d9dd79cdeac7d8!2sIndian%20Institute%20of%20Information%20Technology%2C%20Lucknow!5e0!3m2!1sen!2sin!4v1678373964517!5m2!1sen!2sin"
                    width="100%"
                    height={450}
                    style={{ border: 0 }}
                    allowFullScreen=""
                    loading="lazy"
                    referrerPolicy="no-referrer-when-downgrade"
                />
            </div>
        </section>

    )
}