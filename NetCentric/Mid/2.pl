open( $fh, "<:encoding(utf-8)", "data.txt" ) or die "Couldn't open file";
while ( $row = <$fh> ) {
	chomp $row;
	$id  = substr( $row, -14, 5 );
	$bod = substr( $row, -8,  8 );
	%hash = ( $id, $bod );
	print $_ . "=>" . $hash{$_} . "\n" for ( keys %hash );
}