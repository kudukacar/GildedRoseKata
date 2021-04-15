import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';

test('renders Gilded Rose', () => {
  render(<App />);
  const linkElement = screen.getByText(/Gilded Rose/i);
  expect(linkElement).toBeInTheDocument();
});
