$str = "I am learning Perl";
@arr = split / /, $str;
foreach $i (@arr) {
	print "$i\n";
}