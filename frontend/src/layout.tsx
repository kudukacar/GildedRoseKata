import React, { ReactChild } from 'react';
import Navbar from './navbar';
import './layout.css';

const Layout = (props: { children: ReactChild; }) => {
  return (
    <>
      <Navbar/>
      <main className="body">
        {props.children}
      </main>
    </>
  )
}

export default Layout;