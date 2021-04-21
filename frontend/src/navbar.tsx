import './navbar.css';
import React from 'react';
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar">
      <Link to="/" className="navbar-left">GILDED ROSE</Link>
      <Link to="/additem">Add Item</Link>
    </nav>
  );
}

export default Navbar;