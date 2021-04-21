import React, { FormEventHandler } from 'react';
import { rest } from 'msw'
import { setupServer } from 'msw/node'
import { render, screen, fireEvent } from '@testing-library/react';
import CreateItem from './create_item';
import { CreateItemValues } from './interfaces';
import { Router } from "react-router-dom";
import { createMemoryHistory } from "history";

const server = setupServer(
  rest.post('/items', (req, res, ctx) => {
    return res(ctx.status(200))
  })
)

const TestingForm = (props: { 
  createItemValues: CreateItemValues,
  setCreateItemValues: Function,
  handleSubmit: FormEventHandler
}) => {
  const { handleSubmit } = props;
  return(
    <form onSubmit={handleSubmit}>
      <label>Name
      </label>
      <input aria-label="submit" type="submit" name="submit"/>
    </form>
  )
}

beforeAll(() => server.listen())
afterEach(() => server.resetHandlers())
afterAll(() => server.close())

test('displays the form passed to it', () => {
  render(<CreateItem component={TestingForm}/>)
  expect(screen.getByText(/Name/i)).toBeInTheDocument();
})

test('click on submit redirects the user to the homepage', async () => {
  const history = createMemoryHistory();
  const { getByLabelText } = render(
      <Router history={history}>
        <CreateItem component={TestingForm}/>
      </Router>
  );
  fireEvent.click(getByLabelText("submit"));
  expect(history.location.pathname).toBe("/");
})