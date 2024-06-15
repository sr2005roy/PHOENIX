import { useEffect, useRef, useState } from "react";
import BrandContainer from "../components/cards/BrandContainer";
import SectionCard from "../components/cards/SectionCard";
import { getAllSections } from "../fetch/index";

export default function HomePage() {
  const [data, setData] = useState();
  const sectionsScroll = useRef(null);
  const scrollToSection = (elementRef) => {
    window.scrollTo({
      top: elementRef.current.offsetTop,
      behaviour: "smooth"
    });
  };
  useEffect(() => {
    getAllSections()
      .then((sections) => {
        setData(sections);
      })
      .catch((error) => console.log(error));
  }, []);

  if (!data) return <>Loading...</>;

  return (
    <div>
      <section id="home">
        <div className="container">
          <h5 style={{ fontSize: "2rem", fontWeight: "600" }}>NEW ARRIVALS</h5>
          <h1 style={{ fontSize: "3rem", fontWeight: "600" }}>
            <span>Best Price</span> This Year
          </h1>
          <p style={{ fontSize: "1.2rem" }}>
            Shoomatic offers your very comfortable time <br />
            walking and exercises.
          </p>
          <button onClick={() => scrollToSection(sectionsScroll)} className="btn btn-dark" style={{ width: "200px", height: "50px", fontSize: "1.4rem" }}>Shop Now</button>
        </div>
      </section>
      <BrandContainer />
      <div ref={sectionsScroll} className="sectionsScroll">
        {data.map((section) => (
          <SectionCard key={section.sectionId} section={section} />
        ))}
      </div>
    </div>
  );
}
