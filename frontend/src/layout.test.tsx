import React from 'react';
import { render, screen } from '@testing-library/react';
import Layout from './layout';
import { Router } from "react-router-dom";
import { createMemoryHistory } from "history";


test('renders the children passed to it', () => {
  const history = createMemoryHistory();
  render(<Router history={history}><Layout><div>Items</div></Layout></Router>);
  const linkElement = screen.getByText(/Items/i);
  expect(linkElement).toBeInTheDocument();
});
