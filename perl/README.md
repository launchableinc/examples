
# NAME

Example - Example Perl project for Launchable

# USAGE

## Install dependencies

Please install [`Carton`](https://metacpan.org/pod/Carton) before trying this project.

```sh
 $ cpanm Carton (or cpan Carton)
 $ carton install
```
## Run tests

```sh
$ carton exec prove -Ilib --harness TAP::Harness::JUnit -r t
xmlfile argument not supplied, defaulting to "junit_output.xml" at /Users/yabuki-ryosuke/src/github.com/launchableinc/examples/perl/local/lib/perl5/TAP/Harness/JUnit.pm line 125.
t/00_compile.t .... ok
t/easy/01_easy.t .. ok
t/math/01_math.t .. ok
All tests successful.
Files=3, Tests=6, 0.092551 wallclock secs ( 0.01 usr  0.00 sys +  0.06 cusr  0.01 csys =  0.08 CPU)
Result: PASS
```

# DESCRIPTION

Example is ...

# LICENSE

Copyright (C) Konboi.

This library is free software; you can redistribute it and/or modify
it under the same terms as Perl itself.

# AUTHOR

Konboi <ryosuke.yabuki@gmail.com>
