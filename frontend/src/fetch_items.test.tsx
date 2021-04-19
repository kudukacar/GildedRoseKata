import React from 'react';
import { rest } from 'msw'
import { setupServer } from 'msw/node'
import { render, screen, waitFor } from '@testing-library/react';
import FetchItems from './fetch_items';

const server = setupServer(
  rest.get('/items', (req, res, ctx) => {
    return res(ctx.json([{ name: 'AgedBrie', sellIn: 10, quality: 10 }]))
  })
)

beforeAll(() => server.listen())
afterEach(() => server.resetHandlers())
afterAll(() => server.close())

test('loads and displays the fetched items', async () => {
  render(<FetchItems/>)

  await screen.findByText(/Aged Brie/i);
  expect(screen.getByText("Aged Brie")).toBeInTheDocument();
})