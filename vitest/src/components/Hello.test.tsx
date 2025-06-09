// src/components/Hello.test.tsx
import { render, screen } from '@testing-library/react'
import '@testing-library/jest-dom'
import React from 'react'

function Hello() {
  return <h1>Hello, World!</h1>
}

test('renders hello message', () => {
  render(<Hello />)
  expect(screen.getByText('Hello, World!')).toBeInTheDocument()
})

