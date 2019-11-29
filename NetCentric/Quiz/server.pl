#! /usr/bin/perl -w
use IO::Socket;
use List::Util 'shuffle';

$|      = 1;
$socket = new IO::Socket::INET(
	LocalHost => '127.0.0.1',
	LocalPort => '5000',
	Proto     => 'tcp',
	Listen    => 5,
	Reuse     => 1
);
die "Coudn't open socket" unless $socket;
print "TCPServer Waiting for client on port 5000\n";

while (1) {
	$client_socket = "";
	$client_socket = $socket->accept();
	$peer_address  = $client_socket->peerhost();
	$peer_port     = $client_socket->peerport();
	print "I got a connection from ($peer_address, $peer_port)\n";
	while (1) {
		$client_socket->recv( $recv_data, 1024 );
		if ( $recv_data eq 'SPIN' ) {
			print "RECEIVED: $recv_data\n";
			@arr       = ( shuffle 1 .. 45 )[ 0 .. 5 ];
			@sorted    = sort { $a <=> $b } @arr;
			$send_data = join( ' ', @sorted );
			$client_socket->send("$send_data");
			$unsort = join( ' ', @arr );
			print "$unsort\n";
		}
		elsif ( $recv_data eq 'QUIT' ) {
			print "RECEIVED: $recv_data\n";
			last;
		}
	}
	close $client_socket;
	last;
}