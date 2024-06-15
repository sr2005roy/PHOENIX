import React from "react";
import AboutContainer from "../components/cards/AboutContainer";
import styles from "./AboutUs.module.css"
export default function AboutUs() {
    const developers = [
        {
            name: "Sukrit Malpani",
            role: "Frontend Developer",
            description: "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Accusamus repellendus adipisci voluptas praesentium labore, assumenda officia, blanditiis porro sed temporibus eaque, dolore at quam est. Asperiores nisi velit, fugiat animi ea quo vel quod quibusdam eligendi consectetur sed laborum obcaecati cupiditate deserunt veritatis quaerat enim reprehenderit possimus at aperiam modi!"
        },
        {
            name: "Shubham Roy",
            role: "Frontend Developer",
            description: "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Accusamus repellendus adipisci voluptas praesentium labore, assumenda officia, blanditiis porro sed temporibus eaque, dolore at quam est. Asperiores nisi velit, fugiat animi ea quo vel quod quibusdam eligendi consectetur sed laborum obcaecati cupiditate deserunt veritatis quaerat enim reprehenderit possimus at aperiam modi!"
        },
        {
            name: "Manan Patel",
            role: "Frontend Developer",
            description: "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Accusamus repellendus adipisci voluptas praesentium labore, assumenda officia, blanditiis porro sed temporibus eaque, dolore at quam est. Asperiores nisi velit, fugiat animi ea quo vel quod quibusdam eligendi consectetur sed laborum obcaecati cupiditate deserunt veritatis quaerat enim reprehenderit possimus at aperiam modi!"
        },
        {
            name: "Darsh Baxi",
            role: "Frontend Developer",
            description: "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Accusamus repellendus adipisci voluptas praesentium labore, assumenda officia, blanditiis porro sed temporibus eaque, dolore at quam est. Asperiores nisi velit, fugiat animi ea quo vel quod quibusdam eligendi consectetur sed laborum obcaecati cupiditate deserunt veritatis quaerat enim reprehenderit possimus at aperiam modi!"
        },
        {
            name: "Yash Kudnar",
            role: "Frontend Developer",
            description: "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Accusamus repellendus adipisci voluptas praesentium labore, assumenda officia, blanditiis porro sed temporibus eaque, dolore at quam est. Asperiores nisi velit, fugiat animi ea quo vel quod quibusdam eligendi consectetur sed laborum obcaecati cupiditate deserunt veritatis quaerat enim reprehenderit possimus at aperiam modi!"
        },
        {
            name: "Kshitij Gupta",
            role: "Frontend Developer",
            description: "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Accusamus repellendus adipisci voluptas praesentium labore, assumenda officia, blanditiis porro sed temporibus eaque, dolore at quam est. Asperiores nisi velit, fugiat animi ea quo vel quod quibusdam eligendi consectetur sed laborum obcaecati cupiditate deserunt veritatis quaerat enim reprehenderit possimus at aperiam modi!"
        },
        
    ]
    const elements = developers.map((developer) => {
        return (
            <AboutContainer name={developer.name} role={developer.role} description={developer.description} />
        )
    })
    return (
        <div className={styles.about}>
            {elements}
        </div>
    )
}