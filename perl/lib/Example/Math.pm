package Example::Math;
use 5.008001;
use strict;
use warnings;
use utf8;

sub add {
  my ($a, $b) = @_;

  return $a + $b;
}

sub double {
  my $a = shift;

  return $a * 2;
}

1;