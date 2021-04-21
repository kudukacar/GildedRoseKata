import React from 'react';
import { rest } from 'msw'
import { setupServer } from 'msw/node'
import { render, screen } from '@testing-library/react';
import FetchItems from './fetch_items';
import { ItemsProp } from './interfaces';

const server = setupServer(
  rest.get('/items', (req, res, ctx) => {
    return res(ctx.json([{ name: 'AgedBrie', sellIn: 10, quality: 10 }]))
  })
)

const ItemsIndexForTesting = (props: { itemsProp: ItemsProp }) => {
  const { itemsProp } = props;
  const { items } = itemsProp;

  return (
    <ul>
        {items.map((item, index) => <li key={index}>{item.name}</li>)}
    </ul>
  )
}

beforeAll(() => server.listen())
afterEach(() => server.resetHandlers())
afterAll(() => server.close())

test('loads and displays the fetched items', async () => {
  render(<FetchItems component={ItemsIndexForTesting}/>)

  await screen.findByText(/AgedBrie/i);
  expect(screen.getByText("AgedBrie")).toBeInTheDocument();
})