import './navbar.css';
import React from 'react';
import { Link, NavLink, withRouter } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar">
      <Link to="/" className="navbar-left">GILDED ROSE</Link>
      <NavLink to="/additem" className="navbar-right" activeClassName="selected">ADD ITEM</NavLink>
    </nav>
  );
}

export default withRouter(Navbar);