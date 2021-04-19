import React from 'react';
import { render, screen } from '@testing-library/react';
import ItemsIndex from './items_index';

test('renders loading message if there are no items', () => {
  render(<ItemsIndex itemsProp={{ items: [] }}/>);
  const linkElement = screen.getByText(/Loading/i);
  expect(linkElement).toBeInTheDocument();
});

test('renders the items if available', () => {
  render(<ItemsIndex itemsProp={{ items: [{ name: "AgedBrie", sellIn: 10, quality: 10 }] }}/>);
  const linkElement = screen.getByText(/Aged Brie/i);
  expect(linkElement).toBeInTheDocument();
})