#! /usr/bin/perl -w
use IO::Socket;

$socket = new IO::Socket::INET(
	PeerAddr => '127.0.0.1',
	PeerPort => 5000,
	Proto    => 'tcp',
) or die "Couldn't connect to Server\n";

while (1) {
	print "SEND( TYPE SPIN or QUIT): ";
	$send_data = <STDIN>;
	chop($send_data);
	if ( $send_data eq 'SPIN' ) {
		$socket->send($send_data);
		$socket->recv( $recv_data, 1024 );
		print "RECEIVED: $recv_data\n";
	}
	elsif ( $send_data eq 'QUIT' ) {
		$socket->send($send_data);
		close $socket;
		last;
	}
}