#! /usr/bin/perl -w
use IO::Socket;

$socket = new IO::Socket::INET(
	PeerAddr => '127.0.0.1',
	PeerPort => 5000,
	Proto    => 'tcp',
) or die "Couldn't connect to Server\n";

while (1) {
	$socket->recv( $recv_msg, 1024 );
	print "$recv_msg";

	$send_acc = <STDIN>;
	chop($send_acc);
	$socket->send($send_acc);
	$socket->recv( $recv_acc_msg, 1024 );
	print "$recv_acc_msg";

	while ( $recv_acc_msg ne "Input pin: " ) {
		$send_acc = <STDIN>;
		chop($send_acc);
		$socket->send($send_acc);
		$socket->recv( $recv_acc_msg, 1024 );
		print "$recv_acc_msg";
	}

	$send_pin = <STDIN>;
	chop($send_pin);
	$socket->send($send_pin);
	$socket->recv( $recv_pin_msg, 1024 );
	print "$recv_pin_msg";

	while ( $recv_pin_msg ne "Welcome\n" ) {
		$send_pin = <STDIN>;
		chop($send_pin);
		$socket->send($send_pin);
		$socket->recv( $recv_pin_msg, 1024 );
		print "$recv_pin_msg";
	}

	close $socket;
	last;
}