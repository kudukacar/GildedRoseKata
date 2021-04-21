import React from 'react';
import { render, screen } from '@testing-library/react';
import Layout from './layout';

test('renders the children passed to it', () => {
  render(<Layout><div>Items</div></Layout>);
  const linkElement = screen.getByText(/Items/i);
  expect(linkElement).toBeInTheDocument();
});
