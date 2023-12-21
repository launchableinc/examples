
# NAME

Example - Example Perl prove project for Launchabl

# USAGE

## Install dependencies

Please install [`Carton`](https://metacpan.org/pod/Carton) before trying this project.

```sh
 $ cpanm Carton (or cpan Carton)
 $ carton install
```

## Run tests

```sh
$ export JUNIT_NAME_MANGLE=none 
$ carton exec prove -Ilib --harness TAP::Harness::JUnit -r t

xmlfile argument not supplied, defaulting to "junit_output.xml" at ~/examples/prove/local/lib/perl5/TAP/Harness/JUnit.pm line 125.
t/00_compile.t .... ok
t/easy/01_easy.t .. ok
t/math/01_math.t .. ok
All tests successful.
Files=3, Tests=6, 0.092551 wallclock secs ( 0.01 usr  0.00 sys +  0.06 cusr  0.01 csys =  0.08 CPU)
Result: PASS

$ BUILD_NAME=test
$ launchable record build --name ${BUILD_NAME} --source ..

Launchable recorded 1 commit from repository ~/examples
Launchable recorded build test3 to workspace launchableinc/mothership with commits from 1 repository:

| Name   | Path   | HEAD Commit                              |
|--------|--------|------------------------------------------|
| ..     | ..     | cbf2462dd6a0da7526ecb5d1dc997eb0a1339c59 |


$ launchable record tests --build ${BUILD_NAME} prove junit_output.xml

Launchable recorded tests for build test (test session 8) to workspace launchableinc/mothership from 1 files:

|   Files found |   Tests found |   Tests passed |   Tests failed |   Total duration (min) |
|---------------|---------------|----------------|----------------|------------------------|
|             1 |             6 |              6 |              0 |                   0.01 |

Visit https://app.launchableinc.com/organizations/launchableinc/workspaces/mothership/test-sessions/8 to view uploaded test results (or run `launchable inspect tests --test-session-id 12`)

$ launchable inspect tests --test-session-id 12

| Test Path                                     |   Duration (sec) | Status   | Uploaded At                 |
|-----------------------------------------------|------------------|----------|-----------------------------|
| file=t/easy/01_easy.t#testcase=a + b = ab     |             0.16 | SUCCESS  | 2023-02-20T06:59:24.813602Z |
| file=t/easy/01_easy.t#testcase=str_concat {   |             0.00 | SUCCESS  | 2023-02-20T06:59:24.813602Z |
| file=t/math/01_math.t#testcase=add(1, 2) == 3 |             0.07 | SUCCESS  | 2023-02-20T06:59:24.813602Z |
| file=t/math/01_math.t#testcase=add            |             0.00 | SUCCESS  | 2023-02-20T06:59:24.813602Z |
| file=t/math/01_math.t#testcase=double         |             0.00 | SUCCESS  | 2023-02-20T06:59:24.813602Z |
| file=t/00_compile.t#testcase=use Example;     |             0.09 | SUCCESS  | 2023-02-20T06:59:24.813602Z |
```

## Subsetting your test runs

```shell
$ BUILD_NAME=test
$ TARGET="50%"

$ find ./t -name '*.t' | launchable subset --target ${TARGET} --build ${BUILD_NAME} --rest rest.txt prove > subset.txt 

Your model is currently in training
Launchable created subset 6 for build test2 (test session 9) in workspace launchableinc/mothership

|           |   Candidates |   Estimated duration (%) |   Estimated duration (min) |
|-----------|--------------|--------------------------|----------------------------|
| Subset    |            1 |                    33.33 |                       0.00 |
| Remainder |            2 |                    66.67 |                       0.00 |
|           |              |                          |                            |
| Total     |            3 |                   100.00 |                       0.00 |

Run `launchable inspect subset --subset-id 6` to view full subset details

$ launchable inspect subset --subset-id 6

|   Order | Test Path             | In Subset   |   Estimated duration (sec) |
|---------|-----------------------|-------------|----------------------------|
|       1 | file=t/math/01_math.t | ✔           |                       0.00 |
|       2 | file=t/00_compile.t   |             |                       0.00 |
|       3 | file=t/easy/01_easy.t |             |                       0.00 |

$ carton exec prove -Ilib --harness TAP::Harness::JUnit -r $(cat subset.txt)

xmlfile argument not supplied, defaulting to "junit_output.xml" at ~/examples/prove/local/lib/perl5/TAP/Harness/JUnit.pm line 125.
t/00_compile.t .. ok   
All tests successful.
Files=1, Tests=1, 0.0880508 wallclock secs ( 0.01 usr  0.01 sys +  0.05 cusr  0.01 csys =  0.08 CPU)
Result: PASS
```

# DESCRIPTION

This is an example usage of Launchable to Perl prove test.

# LICENSE

Copyright (C) Konboi.

This library is free software; you can redistribute it and/or modify
it under the same terms as Perl prove itself.

# AUTHOR

Konboi <ryosuke.yabuki@gmail.com>
