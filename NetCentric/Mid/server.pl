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
	$attemp = 3;

	while ( $attemp > 0 ) {
		$client_socket->send("Input account: ");
		$client_socket->recv( $recv_acc, 1024 );

		while ( $recv_acc ne "123456789" ) {
			$attemp--;
			$client_socket->send("$attemp left. Input account again: ");
			$client_socket->recv( $recv_acc, 1024 );
		}
		$client_socket->send("Input pin: ");
		$client_socket->recv( $recv_pin, 1024 );

		while ( $recv_pin ne "987654321" ) {
			$attemp--;
			$client_socket->send("$attemp left. Input pin again: ");
			$client_socket->recv( $recv_pin, 1024 );
		}
		$client_socket->send("Welcome\n");
		last;
	}
	close $client_socket;
	last;
}