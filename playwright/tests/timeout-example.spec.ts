import { test, expect } from "@playwright/test";

test("time-out", async ({ page }, testInfo) => {
  test.setTimeout(1);
  await page.goto("https://playwright.dev/");
  await expect(page).toHaveTitle(new RegExp("Playwright"));
});
