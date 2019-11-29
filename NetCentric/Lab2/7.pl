print "Length:";
$len = <>;
while ( $len-- > 0 ) {
	$str = <stdin>;
	push @arr, $str;
}

sub remove_dup {
	%seen = ();
	@arr = grep { !$seen{$_}++ } @arr;
	print join ' ', @arr, "\n";
}

sub sort {
	@arr = sort { lc($a) cmp lc($b) } @arr;
	print join ' ', @arr, "\n";
}

sub index_of {
	my ($str) = @_;
	my ($index) = grep { $arr[$_] eq $str } ( 0 .. @arr - 1 );
	return $index;
}

sub replace {
	my ( $s1, $s2 ) = @_;
	$arr[ index_of($s1) ] = $s2;
	print join ' ', @arr, "\n";
}

sub remove {
	my ($index) = @_;
	splice( @arr, $index, 1 );
	print join ' ', @arr, "\n";
}

sub move {
	my ($str) = @_;
	unshift( @arr, splice( @arr, index_of($str), 1 ) );
	print join ' ', @arr, "\n";
}

sub p {
	my @a = @_;
	print @a;
}
p(@a);