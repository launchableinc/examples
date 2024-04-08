import { test, expect } from "@playwright/test";

test("retry", async ({ page }, testInfo) => {
  await page.goto("https://playwright.dev/");
  console.log("Retry count:", testInfo.retry);
  const want = testInfo.retry > 2 ? "Playwright" : "Playflight";
  await expect(page).toHaveTitle(new RegExp(want));
});

test.skip("skip this test", async ({ page }) => {
  console.log("please skip my test");
});
