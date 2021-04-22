import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import Navbar from './navbar';
import { Router } from "react-router-dom";
import { createMemoryHistory } from "history";

test('clicking on gilded rose redirects to home page', () => {
  const history = createMemoryHistory();
  const { getByText } = render(<Router history={history}><Navbar/></Router>);
  fireEvent.click(getByText("GILDED ROSE"));
  expect(history.location.pathname).toBe("/");
});


test('clicking on add item redirects to add item page', () => {
  const history = createMemoryHistory();
  const { getByText } = render(<Router history={history}><Navbar/></Router>);
  fireEvent.click(getByText("ADD ITEM"));
  expect(history.location.pathname).toBe("/additem");
});