# rspec


## Recording test results

```shell
# Ruby version
$ rbenv version
2.7.1 (set by ~/examples/rspec/.ruby-version)

$ ruby -v
ruby 2.7.1p83 (2020-03-31 revision a0c7c23c9c) [x86_64-darwin21]


# Record test.
$ BUILD_NAME=test
$ launchable record build --name ${BUILD_NAME} --source ..
Launchable recorded 3 commits from repository ~/examples
Launchable recorded build test to workspace launchableinc/example with commits from 1 repository:

| Name   | Path   | HEAD Commit                              |
|--------|--------|------------------------------------------|
| ..     | ..     | 8b2e54601faa5e8b53c1bcad2527b77fb7ecd785 |


# Run test.
$ bundle exec rspec --format RspecJunitFormatter --out reports/rspec.xml


# Record test.
$ launchable record tests --build ${BUILD_NAME} rspec reports
Launchable recorded tests for build test (test session 5) to workspace launchableinc/example from 1 files:

|   Files found |   Tests found |   Tests passed |   Tests failed |   Total duration (min) |
|---------------|---------------|----------------|----------------|------------------------|
|             1 |            15 |             15 |              0 |                 0.0031 |

Visit https://app.launchableinc.com/organizations/launchableinc/workspaces/mothership/test-sessions/5 to view uploaded test results (or run `launchable inspect tests --test-session-id 5`)


$ cat reports/rspec.xml
<?xml version="1.0" encoding="UTF-8"?>
<testsuite name="rspec" tests="15" skipped="0" failures="0" errors="0" time="0.191767" timestamp="2022-10-28T09:05:18+09:00" hostname="ip-192-168-3-4.us-west-2.compute.internal">
<properties>
<property name="seed" value="43302"/>
</properties>
<testcase classname="spec.models.article_spec" name="Article validation only the body is required." file="./spec/models/article_spec.rb" time="0.004801"></testcase>
<testcase classname="spec.models.comment_spec" name="Comment validation is invalid without a name" file="./spec/models/comment_spec.rb" time="0.012822"></testcase>
<testcase classname="spec.models.comment_spec" name="Comment validation is invalid without a body" file="./spec/models/comment_spec.rb" time="0.002450"></testcase>
<testcase classname="spec.requests.articles_spec" name="Articles GET /index success request" file="./spec/requests/articles_spec.rb" time="0.064075"></testcase>
<testcase classname="spec.requests.articles_spec" name="Articles GET /index show titles" file="./spec/requests/articles_spec.rb" time="0.008547"></testcase>
<testcase classname="spec.requests.articles_spec" name="Articles GET /show success request" file="./spec/requests/articles_spec.rb" time="0.023398"></testcase>
<testcase classname="spec.requests.articles_spec" name="Articles GET /show show titles and body" file="./spec/requests/articles_spec.rb" time="0.008244"></testcase>
<testcase classname="spec.requests.articles_spec" name="Articles GET /show has comments show comments" file="./spec/requests/articles_spec.rb" time="0.010436"></testcase>
<testcase classname="spec.requests.articles_spec" name="Articles GET /new success request" file="./spec/requests/articles_spec.rb" time="0.006817"></testcase>
<testcase classname="spec.requests.articles_spec" name="Articles POST #create success request" file="./spec/requests/articles_spec.rb" time="0.008575"></testcase>
<testcase classname="spec.requests.articles_spec" name="Articles POST #create create new record" file="./spec/requests/articles_spec.rb" time="0.006766"></testcase>
<testcase classname="spec.requests.articles_spec" name="Articles POST #create redirect to created article page" file="./spec/requests/articles_spec.rb" time="0.005259"></testcase>
<testcase classname="spec.requests.comments_spec" name="comments POST #create success request" file="./spec/requests/comments_spec.rb" time="0.008917"></testcase>
<testcase classname="spec.requests.comments_spec" name="comments POST #create create new record" file="./spec/requests/comments_spec.rb" time="0.007860"></testcase>
<testcase classname="spec.requests.comments_spec" name="comments POST #create redirect to parent article page" file="./spec/requests/comments_spec.rb" time="0.007868"></testcase>
</testsuite>


$ launchable inspect tests --test-session-id 5
| Test Path                                                                                                                             |   Duration (sec) | Status   | Uploaded At                 |
|---------------------------------------------------------------------------------------------------------------------------------------|------------------|----------|-----------------------------|
| file=spec/requests/comments_spec.rb#class=spec.requests.comments_spec#testcase=comments POST #create redirect to parent article page  |           0.0079 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/requests/comments_spec.rb#class=spec.requests.comments_spec#testcase=comments POST #create create new record                |           0.0079 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/requests/comments_spec.rb#class=spec.requests.comments_spec#testcase=comments POST #create success request                  |           0.0089 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/requests/articles_spec.rb#class=spec.requests.articles_spec#testcase=Articles POST #create redirect to created article page |           0.0053 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/requests/articles_spec.rb#class=spec.requests.articles_spec#testcase=Articles POST #create create new record                |           0.0068 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/requests/articles_spec.rb#class=spec.requests.articles_spec#testcase=Articles POST #create success request                  |           0.0086 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/requests/articles_spec.rb#class=spec.requests.articles_spec#testcase=Articles GET /new success request                      |           0.0068 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/requests/articles_spec.rb#class=spec.requests.articles_spec#testcase=Articles GET /show has comments show comments          |           0.0104 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/requests/articles_spec.rb#class=spec.requests.articles_spec#testcase=Articles GET /show show titles and body                |           0.0082 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/requests/articles_spec.rb#class=spec.requests.articles_spec#testcase=Articles GET /show success request                     |           0.0234 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/requests/articles_spec.rb#class=spec.requests.articles_spec#testcase=Articles GET /index show titles                        |           0.0085 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/requests/articles_spec.rb#class=spec.requests.articles_spec#testcase=Articles GET /index success request                    |           0.0641 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/models/comment_spec.rb#class=spec.models.comment_spec#testcase=Comment validation is invalid without a body                 |           0.0024 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/models/comment_spec.rb#class=spec.models.comment_spec#testcase=Comment validation is invalid without a name                 |           0.0128 | SUCCESS  | 2022-10-28T00:05:24.072880Z |
| file=spec/models/article_spec.rb#class=spec.models.article_spec#testcase=Article validation only the body is required.                |           0.0048 | SUCCESS  | 2022-10-28T00:05:24.072880Z |

```

---

## Subsetting your test runs

```shell
$ BUILD_NAME=test
$ TARGET="50%"


# Request subset.
$ launchable subset --target ${TARGET} --build ${BUILD_NAME} rspec spec/**/*_spec.rb > subset.txt
Your model is currently in training
Launchable created subset 3 for build test (test session 5) in workspace launchableinc/example

|           |   Candidates |   Estimated duration (%) |   Estimated duration (min) |
|-----------|--------------|--------------------------|----------------------------|
| Subset    |            2 |                       50 |                3.33333e-05 |
| Remainder |            2 |                       50 |                3.33333e-05 |
|           |              |                          |                            |
| Total     |            4 |                      100 |                6.66667e-05 |

Run `launchable inspect subset --subset-id 3` to view full subset details


$ launchable inspect subset --subset-id 3
|   Order | Test Path                           | In Subset   |   Estimated duration (sec) |
|---------|-------------------------------------|-------------|----------------------------|
|       1 | file=spec/models/article_spec.rb    | ✔           |                      0.001 |
|       2 | file=spec/requests/comments_spec.rb | ✔           |                      0.001 |
|       3 | file=spec/models/comment_spec.rb    |             |                      0.001 |
|       4 | file=spec/requests/articles_spec.rb |             |                      0.001 |


$ cat subset.txt
spec/models/article_spec.rb
spec/requests/comments_spec.rb


# Run subset of test.
$ bundle exec rspec $(cat subset.txt) --format d --format RspecJunitFormatter --out reports/rspec.xml

Article
  validation
    only the body is required.

comments
  POST #create
    success request
    create new record
    redirect to parent article page

Finished in 0.06666 seconds (files took 1.21 seconds to load)
4 examples, 0 failures


$ cat reports/rspec.xml
<?xml version="1.0" encoding="UTF-8"?>
<testsuite name="rspec" tests="4" skipped="0" failures="0" errors="0" time="0.066655" timestamp="2022-10-28T09:10:42+09:00" hostname="ip-192-168-3-4.us-west-2.compute.internal">
<properties>
<property name="seed" value="39433"/>
</properties>
<testcase classname="spec.models.article_spec" name="Article validation only the body is required." file="./spec/models/article_spec.rb" time="0.004061"></testcase>
<testcase classname="spec.requests.comments_spec" name="comments POST #create success request" file="./spec/requests/comments_spec.rb" time="0.045420"></testcase>
<testcase classname="spec.requests.comments_spec" name="comments POST #create create new record" file="./spec/requests/comments_spec.rb" time="0.009201"></testcase>
<testcase classname="spec.requests.comments_spec" name="comments POST #create redirect to parent article page" file="./spec/requests/comments_spec.rb" time="0.006056"></testcase>
</testsuite>
```
