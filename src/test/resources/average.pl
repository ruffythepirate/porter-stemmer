my $sum = 0;
my $iterations = 0;
while(<>) {
  my $line = $_;
  $sum += $line;
  $iterations++;
}
print $sum/$iterations;
