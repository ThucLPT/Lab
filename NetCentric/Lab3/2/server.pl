#! /usr/bin/perl -w
use IO::Socket;

$|      = 1;
$socket = new IO::Socket::INET(
	LocalHost => '127.0.0.1',
	LocalPort => '2121',
	Proto     => 'tcp',
	Listen    => 5,
	Reuse     => 1
);
die "Coudn't open socket" unless $socket;
print "TCPServer Waiting for client on port 2121";

while (1) {
	$client_socket = "";
	$client_socket = $socket->accept();
	$peer_address  = $client_socket->peerhost();
	$peer_port     = $client_socket->peerport();
	print "\nI got a connection from ($peer_address, $peer_port)\n";

	while (1) {
		$client_socket->recv( $recv_data, 1024 );
		open( $fh, '<:encoding(UTF-8)', $recv_data )
		  or die "Could not open file '$recv_data' $!";
		while ( $row = <$fh> ) {
			chomp $row;
			print "$row\n";
			$client_socket->send($row);
		}
	}
	close $client_socket;
	last;
}