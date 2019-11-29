#! /usr/bin/perl -w
use IO::Socket;

$socket = new IO::Socket::INET(
	PeerAddr => '127.0.0.1',
	PeerPort => 2121,
	Proto    => 'tcp',
) or die "Couldn't connect to Server\n";

while (1) {
	print "File: ";
	$send_data = <STDIN>;
	chop($send_data);
	$socket->send($send_data);
	while (1) {
		$socket->recv( $recv_data, 1024 );
		print "$recv_data\n";
	}
	close $socket;
	last;
}