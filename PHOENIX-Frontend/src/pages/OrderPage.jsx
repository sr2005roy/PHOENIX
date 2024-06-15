import React from 'react';

const OrderPage = () => {
    const orders = [
        { id: 1, name: 'Product 1', price: 10.99 },
        { id: 2, name: 'Product 2', price: 19.99 },
        { id: 3, name: 'Product 3', price: 14.99 },
        { id: 4, name: 'Product 4', price: 9.99 },
    ];

    return (
        <div>
            <h2>Orders</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {orders.map((order) => (
                        <tr key={order.id}>
                            <td>{order.id}</td>
                            <td>{order.name}</td>
                            <td>{order.price}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default OrderPage;
