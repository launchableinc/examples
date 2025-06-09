// src/components/Hello.test.tsx
import { render, screen } from "@testing-library/react";
import "@testing-library/jest-dom";

function Hello() {
  return <h1>Hello, World!</h1>;
}

test("renders hello message", () => {
  render(<Hello />);
  expect(screen.getByText("Hello, World!")).toBeInTheDocument();
});

test("error: renders invalid message", () => {
  render(<Hello />);
  expect(screen.getByText("Invalid!!")).toBeInTheDocument();
});
