import React from "react";
import { Link } from "react-router-dom";

import { ReactComponent as StarIcon } from "../../assets/svg/star.svg";
import imagePlaceholder from "../../assets/img/image-placeholder.jpg";
import styles from "./ProductCard.module.css";

export default function ProductCard(props) {
  const {
    product: {
      productId,
      productName,
      imageUrl,
      markedPrice,
      sellingPrice,
      reviewCount,
      totalRating,
    },
  } = props;

  const discount = Math.floor(
    ((markedPrice - sellingPrice) * 100.0) / markedPrice
  );
  let rating;

  rating = reviewCount === 0 ? 0.0 : totalRating / reviewCount;
  return (
    <Link to={`/products/${productId}`}>
      <div className={styles["product-card"] + " bg-white"}>
        <div>
          <img
            src={imageUrl || imagePlaceholder}
            alt="Product"
            width="200px"
            height="250px"
          />
        </div>
        <div className={styles.details}>
          <h5 className="ovf-ellipse">{productName}</h5>
          <div className={styles.rating}>
            <span className={styles.score}>
              {rating.toFixed(1)} <StarIcon className={styles.star} />
            </span>
            <span className={styles.reviews}>
              {" "}
              {reviewCount.toLocaleString()} Reviews
            </span>
          </div>
          {discount === 0 ? (
            <div className={styles.price}>
              <span className={styles.main}>
                &#8377;{markedPrice.toLocaleString()}
              </span>
            </div>
          ) : (
            <div className={styles.price}>
              <span className={styles.main}>
                &#8377;{sellingPrice.toLocaleString()}
              </span>
              <span className={styles.original}>
                {" "}
                &#8377;{markedPrice.toLocaleString()}
              </span>
              <span className={styles.discount}>{discount}% off</span>
            </div>
          )}
        </div>
      </div>
    </Link>
  );
}
