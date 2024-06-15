import { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import Swal from "sweetalert2";
import {
  getCart,
  placeOrder,
  removeProductFromCart,
  updateProductInCart,
} from "../fetch/index";
import CartProductCard from "../components/cards/CartProductCard";
import styles from "./Cart.module.css";
import MessageCard from "../components/cards/MessageCard";
import NoticeModal from "../components/modals/NoticeModal";

export default function CartPage() {
  const [cart, setCart] = useState(null);
  const [isOpen, setIsOpen] = useState(false);
  const { isLoggedIn, user } = useSelector((state) => state.auth);
  console.log(cart);

  const deleteProduct = (product) => {
    removeProductFromCart(product.cartItemId, user)
      .then((res) => setCart(res))
      .catch((err) => alert(err));
  };
  const updateProduct = (product) => {
    updateProductInCart(product.cartItemId, product.quantity, user)
      .then((res) => setCart(res))
      .catch((err) => alert(err));
  };

  useEffect(() => {
    if (isLoggedIn) {
      getCart(user)
        .then((cart) => {
          setCart(cart);
        })
        .catch((error) => console.log(error));
    } else {
      setCart(null);
    }
  }, [isLoggedIn, user]);

  if (!isLoggedIn) return <MessageCard message="Not Logged In" />;
  if (!cart || cart.cartItems.length === 0)
    return (
      <>
        <NoticeModal
          title="Order Placed"
          message="Your order has been successfully processed"
          onClose={() => setIsOpen(false)}
          isOpen={isOpen}
        />
        <MessageCard message="Cart Is Empty" />
      </>
    );

  const total = cart.totalAmount;

  return (
    <div className="bg-white">
      {cart.cartItems.map((product) => {
        return (
          <CartProductCard
            key={product.cartItemId}
            product={product}
            deleteProduct={deleteProduct}
            updateProduct={updateProduct}
          />
        );
      })}
      <Payment
        total={total}
        user={user}
        setCart={setCart}
        setIsOpen={setIsOpen}
      />
    </div>
  );
}

function Payment(props) {
  const { total, user, setCart, setIsOpen } = props;

  const handlePay = () => {
    placeOrder(user)
      .then(() => {
        const swalWithBootstrapButtons = Swal.mixin({
          customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
          },
          buttonsStyling: false
        })

        swalWithBootstrapButtons.fire({
          title: 'Are you sure?',
          text: "You are missing out on our other exciting deals!!",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonText: 'Place Order',
          cancelButtonText: 'Cancel',
          reverseButtons: false
        }).then((result) => {
          if (result.isConfirmed) {
            let timerInterval
            Swal.fire({
              title: 'Placing the Order',
              html: 'It will take a few moments.',
              timer: 5000,
              timerProgressBar: false,
              allowOutsideClick: false,
              allowEscapeKey: false,
              didOpen: () => {
                Swal.showLoading()
              },
              willClose: () => {
                clearInterval(timerInterval)
              }
            }).then((result) => {
              if (result.dismiss === Swal.DismissReason.timer) {
                console.log('I was closed by the timer')
              }
              swalWithBootstrapButtons.fire(
                'Order Placed!',
                'Your order has been placed.',
                'success',
                setCart((prev) => {
                  return { ...prev, cartItems: [] };
                })
              )
            })
          } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
          ) {
            swalWithBootstrapButtons.fire(
              'Cancelled',
              ':)',
              'error'
            )
          }
        })
        // setIsOpen(true);
      })
      .catch((err) => alert(err));
  };
  return (
    <div className={styles.payment}>
      <h3 className={styles.total}>Total = &#8377;{total.toLocaleString()}</h3>
      <button className={"btn btn-dark " + styles.pay} onClick={handlePay}>
        PROCEED TO PAY
      </button>
    </div>
  );
}
