# Background

Hi there!

You can use this example repository to get a sense of how [Launchable](https://www.launchableinc.com)’s predictive test selection works.

We’ve created a very basic application — just four files and four tests — and trained a machine learning model using full runs of the test suite.

We’ve set up a pre-merge pipeline that runs on every pull request, which is a very common pattern. However, instead of running the *entire* test suite, we’ll use Launchable to select the right tests to run for each code change, saving lots of time.

# Try it yourself

You can follow this flow entirely within GitHub; you just need a GitHub account:

1. First, fork this repository.
2. Then, navigate to `gradle/src/main/java/example` in your fork.
3. Click on `Add.java`.
4. Click the pencil icon to edit the file.
5. Change line 5 from`return x+y;` to `return x*y;`.
6. Use the buttons at the bottom of the page to commit this change directly to the `master` branch.
7. Then, navigate to the Pull requests section in your fork repository
8. Click `New pull request`. The subsequent Compare changes page should automatically select your fork as the source and this repository as the target.
9. Go ahead and create the pull request between your fork and the `launchableinc/examples repository`. This will kick off the PR test run with Launchable!
10. Click on the “Checks” in the pull request view.
11. Open up the `build` job and open the “Run tests with Gradle and Launchable” step.

Here, you can see how
* We installed Launchable CLI to easily communicate with Launchable.
* We sent the changed files in this build to Launchable (in this case, this is just `Add.java`).
* We asked for and received a 25% subset of tests for this change.
* We ran only that one test, saving time 💪

If you have long running tests that you want to shrink or run earlier in your pipeline, you can sign up for a free Launchable trial at [app.launchableinc.com/signup](https://app.launchableinc.com/signup)!
