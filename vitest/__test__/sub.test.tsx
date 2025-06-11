test("sub - 1", () => {
  const sub = (a: number, b: number): number => a - b;

  expect(sub(3, 2)).toBe(1);
  expect(sub(0, 0)).toBe(0);
  expect(sub(-1, -1)).toBe(0);
});

test("sub - 2", () => {
  const sub = (a: number, b: number): number => a - b;
  expect(sub(-5, -3)).toBe(-2);
  expect(sub(100, 50)).toBe(5);
});
