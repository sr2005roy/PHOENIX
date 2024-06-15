import React, { useState } from 'react';
import { BACKEND_TWO_API_URL } from "../../config";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
export default function ContactForm() {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');
    const [message, setMessage] = useState('');
    let formData;
    const handleSubmit = (e) => {
        e.preventDefault();
        formData = { phone, email, firstName, lastName, message };
        postContact();
        console.log('Form submitted:', { firstName, lastName, email, phone, message });
        setFirstName('');
        setLastName('');
        setEmail('');
        setPhone('');
        setMessage('');
        console.log("Success");
    };
    const postContact = async () => {
        const response = await fetch(`${BACKEND_TWO_API_URL}/contactUs/`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ phone, email, firstName, lastName, message })
        });

        const data = await response.json();
        toast.success("Your Query has been submitted successfully");
        return data;
    };
    return (
        <div className="contact-form">
            <form onSubmit={handleSubmit}>
                <div>
                    <input
                        type="text"
                        id="firstName"
                        value={firstName}
                        className="form-control"
                        onChange={(e) => setFirstName(e.target.value)}
                        required
                        placeholder="First Name"
                    />
                    <input type="text"
                        id="lastName"
                        value={lastName}
                        className="form-control"
                        onChange={(e) => setLastName(e.target.value)}
                        required
                        placeholder="Last Name" />
                </div>
                <div>
                    <input type="email"
                        id="email"
                        value={email}
                        className="form-control"
                        onChange={(e) => setEmail(e.target.value)}
                        required
                        placeholder="Email" />
                    <input type="tel"
                        id="phone"
                        value={phone}
                        className="form-control"
                        onChange={(e) => setPhone(e.target.value)}
                        required
                        placeholder="Phone" />
                </div>
                <div>
                    <textarea
                        id="message"
                        className="form-control"
                        value={message}
                        onChange={(e) => setMessage(e.target.value)}
                        required
                        placeholder="Message"
                    />
                </div>
                <button type="submit" className="send-btn">Send Message</button>
            </form>
            <div className="contact-img">
                <img src="/contact.jpg" alt="" />
            </div>
            <ToastContainer />
        </div>
    );
}