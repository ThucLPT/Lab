open( $fh, "<:encoding(utf-8)", "listofstring.txt" )
  or die "Couldn't open file";
while ( $row = <$fh> ) {
	chomp $row;
	if ( exists $hash{$row} ) {
		$hash{$row}++;
	}
	else {
		$hash{$row} = 1;
	}
}
print $_. "=>" . $hash{$_} . "\n" for ( keys %hash );