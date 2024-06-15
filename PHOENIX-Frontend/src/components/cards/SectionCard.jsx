import React from "react";
import { Link } from "react-router-dom";

import CategoryCard from "./CategoryCard";
import styles from "./SectionCard.module.css";

export default function SectionCard(props) {
  const {
    section: { sectionId, sectionName, categories },
  } = props;

  if (!categories) return <>Loading...</>;

  return (
    <div className={styles["section-card"] + " bg-white"}>
      <div className={styles.header}>
        <h1 className="ovf-ellipse">{sectionName}</h1>
        <Link to={"/sections/" + sectionId} className="btn btn-dark">
          VIEW ALL
        </Link>
      </div>
      <hr />
      <div className={styles.slideshow}>
        <section id="new" className="w-100">
          {categories.map((category) => (
            <CategoryCard
              key={category.categoryId}
              category={category}
              className="col col-md-4 col-lg-3"
              width="230px"
            />
          ))}
        </section >
      </div>
    </div>
  );
}
