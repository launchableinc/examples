use strict;
use warnings;
use utf8;
use Test::More;

use Example::Easy;

is(Example::Easy::str_concat("a", "b"), "ab", "a + b = ab");

subtest 'str_concat' => sub {
    my ($a, $b, $c, $d) = ("a", "bb", "ccc", "dddd");

    is(Example::Easy::str_concat($a, $d), "adddd", "$a + $d");
    is(Example::Easy::str_concat($b, $c), "bbccc", "$b + $c");
};

done_testing;

