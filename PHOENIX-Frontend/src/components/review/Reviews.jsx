import { useDispatch, useSelector } from "react-redux";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { actions } from "../../store/index";
import { addReviewOfProduct, deleteReviewOfProduct } from "../../fetch/index";
import AddReview from "./AddReview";
import ReviewCard from "./ReviewCard";

export default function Reviews(props) {
  const { product, setProduct } = props;
  const { isLoggedIn, user } = useSelector((state) => state.auth);
  const dispatch = useDispatch();

  const handleAdd = (values) => {
    if (!isLoggedIn) return dispatch(actions.loginModalActions.open());
    if (values.rating === 0 || values.text === "")
      return toast.warn('Reviews And Comment Field Cannot be left blank', {
        position: "bottom-center",
        autoClose: 2000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "colored",
      });
    addReviewOfProduct(values, product, user)
      .then((response) => setProduct(response))
      .catch((error) => alert(error));
  };

  const ownReview = product.reviews.find(
    (review) => review.userId === Number(user?.userId)
  );
  const handleDelete = () => {
    deleteReviewOfProduct(ownReview, product, user)
      .then((response) => setProduct(response))
      .catch((error) => alert(error));
  };

  if (product.reviews.length === 0) return <AddReview handleAdd={handleAdd} />;

  return (
    <>
      <h3>Reviews</h3>
      {product.reviews.map((review) => (
        <ReviewCard key={review.reviewId} review={review} />
      ))}
      {!ownReview ? (
        <>
          <hr />
          <AddReview handleAdd={handleAdd} />
        </>
      ) : (
        <button type="button" className="btn btn-dark" onClick={handleDelete}>
          Delete Review
        </button>
      )}
      <ToastContainer
        position="bottom-center"
        autoClose={2000}
        limit={5}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="colored"
      />
    </>
  );
}
