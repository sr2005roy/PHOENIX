import React from 'react';
import { Link, Outlet } from 'react-router-dom';
import './AdminDashboard.css';

const AdminDashboard = () => {
  return (
    <div className="admin-container">
      <div className="admin-sidebar">
        <h1 className="admin-sidebar-title">Admin Dashboard</h1>
        <div className="admin-sidebar-links">
          <Link to="/admin/products" className="admin-sidebar-link">
            Products
          </Link>
          <Link to="/admin/orders" className="admin-sidebar-link">
            Orders
          </Link>
          <Link to="/admin/queries" className="admin-sidebar-link">
            Customer Queries
          </Link>
        </div>
      </div>
      <div className="admin-content">
        <Outlet />
      </div>
    </div>
  );
};

export default AdminDashboard;
