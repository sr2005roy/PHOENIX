import React from "react";
import blog_img from "../assets/img/blog/2.jpg";
import blog_img2 from "../assets/img/blog/1.webp";
import blog_img3 from "../assets/img/blog/2.webp";
import blog_img4 from "../assets/img/blog/2.jpg";
// import blog_img5 from "../assets/img/blog/3.jpg";
import blog_img6 from "../assets/img/blog/3.webp";
import blog_img7 from "../assets/img/blog/4.webp";
import blog_img8 from "../assets/img/blog/4.jpg";
export default function Blog() {
    return (
        <>
            <section id="blog-home" className="pt-5 mt-5 container">
                <h2 className="font-weight-bold">Blogs</h2>
                <hr />
            </section>
            <section id="blog-container" className="container pt-5">
                <div className="row">
                    <div className="post col-lg-6 col-md-6 col-12 pb-5">
                        <div className="post-img">
                            <img className="img-fluid w-100" src={blog_img2} alt="" />
                        </div>
                        <h3 className="text-center font-weight-normal pt-3">
                            The best ways to change your summer wardrobe into autumn wardrobe
                        </h3>
                        <p className="text-center">Jan 11, 2021</p>
                    </div>
                    <div className="post col-lg-6 col-md-6 col-12 pb-5">
                        <div className="post-img">
                            <img className="img-fluid w-100" src={blog_img} alt="" />
                        </div>
                        <h3 className="text-center font-weight-normal pt-3">
                            Men's fashion in leather
                        </h3>
                        <p className="text-center">Jan 11, 2021</p>
                    </div>
                    <div className="post col-lg-6 col-md-6 col-12 pb-5">
                        <div className="post-img">
                            <img className="img-fluid w-100" src={blog_img3} alt="" />
                        </div>
                        <h3 className="text-center font-weight-normal pt-3">
                            DIYer and TV host Trisha Hershberger's journey through gaming keeps
                            evolving
                        </h3>
                        <p className="text-center">Jan 11, 2021</p>
                    </div>
                    <div className="post col-lg-6 col-md-6 col-12 pb-5">
                        <div className="post-img">
                            <img className="img-fluid w-100" src={blog_img4} alt="" />
                        </div>
                        <h3 className="text-center font-weight-normal pt-3">
                            The best ways to change your summer wardrobe into autumn wardrobe
                        </h3>
                        <p className="text-center">Jan 11, 2021</p>
                    </div>
                    <div className=" col-lg-12 col-md-12 col-12 pb-5">
                        <div className="post-img">
                            <img className="img-fluid w-100" src="" alt="" />
                        </div>
                    </div>
                    <div className="post col-lg-4 col-md-6 col-12 pb-5">
                        <div className="post-img">
                            <img className="img-fluid w-100" src={blog_img6} alt="" />
                        </div>
                        <h4 className="text-center font-weight-normal pt-3">
                            The best ways to change your summer wardrob.
                        </h4>
                    </div>
                    <div className="post col-lg-4 col-md-6 col-12 pb-5">
                        <div className="post-img">
                            <img className="img-fluid w-100" src={blog_img7} alt="" />
                        </div>
                        <h4 className="text-center font-weight-normal pt-3">
                            Lenovo's smarter devices stoke professional passions
                        </h4>
                    </div>
                    <div className="post col-lg-4 col-md-6 col-12 pb-5">
                        <div className="post-img">
                            <img className="img-fluid w-100" src={blog_img8} alt="" />
                        </div>
                        <h4 className="text-center font-weight-normal pt-3">
                            Take a 3D tour through a Microsoft datacenter
                        </h4>
                    </div>
                </div>
            </section>
        </>

    )
}