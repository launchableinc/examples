test("add", () => {
  const add = (a: number, b: number): number => a + b;

  expect(add(1, 2)).toBe(3);
  expect(add(-1, 1)).toBe(0);
  expect(add(0, 0)).toBe(0);
  expect(add(-5, -5)).toBe(-10);
  expect(add(100, 200)).toBe(300);
});
