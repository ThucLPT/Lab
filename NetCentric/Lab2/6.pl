print "String: ";
$str = <>;
chomp $str;
for ( 1 .. 10 ) {
	print map { $_->[1] }
	  sort    { $a->[0] <=> $b->[0] }
	  map { [ rand(), $_ ] } split '', $str;
	print "\n";
}