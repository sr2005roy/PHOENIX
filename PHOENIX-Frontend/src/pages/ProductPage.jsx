import React, { useState } from 'react';
import './ProductPage.css';

const ProductsPage = () => {
    const [products, setProducts] = useState([
        { id: 1, name: 'Product 1', price: 10.99 },
        { id: 2, name: 'Product 2', price: 19.99 },
        { id: 3, name: 'Product 3', price: 14.99 },
        { id: 4, name: 'Product 4', price: 9.99 },
    ]);

    const [newProduct, setNewProduct] = useState({ id: '', name: '', price: '' });

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setNewProduct((prevProduct) => ({ ...prevProduct, [name]: value }));
    };

    const handleAddProduct = () => {
        setProducts((prevProducts) => [...prevProducts, newProduct]);
        setNewProduct({ id: '', name: '', price: '' });
    };

    return (
        <div className="products-container">
            <h2>Products Page</h2>
            <table className="products-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {products.map((product) => (
                        <tr key={product.id}>
                            <td>{product.id}</td>
                            <td>{product.name}</td>
                            <td>{product.price}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div className="add-product-form">
                <h3>Add New Product</h3>
                <form>
                    <input
                        type="text"
                        name="id"
                        placeholder="Product ID"
                        value={newProduct.id}
                        onChange={handleInputChange}
                    />
                    <input
                        type="text"
                        name="name"
                        placeholder="Product Name"
                        value={newProduct.name}
                        onChange={handleInputChange}
                    />
                    <input
                        type="text"
                        name="price"
                        placeholder="Product Price"
                        value={newProduct.price}
                        onChange={handleInputChange}
                    />
                    <button type="button" onClick={handleAddProduct}>
                        Add Product
                    </button>
                </form>
            </div>
        </div>
    );
};

export default ProductsPage;
