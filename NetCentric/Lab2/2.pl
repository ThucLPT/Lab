print "Length: ";
$len = <>;
while ( $len-- > 0 ) {
	$str = <>;
	push @arr, $str;
}
while (@arr) {
	$str = pop @arr;
	print join '', map substr( $str, -$_, 1 ), 1 .. length($str);
}
print "\n";