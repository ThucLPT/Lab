#! /usr/bin/perl -w
use IO::Socket;

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
	$value = int( rand(101) );
	print "$value\n";
	$min = 0;
	$max = 100;

	while (1) {
		$send_data = "Enter a number in range $min - $max: ";
		$client_socket->send($send_data);
		$client_socket->recv( $received_data, 1024 );
		print "Client guessed $received_data\n";
		if ( $received_data > $value ) {
			$max = $received_data;
		}
		elsif ( $received_data < $value ) {
			$min = $received_data;
		}
		elsif ( $received_data eq $value ) {
			$client_socket->send("Correct\n");
			last;
		}
	}
	close $client_socket;
	last;
}