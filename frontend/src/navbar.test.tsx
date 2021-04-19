import React from 'react';
import { render, screen } from '@testing-library/react';
import Navbar from './navbar';

test('renders Gilded Rose navbar', () => {
  render(<Navbar />);
  const linkElement = screen.getByText(/Gilded Rose/i);
  expect(linkElement).toBeInTheDocument();
});
