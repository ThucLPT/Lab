#! /usr/bin/perl -w
use IO::Socket;

$socket = new IO::Socket::INET(
	PeerAddr => '127.0.0.1',
	PeerPort => 5000,
	Proto    => 'tcp',
) or die "Couldn't connect to Server\n";

while (1) {
	$socket->recv( $recv_data, 1024 );
	print "$recv_data";
	if ( $recv_data eq "Correct\n" ) {
		close $socket;
		last;
	}
	$send_data = <STDIN>;
	chop($send_data);
	$socket->send($send_data);
}