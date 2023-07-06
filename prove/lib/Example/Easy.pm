package Example::Easy;
use 5.008001;
use strict;
use warnings;
use utf8;

sub str_concat {
    my ($a, $b) = @_;
    sleep(2);

    return $a.$b;
}

1;