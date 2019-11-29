@arr = (
	"zero",   "one",      "two",      "three",   "four",    "five",
	"six",    "seven",    "eight",    "nine",    "ten",     "eleven",
	"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
	"eighteen"
);
print "Input x1: ";
$x1 = <>;
print "Input x2: ";
$x2 = <>;
$x3 = $x1 + $x2;
print "$arr[$x1] plus $arr[$x2] equals $arr[$x3] \n";